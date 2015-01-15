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

import java.math.BigDecimal;

import org.jgeohash.api.Position;

/**
 * The Class GeoHashPoint.
 */
public class GeoHashPoint extends Point {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = -3580536765079661097L;
	/** The Constant GEOHASH_KEY. */
	public static final String GEOHASH_KEY = "GEOHASH_KEY";

	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public GeoHashPoint(final double latitude, final double longitude) {
		super(latitude, longitude);
	}

	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public GeoHashPoint(final Double latitude, final Double longitude) {
		super(latitude, longitude);
	}

	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param position the position
	 */
	public GeoHashPoint(final Position position) {
		this(position.getLatitude(), position.getLongitude());
	}

	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public GeoHashPoint(final float latitude, final float longitude) {
		this(Float.toString(latitude), Float.toString(longitude));
	}
	
	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param lat the latitude as String object.
	 * @param lng the longitude as String object.
	 */
	public GeoHashPoint(final String lat, final String lng) {
		super(Double.parseDouble(lat), Double.parseDouble(lng));
	}

	/**
	 * Instantiates a new geo hash point.
	 *
	 * @param geohash the Geohash code.
	 */
	public GeoHashPoint(String geohash) {
		super(GeoHashUtils.decode(geohash)[0], GeoHashUtils.decode(geohash)[1]);
	}

	/**
	 * Gets the geohash.
	 *
	 * @return the geohash
	 */
	public String getGeohash() {
		return GeoHashUtils.encode(getLatitude(), getLongitude());
	}

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public BigDecimal getLat() {
		return BigDecimal.valueOf(getLatitude());
	}

	/**
	 * Gets the lng.
	 *
	 * @return the lng
	 */
	public BigDecimal getLng() {
		return BigDecimal.valueOf(getLongitude());
	}
	
    /**
     * {@inheritDoc}
     */
	public Object clone() {
		return new GeoHashPoint(getLatitude(), getLongitude());
	}
	
    /**
     * {@inheritDoc}
     */
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != getClass()) {
			return false;
		}
		GeoHashPoint castedObj = (GeoHashPoint) o;
		return ((this.getLatitude()== castedObj.getLatitude()) && (this.getLongitude() == castedObj.getLongitude()));
	}
	
    /**
     * {@inheritDoc}
     */
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = 31
			* hashCode
			+ (int) (+serialVersionUID ^ (serialVersionUID >>> 32));
		hashCode = 31
			* hashCode
			+ (GEOHASH_KEY == null ? 0 : GEOHASH_KEY.hashCode());
		return hashCode;
	}

    /**
     * {@inheritDoc}
     */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[GeoHashPoint:");
		buffer.append(super.toString());
		buffer.append("   Geohash : ");
		buffer.append(getGeohash());
		buffer.append("]");
		return buffer.toString();
	}

}
