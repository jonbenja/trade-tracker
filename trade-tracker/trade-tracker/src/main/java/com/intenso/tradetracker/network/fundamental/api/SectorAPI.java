package com.intenso.tradetracker.network.fundamental.api;

import com.intenso.tradetracker.model.Stock;

public interface SectorAPI {

	
	public String getSector(Stock stock);
	
	public String getIndustry(Stock stock);
	
	
}
