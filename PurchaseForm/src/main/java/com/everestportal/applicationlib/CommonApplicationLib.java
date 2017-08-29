package com.everestportal.applicationlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frameworklib.PageBaseClass;

public class CommonApplicationLib {
	WebDriver driver;
	public CommonApplicationLib(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
	}
	
	public void waitElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
