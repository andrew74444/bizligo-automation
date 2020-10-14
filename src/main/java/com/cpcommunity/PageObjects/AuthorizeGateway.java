package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizeGateway extends BasePage {

	@FindBy(xpath = "//input[@id='cardNum']")
	WebElement cardNum;

	@FindBy(xpath = "//input[@id='expiryDate']")
	WebElement ExpiryDate;

	@FindBy(xpath = "//input[@id='cvv']")
	WebElement CVV;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@name='zip']")
	WebElement ZipCode;

	@FindBy(xpath = "//*[@name='address']")
	WebElement BillingAddress;

	@FindBy(xpath = "//*[@name='city']")
	WebElement City;

	@FindBy(xpath = "//input[@name='state']")
	WebElement State;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//*[@name='email']")
	WebElement email;

	@FindBy(xpath = "//*[@id='payBtn']")
	WebElement PayBtn;

	@FindBy(xpath = "//*[@id='cancelBtn']")
	WebElement CancelBtn;

	@FindBy(xpath = "//*[@id='orderTotalAmount']")
	WebElement orderTotalAmount;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		updateClass(pageheader, "");
		driver.switchTo().frame("load_payment");
		return ExpectedConditions.visibilityOf(cardNum);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();
	}

	public PaymentReceipt payment() throws Exception {
		this.makePayment();

		return (PaymentReceipt) openPage(PaymentReceipt.class);
	}

	public PaymentConfirmation paymentConfirmation() {

		return (PaymentConfirmation) openPage(PaymentConfirmation.class);
	}
	
	
	public String makePayment(String name) throws Exception {
		String amount = this.makePayment();
		writeInNotePad(amount, "name");
		return amount;
	}

	public String makePayment() throws Exception {

		type(cardNum, "4242424242424242", "card Num");
		type(ExpiryDate, "0223", "Expiry Date");
		type(CVV, "024", "CVV");

		while (true) {
			if (cardNum.getAttribute("value").length() == 19) {
				break;
			}
			System.out.println(cardNum.getAttribute("value"));
			cardNum.clear();
			Thread.sleep(2000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("2");
			Thread.sleep(1000);
		}

		if (ExpiryDate.getAttribute("value").equalsIgnoreCase("02/23")) {

		} else {
			while (true) {
				if (ExpiryDate.getAttribute("value").equalsIgnoreCase("02/23")) {
					break;
				}
				ExpiryDate.clear();
				Thread.sleep(1000);
				ExpiryDate.sendKeys("0223");
				Thread.sleep(1000);
			}
		}

		if (ExpiryDate.getAttribute("value").equalsIgnoreCase("02/23")) {

		} else {
			while (true) {
				if (CVV.getAttribute("value").equalsIgnoreCase("024")) {
					break;
				}
				CVV.clear();
				Thread.sleep(1000);
				CVV.sendKeys("024");
				Thread.sleep(1000);
			}
			System.out.println("=" + CVV.getAttribute("value") + "=");
		}

		// type(FirstName, ObjectReader.reader.fName(), "FirstName");

		// type(LastName, ObjectReader.reader.lName(), "LastName");

		// Select Country = new
		// Select(driver.findElement(By.xpath("//button[@type='button']")));
		// Country.selectByVisibleText("USA");

		// type(ZipCode, ObjectReader.reader.zip(), "Zip Code");
		// type(BillingAddress, ObjectReader.reader.address(), "Billing Address");
		//
		// type(City, ObjectReader.reader.cityName(), "City");
		//
		// type(State, String.valueOf(ObjectReader.reader.phNo()), "State");

		type(email, "andrew74444@gmail.com", "email");

		String orderTotalAmount = this.orderTotalAmount.getText();

		clickElementByJavaScript(PayBtn);

		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		orderTotalAmount = orderTotalAmount.replace("$", "");
		writeInNotePad(orderTotalAmount, "orderTotalAmount");

		return orderTotalAmount;
	}

	public EventTicketPage MakePaymentToEvent() throws Exception {

		this.makePayment();

		return (EventTicketPage) openPage(EventTicketPage.class);
		//
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	// }
	//
	// public ZohoCliqPage gotoCliq() {
	//
	// click(cliq,"Cliq Link");
	// return (ZohoCliqPage) openPage(ZohoCliqPage.class);
	// }
	//
	// public ZohoSubscriptionsPage gotoSubscriptions() {
	//
	// click(subscriptions,"Subscriptions Link");
	// return (ZohoSubscriptionsPage) openPage(ZohoSubscriptionsPage.class);
	// }
	//
	// public ZohoCreatorPage gotoCreator() {
	//
	// click(creator,"Creator Link");
	// return (ZohoCreatorPage) openPage(ZohoCreatorPage.class);
	//
	// }

	// public ZohoSalesIQPage gotoSalesIQ() {
	//
	// click(salesIQ,"SalesIQ Link");
	// return (ZohoSalesIQPage) openPage(ZohoSalesIQPage.class);
	// }

}
