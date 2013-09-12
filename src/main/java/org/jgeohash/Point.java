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

import org.jgeohash.api.Position;

/**
 * The Class Point represents a point on earth with the latitude and longitude.
 */
public class Point implements Comparable<Point>, Cloneable, Position {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = -4799959551221362673L;

	/** The latitude. */
	private double latitude;

	/** The longitude. */
	private double longitude;

	/**
	 * Instantiates a new point.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	public Point(final double latitude, final double longitude) {
		if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180) {
			throw new IllegalArgumentException("The given coordinates " + this.toString() + " are out of range.");
		}
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object clone() {
		Position inst = new Point(this.latitude, this.longitude);
		return inst;
	}

	/**
	 * {@inheritDoc}
	 */
	public int compareTo(final Point other) {
		if ( this == other ) {
			return 0;
		}
		if(this.latitude < other.latitude) {
			return -1;
		}
		if(this.latitude > other.latitude) {
			return 1;
		}
		if(this.longitude < other.longitude) {
			return -1;
		}
		if(this.longitude > other.longitude) {
			return 1;
		}
		//all comparisons have yielded equality
	    //verify that compareTo is consistent with equals (optional)
	    assert this.equals(other) : "compareTo inconsistent with equals.";
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != getClass()) {
			return false;
		}
		Point castedObj = (Point) o;
		return ((this.latitude == castedObj.latitude) && (this.longitude == castedObj.longitude));
	}

	/**
	 * {@inheritDoc}
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * {@inheritDoc}
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31
			* hashCode
			+ (int) (+serialVersionUID ^ (serialVersionUID >>> 32));
		hashCode = 31
			* hashCode
			+ (int) (Double.doubleToLongBits(latitude) ^ (Double
				.doubleToLongBits(latitude) >>> 32));
		hashCode = 31
			* hashCode
			+ (int) (Double.doubleToLongBits(longitude) ^ (Double
				.doubleToLongBits(longitude) >>> 32));
		return hashCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLatitude(final double latitude) {
		if (Math.abs(latitude) > 90 ) {
			throw new IllegalArgumentException("The given coordinates for latitude " + latitude + " are out of range.");
		}
		this.latitude = latitude;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLongitude(final double longitude) {
		if (Math.abs(longitude) > 180) {
			throw new IllegalArgumentException("The given coordinates for longitude " + longitude + " are out of range.");
		}
		this.longitude = longitude;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Latitude : " + latitude + "   Longitude  : " + longitude;
	}

}
