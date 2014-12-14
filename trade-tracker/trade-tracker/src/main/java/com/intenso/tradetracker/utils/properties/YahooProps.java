package com.intenso.tradetracker.utils.properties;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intenso.tradetracker.utils.PropUtils;

public class YahooProps implements PropertiesDAO {

	private static YahooProps instance;

	private static Logger logger = LogManager.getLogger();

	private Map<?, ?> data;
	
	private boolean loaded;

	private YahooProps() {
	}

	public static YahooProps get() {
		if (instance == null) {
			instance = new YahooProps();
		}
		return instance;
	}

	public boolean load() {
		try {
			data = PropUtils.get("yahoo");
			return true;
		} catch (IOException e) {
			logger.error("Couldn't load yahoo properties: {}", e);
			return false;
		}
	}

	public String get(String key) {
		
		if(!loaded)
			load();

		return (String) data.get(key);

	}

}
