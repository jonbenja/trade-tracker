package com.intenso.tradetracker.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import com.intenso.tradetracker.model.Stock;

public class YahooFundamentals implements FundamentalsAPI {

	
	private static Logger logger = LogManager.getLogger();
	

	public int getMarketCap(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getTrailingPE(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getForwardPE(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	public DateTime getForwardPEDate(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	public float getPEGRatio(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getPriceSales(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	public float getPriceBook(Stock stock) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
}
