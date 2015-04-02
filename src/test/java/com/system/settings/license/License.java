package com.system.settings.license;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.Log;
import com.utility.NavigatetoOverviews;

import bsh.This;

public class License {
	@Test
	public void updatingLicense() throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		Configuration.getInstance().eDriver.findElement(By.id("license")).sendKeys("E-DS-Xj17havocKVR8xMuH0OYcgPYeDt89ChgUGO2YiHPoQ6M3v4k27BnqrpwBLgh0JeK6OxJXDvU8X8W-zIRKn8kFNXpAg6pcNh0l55-bs7XFb5c60SrDokqdVofAXpSSnudhdxx2khNI1GTETmjgsgpBmqEU-wKzDfK_Wk1k-voy6GBxeHpj3Mmtuk2rR6FCoyoSS4ynnW4CIIeDRiURPRGrUIgjUgMc0hw2OqUbV8AV2Qsh5Jl");//Enter License key
		com.pageObjects.Objects_Common.btn_Applychanges(Configuration.getInstance().eDriver).click();//Click Apply changes
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();//Click OK on information pop-up
	}
}