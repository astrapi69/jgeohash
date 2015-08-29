package de.alpharogroup.jgeohash.geoip;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import de.alpharogroup.jgeohash.GeoHashPoint;
import de.alpharogroup.jgeohash.api.Position;
import de.alpharogroup.jgeohash.distance.MeasuringUnit;


public class LocationUtilsTest
{

	@Test
	public void testSortByDistance()
	{
		final List<Position> geohashes = new ArrayList<>();
		geohashes.add(new GeoHashPoint("u0vf2w1s5tsy"));
		geohashes.add(new GeoHashPoint("u0t3z7cnznrx"));
		geohashes.add(new GeoHashPoint("u0td0v9xnz28"));
		final Position startPoint = new GeoHashPoint("u11fyhzqhp3c");

		LocationUtils.sortByDistance(startPoint, geohashes, MeasuringUnit.METER);
	}

	@Test
	public void testSortByDistanceInMeters()
	{
	}

}
