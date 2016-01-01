package de.alpharogroup.jgeohash.geoip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.maxmind.geoip.LookupService;

import de.alpharogroup.lang.ClassExtensions;

/**
 * The class {@link LookupServiceSingleton} is a singleton class for the {@link LookupService}.
 */
public final class LookupServiceSingleton
{
	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(LookupServiceSingleton.class.getName());

	/** The single instance of the {@link LookupService}. */
	private static LookupService instance;

	/** The constant for the file name prefix. */
	private static final String PREFIX = "GeoLiteCity";

	/** The Constant for the file name suffix. */
	private static final String SUFFIX = ".dat";

	/**
	 * Private constructor.
	 */
	private LookupServiceSingleton()
	{
	}

	/**
	 * Gets the single instance of the {@link LookupService}.
	 *
	 * @return the single instance of the {@link LookupService}.
	 */
	public static synchronized LookupService getInstance()
	{
		if (instance == null)
		{
			synchronized (LookupServiceSingleton.class)
			{
				File fileLocation = null;
				final InputStream is = ClassExtensions.getResourceAsStream(PREFIX + SUFFIX);
				try
				{
					fileLocation = inputStreamToFile(is);
					instance = new LookupService(fileLocation, LookupService.GEOIP_MEMORY_CACHE);
				}
				catch (final IOException e)
				{
					LOGGER.error("IOException in the initialization of the LookupService.", e);
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

}