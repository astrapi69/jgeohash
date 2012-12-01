/**
 * Copyright (C) 2011 Asterios Raptis
 *
 * This program is open source software; you can redistribute it and/or modify
 * it under the terms of the Apache License V2.0 as published by
 * the Apache Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 */
package org.jgeohash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The class Adjacent.
 */
public abstract class Adjacent {

    /**
     * The static class Borders.
     */
    public static class Borders {

        /** The Constant BOTTOM_LEFT. */
        private static final String BOTTOM_LEFT = "028b";

        /** The Constant LEFT_BOTTOM. */
        private static final String LEFT_BOTTOM = "0145hjnp";

        /** The Constant TOP_RIGHT. */
        private static final String TOP_RIGHT = "prxz";

        /** The Constant RIGHT_TOP. */
        private static final String RIGHT_TOP = "bcfguvyz";

        /** The Constant borders. */
        public static final Map<String, Map<String, String>> borders = new LinkedHashMap<String, Map<String, String>>();

        static {
            Map<String, String> right = new LinkedHashMap<String, String>();
            right.put(Adjacent.EVEN, Borders.RIGHT_TOP);
            right.put(Adjacent.ODD, Borders.TOP_RIGHT);
            Map<String, String> left = new LinkedHashMap<String, String>();
            left.put(Adjacent.EVEN, Borders.LEFT_BOTTOM);
            left.put(Adjacent.ODD, Borders.BOTTOM_LEFT);
            Map<String, String> top = new LinkedHashMap<String, String>();
            top.put(Adjacent.EVEN, Borders.TOP_RIGHT);
            top.put(Adjacent.ODD, Borders.RIGHT_TOP);
            Map<String, String> bottom = new LinkedHashMap<String, String>();
            bottom.put(Adjacent.EVEN, Borders.BOTTOM_LEFT);
            bottom.put(Adjacent.ODD, Borders.LEFT_BOTTOM);
            borders.put(Adjacent.RIGHT, right);
            borders.put(Adjacent.LEFT, left);
            borders.put(Adjacent.TOP, top);
            borders.put(Adjacent.BOTTOM, bottom);
        }
    }

    /**
     * The static class Neighbors.
     */
    public static class Neighbors {

        /** The Constant BOTTOM_LEFT. */
        private static final String BOTTOM_LEFT = "14365h7k9dcfesgujnmqp0r2twvyx8zb";

        /** The Constant TOP_RIGHT. */
        private static final String TOP_RIGHT = "p0r21436x8zb9dcf5h7kjnmqesgutwvy";

        /** The Constant LEFT_BOTTOM. */
        private static final String LEFT_BOTTOM = "238967debc01fg45kmstqrwxuvhjyznp";

        /** The Constant RIGHT_TOP. */
        private static final String RIGHT_TOP = "bc01fg45238967deuvhjyznpkmstqrwx";

        /** The Constant neighbors. */
        public static final Map<String, Map<String, String>> neighbors = new LinkedHashMap<String, Map<String, String>>();

        static {
            Map<String, String> right = new LinkedHashMap<String, String>();
            right.put(Adjacent.EVEN, Neighbors.RIGHT_TOP);
            right.put(Adjacent.ODD, Neighbors.TOP_RIGHT);
            Map<String, String> left = new LinkedHashMap<String, String>();
            left.put(Adjacent.EVEN, Neighbors.LEFT_BOTTOM);
            left.put(Adjacent.ODD, Neighbors.BOTTOM_LEFT);
            Map<String, String> top = new LinkedHashMap<String, String>();
            top.put(Adjacent.EVEN, Neighbors.TOP_RIGHT);
            top.put(Adjacent.ODD, Neighbors.RIGHT_TOP);
            Map<String, String> bottom = new LinkedHashMap<String, String>();
            bottom.put(Adjacent.EVEN, Neighbors.BOTTOM_LEFT);
            bottom.put(Adjacent.ODD, Neighbors.LEFT_BOTTOM);
            neighbors.put(Adjacent.RIGHT, right);
            neighbors.put(Adjacent.LEFT, left);
            neighbors.put(Adjacent.TOP, top);
            neighbors.put(Adjacent.BOTTOM, bottom);
        }
    }

    /** The Constant BOTTOM. */
    public static final String BOTTOM = "bottom";

    /** The Constant TOP. */
    public static final String TOP = "top";

    /** The Constant LEFT. */
    public static final String LEFT = "left";

    /** The Constant RIGHT. */
    public static final String RIGHT = "right";

    /** The Constant EVEN. */
    public static final String EVEN = "even";

    /** The Constant ODD. */
    public static final String ODD = "odd";

    /** The Constant TOP_LEFT. */
    public static final String TOP_LEFT = "topleft";

    /** The Constant TOP_RIGHT. */
    public static final String TOP_RIGHT = "topright";

    /** The Constant BOTTOM_LEFT. */
    public static final String BOTTOM_LEFT = "bottomleft";

    /** The Constant BOTTOM_RIGHT. */
    public static final String BOTTOM_RIGHT = "bottomright";

    /** The Constant CENTER. */
    public static final String CENTER = "center";

}
