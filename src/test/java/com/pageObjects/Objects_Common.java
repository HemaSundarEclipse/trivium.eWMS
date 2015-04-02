package com.pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Objects_Common
{
	private static WebElement element = null;
	
	public static class ActionBar {
		public static WebElement icn_New(WebDriver eDriver) {
			element = eDriver.findElement(By.className("ewms-ui-icon-new"));
			return element;
			
		}
		
		public static WebElement btn_New(WebDriver eDriver) throws InterruptedException 
		{
			try {
				
				element = eDriver.findElement(By.className("ewms-ui-icon-new"));
			} catch (Exception e) {
				
				element = eDriver.findElement(By.xpath("//button[span='New']"));
			}
								
			return element;
			
		}
	}
	
	public class TableConfigurator {
		
	}
	
	public class Paginator {
		
	}
		
	public static WebElement btn_Create(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Create']"));
		return element;
	}
	
	public static WebElement btn_Applychanges(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Apply changes']"));
		return element;
	}
	
	public static WebElement btn_Confirm(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Confirm']"));
		return element;
	}	
	
	public static WebElement btn_CreateandNext(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Create & next']"));
		return element;
	}
	
	public static WebElement btn_CreateandNextTemplate(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Create & next template']"));
		return element;
	}
	
	public static WebElement btn_Cancel(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Cancel']"));
		return element;
	}
	
	public static WebElement btn_Import(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Import']"));
		return element;
	}
	
	public static WebElement btn_SelectLessThan5MB(WebDriver eDriver) {
		element = eDriver.findElement(By.xpath("//button[span='Select file < 5MB']"));
		return element;
	}
	
}