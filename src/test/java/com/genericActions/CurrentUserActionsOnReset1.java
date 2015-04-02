package com.genericActions;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utility.Configuration;

public class CurrentUserActionsOnReset1 {
	
	@Test
	public void addRoles() throws InterruptedException
	{
		String username = "Hemasundar";
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='User management']")).click();
		Thread.sleep(2000);	
		Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[2][text()='Hemasundar']]//button[@alt='Edit']")).click();////Clicking Super Edit for User: HemaSundar
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
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[contains(.,'Apply changes')]")).click();//Clicking Apply changes
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.id("infoWithoutAction")).click();//Click OK on Info pop-up
		Thread.sleep(2000);		
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Thread.sleep(1000);
	}
	public boolean isAlertPresent() 
	{
		try{
            Configuration.getInstance().eDriver.switchTo().alert();
            return true;
        }
        catch(Exception e){
            return false;
        }
	}
	@Test
	public void updateChannel() throws InterruptedException
	{
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Channels']")).click();
		Thread.sleep(2000);
		//Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[2][text()='HypoVereinsbank'] and ./td[3][text()='EBICS']//button[@alt='Edit']]")).click();
		
		
		WebElement overviewChnls = Configuration.getInstance().eDriver.findElement(By.id("defaultOverviewTable_data"));
		List<WebElement> indChnl = overviewChnls.findElements(By.tagName("tr"));
		for(WebElement a : indChnl)
		{
			List<WebElement> indClmn = a.findElements(By.tagName("td"));
			if(indClmn.get(1).getText().equalsIgnoreCase("HypoVereinsbank"))
			{
				List<WebElement> allBtnsChnl = a.findElements(By.tagName("button"));
				for(WebElement c : allBtnsChnl)
				{
					if(c.getAttribute("title").matches("Edit"))
					{
						c.click();
						break;
					}
				}
				break;
			}
		}
		
		Configuration.getInstance().eDriver.findElement(By.id("channel-serverUrl")).sendKeys("https://port-212-202-124-81.static.qsc.de/mv-ebics/");
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Apply changes']")).click();
		
		Thread.sleep(2000);
		//Configuration.getInstance().eDriver.findElement(By.id("linkToWelcome1")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Thread.sleep(1000);
	}
	@Test
	public void createCustBank() throws InterruptedException
	{
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Customers']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='New']")).click();//Click New Button
		Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();//Click on Bank drop down
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//div[starts-with(@id,'j_idt') and contains(@id,'_panel')]//li[text()='HypoVereinsbank']")).click();//Select HypoVereinsbank Bank 
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.id("alias")).sendKeys("PRIME1R0");
		Configuration.getInstance().eDriver.findElement(By.id("bcsid")).sendKeys("PRIME1R0");
		Configuration.getInstance().eDriver.findElement(By.id("techContextAlias")).sendKeys("PRIME1RT");
		Configuration.getInstance().eDriver.findElement(By.id("techContextBcs")).sendKeys("PRIME1RT");
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Create']")).click();//Click Create Button
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
	}
	@Test
	public void bankUser() throws InterruptedException
	{
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Customers']")).click();
		Thread.sleep(2000);
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//tbody[@id='defaultOverviewTable_data']/tr[./td[3][text()='PRIME1R0']]//button[@alt='Edit']")).click();
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.linkText("Add new bank user Id")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.id("j_idt122_label")).click();
		//Configuration.getInstance().eDriver.findElement(By.xpath("//label[contains(@id,'j_idt')]")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='j_idt122_panel']/div/ul/li[3]")).click();//Need to improve
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//input[contains(@id,'j_idt')]")).sendKeys("PRIME1R1");
		Configuration.getInstance().eDriver.findElement(By.xpath("//input[contains(@id,'j_idt')][2]")).sendKeys("PRIME1R1");
		Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Create']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
	}
	@Test
	public void fetchCustKeys() throws InterruptedException
	{
		int count = 0;
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banks']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Customers']")).click();
		Thread.sleep(2000);
		//Click Fetch icon
		WebElement overviewChnls = Configuration.getInstance().eDriver.findElement(By.id("defaultOverviewTable_data"));
		List<WebElement> indCust = overviewChnls.findElements(By.tagName("tr"));
		for(WebElement a : indCust)
		{
			List<WebElement> indClmn = a.findElements(By.tagName("td"));
			if(indClmn.get(3).getText().equalsIgnoreCase("PRIME1RT"))
			{
				
				List<WebElement> allBtnsCust = a.findElements(By.tagName("button"));
				for(WebElement c : allBtnsCust)
				{
										
					if(c.getAttribute("title").matches("Fetch bank master data (HKD)"))
					{
						c.click();
						count++;
						break;
					}
				}
				if (count == 0)
				{
					System.out.println("First Create the keys for Customer");
				}
				break;
			}
		}
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
		Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Banking']")).click();
	}
}
