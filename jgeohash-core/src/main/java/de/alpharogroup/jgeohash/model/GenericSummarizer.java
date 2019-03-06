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

import de.alpharogroup.merge.api.Mergeable;
import de.alpharogroup.merge.api.Summarizer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * The class {@link GenericSummarizer} can merge generic items of type {@link T}
 */
@Getter
@Setter
public abstract class GenericSummarizer<T extends Mergeable> implements Summarizer<T>
{

	/** The Constant value for the default max iteration. */
	public static final int DEFAULT_MAX_ITERATION = 9999;

	/** The max iteration which the iteration will break in the while loop. */
	@Builder.Default
	int maxIteration = DEFAULT_MAX_ITERATION;

	public GenericSummarizer(int maxIteration) {
		this.maxIteration = maxIteration;
	}

	private <T> List<T> clean(final List<T> mergeItems,
		final List<T> toRemove)
	{
		final Set<T> set = new HashSet<>(mergeItems);
		set.removeAll(toRemove);
		return new ArrayList<>(set);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> merge(final List<T> items)
	{
		final List<T> toAdd = new ArrayList<>();
		final List<T> toRemove = new ArrayList<>();
		sort(items);
		List<T> mergedItems = new ArrayList<>(items);
		List<T> lastIterated = new ArrayList<>(mergedItems);
		int initialSize = mergedItems.size();
		boolean mergable = true;
		int count = 0;
		while (mergable && count < maxIteration)
		{
			merge(mergedItems, toAdd, toRemove);
			mergedItems = clean(toAdd, toRemove);
			sort(mergedItems);
			toAdd.clear();
			toRemove.clear();
			final int newSize = mergedItems.size();
			if (initialSize == newSize)
			{
				// compare lists if equal
				if (mergedItems.equals(lastIterated))
				{
					mergable = false;
					break;
				}
			}
			initialSize = newSize;
			lastIterated = new ArrayList<>(mergedItems);
			count++;
		}
		return mergedItems;
	}

	/**
	 * Iterates over the given list sourceItems and merge items that can be merged. The result
	 * of the merged items are saved in the given list mergeTs. All items that have to
	 * be removed are saved in the given list toRemove.
	 *
	 * @param sourceItems
	 *            the source items
	 * @param mergedItems
	 *            All merged items are saved in this list
	 * @param toRemove
	 *            All items that have to be removed are saved in this list
	 */
	private void merge(final List<T> sourceItems, final List<T> mergedItems,
		final List<T> toRemove)
	{
		for (final T clonedT : sourceItems)
		{
			for (final T section : sourceItems)
			{
				if (clonedT.equals(section))
				{
					if (!mergedItems.contains(section))
					{
						mergedItems.add(section);
					}
					continue;
				}
				final T mergeT = merge(clonedT, section);
				if (!clonedT.equals(mergeT))
				{
					if (!mergedItems.contains(mergeT))
					{
						mergedItems.add(mergeT);
					}
					if (!toRemove.contains(clonedT) && !mergeT.equals(clonedT))
					{
						toRemove.add(clonedT);
					}
					if (!toRemove.contains(section) && !mergeT.equals(section))
					{
						toRemove.add(section);
					}
				}
				else
				{
					if (!mergedItems.contains(section))
					{
						mergedItems.add(section);
					}
				}
			}
		}
	}

	protected void sort(List<T> list){
		Collections.sort(list, newComparator());
	}

	protected abstract Comparator<T> newComparator();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T merge(final T object, final T other)
	{
		return (T) object.merge(other);
	}

}
