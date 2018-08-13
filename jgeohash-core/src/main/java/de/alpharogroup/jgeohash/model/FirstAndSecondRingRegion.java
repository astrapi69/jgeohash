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

import de.alpharogroup.jgeohash.Adjacent;
import de.alpharogroup.jgeohash.GeoHashExtensions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The class {@link FirstAndSecondRingRegion} provides the neighbors from the given geohash value in
 * first and second ring.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FirstAndSecondRingRegion extends FirstRingRegion
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6668301917974379694L;

	/** The east east. */
	private final String eastEast;

	/** The east north east. */
	private final String eastNorthEast;

	/** The east south east. */
	private final String eastSouthEast;

	/** The north east north east. */
	private final String northEastNorthEast;

	/** The north north. */
	private final String northNorth;

	/** The north north east. */
	private final String northNorthEast;

	/** The north north west. */
	private final String northNorthWest;

	/** The north west north west. */
	private final String northWestNorthWest;

	/** The south east south east. */
	private final String southEastSouthEast;

	/** The south south. */
	private final String southSouth;

	/** The south south east. */
	private final String southSouthEast;

	/** The south south west. */
	private final String southSouthWest;

	/** The south west south west. */
	private final String southWestSouthWest;

	/** The west north west. */
	private final String westNorthWest;

	/** The west south west. */
	private final String westSouthWest;

	/** The west west. */
	private final String westWest;

	/**
	 * Instantiates a new FirstAndSecondRingRegion from the given geohash value.
	 *
	 * @param geohash
	 *            the geohash
	 */
	public FirstAndSecondRingRegion(final String geohash)
	{
		super(geohash);
		northNorth = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.TOP);
		northNorthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.TOP);
		northWestNorthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.TOP, Adjacent.LEFT);
		westNorthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.LEFT);
		northNorthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.TOP);
		northEastNorthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.TOP, Adjacent.RIGHT);
		eastNorthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.RIGHT);
		eastEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.RIGHT, Adjacent.RIGHT);
		eastSouthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.RIGHT);
		southSouthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.BOTTOM);
		southEastSouthEast = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.BOTTOM, Adjacent.RIGHT);
		southSouth = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.BOTTOM);
		southSouthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.BOTTOM);
		southWestSouthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.BOTTOM, Adjacent.LEFT);
		westSouthWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.LEFT);
		westWest = GeoHashExtensions.getAdjacent(geohash, Adjacent.LEFT, Adjacent.LEFT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone()
	{
		return new FirstAndSecondRingRegion(getCenter());
	}

}
