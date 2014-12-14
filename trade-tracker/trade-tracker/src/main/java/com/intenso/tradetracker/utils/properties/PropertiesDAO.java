package com.intenso.tradetracker.utils.properties;

/**
 * @author Jwright
 *
 *Enables loading and access of a properties file
 */
public interface PropertiesDAO {

	public boolean load();
	
	public String get(String key);
	
}
