package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

public class PaymentConfirmation extends BasePage {

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

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
	WebElement cancelButton;

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
	public PaymentGatewaysPage EnterTransactionDetails(String AmountPaid, String TransactionID) throws Exception {

		waitForElementToPresent(TransactionId);
		type(TransactionId, TransactionID, "TransactionId");
		type(Amount, AmountPaid, "Amount");

		Thread.sleep(3000);
		// new TestBase().captureScreen(, driver);
		picture();
		click(SubmitBtn, "SubmitBtn");
		waitForElementToPresent(OkBtn);
		picture();

		click(OkBtn, "OkBtn");
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

	public PaymentGatewaysPage invalidTransactionDetails(String AmountPaid, String TransactionID) throws Exception {

		waitForElementToPresent(TransactionId);
		type(TransactionId, TransactionID, "TransactionId");

		type(Amount, AmountPaid, "Amount");

		click(SubmitBtn, "SubmitBtn");

		Thread.sleep(4000);

		TransactionId.clear();

		Thread.sleep(1000);
		type(TransactionId, TransactionID, "TransactionID");

		click(SubmitBtn, "SubmitBtn");

		Thread.sleep(4000);

		TransactionId.clear();

		Thread.sleep(1000);

		type(TransactionId, TransactionID, "TransactionID");

		click(SubmitBtn, "SubmitBtn");

		Thread.sleep(1000);

		click(okButton, "okButton");

		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);

		// new PaymentGatewaysPage(driver, );

	}

	public String getAmountPaid(String name) throws Exception {

		return readInNotePadFile(name);
	}

}
