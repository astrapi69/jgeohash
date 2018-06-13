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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.alpharogroup.jgeohash.model.FirstAndSecondRingRegion;
import de.alpharogroup.jgeohash.model.FirstRingRegion;
import lombok.experimental.UtilityClass;

/**
 * The class {@link GeoHashExtensions}. This class is based on http://en.wikipedia.org/wiki/Geohash.
 */
@UtilityClass
public final class GeoHashExtensions
{

	/**
	 * The Constant char map BASE_32.
	 */
	private final static char[] BASE_32 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z' };

	/** The Constant DECODE_MAP. */
	private final static Map<Character, Integer> DECODE_MAP = new HashMap<>();
	static
	{
		int counter = 0;
		for (final char c : BASE_32)
		{
			DECODE_MAP.put(c, counter++);
		}
	}

	/** The precision. */
	private static final int precision = 12;

	/** The bits. */
	private static final int[] bits = { 16, 8, 4, 2, 1 };

	/**
	 * Decode the given geohash into a latitude and longitude.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the double[]
	 */
	public static double[] decode(final String geohash)
	{
		if ((geohash == null) || geohash.isEmpty())
		{
			throw new IllegalArgumentException("Argument geohash should not be null.");
		}

		boolean even = true;
		double latitudeError = 90.0;
		double longitudeError = 180.0;
		double latitude;
		double longitude;
		final double[] latitudeInterval = { -90.0, 90.0 };
		final double[] longitudeInterval = { -180.0, 180.0 };
		for (int i = 0; i < geohash.length(); i++)
		{

			final int cd = DECODE_MAP.get(geohash.charAt(i));

			for (int j = 0; j < bits.length; j++)
			{
				final int mask = bits[j];
				if (even)
				{
					longitudeError /= 2;
					if ((cd & mask) != 0)
					{
						longitudeInterval[0] = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
					}
					else
					{
						longitudeInterval[1] = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
					}

				}
				else
				{
					latitudeError /= 2;

					if ((cd & mask) != 0)
					{
						latitudeInterval[0] = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
					}
					else
					{
						latitudeInterval[1] = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
					}
				}

				even = !even;
			}

		}
		latitude = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
		longitude = (longitudeInterval[0] + longitudeInterval[1]) / 2D;

		return new double[] { latitude, longitude, latitudeError, longitudeError };
	}

	/**
	 * Decodes the given geohash into a latitude and longitude.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the double[]
	 */
	public static double[] decodeAndRound(final String geohash)
	{
		final double[] ge = decode(geohash);
		double latitude = ge[0];
		double longitude = ge[1];
		final double latitudeError = ge[2];
		final double longitudeError = ge[3];

		final double latitudePrecision = Math.max(1, Math.round(-Math.log10(latitudeError))) - 1;
		final double longitudePrecision = Math.max(1, Math.round(-Math.log10(longitudeError))) - 1;

		latitude = getPrecision(latitude, latitudePrecision);
		longitude = getPrecision(longitude, longitudePrecision);

		return new double[] { latitude, longitude };
	}

	/**
	 * Encodes the given latitude and longitude into a geohash code.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 * @return The generated geohash from the given latitude and longitude.
	 */
	public static String encode(final double latitude, final double longitude)
	{
		final StringBuilder geohash = new StringBuilder();
		boolean even = true;
		int bit = 0;
		int ch = 0;

		final double[] latitudeInterval = { -90.0, 90.0 };
		final double[] longitudeInterval = { -180.0, 180.0 };

		while (geohash.length() < precision)
		{
			double mid = 0.0;
			if (even)
			{
				mid = (longitudeInterval[0] + longitudeInterval[1]) / 2D;
				if (longitude > mid)
				{
					ch |= bits[bit];
					longitudeInterval[0] = mid;
				}
				else
				{
					longitudeInterval[1] = mid;
				}

			}
			else
			{
				mid = (latitudeInterval[0] + latitudeInterval[1]) / 2D;
				if (latitude > mid)
				{
					ch |= bits[bit];
					latitudeInterval[0] = mid;
				}
				else
				{
					latitudeInterval[1] = mid;
				}
			}

			even = !even;

			if (bit < 4)
			{
				bit++;
			}
			else
			{
				geohash.append(BASE_32[ch]);
				bit = 0;
				ch = 0;
			}
		}

		return geohash.toString();
	}

