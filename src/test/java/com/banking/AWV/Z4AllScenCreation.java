package com.banking.AWV;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class Z4AllScenCreation {
	
	@Test
	public void AllZ4() throws InterruptedException
	{	
		
		NavigatetoOverviews.getInstance().bankingAWVReports();
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New button
		Thread.sleep(1000);
		com.pageObjects.Objects_Banking.AWV.Reports.btn_Z4(Configuration.getInstance().eDriver).click();//Click Z4 link
		//AccountOwner
		Configuration.getInstance().eDriver.findElement(By.id("z4ReportregistrationId_label")).click();//Click Account Owner drop down
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='z4ReportregistrationId_panel']/div[2]/ul/li[text()='HEMANAME']")).click();//Select Account Owner
		//SubType 1
		Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[2]")).click();
		Thread.sleep(1000);
		test();
		//SubType 2
		Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();
		Thread.sleep(1000);
		for(int ChapterNumber=1;ChapterNumber<=5;ChapterNumber++)
//		for(int ChapterNumber=1;ChapterNumber<=98;ChapterNumber++)
		{
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chNoGoodsDescriptionId']/button")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chNoGoodsDescriptionId_panel']/ul/li["+1+"]")).click();
			Thread.sleep(1000);
			test();
		}
		//SubType 3
		Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();
		Thread.sleep(1000);
		test();
	}
		
	public void test() throws InterruptedException
	{
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
		//Number of entries in DocType
		Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();
		Thread.sleep(1000);
		int CurDocTypeCount = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li")).size();
		Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();
		Thread.sleep(1000);
		//Document Type
		for(int DocType=2;DocType<=CurDocTypeCount;DocType++)
		{
			int Amount=1;
			Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li["+DocType+"]")).click();
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
				for(int NorC=2;NorC<=3;NorC++)
				{
					for(int MonthOfNot=currentMonth-3;MonthOfNot<=currentMonth+1;MonthOfNot++)
					{
						//AccountOwner
						Configuration.getInstance().eDriver.findElement(By.id("z4ReportregistrationId_label")).click();//Click Account Owner drop down
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='z4ReportregistrationId_panel']/div[2]/ul/li[text()='HEMANAME']")).click();//Select Account Owner
						
						com.pageObjects.Objects_Banking.AWV.Reports.txtBx_Desription(Configuration.getInstance().eDriver).sendKeys("Description"+String.valueOf(Amount));
						//Indicator
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='indicatorId']/button")).click();
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='indicatorId_panel']/ul/li["+Indicator+"]")).click();
						Thread.sleep(1000);
						if(Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).getText().equalsIgnoreCase("direct investment"))
						{
							//ISIN
							com.pageObjects.Objects_Banking.AWV.Reports.txtBx_ISIN(Configuration.getInstance().eDriver).sendKeys("AAAAAAAAAAAA");
							//Units
							com.pageObjects.Objects_Banking.AWV.Reports.Z4Report.txtBx_Units(Configuration.getInstance().eDriver).sendKeys("1");
						}
						else
						{
							
						}
						//Purpose
						com.pageObjects.Objects_Banking.AWV.Reports.Z4Report.txtArea_Purpose(Configuration.getInstance().eDriver).sendKeys("Test"+Amount);
						//Country Code
						Configuration.getInstance().eDriver.findElement(By.id("countryId_label")).click();
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='countryId_panel']/div[2]/ul/li[5]")).click();
						Thread.sleep(1000);
						//Amount
						com.pageObjects.Objects_Banking.AWV.Reports.Z4Report.txtBx_Amount(Configuration.getInstance().eDriver).sendKeys(String.valueOf(Amount));
						Amount++;
						//Netting or Clearing
						Configuration.getInstance().eDriver.findElement(By.id("nettingOrClearingId_label")).click();
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='nettingOrClearingId_panel']/div/ul/li["+NorC+"]")).click();
						Thread.sleep(1000);
						//DateOfNotification
						Configuration.getInstance().eDriver.findElement(By.id("z4Report-date:month_label")).click();
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='z4Report-date:month_panel']/div/ul/li["+MonthOfNot+"]")).click();
						
						com.pageObjects.Objects_Banking.AWV.Reports.chkBx_AddAsTemplate(Configuration.getInstance().eDriver).click();
						com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();//Create & Next
					}
				}
			}
		}
	}
}