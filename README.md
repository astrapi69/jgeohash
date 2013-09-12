jgeohash
========

An easy-to-implement library that can assist Java developers in using the GeoHash algorithm in order to create geocodes based on custom latitude and longitude values.

With the help of jGeohash, Java developers will be able to quickly and easily generate a geohash code using user-defined latitude and longitude values. By using the GeoHash algorithm, the space can be divided into multiple grid shapes.

This library is a basic implementation from the GeoHash algorithm written in the java and can be applied to generate from the latitude and longitude a geohash code and reverse. 

The library is kept simple and have no dependencies to other libraries.

License
-------

The source code is under the Apache License V2.0 as published by the Apache Foundation.

If you have suggestions or improvements of bugfixes please contribute back via github.

Examples
-------

See the wiki page.

Last changes
----------------------

Version 1.4.2
-------------
Added new interface Position for the class Point.

Created new class that calculates distance from two Points or two geohash values in km or miles.


Version 1.4.1
-------------

Added method to get getAdjacent from multiply directions.

Added functionality for get first and second ring neighbors from a geohash cell.
