package com.samplePractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Goa 
{
	WebDriver driver;
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.134.102:8080/");
		Thread.sleep(40000);
	}
	@Test
	public void pics() throws InterruptedException
	{
		List<WebElement> allDownloads = driver.findElements(By.xpath("html/body/center/div/div/div[3]/div[6]/div[2]/a[2]/img"));
		for(WebElement w: allDownloads)
		{
			w.click();
			Thread.sleep(3000);
		}
	}
}
