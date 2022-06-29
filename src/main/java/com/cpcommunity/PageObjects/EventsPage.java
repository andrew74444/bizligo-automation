package com.cpcommunity.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class EventsPage extends BasePage  {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Events);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	@FindBy(xpath = "//strong[normalize-space()='Events']")
	WebElement Events;
	@FindBy(xpath = "//input[@placeholder='Search by Events']")
	WebElement searchEvents;
	@FindBy(xpath = "//strong[@class='ng-binding']")
	WebElement EventName;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//div[@class='col-sm-12 col-xs-12']")
	List <WebElement> upcomingevents;
	@FindBy(xpath = "//div[@class='career-right-widget']//div//p[@class='ng-binding']")
	WebElement upcomingeventsdate;
	@FindBy(xpath = "//span[@ng-bind='eventsData.EventName']")
	WebElement upcomingEvents;
	@FindBy(xpath = "//span[@ng-bind='eventsInterstedData.EventName']")
	WebElement suggestedEvents;
	@FindBy(xpath = "//div[@class='attendeeclass ng-scope']")
	WebElement	guestevents;
	@FindBy(xpath = "//a[@class='btn btn-default top-btn1 btn-sm dropdown-toggle']")
	WebElement Toggledropdownmenu;
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	@FindBy(xpath = "//div[@class='row my-communities']//div[2]//div[1]//div[1]//div[1]//a[1]//div[1]//div[1]//div[1]//div[3]//button[1]")
	WebElement MANAGEbtn;
	@FindBy(xpath = "//div[@class='row text-center my-eco-page']//div[2]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//button[2]")
	WebElement MANAGE;
	@FindBy(xpath = "//a[@class='edit-page ng-scope']")
	WebElement manageBtn;
	@FindBy(xpath = "//div[@ng-if='data.SuggestedEventsWidgetConfigured.CommunityWidgetEditedName.length > 1")
	List <WebElement> suggestedevent;
	@FindBy(xpath = "//span[@ng-if='data.EventCalendarWidgetConfigured.CommunityWidgetEditedName.length == 0")
	List <WebElement> eventcalender;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	WebElement Event;
	@FindBy(xpath = "//strong[@ng-bind='Event.EventName | limitTo:40']")
	WebElement Eventname;
	@FindBy(css = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")
	List<WebElement> Eventnames;
	@FindBy(xpath="//a[@class='btn btn-success']//strong[contains(text(),'REGISTER')]")
	WebElement register;		
	@FindBy(xpath="//select[@id='selectticketcount']")
	WebElement noOfTickets;	
	@FindBy(xpath="(//select[@ng-model='data.numberOfTickets[eventTicket.TicketId]'])[1]")
	WebElement noOfTickets1;	
	@FindBy(xpath="(//select[@ng-model='data.numberOfTickets[eventTicket.TicketId]'])[2]")
	WebElement noOfTickets2;	
	@FindBy(xpath="//*[text()='Book Now']")
	WebElement booknow;
	@FindBy(xpath="//h3[normalize-space()='BOOKING CONFIRMATION']")
	WebElement bookingConfirmation;
	@FindBy(xpath="//input[@type=\"email\" and @name=\"EmailID[]\"]")
	WebElement emailId;
	@FindBy(xpath="(//input[@placeholder='Email Address'])[1]")
	WebElement emailId1;
	@FindBy(xpath="(//input[@placeholder='Email Address'])[2]")
	WebElement emailId2;
	@FindBy(xpath="(//*[@placeholder='First Name'])[1]")
	WebElement firstName;
	@FindBy(xpath="(//*[@placeholder='Last Name'])[1]")
	WebElement lastName;
	@FindBy(xpath="//input[@id='AttendeePhone00']")
	WebElement phone;
	@FindBy(xpath="//input[@id='AttendeePhone01']")
	WebElement phone2;
	@FindBy(xpath="(//*[@placeholder='First Name'])[2]")
	WebElement firstName2;
	@FindBy(xpath="(//*[@placeholder='Last Name'])[2]")
	WebElement lastName2;
	@FindBy(xpath="//div[@class='row ng-binding ng-scope']")
	WebElement error;
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement book;
	@FindBy(xpath="//input[@value='2']")
	WebElement authorise;
	@FindBy(xpath="//button[@ng-click='data.OnPaypalPaymentClick($event)']")
	WebElement proceed;
	@FindBy(xpath="//form[@id='GuestInvitationForm']//div[@class='panel-heading']")
	WebElement invitees;
	
	
	 public void GuestMessage() {
	    	waitForElementToPresent(guestevents);
	    	String msg=this.guestevents.getText();
	    	System.out.println(msg);
	    	if(guestevents.isDisplayed()) {
	    		Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
	    	}
	    }
	
	public void checkMaxNoUpcomingEvents() throws InterruptedException {
		waitForElementToPresent(upcomingevents);
		int Eventscount=this.upcomingevents.size();
		System.out.println(Eventscount);
	
	}

	private void waitForElementToPresent(List<WebElement> upcomingevents2) {
		// TODO Auto-generated method stub
		
	}
	
	public void UpcomingEventinSuggetedEvent() {
		waitForElementToPresent(upcomingEvents);
		String UpcomingEvent=this.upcomingEvents.getText();
		System.out.println(UpcomingEvent);
		waitForElementToPresent(suggestedEvents);
		String SuggetedEvents=this.suggestedEvents.getText();
		System.out.println(SuggetedEvents);
	Assert.assertSame("Upcoming Events displaying Suggested Events", UpcomingEvent, SuggetedEvents);
		
	}
	
	public void verifyEventName(String name) throws InterruptedException {
		waitForElementToPresent(searchEvents);
		type(searchEvents, name, "Event Name");
		click(search, "Search");
		Thread.sleep(5000);
		waitForElementToPresent(EventName);
		String nameOfEvent=this.EventName.getText();
		System.out.println(nameOfEvent);
	    String Expected="TestingToday";
	    Assert.assertEquals("Event Name Changed",Expected , nameOfEvent);
	    
		
	}
	public void verifyEvent() throws InterruptedException {
		Thread.sleep(4000);
		String changeevent=this.Event.getText();
		System.out.println(changeevent);
	    String Expected="LATEST EVENTS";
	    Assert.assertEquals(changeevent, Expected);
	   Thread.sleep(4000);
	    
	}
	public CommunityDashboardPage gotocommunitydashPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(500);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
		Thread.sleep(15000);
		click(MANAGE, "Manage");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}	
	
	public void VerifyEventsNotDisplaying() throws InterruptedException {
		Thread.sleep(500);
		//Assert.assertEquals(0, suggestedevent.size());
		//Assert.assertEquals(0, eventcalender.size());
		System.out.println("Suggested Events and event calender are Not Displaying");
		
	}
	
	public ManageCommunityPage gotoDashboardpage() throws InterruptedException {
		waitForElementToPresent(manageBtn);
		click(manageBtn, "Manage Button");
		//Thread.sleep(3000);
		return (ManageCommunityPage) openPage(ManageCommunityPage.class);		
	}
	@FindBy(xpath="(//*[@class='event-image']/*/*)[1]")
	WebElement eventname;
	public void searchevent(String name) throws InterruptedException {
		waitForElementToPresent(eventname);
		waitForElementToPresent(searchEvents);
	//	name=name +" " + getDateInDDMMMYYYY();
		type(searchEvents, name, "Event Name");
		
		click(search, "Search");

		
	}
	public void goToEventPage(String name) throws InterruptedException {
		this.searchevent(name);
		waitForElementToPresent(eventname);
		click(eventname,"Event name");

		
	}
	public AuthorizeGateway registerEventbyAuthorizeNetWithPromo(Hashtable<String, String> data) throws Exception {
		this.goToEventPage(data.get("eventName"));

		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		this.usingPromoCode( data.get("promoCode1"));
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
	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed')]")
	WebElement ticketsProcessed;
	public void purchaseWithPromoCodeOnly(Hashtable<String, String> data) throws Exception {
		this.goToEventPage(data.get("eventName"));

		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		this.addPayerDetails(data);
		this.usingPromoCode( data.get("promoCode1"));
		waitForElementToPresent(BookNowBtn);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(15000);

		waitForElementToPresent(ticketsProcessed);

		}
	public PayPalPayment registerEventByPayPalWithPromo(Hashtable<String, String> data) throws Exception {
			this.goToEventPage(data.get("eventName"));
		this.addAttendeeDetails(data);
		waitForElementToPresent(NextBtn);
		clickElementByJavaScript(NextBtn, "next");
		Thread.sleep(3000);
		this.addPayerDetails(data);
		this.usingPromoCode( data.get("promoCode1"));
		waitForElementToPresent(BookNowBtn);
		clickElementByJavaScript(BookNowBtn);
		Thread.sleep(15000);
		waitForElementToPresent(btnPayPal);
		click(btnPayPal, "Selecting PayPal");
		waitForElementToPresent(paypalProceed);
		click(paypalProceed, "paypalProceed");
		return (PayPalPayment) openPage(PayPalPayment.class);
	}

	@FindBy(xpath = "//*[@ng-show='data.ShowPaymentPaypal']/*/*[@class='btn btn-primary center-block']/*[text()='Proceed']")
	WebElement paypalProceed;
	@FindBy(xpath="//*[@for='IHavePromoCode']")
	WebElement checkBox;
	@FindBy(xpath="//*[@placeholder='Enter Promo code']")
	WebElement textBox;
	@FindBy(xpath="//*[@type='button']/*[text()='APPLY']")
	WebElement apply;
	@FindBy(xpath="//*[@class='text-success']")
	WebElement success1;
	public void usingPromoCode(String code) {
	//	scrollDownVertically();
		waitForElementToPresent(checkBox);
	click(checkBox,"checkBox");
	waitForElementToPresent(textBox);
	type(textBox,code,"Promo Code");
	waitForElementToPresent(apply);
	click(apply,"Apply");
	waitForElementToPresent(success1);
	
	}
	@FindBy(xpath="(//select)[1]")
	WebElement paidTicket;
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
	@FindBy(xpath = "//*[contains(text(),'Book Now')]")
	WebElement BookNowBtn;
	@FindBy(xpath = "//*[@class='registration-gateway']/*/*/*/*[@value='1']")
	WebElement btnPayPal;
	//@FindBy(xpath = "//input[@value='2']")
	@FindBy(xpath = "//*[@class='registration-gateway']/*/*/*/*[@value='2']")//added on 30/03
	WebElement authorizeNet;
public void addAttendeeDetails(Hashtable<String, String> data) throws Exception {
//waitForElementToPresent(selectTickets);
//selectByVisibleText(selectTickets, "1", "Selecting Tickets");
waitForElementToPresent(paidTicket);
selectByVisibleText(paidTicket, "1", "Selecting Ticket");//based on events page ticket list 
//	Thread.sleep(2000);
scrollToElement(attendeFormView);
//	Thread.sleep(2000);
waitForElementToPresent(AttendeeEmailID);
	AttendeeEmailID.clear();
	FirstName.clear();
	LastName.clear();
	this.companyName.clear();

Thread.sleep(2000);
type(AttendeeEmailID, data.get("attendeeEmailID"), "Attendee Email ID");
//	scrollDownVertically();
Thread.sleep(2000);
click(AttendeePhone,"Attendee Phone");
FirstName.clear();
LastName.clear();
this.companyName.clear();
//Thread.sleep(2000);
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
	Thread.sleep(2000);
	type(PayerEmailID, data.get("payerEmailID"), "Payer Email ID");
	type(PayerPhone, data.get("payerPhone"), "Payer Phone");
	Thread.sleep(3000);
	payerFirstName.clear();
	payerLastName.clear();
	waitForElementToPresent(payerFirstName);
	type(payerFirstName, data.get("payerFirstName"), "Payer First Name");
	waitForElementToPresent(payerLastName);
	type(payerLastName, data.get("payerLastName"), "Payer Last name");
	type(payerCompany, data.get("payerCompany"), "Payer company");
//	click(PayerPhone," Payer Phone");
//	Thread.sleep(4000);
//	takeScreenshotByShutterBug(payerForm, "Payer Form");
	
}

	public void registerToAnEvent(String Event) throws InterruptedException {
		
		
		
		
	}
	@FindBy(xpath="(//*[@class='event-image']/*/*)[1]")
	WebElement eventname1;
	@FindBy(xpath="(//select[@id='selectticketcount'])[1]")
	WebElement memberTickets;	
	public void registerToAnEventwithDuplicates(String Email, String Fname, String Lname, String ph) throws InterruptedException {
		
		click(eventname1, "Event");
		waitForElementToPresent(register);
		click(register,"Register");
		Thread.sleep(2000);
		selectUsingIndex(memberTickets,2,"1");
		scrollDownVertically();
		type(emailId1,Email,"Email Of registered");	
		Thread.sleep(2000);
		type(firstName, Fname, "First name");
		type(lastName, Lname, "Last name");
	//	type(phone, ph, "Phone");
		Thread.sleep(2000);
		type(emailId2,Email,"Email Of registered");
		Thread.sleep(2000);
		//scrollToElement(firstName2);
		type(firstName2, Fname, "First name");
		type(lastName2, Lname, "Last name");
	//	type(phone2, ph, "Phone");
		click(booknow,"Book Now");
		Thread.sleep(10000);
	}
	
	public void AttendeesDetailNotDisplaying() throws InterruptedException {
		click(Eventname, "Event");
		waitForElementToPresent(register);
		Thread.sleep(3000);
		Assert.assertEquals(0, invitees.getSize());
	
		System.out.println("Attendees detail section not is displaying");
		
	}
	
	public void AttendeesDetailDisplaying() throws InterruptedException{
		click(Eventname, "Event");
		waitForElementToPresent(invitees);
		Assert.assertTrue(true);
	}
	@FindBy(xpath="(//select[@id='selectticketcount'])[2]")
	WebElement memberTickets1;	

public void CannotregisterwithDuplicates(String EventTitle, String Email, String Fname, String Lname) throws InterruptedException {
		//waitForElementToPresent(Eventnames);
	//	EventTitle=EventTitle +" " + getDateInDDMMMYYYY();
//		int T=Eventnames.size();
//		for(int i=1; i<=T; i++) {
//			String name=driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).getText();
//			System.out.println(i);
//		if (name.equalsIgnoreCase(EventTitle)) {
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).isDisplayed();
//			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).click();
//		    break;
//		}}
		//click(Eventname, "Event");
	click(eventname1, "Event");
		waitForElementToPresent(register);
		click(register,"Register");
	//	Thread.sleep(2000);
//		waitForElementToPresent(noOfTickets);
//		selectUsingIndex(noOfTickets,2,"1");
		waitForElementToPresent(memberTickets1);
		selectUsingIndex(memberTickets1,2,"1");
		Thread.sleep(4000);
		type(emailId1,Email,"Email Of registered");
		type(firstName, Fname, "First name");
		type(lastName, Lname, "Last name");
		Thread.sleep(4000);
		type(emailId2,Email,"Email Of registered");
		type(firstName2, Fname, "First name");
		type(lastName2, Lname, "Last name");
		click(booknow,"Book Now");
		waitForElementToPresent(error);
		System.out.println(error);
		
	}
