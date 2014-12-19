package com.intenso.tradetracker.network.fundamental.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import com.intenso.tradetracker.model.Stock;
import com.intenso.tradetracker.network.BaseHtmlParserAPI;
import com.intenso.tradetracker.network.fundamental.api.FundamentalsAPI;
import com.intenso.tradetracker.utils.properties.YahooProps;

public class YahooFundamentalsHtmlParser extends BaseHtmlParserAPI implements FundamentalsAPI {

	
	private static Logger logger = LogManager.getLogger();
	
	
	private String mcapBreak,tpeBreak,fpeBreak,pegBreak,psBreak,pbBreak,fpDateBreak;

	
	public YahooFundamentalsHtmlParser() {
		url = YahooProps.get().get("keystats");
		mcapBreak = YahooProps.get().get("mcapBreak");
		tpeBreak = YahooProps.get().get("tpeBreak");
		fpeBreak = YahooProps.get().get("fpeBreak");
		pegBreak = YahooProps.get().get("pegBreak");
		psBreak = YahooProps.get().get("psBreak");
		pbBreak = YahooProps.get().get("pbBreak");
		fpDateBreak = YahooProps.get().get("fpDateBreak");
		
	}
	public float getMarketCap(Stock stock) {
		
		mcapBreak = mcapBreak.replaceAll("CODE", stock.getCode());
		String mcapString = getValueTD(stock,mcapBreak);
		
					
		String mult = mcapString.substring(mcapString.length() - 1);
		
		mcapString = mcapString.replaceAll(mult, "");
		
		float value = getFloatFromString(mcapString,"Bad Market Cap: ");
		
		if (mult.equals("b"))
			value*=1000000000;
		else if (mult.equals("m"))
			value*=1000000;
		
		return value;
	}

	public float getTrailingPE(Stock stock) {
		
		String tpeString = getValueTD(stock,tpeBreak);
		return getFloatFromString(tpeString,"Bad TPE: ");
	}
	
	public float getForwardPE(Stock stock) {
		String fpeString = getValueTD(stock,fpeBreak);
		return getFloatFromString(fpeString,"Bad FPE: ");
	}

	@SuppressWarnings("deprecation")
	public DateTime getForwardPEDate(Stock stock) {
		
		String dateString = getValueBracket(stock,fpDateBreak);
		
		
		String dformat = "MMM";
		logger.debug("datesting: {}",dateString);
		DateFormat df2 = new SimpleDateFormat(dformat); 
		try {
			String[] datesArr = dateString.split(" ");
			Date date =  df2.parse(datesArr[1]);
			int day = Integer.valueOf(datesArr[0]);
			int year = Integer.valueOf(datesArr[2]);
			
			return new DateTime(year,date.getMonth()+1,day,0,0);
			
		} catch (ParseException e) {
			logger.error(e);
			throw new RuntimeException("BAD FPE Date: "+ e);
		}
		
	}

	public float getPEGRatio(Stock stock) {
		String fpeString = getValueTD(stock,pegBreak);
		return getFloatFromString(fpeString,"Bad PEG: ");
	}

	public float getPriceSales(Stock stock) {
		String fpeString = getValueTD(stock,psBreak);
		return getFloatFromString(fpeString,"Bad Price Sales: ");
	}

	public float getPriceBook(Stock stock) {
		String fpeString = getValueTD(stock,pbBreak);
		return getFloatFromString(fpeString,"Bad Price Book: ");
	}

	private float getFloatFromString(String string,String errorMsg) {
		float value =-1;
		try {
			value = Float.valueOf(string);
		}catch(Exception e) {
			throw new RuntimeException(errorMsg +" " +  e);
		}
		return value;
	}
	
	
	
}
