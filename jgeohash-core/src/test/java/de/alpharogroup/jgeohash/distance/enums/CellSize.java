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
package de.alpharogroup.jgeohash.distance.enums;

import lombok.Getter;

/**
 * The enum {@link CellSize} represents the size of a cell from a geohash value
 */
@Getter
public enum CellSize
{
	/**
	 * The enum value HEIGHT_1_CELL represents the height from a cell from a geohash value with 1
	 * characters.
	 **/
	HEIGHT_1_CELL(1, 5003.53096, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_2_CELL represents the height from a cell from a geohash value with 2
	 * characters.
	 **/
	HEIGHT_2_CELL(2, 744.37693, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_3_CELL represents the height from a cell from a geohash value with 3
	 * characters.
	 **/
	HEIGHT_3_CELL(3, 156.36034, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_4_CELL represents the height from a cell from a geohash value with 4
	 * characters.
	 **/
	HEIGHT_4_CELL(4, 19.54504, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_5_CELL represents the height from a cell from a geohash value with 5
	 * characters.
	 **/
	HEIGHT_5_CELL(5, 5.88626, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_6_CELL represents the height from a cell from a geohash value with 6
	 * characters.
	 **/
	HEIGHT_6_CELL(6, 0.61078, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_7_CELL represents the height from a cell from a geohash value with 7
	 * characters.
	 **/
	HEIGHT_7_CELL(7, 0.15269, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_8_CELL represents the height from a cell from a geohash value with 8
	 * characters.
	 **/
	HEIGHT_8_CELL(8, 0.01908, Alignment.HEIGHT),
	/**
	 * The enum value HEIGHT_9_CELL represents the height from a cell from a geohash value with 9
	 * characters.
	 **/
	HEIGHT_9_CELL(9, 0.00283, Alignment.HEIGHT),
	/**
	 * The enum value WIDTH_1_CELL represents the width from a cell from a geohash value with 1
	 * characters.
	 **/
	WIDTH_1_CELL(1, 4604.31836, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_2_CELL represents the width from a cell from a geohash value with 2
	 * characters.
	 **/
	WIDTH_2_CELL(2, 625.44137, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_3_CELL represents the width from a cell from a geohash value with 3
	 * characters.
	 **/
	WIDTH_3_CELL(3, 103.57409, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_4_CELL represents the width from a cell from a geohash value with 4
	 * characters.
	 **/
	WIDTH_4_CELL(4, 25.66850, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_5_CELL represents the width from a cell from a geohash value with 5
	 * characters.
	 **/
	WIDTH_5_CELL(5, 3.21280, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_6_CELL represents the width from a cell from a geohash value with 6
	 * characters.
	 **/
	WIDTH_6_CELL(6, 0.80315, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_7_CELL represents the width from a cell from a geohash value with 7
	 * characters.
	 **/
	WIDTH_7_CELL(7, 0.10039, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_8_CELL represents the width from a cell from a geohash value with 8
	 * characters.
	 **/
	WIDTH_8_CELL(8, 0.02509, Alignment.WIDTH),
	/**
	 * The enum value WIDTH_9_CELL represents the width from a cell from a geohash value with 9
	 * characters.
	 **/
	WIDTH_9_CELL(9, 0.00477, Alignment.WIDTH);

	/** The alignment. */
	private final Alignment alignment;

	/** The size of the characters in the geohash value. */
	private final int characters;

	/** The size. */
	private final double size;

	/**
	 * Instantiates a new cell size.
	 *
	 * @param characters
	 *            the characters
	 * @param size
	 *            the size
	 * @param alignment
	 *            the alignment
	 */
	private CellSize(int characters, double size, Alignment alignment)
	{
		this.characters = characters;
		this.size = size;
		this.alignment = alignment;
	}

}
