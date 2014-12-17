package com.intenso.tradetracker.network.fundamental.api;

import org.joda.time.DateTime;

import com.intenso.tradetracker.model.Stock;

/**
 * @author Jwright
 *
 *	Get balance sheet statistics of a given stock
 */
public interface BalanceSheetAPI {
	
	static final String url = "https://uk.finance.yahoo.com/q/ks?s=";

	// Fiscal Year
	
	public DateTime getFiscalYearEnd(Stock stock);
	
	public DateTime getMostRecentQuater(Stock stock);
	
	// Profitability
	
	public float getProfitMargin(Stock stock);
	
	public float getOperatingMargin(Stock stock);
	
	// Managemnt Effectiveness
	
	
	public float getReturnOnAssets(Stock stock);
	
	public float getReturnOnEquity(Stock stock);
	
	// Income Statement
	
	public float getRevenue(Stock stock);
	
	public float getQrtlyRevenueGrowthPct(Stock stock);
	
	public int getGrossProfit(Stock stock);
	
	// Balance Sheet
	public int getTotalCash(Stock stock);
	
	public int getTotalDebt(Stock stock);
	
	public float getDebtEquityRatio(Stock stock);
	
	// Cash Flow
	
	public int getOperatingCashFlow(Stock stock);
	
	public int getLeveredCashFlow(Stock stock);
	
	
	
}
