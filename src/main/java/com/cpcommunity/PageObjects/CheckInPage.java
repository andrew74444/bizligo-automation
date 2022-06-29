package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
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
	@FindBy(xpath = "//*[@type='submit']/*[text()='Next']")
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
	@FindBy(xpath = "//*[@class='radio-inline']/*[@value='1']")
	WebElement btnPayPal;
	//@FindBy(xpath = "//input[@value='2']")
	@FindBy(xpath = "//*[@class='radio-inline']/*[@value='2']")//added on 30/03
	WebElement authorizeNet;
	//@FindBy(xpath = "//input[@value='3']")
	@FindBy(xpath = "//*[@class='radio-inline']/*[@alt='Cash']")//added on 29/03
	WebElement cash;
	@FindBy(xpath = "//*[@class='radio-inline']/*[@value='4']")
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
	@FindBy(xpath="(//select)[1]")
			WebElement paidTicket;
	public void addAttendeeDetails(Hashtable<String, String> data) throws Exception {
//		waitForElementToPresent(selectTickets);
//		selectByVisibleText(selectTickets, "1", "Selecting Tickets");
		waitForElementToPresent(paidTicket);
		selectByVisibleText(paidTicket, "1", "Selecting Ticket");//based on events page ticket list 
	//	Thread.sleep(2000);
		scrollToElement(attendeFormView);
	//	Thread.sleep(2000);
		AttendeeEmailID.clear();
		waitForElementToPresent(AttendeeEmailID);
		type(AttendeeEmailID, data.get("attendeeEmailID"), "Attendee Email ID");
	//	scrollDownVertically();
		click(AttendeePhone,"Attendee Phone");
		Thread.sleep(2000);
		FirstName.clear();
		LastName.clear();
		this.companyName.clear();
		waitForElementToPresent(FirstName);
		type(FirstName, data.get("attendeeFirstName"), "First Name");
		waitForElementToPresent(LastName);
		type(LastName, data.get("attendeLastName"), "Last Name");
		type(companyName, data.get("companyName"), "Company Name");
	//	takeScreenshotByShutterBug(eventAttendeesForm, "event Attendees Form");
		
	}
	@FindBy(xpath="(//select)[1]")
	WebElement freeTicket;
	public void addAttendeeDetails2(Hashtable<String, String> data) throws Exception {
//		waitForElementToPresent(selectTickets);
//		selectByVisibleText(selectTickets, "1", "Selecting Tickets");
		waitForElementToPresent(freeTicket);
		selectByVisibleText(freeTicket, "1", "Selecting Ticket");//based on events page ticket list 
	//	Thread.sleep(2000);
		scrollToElement(attendeFormView);
	//	Thread.sleep(2000);
	//	AttendeeEmailID.clear();
		waitForElementToPresent(AttendeeEmailID);
		type(AttendeeEmailID, data.get("attendeeEmailID"), "Attendee Email ID");
	//	scrollDownVertically();
		click(AttendeePhone,"Attendee Phone");
		Thread.sleep(2000);
		FirstName.clear();
		LastName.clear();
		this.companyName.clear();
		type(FirstName, data.get("attendeeFirstName"), "First Name");
		type(LastName, data.get("attendeLastName"), "Last Name");
		type(companyName, data.get("companyName"), "Company Name");
	//	takeScreenshotByShutterBug(eventAttendeesForm, "event Attendees Form");
		
	}
	@FindBy(xpath="//*[@name='PayerFirstName']")
	WebElement payerFirstName;
	@FindBy(xpath="//*[@name='PayerLastName']")
	WebElement payerLastName;
	@FindBy(xpath="//*[@name='PayerCompany']")
	WebElement payerCompany;
	public void addPayerDetails(Hashtable<String, String> data) throws Exception {
		
	
		waitForElementToPresent(PayerEmailID);
		scrollToElement(BookingInformation);
		PayerEmailID.clear();
		payerFirstName.clear();
		payerLastName.clear();
		type(PayerEmailID, data.get("payerEmailID"), "Payer Email ID");
		type(PayerPhone, data.get("payerPhone"), "Payer Phone");
		waitForElementToPresent(payerFirstName);
		type(payerFirstName, data.get("payerFirstName"), "Payer First Name");
		waitForElementToPresent(payerLastName);
		type(payerLastName, data.get("payerLastName"), "Payer Last name");
		type(payerCompany, data.get("payerCompany"), "Payer company");
		click(PayerPhone," Payer Phone");
	//	Thread.sleep(4000);
	//	takeScreenshotByShutterBug(payerForm, "Payer Form");
		
	}

	public void clickOnBookNow() {
		click(BookNowBtn, "BookNowBtn");
	}
	@FindBy(xpath="//*[@class='btn btn-primary']/*[@ng-hide='data.allTicketsTotalPrice() > 0']")//added on 30/03
	WebElement BookNow;
	public void registerFreeEvent(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();		
		this.addAttendeeDetails2(data);
	//	picture();
		clickElementByJavaScript(BookNow);
		Thread.sleep(15000);
		waitForElementToPresent(freeEventRegistrationProcessed);
		
		System.out.println(freeEventRegistrationProcessed.getText());//added on 30/03
		Thread.sleep(2000);
		AssertionHelper.verifyText(freeEventRegistrationProcessed.getText(),
		
		"Your tickets have processed. You will receive an email with the details.");//added on 30/03
		// "Your tickets have processed"
		// Your tickets have processed.. You will receive an email with the details to
		// join the online meeting.
	//	this.registeredEventsuccessfully();//commented on 30/03
	}
	@FindBy(xpath="(//*[@class='btn btn-sm btn-info'])[1]")
	WebElement wait2;
