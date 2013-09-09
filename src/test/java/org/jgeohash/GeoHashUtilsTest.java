package org.jgeohash;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class GeoHashUtilsTest {

	@Test
	public void testGetAdjacentStringStringArray() {
		String expected;
		String actual;
		String geohash = GeoHashUtils.encode(53.5526394, 10.0067103);
		String subGeohash = geohash.substring(0, 7);
		expected = "u1x0esx";
        actual = GeoHashUtils.getAdjacent(subGeohash, Adjacent.TOP, Adjacent.LEFT);
        AssertJUnit.assertEquals(expected, actual);
	}

}
