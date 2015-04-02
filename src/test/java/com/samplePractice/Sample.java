package com.samplePractice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample 
{       
	WebDriver driver;
	@BeforeClass
	public void BeforeClass() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.firefox.profile", "default");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://northeastindiaholidays.com/");
		Thread.sleep(4000);
	}
	@Test
	public void fetchCustKeys() throws Exception
	{
		//WebElement menu1=driver.findElement(By.xpath("//*[@id='content']/section[1]"));
		WebElement menu=driver.findElement(By.xpath("//*[@id='content']/section[./h1[text()='Beach Destinations']]"));
		List<WebElement> allImages=menu.findElements(By.tagName("img"));
		
		List<String> widthofImage = new ArrayList<String>();
		List<String> heightofImage = new ArrayList<String>();
		List<String> srcofImage = new ArrayList<String>();
		for (WebElement imageFromList: allImages)
		{
			widthofImage.add(imageFromList.getAttribute("width"));
			heightofImage.add(imageFromList.getAttribute("height"));
			srcofImage.add(imageFromList.getAttribute("src"));
		}
		System.out.println(widthofImage);
		System.out.println(heightofImage);
		System.out.println(srcofImage);
	}
}