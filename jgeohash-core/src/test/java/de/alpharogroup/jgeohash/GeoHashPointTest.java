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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.verifier.ContractVerifier;

/**
 * The unit test class for the class {@link GeoHashPoint}
 */
public class GeoHashPointTest
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
		GeoHashPoint o1;
		GeoHashPoint o2;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		o1 = new GeoHashPoint(geohash);
		o2 = new GeoHashPoint(geohash);
		actual = o1.compareTo(o2);
		expected = actual == 0;
		assertTrue(expected);
	}

	/**
	 * Test method for {@link Point} constructors
	 */
	@Test
	public final void testConstructors()
	{
		GeoHashPoint model;
		model = new GeoHashPoint(Double.valueOf(53.5526394d), Double.valueOf(10.0067103d));
		assertNotNull(model);
		model = new GeoHashPoint(Float.valueOf(53.5526394f), Float.valueOf(10.0067103f));
		assertNotNull(model);
		model = new GeoHashPoint(53.5526394f, 10.0067103f);
		assertNotNull(model);
		model = new GeoHashPoint(
			Point.builder().latitude(53.5526394d).longitude(10.0067103d).build());
		assertNotNull(model);
	}

	/**
	 * Test method for {@link GeoHashPoint#equals(Object)} , {@link GeoHashPoint#hashCode()} and
	 * {@link GeoHashPoint#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringWithClass()
	{
		ContractVerifier.of(GeoHashPoint.class).verify();
	}

	/**
	 * Test method for {@link GeoHashPoint#getLat()}.
	 */
	@Test
	public void testGetLat()
	{
		BigDecimal actual;
		BigDecimal expected;
		GeoHashPoint model;
		model = new GeoHashPoint(Double.valueOf(53.5526394d), Double.valueOf(10.0067103d));
		actual = model.getLat();
		expected = BigDecimal.valueOf(Double.valueOf(53.5526394d));
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashPoint#getLng()}.
	 */
	@Test
	public void testGetLng()
	{
		BigDecimal actual;
		BigDecimal expected;
		GeoHashPoint model;
		model = new GeoHashPoint(Double.valueOf(53.5526394d), Double.valueOf(10.0067103d));
		actual = model.getLng();
		expected = BigDecimal.valueOf(Double.valueOf(10.0067103d));
		assertEquals(expected, actual);
	}

}
