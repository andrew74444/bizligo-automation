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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(0);
		return ExpectedConditions.visibilityOf(username);
	}

	public String getTransactionID() throws Exception {

		
		
		Thread.sleep(2000);
		
		waitForElementToPresent(username);
		Thread.sleep(10000);
		type(username, "Brooks2018", "username");
		type(password, "P@ssw0rd", "password");
		// type(element, value, elementName);
		click(LogInbtn, "LogInbtn");
		Thread.sleep(30000);
		waitForElementToPresent(TransactionSearchLink);
		click(TransactionSearchLink, "TransactionSearchLink");
		Thread.sleep(30000);
		waitForElementToPresent(UnsettledTransactionsLink);
		click(UnsettledTransactionsLink, "UnsettledTransactionsLink");
		Thread.sleep(30000);
		waitForElementToPresent(UnsettledTransactions);
		String ID = TransactionID.getText();
		String Amount = driver.findElement(By.xpath("//*[@id='TranAmount_" + ID + "']")).getText();
		Amount = Amount.replace("USD ", "");
		String X = Amount + " " + ID;
		driver.switchTo().defaultContent();

		driver.get(Url);

		return ID;
	}
	
	public PaymentConfirmation goPaymentConfirmationPage () {
	
		return (PaymentConfirmation) openPage(PaymentConfirmation.class);
	}
	

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	// }
	//

}
