package com.intenso.tradetracker.network.fundamental.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intenso.tradetracker.model.Stock;
import com.intenso.tradetracker.network.BaseHtmlParserAPI;
import com.intenso.tradetracker.network.fundamental.api.SectorAPI;
import com.intenso.tradetracker.utils.properties.YahooProps;



public class YahooSector extends BaseHtmlParserAPI implements SectorAPI {

	private static final Logger logger = LogManager.getLogger();
	
	
	private String sectorBreak;
	private String industryBreak;
	
	
	public YahooSector() {
		sectorBreak = YahooProps.get().get("sectorBreak");
		industryBreak = YahooProps.get().get("industryBreak");
		url = YahooProps.get().get("industry");
	}
	
	public String getSector(Stock stock) {
		return getValueTD(stock,sectorBreak);
	}

	public String getIndustry(Stock stock) {
		return getValueTD(stock,industryBreak);
	}
	

	


}
