package com.runner;
import org.testng.annotations.Test;
import com.everestportal.applicationlib.CommonTestData;
import com.everestportal.pom.LoginPage;
import com.everestportal.pom.LogoutFormPage;
import com.everestportal.testcases.purchaseform.TestPurchaseRequest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestSuiteRunner {
  
	WebDriver driver;
@BeforeMethod
  public void beforeTest() throws InterruptedException {
	driver = new ChromeDriver();
	driver.get(CommonTestData.APP_URL);
	Thread.sleep(3000);
	try {
		LoginPage obj1 = new LoginPage(driver); 
		if(obj1.login(CommonTestData.USER_NAME ,CommonTestData.USER_PWD))
			Reporter.log( "SUCCESSFULLY log-In application :- " , true);
		else
			Reporter.log( "FAILED to log-In application :- " , false);
	} catch (Exception e) {
		System.out.println("Exception:- "+ e);
		e.printStackTrace();
	}
  }
 
 @Test
  public void testValidatePurchaseFormLoaded() {
	  try {
		  TestPurchaseRequest obj1 = new TestPurchaseRequest(); 
		  if(obj1.testValidatePurchaseFormLoaded(driver))
		  		Reporter.log( "PASSED:- test case testValidatePurchaseFormLoaded" , true);
		  	else
		  		Reporter.log( "FAILED:- test case ValidatePurchaseFormLoaded", false );
		} catch (Exception e) {
			System.out.println("Exception:- "+ e);
			e.printStackTrace();
		}
  }
  
 @Test
  public void testValidatePurchaseFormInlineErrors() {
	  try {
		  TestPurchaseRequest obj1 = new TestPurchaseRequest(); 
		  if(obj1.testValidatePurchaseFormInlineErrors(driver))
		  		Reporter.log( "PASSED:- test case testValidatePurchaseFormInlineErrors" , true);
		  	else
		  		Reporter.log( "FAILED:- test case testValidatePurchaseFormInlineErrors", false );
		} catch (Exception e) {
			System.out.println("Exception:- "+ e);
			e.printStackTrace();
		}
  }
  
 @Test
  public void testCreatePurchaseRequest() {
	  try {
		  TestPurchaseRequest obj1 = new TestPurchaseRequest(); 
		  if(obj1.testPurchaseRequest(driver))
		  		Reporter.log( "PASSED:- test case testPurchaseRequest" , true);
		  	else
		  		Reporter.log( "FAILED:- test case testPurchaseRequest", false );
		} catch (Exception e) {
			System.out.println("Exception:- "+ e);
			e.printStackTrace();
		}
  }

  
 @AfterMethod
  public void afterTest()  {
	  LogoutFormPage logoutFormPage;
	try {
		/*logoutFormPage = new LogoutFormPage(driver);
		if(logoutFormPage.singOut())
			  Reporter.log( "SUCCESSFULLY:- Logout the Application" , true);
		  else
			  Reporter.log( "FAILED:- to Logout Application" , false);*/
		  driver.quit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Reporter.log( "FAILED:- to Logout Application:- "+e , false);
	}
	  
  }

}
