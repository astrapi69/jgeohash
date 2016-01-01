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