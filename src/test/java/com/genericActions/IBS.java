package com.genericActions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IBS 
{
	WebDriver eDriver;
	@BeforeClass
	public void BeforeClass() throws InterruptedException
	{
		//Login
		System.setProperty("webeDriver.firefox.profile", "default");
		eDriver = new FirefoxDriver();
		eDriver.manage().window().maximize();
		eDriver.get("http://10.0.0.29/mv-admin/actions/initdslogin");
		Thread.sleep(20000);
		eDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void IBS1() throws InterruptedException
	{
		//Search Customer
		eDriver.findElement(By.linkText(" Customers ")).click(); //Click on Customers
		eDriver.findElement(By.id("searchDisplayId")).sendKeys("PRIME1R0"+Keys.ENTER);//Enter Costomer value & click Search
		
		//View Customer
		eDriver.findElement(By.xpath("//*[@id='list']/table/tbody/tr[2]/td[6]/input")).click();//Click on View Details of the customer
		
		eDriver.findElement(By.linkText("> PRIME1RT")).click();//Click on User1
		eDriver.findElement(By.linkText(" Banking ")).click();// Click on Banking menu
		eDriver.findElement(By.linkText(" Keys ")).click();// Click on Keys menu
		// Activate or Delete keys for User1 
		loopTest();
		loopTest();
		loopTest();
		
		eDriver.findElement(By.linkText("> PRIME1R1")).click();//Click on User2
		// Activate or Delete keys for User2 
		loopTest();
		loopTest();
		loopTest();
		
		eDriver.findElement(By.linkText("> PRIME1R2")).click();//Click on User3
		// Activate or Delete keys for User3 
		loopTest();
		loopTest();
		loopTest();
		
		//Finish the changes
		eDriver.findElement(By.linkText("> Finish")).click();
		Thread.sleep(10000);
	}
	void loopTest() throws InterruptedException
	{
		List<WebElement> wb = eDriver.findElements(By.id("button"));
	
		if (wb.size() == 0)
			{
				System.out.println("No Keys Created");
			}
		else
		{
			for (WebElement w : wb)
				{
					System.out.println(w.getAttribute("value"));
						if (w.getAttribute("value").matches("> Activate"))
						{
							w.click();
							Thread.sleep(3000);
							break;
						}
						else if (w.getAttribute("value").matches("> Delete"))
						{
							w.click();
							Thread.sleep(3000);
							break;
						}
				}
		}
	}
}
