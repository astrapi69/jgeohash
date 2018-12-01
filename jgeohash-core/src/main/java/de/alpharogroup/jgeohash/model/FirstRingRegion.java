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
package de.alpharogroup.jgeohash.model;

import java.io.Serializable;

import de.alpharogroup.jgeohash.Adjacent;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The class {@link FirstRingRegion} provides the neighbors from the given geohash value.
 */
@Getter
@EqualsAndHashCode
@ToString
public class FirstRingRegion implements Serializable, Cloneable
{

	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = -1L;

	/** The center. */
	private final String center;

	/** The east. */
	private final String east;

	/** The north. */
	private final String north;

	/** The north east. */
	private final String northEast;

	/** The north west. */
	private final String northWest;

	/** The south. */
	private final String south;

	/** The south east. */
	private final String southEast;

	/** The south west. */
	private final String southWest;

	/** The west. */
	private final String west;

	/**
	 * Instantiates a new FirstRingRegion object from the given geohash value.
	 *
	 * @param geohash
	 *            the center
	 */
	public FirstRingRegion(final String geohash)
	{
		this.center = geohash;
		this.east = GeoHashExtensions.getAdjacent(geohash, Adjacent.RIGHT);
		this.west = GeoHashExtensions.getAdjacent(geohash, Adjacent.LEFT);
		this.north = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP);
		this.south = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM);
		this.southEast = GeoHashExtensions.getAdjacent(this.south, Adjacent.RIGHT);
		this.northEast = GeoHashExtensions.getAdjacent(this.north, Adjacent.RIGHT);
		this.northWest = GeoHashExtensions.getAdjacent(this.north, Adjacent.LEFT);
		this.southWest = GeoHashExtensions.getAdjacent(this.south, Adjacent.LEFT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone()
	{
		return new FirstRingRegion(this.center);
	}

}
