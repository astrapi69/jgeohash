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

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

import de.alpharogroup.jgeohash.GeoHashPoint;
import de.alpharogroup.jgeohash.api.Position;
import lombok.experimental.UtilityClass;

/**
 * The class {@link DistanceCalculator} provides methods for calculate the distance between two
 * geohash, position or coordinate values.
 */
@UtilityClass
public final class DistanceCalculator
{

	/**
	 * Returns the distance from the given coordinates values.
	 *
	 * @param startLatitude
	 *            the latitude from start point.
	 * @param startLongitude
	 *            the longitude from start point.
	 * @param endLatitude
	 *            the latitude from end point.
	 * @param endLongitude
	 *            the longitude from end point.
	 * @param unit
	 *            the measurement unit
	 * @return the distance between the given coordinates values.
	 */
	public static double distance(final double startLatitude, final double startLongitude,
		final double endLatitude, final double endLongitude, final MeasuringUnit unit)
	{
		final double theta = toRadians(startLongitude - endLongitude);
		final double latitudePoint1 = toRadians(startLatitude);
		final double latitudePoint2 = toRadians(endLatitude);
		double distance = sin(latitudePoint1) * sin(latitudePoint2)
			+ cos(latitudePoint1) * cos(latitudePoint2) * cos(theta);
		// 60 is the number of minutes in a degree
		// 1.1515 is the number of statute miles in a nautical mile
		// One nautical mile is the length of one minute of latitude at the equator.
		distance = toDegrees(acos(distance)) * 60 * 1.1515;
		switch (unit)
		{
			case MILE :
				distance = distance * unit.getFactor();
				break;
			case KILOMETER :
				distance = distance * unit.getFactor();
				break;
			case METER :
				distance = distance * unit.getFactor();
				break;
		}
		return distance;
	}

	/**
	 * Returns the distance between two points.
	 *
	 * @param start
	 *            the start position.
	 * @param end
	 *            the end position.
	 * @param unit
	 *            the measurement unit
	 * @return the distance between points
	 */
	public static double distanceBetweenPoints(final Position start, final Position end,
		final MeasuringUnit unit)
	{
		final double distance = distance(start.getLatitude(), start.getLongitude(),
			end.getLatitude(), end.getLongitude(), unit);
		return distance;
	}

	/**
	 * Returns the distance between two given geohash values.
	 *
	 * @param startGeohashValue
	 *            the geohash value from where to start the measurement.
	 * @param endGeohashValue
	 *            the geohash value where to end the measurement.
	 * @param unit
	 *            the measurement unit
	 * @return the distance between the given geohash values.
	 */
	public static double distanceBetweenPoints(final String startGeohashValue,
		final String endGeohashValue, final MeasuringUnit unit)
	{
		return distanceBetweenPoints(new GeoHashPoint(startGeohashValue),
			new GeoHashPoint(endGeohashValue), unit);
	}

}
