package mains;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {

	
	private static Logger logger = LogManager.getLogger();
	
	public static void main(String args[]) {
		logger.debug("hello world");
		logger.trace("trace world");
	}
}
