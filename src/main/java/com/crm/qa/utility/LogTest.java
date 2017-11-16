package com.crm.qa.utility;

import org.apache.log4j.Logger;

public class LogTest {

	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void startTestcase(String testName)
	{
		log.info("********************** Start "+testName+" Test Case**********************");
	}
	
	public static void endTestcase(String testName)
	{
		log.info("********************** Start "+testName+" Test Case**********************");
	}
	
	public static void infoMessage(String message)
	{
		log.info(message);
	}
	
	public static void warnMessage(String message)
	{
		log.warn(message);
	}
	
	public static void errorMessage(String message)
	{
		log.error(message);
	}
	
	public static void debugMessage(String message)
	{
		log.debug(message);
	}
	
	
}
