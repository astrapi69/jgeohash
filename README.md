# Overview
<div style="text-align: center">

[![build status](https://travis-ci.com/astrapi69/jgeohash.svg?branch=master)](https://travis-ci.com/astrapi69/jgeohash)
[![Java CI build and test](https://github.com/astrapi69/jgeohash/actions/workflows/build-test.yml/badge.svg)](https://github.com/astrapi69/jgeohash/actions/workflows/build-test.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/jgeohash/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/jgeohash)
[![Coverage Status](https://coveralls.io/repos/github/astrapi69/jgeohash/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/jgeohash?branch=develop)
[![open issues](https://img.shields.io/github/issues/astrapi69/jgeohash.svg?style=flat)](https://github.com/astrapi69/jgeohash/issues)
[![license apache2](https://img.shields.io/badge/license-apache2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

</div>

An easy-to-implement library that can assist Java developers in using the [GeoHash](https://en.wikipedia.org/wiki/Geohash) algorithm in order to create geocodes based on custom latitude and longitude values.

With the help of jGeohash, Java developers will be able to quickly and easily generate a geohash code using user-defined latitude and longitude values. By using the GeoHash algorithm, the space can be divided into multiple grid shapes.

This library is a basic implementation from the GeoHash algorithm written in the java and can be applied to generate from the latitude and longitude a geohash code and reverse.

The library is kept simple and have no dependencies to other libraries.


> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
                                                         <a class="github-button" href="https://github.com/astrapi69/jgeohash" data-icon="octicon-star" aria-label="Star astrapi69/jgeohash on GitHub">Star ⭐</a>. Share this library with friends on Twitter and everywhere else you can.
If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
   
## Note

No animals were harmed in the making of this library.

# Donations

This project is kept as an open source product and relies on contributions to remain being
developed. If you like this library, please consider a donation

over paypal: <br><br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" style="border: none" />
</a>
<br><br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png" 
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png" 
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png" 
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png" 
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png" 
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png" 
alt="Donation Monero Wallet" width="250"/>

or over flattr:
  
<a href="http://flattr.com/thing/4067696/astrapi69jgeohash-on-GitHub" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this"  style="border: none" />
</a>

## Key features:

1. Very small size (<35Kb)
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

## javadoc

jgeohash-core [![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jgeohash.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-core)

jgeohash-geoip [![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/jgeohash.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-geoip)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;quick~jgeohash) for latest snapshots and releases.

You can add the following maven dependencies to your project `pom.xml` if you want to import the library. 

You can first define the version properties:

	<properties>
		...
		<!-- JGEOHASH version -->
		<jgeohash.version>2.5.2</jgeohash.version>
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


## Similar projects

Here is a list of awesome projects that uses geohash:

 * [geohash-java](https://github.com/kungfoo/geohash-java) Another implementation of Geohashes in pure Java.
 * [geo](https://github.com/davidmoten/geo) Geohash utitlies in java 
 
## Blogs

 * [Designing a Spacial Index](https://dzone.com/articles/designing-spacial-index)
 
## Useful links

* [geohash.org browser](http://geohash.org/)
* [alternative geohash browser](https://www.movable-type.co.uk/scripts/geohash.html)
 
## Change log

The changelog is moved in its own file. It can be found on following [page](https://github.com/astrapi69/jgeohash/blob/develop/CHANGELOG.md)

## Credits

|**Travis CI**|
|     :---:      |
|![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png) <img width=500/>|
|[![build status](https://travis-ci.com/astrapi69/jgeohash.svg?branch=master)](https://travis-ci.com/astrapi69/jgeohash) |
|Special thanks to [Travis CI](https://travis-ci.com) for providing a free continuous integration service for open source projects|
|     <img width=1000/>     |

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/jgeohash-core.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~jgeohash-core~~~) jgeohash-core|
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/jgeohash-geoip.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~jgeohash-geoip~~~) jgeohash-geoip|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**coveralls.io**|
|     :---:      |
|[![Coverage Status](https://coveralls.io/repos/github/astrapi69/jgeohash/badge.svg?branch=develop)](https://coveralls.io/github/astrapi69/jgeohash?branch=master)|
|Special thanks to [coveralls.io](https://coveralls.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/jgeohash-core.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-core) jgeohash-core|
|[![Javadoc](http://www.javadoc.io/badge/de.alpharogroup/jgeohash-geoip.svg)](http://www.javadoc.io/doc/de.alpharogroup/jgeohash-geoip) jgeohash-geoip|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
