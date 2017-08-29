package com.everestportal.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.everestportal.applicationlib.CommonTestData;
import com.frameworklib.PageBaseClass;

public class PurchaseRequestPage {

	WebDriver driver;
	String locatorReason = "id,Reason";
	String locatorVendorPicker = "id,vendorPicker";
	String locatorShippingAdd = "id,addressPicker";
	String locatorAddDetailTable = "id,TableGridPODetail";
	String locatorProjNmber = "id,Form_FormHeader_ProjectNo";
	String locatorConfugrationMsg = "xpath,//table[@id='TablePOFormData']/tbody[1]/tr[2]/td[2]/select[1]";
	String locatorAurthCode = "id,Form_FormHeader_AuthorizationCode";
	String locatorRespCode = "id,Form_FormHeader_ResponsibilityCode";
	String locatorFundingTable = "id,TableGridAcctDR";
	String locatorWorkflowAcction = "id,TaskOptions_Result_TaskOutcome";
	String loctorNextUser = "id,PeoplePicker";
	String locatorComments= "id,TaskOptions_Result_TaskComments";
	String locatorSubmitToBeFocused = "id,SubmitToBeFocused";
	
	//Error
	String locatorFormError = "xpath,//div[@class='validation-summary-errors']";

	public PurchaseRequestPage(WebDriver driv)throws Exception {
		if(!driv.equals(null)) {
			driver=driv;
				System.out.println("SUCCESSFULLY Initialised driver object "+this.driver);
			}else
				System.out.println("FAILED to Initialise driver object in EverestPortal_Login");	
	}
	
	public boolean purchaseFormInlineErorValidation() throws InterruptedException {
		boolean isFormInlineErorValidation = false;
		
		WebElement txtReason = new PageBaseClass(driver).getPageElement(locatorReason);
		txtReason.sendKeys(CommonTestData.PURCHASE_REASON);
		// Click on Submit button
		txtReason.submit();
		// Enter Reason
		WebElement divFormError = new PageBaseClass(driver).getPageElement(locatorFormError);
		 String strError = divFormError.getText();
		if(strError!= null) {
			if(strError.contains(CommonTestData.PURCHASE_FORM_ERROR_VENDOR)) {
				Reporter.log("SUCCESSFULL validated purchase empty form error",true);
				isFormInlineErorValidation = true;
			}else 
				Reporter.log("FAILED to validate purchase empty form error",false);
		}
		
		return isFormInlineErorValidation;
	}
	
	public boolean createPurchaseRequest() throws Exception {
		boolean isPurchaseRequestCreated =false; 
		// Enter Reason
		WebElement txtReason = new PageBaseClass(driver).getPageElement(locatorReason);
		txtReason.sendKeys(CommonTestData.PURCHASE_REASON);
		// Enter Vendor
		WebElement txtVendor = new PageBaseClass(driver).getPageElement(locatorVendorPicker);
		txtVendor.sendKeys(CommonTestData.PURCHASE_VENDOR);
		
		// Enter Vendor
		WebElement tblDetail = new PageBaseClass(driver).getPageElement(locatorAddDetailTable);
		txtVendor.sendKeys(CommonTestData.PURCHASE_VENDOR);
		int i=2;

		String tblHeadValue = null;
		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[1]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Quantity")) {
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[1]/input[1]")).clear();
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[1]/input[1]")).sendKeys("1");
		}else
			System.out.println("FAILED to serach the table header for Quantiry");

		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[2]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Unit")) {
			Select selectUnit = new Select(driver.findElement(By.xpath("//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[2]/select[1]")));
			//selectUnit.deselectAll();
			selectUnit.selectByVisibleText(CommonTestData.UNIT_CASE);
		}else
			System.out.println("FAILED to serach the table header for Unit");
		
		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[3]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Item")) {
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[3]/textarea[1]")).clear();
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[3]/textarea[1]")).sendKeys(CommonTestData.ITEM);
		}else
			System.out.println("FAILED to serach the table header for Item");
		
		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[4]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Unit Cost")) {
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[4]/input[1]")).click();
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[4]/input[1]")).sendKeys(CommonTestData.UNIT_COST_100);
		}else
			System.out.println("FAILED to serach the table header for Unit Cost");
		
		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[5]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Tax")) {
			if ( !driver.findElement(By.xpath("//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[5]/input[1]")).isSelected() )
				driver.findElement(By.xpath("//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[5]/input[1]")).click();
			else
				driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[5]/input[1]")).click();
		}else
			System.out.println("FAILED to serach the table header for Tax");
		
		tblHeadValue = driver.findElement(By.xpath("//table[@id='TableGridPODetail']/tbody/tr[1]/td[6]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Discount")) {
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[6]/input[2]")).clear();
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[6]/input[2]")).sendKeys(CommonTestData.DISCCOUNT_10);
		}else
			System.out.println("FAILED to serach the table header for Discount");
		
		
		tblHeadValue = driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr[1]/td[8]")).getText();
		if(tblHeadValue.equalsIgnoreCase("Acct")) {
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[8]/input[1]")).clear();
			driver.findElement(By.xpath(".//table[@id='TableGridPODetail']/tbody/tr["+i+"]/td[8]/input[1]")).sendKeys(CommonTestData.ACC_1);
		}else
			System.out.println("FAILED to serach the table header for Acc");
	
		//Enter project number
		WebElement txtProjNmber = new PageBaseClass(driver).getPageElement(locatorProjNmber);
		txtProjNmber.sendKeys(CommonTestData.PROJECT_NUMBER);
		
		//Select Confirmation msg
		Select confirmationMsg = new Select(driver.findElement(By.xpath("//table[@id='TablePOFormData']/tbody[1]/tr[2]/td[2]/select[@id='Form_FormHeader_ConfirmationCode']")));
		confirmationMsg.selectByIndex(1);
		
		// Authorization Code
		WebElement aurthorizationCode = new PageBaseClass(driver).getPageElement(locatorAurthCode);
		aurthorizationCode.sendKeys(CommonTestData.AURTHORISATION_CODE);
		
		//Responsibility Code
		WebElement responsibilityCode = new PageBaseClass(driver).getPageElement(locatorRespCode);
		responsibilityCode.sendKeys(CommonTestData.AURTHORISATION_CODE);
				
		// add account ID
		tblHeadValue = driver.findElement(By.xpath("//table[@id='TableGridAcctDR']/tbody/tr[@class='trAccountHeader row-header']/td[2]")).getText();
		if(tblHeadValue.equalsIgnoreCase("AccountID")) {
			driver.findElement(By.xpath("//table[@id='TableGridAcctDR']/tbody/tr[@class='trAccountDetailRow']/td[@class='tdAccountID']/input[2]")).clear();
			driver.findElement(By.xpath("//table[@id='TableGridAcctDR']/tbody/tr[@class='trAccountDetailRow']/td[@class='tdAccountID']/input[2]")).sendKeys("43000001");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]/li[1]")).click();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.SPACE).build().perform();
		}else
			System.out.println("FAILED to serach the table header for Discount");
			
		//Click on Submit button
		WebElement btnsubmit = new PageBaseClass(driver).getPageElement(locatorSubmitToBeFocused);
		btnsubmit.submit();
		//txtReason.submit();
		isPurchaseRequestCreated = new Confirmation(driver).validateConfirmation();
		
		return isPurchaseRequestCreated;
	
	}
	
}
