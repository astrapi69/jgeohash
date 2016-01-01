package de.alpharogroup.jgeohash.geoip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import de.alpharogroup.jgeohash.GeoHashPoint;
import de.alpharogroup.jgeohash.api.Position;
import de.alpharogroup.jgeohash.distance.DistanceCalculator;
import de.alpharogroup.jgeohash.distance.DistancePoint;
import de.alpharogroup.jgeohash.distance.MeasuringUnit;

/**
 * The class {@link LocationExtensions} is for location specific data.
 */
public class LocationExtensions
{

	/**
	 * Sort the given list by distance from the given start position and returns a list of
	 * {@link DistancePoint} objects.
	 *
	 * @param startPoint
	 *            the start point
	 * @param geohashes
	 *            the geohashes
	 * @param unit
	 *            the unit
	 * @return the distance points
	 */
	public static List<DistancePoint> getDistancePoints(final Position startPoint,
		final List<Position> geohashes, final MeasuringUnit unit)
	{
		final List<DistancePoint> distancePoints = new ArrayList<>();
		for (final Position geoHashPoint : geohashes)
		{
			final DistancePoint distancePoint = new DistancePoint(geoHashPoint,
				DistanceCalculator.distanceBetweenPoints(startPoint, geoHashPoint, unit));
			distancePoints.add(distancePoint);
		}
		return distancePoints;
	}

	/**
	 * Gets the geohash from the given ip address or return an empty String if nothing is found.
	 *
	 * @param lookupService
	 *            the lookup service
	 * @param ipAddress
	 *            the ip address
	 * @return the geohash from ip address or an empty String if nothing is found.
	 */
	public static String getGeohashFromIpAddress(final LookupService lookupService,
		final String ipAddress)
	{
		final GeoHashPoint geoHashPoint = getGeoHashPoint(lookupService, ipAddress);
		if (geoHashPoint != null)
		{
			return geoHashPoint.getGeohash();
		}
		return "";
	}

	/**
	 * Gets the {@link GeoHashPoint} object from the given ip address or return null if nothing is
	 * found.
	 *
	 * @param lookupService
	 *            the lookup service
	 * @param ipAddress
	 *            the ip address
	 * @return the {@link GeoHashPoint} object from the given ip address or return null if nothing
	 *         is found.
	 */
	public static GeoHashPoint getGeoHashPoint(final LookupService lookupService,
		final String ipAddress)
	{
		final Location lc = lookupService.getLocation(ipAddress);
		if (lc != null)
		{
			return new GeoHashPoint(lc.latitude, lc.longitude);
		}
		return null;
	}

	/**
	 * Sort the given list by distance from the given start position.
	 *
	 * @param startPoint
	 *            the start point
	 * @param geohashes
	 *            the geohashes
	 * @param unit
	 *            the unit
	 * @return the list
	 */
	public static List<Position> sortByDistance(final Position startPoint,
		final List<Position> geohashes, final MeasuringUnit unit)
	{
		final List<DistancePoint> distancePoints = getDistancePoints(startPoint, geohashes, unit);
		Collections.sort(distancePoints);
		final List<Position> geosorted = new ArrayList<>();
		for (int i = 0; i < distancePoints.size(); i++)
		{
			geosorted.add(distancePoints.get(i).getPoint());
		}
		return geosorted;
	}

	/**
	 * Sort the given list by distance from the given start position in meters.
	 *
	 * @param startPoint
	 *            the start point
	 * @param geohashes
	 *            the geohashes
	 * @return the list
	 */
	public static List<Position> sortByDistanceInMeters(final Position startPoint,
		final List<Position> geohashes)
	{
		return sortByDistance(startPoint, geohashes, MeasuringUnit.METER);
	}
}