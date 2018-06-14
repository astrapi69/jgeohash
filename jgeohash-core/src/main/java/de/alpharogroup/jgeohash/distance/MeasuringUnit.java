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

import lombok.Getter;

/**
 * The enum class {@link MeasuringUnit} provides the factors for kilometer, meter and miles.
 */
public enum MeasuringUnit
{

	/**
	 * The kilometer. 1.609344 is the number of kilometres in a mile
	 */
	KILOMETER(MeasuringUnit.KILOMETER_FACTOR),
	/**
	 * The meter. 1609.344 is the number of metres in a mile
	 */
	METER(MeasuringUnit.METER_FACTOR),

	/**
	 * The mile. 0.8684 is the factor for convert miles(statute) into miles (nautical). One nautical
	 * mile is the length of one minute of latitude at the equator.
	 **/
	MILE(MeasuringUnit.MILE_FACTOR);

	public static final double KILOMETER_FACTOR = 1.609344;
	public static final double METER_FACTOR = KILOMETER_FACTOR * 1000;
	public static final double MILE_FACTOR = 0.8684;

	/** The factor. */
	@Getter
	private final double factor;

	/**
	 * Instantiates a new measuring unit.
	 *
	 * @param factor
	 *            the factor
	 */
	private MeasuringUnit(final double factor)
	{
		this.factor = factor;
	}

}