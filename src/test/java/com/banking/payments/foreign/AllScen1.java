package com.banking.payments.foreign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.Log;
import com.utility.NavigatetoOverviews;

public class AllScen1 {
//	 
	@Test
	public void creatingAllForeignPayments() throws InterruptedException 
	{
		Log.info("Log4j Test in child");
		NavigatetoOverviews.getInstance().bankingPaymentsForeign();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Foreign']")).click();
		Thread.sleep(2000);
//		Configuration.getInstance().eDriver.findElement(By.className("ewms-ui-icon-new")).click();
		Configuration.getInstance().eDriver.findElement(By.className("ewms-ui-icon-new")).click();
		
	}
}
