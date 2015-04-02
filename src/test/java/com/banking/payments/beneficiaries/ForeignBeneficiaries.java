package com.banking.payments.beneficiaries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class ForeignBeneficiaries {
	
	
	public void creatingForeignBeneficiary(String beneficiaryCode) throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingPaymentsBeneficiaries();
		Thread.sleep(2000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New
		Configuration.getInstance().eDriver.findElement(By.linkText("Foreign")).click();//Click Foreign
		Thread.sleep(1000);
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_BeneficiaryCode(Configuration.getInstance().eDriver).sendKeys(beneficiaryCode);//Enter Beneficiary code
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_Name(Configuration.getInstance().eDriver).sendKeys(beneficiaryCode);//Enter Beneficiary name
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Address 1']/following-sibling::td/input")).sendKeys("Address 1");//Enter Address
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='City']/following-sibling::td/input")).sendKeys("City");//Enter City
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Postal code']/following-sibling::td/input")).sendKeys("522124");//Enter Postal code		
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Bank code']/following-sibling::td/input")).sendKeys("10010010");//Enter Bank code
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Account number']/following-sibling::td/input")).sendKeys("34");//Enter Account number
//		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='IBAN']/following-sibling::td/input")).sendKeys("522124");//Enter IBAN
//		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='BIC']/following-sibling::td/input")).sendKeys("522124");//Enter BIC
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Credit institution']/following-sibling::td/input")).sendKeys("Credit institution 1");//Enter Credit institution 1
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Country']/following-sibling::td/label")).click();//Click Country drop down
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='metaNavigationAdminButton_menu']/following-sibling::div[3]//li[5]")).click();//Select American Samoya country
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click Create
	}
}