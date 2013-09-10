jgeohash
========

An easy-to-implement library that can assist Java developers in using the GeoHash algorithm in order to create geocodes based on custom latitude and longitude values.

With the help of jGeohash, software developers will be able to quickly and easily generate a geohash code using user-defined latitude and longitude values. By using the GeoHash algorithm, the space can be divided into multiple grid shapes.

This library is a basic implementation from the GeoHash algorithm written in the java can be used to generate from the latitude and longitude a geohash code and reverse. 

The library is kept simple and have no dependencies to other libraries.

License
-------

The source code is under the Apache License V2.0 as published by the Apache Foundation.

If you have suggestions or improvements of bugfixes please contribute back via github.

Examples
-------

Lets see a simple example:

If we have an address like

'Hauptbahnhof, Hamburg' resolves to the latitude and longitude:

53.5526394, 10.0067103

This we can use than to calculate the geohash code like this:

...
String geohash = GeoHashUtils.encode(53.5526394, 10.0067103);
double \[\] decoded = GeoHashUtils.decode(geohash);

System.out.println("geohash:"+geohash);
System.out.println(decoded\[0\]+ ", "+ decoded\[1\]);
...
Output:
geohash:u1x0esywtr81
53.55263943783939, 10.006710458546877

As we can see we can reverse this process too with the method GeoHashUtils.decode(geohash).

More interesting it gets if you like to find the neigbors regions from one geohash point. There are 2 methods to get this information:

...

geohash = geohash.substring(0, 7);

Map<String, String> adjacentAreas = GeoHashUtils.getAllAdjacentAreasMap(geohash);

System.out.println(adjacentAreas);

System.out.println("=======================================");

List<String> aa = GeoHashUtils.getAllAdjacentAreasList(geohash);

System.out.println(aa);

...

Output:

{center=u1x0esy, top=u1x0esz, bottom=u1x0esv, right=u1x0etn, left=u1x0esw, topleft=u1x0esx, topright=u1x0etp, bottomright=u1x0etj, bottomleft=u1x0est}

=======================================

\[u1x0esy, u1x0esz, u1x0etp, u1x0etn, u1x0etj, u1x0esv, u1x0est, u1x0esw, u1x0esx\]

So the geohash from the given address is:
'u1x0esywtr81'. 

To get a box around this point we can truncate this geohash to:
'u1x0esy'

So if you have an database table 'addresses' in this structure:

CREATE TABLE addresses (
  id int(11) NOT NULL,
  street varchar(64) DEFAULT NULL,  /* The name of the street. */
  streetnumber varchar(5) DEFAULT NULL,  /* The streetnumber. */
  address_comment varchar(100) DEFAULT NULL,  /* The address comment. */
  latitude decimal(7,7) DEFAULT NULL,  /* The latitude from the address. */
  longitude decimal(7,7) DEFAULT NULL,  /* The longitude from the address. */
  geohash varchar(12) DEFAULT NULL,  /* The geohash from this address. */
) ;

you can search in the table 'addresses' with this select statement:

SELECT * FROM addresses 
WHERE LEFT(geohash,7) IN 
('u1x0esy', 'u1x0esz', 'u1x0etp', 'u1x0etn', 'u1x0etj', 'u1x0esv', 'u1x0est', 'u1x0esw, 'u1x0esx');

This statement gives all addresses that match with the given geohash codes in the 'in clause'. 

