package org.jgeohash.distance;
/**
 * The Enum MeasuringUnit.
 */
public enum MeasuringUnit {

	/** 
	 * The kilometer.
	 * 1.609344 is the number of kilometres in a mile
	 *  */
	KILOMETER(MeasuringUnit.KILOMETER_FACTOR),
		
	/** 
	 * The mile.
	 * 0.8684 is the factor for convert miles(statute) into miles (nautical).
	 * One nautical mile is the length of one minute of latitude at the equator.
	 **/
	MILE(MeasuringUnit.MILE_FACTOR);

	public static final double KILOMETER_FACTOR = 1.609344;
	public static final double MILE_FACTOR = 0.8684;
	
	/** The factor. */
	private final double factor;
	
	/**
	 * Gets the factor.
	 *
	 * @return the factor
	 */
	public double getFactor() {
		return factor;
	}
	
	/**
	 * Instantiates a new measuring unit.
	 *
	 * @param factor the factor
	 */
	private MeasuringUnit(double factor) {
		this.factor = factor;
	}
}