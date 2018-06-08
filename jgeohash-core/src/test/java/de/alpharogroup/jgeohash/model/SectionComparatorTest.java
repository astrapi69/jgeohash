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

import static org.testng.Assert.assertTrue;

import java.util.Comparator;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link SectionComparator}
 */
public class SectionComparatorTest
{

	/** The comparator. */
	Comparator<Section> comparator;

	/** For use of the expected result. */
	boolean expected;

	/** For use of the result of the comparator. */
	int actual;

	/**
	 * Test method for {@link SectionComparator#compare(Section, Section)}
	 */
	@Test
	public void testCompare()
	{
		Section o1;
		Section o2;
		comparator = new SectionComparator();

		o1 = Section.builder().start(0).end(2).build();
		o2 = Section.builder().start(0).end(2).build();

		actual = comparator.compare(o1, o2);
		expected = actual == 0;
		assertTrue(expected);

		o1 = Section.builder().start(0).end(2).build();
		o2 = Section.builder().start(1).end(2).build();

		actual = comparator.compare(o1, o2);
		expected = actual > 0;
		assertTrue(expected);

	}
}
