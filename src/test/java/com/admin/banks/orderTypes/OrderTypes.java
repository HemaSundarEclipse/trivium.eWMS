package com.admin.banks.orderTypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pageObjects.Objects_Common;
import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class OrderTypes {
		
	public void createFetchOrderType(String OrderType) throws InterruptedException
	{
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		NavigatetoOverviews.getInstance().adminBanksOrderTypes();
		com.pageObjects.Objects_Common.ActionBar.btn_New(Configuration.getInstance().eDriver).click();
		com.pageObjects.Objects_Admin.Banks.OrderTypes.txtBx_OrderType(Configuration.getInstance().eDriver).sendKeys(OrderType);
		Configuration.getInstance().eDriver.findElement(By.xpath("//td[label='Bank to customer']/preceding-sibling::td//span")).click();
		Objects_Common.btn_Create(Configuration.getInstance().eDriver).click();
	}
	
	
}
