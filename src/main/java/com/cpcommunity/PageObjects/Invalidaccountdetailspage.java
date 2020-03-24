package com.cpcommunity.PageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class Invalidaccountdetailspage extends BasePage 

{
	 @FindBy(xpath = "//*[contains(text(),'Invalid account details. Please provide valid details and retry.')]")
	    WebElement invalidAccount;
	 
	 @FindBy(xpath = "//*[contains(text(),'Back to Payment gateways')]")
	 WebElement backtoPaymentGateways;
	 
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(invalidAccount);
	}

	public PaymentGatewaysPage goToPaymentGatewayPage()
	{
		click(backtoPaymentGateways, "back to PaymentGateways");
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
	}
}


