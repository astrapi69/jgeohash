package org.jgeohash;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GeoHashUtilsTest {

	@Test(enabled = true)
	public void testGetAdjacentStringStringArray() {
		String expected;
		String actual;
		String geohash = GeoHashUtils.encode(53.5526394, 10.0067103);
		String subGeohash = geohash.substring(0, 7);
		expected = "u1x0etp";
		actual = GeoHashUtils.getAdjacent(subGeohash, Adjacent.TOP,
				Adjacent.RIGHT);
		AssertJUnit.assertEquals(expected, actual);
                
                expected = "u1x0etj";
		actual = GeoHashUtils.getAdjacent(subGeohash, Adjacent.TOP,
				Adjacent.LEFT);
		AssertJUnit.assertEquals(expected, actual);
	}

	@Test(enabled = true)
	public void testGetAdjacent() {
		String expected;
		String actual;
		expected = "h";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.TOP);
		AssertJUnit.assertEquals(expected, actual);
                
		expected = "j";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.TOP, Adjacent.RIGHT);
		AssertJUnit.assertEquals(expected, actual);

		expected = "v";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.RIGHT);
		AssertJUnit.assertEquals(expected, actual);

		expected = "t";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.BOTTOM, Adjacent.RIGHT);
		AssertJUnit.assertEquals(expected, actual);

		expected = "s";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.BOTTOM);
		AssertJUnit.assertEquals(expected, actual);

		expected = "e";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.BOTTOM, Adjacent.LEFT);
		AssertJUnit.assertEquals(expected, actual);

		expected = "g";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.LEFT);
		AssertJUnit.assertEquals(expected, actual);

		expected = "5";
		actual = GeoHashUtils.getAdjacent("u", Adjacent.LEFT, Adjacent.TOP);
		AssertJUnit.assertEquals(expected, actual);
		
		expected = "dr";
		actual = GeoHashUtils.getAdjacent("dq", Adjacent.TOP);
		AssertJUnit.assertEquals(expected, actual);

		expected = "dw";
		actual = GeoHashUtils.getAdjacent("dq", Adjacent.RIGHT);
		AssertJUnit.assertEquals(expected, actual);	
				
	}

}
