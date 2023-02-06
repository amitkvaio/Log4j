package com.log4j.configuration;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JConfiguration {
	private static final Logger logger = Logger.getLogger(Log4JConfiguration.class);
	static {
		Properties props = new Properties();
		String commonUtilLoc = "D:\\My_Eclipse_Workspace\\Log4j\\00_Log4jProject\\src\\com\\propertiesFile\\commonUtil.properties";
		try {
			InputStream is = new FileInputStream(commonUtilLoc);
			props.load(is);
			String log4jConfigFileLoc = props
					.getProperty("LOG4J_PROPERTY_FILE_LOCATION");
			System.out.println("log4jConfigFileLoc:::::"+log4jConfigFileLoc);
			loadlog4jPropertiesFile(log4jConfigFileLoc);
			logger.info("log4j file has been successfully loaded!");
		} catch (IOException e) {
			logger.error(getStackTrace(e));
		}
	}
	
	//USED TO PRINT STACK TRACE OF AN EXCEPTION OBJECT MESSAGE
	public static String getStackTrace(Exception e) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		e.printStackTrace(pWriter);
		return sWriter.toString();
	}
	
	//USED TO PRINT STACK TRACE OF AN EXCEPTION OBJECT MESSAGE
	public static String anotherWay2PrintStackTrace(Exception ex) {
		CharArrayWriter cw = new CharArrayWriter();
		PrintWriter w = new PrintWriter(cw);
		ex.printStackTrace(w);
		w.close();
		String trace = cw.toString();
		return trace;
	}
	
	//USED FOR LOADING THE LOG4J PROPERTIES FILE
	public static void loadlog4jPropertiesFile(String log4jFileLoc) {
		Properties props = new Properties();
		try {
			InputStream is = new FileInputStream(log4jFileLoc);
			props.load(is);
			PropertyConfigurator.configure(props);
			logger.info(String
					.format("[log4j configuration file has been successfully uploaded][Log4j File Loc = %s]",
							log4jFileLoc));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		logger.debug("[main() has been started]");
		try {
			int str = Integer.parseInt("sdf");
			System.out.println("value of str==>"+str);
		} catch (NumberFormatException numFmtExp) {
			logger.error(getStackTrace(numFmtExp));
			logger.error(anotherWay2PrintStackTrace(numFmtExp));
		}
		logger.debug("[main() has been end]");
	}
}
