package com.intenso.tradetracker.network.fundamental.api;

import com.intenso.tradetracker.model.Stock;

/**
 * @author Jwright
 *
 *         Pulls price history and information without having to perform
 *         calculations on the data
 */
public interface PriceHistoryAPI {

	public float get52wkChangePct(Stock stock);

	public float get52wkChangePctVsSPY(Stock stock);

	public float get52wkHigh(Stock stock);

	public float get52wkLow(Stock stock);

	public float getSMA50(Stock stock);

	public float getSMA200(Stock stock);

	public int get3MonthAvgVol(Stock stock);

	public int get10DayAvgVol(Stock stock);

}
