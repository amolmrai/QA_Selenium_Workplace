package com.everestportal.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.everestportal.applicationlib.CommonTestData;
import com.frameworklib.PageBaseClass;

public class LogoutFormPage {
	WebDriver driver;
	public LogoutFormPage(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
	}
	String fomrs = "xpath,//div[@id='homeBtnForms']/div[1]/a/span";
	String headerSignOutToggle = "class,dropdown-toggle";
	String headerLogOfflink = "linktext,Log off";
	WebElement linkFormButton;
	boolean isFlag;
	public boolean navigaetToForms() throws Exception {
		linkFormButton = new PageBaseClass(driver).getPageElement(fomrs);
		if(isLogoutFormPageloaded()) {
			isFlag=true;
			linkFormButton.click();
			Thread.sleep(CommonTestData.WAIT);
			System.out.println("Successfully clicked on  Element "+linkFormButton);
		}else
		{
			System.out.println("FAILED to click on  Element "+linkFormButton);
		}
		return isFlag;
	}
	
	public boolean isLogoutFormPageloaded() throws InterruptedException {
		linkFormButton = new PageBaseClass(driver).getPageElement(fomrs);
		if(linkFormButton.isDisplayed()) {
			isFlag=true;
			System.out.println("Successfully found Element "+linkFormButton);
		}else
		{
			System.out.println("FAILED to find Element "+linkFormButton);
		}
		return isFlag;
	}
	
	public List<WebElement> clickOnHeaderToggle() throws InterruptedException {
		WebElement ElementHeaderSignOutToggle = new PageBaseClass(driver).getPageElement(headerSignOutToggle);
		List<WebElement> liElements=null;
		if(ElementHeaderSignOutToggle.isDisplayed()) {
			ElementHeaderSignOutToggle.click();
			//WebElement liElements = ElementHeaderSignOutToggle;
			liElements = ElementHeaderSignOutToggle.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
			isFlag=true;
			Reporter.log("SUCCESSFULLY found Header sub Elements "+liElements,true);
		}else
			Reporter.log("FAILED to find Element "+liElements,false);
		
		return liElements;
	}
	
	public boolean singOut() throws Exception {
		List<WebElement> liElements=null;
		liElements = new LogoutFormPage(driver).clickOnHeaderToggle();
		//WebElement ElementheaderLogOfflink = new PageBaseClass(driver).getPageElement(headerLogOfflink);
		for (int i = 1; i < liElements.size()+1; i++) {
            WebElement ElementheaderLogOfflink = liElements.get(i).findElement(By
                            .xpath("//ul[@class='dropdown-menu']/li[" + i
                                    + "]/a"));
		
		if(ElementheaderLogOfflink.getText().contains("Log off")) {
			ElementheaderLogOfflink.click();
			isFlag=true;
			Reporter.log("Successfully found and clicked on Element "+ElementheaderLogOfflink,true);
		}else
			Reporter.log("FAILED to find Element "+ElementheaderLogOfflink,false);
		
		
		
	}
		return isFlag;
	}
}
