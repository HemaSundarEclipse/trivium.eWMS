package com.admin.banks.bankUsers;
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
import com.utility.GenericMethods;
import com.utility.NavigatetoOverviews;

public class BankUsers {
	public void createBankUser(String custName, String custID, String userAlias, String userName, String userSurname, String bankUserAlias, String bankUserID) throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Customer ID']/following-sibling::td//label")).click();//Click on Customer ID drop down
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("html/body/div[last()-1]//li[text()='"+custName+" - "+custID+"']")).click(); // Select Customer
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[text()='System user']/following-siblig::td//label")).click();//Click on System User drop down
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.xpath("html/body/div[last()]//li[text()='"+userAlias+"- "+userName+" "+userSurname+"']")).click();//Select system user
		com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_UserAlias(Configuration.getInstance().eDriver).sendKeys(custName);//Bank User alias
		com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_BankUserID(Configuration.getInstance().eDriver).sendKeys(custID);//Bank user ID
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click on Create button
	}
	@Test
	public void creatingBankUsersForMigration() throws InterruptedException, BiffException, IOException 
	{
		
		NavigatetoOverviews.getInstance().adminBanksBankUsers();
		Thread.sleep(2000);
		
		
		FileInputStream fs = new FileInputStream("D:\\Hema\\Google Drive\\eclipse_project\\Selenium\\trivium.eWMS\\src\\test\\java\\com\\testData\\Migration.xls");
		Workbook wb = Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet("Banks");
		
		int i =2;
		for(int r=7; r<ws.getRows();r++)
		{
			int k =1;
			for (int j = 1; j <= 2; j++) 
			{
					String bank=ws.getCell(0, r).getContents();
					
					Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
					
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Customer ID']/following-sibling::td//label")).click();//Click on Customer ID drop down
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='"+bank+"C"+j+" - "+bank.substring(0, Math.min(bank.length(), 6)).toUpperCase()+"C"+j+"']")).click();//Select CUstomer
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='System user']/following-sibling::td//label")).click();//Click on System user drop down
//					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='Hema- Hema Hema']")).click();//Select System user
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='Sunil- Sunil Sunil']")).click();//Select System user
					
					Thread.sleep(1000);
					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_UserAlias(Configuration.getInstance().eDriver).sendKeys(bank+"B"+k+"n");//Bank user alias
//					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_BankUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(bank.length(), 6)).toUpperCase()+"B"+k);//Bank user ID
					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_BankUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(bank.length(), 5)).toUpperCase()+"B"+k+"n");//Bank user ID
					Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click create button
					
					GenericMethods.checkingForValidationErrors();//Check for validation errors
					k++;
					Thread.sleep(1000);
					Configuration.getInstance().eDriver.findElement(By.linkText("Back to Overview")).click();
					Thread.sleep(2000);
					
					com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click new
					
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='Customer ID']/following-sibling::td//label")).click();//Click on Customer ID drop down
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='"+bank+"C"+j+" - "+bank.substring(0, Math.min(bank.length(), 6)).toUpperCase()+"C"+j+"']")).click();//Select Custome
					Configuration.getInstance().eDriver.findElement(By.xpath("//td[span='System user']/following-sibling::td//label")).click();//Click on System user drop down
//					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='HemaSundar- HemaSundar HemaSundar']")).click();//Select system user
					Configuration.getInstance().eDriver.findElement(By.xpath("//ul/li[text()='Kumar- Kumar Kumar']")).click();//Select system user
					
//					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_UserAlias(Configuration.getInstance().eDriver).sendKeys(bank+"B"+k);//Bank user alias
					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_UserAlias(Configuration.getInstance().eDriver).sendKeys(bank+"B"+k+"n");//Bank user alias
//					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_BankUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(bank.length(), 6)).toUpperCase()+"B"+k);//Bank user ID
					com.pageObjects.Objects_Admin.Banks.BankUsers.txtBx_BankUserID(Configuration.getInstance().eDriver).sendKeys(bank.substring(0, Math.min(bank.length(), 5)).toUpperCase()+"B"+k+"n");//Bank user ID
					Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click on Create button
					
					GenericMethods.checkingForValidationErrors();//Check for validation errors
					k++;
					Thread.sleep(1000);
					Configuration.getInstance().eDriver.findElement(By.linkText("Back to Overview")).click();
					Thread.sleep(2000);
			}
		}			
	}
}