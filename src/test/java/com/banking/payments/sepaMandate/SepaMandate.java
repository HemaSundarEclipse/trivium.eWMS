package com.banking.payments.sepaMandate;


import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.GenericMethods;
import com.utility.NavigatetoOverviews;
@Test
public class SepaMandate {
	
	public void creatingAllSepaMandate() throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingPaymentsSepaMandate();
		
		int mandateReference = 1;
		for (int mandateState=1;mandateState<6;mandateState++) 
		{
			for (int paymentType=1;paymentType<3;paymentType++) 
			{
				for (int directDebitType=1;directDebitType<4;directDebitType++) 
				{
					for (int beneficiary=1; beneficiary<10; beneficiary=beneficiary+2) 
					{					
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='defaultOverviewTable']/table[1]/tbody/tr/td[2]/div/button")).click();
//						Configuration.getInstance().eDriver.findElement(By.xpath(or.New)).click();//Click New button
						
//						Configuration.getInstance().eDriver.findElement(By.id("mandateStateID_label")).click();//Click Mandate type
//						Thread.sleep(1000);
//						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='mandateStateID_panel']/div/ul/li["+mandateState+"]")).click();//Select Mandate type
						
						Configuration.getInstance().eDriver.findElement(By.id("paymentTypeID_label")).click();//Click Payment type drop down
						Thread.sleep(1000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='paymentTypeID_panel']/div/ul/li["+paymentType+"]")).click();//Select payment type
						
						Configuration.getInstance().eDriver.findElement(By.id("mandateReferenceInput")).sendKeys(String.valueOf(mandateReference));//Enter Mandate reference
						mandateReference++;
						Configuration.getInstance().eDriver.findElement(By.id("sepaMandate-signatureDate_input")).sendKeys("08/18/2014");//Enter Date of Execution
						System.out.println(Calendar.getInstance().get(Calendar.MONTH)+"/"+Calendar.getInstance().get(Calendar.DATE)+"/"+Calendar.getInstance().get(Calendar.YEAR));
						Configuration.getInstance().eDriver.findElement(By.id("sepaMandate-lastMandateUsage_input")).sendKeys("08/19/2014");//Enter Last used on
						
						Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Type of direct debit']/following-sibling::td//label")).click();//Click Seq type dropdown
						Thread.sleep(1000);
//						Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='mandateOwnerId_panel']/preceding-sibling::div/div/ul/li["+directDebitType+"]")).click();//Click Seq type value
						System.out.println(Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='ui-datepicker-div']/following-sibling::div/div/ul/li["+directDebitType+"]")).getText());
						Configuration.getInstance().eDriver.findElement(By.xpath("//div[contains(@id, 'j_idt') and contains(@id, '_panel')]/div/ul/li["+directDebitType+"]")).click();
//						Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='ui-datepicker-div']/following-sibling::div/div/ul/li["+directDebitType+"]")).click();//Click Seq type value
						Configuration.getInstance().eDriver.findElement(By.id("mandateOwnerId_label")).click();//Click on Mandate Owner drop down
						Thread.sleep(2000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='mandateOwnerId_panel']/div[2]/ul/li[text()='HEMANAME']")).click();//Select Account Owner value
						
						
						Configuration.getInstance().eDriver.findElement(By.id("accountID_label")).click();//Click Account drop down
						Thread.sleep(2000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='accountID_panel']/div[2]/ul/li[2]")).click();//Select Account
						
						
						Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");//Enter * in Code field
						Thread.sleep(2000);
						Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li["+beneficiary+"]")).click();//Select beneficiary
						
						Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Contract Data']/following-sibling::td/textarea")).sendKeys("Test");//Enter Contact Data
						Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Comment']/following-sibling::td/textarea")).sendKeys("Test");//Enter Comment
						
						Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
						GenericMethods.checkingForValidationErrors();
					}
				}
			}
		}
	}
}