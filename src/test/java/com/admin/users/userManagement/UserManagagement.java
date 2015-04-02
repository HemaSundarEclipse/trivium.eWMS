package com.admin.users.userManagement;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageObjects.Objects_Common;
import com.thoughtworks.selenium.Selenium;
import com.utility.Configuration;
import com.utility.Constant;
import com.utility.ExcelUtils;
import com.utility.NavigatetoOverviews;

public class UserManagagement
{
	
	Random ran = new Random();
//	@BeforeClass
//	public void beforeClass() throws InterruptedException, IOException {
//		nav.adminUsersUserManagement();
//		Thread.sleep(3000);
//		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData_Migration, "Banks");
//	}
	public void createUser(String sysUserAlias,String sysUserName, String sysUserSurname) throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
//		List<String> lst =  new ArrayList<>();
//		lst.add("Suresh");
//		lst.add("Nitish");
//		lst.add("Pramath");
//		lst.add("HemaSundar");
//		lst.add("Sunil");
//		lst.add("SriVidya");
//		lst.add("SreeLatha");
//		
//		for(String x : lst) {
		
			com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click on 'New' button
			Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
//			com.pageObjectFactory.Objects_Admin.Users.UserManagement.txtBx_Alias.sendKeys(sysUserAlias);//Enter "Alias" value
			com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(sysUserAlias);//Enter "Alias" value
			com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_FirstName(Configuration.getInstance().eDriver).sendKeys(sysUserName);//Enter "First Name" value
			com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_SurName(Configuration.getInstance().eDriver).sendKeys(sysUserSurname);//Enter "Surname" value
			//Code for selecting Roles
			if (sysUserName.equalsIgnoreCase("suresh") || sysUserName.equalsIgnoreCase("hemasundar"))
			{
//				Configuration.getInstance().eDriver.findElement(By.xpath("//td[./label[text()='Banking']]/preceding-sibling::td/div/div[2]")).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Banking(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Admin(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_System(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_EuropeanGate(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_SAP(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Audit(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_ConfidentialPayments(Configuration.getInstance().eDriver).click();
				Thread.sleep(1000);
				Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_iPhoneApp(Configuration.getInstance().eDriver).click();
//				for (int j= 1; j<=8; j++)
//				{
//					Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr["+j+"]/td[1]/div/div[2]")).click();
//					try
//					{
//						Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
//					}
//					catch (Exception e)
//					{
//						
//					}
//					boolean y = check_alert();
//				}
			}
			else
			{
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Banking(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Admin(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_System(Configuration.getInstance().eDriver).click();
				com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_Audit(Configuration.getInstance().eDriver).click();
			}
			Thread.sleep(3000);
			com.pageObjects.Objects_Admin.Users.UserManagement.icn_Assign(Configuration.getInstance().eDriver).click();//Click on "Assign" icon
			
			// Code for selecting PermGroup using getText
			
			Thread.sleep(2000);
//			Configuration.getInstance().eDriver.findElement(By.xpath("//span[text()='ALL']/preceding-sibling::div")).click();//Select "ALL" permission group
			Configuration.getInstance().eDriver.findElement(By.xpath("//div[span='ALL']/div[2]")).click();
			Thread.sleep(2000);
			com.pageObjects.Objects_Admin.Users.UserManagement.btn_ApplySelection(Configuration.getInstance().eDriver).click();//Select "Apply selection" for Assigned Permission groups
			Thread.sleep(4000);
			Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click on "Create" button
//		}
	}
	public void addRoles(String sysuser) throws InterruptedException
	{
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[2][text()='"+sysuser+"']]//button[@alt='Edit']")).click();////Clicking Super Edit for User: HemaSundar
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.linkText("Edit")).click();//Click on "Edit" in super edit menu
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		// Selecting the unchecked Roles
		for (int i = 0; i<=7; i++)
		{
			if (Configuration.getInstance().eDriver.findElement(By.id("rolesForSessionUserOrg:"+i+"")).isSelected())
			{
				
			}
			else
			{
				Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr["+(i+1)+"]/td[1]/div/div[2]")).click();
				Thread.sleep(1000);
				//Clicking OK in the information popup displayed for Confidential role
				try
				{
					Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
				}
				catch (Exception e)
				{
					
				}
			}
		}
		com.pageObjects.Objects_Common.btn_Applychanges(Configuration.getInstance().eDriver).click();//Clicking Apply changes
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();//Click OK on Info pop-up
		Thread.sleep(2000);
	}
	@Test
	public void test() throws InterruptedException, IOException
	{
		
//		createUser("Ramesh", "Ramesh", "Ramesh");
//		creatingUsersforMigration("Ramesh", "Ramesh", "Ramesh");
		
		NavigatetoOverviews.getInstance().adminUsersUserManagement();
		ExcelUtils.getInstance().setExcelFile(Constant.File_TestData_Migration, "Banks");
		for (int i = 1; i < 20; i++) {
//			creatingUsersforMigration(ExcelUtils.getCellData(i, 0), ExcelUtils.getCellData(i, 0), ExcelUtils.getCellData(i, 0));
			assigningRandomModulePermissions(ExcelUtils.getInstance().getCellData(i, 0));
		}
		
	}
	
	public void creatingUsersforMigration(String sysUserAlias,String sysUserName, String sysUserSurname) throws InterruptedException, IOException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();//Click on 'New' button
		
		Thread.sleep(1000);
		com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_Alias(Configuration.getInstance().eDriver).sendKeys(sysUserAlias);//Enter "Alias" value
		Thread.sleep(1000);
		com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_FirstName(Configuration.getInstance().eDriver).sendKeys(sysUserName);//Enter "First Name" value
		com.pageObjects.Objects_Admin.Users.UserManagement.txtBx_SurName(Configuration.getInstance().eDriver).sendKeys(sysUserSurname);//Enter "Surname" value
		Thread.sleep(3000);
		//Code for selecting Roles
		String[] userRoles = {"Banking", "Admin", "System", "EuropeanGate", "SAP", "Audit", "Confidential Payments", "iPhone App"};
		
		for (int j = 0; j < 3; j++) {
			int k = ran.nextInt(userRoles.length);
			System.out.println(k);
			com.pageObjects.Objects_Admin.Users.UserManagement.chkBx_UserRoles(userRoles[k], Configuration.getInstance().eDriver).click();
			
			Thread.sleep(1000);
			
			try {
				Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
			
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();//Click on "Create" button
	}
	public void assigningRandomModulePermissions(String sysuser) throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//Performing search
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[@class='action-button_div']//button[@alt='Search']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//thead[@id='defaultOverviewTable_head']/tr/th[2]/input")).sendKeys(sysuser);
		Configuration.getInstance().eDriver.findElement(By.xpath("//thead[@id='defaultOverviewTable_head']/tr/th[2]/input")).sendKeys(Keys.ENTER);
		
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[@alt='Edit']")).click();////Clicking Super Edit for User: HemaSundar
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.linkText("Module permission")).click();//Click on "Edit" in super edit menu
		Thread.sleep(2000);
//		Configuration.getInstance().eDriver.findElement(By.xpath("//label[text()='Module']/preceding-sibling::button")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//thead[@id='permissionTable_head']/tr/th[2]//button")).click();
		Thread.sleep(2000);
		
		List<WebElement> allChkBxs = Configuration.getInstance().eDriver.findElements(By.className("ui-chkbox-box"));
		
		System.out.println("Size: "+allChkBxs.size());
		int k= 1;
		for (int i = 0; i < 20; i++) {
			k= ran.nextInt(allChkBxs.size());
			for (int j = 0; j < 200; j++) {
				Configuration.getInstance().eDriver.executeScript("window.scrollByLines(2)");
				
				try {
					allChkBxs.get(k).click();
				} catch (ElementNotVisibleException e) {
					
				}
				
			}
		}
		
		Objects_Common.btn_Applychanges(Configuration.getInstance().eDriver);
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();
		Thread.sleep(1000);
	}
}