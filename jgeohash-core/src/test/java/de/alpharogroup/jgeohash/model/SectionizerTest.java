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

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

/**
 * The class {@link SectionizerTest}.
 */
public class SectionizerTest
{

	@Test
	public void testMerge()
	{
		Section expected;
		Section actual;
		Section foo;
		Section bar;
		Sectionizer sectionizer;
		sectionizer = Sectionizer.builder().build();

		// no left match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(13).end(21).build();
		expected = foo;
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// no right match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(47).end(57).build();
		expected = foo;
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// is between match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(13).end(65).build();
		expected = bar;
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// is left overlapping match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(13).end(35).build();
		expected = Section.builder().start(13).end(45).build();
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// is right overlapping match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(42).end(57).build();
		expected = Section.builder().start(23).end(57).build();
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// is to left match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(13).end(22).build();
		expected = Section.builder().start(13).end(45).build();
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

		// is to right match case...
		foo = Section.builder().start(23).end(45).build();
		bar = Section.builder().start(46).end(57).build();
		expected = Section.builder().start(23).end(57).build();
		actual = sectionizer.merge(foo, bar);
		assertEquals(expected, actual);

	}

}
