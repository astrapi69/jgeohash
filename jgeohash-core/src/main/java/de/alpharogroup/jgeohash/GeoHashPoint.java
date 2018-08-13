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

import java.math.BigDecimal;

import de.alpharogroup.jgeohash.api.Position;
import lombok.EqualsAndHashCode;

/**
 * The class {@link GeoHashPoint}.
 */
@EqualsAndHashCode(callSuper = true)
public class GeoHashPoint extends Point
{

	/** The Constant GEOHASH_KEY. */
	public static final String GEOHASH_KEY = "GEOHASH_KEY";

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = -3580536765079661097L;

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public GeoHashPoint(final double latitude, final double longitude)
	{
		super(latitude, longitude);
	}

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public GeoHashPoint(final Double latitude, final Double longitude)
	{
		super(latitude, longitude);
	}

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public GeoHashPoint(final float latitude, final float longitude)
	{
		this(Float.toString(latitude), Float.toString(longitude));
	}

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param position
	 *            the position
	 */
	public GeoHashPoint(final Position position)
	{
		this(position.getLatitude(), position.getLongitude());
	}

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param geohash
	 *            the Geohash code.
	 */
	public GeoHashPoint(final String geohash)
	{
		super(GeoHashExtensions.decode(geohash)[0], GeoHashExtensions.decode(geohash)[1]);
	}

	/**
	 * Instantiates a new {@link GeoHashPoint}.
	 *
	 * @param lat
	 *            the latitude as String object.
	 * @param lng
	 *            the longitude as String object.
	 */
	public GeoHashPoint(final String lat, final String lng)
	{
		super(Double.parseDouble(lat), Double.parseDouble(lng));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone()
	{
		return new GeoHashPoint(getLatitude(), getLongitude());
	}

	/**
	 * Gets the geohash.
	 *
	 * @return the geohash
	 */
	public String getGeohash()
	{
		return GeoHashExtensions.encode(getLatitude(), getLongitude());
	}

	/**
	 * Gets the latitude as BigDecimal object.
	 *
	 * @return the latitude as BigDecimal object.
	 */
	public BigDecimal getLat()
	{
		return BigDecimal.valueOf(getLatitude());
	}

	/**
	 * Gets the longitude as BigDecimal object.
	 *
	 * @return the longitude as BigDecimal object.
	 */
	public BigDecimal getLng()
	{
		return BigDecimal.valueOf(getLongitude());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		final StringBuilder buffer = new StringBuilder();
		buffer.append("[GeoHashPoint:");
		buffer.append(super.toString());
		buffer.append("   Geohash : ");
		buffer.append(getGeohash());
		buffer.append("]");
		return buffer.toString();
	}

}
