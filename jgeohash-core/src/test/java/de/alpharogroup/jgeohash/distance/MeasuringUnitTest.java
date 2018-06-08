package de.alpharogroup.jgeohash.distance;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link MeasuringUnit}.
 */
public class MeasuringUnitTest
{


	/**
	 * Test method for {@link MeasuringUnit#KILOMETER}.
	 */
	@Test
	public void testGetKILOMETERFactor()
	{
		double expected;
		double actual;
		actual = MeasuringUnit.KILOMETER.getFactor();
		expected = MeasuringUnit.KILOMETER_FACTOR;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link MeasuringUnit#METER}.
	 */
	@Test
	public void testGetMETERFactor()
	{
		double expected;
		double actual;
		actual = MeasuringUnit.METER.getFactor();
		expected = MeasuringUnit.METER_FACTOR;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for {@link MeasuringUnit#MILE}.
	 */
	@Test
	public void testGetMILEFactor()
	{
		double expected;
		double actual;
		actual = MeasuringUnit.MILE.getFactor();
		expected = MeasuringUnit.MILE_FACTOR;
		assertEquals(actual, expected);
	}

}
