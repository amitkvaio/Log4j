package com.log4j.client;
import org.apache.log4j.Logger;

import com.log4j.configuration.Log4JConfiguration;

public class Log4JClient {
	private static final Logger logger = Logger.getLogger(Log4JClient.class);
	public static void main(String[] args) {
		Log4JConfiguration	conUtil = new Log4JConfiguration();
		logger.info("[main() has been started]");
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(5000);
				int str = Integer.parseInt("sdf");
				System.out.println("value of str==>"+str);
			} catch (NumberFormatException | InterruptedException numFmtExp) {
				logger.error(Log4JConfiguration.getStackTrace(numFmtExp));
				logger.error(Log4JConfiguration.anotherWay2PrintStackTrace(numFmtExp));
			}
		}
		logger.info("[main() has been end]");
	}
}
