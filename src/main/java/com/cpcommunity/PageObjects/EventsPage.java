package com.cpcommunity.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	@FindBy(xpath="//button[@ng-disabled='data.isAutofillIsLoading']")
	WebElement booknow;
	@FindBy(xpath="//h3[normalize-space()='BOOKING CONFIRMATION']")
	WebElement bookingConfirmation;
	@FindBy(xpath="//input[@type=\"email\" and @name=\"EmailID[]\"]")
	WebElement emailId;
	@FindBy(xpath="(//input[@placeholder='Email Address'])[1]")
	WebElement emailId1;
	@FindBy(xpath="(//input[@placeholder='Email Address'])[2]")
	WebElement emailId2;
	@FindBy(xpath="//input[@id='AttendeeFirstName00']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='AttendeeLastName00']")
	WebElement lastName;
	@FindBy(xpath="//input[@id='AttendeePhone00']")
	WebElement phone;
	@FindBy(xpath="//input[@id='AttendeePhone01']")
	WebElement phone2;
	@FindBy(xpath="//input[@id='AttendeeFirstName01']")
	WebElement firstName2;
	@FindBy(xpath="//input[@id='AttendeeLastName01']")
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
	
	public void searchevent(String name) throws InterruptedException {
		waitForElementToPresent(searchEvents);
		name=name +" " + getDateInDDMMMYYYY();
		type(searchEvents, name, "Event Name");
		Thread.sleep(8000);
		click(search, "Search");
		Thread.sleep(8000);
		
	}
	
	public void registerToAnEvent(String Event) throws InterruptedException {
		
		
		
		
	}
	public void registerToAnEventwithDuplicates(String Email, String Fname, String Lname, String ph) throws InterruptedException {
		
		click(Eventname, "Event");
		waitForElementToPresent(register);
		click(register,"Register");
		Thread.sleep(2000);
		selectUsingIndex(noOfTickets,2,"1");
		Thread.sleep(2000);
		type(emailId1,Email,"Email Of registered");	
		type(firstName, Fname, "First name");
		type(lastName, Lname, "Last name");
		type(phone, ph, "Phone");
		Thread.sleep(2000);
		type(emailId2,Email,"Email Of registered");
		
		//scrollToElement(firstName2);
		type(firstName2, Fname, "First name");
		type(lastName2, Lname, "Last name");
		type(phone2, ph, "Phone");
		click(booknow,"Book Now");
		
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
	
public void CannotregisterwithDuplicates(String EventTitle, String Email, String Fname, String Lname) throws InterruptedException {
		//waitForElementToPresent(Eventnames);
		EventTitle=EventTitle +" " + getDateInDDMMMYYYY();
		int T=Eventnames.size();
		for(int i=1; i<=T; i++) {
			String name=driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).getText();
			System.out.println(i);
		if (name.equalsIgnoreCase(EventTitle)) {
			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).isDisplayed();
			driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(" + i + ") > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).click();
		    break;
		}}
		//click(Eventname, "Event");
		waitForElementToPresent(register);
		click(register,"Register");
		Thread.sleep(2000);
		selectUsingIndex(noOfTickets,2,"1");
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
public void CannotregisterDuplicateswithDifferentTicket(String Email, String Fname, String Lname) throws InterruptedException {
	Thread.sleep(3000);
	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,2,"1");
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
	
	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,2,"1");
	Thread.sleep(4000);
	type(emailId1,Email1,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	Thread.sleep(4000);
	type(emailId2,Email1,"Email Of registered");
	waitForElementToPresent(error);
	System.out.println(error);
	
} 
public AuthorizeGateway cancelTransactionRegEmail(String Email1, String Fname, String Lname) throws InterruptedException {
	
	click(Eventname, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,1,"1");
	Thread.sleep(4000);
	type(emailId1,Email1,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	Thread.sleep(4000);
	click(booknow,"Book Now");
	Thread.sleep(3000);
	scrollDownVertically();
	click(book, "Book");
	waitForElementToPresent(authorise);
	click(authorise, "Authorised");
	scrollDownVertically();
	Thread.sleep(3000);
	click(proceed, "Proceed");
	return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	
	
}

}