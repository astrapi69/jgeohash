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
import de.alpharogroup.jgeohash.GeoHashUtils;

/**
 * The Class FirstAndSecondRingRegion provides the neighbors from the given geohash value in first
 * and second ring.
 */
public class FirstAndSecondRingRegion extends FirstRingRegion
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6668301917974379694L;

	/** The north north. */
	private final String northNorth;

	/** The north north west. */
	private final String northNorthWest;

	/** The north west north west. */
	private final String northWestNorthWest;

	/** The west north west. */
	private final String westNorthWest;

	/** The north north east. */
	private final String northNorthEast;

	/** The north east north east. */
	private final String northEastNorthEast;

	/** The east north east. */
	private final String eastNorthEast;

	/** The east east. */
	private final String eastEast;

	/** The east south east. */
	private final String eastSouthEast;

	/** The south south east. */
	private final String southSouthEast;

	/** The south east south east. */
	private final String southEastSouthEast;

	/** The south south. */
	private final String southSouth;

	/** The south south west. */
	private final String southSouthWest;

	/** The south west south west. */
	private final String southWestSouthWest;

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
		northNorth = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.TOP);
		northNorthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.TOP);
		northWestNorthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.TOP, Adjacent.LEFT);
		westNorthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.LEFT,
			Adjacent.LEFT);
		northNorthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.TOP);
		northEastNorthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.TOP, Adjacent.RIGHT);
		eastNorthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.TOP, Adjacent.RIGHT,
			Adjacent.RIGHT);
		eastEast = GeoHashUtils.getAdjacent(geohash, Adjacent.RIGHT, Adjacent.RIGHT);
		eastSouthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.RIGHT);
		southSouthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.BOTTOM);
		southEastSouthEast = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.RIGHT,
			Adjacent.BOTTOM, Adjacent.RIGHT);
		southSouth = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.BOTTOM);
		southSouthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.BOTTOM);
		southWestSouthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.BOTTOM, Adjacent.LEFT);
		westSouthWest = GeoHashUtils.getAdjacent(geohash, Adjacent.BOTTOM, Adjacent.LEFT,
			Adjacent.LEFT);
		westWest = GeoHashUtils.getAdjacent(geohash, Adjacent.LEFT, Adjacent.LEFT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone()
	{
		return new FirstAndSecondRingRegion(getCenter());
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!super.equals(obj))
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final FirstAndSecondRingRegion other = (FirstAndSecondRingRegion)obj;
		if (eastEast == null)
		{
			if (other.eastEast != null)
			{
				return false;
			}
		}
		else if (!eastEast.equals(other.eastEast))
		{
			return false;
		}
		if (eastNorthEast == null)
		{
			if (other.eastNorthEast != null)
			{
				return false;
			}
		}
		else if (!eastNorthEast.equals(other.eastNorthEast))
		{
			return false;
		}
		if (eastSouthEast == null)
		{
			if (other.eastSouthEast != null)
			{
				return false;
			}
		}
		else if (!eastSouthEast.equals(other.eastSouthEast))
		{
			return false;
		}
		if (northEastNorthEast == null)
		{
			if (other.northEastNorthEast != null)
			{
				return false;
			}
		}
		else if (!northEastNorthEast.equals(other.northEastNorthEast))
		{
			return false;
		}
		if (northNorth == null)
		{
			if (other.northNorth != null)
			{
				return false;
			}
		}
		else if (!northNorth.equals(other.northNorth))
		{
			return false;
		}
		if (northNorthEast == null)
		{
			if (other.northNorthEast != null)
			{
				return false;
			}
		}
		else if (!northNorthEast.equals(other.northNorthEast))
		{
			return false;
		}
		if (northNorthWest == null)
		{
			if (other.northNorthWest != null)
			{
				return false;
			}
		}
		else if (!northNorthWest.equals(other.northNorthWest))
		{
			return false;
		}
		if (northWestNorthWest == null)
		{
			if (other.northWestNorthWest != null)
			{
				return false;
			}
		}
		else if (!northWestNorthWest.equals(other.northWestNorthWest))
		{
			return false;
		}
		if (southEastSouthEast == null)
		{
			if (other.southEastSouthEast != null)
			{
				return false;
			}
		}
		else if (!southEastSouthEast.equals(other.southEastSouthEast))
		{
			return false;
		}
		if (southSouth == null)
		{
			if (other.southSouth != null)
			{
				return false;
			}
		}
		else if (!southSouth.equals(other.southSouth))
		{
			return false;
		}
		if (southSouthEast == null)
		{
			if (other.southSouthEast != null)
			{
				return false;
			}
		}
		else if (!southSouthEast.equals(other.southSouthEast))
		{
			return false;
		}
		if (southSouthWest == null)
		{
			if (other.southSouthWest != null)
			{
				return false;
			}
		}
		else if (!southSouthWest.equals(other.southSouthWest))
		{
			return false;
		}
		if (southWestSouthWest == null)
		{
			if (other.southWestSouthWest != null)
			{
				return false;
			}
		}
		else if (!southWestSouthWest.equals(other.southWestSouthWest))
		{
			return false;
		}
		if (westNorthWest == null)
		{
			if (other.westNorthWest != null)
			{
				return false;
			}
		}
		else if (!westNorthWest.equals(other.westNorthWest))
		{
			return false;
		}
		if (westSouthWest == null)
		{
			if (other.westSouthWest != null)
			{
				return false;
			}
		}
		else if (!westSouthWest.equals(other.westSouthWest))
		{
			return false;
		}
		if (westWest == null)
		{
			if (other.westWest != null)
			{
				return false;
			}
		}
		else if (!westWest.equals(other.westWest))
		{
			return false;
		}
		return true;
	}

	/**
	 * Gets the east east.
	 *
	 * @return the east east
	 */
	public String getEastEast()
	{
		return eastEast;
	}

	/**
	 * Gets the east north east.
	 *
	 * @return the east north east
	 */
	public String getEastNorthEast()
	{
		return eastNorthEast;
	}

	/**
	 * Gets the east south east.
	 *
	 * @return the east south east
	 */
	public String getEastSouthEast()
	{
		return eastSouthEast;
	}

	/**
	 * Gets the north east north east.
	 *
	 * @return the north east north east
	 */
	public String getNorthEastNorthEast()
	{
		return northEastNorthEast;
	}

	/**
	 * Gets the north north.
	 *
	 * @return the north north
	 */
	public String getNorthNorth()
	{
		return northNorth;
	}

	/**
	 * Gets the north north east.
	 *
	 * @return the north north east
	 */
	public String getNorthNorthEast()
	{
		return northNorthEast;
	}

	/**
	 * Gets the north north west.
	 *
	 * @return the north north west
	 */
	public String getNorthNorthWest()
	{
		return northNorthWest;
	}

	/**
	 * Gets the north west north west.
	 *
	 * @return the north west north west
	 */
	public String getNorthWestNorthWest()
	{
		return northWestNorthWest;
	}

	/**
	 * Gets the south east south east.
	 *
	 * @return the south east south east
	 */
	public String getSouthEastSouthEast()
	{
		return southEastSouthEast;
	}

	/**
	 * Gets the south south.
	 *
	 * @return the south south
	 */
	public String getSouthSouth()
	{
		return southSouth;
	}

	/**
	 * Gets the south south east.
	 *
	 * @return the south south east
	 */
	public String getSouthSouthEast()
	{
		return southSouthEast;
	}

	/**
	 * Gets the south south west.
	 *
	 * @return the south south west
	 */
	public String getSouthSouthWest()
	{
		return southSouthWest;
	}

	/**
	 * Gets the south west south west.
	 *
	 * @return the south west south west
	 */
	public String getSouthWestSouthWest()
	{
		return southWestSouthWest;
	}

	/**
	 * Gets the west north west.
	 *
	 * @return the west north west
	 */
	public String getWestNorthWest()
	{
		return westNorthWest;
	}

	/**
	 * Gets the west south west.
	 *
	 * @return the west south west
	 */
	public String getWestSouthWest()
	{
		return westSouthWest;
	}

	/**
	 * Gets the west west.
	 *
	 * @return the west west
	 */
	public String getWestWest()
	{
		return westWest;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((eastEast == null) ? 0 : eastEast.hashCode());
		result = prime * result + ((eastNorthEast == null) ? 0 : eastNorthEast.hashCode());
		result = prime * result + ((eastSouthEast == null) ? 0 : eastSouthEast.hashCode());
		result = prime * result
			+ ((northEastNorthEast == null) ? 0 : northEastNorthEast.hashCode());
		result = prime * result + ((northNorth == null) ? 0 : northNorth.hashCode());
		result = prime * result + ((northNorthEast == null) ? 0 : northNorthEast.hashCode());
		result = prime * result + ((northNorthWest == null) ? 0 : northNorthWest.hashCode());
		result = prime * result
			+ ((northWestNorthWest == null) ? 0 : northWestNorthWest.hashCode());
		result = prime * result
			+ ((southEastSouthEast == null) ? 0 : southEastSouthEast.hashCode());
		result = prime * result + ((southSouth == null) ? 0 : southSouth.hashCode());
		result = prime * result + ((southSouthEast == null) ? 0 : southSouthEast.hashCode());
		result = prime * result + ((southSouthWest == null) ? 0 : southSouthWest.hashCode());
		result = prime * result
			+ ((southWestSouthWest == null) ? 0 : southWestSouthWest.hashCode());
		result = prime * result + ((westNorthWest == null) ? 0 : westNorthWest.hashCode());
		result = prime * result + ((westSouthWest == null) ? 0 : westSouthWest.hashCode());
		result = prime * result + ((westWest == null) ? 0 : westWest.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		final StringBuilder buffer = new StringBuilder();
		buffer.append("[SecondRingRegion:");
		buffer.append("center:");
		buffer.append(getCenter());
		buffer.append(" east:");
		buffer.append(getEast());
		buffer.append(" west:");
		buffer.append(getWest());
		buffer.append(" north:");
		buffer.append(getNorth());
		buffer.append(" south:");
		buffer.append(getSouth());
		buffer.append(" southEast:");
		buffer.append(getSouthEast());
		buffer.append(" northEast:");
		buffer.append(getNorthEast());
		buffer.append(" northWest:");
		buffer.append(getNorthWest());
		buffer.append(" southWest:");
		buffer.append(getSouthWest());
		buffer.append(" northNorth:");
		buffer.append(northNorth);
		buffer.append(" northNorthWest:");
		buffer.append(northNorthWest);
		buffer.append(" northWestNorthWest:");
		buffer.append(northWestNorthWest);
		buffer.append(" westNorthWest:");
		buffer.append(westNorthWest);
		buffer.append(" northNorthEast:");
		buffer.append(northNorthEast);
		buffer.append(" northEastNorthEast:");
		buffer.append(northEastNorthEast);
		buffer.append(" eastNorthEast:");
		buffer.append(eastNorthEast);
		buffer.append(" eastEast:");
		buffer.append(eastEast);
		buffer.append(" eastSouthEast:");
		buffer.append(eastSouthEast);
		buffer.append(" southSouthEast:");
		buffer.append(southSouthEast);
		buffer.append(" southEastSouthEast:");
		buffer.append(southEastSouthEast);
		buffer.append(" southSouth:");
		buffer.append(southSouth);
		buffer.append(" southSouthWest:");
		buffer.append(southSouthWest);
		buffer.append(" southWestSouthWest:");
		buffer.append(southWestSouthWest);
		buffer.append(" westSouthWest:");
		buffer.append(westSouthWest);
		buffer.append(" westWest:");
		buffer.append(westWest);
		buffer.append("]");
		return buffer.toString();
	}

}
