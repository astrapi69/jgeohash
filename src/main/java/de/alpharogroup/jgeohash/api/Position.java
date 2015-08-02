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
package de.alpharogroup.jgeohash.api;

import java.io.Serializable;

/**
 * The Interface Position defines a position from a latitude and a longitude.
 */
public interface Position extends Serializable
{

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	double getLatitude();

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	double getLongitude();

	/**
	 * Sets the latitude.
	 *
	 * @param latitude
	 *            the new latitude
	 */
	void setLatitude(final double latitude);

	/**
	 * Sets the longitude.
	 *
	 * @param longitude
	 *            the new longitude
	 */
	void setLongitude(final double longitude);

}