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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The class {@link Adjacent}.
 */
public abstract class Adjacent
{

	/**
	 * The static class Borders.
	 */
	public static class Borders
	{

		/** The Constant borders. */
		public static final Map<String, Map<String, String>> borders = new LinkedHashMap<>();

		/** The Constant BOTTOM_LEFT. */
		private static final String BOTTOM_LEFT = "028b";

		/** The Constant LEFT_BOTTOM. */
		private static final String LEFT_BOTTOM = "0145hjnp";

		/** The Constant RIGHT_TOP. */
		private static final String RIGHT_TOP = "bcfguvyz";

		/** The Constant TOP_RIGHT. */
		private static final String TOP_RIGHT = "prxz";

		/**
		 * Initializes the borders map.
		 **/
		static
		{
			final Map<String, String> right = new LinkedHashMap<>();
			right.put(Adjacent.EVEN, Borders.RIGHT_TOP);
			right.put(Adjacent.ODD, Borders.TOP_RIGHT);
			final Map<String, String> left = new LinkedHashMap<>();
			left.put(Adjacent.EVEN, Borders.LEFT_BOTTOM);
			left.put(Adjacent.ODD, Borders.BOTTOM_LEFT);
			final Map<String, String> top = new LinkedHashMap<>();
			top.put(Adjacent.EVEN, Borders.TOP_RIGHT);
			top.put(Adjacent.ODD, Borders.RIGHT_TOP);
			final Map<String, String> bottom = new LinkedHashMap<>();
			bottom.put(Adjacent.EVEN, Borders.BOTTOM_LEFT);
			bottom.put(Adjacent.ODD, Borders.LEFT_BOTTOM);
			borders.put(Adjacent.TOP, right);
			borders.put(Adjacent.BOTTOM, left);
			borders.put(Adjacent.RIGHT, top);
			borders.put(Adjacent.LEFT, bottom);
		}
	}

	/**
	 * The static class Neighbors.
	 */
	public static class Neighbors
	{

		/** The Constant BOTTOM_LEFT. */
		private static final String BOTTOM_LEFT = "14365h7k9dcfesgujnmqp0r2twvyx8zb";

		/** The Constant LEFT_BOTTOM. */
		private static final String LEFT_BOTTOM = "238967debc01fg45kmstqrwxuvhjyznp";

		/** The Constant neighbors. */
		public static final Map<String, Map<String, String>> neighbors = new LinkedHashMap<>();

		/** The Constant RIGHT_TOP. */
		private static final String RIGHT_TOP = "bc01fg45238967deuvhjyznpkmstqrwx";

		/** The Constant TOP_RIGHT. */
		private static final String TOP_RIGHT = "p0r21436x8zb9dcf5h7kjnmqesgutwvy";

		/**
		 * Initializes the neighbors map.
		 **/
		static
		{
			final Map<String, String> right = new LinkedHashMap<>();
			right.put(Adjacent.EVEN, Neighbors.RIGHT_TOP);
			right.put(Adjacent.ODD, Neighbors.TOP_RIGHT);
			final Map<String, String> left = new LinkedHashMap<>();
			left.put(Adjacent.EVEN, Neighbors.LEFT_BOTTOM);
			left.put(Adjacent.ODD, Neighbors.BOTTOM_LEFT);
			final Map<String, String> top = new LinkedHashMap<>();
			top.put(Adjacent.EVEN, Neighbors.TOP_RIGHT);
			top.put(Adjacent.ODD, Neighbors.RIGHT_TOP);
			final Map<String, String> bottom = new LinkedHashMap<>();
			bottom.put(Adjacent.EVEN, Neighbors.BOTTOM_LEFT);
			bottom.put(Adjacent.ODD, Neighbors.LEFT_BOTTOM);
			neighbors.put(Adjacent.TOP, right);
			neighbors.put(Adjacent.BOTTOM, left);
			neighbors.put(Adjacent.RIGHT, top);
			neighbors.put(Adjacent.LEFT, bottom);
		}
	}

	/** The Constant BOTTOM. */
	public static final String BOTTOM = "bottom";

	/** The Constant BOTTOM_BOTTOM. */
	public static final String BOTTOM_BOTTOM = "bottom_bottom";

	/** The Constant BOTTOM_LEFT. */
	public static final String BOTTOM_LEFT = "bottomleft";

	/** The Constant BOTTOM_LEFT_BOTTOM. */
	public static final String BOTTOM_LEFT_BOTTOM = "bottomleft_bottom";

	/** The Constant BOTTOM_LEFT_BOTTOM_LEFT. */
	public static final String BOTTOM_LEFT_BOTTOM_LEFT = "bottomleft_bottom_left";

	/** The Constant BOTTOM_LEFT_LEFT. */
	public static final String BOTTOM_LEFT_LEFT = "bottomleft_left";

	/** The Constant BOTTOM_RIGHT. */
	public static final String BOTTOM_RIGHT = "bottomright";

	/** The Constant BOTTOM_RIGHT_BOTTOM. */
	public static final String BOTTOM_RIGHT_BOTTOM = "bottomright_bottom";

	/** The Constant BOTTOM_RIGHT_BOTTOM_RIGHT. */
	public static final String BOTTOM_RIGHT_BOTTOM_RIGHT = "bottomright_bottom_right";

	/** The Constant BOTTOM_RIGHT_RIGHT. */
	public static final String BOTTOM_RIGHT_RIGHT = "bottomright_right";

	/** The Constant CENTER. */
	public static final String CENTER = "center";

	/** The Constant EVEN. */
	public static final String EVEN = "even";

	/** The Constant LEFT. */
	public static final String LEFT = "left";

	/** The Constant LEFT_LEFT. */
	public static final String LEFT_LEFT = "left_left";

	/** The Constant ODD. */
	public static final String ODD = "odd";

	/** The Constant RIGHT. */
	public static final String RIGHT = "right";

	/** The Constant RIGHT_RIGHT. */
	public static final String RIGHT_RIGHT = "right_right";

	/** The Constant TOP. */
	public static final String TOP = "top";

	/** The Constant TOP_LEFT. */
	public static final String TOP_LEFT = "topleft";

	/** The Constant TOP_LEFT_LEFT. */
	public static final String TOP_LEFT_LEFT = "topleft_left";

	/** The Constant TOP_LEFT_TOP. */
	public static final String TOP_LEFT_TOP = "topleft_top";

	/** The Constant TOP_LEFT_TOP_LEFT. */
	public static final String TOP_LEFT_TOP_LEFT = "topleft_top_left";

	/** The Constant TOP_RIGHT. */
	public static final String TOP_RIGHT = "topright";

	/** The Constant TOP_RIGHT_RIGHT. */
	public static final String TOP_RIGHT_RIGHT = "topright_right";

	/** The Constant TOP_RIGHT_TOP. */
	public static final String TOP_RIGHT_TOP = "topright_top";

	/** The Constant TOP_RIGHT_RIGHT_TOP. */
	public static final String TOP_RIGHT_TOP_RIGHT = "topright_top_right";

	/** The Constant TOP_TOP. */
	public static final String TOP_TOP = "top_top";

}