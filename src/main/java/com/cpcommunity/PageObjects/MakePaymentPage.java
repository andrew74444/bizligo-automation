package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MakePaymentPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(heading);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		aShot();
	}
	@FindBy(xpath = "//nav[@class='navbar navbar-inverse']")
	WebElement header;
	@FindBy(xpath = "//h4[normalize-space()='Make Payment']")
	WebElement heading;
	@FindBy(xpath = "//input[@value='2']")
	WebElement Authorised;
	@FindBy(xpath = "//form[@id='AuthorizeHostedCheckOutform']//button[@type='submit'][normalize-space()='Proceed']")
	WebElement proceed;
	
	
	
	public AuthorizeGateway payment() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToPresent(Authorised);
		click(Authorised, "Authorised.Net");
	    Thread.sleep(2000);
	    scrollDownVertically();
	    waitForElementToPresent(proceed);
	    //clickElementByJavaScript(proceed);
	    click(proceed, "Click Proceed");
		Thread.sleep(4000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	
		
		
	}
	
}
