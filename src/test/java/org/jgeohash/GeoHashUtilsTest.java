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
package org.jgeohash;

import org.jgeohash.model.FirstRingRegion;
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
		expected = "u1x0etq";
		actual = GeoHashUtils.getAdjacent(subGeohash, Adjacent.TOP,
				Adjacent.TOP);
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
		
		FirstRingRegion geoHashRegion = new FirstRingRegion("u");
		expected = "h";
		actual = geoHashRegion.getNorth();
		AssertJUnit.assertEquals(expected, actual);
		expected = "j";
		actual = geoHashRegion.getNorthEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "v";
		actual = geoHashRegion.getEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "t";
		actual = geoHashRegion.getSouthEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "s";
		actual = geoHashRegion.getSouth();
		AssertJUnit.assertEquals(expected, actual);
		expected = "e";
		actual = geoHashRegion.getSouthWest();
		AssertJUnit.assertEquals(expected, actual);
		expected = "g";
		actual = geoHashRegion.getWest();
		AssertJUnit.assertEquals(expected, actual);
		expected = "5";
		actual = geoHashRegion.getNorthWest();
		AssertJUnit.assertEquals(expected, actual);
		
		geoHashRegion = new FirstRingRegion("t");
		expected = "v";
		actual = geoHashRegion.getNorth();
		AssertJUnit.assertEquals(expected, actual);
		expected = "y";
		actual = geoHashRegion.getNorthEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "w";
		actual = geoHashRegion.getEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "q";
		actual = geoHashRegion.getSouthEast();
		AssertJUnit.assertEquals(expected, actual);
		expected = "m";
		actual = geoHashRegion.getSouth();
		AssertJUnit.assertEquals(expected, actual);
		expected = "k";
		actual = geoHashRegion.getSouthWest();
		AssertJUnit.assertEquals(expected, actual);
		expected = "s";
		actual = geoHashRegion.getWest();
		AssertJUnit.assertEquals(expected, actual);
		expected = "u";
		actual = geoHashRegion.getNorthWest();
		AssertJUnit.assertEquals(expected, actual);
				
	}

}
