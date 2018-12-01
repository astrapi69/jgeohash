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

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.AbstractTestCase;
import de.alpharogroup.evaluate.object.evaluators.EqualsHashCodeAndToStringEvaluator;

/**
 * The unit test class for the class {@link FirstRingRegion}
 */
public class FirstRingRegionTest extends AbstractTestCase<String, String>
{

	/**
	 * Test method for {@link FirstRingRegion#clone()}
	 */
	@Test
	public void testClone()
	{
		FirstRingRegion actual;
		FirstRingRegion expected;
		expected = new FirstRingRegion("u1x0etp");
		actual = (FirstRingRegion)expected.clone();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#equals(Object)} , {@link FirstRingRegion#hashCode()}
	 * and {@link FirstRingRegion#toString()}
	 */
	@Test
	public void testEqualsHashcodeAndToString()
	{
		boolean expected;
		boolean actual;
		final FirstRingRegion first = new FirstRingRegion("u1x0etp");
		final FirstRingRegion second = new FirstRingRegion("u1x0etq");
		final FirstRingRegion third = new FirstRingRegion("u1x0etp");
		final FirstRingRegion fourth = new FirstRingRegion("u1x0etp");

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(first, second,
			third, fourth);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getCenter()}.
	 */
	@Test
	public void testGetCenter()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "u";
		actual = geoHashRegion.getCenter();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "t";
		actual = geoHashRegion.getCenter();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getEast()}.
	 */
	@Test
	public void testGetEast()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "v";
		actual = geoHashRegion.getEast();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "w";
		actual = geoHashRegion.getEast();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getNorth()}.
	 */
	@Test
	public void testGetNorth()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");
		expected = "h";
		actual = geoHashRegion.getNorth();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");
		expected = "v";
		actual = geoHashRegion.getNorth();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getNorthEast()}.
	 */
	@Test
	public void testGetNorthEast()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "j";
		actual = geoHashRegion.getNorthEast();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "y";
		actual = geoHashRegion.getNorthEast();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getNorthWest()}.
	 */
	@Test
	public void testGetNorthWest()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "5";
		actual = geoHashRegion.getNorthWest();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "u";
		actual = geoHashRegion.getNorthWest();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getSouth()}.
	 */
	@Test
	public void testGetSouth()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "s";
		actual = geoHashRegion.getSouth();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "m";
		actual = geoHashRegion.getSouth();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getSouthEast()}.
	 */
	@Test
	public void testGetSouthEast()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "t";
		actual = geoHashRegion.getSouthEast();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "q";
		actual = geoHashRegion.getSouthEast();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getSouthWest()}.
	 */
	@Test
	public void testGetSouthWest()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "e";
		actual = geoHashRegion.getSouthWest();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "k";
		actual = geoHashRegion.getSouthWest();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstRingRegion#getWest()}.
	 */
	@Test
	public void testGetWest()
	{
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");

		expected = "g";
		actual = geoHashRegion.getWest();
		assertEquals(expected, actual);

		geoHashRegion = new FirstRingRegion("t");

		expected = "s";
		actual = geoHashRegion.getWest();
		assertEquals(expected, actual);
	}

}
