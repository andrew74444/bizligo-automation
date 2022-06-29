package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;




public class PaymentOptionsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	
	@FindBy(xpath = "//*[contains(text(),'SELECT PAYMENT METHOD')]")
	WebElement selectPaymentMethods;

	@FindBy(xpath = "(//*[@class='gateway'])//*[@value='1']")
	WebElement payPal;

	@FindBy(xpath = "(//*[@class='fa fa-paypal'])")
	WebElement payPalProceedbtn;

	@FindBy(xpath = "(//*[@class='gateway'])//*[@value='2']")
	WebElement authorize;

	@FindBy(xpath = "//*[@type='submit']//*[@class='fa fa-credit-card']")
	WebElement authorizeProccedbtn;

	@FindBy(xpath = "(//button[@type='submit'])[1] | (//button[@type='submit'])[2]")
	WebElement proceedToPaymentGateway;
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement promoCodecheckbox;
	
	@FindBy(xpath="//input[@placeholder='Enter Promo code']")
	WebElement promoCode;
	
	@FindBy(xpath="//*[contains(text(),'APPLY')]")
	WebElement applybtn;
	
	@FindBy(xpath="//*[contains(text(),'Congratulations!')]")
	WebElement promoCodeApplied;

	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(selectPaymentMethods);
	}

	
	
	
	
	public PayPalPayment paymentByPayPal() {
		waitForElementToPresent(payPal);
		click(payPal, "Selecting payPal button");
		click(payPalProceedbtn, "Proceed button");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	public AuthorizeGateway paymentByauthorize() throws Exception {
		waitForElementToPresent(authorize);
		click(authorize, "Selecting authorize button");
		clickElementByJavaScript(authorizeProccedbtn);
		
		Thread.sleep(10000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

	public void proceedToPayment() {
		waitForElementToPresent(proceedToPaymentGateway);
		click(proceedToPaymentGateway, "Proceed To Payment Gateway");
		picture();
	}


@FindBy(xpath="//*[contains(text(),'Amount to be paid')]/../..//td[2]//span | //*[contains(text(),'Amount to be paid')]/../..//td[3]")
WebElement amountToBePaid;
@FindBy(xpath="//*[contains(text(),'Submit')]")
WebElement sumbit;







	public PaymentReceipt makePayment(String paymentMethod,String promo) throws Exception {
		
	//	promo = chanageToUpperCase(promo).toString();
		applyPromoCode(promo,this.promoCode,applybtn,promoCodeApplied);
	//	Thread.sleep(7000);
	//	if(promo.contains("PROMO")){
			
				waitForElementToPresent(amountToBePaid);	
			
	//	}
		
		
		
		
		if (!amountToBePaid.getText().equalsIgnoreCase("$0.00")) {
			if(paymentMethod.equalsIgnoreCase("Paypal")) {
				PayPalPayment payPalPayment = this.paymentByPayPal();
				payPalPayment.MakePayment();
			}
			if(paymentMethod.equalsIgnoreCase("Authorize")) {
				AuthorizeGateway authorizeGateway =this.paymentByauthorize();
				authorizeGateway.makePayment();
			}
		} else {
			clickElementByJavaScript(sumbit);
			
		}
		return (PaymentReceipt) openPage(PaymentReceipt.class);
	}
	
	
}
