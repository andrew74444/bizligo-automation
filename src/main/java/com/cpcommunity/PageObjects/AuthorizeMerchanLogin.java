package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AuthorizeMerchanLogin extends BasePage {

	@FindBy(xpath = "//input[@name='input-username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='input-password']")
	WebElement password;
	@FindBy(xpath = "//button[contains(.,'Log In')]")
	WebElement LogInbtn;

	@FindBy(xpath = "//a[contains(.,'Transaction Search')]")
	WebElement TransactionSearchLink;

	@FindBy(xpath = "//a[contains(.,'Unsettled Transactions')]")
	WebElement UnsettledTransactionsLink;

	@FindBy(xpath = "//*[@id='Main']/form[1]/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/a")
	WebElement TransactionID;

	@FindBy(xpath = "//div[contains(text(),'Unsettled Transactions')]")
	WebElement UnsettledTransactions;

	
	String Url;
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		
		Url = driver.getCurrentUrl();
		driver.get("https://sandbox.authorize.net/");
		driver.switchTo().frame(0);
		return ExpectedConditions.visibilityOf(username);
	}

	public String MerchantLogin() throws Exception {

		
		
		Thread.sleep(2000);
		
		waitForElementToPresent(username);
		Thread.sleep(10000);
		type(username, "viswanadhms1234", "user name");
		type(password, "Pamten@1234", "password");
		// type(element, value, elementName);
		click(LogInbtn, "LogInbtn");
		waitForElementToPresent(TransactionSearchLink);
		click(TransactionSearchLink, "TransactionSearchLink");
		waitForElementToPresent(UnsettledTransactionsLink);
		click(UnsettledTransactionsLink, "nsettledTransactionsLink");
		waitForElementToPresent(UnsettledTransactions);
		String ID = TransactionID.getText();
		String Amount = driver.findElement(By.xpath("//*[@id='TranAmount_" + ID + "']")).getText();
		Amount = Amount.replace("USD ", "");
		String X = Amount + " " + ID;
		driver.switchTo().defaultContent();

		driver.get(Url);

		return ID;
	}
	
	public PaymentConfirmation confirmation () {
	
		return (PaymentConfirmation) openPage(PaymentConfirmation.class);
	}
	

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	// }
	//

}
