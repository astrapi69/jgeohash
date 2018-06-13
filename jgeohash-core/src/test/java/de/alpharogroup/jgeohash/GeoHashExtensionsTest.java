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

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.meanbean.factories.ObjectCreationException;
import org.meanbean.test.BeanTestException;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.jgeohash.model.FirstAndSecondRingRegion;
import de.alpharogroup.jgeohash.model.FirstRingRegion;

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
	 * Test method for {@link GeoHashExtensions#decode(String)} with empty value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testDecodeWithEmptyValue()
	{
		GeoHashExtensions.decode("");
	}

	/**
	 * Test method for {@link GeoHashExtensions#decode(String)} with null value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testDecodeWithNullValue()
	{
		GeoHashExtensions.decode(null);
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
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String)} with direction empty
	 * value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAdjacentStringStringDirectionEmptyValue()
	{
		GeoHashExtensions.getAdjacent("u", "");
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String)} with direction null
	 * value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAdjacentStringStringDirectionNullValue()
	{
		GeoHashExtensions.getAdjacent("u", (String)null);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String)} with geohash empty
	 * value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAdjacentStringStringGeohashEmptyValue()
	{
		GeoHashExtensions.getAdjacent("", Adjacent.TOP);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getAdjacent(String, String)} with geohash null value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAdjacentStringStringGeohashNullValue()
	{
		GeoHashExtensions.getAdjacent(null, Adjacent.TOP);
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
	 * Test method for {@link GeoHashExtensions#decode(String)} with null value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAllAdjacentAreasListNullValue()
	{
		GeoHashExtensions.getAllAdjacentAreasList(null);
	}

	/**
	 * Test method for {@link GeoHashExtensions#decode(String)} with empty value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAllAdjacentAreasListWithEmptyValue()
	{
		GeoHashExtensions.getAllAdjacentAreasList("");
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

	/**
	 * Test method for {@link GeoHashExtensions#decode(String)} with null value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAllAdjacentAreasMapNullValue()
	{
		GeoHashExtensions.getAllAdjacentAreasMap(null);
	}

	/**
	 * Test method for {@link GeoHashExtensions#decode(String)} with empty value
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public final void testGetAllAdjacentAreasMapWithEmptyValue()
	{
		GeoHashExtensions.getAllAdjacentAreasMap("");
	}

	/**
	 * Test method for {@link GeoHashExtensions#getFirstAndSecondRingRegion(String)}.
	 */
	@Test
	public void testGetFirstAndSecondRingRegion()
	{
		FirstAndSecondRingRegion actual;
		FirstAndSecondRingRegion expected;
		String geohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		actual = GeoHashExtensions.getFirstAndSecondRingRegion(geohash);
		assertNotNull(actual);
		expected = new FirstAndSecondRingRegion(geohash);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getFirstRingRegion(String)}.
	 */
	@Test
	public void testGetFirstRingRegion()
	{
		FirstRingRegion actual;
		FirstRingRegion expected;
		String geohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		actual = GeoHashExtensions.getFirstRingRegion(geohash);
		assertNotNull(actual);
		expected = new FirstRingRegion(geohash);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getLatitude(String)}.
	 */
	@Test
	public void testGetLatitude()
	{
		double actual;
		double expected;
		String geohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		actual = GeoHashExtensions.getLatitude(geohash);
		expected = 53.552639;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getLongitude(String)}.
	 */
	@Test
	public void testGetLongitude()
	{
		double actual;
		double expected;
		String geohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);

		actual = GeoHashExtensions.getLongitude(geohash);
		expected = 10.006710;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link GeoHashExtensions#getTwentyFiveAreasMap(String)}.
	 */
	@Test
	public void testGetTwentyFiveAreasMap()
	{
		Map<String, String> actual;
		Map<String, String> expected;
		String geohash;

		geohash = GeoHashExtensions.encode(53.5526394, 10.0067103);
		actual = GeoHashExtensions.getTwentyFiveAreasMap(geohash);
		assertNotNull(actual);
		assertTrue(actual.size() == 25);
		expected = MapFactory.newLinkedHashMap(25);
		expected.put("center", "u1x0esywtr81");
		expected.put("top", "u1x0esywtr84");
		expected.put("bottom", "u1x0esywtr80");
		expected.put("right", "u1x0esywtr83");
		expected.put("left", "u1x0esywtpxc");
		expected.put("topleft", "u1x0esywtpxf");
		expected.put("topright", "u1x0esywtr86");
		expected.put("bottomright", "u1x0esywtr82");
		expected.put("bottomleft", "u1x0esywtpxb");
		expected.put("topleft_top", "u1x0esywtpxg");
		expected.put("topleft_top_left", "u1x0esywtpxe");
		expected.put("topleft_left", "u1x0esywtpxd");
		expected.put("top_top", "u1x0esywtr85");
		expected.put("topright_top", "u1x0esywtr87");
		expected.put("topright_right", "u1x0esywtr8d");
		expected.put("topright_top_right", "u1x0esywtr8e");
		expected.put("right_right", "u1x0esywtr89");
		expected.put("bottomright_right", "u1x0esywtr88");
		expected.put("bottomright_bottom", "u1x0esywtr2r");
		expected.put("bottomright_bottom_right", "u1x0esywtr2x");
		expected.put("bottom_bottom", "u1x0esywtr2p");
		expected.put("bottomleft_bottom", "u1x0esywtprz");
		expected.put("bottomleft_bottom_left", "u1x0esywtprx");
		expected.put("bottomleft_left", "u1x0esywtpx8");
		expected.put("left_left", "u1x0esywtpx9");
		for (Entry<String, String> entry : actual.entrySet())
		{
			assertEquals(expected.get(entry.getKey()), actual.get(entry.getKey()));
		}
	}

	/**
	 * Test method for {@link GeoHashExtensions}
	 */
	@Test(expectedExceptions = { BeanTestException.class, ObjectCreationException.class })
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(GeoHashExtensions.class);
	}
}
