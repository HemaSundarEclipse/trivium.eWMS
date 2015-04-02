package com.genericActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class SmokeTest {
	
//	@org.testng.annotations.Test (priority=0)
	public void banking() throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		NavigateAllOverviews("Cash management");
		NavigateAllOverviews("Payments");
		NavigateAllOverviews("AWV");
		NavigateAllOverviews("Signature");
		NavigateAllOverviews("SEPA Tools");
	}
//	@Test (priority=1)
	public void admin() throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().navigateToDashboard("Admin");
		
		NavigateAllOverviews("Users");
		NavigateAllOverviews("Accounts");
		NavigateAllOverviews("Banks");
		NavigateAllOverviews("Data exchange");
		NavigateAllOverviews("Approvals");
		NavigateAllOverviews("Jobs");
		NavigateAllOverviews("AWV");
	}
//	@Test(priority=2)
	public void system() throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().navigateToDashboard("System");
		
		NavigateAllOverviews("Organisations");
		NavigateAllOverviews("Proxy");
		NavigateAllOverviews("Settings");
		NavigateAllOverviews("Monitor");
		NavigateAllOverviews("Jobs");
	}
	@Test(priority=3)
	public void audit() throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().navigateToDashboard("Audit");
		
		NavigateAllOverviews("Users");
		NavigateAllOverviews("Security settings");
//		NavigateAllOverviews("Cleanup");
		NavigateAllOverviews("Logging");
		NavigateAllOverviews("Audit Logging");
	}
	@Test(priority=4)
	public void configuration() throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().navigateToDashboard("Configuration");
		
		NavigateAllOverviews("Overviews");
		NavigateAllOverviews("Preferences");
	}
	
	
	public void NavigateAllOverviews(String mainMenu) throws InterruptedException {
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='"+mainMenu+"']")).click();
		List<WebElement> SubMenus = Configuration.getInstance().eDriver.findElements(By.xpath("//a[span='"+mainMenu+"']/following-sibling::ul/li[./a]"));
		int noSubMenus = SubMenus.size();
		System.out.println(noSubMenus);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='"+mainMenu+"']")).click();
		for (int i = 1; i <= noSubMenus; i++) {
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='"+mainMenu+"']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("(//a[span='"+mainMenu+"']/following-sibling::ul/li[./a])["+i+"]")).click();
			Thread.sleep(2000);
			System.out.println(Configuration.getInstance().eDriver.findElement(By.className("ui-toolbar-group-left")).getText());
		}
	}
}