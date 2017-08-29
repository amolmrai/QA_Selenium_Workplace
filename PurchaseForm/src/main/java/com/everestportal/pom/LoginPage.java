package com.everestportal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frameworklib.PageBaseClass;

public class LoginPage {
	WebDriver driver;
	public String from = "//div[@class='portalPanelDiv']/form";
	public String txt_uname = "id,uName"; 
	public String txt_pwd = "id,Password";
	public String btn_submit = "xpath,html/body/div[1]/div/form/div[3]/input";
	
	public LoginPage(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
		}
	
	public boolean login(String sUsername, String sPassword) throws Exception{
		WebElement txtUname = new PageBaseClass(driver).getPageElement(txt_uname);
		txtUname.sendKeys(sUsername);
		WebElement txtPwd = new PageBaseClass(driver).getPageElement(txt_pwd);
		txtPwd.sendKeys(sPassword);
		WebElement btnLogin = new PageBaseClass(driver).getPageElement(btn_submit);
		btnLogin.click();
		Thread.sleep(3000);
	 return new LogoutFormPage(driver).isLogoutFormPageloaded();
	}

}
