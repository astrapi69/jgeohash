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
import java.util.List;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.BaseComparatorTestCase;
import de.alpharogroup.collections.list.ListFactory;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * The unit test class for the class {@link SectionComparator}
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SectionComparatorTest extends BaseComparatorTestCase<Section>
{

	Section first = Section.builder().start(10).end(12).build();
	Section fourth = Section.builder().start(0).end(2).build();
	Section second = Section.builder().start(8).end(13).build();
	Section third = Section.builder().start(17).end(19).build();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Section> newActualList()
	{
		List<Section> actual = ListFactory.newArrayList(first, second, third, fourth);
		return actual;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Comparator<Section> newComparator()
	{
		return new SectionComparator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Section> newExpectedSortedList()
	{
		List<Section> expected = ListFactory.newArrayList(third, first, second, fourth);
		return expected;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Section> newExpectedUnsortedList()
	{
		List<Section> expected = ListFactory.newArrayList(first, second, third, fourth);
		return expected;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO1Equal()
	{
		return Section.builder().start(0).end(2).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO1GreaterThan()
	{
		return Section.builder().start(0).end(2).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO1LessThan()
	{
		return Section.builder().start(1).end(2).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO2Equal()
	{
		return newO1Equal();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO2GreaterThan()
	{
		return Section.builder().start(1).end(2).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Section newO2LessThan()
	{
		return Section.builder().start(0).end(2).build();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void testCompare()
	{
		super.testCompare();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void testEqual()
	{
		super.testEqual();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void testGreaterThan()
	{
		super.testGreaterThan();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void testLessThan()
	{
		super.testLessThan();
	}

	/**
	 * Test method for {@link SectionComparator}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(SectionComparator.class);
	}

}
