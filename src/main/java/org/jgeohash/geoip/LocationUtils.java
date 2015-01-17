package org.jgeohash.geoip;

import org.jgeohash.GeoHashPoint;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

/**
 * The Class LocationUtils is for location specific data.
 */
public class LocationUtils {


	/**
	 * Gets the geohash from the given ip address or return an empty String if nothing is found.
	 *
	 * @param lookupService the lookup service
	 * @param ipAddress the ip address
	 * @return the geohash from ip address or an empty String if nothing is found.
	 */
	public static String getGeohashFromIpAddress(LookupService lookupService, String ipAddress) {
		GeoHashPoint geoHashPoint = getGeoHashPoint(lookupService, ipAddress);
		if(geoHashPoint != null) {
			return geoHashPoint.getGeohash();
		}
		return "";
	}

	/**
	 * Gets the {@link GeoHashPoint} object from the given ip address or return null if nothing is found.
	 *
	 * @param lookupService the lookup service
	 * @param ipAddress the ip address
	 * @return the {@link GeoHashPoint} object from the given ip address or return null if nothing is found.
	 */
	public static GeoHashPoint getGeoHashPoint(LookupService lookupService, String ipAddress) {
		Location lc = lookupService.getLocation(ipAddress);
		if(lc != null) {
			return new GeoHashPoint(lc.latitude, lc.longitude);
		}
		return null;
	}
}