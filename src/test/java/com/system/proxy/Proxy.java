package com.system.proxy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

@Test
public class Proxy {
		
	public void creatingDataForMigration() throws BiffException, IOException, InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		nav.systemProxy();
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='System']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Proxy']")).click();
		
		FileInputStream fs = new FileInputStream("D:\\Hema\\OneDrive\\TestData\\Migration.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Banks");
		
		int ip=11, port=9090;
		for(int r=1; r<ws.getRows();ip++,port++)
		{		
			for (int i = 1; i < 4; i++) 
			{
				com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
				Configuration.getInstance().eDriver.findElement(By.id("alias")).sendKeys(ws.getCell(0, r).getContents());
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.id("proxyHost")).sendKeys("10.0.0."+String.valueOf(ip));
//				ip++;
				Configuration.getInstance().eDriver.findElement(By.id("proxyPort")).sendKeys(String.valueOf(port));
//				port++;
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Authentication Type']/following-sibling::td//label")).click();
				Thread.sleep(1000);
				
//				WebElement currentAuthenticationType = Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li["+i+"]"));
				WebElement currentAuthenticationType = Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='selectOrganizationMenu']/following-sibling::div[3]/div/ul/li["+i+"]"));
				System.out.println(currentAuthenticationType.getText());
				currentAuthenticationType.click();
				Thread.sleep(2000);
				try {
					Configuration.getInstance().eDriver.findElement(By.id("userName")).sendKeys(ws.getCell(0, r).getContents());
					Configuration.getInstance().eDriver.findElement(By.id("password")).sendKeys("12345");
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Domain']/following-sibling::td/input")).sendKeys("12345");
				} catch (Exception e) {
					// TODO: handle exception
				}
//				if (currentAuthenticationType.getText().equalsIgnoreCase("none")) 
//				{
//					
//				}
//				else if (currentAuthenticationType.getText().equalsIgnoreCase("basic") || 
//						currentAuthenticationType.getText().equalsIgnoreCase("digest")) 
//				{
//					Configuration.getInstance().eDriver.findElement(By.id("userName")).sendKeys(ws.getCell(0, r).getContents());
//					Configuration.getInstance().eDriver.findElement(By.id("password")).sendKeys("12345");
//				}
//				else if (currentAuthenticationType.getText().equalsIgnoreCase("ntlm")) 
//				{
//					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Domain']/following-sibling::td/input")).sendKeys("12345");
//				}
				Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
				r++;
			}
		}	
	}
}