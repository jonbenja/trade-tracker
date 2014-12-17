package com.intenso.tradetracker.network.fundamental.api;

import org.joda.time.DateTime;

import com.intenso.tradetracker.model.Stock;

/**
 * @author Jwright
 *	Get market fundamental statistics from a given stock.
 */
public interface FundamentalsAPI {

	
	public float getMarketCap(Stock stock);
	
	public float getTrailingPE(Stock stock);
	
	public float getForwardPE(Stock stock);
	
	public DateTime getForwardPEDate(Stock stock);
	
	public float getPEGRatio(Stock stock);
	
	public float getPriceSales(Stock stock);
	
	public float getPriceBook(Stock stock);
	
	
}
