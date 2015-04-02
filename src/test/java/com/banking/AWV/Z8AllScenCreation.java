package com.banking.AWV;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class Z8AllScenCreation {
	
	@Test
	public void AllZ8() throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingAWVReports();
		
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
		Thread.sleep(1000);
		com.pageObjects.Objects_Banking.AWV.Reports.btn_Z8(Configuration.getInstance().eDriver).click();
		//AccountOwner
		Configuration.getInstance().eDriver.findElement(By.id("z8ReportRegistrationId_label")).click();
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='z8ReportRegistrationId_panel']/div[2]/ul/li[text()='HEMANAME']")).click();
		//Document Type
		for(int DocType=2;DocType<=4;DocType++)
		{
			Configuration.getInstance().eDriver.findElement(By.id("documentypeId_label")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='documentTypeId_panel']/div/ul/li["+DocType+"]")).click();
			Thread.sleep(1000);
			for(int Country=2;Country<=244;Country++)
			{
				//Country code
				Configuration.getInstance().eDriver.findElement(By.id("countryId_label")).click();
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='countryId_panel']/div[2]/ul/li["+Country+"]")).click();
				Thread.sleep(1000);
				for(int MonthOfNot=5;MonthOfNot<=9;MonthOfNot++)
				{
					//DateOfNotification
					Configuration.getInstance().eDriver.findElement(By.id("z8Report-date:month_label")).click();
					Thread.sleep(1000);
					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='z8Report-date:month_panel']/div/ul/li["+MonthOfNot+"]")).click();
					com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();//Create & Next
				}
			}
		}
	}
}