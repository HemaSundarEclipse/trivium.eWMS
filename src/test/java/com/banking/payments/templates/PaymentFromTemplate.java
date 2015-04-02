package com.banking.payments.templates;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class PaymentFromTemplate {	
	
	@Test
	public void paymentFromTemp() throws InterruptedException
	{
		NavigatetoOverviews.getInstance().bankingPaymentsEuroUrgent();
		Thread.sleep(2000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New Button
		Thread.sleep(2000);
		for(int i=1;i<=8;i++)
		{
			Configuration.getInstance().eDriver.findElement(By.id("paymentHeaderForm:templatePopUpTrigger")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='"+i+"']")).click();
			com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();
		}
	}
}