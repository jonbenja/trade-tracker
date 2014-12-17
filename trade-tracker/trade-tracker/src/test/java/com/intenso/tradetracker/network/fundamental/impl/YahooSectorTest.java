package com.intenso.tradetracker.network.fundamental.impl;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.intenso.tradetracker.model.Stock;
import com.intenso.tradetracker.network.fundamental.impl.YahooSector;

public class YahooSectorTest {

	private static Logger logger = LogManager.getLogger();

	private static Stock stock;
	private static YahooSector yahooSector;

	@BeforeClass
	public static void setUp() {
		yahooSector = new YahooSector();
		stock = new Stock("msft");
	}

	@Test
	public void getSectorTest() {

		String sector = yahooSector.getSector(stock);
		logger.debug("Sector: {}", sector);
		assertTrue("Bad sector", sector.equals("Technology"));

	}

	@Test
	public void getIndustryTest() {
		String industry = yahooSector.getIndustry(stock);
		logger.debug("Industry: {}", industry);
		assertTrue("Bad industry",
				industry.equals("Business Software & Services"));
	}
}
