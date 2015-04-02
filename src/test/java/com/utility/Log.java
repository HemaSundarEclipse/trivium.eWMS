package com.utility;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Log {
	// Initialize Log4j logs
	private static Logger Log = Logger.getLogger(Log.class.getName());	 

//	public void configureManually() {
//		
//		//Defining logger object
//		Log = LogManager.getLogger("log1");
//		BasicConfigurator.configure();
//		//Defining Appender
//		FileAppender fa = new FileAppender();
//		fa.setFile("log.log");
//		fa.setLayout(new SimpleLayout());
//		//Linking Appender & logger object
//		Log.addAppender(fa);
//		fa.activateOptions();	
//		Log.info("Beforeclass done");
//	}
	static
	{
		DOMConfigurator.configure("log4j.xml");
	}
		 
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName){
	 
		Log.info("****************************************************************************************");
	 
		Log.info("****************************************************************************************");
	 
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	 
		Log.info("****************************************************************************************");
	 
		Log.info("****************************************************************************************");
	 
		}
	 
		//This is to print log for the ending of the test case
	 
	public static void endTestCase(String sTestCaseName){
	 
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		Log.info("X");
	 
		}
	 
		// Need to create these methods, so that they can be called  
	 
	public static void info(String message) {
		 
			Log.info(message);
	 
			}
	 
	public static void warn(String message) {
	    Log.warn(message); 
		}
	 
	 public static void error(String message) {
	 
	    Log.error(message);
	 
		}
	 
	 public static void fatal(String message) {
	 
	    Log.fatal(message);
	 
		}
	 
	 public static void debug(String message) {
	 
	    Log.debug(message);
	 
		}
	 
}