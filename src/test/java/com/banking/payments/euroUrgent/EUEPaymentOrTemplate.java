package com.banking.payments.euroUrgent;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.Configuration;
import com.utility.NavigatetoOverviews;

public class EUEPaymentOrTemplate {	
	
	@Test
	public void foreign() throws InterruptedException
	{
		int x=1;
		NavigatetoOverviews.getInstance().bankingPaymentsTemplates();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//button/span[2][text()='New']")).click();//Click New Button
		Thread.sleep(1000);
		Configuration.getInstance().eDriver.findElement(By.linkText("Euro urgent")).click();
		Thread.sleep(2000);
		//Remitter Account
		Configuration.getInstance().eDriver.findElement(By.xpath("//table[@id='remitterInformation']//label[contains(@id, 'j_idt') and contains(@id, '_label')]")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/preceding-sibling::div/div[2]/ul/li[text()='421421421:70020270:EUR - 421421421']")).click();
		x=test(x);
		Thread.sleep(2000);
		//Charges Account
		Configuration.getInstance().eDriver.findElement(By.id("chargesAccounId_label")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/div[2]/ul/li[6]")).click();
		Thread.sleep(1000);
		x=test(x);
		
		Configuration.getInstance().eDriver.findElement(By.xpath("//table[@id='remitterInformation']//label[contains(@id, 'j_idt') and contains(@id, '_label')]")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/preceding-sibling::div/div[2]/ul/li[text()='44004400:70020270:EUR - 44004400']")).click();
		x=test(x);
		Thread.sleep(2000);
		//Charges Account
		Configuration.getInstance().eDriver.findElement(By.id("chargesAccounId_label")).click();
		Thread.sleep(2000);
		Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='chargesAccounId_panel']/div[2]/ul/li[4]")).click();
		Thread.sleep(1000);
		x=test(x);
	}
	public int test(int z) throws InterruptedException
	{
			
//			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='eueForeignPaymentPanel_content']/table[1]/tbody/tr/td[2]/table/tbody/tr/td[4]/input")).sendKeys(String.valueOf(z));
//			z++;
//			Thread.sleep(2000);
//			//Beneficiary Selection
//			Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");
//			Thread.sleep(2000);
//			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li[1]")).click();
//			Thread.sleep(1000);
//			
//			Configuration.getInstance().eDriver.findElement(By.id("dtazvPayment-money-amount")).sendKeys("1");//Amount
//			Configuration.getInstance().eDriver.findElement(By.xpath("//button[span='Create & next template']")).click();//Click Create & next
			
			String[] args2 = {"None", "Option 1", "Option 2", "Option 3"};
	        for(int i = 1; i < 4; i++)
	        {
	            String string = args2[i];
	            // System.out.println(string);
	            for(int j = 1; j < 4; j++)
	            {
	            	
	            	if(j == 1 || j != i)
	            	{
	            		for(int k = 1; k < 4; k++)
	            		{
	                        
	                        if(k == 1 || k != i)
	                        {
	                            for(int l = 1; l < 4; l++)
	                            {
	                            	if(l == 1 || l != i)
	                                {
	                                	Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='eueForeignPaymentPanel_content']/table[1]/tbody/tr/td[2]/table/tbody/tr/td[4]/input")).sendKeys(String.valueOf(z));
	                        			z++;
	                        			Thread.sleep(2000);
	                        			//Beneficiary Selection
	                        			Configuration.getInstance().eDriver.findElement(By.id("beneficiaryAlias_input")).sendKeys("*");
	                        			Thread.sleep(2000);
	                        			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='beneficiaryAlias_panel']/ul/li[3]")).click();
	                        			Thread.sleep(1000);
	                        			
	                        			Configuration.getInstance().eDriver.findElement(By.id("dtazvPayment-money-amount")).sendKeys("1");//Amount
	                        			
	                        			Configuration.getInstance().eDriver.findElement(By.id("instructionCode1_label")).click();
	                        			Thread.sleep(1000);
	                        			Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode1_panel']/div/ul/li["+i+"]")).click();
	                        			Thread.sleep(1000);
	                	            	Configuration.getInstance().eDriver.findElement(By.id("instructionCode2_label")).click();
	                	            	Thread.sleep(1000);
	                	            	Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode2_panel']/div/ul/li["+j+"]")).click();
	                	            	Thread.sleep(1000);
	                	                Configuration.getInstance().eDriver.findElement(By.id("instructionCode3_label")).click();
	                	                Thread.sleep(1000);
	                	                Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode3_panel']/div/ul/li["+k+"]")).click();
	                	                Thread.sleep(1000);
	                	                Configuration.getInstance().eDriver.findElement(By.id("instructionCode4_label")).click();
	                	                Thread.sleep(1000);
	        	    	                Configuration.getInstance().eDriver.findElement(By.xpath("//*[@id='instructionCode4_panel']/div/ul/li["+l+"]")).click();
	        	    	                Thread.sleep(1000);
	                	                
	        	    	                System.out.println(Configuration.getInstance().eDriver.findElement(By.id("instructionCode1_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode2_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode3_label")).getText()+", "+Configuration.getInstance().eDriver.findElement(By.id("instructionCode4_label")).getText()+", ");
	        	    	                com.pageObjects.Objects_Common.btn_CreateandNext(Configuration.getInstance().eDriver).click();//Click Create & next
	                                	
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        return z;
	}
}