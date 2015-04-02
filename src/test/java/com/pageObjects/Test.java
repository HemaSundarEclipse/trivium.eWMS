package com.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.samplePractice.POF;
import com.utility.Configuration;

public class Test {

	
	@org.testng.annotations.Test
	public void name() throws InterruptedException {
		
		Configuration.getInstance().eDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//		PageFactory.initElements(Configuration.getInstance().eDriver, this);
//		POF p = new POF();
		POF.Email.sendKeys("p.hemasundar@gmail.com");
		POF.Password.sendKeys("12345");
	}
}
