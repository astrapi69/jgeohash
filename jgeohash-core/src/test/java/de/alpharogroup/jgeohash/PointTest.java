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
package de.alpharogroup.jgeohash;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link Point}.
 */
public class PointTest
{

	/**
	 * Test method for {@link Point#compareTo(Point)}.
	 */
	@Test
	public void testCompareTo()
	{
		/** For use of the expected result. */
		boolean expected;
		/** For use of the result of the comparison. */
		int actual;
		String geohash;
		Point o1;
		Point o2;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		o1 = new GeoHashPoint(geohash);
		o2 = new GeoHashPoint(geohash);
		actual = o1.compareTo(o2);
		expected = actual == 0;
		assertTrue(expected);
		actual = o1.compareTo(o1);
		expected = actual == 0;
		assertTrue(expected);

		geohash = GeoHashExtensions.encode(30.0, -90.0);
		o2 = new GeoHashPoint(geohash);
		actual = o1.compareTo(o2);
		expected = 0 < actual;
		assertTrue(expected);

		actual = o2.compareTo(o1);
		expected = actual < 0;
		assertTrue(expected);
	}

	/**
	 * Test method for {@link Point} constructors and builders
	 */
	@Test
	public final void testConstructors()
	{
		Point model = new Point(53.5526394, 10.0067103);
		assertNotNull(model);
		model = Point.builder().build();
		assertNotNull(model);
	}

	/**
	 * Test method for {@link Point} constructors and builders with an unappropriated latitude
	 * number.
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testConstructorsWithUnappropriatedLatitudeNumber()
	{
		new Point(153.5526394, 10.0067103);
	}

	/**
	 * Test method for {@link Point} constructors and builders with an unappropriated longitude
	 * number.
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testConstructorsWithUnappropriatedLongitudeNumber()
	{
		new Point(53.5526394, 190.0067103);
	}

	/**
	 * Test method for {@link Point#equals(Object)} , {@link Point#hashCode()} and
	 * {@link Point#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringWithClass()
	{
		ContractVerifier.of(Point.class).verify();
	}

	/**
	 * Test method for {@link Point#setLatitude(double)}.
	 */
	@Test
	public void testSetLatitude()
	{
		double actual;
		double expected;
		Point o1;
		o1 = new GeoHashPoint(GeoHashExtensions.encode(53.5526394, 10.0067103));
		o1.setLatitude(52.0d);
		actual = o1.getLatitude();
		expected = 52.0d;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link Point#setLatitude(double)} with an unappropriated latitude number.
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSetLatitudeUnappropriateLatitudeNumber()
	{
		Point o1 = new GeoHashPoint(GeoHashExtensions.encode(53.5526394, 10.0067103));
		o1.setLatitude(100.0d);
	}

	/**
	 * Test method for {@link Point#setLongitude(double)}.
	 */
	@Test
	public void testSetLongitude()
	{
		double actual;
		double expected;
		String geohash;
		Point o1;
		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		o1 = new GeoHashPoint(geohash);
		o1.setLongitude(9.8d);
		actual = o1.getLongitude();
		expected = 9.8d;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link Point#setLongitude(double)} with an unappropriated longitude number.
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testSetLongitudeWithUnappropriatedNumber()
	{
		String geohash;
		Point o1;
		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		o1 = new GeoHashPoint(geohash);
		o1.setLongitude(190.0d);
	}

}
