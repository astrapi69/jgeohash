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
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNotSame;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.evaluators.EqualsEvaluator;
import de.alpharogroup.evaluate.object.evaluators.HashcodeEvaluator;
import de.alpharogroup.evaluate.object.evaluators.ToStringEvaluator;
import de.alpharogroup.jgeohash.Point;
import de.alpharogroup.jgeohash.api.Position;

/**
 * The unit test class for the class {@link DistancePoint}.
 */
public class DistancePointTest
{

	/**
	 * Test method for {@link DistancePoint#compareTo(DistancePoint)}
	 */
	@Test
	public void testCompareTo()
	{
		boolean expected;
		int actual;
		Position point;
		Double distance;

		point = Point.builder().longitude(0.1d).latitude(20.0d).build();
		distance = 1000.0d;
		final DistancePoint distancePoint = DistancePoint.builder().distance(distance).point(point)
			.build();
		point = Point.builder().longitude(0.2d).latitude(3.5d).build();
		distance = 20.0d;
		DistancePoint anotherPoint = DistancePoint.builder().distance(distance).point(point)
			.build();

		actual = distancePoint.compareTo(anotherPoint);
		expected = 0 < actual;
		assertTrue(expected);
	}

	/**
	 * Test method for {@link DistancePoint} constructors
	 */
	@Test
	public final void testConstructors()
	{
		DistancePoint model = new DistancePoint(
			Point.builder().latitude(0.0d).longitude(0.0d).build(), Double.valueOf(1.0d));
		assertNotNull(model);
	}

	/**
	 * Test method for {@link DistancePoint#equals(Object)}
	 */
	@Test
	public void testEqualsObject()
	{
		Position point;
		Double distance;
		point = Point.builder().longitude(0.1d).latitude(20.0d).build();
		distance = 1000.0d;
		final DistancePoint expected = DistancePoint.builder().distance(distance).point(point)
			.build();

		point = Point.builder().longitude(0.2d).latitude(3.5d).build();
		distance = 20.0d;
		final DistancePoint actual = new DistancePoint(point, distance);

		assertNotSame(expected, actual);

		point = Point.builder().longitude(0.1d).latitude(20.0d).build();
		distance = 1000.0d;
		final DistancePoint distancePoint = new DistancePoint(point, distance);
		assertEquals(expected, distancePoint);
		assertTrue(
			EqualsEvaluator.evaluateReflexivityNonNullSymmetricAndConsistency(expected, actual));
		assertTrue(EqualsEvaluator.evaluateReflexivityNonNullSymmetricConsistencyAndTransitivity(
			expected, distancePoint, new DistancePoint(point, distance)));
	}

	/**
	 * Test method for {@link DistancePoint#hashCode()}
	 */
	@Test
	public void testHashcode()
	{
		boolean expected;
		boolean actual;
		Position point;
		Double distance;
		point = Point.builder().longitude(0.1d).latitude(20.0d).build();
		distance = 1000.0d;
		final DistancePoint distancePoint = DistancePoint.builder().distance(distance).point(point)
			.build();
		actual = HashcodeEvaluator.evaluateEquality(distancePoint,
			new DistancePoint(point, distance));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateConsistency(distancePoint);
		expected = true;
		assertEquals(expected, actual);

		expected = true;
		point = Point.builder().longitude(0.2d).latitude(3.5d).build();
		distance = 20.0d;
		DistancePoint stringBox = DistancePoint.builder().distance(distance).point(point).build();
		actual = HashcodeEvaluator.evaluateUnequality(distancePoint, stringBox);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link DistancePoint#toString()}
	 */
	@Test
	public void testToString()
	{
		boolean expected;
		boolean actual;
		Position point;
		Double distance;
		actual = ToStringEvaluator.evaluate(DistancePoint.class);
		expected = true;
		assertEquals(expected, actual);

		point = Point.builder().longitude(0.1d).latitude(20.0d).build();
		distance = 1000.0d;
		final DistancePoint distancePoint = DistancePoint.builder().distance(distance).point(point)
			.build();
		actual = ToStringEvaluator.evaluateConsistency(distancePoint);
		expected = true;
		assertEquals(expected, actual);
	}
}
