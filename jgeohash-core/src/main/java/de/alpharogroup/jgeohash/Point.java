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

import de.alpharogroup.jgeohash.api.Position;
import lombok.Builder;
import lombok.EqualsAndHashCode;

/**
 * The class {@link Point} represents a point on earth with the latitude and longitude.
 */
@EqualsAndHashCode
@Builder(toBuilder = true)
public class Point implements Comparable<Point>, Cloneable, Position
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = -4799959551221362673L;

	/** The latitude. */
	private double latitude;

	/** The longitude. */
	private double longitude;

	/**
	 * Instantiates a new {@link Point} object.
	 *
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 */
	public Point(final double latitude, final double longitude)
	{
		if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180)
		{
			throw new IllegalArgumentException(
				"The given coordinates " + this.toString() + " are out of range.");
		}
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone()
	{
		final Position inst = new Point(this.latitude, this.longitude);
		return inst;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final Point other)
	{
		if (this == other)
		{
			return 0;
		}
		if (this.latitude < other.latitude)
		{
			return -1;
		}
		if (this.latitude > other.latitude)
		{
			return 1;
		}
		if (this.longitude < other.longitude)
		{
			return -1;
		}
		if (this.longitude > other.longitude)
		{
			return 1;
		}
		// all comparisons have yielded equality
		// verify that compareTo is consistent with equals (optional)
		assert this.equals(other) : "compareTo inconsistent with equals.";
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLatitude(final double latitude)
	{
		if (Math.abs(latitude) > 90)
		{
			throw new IllegalArgumentException(
				"The given coordinates for latitude " + latitude + " are out of range.");
		}
		this.latitude = latitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLongitude(final double longitude)
	{
		if (Math.abs(longitude) > 180)
		{
			throw new IllegalArgumentException(
				"The given coordinates for longitude " + longitude + " are out of range.");
		}
		this.longitude = longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Latitude : " + latitude + "   Longitude  : " + longitude;
	}

}
