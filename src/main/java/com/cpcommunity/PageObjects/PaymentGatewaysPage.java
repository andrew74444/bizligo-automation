package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.apache.log4j.Logger;

public class PaymentGatewaysPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();//

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
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;

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
	@FindBy(xpath = "//select[@id='CommunityID']")
	WebElement selectCommunity;
	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement active;
	@FindBy(xpath = "//label[normalize-space()='In-Active']")
	WebElement inactive;
	@FindBy(xpath = "//span[@class='ng-binding']")
	WebElement update;
	@FindBy(xpath = "//a[normalize-space()='Donate']")
	WebElement donateBtn;
	@FindBy(xpath="//input[@value='2']")
	List<WebElement> authorizeBtns;
	
	@FindBy(xpath="//ng-repeat[1]//li[1]//label[1]//input[1]")
	List<WebElement> paypalBtns;
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement gatewayerror;



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
	public void inactiveAuthorizeGateway() throws InterruptedException {
		selectByVisibleText(selectCommunity,"BizLigo1","Bizligo1");
		Thread.sleep(3000);
		Authorize.click();
		Thread.sleep(3000);
		click(active,"Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(1000);
		
	}
	
	public void inactiveAuthorizeGateway(String community) throws InterruptedException {
		selectByVisibleText(selectCommunity,community,"Bizligo1");
		Thread.sleep(9000);
		Authorize.click();
		Thread.sleep(5000);
		click(inactive,"Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(9000);
		
	}
	public void activeAuthorizeGateway(String community) throws InterruptedException {
		selectByVisibleText(selectCommunity,community,"Bizligo1");
		Thread.sleep(9000);
		Authorize.click();
		Thread.sleep(3000);
		click(inactive," Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(5000);
		
	}
	public void inactiveCash(String community) throws InterruptedException {
		selectByVisibleText(selectCommunity,community,"Bizligo1");
		Thread.sleep(9000);
		Cash.click();
		Thread.sleep(5000);
		//click(inactive,"Active");
		//click(update,"Update");
		waitForElementToPresent(gatewayerror);
		String error=this.gatewayerror.getText();
		System.out.println(error);
		click(cancel,"Cancel");
		Thread.sleep(5000);
		
	}
	public void activeCash(String community) throws InterruptedException {
		selectByVisibleText(selectCommunity,community,"Bizligo1");
		Thread.sleep(3000);
		Cash.click();
		Thread.sleep(3000);
		click(active,"In Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(5000);
		
	}
	public void activeAuthorizeGateway() throws InterruptedException {
		selectByVisibleText(selectCommunity,"BizLigo1","Bizligo1");
		Thread.sleep(3000);
		Authorize.click();
		Thread.sleep(3000);
		click(inactive,"In Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(1000);
		
	}
	public void inactivePaypalGateway() throws InterruptedException {
		selectByVisibleText(selectCommunity,"BizLigo1","Bizligo1");
		Thread.sleep(3000);
		PayPal.click();
		Thread.sleep(3000);
		click(active,"Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(1000);
		
	}
	public void activePayPalGateway() throws InterruptedException {
		selectByVisibleText(selectCommunity,"BizLigo1","Bizligo1");
		Thread.sleep(3000);
		PayPal.click();
		Thread.sleep(3000);
		click(inactive,"In Active");
		click(update,"Update");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		Thread.sleep(1000);
		
	}
	

	
	







}
