package com.pageObjects;

import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.utility.Configuration;

public class Objects_Admin {
	
	private static WebElement element = null;
	public static class Users {
		
		public static class UserManagement {
			
			public static WebElement txtBx_Alias(WebDriver eDriver) {
				element = eDriver.findElement(By.id("alias"));
				return element;
			}
			
			public static WebElement txtBx_FirstName(WebDriver eDriver) {
				element = eDriver.findElement(By.id("firstName"));
				return element;
			}
			
			public static WebElement txtBx_SurName(WebDriver eDriver) {
				element = eDriver.findElement(By.id("name"));
				return element;
			}
			
			public static WebElement chkBx_Banking(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='Banking']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_Admin(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='Admin']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_System(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='System']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_EuropeanGate(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='EuropeanGate']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_SAP(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='SAP']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_Audit(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='Audit']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_ConfidentialPayments(WebDriver eDriver) throws InterruptedException {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='Confidential Payments']]/td[1]/div/div[2]"));
				Thread.sleep(1000);
				try {
					eDriver.findElement(By.id("infoWithoutAction")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return element;
			}
			
			public static WebElement chkBx_iPhoneApp(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='iPhone App']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement chkBx_UserRoles(String role, WebDriver eDriver) throws InterruptedException {
				element = eDriver.findElement(By.xpath("//*[@id='rolesForSessionUserOrg']/tbody/tr[.//label[text()='"+role+"']]/td[1]/div/div[2]"));
				return element;
			}
			
			public static WebElement icn_Assign(WebDriver eDriver) {
				element = eDriver.findElement(By.id("permissionPopUpTrigger"));
				return element;
			}
			
			public static WebElement btn_ApplySelection(WebDriver eDriver) {
				element = eDriver.findElement(By.id("blockPanelSaveButton"));
				return element;
			}
		}
		public static class PremisionGroups
		{
			public static WebElement txtBx_Name(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='Name']/following-sibling::td/input"));
				return element;
			}
		}
		public class UserWizard
		{
			
		}
	}
	public static class Accounts
	{
		public class AccountManagement
		{
			
		}
		public static class AccountOwners
		{
			public static WebElement txtBx_Alias(WebDriver eDriver) {
				
				element = eDriver.findElement(By.id("paymentParty-alias"));
				return element;
			}
			public static WebElement txtBx_Name1(WebDriver eDriver) {
				element = eDriver.findElement(By.id("paymentParty-name"));
				return element;
			}
			public static WebElement txtBx_Town(WebDriver eDriver) {
				element = eDriver.findElement(By.id("paymentParty-address-townName"));
				return element;
			}
			public static WebElement txtBx_FederalStateNo(WebDriver eDriver) {
				element = eDriver.findElement(By.id("paymentParty-federalStateNumber"));
				return element;
			}
			public static WebElement txtBx_CompanyNo(WebDriver eDriver) {
				element = eDriver.findElement(By.id("paymentParty-companyNumber"));
				return element;
			}
		}
		public class AccountWizard
		{
			
		}
	}
	public static class Banks
	{
		public static class BankManagement
		{
			public static WebElement txtBx_BankName(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//input[contains(@id, 'j_idt')]"));
				return element;
			}
			
			public static WebElement txtBx_BIC(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("(//input[contains(@id, 'j_idt')])[2]"));
				return element;
			}
			
			public static WebElement txtBx_TimeTillPTKFetchjob(WebDriver eDriver) {
				element = eDriver.findElement(By.id("timePeriodForAutoProtocolFetch"));
				return element;
			}
			
			public static WebElement txtBx_FaxNumberForINILetters(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Fax number for INI-Letters']/following-sibling::td/input/"));
				return element;
			}
		}
		public static class Channels
		{
			public static WebElement txtBx_URL(WebDriver eDriver) {
				element = eDriver.findElement(By.id("channel-serverUrl"));
				return element;
			}
			
			public static WebElement txtBx_HostID(WebDriver eDriver) {
				element = eDriver.findElement(By.id("channel-hostId"));
				return element;
			}
		}
		public static class Customers
		{
			public static WebElement txtBx_Alias(WebDriver eDriver) {
				element = eDriver.findElement(By.id("alias"));
				return element;
			}
			public static WebElement txtBx_CustomerID(WebDriver eDriver) {
				element = eDriver.findElement(By.id("bcsid"));
				return element;
			}
			public static WebElement txtBx_AliasTechnicalBankUser(WebDriver eDriver) {
				element = eDriver.findElement(By.id("techContextAlias"));
				return element;
			}
			public static WebElement txtBx_TechnicalUserID(WebDriver eDriver) {
				element = eDriver.findElement(By.id("techContextBcs"));
				return element;
			}
			
			public static WebElement chkBx_AllowTechnicalUserToCreateFetchJobs(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Allow technical user to create']/following-sibling::td/div/div[2]"));
				return element;
			}
		}
		public static class BankUsers
		{
			public static WebElement txtBx_UserAlias(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='User alias']/following-sibling::td/input"));
				return element;
			}
			
			public static WebElement txtBx_BankUserID(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Bank user-ID']/following-sibling::td/input"));
				return element;
			}
			
		}
		public static class OrderTypes
		{
			public static WebElement txtBx_OrderType(WebDriver eDriver) {
				element = eDriver.findElement(By.id("orderId"));
				return element;
			}
			
			public static WebElement txtBx_Description(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Description']/following-sibling::td/input"));
				return element;
			}
		}
		public class Keys
		{
			
		}
		public class KeyJobs
		{
			
		}
		public class BankWizard
		{
			
		}
	}
	public static class DataExchange
	{
		public static class AutoImport
		{
			public static WebElement txtBx_Alias(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Alias']/following-sibling::td/input"));
				return element;
			}
			
			public static WebElement txtBx_Directory(WebDriver eDriver) {
				element = eDriver.findElement(By.id("pathId"));
				return element;
			}
			
			public static WebElement txtBx_SaveDirectory(WebDriver eDriver) {
				element = eDriver.findElement(By.id("savePathId"));
				return element;
			}
			public static WebElement txtBx_FilePattern(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='File pattern']/following-sibling::td/input"));
				return element;
			}
			
			public static WebElement txtBx_DeleteLogsOlderThan(WebDriver eDriver) {
				element = eDriver.findElement(By.id("importObj-keepLogForDays"));
				return element;
			}
			
			public static WebElement chkBx_Confidential(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[./label[text()='Confidential']]/following-sibling::td/div/div[2]"));
				return element;
			}
			
		}
		public class AutoExport
		{
			
		}
		public class ExportConversions
		{
			
		}
		public class ImportJournal
		{
			
		}
	}
	public class AWV
	{
		public class ExtranetID
		{
			
		}
		public class ExtranetSubscriptin
		{
			
		}
	}
}
