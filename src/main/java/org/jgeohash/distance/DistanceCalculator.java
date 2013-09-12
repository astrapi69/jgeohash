package org.jgeohash.distance;

import org.jgeohash.GeoHashPoint;
import org.jgeohash.api.Position;

/**
 * The Class DistanceCalculator provides methods for calculate the distance between two positions.
 */
public class DistanceCalculator {
	
	/**
	 * Returns the distance between two points.
	 * 
	 * @param point1
	 *            the first position.
	 * @param point2
	 *            the second position.
	 * @param unit
	 *            the measurement unit
	 * @return the distance between points
	 */
	public static double distanceBetweenPoints(final Position point1,
			final Position point2, MeasuringUnit unit) {
		double theta = Math.toRadians(point1.getLongitude() - point2.getLongitude());		
		double latitudePoint1=Math.toRadians(point1.getLatitude());
		double latitudePoint2=Math.toRadians(point2.getLatitude());		
		double distance = Math.sin(latitudePoint1) * Math.sin(latitudePoint2) + Math.cos(latitudePoint1) * Math.cos(latitudePoint2)*Math.cos(theta);
		// 60 is the number of minutes in a degree
		// 1.1515 is the number of statute miles in a nautical mile
		// One nautical mile is the length of one minute of latitude at the equator.
		distance = Math.toDegrees(Math.acos(distance)) * 60 * 1.1515;		
		switch (unit) {
		case MILE:
			distance = distance * unit.getFactor();
			break;
		case KILOMETER:
			distance = distance * unit.getFactor();
			break;
		default:
			distance = distance * MeasuringUnit.KILOMETER.getFactor();
			break;
		}
		return distance;
	}
	

	
	/**
	 * Returns the distance between two given geohash points.
	 * 
	 * @param point1
	 *            the first geohash value.
	 * @param point2
	 *            the second geohash value.
	 * @param unit
	 *            the measurement unit
	 * @return the distance between points
	 */
	public static double distanceBetweenPoints(final String point1,
			final String point2, MeasuringUnit unit) {
		return distanceBetweenPoints(new GeoHashPoint(point1), new GeoHashPoint(point2), unit);
	}

}
