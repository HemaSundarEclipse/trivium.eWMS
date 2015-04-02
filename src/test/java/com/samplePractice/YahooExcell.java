package com.samplePractice;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class YahooExcell 
{
	WebDriver driver;
	@BeforeClass
	public void beforeClass() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.get("http://yahoomail.com");
		Thread.sleep(4000);
	}
	@Test
	public void test() throws BiffException, IOException
	{
		FileInputStream fs = new FileInputStream("D://sample.xls");
		Workbook wb= Workbook.getWorkbook(fs);
		Sheet ws = wb.getSheet(0);
		
		driver.findElement(By.id("username")).sendKeys(ws.getCell(0, 1).getContents());
		driver.findElement(By.id("passwd")).sendKeys(ws.getCell(1, 1).getContents());
		driver.findElement(By.id(".save")).click();
	}
}
