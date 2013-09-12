package org.jgeohash.api;

import java.io.Serializable;

/**
 * The Interface Position defines a position from a latitude and a longitude.
 */
public interface Position extends Serializable {

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	double getLatitude();

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	double getLongitude();

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	void setLatitude(double latitude);

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	void setLongitude(double longitude);

}