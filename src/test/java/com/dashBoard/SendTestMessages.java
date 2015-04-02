package com.dashBoard;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class SendTestMessages {	
	
	@Test
	public void fetchCustKeys() throws Exception
	{
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='adminDashboardForm:systemInfo_currentUsers:dashboardLink']/tbody/tr/td[1]/a/span")).click();//Click on Admin Dashboard entry
		Thread.sleep(3000);
		for (int i=1; i<=200; i++)
		{
			Configuration.getInstance().eDriver.findElement(By.xpath("//button[contains(@id,'adminDashboardForm:currentLoggedInUsersTable:j_idt')]")).click();//Click on message button
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='adminDashboardForm:currentLoggedInUsersTable:messageSubjectBox']")).sendKeys("Hello message");//Enter Message headline
			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='adminDashboardForm:currentLoggedInUsersTable:messageInputBox']")).sendKeys("Test message:"+i);//Enter message body
			Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Send']")).click();//Click on Send button
		}
	}
}