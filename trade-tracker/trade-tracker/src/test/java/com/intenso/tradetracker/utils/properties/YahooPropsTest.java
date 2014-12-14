/**
 * 
 */
package com.intenso.tradetracker.utils.properties;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Jwright
 *
 */
public class YahooPropsTest {
	
	@Test
	public void getTest() {
		
		String value = YahooProps.get().get("keystats");
		
		assertNotNull(value);
		assertEquals(value,"https://uk.finance.yahoo.com/q/ks?s=");
	}
}
