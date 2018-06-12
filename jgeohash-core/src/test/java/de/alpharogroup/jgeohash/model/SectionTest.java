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

import de.alpharogroup.evaluate.object.SilentEqualsHashCodeAndToStringEvaluator;

/**
 * The unit test class for the class {@link Section}
 */
public class SectionTest
{

	/**
	 * Test method for {@link Section#equals(Object)} , {@link Section#hashCode()} and
	 * {@link Section#toString()}
	 */
	@Test
	public void testEqualsHashcodeAndToStringWithClassSilently()
	{
		boolean expected;
		boolean actual;
		actual = SilentEqualsHashCodeAndToStringEvaluator
			.evaluateEqualsHashcodeAndToStringQuietly(Section.class);
		expected = true;
		assertEquals(expected, actual);
	}

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

}
