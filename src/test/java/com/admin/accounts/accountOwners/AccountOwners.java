package com.admin.accounts.accountOwners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Admin;
import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class AccountOwners {
	
	public void creatingSampleAccountOwner(String AccountOwner) throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click(); //Click New button
		Objects_Admin.Accounts.AccountOwners.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(AccountOwner+"ALIAS");//AcountOwner Alias
		Objects_Admin.Accounts.AccountOwners.txtBx_Name1(Configuration.getInstance().eDriver).sendKeys(AccountOwner+"NAME");//AccountOwner Name
		Objects_Admin.Accounts.AccountOwners.txtBx_Town(Configuration.getInstance().eDriver).sendKeys("SAMPLETOWN");//Town
		Objects_Admin.Accounts.AccountOwners.txtBx_FederalStateNo(Configuration.getInstance().eDriver).sendKeys("89");//Federal State Number
		Objects_Admin.Accounts.AccountOwners.txtBx_CompanyNo(Configuration.getInstance().eDriver).sendKeys("87654321");//Company Number
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click Create
	}
}
