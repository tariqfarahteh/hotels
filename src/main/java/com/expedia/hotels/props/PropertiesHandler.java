package com.expedia.hotels.props;

import java.util.Properties;

import com.expedia.hotels.exception.BusinessException;

/**
 * 
 * This class is used to handle properties files operations.
 * 
 * @author Tariq
 */
public class PropertiesHandler {

	private static String EMPTY_STRING = "";

	/**
	 * Read property value from properties file
	 * 
	 * @param propsFile
	 *            : properties file that we need to read from
	 * @param propertyName
	 *            : key of property which we need it's value
	 * @author Tariq
	 * @throws BusinessException 
	 */
	public static String readproperty(Properties propsFile, String propertyName) throws BusinessException {
		if (propsFile == null) {
			throw new BusinessException("The properties file didn't load successfully to retrieve value for " + propertyName);
		}
		
		if (propsFile.containsKey(propertyName)) {
			return propsFile.getProperty(propertyName);
		}

		return EMPTY_STRING;
	}

}
