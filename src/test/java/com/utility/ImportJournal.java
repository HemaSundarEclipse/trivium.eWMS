package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ImportJournal {
	
	@Test
	public void importingAdvices() throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingCashManagementImportJournal();
		
		for (int i = 1; i < 30; i++) 
		{
			com.pageObjects.Objects_Common.btn_Import(Configuration.getInstance().eDriver).click();
			Thread.sleep(1000);
//			Configuration.getInstance().eDriver.findElement(By.linkText("Advices")).click();
			Configuration.getInstance().eDriver.findElement(By.linkText("Advice - CAMT")).click();
			com.pageObjects.Objects_Common.btn_SelectLessThan5MB(Configuration.getInstance().eDriver).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//input[contains(@id, 'j_idt')]")).click();
			Thread.sleep(3000);
			com.pageObjects.Objects_Common.btn_Import(Configuration.getInstance().eDriver).click();
			
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
		}
	}
}
