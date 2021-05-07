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

import java.util.Comparator;

import de.alpharogroup.merge.api.GenericSummarizer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The class {@link Sectionizer} can merge {@link Section} objects.
 */
@Getter
@Setter
@Builder
public class Sectionizer extends GenericSummarizer<Section>
{

	/**
	 * Instantiates a new {@link Sectionizer} object
	 */
	public Sectionizer()
	{
		super();
	}

	/**
	 * Instantiates a new {@link Sectionizer} object with the given max iteration
	 *
	 * @param maxIteration the max iteration
	 */
	public Sectionizer(int maxIteration)
	{
		super(maxIteration);
	}

	@Override
	protected Comparator<Section> newComparator()
	{
		return new SectionComparator();
	}


}
