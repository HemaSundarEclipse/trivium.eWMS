package com.utility;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;

import com.eventListeners.WebDriverEventHandler;

public final class Configuration {
	
	private static WebDriver driver = null;
	private static WebDriverEventHandler handler;
	public EventFiringWebDriver eDriver;
	
	private static Configuration INSTANCE;
	private Configuration() throws InterruptedException {
		//Configuring FireFox Driver
				System.setProperty("webdriver.firefox.profile", "default");
				driver = new FirefoxDriver();
				
				//Configuring ChromeDriver
//						
//				System.setProperty("webdriver.chrome.driver","D:\\Hema\\Google Drive\\TestData\\Lib\\chromedriver.exe");
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("user-data-dir=C:\\Users\\hpenugonda\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
//				options.addArguments("--start-maximized");
//				driver = new ChromeDriver(options);
//				driver = new ChromeDriver();
				
				
				//Configuring WebDriverEventListener
				handler = new WebDriverEventHandler();
				eDriver = new EventFiringWebDriver(driver);
				eDriver.register(handler);	
			
//				eDriver.get("http://gmail.com/");
//				eDriver.get("http://localhost:9090/de.hvb.ewms");
//				eDriver.get("http://10.0.1.45:9090/ucebprime/");
				eDriver.get("http://10.0.1.48:9090/de.hvb.ewms/");
//				eDriver.get("http://10.0.1.46:9090/ucebprime/");
//				eDriver.get("http://10.0.1.47:9191/");
//				eDriver.get("http://10.0.1.45:9090/ucebprime/");
				Thread.sleep(30000);
				
//				 Waiting 30 seconds for an element to be present on the page, checking
//				    for its presence once every 5 seconds.
//				   Wait<WebDriver> wait = new FluentWait<WebDriver>(eDriver)
//				       .withTimeout(30, TimeUnit.SECONDS)
//				       .pollingEvery(5, TimeUnit.SECONDS)
//				       .ignoring(NoSuchElementException.class);
//		
//				   WebElement foo = wait.until(ExpectedConditions.visibilityOf(eDriver.findElement(By.id("metaNavigationAdminButtonRight_button"))));
				   
				   new FluentWait<WebDriver>(eDriver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class)
			       .until(ExpectedConditions.visibilityOf(eDriver.findElement(By.id("metaNavigationAdminButtonRight_button"))));
	}
	
	public static Configuration getInstance() throws InterruptedException {
		if( INSTANCE == null) {
			
			INSTANCE = new Configuration();
		}
		return INSTANCE;
	}

	@AfterClass
	public void afterClass() {
		eDriver.unregister(handler);
//		driver.close();
		driver.quit();
	}
}