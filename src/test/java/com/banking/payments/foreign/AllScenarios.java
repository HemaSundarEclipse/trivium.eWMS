package com.banking.payments.foreign;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.GenericMethods;
import com.utility.NavigatetoOverviews;

public class AllScenarios {
	
	Random gen = new Random();
	@DataProvider(name="p1")
	public String[][] f1()
	{
		return new String[][]
				{
				{"44004400:70020270:EUR - 44004400","44004400:70020270:EUR - 44004400" , "ForeignSample"},
				{"44004400:70020270:EUR - 44004400","44004400:70020270:EUR - 44004400" , "ForeignSample1"},
				
				{"44004400:70020270:EUR - 44004400", "55005500:70020270:EUR - 55005500", "ForeignSample"}, 
				{"44004400:70020270:EUR - 44004400", "55005500:70020270:EUR - 55005500", "ForeignSample1"},
				};
	}
	@Test(dataProvider="p1")
	public void creatingForeignPaymentsAllScenarios(String remitterAccount, String chargesAccount, String beneficiaryCode) throws InterruptedException
	{
		String str[] = {"00 - Standard Transmission", "10 - Telex Payment Or Swift Urgent", "15 - Transfer Across The Borders", "20 - Cheque, Mail Or Other", "21 - Cheque By Registered Mail", "22 - Cheque By Express Mail", "23 - Cheque By Express & Reg. Mail", "30 - Cheque To Ordering Party", "31 - Cheque To Ordering Party, Registered", "32 - Cheque To Ordering Party, Express Mail", "33 - Cheque To Ord. Party"};
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingPaymentsForeign();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
//		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Foreign']")).click();
		Thread.sleep(2000);
//		Configuration.getInstance().eDriver.findElement(By.xpath(or.New)).click();
		com.pageObjects.Objects_Common.ActionBar.icn_New(Configuration.getInstance().eDriver).click();
		
		int amount=1;
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//table[@id='remitterInformation']/tbody/tr[1]//label")).click();//Click Remitter Account drop down
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/preceding-sibling::div/div[2]/ul/li[text()='"+remitterAccount+"']")).click();//Select Remitter account
		
		Thread.sleep(1000);
		
		Configuration.getInstance().eDriver.findElement(By.id("chargesAccounId_label")).click();//Click Charges account drop down
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/div[2]/ul/li[text()='"+chargesAccount+"']")).click();//Select Charges Account
				
		for(int typeOfExecution=1;typeOfExecution<=11;typeOfExecution++)
		{
			for (int chargesRegulation=1;chargesRegulation<=3;chargesRegulation++)
			{
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Type of execution']/following-sibling::td/div/label")).click();//Click Type of execution drop down
				//Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='chargesAccounId_panel']/preceding-sibling::div[2]//li["+typeOfExecution+"]")).click();//Select type of execution
//				Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li["+typeOfExecution+"]")).click();//Select type of execution
				Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='"+str[typeOfExecution-1]+"']")).click();//Select type of execution
				System.out.println(Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li["+typeOfExecution+"]")).getText());
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Description (internal)']/following-sibling::td/input")).sendKeys(String.valueOf(amount));//Enter Description
				
				Configuration.getInstance().eDriver.findElement(By.id("contactNameId")).sendKeys(String.valueOf(amount));//Enter Contact field
				
				Configuration.getInstance().eDriver.findElement(By.id("chargeCode_label")).click();//Click Charges regulation drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargeCode_panel']/div/ul/li["+chargesRegulation+"]")).click();
				
				Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");//Enter * in Code field
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li[span='"+beneficiaryCode+"']")).click();//Select Beneficiary
				Thread.sleep(1000);
				try
				{
					Configuration.getInstance().eDriver.findElement(By.id("beneficiaryChequeOwnerName")).sendKeys("Test");
					Configuration.getInstance().eDriver.findElement(By.id("beneficiaryChequeOwnerName2")).sendKeys("Test");
				}
				catch(Exception e)
				{
					
				}
				
				Configuration.getInstance().eDriver.findElement(By.id("dtazvPayment-money-amount")).sendKeys(String.valueOf(amount));//Enter Amount
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Remitter note']/following-sibling::td/input")).sendKeys(String.valueOf(amount));//Enter Remitter note
				
//				Configuration.getInstance().eDriver.findElement(By.id("instructionCode1_label")).click();
//				List<WebElement> instructionKey1 = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='instructionCode1_panel']/div/ul/li"));
//				instructionKey1.get(gen.nextInt(instructionKey1.size())).click();
//				
//				Configuration.getInstance().eDriver.findElement(By.id("instructionCode2_label")).click();
//				List<WebElement> instructionKey2 = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='instructionCode2_panel']/div/ul/li"));
//				instructionKey2.get(gen.nextInt(instructionKey2.size())).click();
//				
//				Configuration.getInstance().eDriver.findElement(By.id("instructionCode3_label")).click();
//				List<WebElement> instructionKey3 = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='instructionCode3_panel']/div/ul/li"));
//				instructionKey3.get(gen.nextInt(instructionKey3.size())).click();
//				
//				Configuration.getInstance().eDriver.findElement(By.id("instructionCode4_label")).click();
//				List<WebElement> instructionKey4 = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='instructionCode4_panel']/div/ul/li"));
//				instructionKey4.get(gen.nextInt(instructionKey4.size())).click();
				
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//div[span='Add as template']/div/div[2]")).click();//Select Add as template check box
				com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();
				amount++;
				
				GenericMethods.checkingForValidationErrors();
			}
		}
	}
}