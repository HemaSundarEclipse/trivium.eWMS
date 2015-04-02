package com.admin.dataExchange.autoExport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.Constant;
import com.utility.ExcelUtils;
import com.utility.NavigatetoOverviews;

@Test
public class AutoExport {

	public AutoExport() {
		ExcelUtils.getInstance().setExcelFile(Constant.File_TestData_Migration, "Banks");
	}

	public void creatingMigrationData() throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		NavigatetoOverviews.getInstance().adminDataExchangeAutoExport();
		
		for (int r = 0; r < 30; r++) {
			
			Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New button or icon
			Configuration.getInstance().eDriver.findElement(By.id("nameId")).sendKeys(ExcelUtils.getInstance().getCellData(r, 0));//Enter Alias
			
//			Configuration.getInstance().eDriver.findElement(By.xpath("//td[.label[text()='Type']]/following-sibling::td//label")).click();//Click Type drop down
			Configuration.getInstance().eDriver.findElement(By.xpath("//label[text()='STA']")).click();//Click Type drop down
			
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='selectOrganizationMenu']/following-sibling::div[2]//ul/li["+(r+1)+"]")).click();//Select Type value
			
			Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Export directory']/following-sibling::td/input")).sendKeys("D:\\Export\\HemaSundar\\");//Enter Export directory
			
			Configuration.getInstance().eDriver.findElement(By.id("conversionTable:assignConversionButtonId")).click();//Click Assign icon in Assigned conversions table
			Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Add Original File Export']")).click();//click Add Original File Export link
			
			Thread.sleep(1000);
			try {
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[text()='Original File']/following-sibling::td/input")).sendKeys(ExcelUtils.getInstance().getCellData(r, 0));//Enter Original text box
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			Configuration.getInstance().eDriver.findElement(By.xpath("//td[@id='selectedContextForUnassignId_paginator_top']/following-sibling::td/div/button")).click();//Click Assign icon in Assigned contexts table
			
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='defaultOverviewTable_data']/tr[1]/td[1]/div/div[2]/span")).click();//Select first record
			
			Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Assign']")).click();
			
			Thread.sleep(2000);
			Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
			
		}
	}
}
