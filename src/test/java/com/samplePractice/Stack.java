package com.samplePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Stack {

	static WebDriver driver;
	@BeforeClass
	public static void setup() {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    driver.get(baseUrl + "login");
	    driver.get("http://google.com");
//	    driver.findElement(By.id("username")).sendKeys("myUserName");
//	    driver.findElement(By.id("password")).sendKeys("myPassword"); 
//	    driver.findElement(By.id("loginBTN")).click();
	}
	
	@Test
	public void firstTest() {
	    //myTestCode
		System.out.println("Test1");
	}
}
