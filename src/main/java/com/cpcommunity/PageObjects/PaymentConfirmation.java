package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class PaymentConfirmation extends BasePage {

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	// @FindBy(xpath="//*[@id='email_create']")
	// WebElement registrationEmailAddress;
	//
	// @FindBy(xpath="//*[@id='SubmitCreate']")
	// WebElement createAnAccount;
	// @FindBy(xpath="//li[contains(text(),'Invalid login credentials. Please try
	// again')]")
	// WebElement Invalidlogin;
	@FindBy(xpath = "//input[@name='TransactionId']")
	WebElement TransactionId;

	@FindBy(xpath = "//input[@name='Amount']")
	WebElement Amount;

	@FindBy(xpath = "//button[contains(.,' Submit ')]")
	WebElement SubmitBtn;

	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement OkBtn;
	
	
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	WebElement  cancelButton;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okButton;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(TransactionId);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	public PaymentGatewaysPage EnterTransactionDetails(String AmountPaid, String TransactionID ) throws Exception {

		waitForElementToPresent(TransactionId);
		TransactionId.sendKeys(TransactionID);
		Amount.sendKeys(AmountPaid);
		Thread.sleep(3000);
		// new TestBase().captureScreen(, driver);
		picture();
		SubmitBtn.click();
		waitForElementToPresent(OkBtn);
		picture();
		OkBtn.click();
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
		// new PaymentGatewaysPage(driver, );
	}

	public AuthorizeMerchanLogin gotoMerchanLoginPage() {

		return (AuthorizeMerchanLogin) openPage(AuthorizeMerchanLogin.class);
	}

	public PayPalMerchant payPallogin() {

		return (PayPalMerchant) openPage(PayPalMerchant.class);
	}
	
	public PaymentGatewaysPage cancelTransaction()
		
	       {
		
	               click(cancelButton, "button");
		
	               return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
		
	       }
		
	       
		
	       public PaymentGatewaysPage invalidTransactionDetails(String AmountPaid, String TransactionID ) throws Exception {
		
		
	               waitForElementToPresent(TransactionId);
		
	               TransactionId.sendKeys(TransactionID);
		
	               Amount.sendKeys(AmountPaid);
		
	               SubmitBtn.click();
		
	               Thread.sleep(4000);
		
	               TransactionId.clear();
		
	               Thread.sleep(1000);
		
	               TransactionId.sendKeys(TransactionID);
		
	               SubmitBtn.click();
		
	               Thread.sleep(4000);
		
	               TransactionId.clear();
		
	               Thread.sleep(1000);
		
	               TransactionId.sendKeys(TransactionID);
		
	               SubmitBtn.click();
		
	               Thread.sleep(1000);
		
	               okButton.click();
		
	               return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
		
	               
		
	               // new PaymentGatewaysPage(driver, );
	
	       }

		public String getAmountPaid(String name) throws Exception {
			
			return readInNotePadFile(name);
		}
	
	

}
