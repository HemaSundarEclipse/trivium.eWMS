package com.admin.dataExchange.autoImport;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class AutoImport {
	
	Random ran = new Random();
	public void creatingDataForMigration() throws InterruptedException  {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().adminDataExchangeAutoImport();
		int count=1;
		for (int orderType = 2; orderType <= 45 ; orderType++) {
			
			for (int i = 0; i < 24; i++) {
				
				for (int displayHashValue=1; displayHashValue<=3; displayHashValue++) {
					
					com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
					Configuration.getInstance().eDriver.findElement(By.linkText("Import")).click();
					
					Configuration.getInstance().eDriver.findElement(By.id("transCodeId_label")).click();//Click Order type
					String currentOrderType = Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='transCodeId_panel']/div/ul/li["+orderType+"]")).getText();
					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='transCodeId_panel']/div/ul/li["+orderType+"]")).click();//Select Order Type
					com.pageObjects.Objects_Admin.DataExchange.AutoImport.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(currentOrderType);//Enter Alias
					com.pageObjects.Objects_Admin.DataExchange.AutoImport.txtBx_Directory(Configuration.getInstance().eDriver).sendKeys("D:\\import\\Hemasundar");//Enter Directory
					com.pageObjects.Objects_Admin.DataExchange.AutoImport.txtBx_SaveDirectory(Configuration.getInstance().eDriver).sendKeys("D:\\import\\Hemasundar\\save");//Enter Save Directory
					com.pageObjects.Objects_Admin.DataExchange.AutoImport.txtBx_FilePattern(Configuration.getInstance().eDriver).sendKeys("*");//Enter FIle pattern
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Daily execution from']/following-sibling:td//label")).click();//Click Daily execution from drop down
					List<WebElement> fromTime = Configuration.getInstance().eDriver.findElements(By.xpath("//ul/li"));
					System.out.println(fromTime.size());
					fromTime.remove(fromTime.size()-1);//Remove last value from Daily execution from drop down values
					System.out.println(fromTime.size());
					
					for (WebElement w : fromTime) {
					
						System.out.println(w.getText());
					}
					
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li["+i+"]")).click();//Select Daily execution from time
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Daily execution to']/following-sibling:td//label")).click();//Click Daily execution to drop down
					List<WebElement> toList = Configuration.getInstance().eDriver.findElements(By.xpath("//ul/li"));
					
					for (int j = 0; j <= i; j++) {
						
						toList.remove(j);//Remove daily execution to values till daily execution from value
					}
					
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li["+ran.nextInt(toList.size())+"]")).click();//Randomly select Daily execution to value
					
					for (int weekly=1; weekly<=4; weekly++) {
						
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='weekDaysId']/tbody/tr/td["+(ran.nextInt(7)*2-1)+"]/div/div[2]/span")).click();//Select week check box
					}
					
					com.pageObjects.Objects_Admin.DataExchange.AutoImport.txtBx_DeleteLogsOlderThan(Configuration.getInstance().eDriver).sendKeys(String.valueOf(count));//Enter delete logs older than
					Configuration.getInstance().eDriver.findElement(By.id("integrityAlgorithm_label")).click();//Click Display hash value drop down
					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='integrityAlgorithm_panel']/div/ul/li["+displayHashValue+"]")).click();//Select Display hash value
					
					if (count%2==0) {
						
						com.pageObjects.Objects_Admin.DataExchange.AutoImport.chkBx_Confidential(Configuration.getInstance().eDriver).click();//Click Confidential check box
					}
					
					count++;
					Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
					
				}
			}
		}
	}
}