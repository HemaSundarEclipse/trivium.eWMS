package com.samplePractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.Configuration;

public class Dave {
		
	@Test
	public void test() throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Configuration.getInstance().eDriver.findElement(By.id("username")).sendKeys("tomsmith");
		Configuration.getInstance().eDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='login']/button")).click();
		
		if (Configuration.getInstance().eDriver.findElement(By.xpath("//i[text()=' Logout']")).isDisplayed()) 
		{
			System.out.println("Login successfull");
		}
		else {
			System.out.println("Login failed");
		}
		Assert.assertEquals("Secure Area", Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='content']/div/h2")).getText());
//		System.out.println(Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='content']/div/h2")).getText());
		System.out.println(Configuration.getInstance().eDriver.findElement(By.id("flash")).getText());
		String str = Configuration.getInstance().eDriver.findElement(By.id("flash")).getText();
		str = str.substring(0, str.length()-2);
		System.out.println(str);
		Assert.assertEquals("You logged into a secure area!", str.trim());
		System.out.println("Passesd");
	}
}