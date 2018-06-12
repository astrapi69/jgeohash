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
	 * Test distance between points.
	 */
	@Test(enabled = true)
	public void testDistanceBetweenPoints()
	{
		final String alterTeichwegGeohash = "u1x0v54rmjwej";
		final String subGeohash = alterTeichwegGeohash.substring(0, 1);
		final Map<String, String> firstRingCells = GeoHashExtensions
			.getAllAdjacentAreasMap(subGeohash);
		final double[] coordinates = GeoHashExtensions.decodeAndRound(alterTeichwegGeohash);
		final Position alterTeichweg = new Point(coordinates[0], coordinates[1]);
		final Position ludwigsburg = new GeoHashPoint(48.889380, 9.190459);
		final String ludwigsburgGeohash = ((GeoHashPoint)ludwigsburg).getGeohash();
		final double distance2 = DistanceCalculator.distanceBetweenPoints(ludwigsburg,
			alterTeichweg, MeasuringUnit.KILOMETER);
		assertEquals(distance2, 525.875517661088);
		System.out.println("Distance2:" + distance2);

		double distance3 = DistanceCalculator.distanceBetweenPoints(ludwigsburgGeohash,
			alterTeichwegGeohash, MeasuringUnit.KILOMETER);
		assertEquals(distance3, 525.875517737948);
		System.out.println("Distance3:" + distance3);

		distance3 = DistanceCalculator.distanceBetweenPoints(ludwigsburgGeohash,
			alterTeichwegGeohash, MeasuringUnit.METER);
		assertEquals(distance3, 525875.517737948);
		System.out.println("Distance3 in meters:" + distance3);

		final double distance4 = DistanceCalculator.distanceBetweenPoints(
			firstRingCells.get(Adjacent.CENTER), firstRingCells.get(Adjacent.RIGHT),
			MeasuringUnit.KILOMETER);
		 assertEquals(distance4, 1872.667779425215);
		System.out.println("Distance4 width:" + distance4);

		final double distance5 = DistanceCalculator.distanceBetweenPoints(
			firstRingCells.get(Adjacent.CENTER), firstRingCells.get(Adjacent.BOTTOM),
			MeasuringUnit.KILOMETER);
		 assertEquals(distance5, 5003.530963199998);
		System.out.println("Distance5 height:" + distance5);

		final double distance6 = DistanceCalculator.distanceBetweenPoints(
			firstRingCells.get(Adjacent.CENTER), firstRingCells.get(Adjacent.RIGHT),
			MeasuringUnit.MILE);
		 assertEquals(distance6, 1010.4891804690958);
		System.out.println("Distance6 width:" + distance6);

		final double distance7 = DistanceCalculator.distanceBetweenPoints(
			firstRingCells.get(Adjacent.CENTER), firstRingCells.get(Adjacent.BOTTOM),
			MeasuringUnit.MILE);
		 assertEquals(distance7, 2699.899019999999);
		System.out.println("Distance7 width:" + distance7);

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