@FindBy(xpath="//*[@class='form-control input-sm']")
WebElement searchBox;
@FindBy(xpath="//*[@title='Click to reject this ticket']")
WebElement reject;
@FindBy(xpath="//*[@placeholder='Enter the reason for rejection']")
WebElement note;
@FindBy(xpath="//*[@class='btn btn-danger']")
WebElement rejectBtn;
      
          public void declineComplimentryTicket(String email) throws InterruptedException {
 waitForElementToPresent(wait2);
 waitForElementToPresent(searchBox);
 type(searchBox,email,"mail");
 Thread.sleep(10000);
 waitForElementToPresent(reject);
 click(reject,"reject complimentry ticket");
 waitForElementToPresent(note);
 type(note,"Try Again","reason");
 waitForElementToPresent(rejectBtn);
 click(rejectBtn,"Reject Button");
 Thread.sleep(5000);
}

	public AuthorizeGateway registerEventbyAuthorizeNet(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		waitForElementToPresent(BookNowBtn);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(15000);
		waitForElementToPresent(authorizeNet);
		click(authorizeNet, "Selecting AuthorizeNet");
		
		waitForElementToPresent(proceed);
		clickElementByJavaScript(proceed);
	//	click(proceed, "Proceed");
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

	public PayPalPayment registerEventByPayPal(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");//added on 29/03
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(10000);
	//	waitForElementToPresent(btnPayPal);
		click(btnPayPal, "Selecting PayPal");
		waitForElementToPresent(paypalProceed);
		click(paypalProceed, "paypalProceed");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/section[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/label[1]")
	WebElement checkBox;
	@FindBy(xpath="//*[@placeholder='Enter Promo code']")
	WebElement textBox;
	@FindBy(xpath="//*[@ng-hide='data.AppliedPromoCodeResponce.IsValid']/*[text()='APPLY']")
	WebElement apply;
	@FindBy(xpath="//*[@class='text-success']")
	WebElement success1;
	public void usingPromoCode(String code) {
		scrollDownVertically();
		waitForElementToPresent(checkBox);
	click(checkBox,"checkBox");
	waitForElementToPresent(textBox);
	type(textBox,code,"Promo Code");
	
	click(apply,"Apply");
	waitForElementToPresent(success1);
	
	}
	public PayPalPayment registerEventByPayPalWithPromo(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		this.usingPromoCode( data.get("promoCode1"));
		waitForElementToPresent(BookNowBtn);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(10000);
	//	waitForElementToPresent(btnPayPal);
		click(btnPayPal, "Selecting PayPal");
		waitForElementToPresent(paypalProceed);
		click(paypalProceed, "paypalProceed");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	public void cashPayment(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(10000);
		waitForElementToPresent(cash);
		clickElementByJavaScript(cash);
	//	click(cash, "cash");
		waitForElementToPresent(payment);
	//	picture();
		click(payment, "payment");
		Thread.sleep(10000);
	//	this.registeredEventsuccessfully();
	}

	@FindBy(xpath="//*[@name='ChequeNumber']")
	WebElement chequeNumber;
	@FindBy(xpath="//*[@name='ChequeDate']")
	WebElement chequeDate;
	
	public void chequePayment(Hashtable<String, String> data) throws Exception {
		this.clickOnBookTicketsTab();	
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(10000);
		waitForElementToPresent(cheuque);
		click(cheuque, "cheuque");
		waitForElementToPresent(payment);
		type(chequeNumber,"454545145","cheque Number");
		click(chequeDate,"cheque Date");
		DateManager d = new DateManager(driver);
		String currentDate = d.getCurrentDateString();
		d.selectDate("//*[@class='daterangepicker dropdown-menu ltr single openscenter show-calendar']", currentDate);
		Thread.sleep(1000);
	//	picture();
		click(payment, "payment");
		this.registeredEventsuccessfully();
		
	}
	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed')]")
	WebElement ticketsProcessed;

	public void registeredEventsuccessfully() throws InterruptedException {
		Thread.sleep(10000);
	//	waitForElementToPresent(success);
		waitForElementToPresent(ticketsProcessed);
		
		//aShot();
	}

}
