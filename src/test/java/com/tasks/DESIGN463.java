package com.tasks;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class DESIGN463 {
	
	public void padding() throws InterruptedException
	{
		List<WebElement> inputs = Configuration.getInstance().eDriver.findElements(By.xpath("//td[contains(@class, 'panelGridInputCol')]"));
		System.out.println(inputs.size());
		for(WebElement w:inputs)
		{
			//System.out.print(w.getCssValue("padding-top").replace("px", ""));
			int t1 = Integer.parseInt(w.getCssValue("padding-top").replace("px", ""));
			//System.out.println(w.getCssValue("padding-bottom").replace("px", ""));
			int t2 = Integer.parseInt(w.getCssValue("padding-bottom").replace("px", ""));
			System.out.println(t1+"+"+t2+" = "+(t1+t2));
		}
	}
	@Test
	public void D463() throws InterruptedException
	{
		//CashManagement();
		//payments();
		awv();
		orders();
		admin();		
	}	
	public void orders() throws InterruptedException
	{
		//Fetch Jobs
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Orders']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Fetch jobs']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.id("timePeriod_label")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='timePeriod_panel']/div/ul/li[2]")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.id("executionTimeOption_label")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='executionTimeOption_panel']/div/ul/li[2]")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='j_idt183:0:executionRange']/tbody/tr/td[7]")).click();
				padding();
				
	}
	public void CashManagement() throws InterruptedException
	{
		//Account Statements
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash management']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Account statements']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Import']")).click();
				Thread.sleep(2000);
				padding();
				
				//CAMT Account Statements
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash management']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Account statements']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='CAMT']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Import']")).click();
				Thread.sleep(2000);
				padding();
				//Advices
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash management']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Advices']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Import']")).click();
				Thread.sleep(2000);
				padding();
				//CAMTAdvices
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash management']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Advices']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='CAMT']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Import']")).click();
				Thread.sleep(2000);
				padding();
	}
	public void payments() throws InterruptedException
	{
		//Payments
				//SEPA (Credit) Payments
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA (Credit)']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);

				Configuration.getInstance().eDriver.findElement(By.xpath("(//label[contains(@id,'j_idt')])[2]")).click();//Click Remitter Account Dropdown
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt') and contains(@id, '_panel')]/div[2]/ul/li[2]")).click();//Select first Remitter Account
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='creditorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Remitter section 
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Beneficiary section
				Thread.sleep(2000);
				padding();
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdentificationType']/div/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenDebtorTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ultimate ben section
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("ultimateCreditor_org_label")).click();//Click ID type dropdown in ext ident for remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateCreditor_org_label']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("debtor_org_label")).click();//Click ID type dropdown in ext ident for ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("ultimateDebtor_org_label")).click();//Click ID type dropdown in ext ident for ultimate ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateDebtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				
				//Sepa Debit
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA (Debit)']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				//Needs to improve
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();//Click Remitter Account Dropdown
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]/div[2]/ul/li[2]")).click();//Select first Remitter Account
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='creditorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Remitter section 
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Beneficiary section
				Thread.sleep(2000);
				padding();
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdentificationType']/div/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenDebtorTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ultimate ben section
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("ultimateCreditor_org_label")).click();//Click ID type dropdown in ext ident for remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateCreditor_org_label']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("debtor_org_label")).click();//Click ID type dropdown in ext ident for ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("ultimateDebtor_org_label")).click();//Click ID type dropdown in ext ident for ultimate ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateDebtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//Domestic
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Domestic']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dtausPayment-textKey_label")).click();//Click Payment method drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='dtausPayment-textKey_panel']//li[text()='Capital formation savings payment']")).click();//select Capital formation savings payment
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("search")).click();//Click Search Bank icon
				Thread.sleep(2000);
				padding();
				
				//XML Urgent
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='XML urgent']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);

				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();//Click Remitter Account Dropdown
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]/div[2]/ul/li[2]")).click();//Select first Remitter Account
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='creditorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Remitter section 
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdenButtonId']/tbody/tr/td[2]/button")).click();//Click Extended identification for Beneficiary section
				Thread.sleep(2000);
				padding();
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtorIdentificationType']/div/table[1]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='idenDebtorTypeRadioRendererId']/tbody/tr/td[4]/table/tbody/tr/td[3]/div/div[2]/span")).click();//Click Org radiobutton in Ext identification for Ultimate ben section
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("ultimateCreditor_org_label")).click();//Click ID type dropdown in ext ident for remitter section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateCreditor_org_label']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("debtor_org_label")).click();//Click ID type dropdown in ext ident for ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='debtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				Configuration.getInstance().eDriver.findElement(By.id("ultimateDebtor_org_label")).click();//Click ID type dropdown in ext ident for ultimate ben section
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='ultimateDebtor_org_panel']/div/ul/li[2]")).click();//Select Other identification
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//Foreign
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Foreign']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);
				padding();
				//Need to correct
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();//Click Type of Execution Dropdown
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]/div[2]/ul/li[4]")).click();//Select 20 - Cheque, Mail Or Other
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment	
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//Euro urgent
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Euro urgent']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//RFT (MT101)
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='RFT (MT101)']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='addIntermediaryBankPanel']/button")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='bankAddressOption']/div[2]/span")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='benBankAddressOption']/div[2]/span")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='bankCodeOption']/div[2]/span")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='benBankCodeOption']/div[2]/span")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='Add instruction code']/..")).click();
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//EuropeanGate
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='EuropeanGate']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='addIntermediaryBankPanel']/button")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='bankAddressOption']/div[2]/span")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='benBankAddressOption']/div[2]/span")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='bankCodeOption']/div[2]/span")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='benBankCodeOption']/div[2]/span")).click();
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='Add instruction code']/..")).click();
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z4']")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z8']")).click();//Click Z8
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.id("dynaButton")).click();//Click Add dropdown button
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Z10']")).click();//Click Z10
				padding();
				
				//Beneficiaries/Payers
				//SEPA Mandate
				//Templates
				//Periodic
				//Import Journal
	}
	public void admin() throws InterruptedException
	{
		//ADMIN
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Admin")).click();
				Thread.sleep(2000);
				//System Users
				Configuration.getInstance().eDriver.findElement(By.linkText("Users")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("User management")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Permission groups
				Configuration.getInstance().eDriver.findElement(By.linkText("Users")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Permission groups")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Account management
				Configuration.getInstance().eDriver.findElement(By.linkText("Accounts")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Account management")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Account Owners
				Configuration.getInstance().eDriver.findElement(By.linkText("Accounts")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Account owner")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Banks
				Configuration.getInstance().eDriver.findElement(By.linkText("Banks")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Bank management")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Channel
				Configuration.getInstance().eDriver.findElement(By.linkText("Banks")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Channels")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Customers
				Configuration.getInstance().eDriver.findElement(By.linkText("Banks")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Customers")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Bank Users
				Configuration.getInstance().eDriver.findElement(By.linkText("Banks")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Bank users")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Order Types
				Configuration.getInstance().eDriver.findElement(By.linkText("Banks")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Order types")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Auto Import
				Configuration.getInstance().eDriver.findElement(By.linkText("Data exchange")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Auto import")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.linkText("Import")).click();
				Thread.sleep(2000);
				padding();
				//Conversion import
				Configuration.getInstance().eDriver.findElement(By.linkText("Data exchange")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Auto import")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.linkText("Conversion Import")).click();
				Thread.sleep(2000);
				padding();
				//Auto Export
				Configuration.getInstance().eDriver.findElement(By.linkText("Data exchange")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Auto export")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Export Conversions
				Configuration.getInstance().eDriver.findElement(By.linkText("Data exchange")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Export conversions")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Extranet-ID
				Configuration.getInstance().eDriver.findElement(By.linkText("AWV")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Extranet-ID")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
				//Extranet subscription
				Configuration.getInstance().eDriver.findElement(By.linkText("AWV")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Extranet subscription")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Thread.sleep(2000);
				padding();
	}
	public void awv() throws InterruptedException
	{
		//AWV Reports
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Reports']")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z4")).click();//Click Z4
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z8")).click();//Click Z8
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z10")).click();//Click Z10
				Thread.sleep(2000);
				padding();		
				
				//AWV Templates
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.linkText("Templates")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z4")).click();//Click Z4
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[3]")).click();//Select Merchanting
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("subTypeId_label")).click();//Click Sub Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='subTypeId_panel']/div/ul/li[4]")).click();//Select Direct Investment
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z8")).click();//Click Z8
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[3]")).click();//Select 2 = Income from residents
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.id("documentTypeId_label")).click();//Click Document Type drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='documentTypeId_panel']/div/ul/li[4]")).click();//Select 3 = Payments to non-residents
				Thread.sleep(2000);
				padding();
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Back']")).click();//Click Back button
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='New']/..")).click();//Click New dropdown button
				Configuration.getInstance().eDriver.findElement(By.linkText("Z10")).click();//Click Z10
				Thread.sleep(2000);
				padding();		
				
				//AWV Transactions
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
				Configuration.getInstance().eDriver.findElement(By.linkText("Transactions")).click();
				Thread.sleep(2000);
				Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Thread.sleep(2000);
				padding();
	}
}
