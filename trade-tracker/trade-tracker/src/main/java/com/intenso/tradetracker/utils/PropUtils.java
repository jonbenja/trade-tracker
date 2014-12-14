package com.intenso.tradetracker.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtils {

		
	private static String location ="com/intenso/properties.";
	
	public static Properties get(String filename) throws IOException {
		
		String full = filename+".properties";
		
		InputStream is = PropUtils.class.getClassLoader().getResourceAsStream(full);
		Properties prop = new Properties();
		
		if (is != null) {
			prop.load(is);
		} else {
			throw new FileNotFoundException("property file '" + full + "' not found in the classpath");
		}
		
		return prop;
	}
}
