# Overview

<div align="center">

[![build status](https://travis-ci.org/astrapi69/jgeohash.svg?branch=master)](https://travis-ci.org/astrapi69/jgeohash) 
[![coverage status](https://coveralls.io/repos/github/astrapi69/jgeohash/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/jgeohash?branch=develop)
[![open issues](https://img.shields.io/github/issues/astrapi69/jgeohash.svg?style=flat)](https://github.com/astrapi69/jgeohash/issues)
[![license apache2](https://img.shields.io/badge/license-apache2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

</div>

An easy-to-implement library that can assist Java developers in using the GeoHash algorithm in order to create geocodes based on custom latitude and longitude values.

With the help of jGeohash, Java developers will be able to quickly and easily generate a geohash code using user-defined latitude and longitude values. By using the GeoHash algorithm, the space can be divided into multiple grid shapes.

This library is a basic implementation from the GeoHash algorithm written in the java and can be applied to generate from the latitude and longitude a geohash code and reverse.

The library is kept simple and have no dependencies to other libraries.

## Key features:

1. Very small size (<30Kb)
2. Can get the adjacent geohash area from the given direction
3. Can get the geohash from an ip address
4. Can calculate distance between two geohash values in various measuring units like miles, km, meters
5. Can get the geohash cells around from the first, second or thrird ring from a given geohash cell

## License

The source code comes under the liberal Apache License V2.0, making jgeohash great for all types of applications.

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jgeohash-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jgeohash-core) jgeohash-core 

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jgeohash-geoip/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/jgeohash-geoip) jgeohash-geoip

## javadoc

[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jgeohash.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-core) jgeohash-core 

[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jgeohash.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-geoip) jgeohash-geoip 

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;quick~jgeohash) for latest snapshots and releases.

You can add the following maven dependencies to your project `pom.xml` if you want to import the library. 

You can first define the version properties:

	<properties>
		...
		<!-- JGEOHASH version -->
		<jgeohash.version>2.4.0</jgeohash.version>
		<jgeohash-core.version>${jgeohash.version}</jgeohash-core.version>
		<jgeohash-geoip.version>${jgeohash.version}</jgeohash-geoip.version>
		...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of jgeohash:

		<dependencies>
			...
            <!-- JGEOHASH-CORE DEPENDENCY -->
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>jgeohash-core</artifactId>
				<version>${jgeohash-core.version}</version>
			</dependency>
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the geoip functionality of jgeohash:

		<dependencies>
			...
            <!-- JGEOHASH-GEOIP DEPENDENCY -->
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>jgeohash-geoip</artifactId>
				<version>${jgeohash-geoip.version}</version>
			</dependency>
		</dependencies>

## Semantic Versioning

The versions of jgeohash are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning for this project you can visit this [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for jGeohash are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/jgeohash/fork](https://github.com/astrapi69/jgeohash/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/jgeohash/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the jgeohash developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/jgeohash/issues).

## Examples

  * [SpatialDataQueries][SpatialDataQueries]
  * [Simple-example][Simple-example]
  * [Hibernate-example][Hibernate-example]

   [SpatialDataQueries]: https://github.com/astrapi69/jgeohash/wiki/Adding-spatial-data-queries-to-Phoenix-on-HBase "Adding spatial data queries to Phoenix on HBase"
   [Simple-example]: https://github.com/astrapi69/jgeohash/wiki/Simple-example "Simple-example"
   [Hibernate-example]: https://github.com/astrapi69/jgeohash/wiki/Hibernate-example "Hibernate-example"
   
## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through paypal: <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" border="0" />
</a>

or over bitcoin or bitcoin-cash with:

1Jzso5h7U82QCNmgxxSCya1yUK7UVcSXsW

or over ether with:

0xaB6EaE10F352268B0CA672Dd6e999C86344D49D8

or over flattr:
  
<a href="http://flattr.com/thing/4067696/astrapi69jgeohash-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" />
</a>

## Similar projects

Here is a list of awesome projects that uses geohash:

 * [geohash-java](https://github.com/kungfoo/geohash-java) Another implementation of Geohashes in pure Java.
 * [geo](https://github.com/davidmoten/geo) Geohash utitlies in java 
 
## Blogs

 * [Designing a Spacial Index](https://dzone.com/articles/designing-spacial-index)
 
## Change log

The changelog is moved in its own file. It can be found on following [page](https://github.com/astrapi69/jgeohash/blob/develop/CHANGELOG.md)

## Credits

|Travis CI|
|:-:|
|![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png)|
|Many thanks to [Travis CI](https://travis-ci.org) for providing a free continuous integration service for open source projects.|