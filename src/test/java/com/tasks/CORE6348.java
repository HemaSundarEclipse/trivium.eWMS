package com.tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class CORE6348 {
	
	@Test
	public void checkingMandatoryFieldsBackgroundColor() throws InterruptedException 
	{
		NavigatetoOverviews.getInstance().bankingPaymentsForeign();
		 
		 Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 Configuration.getInstance().eDriver.findElement(By.xpath("//div[@class='action-button_div']/button")).click();//Click New button
		 System.out.println("Background color is: "+Configuration.getInstance().eDriver.findElement(By.id("beneficiaryName_input")).getAttribute("background-color"));
		 
	}
}
