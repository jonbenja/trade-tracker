package com.intenso.tradetracker.network;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intenso.tradetracker.model.Stock;
import com.intenso.tradetracker.utils.NetworkUtils;
import com.intenso.tradetracker.utils.PropUtils;



public class YahooSectorImpl implements SectorAPI {

	private static Logger logger = LogManager.getLogger();
	private static String url;// = "https://uk.finance.yahoo.com/q/in?s=";
	
	private static String sectorBreak = "Sector:</th><td nowrap class=\"yfnc_tabledata1\">";
	private static String industryBreak = "Industry:</th><td nowrap class=\"yfnc_tabledata1\">";
	
	private String cachedHtml = null;
	private String cachedCode = null;
	
	public String getSector(Stock stock) {
		return get(stock,sectorBreak);
	}

	public String getIndustry(Stock stock) {
		return get(stock,industryBreak);
	}
	
	private String get(Stock stock,String split) {
		try {
			String html = getHtml(stock);
			return html.split(split)[1].split("</td>")[0];
		} catch (Exception e) {
			logger.error(e);
		}
		return "Error gettting data";
	}
	
	private String getHtml(Stock stock) throws UnsupportedEncodingException, IOException {
		
		url = PropUtils.get("yahoo").getProperty("industry");
		
		if (!stock.getCode().equalsIgnoreCase(cachedCode)) {
			logger.trace("getting new data");
			cachedCode = stock.getCode();
			cachedHtml = NetworkUtils.webToString(url+cachedCode.toUpperCase());
		}else {
			logger.trace("using cached data");
		}
		return StringEscapeUtils.unescapeHtml4(cachedHtml);
	}

}
