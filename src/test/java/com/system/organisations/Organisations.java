package com.system.organisations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class Organisations {
	
	public void updateEnhancedOptions(String organisation) throws InterruptedException {		
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='defaultOverviewTable_data']/tr[./td[2][text()='"+organisation+"']]/td[.//button[@alt='Edit']]//button")).click();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//button[@alt='Edit']")).click();//Click Edit button for the only available organisation "Default organisation"
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='preSendCheckBox']/div[2]")).click();//Select "Allow manual presending for Send jobs" ckeck box
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='signAllPayCheckBox']/div[2]")).click();// Select "Sign all payments within payment overviews" check box
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='hashAlgCheckBox']/div[2]")).click();//Select "Display of Hash values for imported files" check box
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='crossBorderCOR1CheckBox']/div[2]")).click();//Select "Cross Border COR1" option
		com.pageObjects.Objects_Common.btn_Applychanges(Configuration.getInstance().eDriver).click();//Click "Apply changes" button
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();//Click OK on information pop-up	
	}
}