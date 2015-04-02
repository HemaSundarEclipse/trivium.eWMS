package com.banking.payments.foreign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class Foreign {
	
	@Test
	public void foreignPaymentsWithDiffCurrencies() throws InterruptedException
	{
		
		NavigatetoOverviews.getInstance().bankingPaymentsForeign();
		Thread.sleep(2000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New Button
		Thread.sleep(2000);
		//Remitter Account
		Configuration.getInstance().eDriver.findElement(By.xpath("//table[@id='remitterInformation']//label[contains(@id, 'j_idt') and contains(@id, '_label')]")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/preceding-sibling::div/div[2]/ul/li[text()='421421421:70020270:EUR - 421421421']")).click();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='421421421:70020270:EUR - 421421421']")).click();
		test();
		Thread.sleep(2000);
//		//Charges Account
//		Configuration.getInstance().eDriver.findElement(By.id("chargesAccounId_label")).click();
//		Thread.sleep(2000);
//		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/div[2]/ul/li[5]")).click();
//		Thread.sleep(1000);
//		test();
	}
	public void test() throws InterruptedException
	{
		for (int j=2;j<=167;j++)
		{
			Thread.sleep(2000);
			//Beneficiary Selection
			Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li[1]")).click();
			Thread.sleep(1000);
			
			Configuration.getInstance().eDriver.findElement(By.id("dtazvPayment-money-amount")).sendKeys("1");//Amount
			//Currency code
			Configuration.getInstance().eDriver.findElement(By.id("currencyId_label")).click();//Click Currency code drop down
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='currencyId_panel']/div[2]/ul/li["+j+"]")).click();//Select Currency code
			Thread.sleep(1000);
			com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();//Click Create & next
		}
	}
}