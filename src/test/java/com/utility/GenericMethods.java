package com.utility;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	
	private static boolean check_alert() throws InterruptedException {
		try {
			Alert a = Configuration.getInstance().eDriver.switchTo().alert();
			a.accept();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void checkingForValidationErrors() throws InterruptedException {
		List<WebElement> validationMessages = Configuration.getInstance().eDriver.findElements(By
				.xpath("//div[@id='messagesId']//li"));
		if (validationMessages.size() > 0) {
			System.out.println("Number of validation messages: "
					+ validationMessages.size());
			for (WebElement val : validationMessages) {
				System.out.println(val.getText());
			}
		}
	}
}