package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

public class CheckInPage extends BasePage {

	@FindBy(xpath = "//*[@class='btn btn-default otbalBulkBtn']")
	WebElement bulkbadgeBtn;
	@FindBy(xpath = "//*[contains(text(),'Book Tickets')]")
	WebElement bookTicketsTab;
	@FindBy(xpath = "//select")
	WebElement selectTickets;
	@FindBy(xpath = "//h4[contains(.,'Event Attendees')]")
	WebElement attendeFormView;
	@FindBy(xpath = "//*[@name='FirstName[]']")
	WebElement FirstName;
	@FindBy(xpath = "//*[@name='LastName[]']")
	WebElement LastName;
	@FindBy(xpath = "")
	WebElement Phone;
	@FindBy(xpath = "//*[@name='Company[]']")
	WebElement companyName;
	@FindBy(xpath = "//input[@name='EmailID[]']")
	WebElement AttendeeEmailID;
	@FindBy(xpath = "//*[@name='Phone[]']")
	WebElement AttendeePhone;
	@FindBy(xpath = "//*[@id='eventAttendeesForm']")
	WebElement eventAttendeesForm;
	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement NextBtn;
	@FindBy(xpath = "//h4[contains(text(),'Booking Information')]")
	WebElement BookingInformation;
	
	
	@FindBy(xpath = "//input[@name='PayerEmailID']")
	WebElement PayerEmailID;
	@FindBy(xpath = "//input[@name='PayerPhone']")
	WebElement PayerPhone;
	@FindBy(xpath = "(//*[@id='PayerInfoForm']//*[@class='panel panel-default'])[1]")
	WebElement payerForm;
	@FindBy(xpath = "//button[contains(text(),'Book Now')]")
	WebElement BookNowBtn;
	@FindBy(xpath = "//input[@value='1']")
	WebElement btnPayPal;
	@FindBy(xpath = "//input[@value='2']")
	WebElement authorizeNet;
	@FindBy(xpath = "//input[@value='3']")
	WebElement cash;
	@FindBy(xpath = "//input[@value='4']")
	WebElement cheuque;
	@FindBy(xpath = "//*[@id='Authorizeform']//button[contains(.,'Proceed')]")
	WebElement proceed;
	@FindBy(xpath = "//*[@type]//*[@class='fa fa-paypal']")
	WebElement paypalProceed;
	
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(text(),'Payment')] | //button[@class='btn btn-primary disabled']")
	WebElement payment;
	@FindBy(xpath = "//*[contains(text(),'Booking ID')]/following-sibling::strong")
	WebElement BookingID;
	@FindBy(xpath = "//*[@class='panel panel-default']//*[contains(text(),'Success')]")
	WebElement success;
	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed')]")
	WebElement freeEventRegistrationProcessed;
	



	// *[@class='row payby-cash']//button[contains(.,'Payment')]

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(bulkbadgeBtn);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();
	}

	public void clickOnBookTicketsTab() {
		click(bookTicketsTab, "bookTicketsTab");
	}

	public void addAttendeeDetails(Hashtable<String, String> data) throws Exception {
		waitForElementToPresent(selectTickets);
		selectByVisibleText(selectTickets, "1", "Selecting Tickets");
		Thread.sleep(2000);
		scrollToElement(attendeFormView);
		Thread.sleep(2000);
		AttendeeEmailID.clear();
		type(AttendeeEmailID, data.get("attendeeEmailID"), "Attendee Email ID");
		AttendeePhone.click();
		Thread.sleep(2000);
		FirstName.clear();
		LastName.clear();
		this.companyName.clear();
		type(FirstName, data.get("attendeeFirstName"), "First Name");
		type(LastName, data.get("attendeLastName"), "Last Name");
		type(companyName, data.get("companyName"), "Company Name");
		takeScreenshotByShutterBug(eventAttendeesForm, "event Attendees Form");
	}

	public void addPayerDetails(Hashtable<String, String> data) throws Exception {
		click(NextBtn, "next");
		waitForElementToPresent(PayerEmailID);
		scrollToElement(BookingInformation);
		PayerEmailID.clear();
		type(PayerEmailID, data.get("payerEmailID"), "Payer Email ID");
		PayerPhone.click();
		Thread.sleep(4000);
		takeScreenshotByShutterBug(payerForm, "Payer Form");
	}

	public void clickOnBookNow() {
		click(BookNowBtn, "BookNowBtn");
	}

	public void registerFreeEvent(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();		
		this.addAttendeeDetails(data);
		picture();
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(freeEventRegistrationProcessed);
		
		this.registeredEventsuccessfully();
	}

	public AuthorizeGateway registerEventbyAuthorizeNet(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();
		this.addAttendeeDetails(data);
		
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(authorizeNet);
		click(authorizeNet, "Selecting AuthorizeNet");
		waitForElementToPresent(proceed);
		click(proceed, "Proceed");
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

	public PayPalPayment registerEventByPayPal(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(btnPayPal);
		click(btnPayPal, "Selecting PayPal");
		waitForElementToPresent(paypalProceed);
		click(paypalProceed, "paypalProceed");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	public void cashPayment(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(cash);
		click(cash, "cash");
		waitForElementToPresent(payment);
		picture();
		click(payment, "payment");
		this.registeredEventsuccessfully();
	}

	@FindBy(xpath="//*[@name='ChequeNumber']")
	WebElement chequeNumber;
	@FindBy(xpath="//*[@name='ChequeDate']")
	WebElement chequeDate;
	
	public void chequePayment(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		waitForElementToPresent(cheuque);
		click(cheuque, "cheuque");
		waitForElementToPresent(payment);
		type(chequeNumber,"454545145","cheque Number");
		click(chequeDate,"cheque Date");
		DateManager d = new DateManager(driver);
		String currentDate = d.getCurrentDateString();
		d.selectDate("//*[@class='daterangepicker dropdown-menu ltr single openscenter show-calendar']", currentDate);
		Thread.sleep(1000);
		picture();
		click(payment, "payment");
		this.registeredEventsuccessfully();
		
	}

	public void registeredEventsuccessfully() {
		waitForElementToPresent(success);
		aShot();
	}

}
