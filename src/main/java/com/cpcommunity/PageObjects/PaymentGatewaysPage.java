package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

public class PaymentGatewaysPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@FindBy(xpath = "//h2[contains(text(),'Manage Payment Gateways')]")
	WebElement ManagePaymentGatewaysHeader;

	@FindBy(xpath = "//tbody//tr[1]//td[1]//button[1]//i[1]")
	WebElement PayPal;

	@FindBy(xpath = "//tbody//tr[2]//td[1]//button[1]//i[1]")
	WebElement Authorize;

	@FindBy(xpath = "//tbody//tr[3]//td[1]//button[1]//i[1]")
	WebElement Cash;

	@FindBy(xpath = "//tbody//tr[4]//td[1]//button[1]//i[1]")
	WebElement Cheque;

	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement OkBtn;

	@FindBy(xpath = "//*[@id=\"PaymentForm\"]/div[2]/div/div/div/label[1]")
	WebElement toogleButton;

	@FindBy(xpath = "//*[@class = 'swal-button swal-button--Cancel btn-danger']")
	WebElement cancelBtn;

	@FindBy(xpath = "//button[contains(.,'Validate')]")
	WebElement ValidateBtn;
	@FindBy(xpath = "//input[@name='txtAPILoginID']")
	WebElement APILoginID;
	@FindBy(xpath = "//input[@name='txtTransactionKey']")
	WebElement txtTransactionKey;
	@FindBy(xpath = "//input[@name='txtContent']")
	WebElement txtContent;
	@FindBy(xpath = "//*[contains(text(),'Activate')]")
	WebElement Activate;
	@FindBy(xpath = "//*[contains(text(),'InActivate')]")
	WebElement InActivate;
	@FindBy(xpath = "//button[contains(.,'Activate')]")
	WebElement Activaqte;
	@FindBy(xpath = "html/body/div[2]/div/div[2]")
	WebElement PaymentMethod;

	@FindBy(xpath = "//input[@name='TransactionId']")
	WebElement TransactionId;
	@FindBy(xpath = "//input[@name='Amount']")
	WebElement Amount;
	@FindBy(xpath = "//button[contains(.,' Submit ')]")
	WebElement SubmitBtn;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(ManagePaymentGatewaysHeader);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public SetupPayPalPage SetPayPal() throws Exception {
		click(PayPal,"PayPal");
		this.OkBtn();
		Thread.sleep(2000);
		return (SetupPayPalPage) openPage(SetupPayPalPage.class);
		// new SetupPayPalPage(driver, );
	}

	public SetupPayPalPage navigateToActivatePayPal() {
		click(PayPal,"PayPal");
		return (SetupPayPalPage) openPage(SetupPayPalPage.class);
		// new SetupPayPalPage(driver, );
	}

	public SetupAuthorizePage navigateActivateAuthorize() {
		click(Authorize,"Authorize");
		return (SetupAuthorizePage) openPage(SetupAuthorizePage.class);
		// new SetupAuthorizePage(driver, );
	}

	public SetupAuthorizePage setUpAuthorize() throws Exception {

		click(Authorize,"Authorize");
		this.OkBtn();
		Thread.sleep(2000);
		return (SetupAuthorizePage) openPage(SetupAuthorizePage.class);
		// new SetupAuthorizePage(driver, );
	}

	
	public PaymentConfirmation gotoConfirmPaymentPage() throws Exception {

		
		
		return (PaymentConfirmation) openPage(PaymentConfirmation.class);
		// new SetupAuthorizePage(driver, );
	}
	
	public void activateCash() throws Exception {

		click(Cash,"Cash");
		this.ClickonActivate();
		Thread.sleep(2000);

	}

	public void activateCheque() throws Exception {

		click(Cheque,"Cheque");
		this.ClickonActivate();
		Thread.sleep(2000);

	}

	public void inActivateCheque() {
		click(Cheque,"Cheque");
		this.ClickonInActivate();
	}

	public void inActivateCash() {

		click(Cash,"Cash");
		this.ClickonInActivate();
	}

	public void ClickonInActivate() {
		waitForElementToPresent(InActivate);
		click(InActivate,"InActivate");
		this.OkBtn();
	}

	public void ClickonActivate() {
		waitForElementToPresent(Activate);
		click(Activate,"Activate");
		this.OkBtn();
	}

	public void OkBtn() {

		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
	}

	public PaymentGatewaysPage InactiveAuthorize() throws InterruptedException
	{

		click(Authorize,"Authorize");

		click(toogleButton,"toogleButton");

		Thread.sleep(1000);

		click(Activate,"Activate");

		click(cancelBtn,"cancelBtn");

		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);

	}

}
