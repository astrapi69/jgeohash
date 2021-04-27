/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.jgeohash.geoip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.maxmind.geoip.LookupService;

import de.alpharogroup.lang.ClassExtensions;

/**
 * The class {@link LookupServiceSingleton} is a singleton class for the {@link LookupService}.<br>
 * <br>
 * Note: <br>
 * There have to be the file with the file name 'GeoLiteCity.dat' in the classpath for appropriate
 * work of the {@link LookupService}.
 */
public final class LookupServiceSingleton
{
	/** The single instance of the {@link LookupService}. */
	private static volatile LookupService instance;

	/** The constant for the file name prefix. */
	private static final String PREFIX = "GeoLiteCity";

	/** The Constant for the file name suffix. */
	private static final String SUFFIX = ".dat";

	/**
	 * Gets the single instance of the {@link LookupService}
	 *
	 * @return the single instance of the {@link LookupService}
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static LookupService getInstance() throws IOException
	{
		if (instance == null)
		{
			synchronized (LookupServiceSingleton.class)
			{ // double check...
				if (instance == null)
				{
					File fileLocation = null;
					final InputStream is = ClassExtensions.getResourceAsStream(PREFIX + SUFFIX);
					fileLocation = inputStreamToFile(is);
					instance = new LookupService(fileLocation, LookupService.GEOIP_MEMORY_CACHE);
				}
			}
		}
		return instance;
	}

	/**
	 * Creates a temporary file from the given {@link InputStream} object. Note: the created
	 * temporary file from the given {@link InputStream} object will be deleted on finish of the
	 * application.
	 *
	 * @param inputStream
	 *            the {@link InputStream} object
	 * @return the temporary file from the given {@link InputStream} object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static File inputStreamToFile(final InputStream inputStream) throws IOException
	{
		final File tempFile = File.createTempFile(PREFIX, SUFFIX);
		tempFile.deleteOnExit();
		final FileOutputStream out = new FileOutputStream(tempFile);
		IOUtils.copy(inputStream, out);
		return tempFile;
	}

	/**
	 * Private constructor.
	 */
	private LookupServiceSingleton()
	{
	}

}
