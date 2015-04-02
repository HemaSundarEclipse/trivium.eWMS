package com.admin.users.permissionGroups;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class PermissionGroup {

	@Test
	public void creatingPermissionGroup() throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().adminUsersPermissionGroups();
		Thread.sleep(1000);
		
		
		
		for (int i = 915; i < 2000; i++) {
			
			com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
			Thread.sleep(2000);
			com.pageObjects.Objects_Admin.Users.PremisionGroups.txtBx_Name(Configuration.getInstance().eDriver).sendKeys("permissionGroup "+i);
			Thread.sleep(1000);
			com.pageObjects.Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
			Thread.sleep(2000);
		}
		
	}
}
