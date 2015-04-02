package com.banking.payments.beneficiaries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class SEPABeneficiaries {
	
	public void creatingSEPABeneficiary(String beneficiaryCode, String iBAN, String bIC) throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().bankingPaymentsBeneficiaries();
		Thread.sleep(2000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.btn_SEPA(Configuration.getInstance().eDriver).click();//Click SEPA
		Thread.sleep(1000);
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_BeneficiaryCode(Configuration.getInstance().eDriver).sendKeys(beneficiaryCode);//Enter Beneficiary code
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_Name(Configuration.getInstance().eDriver).sendKeys(beneficiaryCode);//Enter Beneficiary name
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.SEPA.txtBx_Address(Configuration.getInstance().eDriver).sendKeys("Address 1");//Enter Address
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.SEPA.txtBx_Address2(Configuration.getInstance().eDriver).sendKeys("Address 2");//Enter City
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Country']/following-sibling::td/label")).click();//Click Country drop down
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='metaNavigationAdminButton_menu']/following-sibling::div[3]//li[5]")).click();//Select American Samoya country
//		pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_AccountNumber(Configuration.getInstance().eDriver).sendKeys("45");//Enter Account number
//		pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_BankCode(Configuration.getInstance().eDriver).sendKeys("10010010");//Enter Bank code
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_IBAN(Configuration.getInstance().eDriver).sendKeys(iBAN);//Enter IBAN
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.txtBx_BIC(Configuration.getInstance().eDriver).sendKeys(bIC);//Enter BIC
		com.pageObjects.Objects_Banking.Payments.Beneficiaries.SEPA.txtBx_EndToEndRef(Configuration.getInstance().eDriver).sendKeys("End to End ref.");//Enter End to End ref.
		
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click Create		
	}
}