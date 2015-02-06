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
package org.jgeohash.model;

import java.io.Serializable;

import org.jgeohash.Adjacent;
import org.jgeohash.GeoHashUtils;

/**
 * The Class FirstRingRegion provides the neighbors from the given geohash value in f.
 */
public class FirstRingRegion implements Serializable {

	/**
	 * The constant serialVersionUID.
	 */
	private static final long serialVersionUID = -1690885107068325816L;

	/** The center. */
	private final String center;

	/** The east. */
	private final String east;

	/** The west. */
	private final String west;

	/** The north. */
	private final String north;

	/** The south. */
	private final String south;

	/** The south east. */
	private final String southEast;

	/** The north east. */
	private final String northEast;

	/** The north west. */
	private final String northWest;

	/** The south west. */
	private final String southWest;

	/**
	 * Instantiates a new FirstRingRegion object from the given geohash value.
	 * 
	 * @param geohash
	 *            the center
	 */
	public FirstRingRegion(final String geohash) {
		super();
		this.center = geohash;
		this.east = GeoHashUtils.getAdjacent(geohash, Adjacent.RIGHT);
		this.west = GeoHashUtils.getAdjacent(geohash, Adjacent.LEFT);
		this.north = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP);
		this.south = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM);
		this.southEast = GeoHashUtils.getAdjacent(this.south, Adjacent.RIGHT);
		this.northEast = GeoHashUtils.getAdjacent(this.north, Adjacent.RIGHT);
		this.northWest = GeoHashUtils
				.getAdjacent(this.north, Adjacent.LEFT);
		this.southWest = GeoHashUtils.getAdjacent(this.south, Adjacent.LEFT);
	}

	/**
	 * Gets the center.
	 *
	 * @return the center
	 */
	public String getCenter() {
		return center;
	}

	/**
	 * Gets the east.
	 *
	 * @return the east
	 */
	public String getEast() {
		return east;
	}

	/**
	 * Gets the west.
	 *
	 * @return the west
	 */
	public String getWest() {
		return west;
	}

	/**
	 * Gets the north.
	 *
	 * @return the north
	 */
	public String getNorth() {
		return north;
	}

	/**
	 * Gets the south.
	 *
	 * @return the south
	 */
	public String getSouth() {
		return south;
	}

	/**
	 * Gets the south east.
	 *
	 * @return the south east
	 */
	public String getSouthEast() {
		return southEast;
	}

	/**
	 * Gets the north east.
	 *
	 * @return the north east
	 */
	public String getNorthEast() {
		return northEast;
	}

	/**
	 * Gets the north west.
	 *
	 * @return the north west
	 */
	public String getNorthWest() {
		return northWest;
	}

	/**
	 * Gets the south west.
	 *
	 * @return the south west
	 */
	public String getSouthWest() {
		return southWest;
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("[GeoHashRegion:");
		buffer.append(" center:");
		buffer.append(center);
		buffer.append(" east:");
		buffer.append(east);
		buffer.append(" west:");
		buffer.append(west);
		buffer.append(" north:");
		buffer.append(north);
		buffer.append(" south:");
		buffer.append(south);
		buffer.append(" southEast:");
		buffer.append(southEast);
		buffer.append(" northEast:");
		buffer.append(northEast);
		buffer.append(" northWest:");
		buffer.append(northWest);
		buffer.append(" southWest:");
		buffer.append(southWest);
		buffer.append("]");
		return buffer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != getClass()) {
			return false;
		}
		FirstRingRegion castedObj = (FirstRingRegion) o;
		return ((this.center == null ? castedObj.center == null : this.center
			.equals(castedObj.center))
			&& (this.east == null ? castedObj.east == null : this.east
				.equals(castedObj.east))
			&& (this.west == null ? castedObj.west == null : this.west
				.equals(castedObj.west))
			&& (this.north == null ? castedObj.north == null : this.north
				.equals(castedObj.north))
			&& (this.south == null ? castedObj.south == null : this.south
				.equals(castedObj.south))
			&& (this.southEast == null
				? castedObj.southEast == null
				: this.southEast.equals(castedObj.southEast))
			&& (this.northEast == null
				? castedObj.northEast == null
				: this.northEast.equals(castedObj.northEast))
			&& (this.northWest == null
				? castedObj.northWest == null
				: this.northWest.equals(castedObj.northWest)) && (this.southWest == null
				? castedObj.southWest == null
				: this.southWest.equals(castedObj.southWest)));
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31
			* hashCode
			+ (int) (+serialVersionUID ^ (serialVersionUID >>> 32));
		hashCode = 31 * hashCode + (center == null ? 0 : center.hashCode());
		hashCode = 31 * hashCode + (east == null ? 0 : east.hashCode());
		hashCode = 31 * hashCode + (west == null ? 0 : west.hashCode());
		hashCode = 31 * hashCode + (north == null ? 0 : north.hashCode());
		hashCode = 31 * hashCode + (south == null ? 0 : south.hashCode());
		hashCode = 31
			* hashCode
			+ (southEast == null ? 0 : southEast.hashCode());
		hashCode = 31
			* hashCode
			+ (northEast == null ? 0 : northEast.hashCode());
		hashCode = 31
			* hashCode
			+ (northWest == null ? 0 : northWest.hashCode());
		hashCode = 31
			* hashCode
			+ (southWest == null ? 0 : southWest.hashCode());
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 */
        @Override
	public Object clone() {
		return new FirstRingRegion(this.center);
	}

}
