package com.samplePractice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Flipkart 
{
	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.firefox.profile", "default");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void flip() throws InterruptedException
	{
		driver.get("http://www.flipkart.com/philips-gc1010-iron/p/itmdyczgmsggwgd8?pid=IRNDYCZCZCSTKRZY&srno=b_2&ref=206cda29-7203-4068-a1ab-474f64c2e877");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		Thread.sleep(2000);
		
		driver.get("http://www.flipkart.com/philips-gc1905-iron/p/itmd2ufgjhhgjfhd?pid=IRND2UFFBEDXAFGC");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		Thread.sleep(2000);
		
		driver.get("http://www.flipkart.com/panasonic-er206kk/p/itmdnyn9sfmpchhg?pid=SHVCZZF3RESAJYVW");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		Thread.sleep(3000);

		System.out.println("Philips GC1010 Iron (Green): "+driver.findElement(By.xpath("//td[span='Philips GC1010 Iron (Green)']/following-sibling::td[2]/div/div")).getText());
		System.out.println("Philips GC1905 Iron (White and blue): "+driver.findElement(By.xpath("//td[span='Philips GC1905 Steam Iron, 1440 W (White and blue)']/following-sibling::td[2]/div/div")).getText());
		System.out.println("Panasonic ER206KK (Black): "+driver.findElement(By.xpath("//td[span='Panasonic ER206KK (Black)']/following-sibling::td[2]/div/div")).getText());
	}
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
}