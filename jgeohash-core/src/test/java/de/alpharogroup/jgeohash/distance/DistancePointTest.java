package de.alpharogroup.jgeohash.distance;

import static org.testng.AssertJUnit.assertNotNull;

import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.jgeohash.Point;

/**
 * The unit test class for the class {@link DistancePoint}.
 */
public class DistancePointTest {

	/**
	 * Test method for {@link DistancePoint} constructors
	 */
	@Test
	public final void testConstructors()
	{
		DistancePoint model = new DistancePoint(Point.builder().latitude(0.0d).longitude(0.0d).build(), Double.valueOf(1.0d));
		assertNotNull(model);
	}

	/**
	 * Test method for {@link DistancePoint}
	 */
	@Test(enabled = false)
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DistancePoint.class);
	}

}
