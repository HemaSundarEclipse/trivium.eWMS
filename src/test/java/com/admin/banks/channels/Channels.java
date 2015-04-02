package com.admin.banks.channels;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.poi.ss.usermodel.PageOrder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class Channels
{
	public void updateChannelURL(String bankName) throws InterruptedException
	{
		NavigatetoOverviews.getInstance().adminBanksChannels();
		Thread.sleep(2000);
		//Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[2][text()='HypoVereinsbank'] and ./td[3][text()='EBICS']//button[@alt='Edit']]")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[2](text()='"+bankName+"')/td[//button[@alt='Edit']]//button[@alt='Edit']")).click();//Click Edit on the specified Bank
//		WebElement overviewChnls = Configuration.getInstance().eDriver.findElement(By.id("defaultOverviewTable_data"));
//		List<WebElement> indChnl = overviewChnls.findElements(By.tagName("tr"));
//		for(WebElement a : indChnl)
//		{
//			List<WebElement> indClmn = a.findElements(By.tagName("td"));
//			if(indClmn.get(1).getText().equalsIgnoreCase("HypoVereinsbank"))
//			{
//				List<WebElement> allBtnsChnl = a.findElements(By.tagName("button"));
//				for(WebElement c : allBtnsChnl)
//				{
//					if(c.getAttribute("title").matches("Edit"))
//					{
//						c.click();
//						break;
//					}
//				}
//				break;
//			}
//		}
		com.pageObjects.Objects_Admin.Banks.Channels.txtBx_URL(Configuration.getInstance().eDriver).clear();
		com.pageObjects.Objects_Admin.Banks.Channels.txtBx_URL(Configuration.getInstance().eDriver).sendKeys("https://port-212-202-124-81.static.qsc.de/mv-ebics/");
		com.pageObjects.Objects_Common.btn_Applychanges(Configuration.getInstance().eDriver).click();
	}
	@Test
	public void creatingChannelsForMigration() throws InterruptedException, BiffException, IOException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().adminBanksChannels();
		Thread.sleep(2000);	
		
		FileInputStream fs = new FileInputStream("D:\\Hema\\Google Drive\\eclipse_project\\Selenium\\trivium.eWMS\\src\\test\\java\\com\\testData\\Migration.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Banks");
		for(int r=7; r<ws.getRows();r++)
		{
			com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Bank']/following-sibling::td//label")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//li[text()='"+ws.getCell(0, r).getContents()+"']")).click();
			Thread.sleep(1000);
			com.pageObjects.Objects_Admin.Banks.Channels.txtBx_HostID(Configuration.getInstance().eDriver).sendKeys("1234");
			com.pageObjects.Objects_Admin.Banks.Channels.txtBx_URL(Configuration.getInstance().eDriver).sendKeys("https://test");
//			if(ws.getCell(4, r).getContents().equalsIgnoreCase("a004"))
//			{
//				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='securityTypeId']/tbody/tr/td[1]/div/div[2]")).click();
//			}
//			else if (ws.getCell(4, r).getContents().equalsIgnoreCase("a006")) 
//			{
//				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='securityTypeId']/tbody/tr/td[3]/div/div[2]")).click();
//			}
//			else 
//			{
//				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='securityTypeId']/tbody/tr/td[1]/div/div[2]")).click();
//				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='securityTypeId']/tbody/tr/td[3]/div/div[2]")).click();
//			}
			Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
			Thread.sleep(1000);
			
			
//			Configuration.getInstance().eDriver.findElement(By.linkText("Back to Overview")).click();
//			Thread.sleep(2000);
		}
	}
	
	
}