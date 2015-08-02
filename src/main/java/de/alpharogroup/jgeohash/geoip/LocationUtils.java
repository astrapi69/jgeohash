package de.alpharogroup.jgeohash.geoip;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import de.alpharogroup.jgeohash.GeoHashPoint;

/**
 * The Class LocationUtils is for location specific data.
 */
public class LocationUtils
{


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
}