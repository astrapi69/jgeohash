/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.jgeohash.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.alpharogroup.merge.api.Summarizer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link Sectionizer} can merge {@link Section} objects.
 */
@Getter
@Setter
@Builder
public class Sectionizer implements Summarizer<Section>
{

	/** The Constant value for the default max iteration. */
	public static final int DEFAULT_MAX_ITERATION = 9999;

	/**
	 * Removes duplicate entries in the given list mergedSections and sorts them with the
	 * {@link SectionComparator}.
	 *
	 * @param mergeSections
	 *            All merged sections that will be processed.
	 * @param toRemove
	 *            All sections that have to be removed from the list mergedSections
	 * @return the clean and sorted list.
	 */
	private static List<Section> clean(final List<Section> mergeSections,
		final List<Section> toRemove)
	{
		final Set<Section> set = new HashSet<>(mergeSections);
		set.removeAll(toRemove);
		final List<Section> mergedSections = new ArrayList<>(set);
		Collections.sort(mergedSections, new SectionComparator());
		return mergedSections;
	}

	/** The max iteration which the iteration will break in the while loop. */
	@Builder.Default
	private int maxIteration = DEFAULT_MAX_ITERATION;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Section> merge(final List<Section> sections)
	{
		final List<Section> toAdd = new ArrayList<>();
		final List<Section> toRemove = new ArrayList<>();
		Collections.sort(sections, new SectionComparator());
		List<Section> mergedSections = new ArrayList<>(sections);
		List<Section> lastIterated = new ArrayList<>(mergedSections);
		int initialSize = mergedSections.size();
		boolean mergable = true;
		int count = 0;
		while (mergable && count < maxIteration)
		{
			merge(mergedSections, toAdd, toRemove);
			mergedSections = clean(toAdd, toRemove);
			toAdd.clear();
			toRemove.clear();
			final int newSize = mergedSections.size();
			if (initialSize == newSize)
			{
				// compare lists if equal
				if (mergedSections.equals(lastIterated))
				{
					mergable = false;
					break;
				}
			}
			initialSize = newSize;
			lastIterated = new ArrayList<>(mergedSections);
			count++;
		}
		return mergedSections;
	}

	/**
	 * Iterates over the given list sourceSections and merge sections that can be merged. The result
	 * of the merged sections are saved in the given list mergeSections. All sections that have to
	 * be removed are saved in the given list toRemove.
	 *
	 * @param sourceSections
	 *            the source sections
	 * @param mergedSections
	 *            All merged sections are saved in this list
	 * @param toRemove
	 *            All sections that have to be removed are saved in this list
	 */
	private void merge(final List<Section> sourceSections, final List<Section> mergedSections,
		final List<Section> toRemove)
	{
		for (final Section clonedSection : sourceSections)
		{
			for (final Section section : sourceSections)
			{
				if (clonedSection.equals(section))
				{
					if (!mergedSections.contains(section))
					{
						mergedSections.add(section);
					}
					continue;
				}
				final Section mergeSection = merge(clonedSection, section);
				if (!clonedSection.equals(mergeSection))
				{
					if (!mergedSections.contains(mergeSection))
					{
						mergedSections.add(mergeSection);
					}
					if (!toRemove.contains(clonedSection) && !mergeSection.equals(clonedSection))
					{
						toRemove.add(clonedSection);
					}
					if (!toRemove.contains(section) && !mergeSection.equals(section))
					{
						toRemove.add(section);
					}
				}
				else
				{
					if (!mergedSections.contains(section))
					{
						mergedSections.add(section);
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Section merge(final Section object, final Section other)
	{
		return object.merge(other);
	}

}
