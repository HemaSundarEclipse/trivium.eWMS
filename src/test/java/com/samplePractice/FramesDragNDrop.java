package com.samplePractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDragNDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Hema\\Google Drive\\TestData\\Lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.ankur.com/projects/FrameGlider/demo/simple/a.html");
		
		Thread.sleep(3000);
		
		List<WebElement> TotalFrames = driver.findElements(By.tagName("iframe"));
		
		
		driver.switchTo().frame("b");
		System.out.println("Focus on frame B");
		
		driver.switchTo().frame("c");
		System.out.println("Focus on frame C");
		
		WebElement Dra2 = driver.findElement(By.id("Dra2"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(Dra2).build().perform();
		
		driver.switchTo().defaultContent();
		System.out.println("Focus back to Defauilt Content");
		
		driver.switchTo().frame("b");
		System.out.println("Focus on frame B");
		
		driver.switchTo().frame("d");
		System.out.println("Focus on frame D");
		
		WebElement Dro3 = driver.findElement(By.id("Dro3"));
		
		Actions act1 = new Actions(driver);
		act.moveToElement(Dro3).release().build().perform();
		System.out.println("Drag & Drop action is successfull");

	}

}
