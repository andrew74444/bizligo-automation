package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@FindBy(xpath = "//a[@title='Manage Community']")
	WebElement managecommunity;
	@FindBy(xpath = "//a[@title='Manage Community']")
	WebElement managetogocommunity;
	
	@FindBy(xpath = "//a[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;
	@FindBy(xpath = "//a[normalize-space()='Revenue Reports']")
	WebElement revenuereport;
	@FindBy(xpath = "//span[@id='inbox-id']")
	WebElement boxId;
	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement emailName;
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement toggledropdown;
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement myeco;
	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement setBtn;
	
	
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
		writeInNotePad(amount, name);
		return amount;
	}

	public String makePayment() throws Exception {

		//type(cardNum, "4242424242424242", "card Num");
		//type(ExpiryDate, "0223", "Expiry Date");
		//type(CVV, "024", "CVV");
		type(cardNum, "4111111111111111", "card Num");
		type(ExpiryDate, "1221", "Expiry Date");
		type(CVV, "523", "CVV");

		while (true) {
			if (cardNum.getAttribute("value").length() == 19) {
				break;
			}
			System.out.println(cardNum.getAttribute("value"));
			cardNum.clear();
			Thread.sleep(2000);
			cardNum.sendKeys("4");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
			cardNum.sendKeys("1");
			Thread.sleep(1000);
		}

		if (ExpiryDate.getAttribute("value").equalsIgnoreCase("12/21")) {

		} else {
			while (true) {
				if (ExpiryDate.getAttribute("value").equalsIgnoreCase("12/21")) {
					break;
				}
				ExpiryDate.clear();
				Thread.sleep(1000);
				ExpiryDate.sendKeys("1221");
				Thread.sleep(1000);
			}
		}

		if (ExpiryDate.getAttribute("value").equalsIgnoreCase("12/21")) {

		} else {
			while (true) {
				if (CVV.getAttribute("value").equalsIgnoreCase("523")) {
					break;
				}
				CVV.clear();
				Thread.sleep(1000);
				CVV.sendKeys("523");
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

		//type(email, "andrew74444@gmail.com", "email");
		type(email, "nancycarton2@gmail.com", "email");

		String orderTotalAmount = this.orderTotalAmount.getText();
        click(PayBtn, "payBtn");
		//clickElementByJavaScript(PayBtn);

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
	
	public ManageCommunitiesPage navigateManageCommunities() {
		waitForElementToPresent(managecommunity);
		click(managecommunity, "Manage Community");
		
		return (ManageCommunitiesPage) openPage(ManageCommunitiesPage.class);
		
	}
	
	public RevenueReportPage navigateToRevenueReport() throws InterruptedException {
		Thread.sleep(8000);
		//scrollDownVertically();
		click(advertisement, "Advertisement");
		waitForElementToPresent(managetogocommunity);
		//scrollUpVertically();
		click(managetogocommunity, "Manage button");
		Thread.sleep(8000);
		scrollUpVertically();
		waitForElementToPresent(dashboardreport);
		click(dashboardreport, "Dashboard Reports");
		Thread.sleep(8000);
		waitForElementToPresent(revenuereport);
		click(revenuereport, "Revenue Report");
		return (RevenueReportPage) openPage(RevenueReportPage.class);	
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
	public void openGuerillamail(String emailName) throws InterruptedException, AWTException {
		// Thread.sleep(5000);
	     //((JavascriptExecutor)driver).executeScript("window.open()");
	    // Thread.sleep(2500);
	    // ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
	     //driver.switchTo().window(wins.get(1));
	     driver.get("https://www.guerrillamail.com/");
	     Thread.sleep(5000);
	     click(boxId,"BoxID");
	     Thread.sleep(5000);
	     this.emailName.clear();
	     Thread.sleep(2000);
	     type(this.emailName, emailName, "emailName");
	     Thread.sleep(5000);
	     click(setBtn,"set Button");
	     Thread.sleep(180000);
	     Actions ac = new Actions(driver);
	     ac.contextClick().build().perform();
	     Thread.sleep(5000);
	     Robot r = new Robot();
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_ENTER);
	    // Thread.sleep(1000);
	    // click(emailVerify,"passwordVerify");
	   //  Thread.sleep(1500);
	    // String password = passWord.getText();
	   //  Thread.sleep(2000);
	    // ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
	    // driver.switchTo().window(wins1.get(0));
	     Thread.sleep(8000);
	 }
	
	public MyDashboardPage gotoMyDashPage() throws InterruptedException {
		scrollUpVertically();
		waitForElementToPresent(toggledropdown);
		click(toggledropdown, "Toggle dropdown");
		Thread.sleep(5000);
		waitForElementToPresent(myeco);
        click(myeco, "My Ecosystem");
        Thread.sleep(8000);
		return (MyDashboardPage) openPage(MyDashboardPage.class);
	}
}