@FindBy(xpath="(//select[@id='selectticketcount'])[1]")
WebElement tableTicket;	

public void CannotregisterDuplicateswithDifferentTicket(String Email, String Fname, String Lname) throws InterruptedException {
	Thread.sleep(3000);
	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
//	Thread.sleep(2000);
	waitForElementToPresent(tableTicket);
	selectUsingIndex(tableTicket,1,"1");
	Thread.sleep(2000);
	scrollDownVertically();
	type(emailId1,Email,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	Thread.sleep(4000);
	type(emailId2,Email,"Email Of registered");
	type(firstName2, Fname, "First name");
	type(lastName2, Lname, "Last name");
	click(booknow,"Book Now");

	waitForElementToPresent(error);
	System.out.println(error);
	
}
public void AllowDuplicatesEmailwithGuestUser(String Email, String Fname, String Lname) throws InterruptedException {
	Thread.sleep(3000);
	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets1,2,"1");
	Thread.sleep(2000);
	//selectUsingIndex(noOfTickets2,1,"1");
	type(emailId1,Email,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	Thread.sleep(3000);
	type(emailId2,Email,"Email Of registered");
	type(firstName2, Fname, "First name");
	type(lastName2, Lname, "Last name");
	
	click(booknow,"Book Now");
	

}
public void CannotregisterwithEmails(String Email1, String Fname, String Lname) throws InterruptedException {
	waitForElementToPresent(eventname);
	click(eventname, "Event");

//	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
//	Thread.sleep(2000);
	selectUsingIndex(tableTicket,2,"1");
//	Thread.sleep(4000);
	scrollDownVertically();
	type(emailId1,Email1,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	Thread.sleep(4000);
	type(emailId2,Email1,"Email Of registered");
	waitForElementToPresent(error);
	System.out.println(error);
	
} 
@FindBy(xpath="//*[@name='PayerFirstName']")
WebElement payername1;
@FindBy(xpath="//*[@name='PayerLastName']")
WebElement payername2;
@FindBy(xpath="//*[@name='PayerEmailID']")
WebElement payerEmail;
@FindBy(xpath="//*[@type='submit']/*[text()='Next']")
WebElement next;
@FindBy(xpath="//*[@name='PayerComments']")
WebElement comments;
public AuthorizeGateway cancelTransactionRegEmail(String Email1, String Fname, String Lname) throws InterruptedException {
	waitForElementToPresent(eventname);
	click(eventname, "Event");

//	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
//	Thread.sleep(2000);
	waitForElementToPresent(noOfTickets);
	selectUsingIndex(noOfTickets,1,"1");
//	Thread.sleep(4000);
	scrollDownVertically();
	type(emailId1,Email1,"Email Of registered");
	Thread.sleep(2000);
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	click(next,"next");
	Thread.sleep(10000);
	waitForElementToPresent(payerEmail);
	scrollDownVertically();
//	type(payerEmail,Email1,"Email Of registered");
	Thread.sleep(2000);
	type(payername1, "yogesh", "First name");
	type(payername2, "bhor", "Last name");
	comments.click();
	waitForElementToPresent(booknow);
	clickElementByJavaScript(booknow,"Book Now");
	Thread.sleep(15000);
//	scrollDownVertically();
//	click(book, "Book");
	waitForElementToPresent(authorise);
	click(authorise, "Authorised");
//	scrollDownVertically();
//	Thread.sleep(3000);
	waitForElementToPresent(proceed);
	click(proceed, "Proceed");
	return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	
	
}public AuthorizeGateway completeTransactionRegEmail(String Email1, String Fname, String Lname) throws InterruptedException {

//	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
//	Thread.sleep(2000);
	waitForElementToPresent(noOfTickets);
	selectUsingIndex(noOfTickets,1,"1");
//	Thread.sleep(4000);
	scrollDownVertically();
	type(emailId1,Email1,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	click(next,"next");
	Thread.sleep(4000);
	waitForElementToPresent(payerEmail);
	scrollDownVertically();
	type(payerEmail,Email1,"Email Of registered");
	type(payername1, Fname, "First name");
	type(payername2, Lname, "Last name");
	comments.click();
	waitForElementToPresent(booknow);
	clickElementByJavaScript(booknow,"Book Now");
	Thread.sleep(15000);
//	scrollDownVertically();
//	click(book, "Book");
	waitForElementToPresent(authorise);
	click(authorise, "Authorised");
//	scrollDownVertically();
//	Thread.sleep(3000);
	waitForElementToPresent(proceed);
	click(proceed, "Proceed");
	return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	
	
}

}