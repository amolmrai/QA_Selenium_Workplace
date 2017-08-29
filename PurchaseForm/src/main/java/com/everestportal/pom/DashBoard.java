package com.everestportal.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everestportal.applicationlib.CommonApplicationLib;
import com.everestportal.applicationlib.CommonTestData;
import com.frameworklib.PageBaseClass;

public class DashBoard {

	WebDriver driver;
	public DashBoard(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
	}
	String FormLibrary = "id,contentHeaderText";
	String LinkPurchaseRequest = "xpath, //div[contains(text(),'Purchase Request')]";
	WebElement spanFormLibrary;
	WebElement linkPurchaseForm;
	boolean isFlag;
	public boolean isDashBoardPageLoaded() throws InterruptedException {
		spanFormLibrary = new PageBaseClass(driver).getPageElement(FormLibrary);
		if(spanFormLibrary.isDisplayed()) {
			isFlag=true;
			System.out.println("Successfully found Element "+spanFormLibrary);
		}else
		{
			System.out.println("FAILED to find Element "+spanFormLibrary);
		}
		return isFlag;
	}
	
	public boolean navigatePurchaseForm() throws Exception {
		Thread.sleep(2000);
		WebElement linkPurchaseForm = driver.findElement(By.xpath("//div[contains(text(),'Purchase Request')]"));
		new CommonApplicationLib(driver).waitElementPresent(linkPurchaseForm);
		if(linkPurchaseForm.isDisplayed()) {
			linkPurchaseForm.click();
			Thread.sleep(CommonTestData.WAIT);
			System.out.println("Successfully found Element "+linkPurchaseForm);
			isFlag=true;
		}else
		{
			System.out.println("FAILED to find Element "+linkPurchaseForm);
		}
		return isFlag;
	}

}
