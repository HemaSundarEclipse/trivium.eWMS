package com.banking.payments.foreign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class ForeignPayment {	
	
	@DataProvider(name="p1")
	public String[][] f1()
	{
		return new String[][]
				{
				{"44004400:70020270:EUR - 44004400","44004400:70020270:EUR - 44004400" , "ForeignSample"},
				{"44004400:70020270:EUR - 44004400","44004400:70020270:EUR - 44004400" , "ForeignSample1"},
				
				{"44004400:70020270:EUR - 44004400", "55005500:70020270:EUR - 55005500", "ForeignSample"}, 
				{"44004400:70020270:EUR - 44004400", "55005500:70020270:EUR - 55005500", "ForeignSample1"},
				
				{"55005500:70020270:EUR - 55005500", "55005500:70020270:EUR - 55005500", "ForeignSample"}, 
				{"55005500:70020270:EUR - 55005500", "55005500:70020270:EUR - 55005500", "ForeignSample1"},
				};
	}
	@Test(dataProvider="p1")
	public void allScenForeignPayments(String Remitter, String Charges, String Beneficiary) throws InterruptedException
	{
//		All Type of Executions, Different Remitter Accounts, Different Charges Regulations, Different Charges Account, Different Beneficiaries, Future Date of Execution, Different Instruction Keys
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int Amount=10000, Desc=1,i=1,j=1,k=1,l=1;
		NavigatetoOverviews.getInstance().bankingPaymentsForeign();
		Thread.sleep(1000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();

		Thread.sleep(1000);
		WebElement TypeOfExec = Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Type of execution']/following-sibling::td/div/label"));
		for(int PType=1;PType<=11;PType++)
		{
			Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Type of execution']/following-sibling::td/div/label")).click();//Click Type of Execution
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='chargesAccounId_panel']/preceding-sibling::div[2]//li["+PType+"]")).click();//Select TypeOfExecution
			Thread.sleep(1000);
			
			Configuration.getInstance().eDriver.findElement(By.xpath("//table[@id='remitterInformation']//label[contains(@id, 'j_idt') and contains(@id, '_label')]")).click();//Click Remitter drop down
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/preceding-sibling::div/div[2]/ul/li[text()='"+Remitter+"']")).click();//Select Remitter
			System.out.println(TypeOfExec.getText());
			Configuration.getInstance().eDriver.findElement(By.id("chargesAccounId_label")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/div[2]/ul/li[text()='"+Charges+"']")).click();//Select Charges Account
			Configuration.getInstance().eDriver.findElement(By.id("contactNameId")).sendKeys("Sample Contact");//Contact		
//			
			Configuration.getInstance().eDriver.findElement(By.id("chargeCode_label")).click();//Click Chatges Regulation
			Thread.sleep(1000);
			int CRegSize = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='chargeCode_panel']/div/ul/li")).size();//Charges Reg size
			System.out.println(TypeOfExec.getText()+": "+CRegSize);
			for(int CReg=1;CReg<=CRegSize;CReg++)
			{
				for(int Currency=2;Currency<=166;Currency++)
				{
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Description (internal)']/following-sibling::td/input")).sendKeys(String.valueOf(Desc));//Description
					Desc++;
//					Beneficiary
					Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");
					Thread.sleep(2000);
					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li[span='"+Beneficiary+"']")).click();//Select Beneficiary
					Thread.sleep(1000);
//					if(TypeOfExec.getText().equalsIgnoreCase("20 - Cheque, Mail Or Other")
//					|| TypeOfExec.getText().equalsIgnoreCase("21 - Cheque By Registered Mail")
//					|| TypeOfExec.getText().equalsIgnoreCase("22 - Cheque By Express Mail")
//					|| TypeOfExec.getText().equalsIgnoreCase("23 - Cheque By Express & Reg. Mail")
//					|| TypeOfExec.getText().equalsIgnoreCase("30 - Cheque To Ordering Party")
//					|| TypeOfExec.getText().equalsIgnoreCase("31 - Cheque To Ordering Party, Registered")
//					|| TypeOfExec.getText().equalsIgnoreCase("32 - Cheque To Ordering Party, Express Mail")
//					|| TypeOfExec.getText().equalsIgnoreCase("33 - Cheque To Ord. Party"))
//					{
//						Configuration.getInstance().eDriver.findElement(By.id("beneficiaryChequeOwnerName")).sendKeys("beneficiaryChequeOwnerName");
//						Configuration.getInstance().eDriver.findElement(By.id("beneficiaryChequeOwnerName2")).sendKeys("beneficiaryChequeOwnerName2");
//					}
					Configuration.getInstance().eDriver.findElement(By.id("dtazvPayment-money-amount")).sendKeys(String.valueOf(Amount));//Amount
					Amount+=100;
					Configuration.getInstance().eDriver.findElement(By.id("currencyId_label")).click();//Click Currency drop down
					Thread.sleep(1000);
					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='currencyId_panel']/div[2]/ul/li["+Currency+"]")).click();//Select Currency
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Remitter note']/following-sibling::td/input")).sendKeys("Sample Remitter note");//Remitter Note
					com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();
				}
			}	
		}
	}
				
//		Configuration.getInstance().eDriver.findElement(By.id("instructionCode1_label")).click();
//		Thread.sleep(1000);
//		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode1_panel']/div/ul/li["+i+"]")).click();
//		Thread.sleep(1000);
//    	Configuration.getInstance().eDriver.findElement(By.id("instructionCode2_label")).click();
//    	Thread.sleep(1000);
//    	Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode2_panel']/div/ul/li["+j+"]")).click();
//    	Thread.sleep(1000);
//		Configuration.getInstance().eDriver.findElement(By.id("instructionCode3_label")).click();
//		Thread.sleep(1000);
//		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode3_panel']/div/ul/li["+k+"]")).click();
//		Thread.sleep(1000);
//		Configuration.getInstance().eDriver.findElement(By.id("instructionCode4_label")).click();
//		Thread.sleep(1000);
//		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode4_panel']/div/ul/li["+l+"]")).click();
                
//		System.out.println(Configuration.getInstance().eDriver.findElement(By.id("instructionCode1_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode2_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode3_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode4_label")).getText()+", ");       
}