jgeohash 
========
<a href="http://flattr.com/thing/4067696/astrapi69jgeohash-on-GitHub" target="_blank"><img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" /></a>

[![Build Status](https://travis-ci.org/astrapi69/jgeohash.svg?branch=master)](https://travis-ci.org/astrapi69/jgeohash)

An easy-to-implement library that can assist Java developers in using the GeoHash algorithm in order to create geocodes based on custom latitude and longitude values.

With the help of jGeohash, Java developers will be able to quickly and easily generate a geohash code using user-defined latitude and longitude values. By using the GeoHash algorithm, the space can be divided into multiple grid shapes.

This library is a basic implementation from the GeoHash algorithm written in the java and can be applied to generate from the latitude and longitude a geohash code and reverse. 

The library is kept simple and have no dependencies to other libraries.

Maven dependency
-------

Maven dependency is now on sonatype. 
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;quick~jgeohash) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import jgeohash:

Than you can add the dependency to your dependencies:

	<dependencies>
		<dependency>
			<groupId>de.alpharogroup</groupId>
			<artifactId>jgeohash</artifactId>
			<version>${jgeohash.version}</version>
		</dependency>	
	</dependencies>
	
License
-------

The source code is under the Apache License V2.0 as published by the Apache Foundation.

If you have suggestions or improvements of bugfixes please contribute back via github.

Want to Help?
-------

The source code for jGeohash are on GitHub. Please feel free to fork and send pull requests!

Examples
-------

See the wiki page.

Last changes
----------------------
Version 1.4.5
-------------
Gets the geohash from the given ip address
added dependency for geoip-api

Version 1.4.3
-------------
Extend functionality to calculate distance from two Points, Positions, coordinate values(latitude, longitude) or two geohash values in meters.
Created a new class for keeping data of the neighbors cells from the given geohash to cardinal directions for the first and second ring region.


Version 1.4.2
-------------
Added new interface Position for the class Point.

Created new class that calculates distance from two Points or two geohash values in km or miles.


Version 1.4.1
-------------

Added method to get getAdjacent from multiply directions.

Added functionality for get first and second ring neighbors from a geohash cell.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/astrapi69/jgeohash/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

