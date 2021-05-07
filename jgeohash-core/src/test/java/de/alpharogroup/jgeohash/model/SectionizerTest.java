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

import java.util.List;

import org.testng.annotations.Test;

import de.alpharogroup.collections.list.ListFactory;

/**
 * The unit test class for the class {@link Sectionizer}
 */
public class SectionizerTest
{

	/**
	 * Test method for {@link Sectionizer#getMaxIteration()}.
	 */
	@Test
	public void testGetMaxIteration()
	{
		int actual;
		int expected;
		Sectionizer sectionizer;
		sectionizer = Sectionizer.builder().build();

		actual = sectionizer.getMaxIteration();
		expected = Sectionizer.DEFAULT_MAX_ITERATION;
		assertEquals(expected, actual);
	}


	/**
	 * Test method for {@link Sectionizer#merge(Section, Section)}
	 */
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

	/**
	 * Test method for {@link Sectionizer#merge(List)}.
	 */
	@Test
	public void testMergeListOfSection()
	{
		List<Section> expected;
		List<Section> actual;
		List<Section> sections;

		sections = ListFactory.newArrayList(Section.builder().start(23).end(45).build(),
			Section.builder().start(13).end(21).build(),
			Section.builder().start(46).end(57).build());
		Sectionizer sectionizer = new Sectionizer(10000);
		actual = sectionizer.merge(sections);
		expected = ListFactory.newArrayList(Section.builder().start(23).end(57).build(),
			Section.builder().start(13).end(21).build());
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
	}

}
