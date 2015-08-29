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
		List<Position> geohashes = new ArrayList<>();
		geohashes.add(new GeoHashPoint("u0vf2w1s5tsy"));
		geohashes.add(new GeoHashPoint("u0t3z7cnznrx"));
		geohashes.add(new GeoHashPoint("u0td0v9xnz28"));
		Position startPoint = new GeoHashPoint("u11fyhzqhp3c");

		LocationUtils.sortByDistance(startPoint, geohashes, MeasuringUnit.METER);

		geohashes = new ArrayList<>();
		geohashes.add(new GeoHashPoint("u0z4")); // below Wuerzburg
		geohashes.add(new GeoHashPoint("u1p1")); // right from Bad Hersfeld
		geohashes.add(new GeoHashPoint("u28j")); // Ingolstadt
		geohashes.add(new GeoHashPoint("u0zc4wp0k")); // Nurremberg at work
		startPoint = new GeoHashPoint("u0ww"); // Ludwigsburg

		LocationUtils.sortByDistance(startPoint, geohashes, MeasuringUnit.METER);
	}

	@Test
	public void testSortByDistanceInMeters()
	{
	}

}
