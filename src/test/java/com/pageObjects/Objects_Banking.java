package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objects_Banking {
	private static WebElement element = null;
	public static class CashManagement {
		
	}
	public static class Payments {
		public class generic {
			
		}
		public static class Foreign {
			public static WebElement drpdwn_TypeOfExecution(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Type of execution']/following-sibling::td//label"));
				return element;
				
			}
		}
	
		public static class Beneficiaries {
			
			public static WebElement btn_Foreign(WebDriver eDriver) {
				
				element = eDriver.findElement(By.linkText("Foreign"));
				return element;
			}
			
			public static WebElement btn_RFT(WebDriver eDriver) {
				
				element = eDriver.findElement(By.linkText("RFT"));
				return element;
			}
			
			public static WebElement btn_SEPA(WebDriver eDriver) {
				
				element = eDriver.findElement(By.linkText("SEPA"));
				return element;
			}

			public static WebElement txtBx_BeneficiaryCode(WebDriver eDriver) {
	
				element = eDriver.findElement(By.xpath("//td[span='Beneficiary code']/following-sibling/::td/input"));
				return element;	
			}

			public static WebElement txtBx_Name(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='Name']/following-sibling::td/input"));
				return element;			
			}
			
			public static WebElement txtBx_AccountNumber(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='Account number']/following-sibling::td/input"));
				return element;	
			}
			
			public static WebElement txtBx_BankCode(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='Bank code']/following-sibling::td/input"));
				return element;	
			}
			
			public static WebElement txtBx_IBAN(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='IBAN']/following-sibling::td/input"));
				return element;	
			}
			
			public static WebElement txtBx_BIC(WebDriver eDriver) {
				
				element = eDriver.findElement(By.xpath("//td[span='BIC']/following-sibling::td/input"));
				return element;	
			}
			
			public static class SEPA {
				
				public static WebElement txtBx_Address(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='Address']/following-sibling::td/input"));
					return element;	
				}
				
				public static WebElement txtBx_Address2(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='Address 2']/following-sibling::td/input"));
					return element;	
				}
				
				public static WebElement txtBx_EndToEndRef(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='End to End ref.']/following-sibling::td/input"));
					return element;	
				}
			}
			
			public static class Foreign {
				
				public static WebElement txtBx_Address1(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='Address 1']/following-sibling::td/input"));
					return element;
				}
				
				public static WebElement txtBx_City(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='City']/following-sibling::td/input"));
					return element;					
				}
				
				public static WebElement txtBx_PostalCode(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='Postal code']/following-sibling::td/input"));
					return element;
				}
				
				public static WebElement txtBx_CreditInstitution(WebDriver eDriver) {
					
					element = eDriver.findElement(By.xpath("//td[span='Credit institution']/following-sibling::td/input"));
					return element;	
				}
			}
			
			public static class RFT {
				
			}
		}
	}

	public static class AWV {
		
		public static class Reports {
			
			public static WebElement btn_Z4(WebDriver eDriver) {
				element = eDriver.findElement(By.linkText("Z4"));
				return element;
			}
			
			public static WebElement btn_Z8(WebDriver eDriver) {
				element = eDriver.findElement(By.linkText("Z8"));
				return element;
			}
			
			public static WebElement btn_Z10(WebDriver eDriver) {
				element = eDriver.findElement(By.linkText("Z10"));
				return element;
			}
			
			public static WebElement txtBx_Desription(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='Description (internal)']/following-sibling::td/input"));
				return element;
			}
			
			public static WebElement txtBx_ISIN(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//td[span='ISIN']/following-sibling::td/input"));
				return element;
			}
			
			public static WebElement chkBx_AddAsTemplate(WebDriver eDriver) {
				element = eDriver.findElement(By.xpath("//div[span='Add as template']/div/div[2]"));
				return element;
			}
			
			public static class Z4Report {
				
				public static WebElement txtArea_Purpose(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z4ReportPurposeId"));
					return element;
				}
				
				public static WebElement txtBx_Amount(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z4Report-amount"));
					return element;
				}
				
				public static WebElement txtBx_Units(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z4Report-units"));
					return element;
				}
				
			}
			
			public static class Z8Report {
				
				
			}

			public static class Z10Report {
								
				public static WebElement txtBx_Amount(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z10Report-amount"));
					return element;
				}
				
				public static WebElement txtBx_ParValueInThdOrQuantity(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z10Report-units"));
					return element;
				}
				
				public static WebElement txtArea_Purpose(WebDriver eDriver) {
					element = eDriver.findElement(By.id("z10ReportPurposeId"));
					return element;
				}
			}
		}
		
		public static class Templates {
			
			
		}
		
		public static class Transactions {
			
		}
	}

	
}
