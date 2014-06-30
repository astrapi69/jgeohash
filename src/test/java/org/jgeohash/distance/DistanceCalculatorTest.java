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
package org.jgeohash.distance;

import java.util.Map;

import org.jgeohash.Adjacent;
import org.jgeohash.GeoHashPoint;
import org.jgeohash.GeoHashUtils;
import org.jgeohash.Point;
import org.jgeohash.api.Position;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * The Class DistanceCalculatorTest.
 */
public class DistanceCalculatorTest {

	/**
	 * The Constant WIDTH_9_CELL represents the width from a cell from a geohash
	 * value with 9 characters.
	 **/
	public static final double WIDTH_9_CELL = 0.00477;

	/**
	 * The Constant HEIGHT_9_CELL represents the height from a cell from a
	 * geohash value with 9 characters.
	 **/
	public static final double HEIGHT_9_CELL = 0.00283;

	/**
	 * The Constant WIDTH_8_CELL represents the width from a cell from a geohash
	 * value with 8 characters.
	 **/
	public static final double WIDTH_8_CELL = 0.02509;

	/**
	 * The Constant HEIGHT_8_CELL represents the height from a cell from a
	 * geohash value with 8 characters.
	 **/
	public static final double HEIGHT_8_CELL = 0.01908;

	/**
	 * The Constant WIDTH_7_CELL represents the width from a cell from a geohash
	 * value with 7 characters.
	 **/
	public static final double WIDTH_7_CELL = 0.10039;

	/**
	 * The Constant HEIGHT_7_CELL represents the height from a cell from a
	 * geohash value with 7 characters.
	 **/
	public static final double HEIGHT_7_CELL = 0.15269;

	/**
	 * The Constant WIDTH_6_CELL represents the width from a cell from a geohash
	 * value with 6 characters.
	 **/
	public static final double WIDTH_6_CELL = 0.80315;

	/**
	 * The Constant HEIGHT_6_CELL represents the height from a cell from a
	 * geohash value with 6 characters.
	 **/
	public static final double HEIGHT_6_CELL = 0.61078;

	/**
	 * The Constant WIDTH_5_CELL represents the width from a cell from a geohash
	 * value with 5 characters.
	 **/
	public static final double WIDTH_5_CELL = 3.21280;

	/**
	 * The Constant HEIGHT_5_CELL represents the height from a cell from a
	 * geohash value with 5 characters.
	 **/
	public static final double HEIGHT_5_CELL = 4.88626;

	/**
	 * The Constant WIDTH_4_CELL represents the width from a cell from a geohash
	 * value with 4 characters.
	 **/
	public static final double WIDTH_4_CELL = 25.66850;

	/**
	 * The Constant HEIGHT_4_CELL represents the height from a cell from a
	 * geohash value with 4 characters.
	 **/
	public static final double HEIGHT_4_CELL = 19.54504;

	/**
	 * The Constant WIDTH_3_CELL represents the width from a cell from a geohash
	 * value with 3 characters.
	 **/
	public static final double WIDTH_3_CELL = 103.57409;

	/**
	 * The Constant HEIGHT_3_CELL represents the height from a cell from a
	 * geohash value with 3 characters.
	 **/
	public static final double HEIGHT_3_CELL = 156.36034;

	/**
	 * The Constant WIDTH_2_CELL represents the width from a cell from a geohash
	 * value with 2 characters.
	 **/
	public static final double WIDTH_2_CELL = 625.44137;

	/**
	 * The Constant HEIGHT_2_CELL represents the height from a cell from a
	 * geohash value with 2 characters.
	 **/
	public static final double HEIGHT_2_CELL = 744.37693;

	/**
	 * The Constant WIDTH_1_CELL represents the width from a cell from a geohash
	 * value with 1 characters.
	 **/
	public static final double WIDTH_1_CELL = 4604.31836;

	/**
	 * The Constant HEIGHT_1_CELL represents the height from a cell from a
	 * geohash value with 1 characters.
	 **/
	public static final double HEIGHT_1_CELL = 5003.53096;

	/**
	 * Test distance between points.
	 */
	@Test(enabled = true)
	public void testDistanceBetweenPoints() {
		String alterTeichwegGeohash = "u1x0v54rmjwej";
		String subGeohash = alterTeichwegGeohash.substring(0, 1);
		Map<String, String> firstRingCells = GeoHashUtils
				.getAllAdjacentAreasMap(subGeohash);
		double[] coordinates = GeoHashUtils
				.decodeAndRound(alterTeichwegGeohash);
		Position alterTeichweg = new Point(coordinates[0], coordinates[1]);
		Position ludwigsburg = new GeoHashPoint(48.889380, 9.190459);
		String ludwigsburgGeohash = ((GeoHashPoint) ludwigsburg).getGeohash();
		double distance2 = DistanceCalculator.distanceBetweenPoints(
				ludwigsburg, alterTeichweg, MeasuringUnit.KILOMETER);
		AssertJUnit.assertEquals(distance2, 525.875517661088);
		System.out.println("Distance2:" + distance2);

		double distance3 = DistanceCalculator.distanceBetweenPoints(
				ludwigsburgGeohash, alterTeichwegGeohash,
				MeasuringUnit.KILOMETER);
		AssertJUnit.assertEquals(distance3, 525.875517737948);
		System.out.println("Distance3:" + distance3);
		
		distance3 = DistanceCalculator.distanceBetweenPoints(
				ludwigsburgGeohash, alterTeichwegGeohash,
				MeasuringUnit.METER);
		AssertJUnit.assertEquals(distance3, 525875.517737948);
		System.out.println("Distance3 in meters:" + distance3);

		double distance4 = DistanceCalculator.distanceBetweenPoints(
				firstRingCells.get(Adjacent.CENTER),
				firstRingCells.get(Adjacent.RIGHT), MeasuringUnit.KILOMETER);
		// AssertJUnit.assertEquals(distance4, 25.668503170382518);
		System.out.println("Distance4 width:" + distance4);

		double distance5 = DistanceCalculator.distanceBetweenPoints(
				firstRingCells.get(Adjacent.CENTER),
				firstRingCells.get(Adjacent.BOTTOM), MeasuringUnit.KILOMETER);
		// AssertJUnit.assertEquals(distance5, 19.545042824959157);
		System.out.println("Distance5 height:" + distance5);

	}

}
