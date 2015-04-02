package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public final class NavigatetoOverviews {
	
	private NavigatetoOverviews() {
		// TODO Auto-generated constructor stub
	}
	private static NavigatetoOverviews INSTANCE=null;
	
	public static NavigatetoOverviews getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new NavigatetoOverviews();
		}
		return INSTANCE;
	}
	
	public void navigateToDashboard(String dashBoard) {
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='"+dashBoard+"']")).click();
		} catch (Exception e) {
			System.out.println("Application version is above 4.3.1SR1.1");
		}
		try {
			Configuration.getInstance().eDriver.findElement(By.id("metaNavigationAdminButtonRight_button")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='metaNavigationAdminButtonRight_menu']//a[span='"+dashBoard+"']")).click();
			System.out.println("User have BANKING roles");
		} catch (Exception e) {
			try {
				Configuration.getInstance().eDriver.findElement(By.id("metaNavigationAdminButtonLeft_button")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//div[@id='metaNavigationAdminButtonLeft_menu']//a[span='"+dashBoard+"']")).click();
				System.out.println("User doesn't have BANKING roles");
			} catch (Exception e2) {
				System.out.println("User doesn't have "+dashBoard+" role");
			}
		}
	}
	//Banking
	//CashManagement
	
	//Import Journal
	public void bankingCashManagementImportJournal()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash management']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Import Journal']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Payments Overview
	public void bankingPaymentsOverview() throws InterruptedException
	{
			try {
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("(//a[span='Overview'])[2]")).click();
//				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']..//a[span='Overview']")).click();	
			} catch (Exception e) {
				System.out.println("User doesn't have Banking Roles");
				Reporter.log("User doesn't have Banking Roles");
			}
	}
	//SEPA Credit Payments
	public void bankingPaymentsSepaCredit()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA (Credit)']")).click();	
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//SEPA Credit Reports
	public void bankingPaymentsSepaReportsCredit()
	{
		try {
				
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//SEPA Debit Payments
	public void bankingPaymentsSepadebit()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA (Debit)']")).click();	
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//SEPA Debit Reports
	public void bankingPaymentsSepaReportsDebit()
	{
		try {
				
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Domestic Payments
	public void bankingPaymentsDomestic()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Domestic']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//XML Urgent Payments
	public void bankingPaymentsXMLUrgent() {
		
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='XML urgent']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Foreign Payments
	public void bankingPaymentsForeign()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Foreign']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Euro Urgent Payments
	public void bankingPaymentsEuroUrgent()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Euro urgent']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//RFT Payments
	public void bankingPaymentsRFT()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='RFT (MT101)']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//EuropeanGate Payments
	public void bankingPaymentsEuropeanGate()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='EuropeanGate']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Beneficiaries
	public void bankingPaymentsBeneficiaries()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Beneficiaries / ']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//SEPA Mandate
	public void bankingPaymentsSepaMandate() throws InterruptedException
	{
		Thread.sleep(2000);
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA mandate']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Payment Templates
	public void bankingPaymentsTemplates()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Templates']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Periodic Payments
	public void bankingPaymentsPeriodic()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Periodic']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}	
	}
	//Invoices
	public void bankingPaymentsInvoices()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Invoices']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Payment Import Journal
	public void bankingPaymentsImportJournal()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Import Journal']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//AWV Reports
	public void bankingAWVReports() throws InterruptedException
	{
		
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Reports']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//AWV Templates
	public void bankingAWVTemplates()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Templates']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//AWV Transactions
	public void bankingAWVTransactions()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Transactions']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Signatures
	public void bankingSignatures()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Signature']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Send Orders
	public void bankingOrdersSendJobs()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Orders']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Send jobs']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	//Fetch Jobs
	public void bankingOrdersFetchJobs()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Orders']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Fetch jobs']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//SendJobs Upload Journal
	public void bankingOrdersUploadJournal()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Orders']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Upload Journal']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	public void bankingSepaToolspaymentTemplateConversion()
	{
		try {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA Tools']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Upload Journal']")).click();
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}		
	}
	public void bankingSepaToolsperiodicPaymentsConversion()
	{
		try {
		
		} catch (Exception e) {
			System.out.println("User doesn't have Banking Roles");
			Reporter.log("User doesn't have Banking Roles");
		}
	}
	//Admin
	//User Management
	public void adminUsersUserManagement() throws InterruptedException
	{
		
			navigateToDashboard("Admin");
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='User management']")).click();
	}
	public void adminUsersPermissionGroups() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Permission groups']")).click();		
	}
	public void adminAccountsAccountManagement() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Accounts']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Account management']")).click();
	}
	public void adminAccountsAccountOwners() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Accounts']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Account owner']")).click();
	}
	public void adminBanksBankManagement() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Bank management']")).click();
	}
	public void adminBanksChannels() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Channels']")).click();
	}
	public void adminBanksCustomers() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Customers']")).click();
	}
	public void adminBanksBankUsers() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Bank users']")).click();
	}
	public void adminBanksOrderTypes() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Order types']")).click();
	}
	public void adminBanksKeys() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Keys']")).click();
	}
	public void adminBanksKeyJobs() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Key jobs']")).click();
	}
	public void adminDataExchangeAutoImport() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Data exchange']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Auto import']")).click();
	}
	public void adminDataExchangeAutoExport() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Data exchange']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Auto export']")).click();
	}
	public void adminDataExchangeExportConversions() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Data exchange']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Export conversions']")).click();
	}
	public void adminDataExchengeImportJournal() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Data exchange']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Import journal']")).click();
	}
	public void adminApprovalsPendingApprovals() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Approvals']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Pending approvals']")).click();
	}
	public void adminApprovalsPendingWizardApprovals() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Approvals']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Pending wizard approvals']")).click();
	}
	public void adminJobs() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Jobs']")).click();
	}
	public void adminAWVExtranetID() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Extranet-ID']")).click();
	}
	public void adminAWVExtranetSubscription() throws InterruptedException
	{
		navigateToDashboard("Admin");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Extranet subscription']")).click();
	}
	//SYSTEM
	public void systemOrganisations() throws InterruptedException
	{
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Organisations']")).click();
	}
	public void systemProxy() throws InterruptedException
	{
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Proxy']")).click();
	}
	public void systemSettingsMailServer() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Mail Server']")).click();
	}
	public void systemSettingsTracing() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Tracing']")).click();
	}
	public void systemSettingsLicense() throws InterruptedException
	{
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='License']")).click();
	}
	public void systemSettingsSystem() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='System']")).click();
	}
	public void systemSettingsSystemInfo() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='System info']")).click();
	}
	public void systemMonitorSystem() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Monitor']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='System']")).click();
	}
	public void systemMonitorJobs() throws InterruptedException {
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Monitor']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Jobs']")).click();
	}
	public void systemJobs() throws InterruptedException
	{
		navigateToDashboard("System");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Jobs']")).click();
	}
	//Audit
	public void auditUsers() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
	}
	public void auditSecuritySettingsPasswords() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Security settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Passwords']")).click();
	}
	public void auditSecuritySettingsLogging() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Security settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
	}
	public void auditSecuritySettingsnEye() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Security settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='n-Eye']")).click();
	}
	public void auditSecuritySettingsKeybag() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Security settings']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Keybag']")).click();
	}
	public void auditCleanup() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cleanup']")).click();
	}
	//Logging
	public void auditLoggingPayments() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Payments']")).click();
	}
	public void auditLoggingTemplates() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Templates']")).click();
	}
	public void auditLoggingPeriodic() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Periodic']")).click();
	}
	public void auditLoggingBeneficiary() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Beneficiary']")).click();
	}
	public void auditLoggingSEPAMandate() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='SEPA mandate']")).click();
	}
	public void auditLoggingAWVReports() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV reports']")).click();
	}
	public void auditLoggingAWVTemplates() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV templates']")).click();
	}
	public void auditLoggingAWVTransactions() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='AWV transactions']")).click();
	}
	public void auditLoggingSendJobs() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Send jobs']")).click();
	}
	public void auditLoggingUsers() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
	}
	public void auditLoggingPermissionGroups() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Permission groups']")).click();
	}
	public void auditLoggingBanks() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
	}
	public void auditLoggingChannels() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Channels']")).click();
	}
	public void auditLoggingAccounts() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Accounts']")).click();
	}
	public void auditLoggingCashMgmntData() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Cash Mgmnt. Data']")).click();
	}
	public void auditLoggingAccountOwners() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Account owners']")).click();
	}
	public void auditLoggingCustomers() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Customers']")).click();
	}
	public void auditLoggingBankUsers() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Bank users']")).click();
	}
	public void auditLoggingAutoImport() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Auto import']")).click();
	}
	public void auditLoggingAutoExport() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Auto export']")).click();
	}
	public void auditLoggingExtranet() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Extranet']")).click();
	}
	public void auditLoggingExtranetSubscription() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Extranet Subscription']")).click();
	}
	public void auditLoggingOrganisations() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Organisations']")).click();
	}
	public void auditLoggingProxy() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Proxy']")).click();
	}
	//Audit Logging
	public void auditAuditLoggingUser() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Audit Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='User']")).click();
	}
	public void auditAuditLoggingOrganisation() throws InterruptedException {
		navigateToDashboard("Audit");
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Audit Logging']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Organisation']")).click();
	}
	
	
	public String toString() {
		return "Object for NavigatetoOverview";
	}
}