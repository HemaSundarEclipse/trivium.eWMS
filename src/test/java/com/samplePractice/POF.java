package com.samplePractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.utility.Configuration;

public class POF {

	public POF() {
		try {
			PageFactory.initElements(Configuration.getInstance().eDriver, this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FindBy(id="Email")
	public static WebElement Email;
	
	@FindBy(id="Passwd")
	public static WebElement Password;

}
