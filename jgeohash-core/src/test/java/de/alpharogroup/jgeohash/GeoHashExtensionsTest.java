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

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapFactory;

/**
 * The unit test class for the class {@link GeoHashExtensions}.
 */
public class GeoHashExtensionsTest
{

	/**
	 * Test method for {@link GeoHashExtensions#decode(String)}.
	 */
	@Test
	public void testDecode()
	{
		double[] actual;
		double[] expected;
		String geohash;
		expected = new double[2];

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		expected[0] = 53.55263943783939d;
		expected[1] = 10.006710458546877d;
		actual = GeoHashExtensions.decode(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);

		geohash = GeoHashExtensions.encode(30.0, -90.0);
		expected[0] = 29.999999972060323d;
		expected[1] = -90.00000016763806d;
		actual = GeoHashExtensions.decode(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);

		geohash = GeoHashExtensions.encode(51.4797, -0.0124);
		expected[0] = 51.47970006801188d;
		expected[1] = -0.01240001991391182d;
		actual = GeoHashExtensions.decode(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
	}

	/**
	 * Test method for {@link GeoHashExtensions#decodeAndRound(String)}.
	 */
	@Test
	public void testDecodeAndRound()
	{
		double[] actual;
		double[] expected;
		String geohash;
		expected = new double[2];

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		expected[0] = 53.552639d;
		expected[1] = 10.00671d;
		actual = GeoHashExtensions.decodeAndRound(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);

		geohash = GeoHashExtensions.encode(30.0, -90.0);
		expected[0] = 29.999999d;
		expected[1] = -90.0d;
		actual = GeoHashExtensions.decodeAndRound(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);

		geohash = GeoHashExtensions.encode(51.4797, -0.0124);
		expected[0] = 51.4797d;
		expected[1] = -0.0124d;
		actual = GeoHashExtensions.decodeAndRound(geohash);
		assertEquals(expected[0], actual[0]);
		assertEquals(expected[1], actual[1]);
	}

	/**
	 * Test method for {@link GeoHashExtensions#encode(double, double)}.
	 */
	@Test
	public void testEncode()
	{
		String expected;
		String actual;

		actual = GeoHashExtensions.encode(53.5526394, 10.0067103);
		expected = "u1x0esywtr81";
		assertEquals(expected, actual);

		actual = GeoHashExtensions.encode(30.0, -90.0);
		expected = "9vrfxvrfxvrf";
		assertEquals(expected, actual);

		actual = GeoHashExtensions.encode(51.4797, -0.0124);
		expected = "gcpuzewfzp9u";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String)}
	 */
	@Test(enabled = true)
	public void testGetAdjacentStringString()
	{
		String expected;
		String actual;
		String alterTeichwegGeohash;
		String geohash;
		String right;
		String left;

		alterTeichwegGeohash = "u1x0v54rmjwej";
		geohash = alterTeichwegGeohash;

		expected = "h";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.TOP);
		assertEquals(expected, actual);

		expected = "v";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.RIGHT);
		assertEquals(expected, actual);

		expected = "s";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.BOTTOM);
		assertEquals(expected, actual);

		expected = "g";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.LEFT);
		assertEquals(expected, actual);

		expected = "dr";
		actual = GeoHashExtensions.getAdjacent("dq", Adjacent.TOP);
		assertEquals(expected, actual);

		expected = "dw";
		actual = GeoHashExtensions.getAdjacent("dq", Adjacent.RIGHT);
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwem";
		actual = GeoHashExtensions.getAdjacent(geohash, "top");
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwdv";
		actual = GeoHashExtensions.getAdjacent(geohash, "bottom");
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwen";
		actual = GeoHashExtensions.getAdjacent(geohash, "right");
		right = actual;
		assertEquals(expected, actual);

		expected = "u1x0v54rmjweh";
		actual = GeoHashExtensions.getAdjacent(geohash, "left");
		left = actual;
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwek";
		actual = GeoHashExtensions.getAdjacent(left, "top");
		assertEquals(expected, actual);

		expected = "u1x0v54rmjweq";
		actual = GeoHashExtensions.getAdjacent(right, "top");
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwdy";
		actual = GeoHashExtensions.getAdjacent(right, "bottom");
		assertEquals(expected, actual);

		expected = "u1x0v54rmjwdu";
		actual = GeoHashExtensions.getAdjacent(left, "bottom");
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String...)}
	 */
	@Test(enabled = true)
	public void testGetAdjacentStringStringArray()
	{
		String expected;
		String actual;
		String geohash;
		String subGeohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		subGeohash = geohash.substring(0, 7);
		expected = "u1x0etp";
		actual = GeoHashExtensions.getAdjacent(subGeohash, Adjacent.TOP, Adjacent.RIGHT);
		assertEquals(expected, actual);

		expected = "u1x0etj";
		actual = GeoHashExtensions.getAdjacent(subGeohash, Adjacent.TOP, Adjacent.LEFT);
		assertEquals(expected, actual);
		expected = "u1x0etq";
		actual = GeoHashExtensions.getAdjacent(subGeohash, Adjacent.TOP, Adjacent.TOP);
		assertEquals(expected, actual);

		expected = "j";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.TOP, Adjacent.RIGHT);
		assertEquals(expected, actual);

		expected = "t";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.BOTTOM, Adjacent.RIGHT);
		assertEquals(expected, actual);

		expected = "e";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.BOTTOM, Adjacent.LEFT);
		assertEquals(expected, actual);

		expected = "5";
		actual = GeoHashExtensions.getAdjacent("u", Adjacent.LEFT, Adjacent.TOP);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAllAdjacentAreasList(String)}.
	 */
	@Test
	public void testGetAllAdjacentAreasList()
	{
		List<String> expected;
		List<String> actual;
		String geohash;
		String subGeohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		subGeohash = geohash.substring(0, 7);

		actual = GeoHashExtensions.getAllAdjacentAreasList(subGeohash);
		expected = ListFactory.newArrayList("u1x0esy", "u1x0etn", "u1x0etp", "u1x0esz", "u1x0esx",
			"u1x0esw", "u1x0est", "u1x0esv", "u1x0etj");
		for (int i = 0; i < actual.size(); i++)
		{
			assertEquals(expected.get(i), actual.get(i));
		}
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAllAdjacentAreasMap(String)}.
	 */
	@Test
	public void testGetAllAdjacentAreasMap()
	{
		Map<String, String> expected;
		Map<String, String> actual;
		String geohash;
		String subGeohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		subGeohash = geohash.substring(0, 7);
		actual = GeoHashExtensions.getAllAdjacentAreasMap(subGeohash);

		expected = MapFactory.newHashMap(9);
		expected.put("center", "u1x0esy");
		expected.put("top", "u1x0etn");
		expected.put("bottom", "u1x0esw");
		expected.put("right", "u1x0esz");
		expected.put("left", "u1x0esv");
		expected.put("topleft", "u1x0etj");
		expected.put("topright", "u1x0etp");
		expected.put("bottomright", "u1x0esx");
		expected.put("bottomleft", "u1x0est");
		for (Entry<String, String> entry : actual.entrySet())
		{
			assertEquals(expected.get(entry.getKey()), actual.get(entry.getKey()));
		}
	}

}