	/**
	 * Gets the adjacent from the given direction. For instance if direction is 'top' then the top
	 * adjacent geohash code will be returned.
	 *
	 * @param geohash
	 *            the geohash
	 * @param direction
	 *            the direction
	 * @return the geohash code for the adjacent from the given direction.
	 */
	public static String getAdjacent(final String geohash, final String direction)
	{
		if ((geohash == null) || geohash.isEmpty())
		{
			throw new IllegalArgumentException("Argument geohash should not be null or empty.");
		}
		if ((direction == null) || direction.isEmpty())
		{
			throw new IllegalArgumentException("Argument direction should not be null or empty.");
		}
		final String lowerCaseGeohash = geohash.toLowerCase();
		final char lastChar = lowerCaseGeohash.charAt(lowerCaseGeohash.length() - 1);
		final int modulo = lowerCaseGeohash.length() % 2;
		final String type = modulo == 0 ? Adjacent.ODD : Adjacent.EVEN;
		String base = lowerCaseGeohash.substring(0, lowerCaseGeohash.length() - 1);
		final Map<String, String> borderDirection = Adjacent.Borders.borders.get(direction);
		final String borderDirectionType = borderDirection.get(type);
		final int indexOfLastChar = borderDirectionType.indexOf(lastChar);
		if ((indexOfLastChar != -1) && !base.isEmpty())
		{
			base = getAdjacent(base, direction);
		}
		final Map<String, String> neighborsDirection = Adjacent.Neighbors.neighbors.get(direction);
		final String neighborsDirectionType = neighborsDirection.get(type);
		final int i = neighborsDirectionType.indexOf(lastChar);
		final char r = BASE_32[i];
		return base + r;
	}

	/**
	 * Gets the adjacent from the given directions. For instance if directions is 'top' and 'feft'
	 * then the topleft adjacent geohash code will be returned.
	 *
	 * @param geohash
	 *            the geohash
	 * @param directions
	 *            the directions
	 * @return the geohash code for the adjacent from the given directions.
	 */
	public static String getAdjacent(final String geohash, final String... directions)
	{
		String geohashresult = geohash;
		for (final String direction : directions)
		{
			geohashresult = getAdjacent(geohashresult, direction);
		}
		return geohashresult;
	}

