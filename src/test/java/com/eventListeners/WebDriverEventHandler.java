package com.eventListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.utility.Log;

public class WebDriverEventHandler implements WebDriverEventListener
{

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		 
//		System.out.println("About to change value of : " +arg0.toString());
		Log.info("About to change value of : " +arg0.toString());
	}
 
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		
 
//		System.out.println("Changed the value for : " + arg0.toString());
		Log.info("Changed the value for : " + arg0.toString());
	}
 
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		
//		System.out.println("About to click on the " + arg0.toString());
		Log.info("About to click on the " + arg0.toString());
	}
 
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		
//		System.out.println("inside method afterClickOn on " + arg0.toString());
		Log.info("inside method afterClickOn on " + arg0.toString());
	}
 
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		if (arg1 == null) {
//			System.out.println("Just before finding element: " + arg0.toString() + " on browser: " + arg2.toString() );
//			System.out.println("Just before finding element: " + arg0.toString());
			Log.info("Just before finding element: " + arg0.toString());
			
		} else {
//			System.out.println("Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
//			System.out.println("Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element");
			Log.info("Just before finding element: " + arg0.toString() + " inside " + arg1.toString() + " Web element");
		}
		
	}
 
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		if (arg1 == null) {
//			System.out.println("Found happened on element: " + arg0.toString() + " on browser: " + arg2.toString() );
//			System.out.println("Found happened on element: " + arg0.toString());
			Log.info("Found happened on element: " + arg0.toString());
			
		} else {
//			System.out.println("Found happened on element: " + arg0.toString() + " inside " + arg1.toString() + " Web element on browser: " + arg2.toString() );
//			System.out.println("Found happened on element: " + arg0.toString() + " inside " + arg1.toString() + " Web element");
			Log.info("Found happened on element: " + arg0.toString() + " inside " + arg1.toString() + " Web element");
		}
		
	}
 
	public void beforeNavigateBack(WebDriver arg0) {
		
//		System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
		Log.info("Just before beforeNavigateBack " + arg0.getCurrentUrl());
 
	}
 
	public void afterNavigateBack(WebDriver arg0) {
		
 
//		System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
		Log.info("Inside the after navigateback to " + arg0.getCurrentUrl());
	}
 
	public void beforeNavigateForward(WebDriver arg0) {
		
//		System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
		Log.info("Just before beforeNavigateForward " + arg0.getCurrentUrl());
 
	}
 
	public void afterNavigateForward(WebDriver arg0) {
		
//		System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
		Log.info("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
	}
 
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		
//		System.out.println("Just before beforeNavigateTo " + arg0);
		Log.info("Just before beforeNavigateTo " + arg0);
	}
  
	public void afterNavigateTo(String arg0, WebDriver arg1) {

//		System.out.println("Inside the afterNavigateTo to " + arg0);
		Log.info("Inside the afterNavigateTo to " + arg0);
	}
 
	public void beforeScript(String arg0, WebDriver arg1) {
		
//		System.out.println("Just before beforeScript " + arg0);
		Log.info("Just before beforeScript " + arg0);
	}

	public void afterScript(String arg0, WebDriver arg1) {
		
//		System.out.println("Inside the afterScript to, Script is " + arg0);
		Log.info("Inside the afterScript to, Script is " + arg0);
	}
 
	public void onException(Throwable arg0, WebDriver arg1) {
		
//		System.out.println("Exception occured at " + arg0.getMessage());
		Log.info("Exception occured at " + arg0.getMessage());
 
	}
}