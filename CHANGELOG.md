
## Change log
----------------------

Version 2.7-SNAPSHOT
-------------

Version 2.6
-------------

ADDED:

- gradle as build system
- new barcode images for several crypto addresses

CHANGED:

- removed maven related files
- changed project nature from maven to gradle nature
- update of jcommons-lang version to 5.2.2
- update of test-objects version to 5.3
- update of silly-collections version to 8.4
- dependency jobject-evaluate replaced with jobj-contract-verifier
- new launch scripts for ide intellij created

Version 2.5.2
-------------

CHANGED:

- update of parent version to 4.4
- update of jcommons-lang version to 5.1
- update of jobject-extensions version to 2.5
- update of silly-collections version to 5
- update of silly-collections version to 5
- update of dependency test-objects version to 5
- removed exclusions from dependency jcommons-lang

Version 2.5.1
-------------

CHANGED:

- update of parent version to 4.2
- update of jcommons-lang version to 5
- update of jobject-extensions version to 2.3
- update of silly-collections version to 4.35
- moved dependencies from parent to the specific jgeohash-geoip project
- added exclusions to unneeded transitive dependencies from dependency jcommons-lang

Version 2.5
-------------

ADDED: 

- new test dependency of test-objects
- new test dependency of silly-collections

CHANGED:

- update of parent version to 3.11
- removed unneeded .0 at the end of version
- unit tests extended for improve code coverage

Version 2.4.0
-------------

ADDED: 

- Note section added

CHANGED:

- update of java parent version
- moved changelog to its own file

Version 2.3.0
-------------
- Created new module projects. jgeohash-core and jgeohash-geoip

Version 2.0.0
-------------
- JDK version upgraded to version 8.

Version 1.4.6
-------------
- Added project to sonatype repository.
- Added project to continous integration: https://travis-ci.org/astrapi69/jgeohash
- Added project to flattr.com: https://flattr.com/thing/4067696/astrapi69jgeohash-on-GitHub

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


