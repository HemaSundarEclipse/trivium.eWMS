package com.test;

import org.openqa.selenium.By;

import com.utility.Configuration;

public class Test {
@org.testng.annotations.Test
//	public static void main(String[] args) throws InterruptedException 
	public void testing() throws InterruptedException
	{
//		int i=1, j=0;
//		try {
//			int k = i/j;
//			System.out.println("After Exception");
//		} catch (Exception e) {
//			System.out.println("Catch Block");
//		}
		try {
			Configuration.getInstance().eDriver.findElement(By.id("metaNavigationAdminButton_button")).click();
			Thread.sleep(1000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Admin']")).click();
			Thread.sleep(2000);
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
			Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='User management']")).click();
			System.out.println("User have Banking & ADMIN roles");
		} catch (Exception e) {
			try {
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='Users']")).click();
				Configuration.getInstance().eDriver.findElement(By.xpath("//a[span='User management']")).click();
				System.out.println("User doesn't have Banking Roles");
			} catch (Exception e2) {
				System.out.println("User doesn't have ADMIN role");
			}
		}		
	}
}