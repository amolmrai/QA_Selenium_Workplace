package com.frameworklib;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.everestportal.applicationlib.CommonApplicationLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBaseClass {
	WebDriver driver;
	WebElement webelement;
public PageBaseClass(WebDriver driver) {
		if(null != driver) 
			this.driver=driver;
		else {
			Reporter.log( "FAILED to Initialise driver object in PageBaseClass", false );
			System.out.println("FAILED to Initialise driver object in PageBaseClass");
		}
	}
	
	public WebElement getPageElement(String strLocator) throws InterruptedException {
		CommonUtil commonutil = new CommonUtil(strLocator);
		Thread.sleep(1000);
		switch(commonutil.getStrLocKey()) {
		case "id":
			webelement = driver.findElement(ById.id(commonutil.getStrLocValue())) ;
			break;
		case "class":
			webelement = driver.findElement(ByClassName.className(commonutil.getStrLocValue())) ;
			break;
		case "xpath":
			webelement = driver.findElement(By.xpath(commonutil.getStrLocValue())) ;
			break;
		case "name":
			webelement = driver.findElement(ByName.name(commonutil.getStrLocValue())) ;
			break;
		case "linktext":
			webelement = driver.findElement(By.linkText(commonutil.getStrLocValue())) ;
			break;
			
		default:
            throw new IllegalArgumentException("Invalid locator: " + commonutil.getStrLocKey());
		}
		return webelement;
	}
	
}
