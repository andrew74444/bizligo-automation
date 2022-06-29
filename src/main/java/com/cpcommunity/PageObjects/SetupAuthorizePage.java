package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class SetupAuthorizePage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
		
	
	
	@FindBy(xpath="//h2[contains(.,'- Authorize.net')]")
	WebElement SetUpAuthorizeHeader;

	 @FindBy(xpath = "//input[@value='false']")
	    WebElement UseSandboxCheckBox;
	 
	 @FindBy(xpath = "//input[@name='txtAPILoginID']")
	    WebElement txtAPILoginID;
	 @FindBy(xpath = "//input[@name='txtTransactionKey']")
	    WebElement txtTransactionKey;
	 
	 @FindBy(xpath = "//input[@name='txtContent']")
	    WebElement txtContent;	
	 
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
		 
		return ExpectedConditions.visibilityOf(SetUpAuthorizeHeader);
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
		try {
			
		
		 String CheckBoxSelected = UseSandboxCheckBox.getAttribute("value");
		 log.info(CheckBoxSelected);
		 
		 if(CheckBoxSelected.equalsIgnoreCase("false"))
		 {
			 click(UseSandboxCheckBox,"UseSandboxCheckBox");
		 }
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
	
	
	public AuthorizeGateway SetUpAuthorizeGateway() throws Exception
	{
		
		 this.SelectCheckBox();
		 txtAPILoginID.clear();
		 type(txtAPILoginID, "3u9A3Hx6Qwq", "txtAPILoginID");
		 txtTransactionKey.clear();
		 type(txtTransactionKey, "9B5eQP236vdWe85p", "txtTransactionKey");
		 txtContent.clear();
		 type(txtContent, "Simon", "txtContent");
	//	 Thread.sleep(500);
		 waitForElementToPresent(ValidateBtn);
		 click(ValidateBtn,"ValidateBtn");
		 waitForElementToPresent(OkBtn);
		 click(OkBtn,"Ok Btn");	
		 Thread.sleep(10000);
		 return (AuthorizeGateway) openPage(AuthorizeGateway.class);
//		 new AuthorizeGateway(driver, );
	}
	
	
	
	public PaymentGatewaysPage inActiveAuthorizeGateway() throws Exception
	{		 
		click(toggleOn,"toggle On");
		Update.click();
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//		new PaymentGatewaysPage(driver, );
	}
	
	public PaymentGatewaysPage ActiveAuthorizeGateway() {
		
		waitForElementToPresent(toggleOff);
		click(toggleOff,"toggleOff");
		waitForElementToPresent(Update);
		click(Update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//		new PaymentGatewaysPage(driver, );
		
	}
	
	
	
}
