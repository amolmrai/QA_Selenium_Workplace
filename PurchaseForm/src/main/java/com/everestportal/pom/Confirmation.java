package com.everestportal.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everestportal.applicationlib.CommonTestData;
import com.frameworklib.PageBaseClass;

public class Confirmation {

	WebDriver driver;
	public Confirmation(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
	}

	String locatorWorkFlow = "xpath,//div[@class='container']/h2[1]";
	String locatorActionTaken = "xpath,//div[@class='container']/div[1]/div[2]/div[2]/b[1]";
	String locatorState = "//div[@class='container']/div[1]/div[5]/div[2]/b[1]";
	
	public boolean validateConfirmation() throws InterruptedException {
		boolean isValidateConfirmation =false; 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Enter WorkFlow
		WebElement labelWorkFlow = new PageBaseClass(driver).getPageElement(locatorWorkFlow);
		wait.until(ExpectedConditions.visibilityOf(labelWorkFlow));
		if(labelWorkFlow.getText().equals("Workflow")) {
			assertEquals(labelWorkFlow.getText(), "Workflow");
			isValidateConfirmation = true;
			System.out.println("SUCCESSFULLY validated confirmation page with WorkFlow");
		}else
			System.out.println("FAILED to validate confirmation page with WorkFlow");
		
		// Enter WorkFlow
		WebElement labelActionTaken = new PageBaseClass(driver).getPageElement(locatorActionTaken);
		if(labelActionTaken.getText().equals("SUBMIT")) {
			assertEquals(labelActionTaken.getText(), "SUBMIT");
			isValidateConfirmation = true;
			System.out.println("SUCCESSFULLY validated confirmation page with State");
		}else
			System.out.println("FAILED to validate confirmation page with State");
			
		return isValidateConfirmation;
		
	}
	
}
