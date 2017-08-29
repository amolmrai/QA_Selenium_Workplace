package com.everestportal.testcases.purchaseform;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.everestportal.pom.DashBoard;
import com.everestportal.pom.LogoutFormPage;
import com.everestportal.pom.PurchaseRequestPage;

public class TestPurchaseRequest {

	PurchaseRequestPage purchaseRequestPage;
	LogoutFormPage logoutFormPage;
	
	/**
	 * @author 
	 * @param driver
	 * @return boolean
	 * @throws Exception
	 * @desc Method Name <B>testValidatePurchaseFormInlineErrors</B>
	 * 	This test method will validate the purchase request form client side errors. 
	 */
	public boolean testValidatePurchaseFormInlineErrors(WebDriver driver) throws Exception {
		boolean isTestValidatePurchaseFormInlineErrors = false;
		logoutFormPage = new LogoutFormPage(driver);
		purchaseRequestPage = new PurchaseRequestPage(driver);
		if(logoutFormPage.navigaetToForms()) 
			Reporter.log("SUCCESSFULLY clicked Purchase Form image button",true);
		else 
			Reporter.log("FAILED cto click on Purchase Form image button",false);
		
		// Navigate Purchase form
		if(new DashBoard(driver).navigatePurchaseForm())
		{
			isTestValidatePurchaseFormInlineErrors= purchaseRequestPage.purchaseFormInlineErorValidation();
			Reporter.log("SUCCESSFULLY clicked Purchase Form link",true);
		}else
			Reporter.log("FAILED to click on Purchase Form link",false);	
		
		return isTestValidatePurchaseFormInlineErrors;
	}
	/**
	 * @author 
	 * @param driver
	 * @return boolean
	 * @throws Exception
	 * @desc Method Name <B>testValidatePurchaseFormLoaded</B>
	 * 	This test method will validate the  whether purchase request form is loaded or not. 
	 */
	public boolean testValidatePurchaseFormLoaded(WebDriver driver) throws Exception {
		boolean isTestValidatePurchaseLoaded=false;
		purchaseRequestPage = new PurchaseRequestPage(driver);
		logoutFormPage = new LogoutFormPage(driver);
		
		if(logoutFormPage.navigaetToForms()) {
			Reporter.log("SUCCESSFULLY clicked Purchase Form image button",true);
		}else {
			Reporter.log("FAILED cto click on Purchase Form image button",false);
		}
	
		// Navigate Purchase form
		if(new DashBoard(driver).navigatePurchaseForm())
		{
			isTestValidatePurchaseLoaded =new DashBoard(driver).navigatePurchaseForm();
			Reporter.log("SUCCESSFULLY clicked Purchase Form link",true);
		}else
			Reporter.log("FAILED to click on Purchase Form link",false);	
			
		return isTestValidatePurchaseLoaded;
	}
	/**
	 * @author 
	 * @param driver
	 * @return boolean
	 * @throws Exception
	 * @desc Method Name <B>testPurchaseRequest</B>
	 * 	This test method will create purchase request using valid test data. 
	 */
	public boolean testPurchaseRequest(WebDriver driver) throws Exception {
		boolean isTestPurchaseRequest = false;
		purchaseRequestPage = new PurchaseRequestPage(driver);
		logoutFormPage = new LogoutFormPage(driver);
		
		if(logoutFormPage.navigaetToForms())
			System.out.println("SUCCESSFULLY clicked Purchase Form image button");
		else
			System.out.println("FAILED to click on Purchase Form image button");	

		// Navigate Purchase form
		if(new DashBoard(driver).navigatePurchaseForm()) 
			System.out.println("SUCCESSFULLY clicked Purchase Form link");
		else
			System.out.println("FAILED to click on Purchase Form link");	

		if(purchaseRequestPage.createPurchaseRequest()) { 
			isTestPurchaseRequest= true;
			System.out.println("SUCCESSFULLY Created purchase request");
		}else
			System.out.println("FAILED to Purchase request");	
		
		return isTestPurchaseRequest;
	}
	
	
	
	
	
	

}
