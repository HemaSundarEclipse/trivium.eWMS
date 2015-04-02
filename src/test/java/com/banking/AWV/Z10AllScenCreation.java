package com.banking.AWV;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.GenericMethods;
import com.utility.NavigatetoOverviews;

public class Z10AllScenCreation {
	
	@Test
	public void Z10Reports(String accountOwner) throws InterruptedException
	{
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingAWVReports();
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
		Thread.sleep(1000);
		com.pageObjects.Objects_Banking.AWV.Reports.btn_Z10(Configuration.getInstance().eDriver).click();
		//AccountOw12ner
		Configuration.getInstance().eDriver.findElement(By.id("z10ReportregistrationId_label")).click();//Click Account Owner drop down
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='z10ReportregistrationId_panel']/div[2]/ul/li[text()='"+accountOwner+"']")).click();//Select Account Owner
//		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='z10ReportregistrationId_panel']/div[2]/ul/li[text()='HEMANAME']")).click();//Select Account Owner
		int Amount = 1;
		for (int documentType=2;documentType<=3; documentType++) 
		{
			//Document Type
			Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li["+documentType+"]")).click();
			//Number of entries in Indicator drop down
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='indicatorId']/button")).click();
			Thread.sleep(1000);
			int CurIndicatorCount = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='indicatorId_panel']/ul/li")).size();
			if(CurIndicatorCount>5)
			{
				CurIndicatorCount = 5; 
			}
			for(int Indicator=1;Indicator<=CurIndicatorCount;Indicator++)
//			for(int Indicator=1;Indicator<=CurIndicatorCount;Indicator++)
			{
				for (int parValue=1; parValue<=3;parValue++) 
				{
					for (int currencyCode=2; currencyCode <=3; currencyCode++) 
					{
						for(int MonthOfNot=currentMonth-3;MonthOfNot<=currentMonth+1;MonthOfNot++)
						{
							com.pageObjects.Objects_Banking.AWV.Reports.txtBx_Desription(Configuration.getInstance().eDriver).sendKeys("Description"+String.valueOf(Amount));
							//Indicator
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='indicatorId']/button")).click();
							Thread.sleep(1000);
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='indicatorId_panel']/ul/li["+Indicator+"]")).click();
							Thread.sleep(1000);
							com.pageObjects.Objects_Banking.AWV.Reports.Z10Report.txtArea_Purpose(Configuration.getInstance().eDriver).sendKeys("Test");//Enter Purpose
							//Country Code
							Configuration.getInstance().eDriver.findElement(By.id("countryId_label")).click();
							Thread.sleep(1000);
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='countryId_panel']/div[2]/ul/li[5]")).click();
							Thread.sleep(1000);
							//Amount
							com.pageObjects.Objects_Banking.AWV.Reports.Z10Report.txtBx_Amount(Configuration.getInstance().eDriver).sendKeys(String.valueOf(Amount));
							Amount++;
							//ISIN
							com.pageObjects.Objects_Banking.AWV.Reports.txtBx_ISIN(Configuration.getInstance().eDriver).sendKeys("AAAAAAAAAAAA");
							//Par alue
							Configuration.getInstance().eDriver.findElement(By.id("unitCodeId_label")).click();
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='unitCodeId_panel']/div/ul/li["+parValue+"]")).click();
							Thread.sleep(1000);
							try
							//if (Configuration.getInstance().eDriver.findElement(By.id("z10Report-units")).getCssValue("aria-disabled").equalsIgnoreCase("false")) 
							{
								com.pageObjects.Objects_Banking.AWV.Reports.Z10Report.txtBx_ParValueInThdOrQuantity(Configuration.getInstance().eDriver).sendKeys(String.valueOf(Amount));
							}
							catch (Exception e)
							{
								
							}
							Configuration.getInstance().eDriver.findElement(By.id("currencyId_label")).click();
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='currencyId_panel']/div[2]/ul/li["+currencyCode+"]")).click();
							//DateOfNotification
							Configuration.getInstance().eDriver.findElement(By.id("z10Report-date:month_label")).click();
							Thread.sleep(1000);
							Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='z10Report-date:month_panel']/div/ul/li["+MonthOfNot+++"]")).click();
							com.pageObjects.Objects_Banking.AWV.Reports.chkBx_AddAsTemplate(Configuration.getInstance().eDriver).click();
							com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();//Create & Next
							
							GenericMethods.checkingForValidationErrors();
						}
					}
				}
			}
		}
	}
}