package com.admin.banks.bankManagement;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

import bsh.This;

public class BankManagement {
	
	private String bankName;
	public BankManagement(String bankName) {
		super();
		this.bankName = bankName;
		
	}
	public void createBank() throws InterruptedException
	{
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Bank management']")).click();
		Thread.sleep(2000);
		
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
		
		com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_BankName(Configuration.getInstance().eDriver).sendKeys(bankName);//Bank Name
		com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_BIC(Configuration.getInstance().eDriver).sendKeys("AAAAAAAAAAA");//BIC
//		pageObjects.Objects_Admin.Banks.BankManagement.txtBx_TimeTillPTKFetchjob(Configuration.getInstance().eDriver).clear();
//		pageObjects.Objects_Admin.Banks.BankManagement.txtBx_TimeTillPTKFetchjob(Configuration.getInstance().eDriver).sendKeys(10);
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
	}
	@Test
	public void creatingBanksForMigration() throws BiffException, IOException, InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().adminBanksBankManagement();
		Thread.sleep(2000);		
		
		FileInputStream fs = new FileInputStream("D:\\Hema\\Google Drive\\eclipse_project\\Selenium\\trivium.eWMS\\src\\test\\java\\com\\testData\\Migration.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Banks");
		for(int r=1; r<ws.getRows();r++) {
			
			String Bankname = ws.getCell(0, r).getContents();
			System.out.println(Bankname);
			com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
			
			com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_BankName(Configuration.getInstance().eDriver).sendKeys(Bankname);//Bank Name
			com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_BIC(Configuration.getInstance().eDriver).sendKeys(ws.getCell(1, r).getContents());//BIC
			com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_TimeTillPTKFetchjob(Configuration.getInstance().eDriver).clear();
			com.pageObjects.Objects_Admin.Banks.BankManagement.txtBx_TimeTillPTKFetchjob(Configuration.getInstance().eDriver).sendKeys(ws.getCell(2, r).getContents());
			Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
//			Thread.sleep(1000);
//			Configuration.getInstance().eDriver.findElement(By.linkText("Back to Overview")).click();
			Thread.sleep(2000);
//			if(ws.getCell(1, r).getContents().equalsIgnoreCase("yes")) {
//				
//				Configuration.getInstance().eDriver.findElement(By.xpath("CheckBoxXpath")).click();
//			}
		}		
	}
}