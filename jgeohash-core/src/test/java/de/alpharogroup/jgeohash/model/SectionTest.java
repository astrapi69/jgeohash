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

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link Section}
 */
public class SectionTest
{

	/**
	 * Test method for {@link Section#isBetween(Section)}.
	 */
	@Test
	public void testIsBetween()
	{
		boolean expected;
		boolean actual;
		Section section;
		Section other;

		section = Section.builder().start(23).end(45).build();
		other = Section.builder().start(22).end(44).build();

		actual = section.isBetween(other);
		expected = false;
		assertEquals(expected, actual);

		section = Section.builder().start(23).end(45).build();
		other = Section.builder().start(23).end(45).build();

		actual = section.isBetween(other);
		expected = true;
		assertEquals(expected, actual);

		section = Section.builder().start(23).end(45).build();
		other = Section.builder().start(24).end(44).build();

		actual = section.isBetween(other);
		expected = true;
		assertEquals(expected, actual);

		section = Section.builder().start(23).end(45).build();
		other = Section.builder().start(23).end(46).build();

		actual = section.isBetween(other);
		expected = false;
		assertEquals(expected, actual);

		section = Section.builder().start(23).end(45).build();
		other = Section.builder().start(24).end(46).build();

		actual = section.isBetween(other);
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link Section#isBetween(int, int, int, boolean, boolean)}.
	 */
	@Test
	public void testIsBetweenIntIntIntBooleanBoolean()
	{
		boolean expected;
		boolean actual;
		int min;
		int max;
		int index;
		final int primitiveOne = 1;
		boolean includeMin;
		boolean includeMax;
		min = 0;
		max = 10;
		// first test case
		index = min;
		includeMin = false;
		includeMax = false;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		for (index = min + primitiveOne; index < max; index++)
		{
			actual = Section.isBetween(min, max, index, includeMin, includeMax);
			expected = true;
			assertEquals(actual, expected);
		}
		index = max;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);

		// Now check negative cases
		index = min - primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		index = max + primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);

		// second test case
		index = min;
		includeMin = true;
		includeMax = true;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = true;
		assertEquals(actual, expected);
		for (index = min + primitiveOne; index < max; index++)
		{
			actual = Section.isBetween(min, max, index, includeMin, includeMax);
			expected = true;
			assertEquals(actual, expected);
		}
		index = max;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = true;
		assertEquals(actual, expected);
		// Now check negative cases
		index = min - primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		index = max + primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);

		// third test case
		index = min;
		includeMin = false;
		includeMax = true;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		for (index = min + primitiveOne; index < max; index++)
		{
			actual = Section.isBetween(min, max, index, includeMin, includeMax);
			expected = true;
			assertEquals(actual, expected);
		}
		index = max;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = true;
		assertEquals(actual, expected);
		// Now check negative cases
		index = min - primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		index = max + primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);

		// fourth test case
		index = min;
		includeMin = true;
		includeMax = false;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = true;
		assertEquals(actual, expected);
		for (index = min + primitiveOne; index < max; index++)
		{
			actual = Section.isBetween(min, max, index, includeMin, includeMax);
			expected = true;
			assertEquals(actual, expected);
		}
		index = max;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		// Now check negative cases
		index = min - primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
		index = max + primitiveOne;
		actual = Section.isBetween(min, max, index, includeMin, includeMax);
		expected = false;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link Section#equals(Object)} , {@link Section#hashCode()} and
	 * {@link Section#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringWithClass()
	{
		ContractVerifier.of(Section.class).verify();
	}

}
