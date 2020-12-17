package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class SetupPayPalPage extends BasePage{
	
	
	@Override
	protected  void getPageScreenSot() {
		aShot();
	}
	
	
	
	@FindBy(xpath="//h2[contains(.,'- PayPal')]")
	WebElement SetupPayPalHeader;
	
	
	@FindBy(xpath="//div[@class='user-text']")
	WebElement usertext;
	
//	@FindBy(xpath="//*[@id='email_create']")
//	WebElement registrationEmailAddress;
//	
//	@FindBy(xpath="//*[@id='SubmitCreate']")
//	WebElement createAnAccount;
//	@FindBy(xpath="//li[contains(text(),'Invalid login credentials. Please try again')]")
//	WebElement Invalidlogin;
	
//	@FindBy(xpath="//*[@id='center_column']/h1")
//	WebElement authenticate;
//	
//	@FindBy(xpath="//*[@id='create-account_form']/div/p")
//	WebElement createAnAccountMessage;
	
	 @FindBy(xpath = "//input[@value='false']")
	    WebElement UseSandboxCheckBox;
	 
	 @FindBy(xpath = "//input[@name='txtAPIUsername']")
	    WebElement txtAPIUsername;
	 @FindBy(xpath = "//input[@name='txtAPIPassword']")
	    WebElement txtAPIPassword;
	 
	 @FindBy(xpath = "//input[@name='txtAPISignature']")
	    WebElement txtAPISignature;	
	 
	 @FindBy(xpath = "//button[contains(.,'Validate')]")
	    WebElement ValidateBtn;
	 
	 @FindBy(xpath = "//button[contains(.,'Ok')]")
	    WebElement OkBtn;
	 
	 
	 @FindBy(xpath = "//label[@class='btn btn-success toggle-on']")
	    WebElement toggleOn;
	 
	 @FindBy(xpath = "//label[@class='btn btn-danger active toggle-off']")
	    WebElement toggleOff;
	 
	 @FindBy(xpath = "//*[contains(text(),'Update')]")
	    WebElement Update;	

	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(SetupPayPalHeader);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public void SelectCheckBox()
	 {
		 String CheckBoxSelected = UseSandboxCheckBox.getAttribute("value");
		 if(CheckBoxSelected.equalsIgnoreCase("false"))
		 {
			 UseSandboxCheckBox.click();
		 } 
	 }
	 
	
	
	public PayPalPayment SetUpPayPalPaymentGateway(String APIUsername, String APIPassword, String APISignature) throws Exception
	{
		 this.SelectCheckBox();
		 txtAPIUsername.clear();
		 type(txtAPIUsername, APIUsername, "txtAPIUsername");
		 
		 txtAPIPassword.clear();
		 type(txtAPIPassword, APIPassword, "txtAPIPassword");
		 
		 txtAPISignature.clear();
		 type(txtAPISignature, APISignature, "txtAPISignature");
		 
		 Thread.sleep(500);
		 click(ValidateBtn,"ValidateBtn");
		 waitForElementToPresent(OkBtn);
		 click(OkBtn,"OkBtn");	
		 return (PayPalPayment) openPage(PayPalPayment.class);
//				 new PayPalGateway(driver, );
	}
	
	
	
	public PaymentGatewaysPage inActiavtePayPalPaymentGateway()
	{
		click(toggleOn,"toggleOn");
		click(Update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//				 new PaymentGatewaysPage(driver, );
	}
	
	
	public PaymentGatewaysPage ActiavtePayPalPaymentGateway() {
		click(toggleOff,"toggleOff");
		click(Update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//				 new PaymentGatewaysPage(driver, );
		
	}
	
	
	
}
