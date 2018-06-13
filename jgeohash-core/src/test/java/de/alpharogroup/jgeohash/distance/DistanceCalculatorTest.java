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
package de.alpharogroup.jgeohash.distance;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Map;

import org.meanbean.factories.ObjectCreationException;
import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.jgeohash.Adjacent;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import de.alpharogroup.jgeohash.GeoHashPoint;
import de.alpharogroup.jgeohash.Point;
import de.alpharogroup.jgeohash.api.Position;

/**
 * The unit test class for the class {@link DistanceCalculator}.
 */
public class DistanceCalculatorTest
{

	/**
	 * Test method for
	 * {@link DistanceCalculator#distanceBetweenPoints(Position, Position, MeasuringUnit)}
	 */
	@Test(enabled = true)
	public void testDistanceBetweenPointsPositionPositionMeasuringUnit()
	{
		double actual;
		double expected;

		final String alterTeichwegGeohash = "u1x0v54rmjwej";
		final double[] coordinates = GeoHashExtensions.decodeAndRound(alterTeichwegGeohash);
		final Position alterTeichweg = new Point(coordinates[0], coordinates[1]);
		final Position ludwigsburg = new GeoHashPoint(48.889380, 9.190459);

		actual = DistanceCalculator.distanceBetweenPoints(ludwigsburg, alterTeichweg,
			MeasuringUnit.KILOMETER);
		expected = 525.875517661088d;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link DistanceCalculator#distanceBetweenPoints(String, String, MeasuringUnit)}
	 */
	@Test(enabled = true)
	public void testDistanceBetweenPointsStringStringMeasuringUnit()
	{
		double actual;
		double expected;

		final String alterTeichwegGeohash = "u1x0v54rmjwej";
		final String subGeohash = alterTeichwegGeohash.substring(0, 1);
		final Map<String, String> firstRingCells = GeoHashExtensions
			.getAllAdjacentAreasMap(subGeohash);
		final Position ludwigsburg = new GeoHashPoint(48.889380, 9.190459);
		final String ludwigsburgGeohash = ((GeoHashPoint)ludwigsburg).getGeohash();

		actual = DistanceCalculator.distanceBetweenPoints(ludwigsburgGeohash, alterTeichwegGeohash,
			MeasuringUnit.KILOMETER);
		expected = 525.875517737948d;
		assertEquals(expected, actual);

		actual = DistanceCalculator.distanceBetweenPoints(ludwigsburgGeohash, alterTeichwegGeohash,
			MeasuringUnit.METER);
		expected = 525875.517737948d;
		assertEquals(expected, actual);

		actual = DistanceCalculator.distanceBetweenPoints(firstRingCells.get(Adjacent.CENTER),
			firstRingCells.get(Adjacent.RIGHT), MeasuringUnit.KILOMETER);
		expected = 1872.667779425215d;
		assertEquals(expected, actual);

		actual = DistanceCalculator.distanceBetweenPoints(firstRingCells.get(Adjacent.CENTER),
			firstRingCells.get(Adjacent.BOTTOM), MeasuringUnit.KILOMETER);
		expected = 5003.530963199998d;
		assertEquals(expected, actual);

		actual = DistanceCalculator.distanceBetweenPoints(firstRingCells.get(Adjacent.CENTER),
			firstRingCells.get(Adjacent.RIGHT), MeasuringUnit.MILE);
		expected = 1010.4891804690958d;
		assertEquals(expected, actual);

		actual = DistanceCalculator.distanceBetweenPoints(firstRingCells.get(Adjacent.CENTER),
			firstRingCells.get(Adjacent.BOTTOM), MeasuringUnit.MILE);
		expected = 2699.899019999999d;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DistanceCalculator}
	 */
	@Test(expectedExceptions = { BeanTestException.class, ObjectCreationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DistanceCalculator.class);
	}

}
