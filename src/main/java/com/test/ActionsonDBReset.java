package com.test;

import org.testng.annotations.Test;

import com.admin.users.userManagement.UserManagagement;
import com.system.organisations.Organisations;
import com.system.settings.license.License;
import com.utility.NavigatetoOverviews;

public class ActionsonDBReset {
	
	@Test
	public void name1() throws InterruptedException {

		License lic = new License();
		Organisations org = new Organisations();
		UserManagagement um = new UserManagagement();
		/*
		NavigatetoOverviews.getInstance().systemSettingsLicense();
		lic.updatingLicense();
		
		NavigatetoOverviews.getInstance().systemOrganisations();
		Thread.sleep(2000);
		org.updateEnhancedOptions("Default Organisation");
		*/
//		
		NavigatetoOverviews.getInstance().adminUsersUserManagement();
		Thread.sleep(2000);
		um.createUser("Suresh", "Suresh", "Suresh");
		um.createUser("Nitish", "Nitish", "Nitish");
		um.createUser("Pramath", "Pramath", "Pramath");
		um.createUser("HemaSundar", "HemaSundar", "HemaSundar");
		um.createUser("Sunil", "HemaSundar", "HemaSundar");
		um.createUser("SriVidya", "SriVidya", "SriVidya");
		um.createUser("SreeLatha", "SreeLatha", "SreeLatha");
	}
}