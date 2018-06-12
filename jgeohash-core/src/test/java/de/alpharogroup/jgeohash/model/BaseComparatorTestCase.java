package de.alpharogroup.jgeohash.model;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import de.alpharogroup.AbstractTestCase;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * The abstract class {@link BaseComparatorTestCase} is for unit tests with {@link Comparator}.
 *
 * @author Asterios Raptis
 * @version 1.0
 * @param <T>
 *            the generic type of the objects to compare
 *            @deprecated use instead the same named class from test-objects.
 */
@Deprecated
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseComparatorTestCase<T> extends AbstractTestCase<Integer, Boolean>
{

	/** The comparator. */
	Comparator<T> comparator;

	/** The first comparison object. */
	T o1;

	/** The other object to compare. */
	T o2;

	/**
	 * Sets up method will be invoked before every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@Override
	@BeforeMethod
	public void setUp() throws Exception
	{
		comparator = newComparator();
	}

	/**
	 * Tear down method will be invoked after every unit test method
	 *
	 * @throws Exception
	 *             is thrown if an exception occurs
	 */
	@Override
	@AfterMethod
	public void tearDown() throws Exception
	{
		comparator = null;
		o1 = null;
		o2 = null;
	}

	/**
	 * Abstract factory callback method that have to be overwritten for create the specific
	 * comparator object
	 *
	 * @return the specific comparator
	 */
	protected abstract Comparator<T> newComparator();

	/**
	 * Test method for {@link Comparator#compare(Object, Object)}
	 */
	public void testCompare()
	{
		List<T> actual;
		List<T> expected;
		actual = newActualList();
		expected = newExpectedUnsortedList();
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
		// sort...
		Collections.sort(actual, comparator);
		expected = newExpectedSortedList();
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	/**
	 * Test scenario when comparison objects are equal.
	 */
	public void testEqual()
	{
		o1 = newO1Equal();
		o2 = newO2Equal();

		actual = comparator.compare(o1, o2);
		expected = actual == 0;
		assertTrue(expected);

		o1 = newO1Equal();
		o2 = o1;

		actual = comparator.compare(o1, o2);
		expected = actual == 0;
		assertTrue(expected);
	}

	/**
	 * Test scenario when a comparison object is greater than the other object to compare.
	 */
	public void testGreaterThan()
	{
		o1 = newO1GreaterThan();
		o2 = newO2GreaterThan();

		actual = comparator.compare(o1, o2);
		expected = actual > 0;
		assertTrue(expected);

		o1 = newO1GreaterThan();
		o2 = null;

		actual = comparator.compare(o1, o2);
		expected = actual > 0;
		assertTrue(expected);
	}

	/**
	 * Test scenario when a comparison object is less than the other object to compare.
	 */
	public void testLessThan()
	{
		o1 = newO1LessThan();
		o2 = newO2LessThan();

		actual = comparator.compare(o1, o2);
		expected = actual < 0;
		assertTrue(expected);

		o1 = null;
		o2 = newO2LessThan();

		actual = comparator.compare(o1, o2);
		expected = actual < 0;
		assertTrue(expected);
	}

	/**
	 * Abstract factory callback method that have to be overwritten for create the first comparison
	 * object in the scenario less than.
	 *
	 * @return the new created first comparison object
	 */
	protected abstract T newO1LessThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario less than.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO2LessThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the first comparison
	 * object in the scenario greater than.
	 *
	 * @return the new created first comparison object
	 */
	protected abstract T newO1GreaterThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario greater than.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO2GreaterThan();

	/**
	 * Abstract factory callback method that have to be overwritten for create the other object to
	 * compare in the scenario that the objects are equal.
	 *
	 * @return the new created object to compare
	 */
	protected abstract T newO1Equal();

	/**
	 * Factory callback method that can be overwritten for create the other object to compare in the
	 * scenario that the objects are equal.
	 *
	 * @return the new created object to compare
	 */
	protected T newO2Equal()
	{
		return newO1Equal();
	}

	/**
	 * Abstract factory callback method that have to be overwritten for create the {@link List} with
	 * objects to sort in the sort scenario.
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newActualList();

	/**
	 * Abstract factory callback method that have to be overwritten for create the expected {@link List} with
	 * objects to test the sort algorithm in the sort scenario.
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newExpectedSortedList();

	/**
	 * Abstract factory callback method that have to be overwritten for create the {@link List} with
	 * objects to sort in the sort scenario. <br>
	 * <br>
	 * Note:This list have to be equal with {@link BaseComparatorTestCase#newActualList()}
	 *
	 * @return the {@link List} with objects to test the sort algorithm
	 */
	protected abstract List<T> newExpectedUnsortedList();

}
