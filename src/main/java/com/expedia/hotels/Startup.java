package com.expedia.hotels;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;

import com.expedia.hotels.exception.BusinessException;

/**
 * 
 * This is a Startup class called once on staring the system. This class used to
 * load the properties file.
 * 
 * @author Tariq
 */
public class Startup {
	public static Properties configProp;

	/**
	 * 
	 * Default constructor to load the Log file and config.properties file.
	 * 
	 * @author Tariq
	 * @throws BusinessException 
	 */
	public static void init() throws BusinessException {

		BasicConfigurator.configure();

		configProp = new Properties();
		InputStream input = null;
		try {

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("config.properties");
			if (input != null) {
				configProp.load(input);
			} else {
				throw new BusinessException("The config file didn't load successfully");
			}
		} catch (IOException e) {
			configProp = null;
			Log.error(Startup.class, e.getStackTrace().toString());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					Log.error(Startup.class, e.getStackTrace().toString());
				}
			}
		}
	}
}
