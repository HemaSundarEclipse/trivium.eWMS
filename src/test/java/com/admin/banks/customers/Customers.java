package com.admin.banks.customers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.GenericMethods;
import com.utility.NavigatetoOverviews;

public class Customers {
	
	Random random = new Random();
	public void createCustomer(String bankName, String customername, String customerID) throws InterruptedException
	{
		NavigatetoOverviews.getInstance().adminBanksCustomers();
		Thread.sleep(2000);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click New Button
		Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();//Click on Bank drop down
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[starts-with(@id,'j_idt') and contains(@id,'_panel')]//li[text()='"+bankName+"']")).click();//Select HypoVereinsbank Bank 
		Thread.sleep(2000);
		com.pageObjects.Objects_Admin.Banks.Customers.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(customername);//Alias
		com.pageObjects.Objects_Admin.Banks.Customers.txtBx_CustomerID(Configuration.getInstance().eDriver).sendKeys(customername);//Customer-ID
		com.pageObjects.Objects_Admin.Banks.Customers.txtBx_AliasTechnicalBankUser(Configuration.getInstance().eDriver).sendKeys(customerID);//Alias technical bank user
		com.pageObjects.Objects_Admin.Banks.Customers.txtBx_TechnicalUserID(Configuration.getInstance().eDriver).sendKeys(customerID);//Technical user-ID (EBICS)
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click Create Button
	}
	@Test
	public void creatingCudtomersForMigration() throws InterruptedException, BiffException, IOException 
	{
//		nav.adminBanksCustomers();
		
		NavigatetoOverviews.getInstance().adminBanksCustomers();
		Thread.sleep(2000);
		
		
		FileInputStream fs = new FileInputStream("D:\\Hema\\Google Drive\\eclipse_project\\Selenium\\trivium.eWMS\\src\\test\\java\\com\\testData\\Migration.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Banks");
		
		int i =2;
		for(int r=7; r<ws.getRows();r++)
		{
			for (int j = 1; j <= 2; j++) 
			{
				Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
				
				Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Bank name']/following-sibling::td//label")).click();//Click Bank drop down
				Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='"+ws.getCell(0, r).getContents()+"']")).click();//Select Bank
				Thread.sleep(1000);
				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(ws.getCell(0, r).getContents()+"C"+j+"n");//Enter Customer Alias
				String bank=ws.getCell(0, r).getContents();
//				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_CustomerID(Configuration.getInstance().eDriver).sendKeys(ws.getCell(0, r).getContents().substring(0, Math.min(bank.length(), 6))+"C"+j);//Enter Customer ID
				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_CustomerID(Configuration.getInstance().eDriver).sendKeys(ws.getCell(0, r).getContents().substring(0, Math.min(bank.length(), 5))+"C"+j+"n");//Enter Customer ID
				
				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_AliasTechnicalBankUser(Configuration.getInstance().eDriver).sendKeys(ws.getCell(0, r).getContents()+"T"+j+"n");//Enter Teschnicle User Alias
//				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_TechnicalUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(ws.getCell(0, r).getContents().length(), 6))+"T"+j);//Enter Technicle User ID
				com.pageObjects.Objects_Admin.Banks.Customers.txtBx_TechnicalUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(ws.getCell(0, r).getContents().length(), 5))+"T"+j+"n");//Enter Technicle User ID
				
				com.pageObjects.Objects_Admin.Banks.Customers.chkBx_AllowTechnicalUserToCreateFetchJobs(Configuration.getInstance().eDriver).click();//Click All send jobs check box
				
//				try 
//				{
//					//Code for selecting A006 Security type check box
//				} catch (Exception e) 
//				{
//				
//				}
				
//				Configuration.getInstance().eDriver.findElement(By.id("defaultSecurityContext_label")).click();//Click Default security type drop down
//				List<WebElement> defaultSecurityTypes = Configuration.getInstance().eDriver.findElements(By.xpath("//*[@id='defaultSecurityContext_panel']/div/ul/li"));//List of available security types
//				defaultSecurityTypes.get(random.nextInt(defaultSecurityTypes.size())).click();//Selecting random value for security type
				
				
				String[] trick = {"//ul/li[text()='Non-Standard(Sparkasse)']", "//ul/li[text()='Standard']"};
				
//				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='defaultSecTypesbcs']/tbody/tr[2]/td[2]//label")).click();//Click on advice handler drop down
////			Configuration.getInstance().eDriver.findElement(By.xpath("//label[text()='Advice(MT942) handler']/../following-sibling::td//label")).click();//Click on advice handler drop down
//				Configuration.getInstance().eDriver.findElement(By.xpath(trick[i%0])).click();//Select Advice Handler
//				if (i%2==0) 
//				{
//					//Don't check DES by bank check box
//				}else
//				{
//					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='defaultSecTypesbcs']/tbody/tr[3]/td[2]/div/div[2]")).click();//Select DES By Support check box
//					Configuration.getInstance().eDriver.findElement(By.xpath("//label[text()='DES support']/../following-sibling::td/div/div[2]")).click();//Select DES By Support check box	
//				}
				Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
				
				GenericMethods.checkingForValidationErrors();
				i++;
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.linkText("Back to Overview")).click();
				Thread.sleep(2000);
			}
		}
	}
}