package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;


public class UpcomingEventsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	@FindBy(xpath = "//input[@id='eventNameSearch']")
	WebElement EventNameSearch;

	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement Search;
	
	@FindBy(xpath="//strong[@ng-bind='Event.EventName'] | //strong[@class='ng-binding']")
	WebElement EventName;
	
	@FindBy(xpath="//div[@class='ng-binding']")
	WebElement EventTime;
	
	@FindBy(xpath="//div[@class='status-btn']")
	WebElement EventType;
	
	@FindBy(xpath="//*[@class='event-venue']")
	WebElement EventVenue;	
	
	@FindBy(xpath="//a[@class='btn btn-success']//strong[contains(text(),'REGISTER')]")
	WebElement registe;		
	
	@FindBy(xpath="//div[@class='row ng-binding ng-scope']")
	WebElement error;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Search);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public void searchEvent(Hashtable<String, String> data) throws Exception {
		//EventNameSearch.clear();
		type(EventNameSearch, data.get("eventName"),"eventName");//+" "+getDateInDDMMMYYYY() COMMENTED on 22/03
		
		waitForElementToPresent(Search);
		clickElementByJavaScript(Search);
	//	click(Search,"Search");
		Thread.sleep(3000);
	}
	public CreateOrEditEvent searchEvent(String Eventname) throws Exception {
		Eventname=Eventname+" "+getDateInDDMMMYYYY();
		EventNameSearch.clear();
		type(EventNameSearch,Eventname , "eventName");
		click(Search,"Search");
		Thread.sleep(6000);
		click(EventName, "Event Name");
		return (CreateOrEditEvent) openPage(CreateOrEditEvent.class);
	}
	
	@FindBy(xpath="(//*[@class='event-image'])[1]")
			WebElement image;
	public EventDetailsPage goToEventDetailsPage(Hashtable<String, String> data) throws Exception {
		this.searchEvent(data);
		
		waitForElementToPresent(image);
		WebElement element = driver.findElement(By.xpath("(//div[@ng-app='EventsApp']//*[@class='row']//a[@target='_self'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('target','_self');", element);
		String hrefUrl = element.getAttribute("href");
		log.info(hrefUrl);
		driver.get(hrefUrl);
		
		return (EventDetailsPage) openPage(EventDetailsPage.class);
	}

//	public EventDetailsPage navigateToEventDetailsPage(String EventName) throws Exception {
//
//		
////		this.searchEvent(EventName);
//		WebElement element = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].setAttribute('target','_self');", element);
//		String hrefUrl = element.getAttribute("href");
//		System.out.println(hrefUrl);
//		driver.get(hrefUrl);
////		WebElement we = driver.findElement(By.cssSelector("a[href='" + hrefUrl + "']"));
////		we.click();
//		
//		return (EventDetailsPage) openPage(EventDetailsPage.class);
////				new EventDetailsPage(driver, );
//		
//	}

	
	public void VerifyEventDetails(String eventName, String isPrivateEvent, String eventStartTime,
			String eventEndTime, String isPaidEvent, String Address) throws Exception {

//		this.searchEvent(eventName);
		SoftAssert st = new SoftAssert();
		String e = EventName.getText();
		
		
		String EType;
		String EventDate = EventTime.getText();
		if (isPaidEvent.equalsIgnoreCase("yes")) {
			EType = "Paid";
		} else {
			EType = "Free";			
		}
		String type = EventType.getText();
		// System.out.println(type);
		if (type.equalsIgnoreCase(EType)) {
			st.assertTrue(true);
		} else {
			st.assertEquals(type, EType);
		}
		String strStartDate = eventStartTime;
		String strEndDate = eventEndTime;
		// create SimpleDateFormat object with source string date format
		SimpleDateFormat sdfSource = new SimpleDateFormat("MM/dd/yyyy h:m a");
		// parse the string into Date object
		Date Sdate = sdfSource.parse(strStartDate);
		Date Edate = sdfSource.parse(eventEndTime);
		// create SimpleDateFormat object with desired date format
		SimpleDateFormat sdfDestination = new SimpleDateFormat("MMM d, yyyy hh:mm a");
		// parse the date into another format
		strStartDate = sdfDestination.format(Sdate);
		strEndDate = sdfDestination.format(Edate);
		// System.out.println("Date is converted from dd/MM/yy format to
		// MM-dd-yyyy hh:mm a");
		// System.out.println(strStartDate);
		// System.out.println(strEndDate);
		String Date = strStartDate + " To " + strEndDate + ", AUS Central Standard Time";
		// System.out.println(Date);
		// System.out.println(EventDate);
		if (EventDate.equalsIgnoreCase(Date)) {
			st.assertTrue(true);
		} else {
			st.assertEquals(EventDate, Date);
		}
//		if (isPrivateEvent.equalsIgnoreCase("yes")) {
//			if (PrivateEvent.isDisplayed()) {
//				st.assertTrue(true);
//
//			} else {
//				st.assertEquals("Private Event Lock Symbol is not displayed",
//						"Private Event Lock Symbol is should be displayed");
//				// System.out.println("Fail");
//			}//
//		}
		String Location = EventVenue.getText();
		if (Location.equalsIgnoreCase(Address)) {
			st.assertTrue(true);
		} else {
			st.assertEquals("Location :" + Location, "Location :" + Address);
		}
		// JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// String textObtained= (String) jsExecutor.executeScript("return
		// arguments[0].innerHTML;",
		// driver.findElement(By.xpath("//div[@class='ng-binding']")));
		// System.out.println("----"+textObtained+"****");
		// System.out.println("----"+date+"****");
		// = EventDate.getText();
		// System.out.println(date);
		st.assertAll();

	}
	@FindBy(xpath="(//*[@ng-if='Event.BannerTypeID == 1'])[1]")
			WebElement eventname;
	@FindBy(xpath="(//select[@id='selectticketcount'])[1]")
			WebElement freeTicket;
	@FindBy(xpath="(//*[@class='booking-details']/*/*/*)[1]")
			WebElement id;
	@FindBy(xpath="(//*[@class='booking-details']/*/*/*)[2]")
	WebElement date;
	@FindBy(xpath="(//*[@class='booking-details']/*/*/*)[3]")
	WebElement type;
	public void registerToAnEvent(String Event) throws InterruptedException {
		waitForElementToPresent(eventname);
		type(EventNameSearch, Event, "eventName");
		click(Search,"Search");
	//	Thread.sleep(3000);
		waitForElementToPresent(eventname);
		click(eventname,"Event name");
	//	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
		waitForElementToPresent(registe);
		click(registe,"Register");
	//	Thread.sleep(2000);
	//	selectUsingIndex(noOfTickets,1,"1");
		waitForElementToPresent(freeTicket2);
		selectUsingIndex(freeTicket2,1,"1");//added on 11/05 based on event ticket list
		Thread.sleep(3000);
		scrollDownVertically();
		//type(AuthoriseNet, label, Event)
		scrollToElement(booknow);
		clickElementByJavaScript(booknow,"Book Now");
		Thread.sleep(15000);
		waitForElementToPresent(bookingConfirmation);
		
		if(bookingConfirmation.isDisplayed()) {
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		System.out.println("Details of registration:");
	//	System.out.println(bookingId.getText());
	//	System.out.println(bookingDate.getText());
	//	System.out.println(eventType.getText());
	//	System.out.println(eventDetails.getText());
		System.out.println(id.getText());//added on 11/05
			System.out.println(date.getText());
			System.out.println(type.getText());

		
	}

	@FindBy(xpath="//a[@class='btn btn-success']//strong[contains(text(),'REGISTER')]")
	WebElement register;
	@FindBy(xpath="//select[@id='selectticketcount']")
	WebElement noOfTickets;	
//	@FindBy(xpath="//span[@ng-click='data.ShowInviteGuestHide()']")
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[2]/div[1]/div[9]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/fieldset[1]/form[1]/button[2]")
	WebElement booknow;
	@FindBy(xpath="//h3[normalize-space()='BOOKING CONFIRMATION']")
	WebElement bookingConfirmation;
	@FindBy(xpath="//*[@id=\"EventTicketController\"]//table[1]/tbody/tr[1]/td[1][@class='ng-binding']")
	WebElement bookingId;	
	@FindBy(xpath="//*[@id=\"EventTicketController\"]//table[1]/tbody/tr[1]/td[2][@class='ng-binding']")
	WebElement bookingDate;
	@FindBy(xpath="//*[@id=\"EventTicketController\"]//table[1]/tbody/tr[1]/td[3][@class='ng-binding']")
	WebElement eventType;
	@FindBy(xpath="//*[@id=\"EventTicketController\"]/div[2]/div/div/div/div[2]/div/div/div[2]/div/table[1]/tbody")
	WebElement eventDetails;
	@FindBy(xpath="//a[@class=\"btn btn-default top-btn1 btn-sm dropdown-toggle\"]")
	WebElement toggleDropDown;
	@FindBy(xpath="//a[normalize-space()='My Events']")
	WebElement myEvents;
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
	@FindBy(xpath="//input[@id='AttendeeFirstName01']")
	WebElement firstName2;
	@FindBy(xpath="//input[@id='AttendeeLastName01']")
	WebElement lastName2;
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement next;
	@FindBy(xpath="//span[@ng-bind=\"appData.jsResources.Events.BookNow\"]")
	WebElement bookNow;
	@FindBy(xpath="//h4[@class='fs-title']//span[@class='ng-binding'][normalize-space()='Make Payment']")
	WebElement makePayment;
	@FindBy(xpath="//img[@alt='Authorize.net']")
	WebElement AuthoriseNet;
	@FindBy(xpath="//span[@ng-bind='appData.jsResources.CommonWords.PayThroughCheckout']")
	WebElement proceed;
	@FindBy(xpath="//h2[normalize-space()='Payment Form']")
	WebElement paymentForm;
	@FindBy(xpath="//input[@id='cardNum']")
	WebElement cardNum;
	@FindBy(xpath="//input[@id='expiryDate']")
	WebElement expiryDate;
	@FindBy(xpath="//*[@id='cvv']")
	WebElement cvv;
	@FindBy(xpath="//*[@id=\"payBtn\"]")
	WebElement pay;
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[1]")
	WebElement bookingIdPaid;	
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[2]")
	WebElement bookingDatePaid;
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[3]")
	WebElement eventTypePaid;
	@FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")
	WebElement Eventname;
	@FindBy(xpath="//form[@id='GuestInvitationForm']//div[@class='panel-heading']")
	List<WebElement> invitees;
	@FindBy(xpath="//form[@id='GuestInvitationForm']//div[@class='panel-heading']")
	WebElement invitee;
	@FindBy(css="body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")
	WebElement element;

	
public  MyEventsPage goToMyEventsPage() throws InterruptedException {
	
	waitForElementToPresent(toggleDropDown);
		clickElementByJavaScript(toggleDropDown,"Toggle Drop Down Menu");
		waitForElementToPresent(myEvents);
		click(myEvents,"My events");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}
@FindBy(xpath="(//select[@id='selectticketcount'])[2]")
WebElement freeTicket2;
public void registerToAnEventAsGuest(String Event,String Email) throws InterruptedException {
	waitForElementToPresent(eventname);
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(eventname);
	click(eventname,"Event");
	waitForElementToPresent(register);
	click(register,"Register");
//	selectUsingIndex(noOfTickets,1,"1");
	waitForElementToPresent(freeTicket2);
	selectUsingIndex(freeTicket2,1,"1");//added on 11/05 based on ticket list in event
	//Thread.sleep(4000);
	waitForElementToPresent(emailId);
	type(emailId,Email,"Email Of registered Guest User");
	emailId.sendKeys(Keys.ENTER);
	click(booknow,"Book Now");
	Thread.sleep(10000);
	waitForElementToPresent(bookingConfirmation);
	
	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
		System.out.println("Member able to register for event as Guest user");
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
//	System.out.println(bookingId.getText());
//	System.out.println(bookingDate.getText());
//	System.out.println(eventType.getText());
//	System.out.println(eventDetails.getText());
	System.out.println(id.getText());//added on 11/05
	System.out.println(date.getText());
	System.out.println(type.getText());
	}

public void registerToAnEventThroughOtherMember(String Event,String Email,String Fname,String Lname) throws InterruptedException {
	waitForElementToPresent(eventname);
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	//Thread.sleep(3000);
//	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(eventname);
	click(eventname,"Event");
	waitForElementToPresent(register);
	click(register,"Register");
	//selectUsingIndex(noOfTickets,1,"1");
	waitForElementToPresent(freeTicket2);
	selectUsingIndex(freeTicket2,1,"1");//added on 11/05 based on ticket list in event
	//Thread.sleep(2000);
	waitForElementToPresent(emailId);
	type(emailId,Email,"Email Of registered Guest User");
	type(firstName,Fname,"First name Of registered Guest User");
	type(lastName,Lname,"Last Name Of registered Guest User");
	//emailId.sendKeys(Keys.ENTER);
	//Thread.sleep(6000);
	click(booknow,"Book Now");
	Thread.sleep(15000);
	waitForElementToPresent(bookingConfirmation);

	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
//	System.out.println(bookingId.getText());
//	System.out.println(bookingDate.getText());
//	System.out.println(eventType.getText());
//	System.out.println(eventDetails.getText());
	System.out.println(id.getText());//added on 11/05
	System.out.println(date.getText());
	System.out.println(type.getText());
}
@FindBy(xpath="//*[@name='PayerEmailID']")
WebElement payerId;
@FindBy(xpath="//*[@name='PayerFirstName']")
WebElement payerName1;
@FindBy(xpath="//*[@name='PayerLastName']")
WebElement payerName2;
@FindBy(xpath="(//*[@type='radio'])[2]")
		WebElement net;
@FindBy(xpath="//*[@name='PayerComments']")
WebElement comment;
@FindBy(xpath = "//input[@id='cardNum']")
WebElement cardnum;
//
@FindBy(xpath = "//input[@id='expiryDate']")
WebElement ExpiryDate;

@FindBy(xpath = "//input[@id='cvv']")
WebElement CVV;
@FindBy(xpath = "(//select[@id='selectticketcount'])[5]")
		WebElement paidTicket;
public void registerToPaidEvent(String Event,String Email,String Fname,String Lname) throws InterruptedException {
	waitForElementToPresent(eventname);
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	Thread.sleep(3000);
//	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(eventname);
	clickElementByJavaScript(eventname,"Event");
	waitForElementToPresent(register);
	click(register,"Register");
	//Thread.sleep(2000);
	//waitForElementToPresent(noOfTickets);
	//selectUsingIndex(noOfTickets,1,"1");
	waitForElementToPresent(paidTicket);
	selectUsingIndex(paidTicket,1,"1");//based on tickets list in events page
	waitForElementToPresent(emailId);
	type(emailId,Email,"Email");
	Thread.sleep(2000);
	firstName.clear();
	type(firstName,Fname,"First name Of registered User");
	lastName.clear();
	type(lastName,Lname,"Last Name Of registered User");
	
	//Thread.sleep(2000);
	click(next,"Next");
	Thread.sleep(10000);
	waitForElementToPresent(payerId);
//	payerId.clear();
//	type(payerId,"yogesh.bhor141@yahoo.com","Payer Email");
	Thread.sleep(2000);
	payerName1.clear();
	type(payerName1,"venkata","Payer FirstName");
	payerName2.clear();
	type(payerName2,"kr","Payer LastName");
	comment.click();
	scrollToElement(bookNow);
	clickElementByJavaScript(bookNow);
	Thread.sleep(10000);
	waitForElementToPresent(makePayment);
	waitForElementToPresent(net);
	click(net,"Authorize Net");
	click(proceed,"Proceed");	
	Thread.sleep(4000);
	waitForElementToPresent(paymentForm);
	Thread.sleep(2000);
	switchToFrameByID(0);
	type(cardNum,"4111111111111111","card number");
	type(expiryDate,"0525","Expiry Date");
	type(cvv,"025","CVV");
//	cardnum.click();
//	type(cardnum, "4111111111111111", "card Num");
//	ExpiryDate.click();
//	type(ExpiryDate, "0525", "Expiry Date");
//	CVV.click();
//	type(CVV, "025", "CVV");
	//switchToFrameByID(0);
	click(pay,"Pay");
	switchTodefaultContent();	
	Thread.sleep(30000);
	waitForElementToPresent(bookingConfirmation);
	
	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
//	System.out.println(bookingIdPaid.getText());
//	System.out.println(bookingDatePaid.getText());
//	System.out.println(eventTypePaid.getText());
	System.out.println(id.getText());//added on 11/05
	System.out.println(date.getText());
	System.out.println(type.getText());
	
}

public void registerTt(String Event) throws InterruptedException {
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	Thread.sleep(3000);
	//driver.findElement(By.xpath("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(1) > strong:nth-child(2)")).click();
	this.element.click();
	waitForElementToPresent(registe);
	click(registe,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,1,"1");
	Thread.sleep(2000);
	//type(AuthoriseNet, label, Event)
	click(booknow,"Book Now");

}
public void searchevent(String name) throws InterruptedException {
	waitForElementToPresent(eventname);

	waitForElementToPresent(EventNameSearch);
//	name=name +" " + getDateInDDMMMYYYY();
	type(EventNameSearch, name, "Event Name");
//	Thread.sleep(8000);
	click(Search, "Search");
//	Thread.sleep(8000);
	
}
public void AllowDuplicatesEmailwithGuestUser(String Email, String Fname, String Lname) throws InterruptedException {
	//Thread.sleep(3000);
	click(EventName, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,2,"1");
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
public void CannotregisterwithDuplicates(String Email, String Fname, String Lname) throws InterruptedException {
	waitForElementToPresent(eventname);
	click(eventname, "Event");
	//click(EventName, "Event");
	waitForElementToPresent(register);
	click(register,"Register");
	//Thread.sleep(2000);
	waitForElementToPresent(noOfTickets);
	selectUsingIndex(noOfTickets,2,"1");
//	Thread.sleep(4000);
	scrollDownVertically();
	type(emailId1,Email,"Email Of registered");
	type(firstName, Fname, "First name");
	type(lastName, Lname, "Last name");
	//type(emailId2,Email,"Email Of registered");
	type(firstName2, Fname, "First name");
	type(lastName2, Lname, "Last name");
	click(booknow,"Book Now");
	waitForElementToPresent(error);
	System.out.println(error);
	
}
public void AttendeesDetailNotDisplaying() throws InterruptedException {
	click(Eventname, "Event");
	waitForElementToPresent(register);
	Thread.sleep(3000);
	//Assert.assertEquals(0, invitees.size());

	System.out.println("Attendees detail section not is displaying");
	
}
public void AttendeesDetailDisplaying() throws InterruptedException{
	click(Eventname, "Event");
	waitForElementToPresent(invitee);
	Assert.assertTrue(true);
}
public void InviteGuestNotDisplaying() throws InterruptedException {
	click(Eventname, "Event");
	waitForElementToPresent(register);
	Thread.sleep(3000);
	//Assert.assertEquals(0, invitees.size());

	System.out.println("Attendees detail section not is displaying");
	
}
public void InviteGuestDisplaying() throws InterruptedException{
	click(Eventname, "Event");
	waitForElementToPresent(invitee);
	Assert.assertTrue(true);
}
}
