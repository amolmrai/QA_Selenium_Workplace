package com.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.everestportal.applicationlib.CommonTestData;
import com.everestportal.pom.LoginPage;
import com.everestportal.testcases.purchaseform.TestPurchaseRequest;

public class runner {

	WebDriver driver;
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(CommonTestData.APP_URL);
		Thread.sleep(3000);
		 try {
				LoginPage macys = new LoginPage(driver); 
			 	obj1.login(CommonTestData.USER_NAME ,CommonTestData.USER_PWD);
			} catch (Exception e) {
				System.out.println("Exception:- "+ e);
				e.printStackTrace();
			}
	  }
	  
	  @Test (priority=1)
	  public void purhcaseRequestFormTestSuite() {  
		  try {
			  boolean isTestCase= false;
			  TestPurchaseRequest obj1 = new TestPurchaseRequest();
			  	if(obj1.testValidatePurchaseFormLoaded(driver))
			  		Reporter.log( "PASSED:- test case testValidatePurchaseFormLoaded" , true);
			  	else
			  		Reporter.log( "FAILED:- test case ValidatePurchaseFormLoaded", false );
			  	
			  	if(obj1.testValidatePurchaseFormInlineErrors(driver))
			  		Reporter.log( "PASSED:- test case testValidatePurchaseFormInlineErrors" , true);
			  	else
			  		Reporter.log( "FAILED:- test case testValidatePurchaseFormInlineErrors", false );
			  	
			  	if(obj1.testPurchaseRequest(driver))
			  		Reporter.log( "PASSED:- test case testPurchaseRequest" , true);
			  	else
			  		Reporter.log( "FAILED:- test case testPurchaseRequest", false );
			  	
			  			
			} catch (Exception e) {
				Reporter.log( "FAILED:- test case purhcaseRequestFormTestSuite", false );
				System.out.println("Exception:- "+ e);
				e.printStackTrace();
			}
			
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.quit();
	  }

}