	/**
	 * Gets the all adjacent areas list.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the all adjacent areas list
	 */
	public static List<String> getAllAdjacentAreasList(final String geohash)
	{
		if ((geohash == null) || geohash.isEmpty())
		{
			throw new IllegalArgumentException("Argument geohash should not be null.");
		}

		final List<String> adjacentAreas = new ArrayList<>();
		final String top = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP);
		final String bottom = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM);
		final String right = GeoHashExtensions.getAdjacent(geohash, Adjacent.RIGHT);
		final String left = GeoHashExtensions.getAdjacent(geohash, Adjacent.LEFT);
		final String topleft = GeoHashExtensions.getAdjacent(left, Adjacent.TOP);
		final String topright = GeoHashExtensions.getAdjacent(right, Adjacent.TOP);
		final String bottomright = GeoHashExtensions.getAdjacent(right, Adjacent.BOTTOM);
		final String bottomleft = GeoHashExtensions.getAdjacent(left, Adjacent.BOTTOM);
		adjacentAreas.add(geohash);
		adjacentAreas.add(top);
		adjacentAreas.add(topright);
		adjacentAreas.add(right);
		adjacentAreas.add(bottomright);
		adjacentAreas.add(bottom);
		adjacentAreas.add(bottomleft);
		adjacentAreas.add(left);
		adjacentAreas.add(topleft);
		return adjacentAreas;
	}

	/**
	 * Gets the geohash cells around the given geohash cell. With other words it gets eight cells
	 * around the given geohash cell so the first ring inclusive the given geohash cell.
	 *
	 * @param geohash
	 *            the geohash
	 * @return all geohash cells around the given geohash cell.
	 */
	public static Map<String, String> getAllAdjacentAreasMap(final String geohash)
	{
		if ((geohash == null) || geohash.isEmpty())
		{
			throw new IllegalArgumentException("Argument geohash should not be null.");
		}

		final String top = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP);
		final String bottom = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM);
		final String right = GeoHashExtensions.getAdjacent(geohash, Adjacent.RIGHT);
		final String left = GeoHashExtensions.getAdjacent(geohash, Adjacent.LEFT);
		final String topleft = GeoHashExtensions.getAdjacent(left, Adjacent.TOP);
		final String topright = GeoHashExtensions.getAdjacent(right, Adjacent.TOP);
		final String bottomright = GeoHashExtensions.getAdjacent(right, Adjacent.BOTTOM);
		final String bottomleft = GeoHashExtensions.getAdjacent(left, Adjacent.BOTTOM);

		final Map<String, String> adjacentAreas = new LinkedHashMap<>();
		adjacentAreas.put(Adjacent.CENTER, geohash);
		adjacentAreas.put(Adjacent.TOP, top);
		adjacentAreas.put(Adjacent.BOTTOM, bottom);
		adjacentAreas.put(Adjacent.RIGHT, right);
		adjacentAreas.put(Adjacent.LEFT, left);
		adjacentAreas.put(Adjacent.TOP_LEFT, topleft);
		adjacentAreas.put(Adjacent.TOP_RIGHT, topright);
		adjacentAreas.put(Adjacent.BOTTOM_RIGHT, bottomright);
		adjacentAreas.put(Adjacent.BOTTOM_LEFT, bottomleft);

		return adjacentAreas;
	}

	/**
	 * Gets the geohash cells of the first and second ring region around the given geohash cell as a
	 * {@link FirstAndSecondRingRegion} object.
	 *
	 * @param geohash
	 *            the geohash cell.
	 * @return the {@link FirstAndSecondRingRegion} that encapsulates the cells of the first and
	 *         second ring region around the given geohash cell.
	 */
	public static FirstAndSecondRingRegion getFirstAndSecondRingRegion(final String geohash)
	{
		return new FirstAndSecondRingRegion(geohash);
	}

	/**
	 * Gets the geohash cells around the given geohash cell as a {@link FirstRingRegion} object.
	 *
	 * @param geohash
	 *            the geohash cell.
	 * @return the {@link FirstRingRegion} object calculated from the given geohash value.
	 */
	public static FirstRingRegion getFirstRingRegion(final String geohash)
	{
		return new FirstRingRegion(geohash);
	}

	/**
	 * Gets the latitude from the given geohash value.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the latitude
	 */
	public static double getLatitude(final String geohash)
	{
		return decodeAndRound(geohash)[0];
	}

	/**
	 * Gets the longitude from the given geohash value.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the longitude
	 */
	public static double getLongitude(final String geohash)
	{
		return decodeAndRound(geohash)[1];
	}

	/**
	 * Gets the precision.
	 *
	 * @param x
	 *            the x
	 * @param precision
	 *            the precision
	 * @return the precision
	 */
	private static double getPrecision(final double x, final double precision)
	{
		final double base = Math.pow(10, -precision);
		final double diff = x % base;
		return x - diff;
	}

	/**
	 * Gets the eight cells around the given geohash cell so the first ring inclusive the given
	 * geohash cell and cells from the second ring. The result is 24 cells plus the given geohash
	 * cell.
	 *
	 * @param geohash
	 *            the geohash
	 * @return the eight cells around the given geohash cell so the first ring inclusive the given
	 *         geohash cell and cells from the second ring.
	 */
	public static Map<String, String> getTwentyFiveAreasMap(final String geohash)
	{
		final Map<String, String> adjacentAreas = getAllAdjacentAreasMap(geohash);

		final String topTop = GeoHashExtensions.getAdjacent(adjacentAreas.get(Adjacent.TOP),
			Adjacent.TOP);
		final String topLeftTop = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.TOP_LEFT), Adjacent.TOP);
		final String topLeftTopLeft = GeoHashExtensions.getAdjacent(topLeftTop, Adjacent.LEFT);
		final String topLeftLeft = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.TOP_LEFT), Adjacent.LEFT);
		final String topRightTop = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.TOP_RIGHT), Adjacent.TOP);
		final String topRightTopRight = GeoHashExtensions.getAdjacent(topRightTop, Adjacent.RIGHT);
		final String topRightRight = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.TOP_RIGHT), Adjacent.RIGHT);
		final String rightRight = GeoHashExtensions.getAdjacent(adjacentAreas.get(Adjacent.RIGHT),
			Adjacent.RIGHT);
		final String bottomRightRight = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.BOTTOM_RIGHT), Adjacent.RIGHT);
		final String bottomRightBottom = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.BOTTOM_RIGHT), Adjacent.BOTTOM);
		final String bottomRightBottomRight = GeoHashExtensions.getAdjacent(bottomRightBottom,
			Adjacent.RIGHT);
		final String bottomBottom = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.BOTTOM), Adjacent.BOTTOM);
		final String bottomLeftBottom = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.BOTTOM_LEFT), Adjacent.BOTTOM);
		final String bottomLeftBottomLeft = GeoHashExtensions.getAdjacent(bottomLeftBottom,
			Adjacent.LEFT);
		final String bottomLeftLeft = GeoHashExtensions
			.getAdjacent(adjacentAreas.get(Adjacent.BOTTOM_LEFT), Adjacent.LEFT);
		final String leftLeft = GeoHashExtensions.getAdjacent(adjacentAreas.get(Adjacent.LEFT),
			Adjacent.LEFT);

		adjacentAreas.put(Adjacent.TOP_LEFT_TOP, topLeftTop);
		adjacentAreas.put(Adjacent.TOP_LEFT_TOP_LEFT, topLeftTopLeft);
		adjacentAreas.put(Adjacent.TOP_LEFT_LEFT, topLeftLeft);
		adjacentAreas.put(Adjacent.TOP_TOP, topTop);
		adjacentAreas.put(Adjacent.TOP_RIGHT_TOP, topRightTop);
		adjacentAreas.put(Adjacent.TOP_RIGHT_RIGHT, topRightRight);
		adjacentAreas.put(Adjacent.TOP_RIGHT_TOP_RIGHT, topRightTopRight);
		adjacentAreas.put(Adjacent.RIGHT_RIGHT, rightRight);
		adjacentAreas.put(Adjacent.BOTTOM_RIGHT_RIGHT, bottomRightRight);
		adjacentAreas.put(Adjacent.BOTTOM_RIGHT_BOTTOM, bottomRightBottom);
		adjacentAreas.put(Adjacent.BOTTOM_RIGHT_BOTTOM_RIGHT, bottomRightBottomRight);
		adjacentAreas.put(Adjacent.BOTTOM_BOTTOM, bottomBottom);
		adjacentAreas.put(Adjacent.BOTTOM_LEFT_BOTTOM, bottomLeftBottom);
		adjacentAreas.put(Adjacent.BOTTOM_LEFT_BOTTOM_LEFT, bottomLeftBottomLeft);
		adjacentAreas.put(Adjacent.BOTTOM_LEFT_LEFT, bottomLeftLeft);
		adjacentAreas.put(Adjacent.LEFT_LEFT, leftLeft);

		return adjacentAreas;
	}

}
