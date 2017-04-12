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
package de.alpharogroup.jgeohash.distance;

import de.alpharogroup.jgeohash.api.Position;

/**
 * The Class DistancePoint is a pojo for holding a distance between two points.
 */
public class DistancePoint implements Comparable<DistancePoint>
{

	/** The point. */
	private final Position point;

	/** The distance. */
	private final Double distance;

	/**
	 * Instantiates a new distance point.
	 *
	 * @param point
	 *            the point
	 * @param distance
	 *            the distance
	 */
	public DistancePoint(final Position point, final Double distance)
	{
		this.point = point;
		this.distance = distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(final DistancePoint o)
	{
		return distance.compareTo(o.distance);
	}

	/**
	 * Gets the point.
	 *
	 * @return the point
	 */
	public Position getPoint()
	{
		return point;
	}
}