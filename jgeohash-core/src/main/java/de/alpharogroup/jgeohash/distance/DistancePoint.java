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
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The class {@link DistancePoint} is a pojo for holding a distance from one point. you can sort
 * than the objects from the distance.
 */
@Getter
@EqualsAndHashCode
@ToString
@Builder(toBuilder = true)
public class DistancePoint implements Comparable<DistancePoint>
{

	/** The distance. */
	private final Double distance;

	/** The position point. */
	private final Position point;

	/**
	 * Instantiates a new {@link DistancePoint} object from the given arguments
	 *
	 * @param distance
	 *            the distance
	 * @param point
	 *            the position point
	 */
	public DistancePoint(final Double distance, final Position point)
	{
		this.distance = distance;
		this.point = point;
	}

	/**
	 * Instantiates a new {@link DistancePoint} object from the given arguments
	 *
	 * @param point
	 *            the position point
	 * @param distance
	 *            the distance
	 */
	public DistancePoint(final Position point, final Double distance)
	{
		this.point = point;
		this.distance = distance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final DistancePoint o)
	{
		return distance.compareTo(o.distance);
	}

}