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
		EventNameSearch.clear();
		type(EventNameSearch, data.get("eventName")+" "+getDateInDDMMMYYYY(), "eventName");
		click(Search,"Search");
		Thread.sleep(5000);
	}
	
	
	public EventDetailsPage goToEventDetailsPage(Hashtable<String, String> data) throws Exception {
		this.searchEvent(data);
		
		
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
	public void registerToAnEvent(String Event) throws InterruptedException {
		type(EventNameSearch, Event, "eventName");
		click(Search,"Search");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
		waitForElementToPresent(register);
		click(register,"Register");
		Thread.sleep(2000);
		selectUsingIndex(noOfTickets,1,"1");
		Thread.sleep(2000);
		click(booknow,"Book Now");
		waitForElementToPresent(bookingConfirmation);
		Thread.sleep(4000);
		if(bookingConfirmation.isDisplayed()) {
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		System.out.println("Details of registration:");
		System.out.println(bookingId.getText());
		System.out.println(bookingDate.getText());
		System.out.println(eventType.getText());
		System.out.println(eventDetails.getText());
		
	}

	@FindBy(xpath="//a[@class='btn btn-success']//strong[contains(text(),'REGISTER')]")
	WebElement register;
	@FindBy(xpath="//select[@id='selectticketcount']")
	WebElement noOfTickets;	
	@FindBy(xpath="//span[@ng-click='data.ShowInviteGuestHide()']")
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
	@FindBy(xpath="//input[@id='AttendeeFirstName00']")
	WebElement firstName;
	@FindBy(xpath="//input[@id='AttendeeLastName00']")
	WebElement lastName;
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
	@FindBy(xpath="//*[@id=\"payBtn\"]")
	WebElement pay;
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[1]")
	WebElement bookingIdPaid;	
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[2]")
	WebElement bookingDatePaid;
	@FindBy(xpath="//*[@id=\"PaymentController\"]//table[1]/tbody/tr[1]/td[3]")
	WebElement eventTypePaid;




	
public  MyEventsPage goToMyEventsPage() {
		
		click(toggleDropDown,"Toggle Drop Down Menu");
		click(myEvents,"My events");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}
public void registerToAnEventAsGuest(String Event,String Email) throws InterruptedException {
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(register);
	click(register,"Register");
	selectUsingIndex(noOfTickets,1,"1");
	Thread.sleep(4000);
	type(emailId,Email,"Email Of registered Guest User");
	emailId.sendKeys(Keys.ENTER);
	click(booknow,"Book Now");
	waitForElementToPresent(bookingConfirmation);
	Thread.sleep(4000);
	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
		System.out.println("Member able to register for event as Guest user");
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
	System.out.println(bookingId.getText());
	System.out.println(bookingDate.getText());
	System.out.println(eventType.getText());
	System.out.println(eventDetails.getText());
	
}
public void registerToAnEventThroughOtherMember(String Event,String Email,String Fname,String Lname) throws InterruptedException {
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(register);
	click(register,"Register");
	selectUsingIndex(noOfTickets,1,"1");
	Thread.sleep(2000);
	type(emailId,Email,"Email Of registered Guest User");
	type(firstName,Fname,"First name Of registered Guest User");
	type(lastName,Lname,"Last Name Of registered Guest User");
	//emailId.sendKeys(Keys.ENTER);
	//Thread.sleep(6000);
	click(booknow,"Book Now");
	Thread.sleep(8000);
	waitForElementToPresent(bookingConfirmation);
	Thread.sleep(3000);
	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
	System.out.println(bookingId.getText());
	System.out.println(bookingDate.getText());
	System.out.println(eventType.getText());
	System.out.println(eventDetails.getText());
	
}
public void registerToPaidEvent(String Event) throws InterruptedException {
	type(EventNameSearch, Event, "eventName");
	click(Search,"Search");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//strong[contains(text(),'" + Event + "')]")).click();
	waitForElementToPresent(register);
	click(register,"Register");
	Thread.sleep(2000);
	selectUsingIndex(noOfTickets,1,"1");
	Thread.sleep(2000);
	click(next,"Next");
	Thread.sleep(4000);
	clickElementByJavaScript(bookNow);
	Thread.sleep(2000);
	waitForElementToPresent(makePayment);
	
	click(AuthoriseNet,"Authorize Net");
	click(proceed,"Proceed");		
	Thread.sleep(4000);
	waitForElementToPresent(paymentForm);
	Thread.sleep(2000);
	switchToFrameByID(0);
	type(cardNum,"4111111111111111","card number");
	type(expiryDate,"02/333","Expiry Date");
	//switchToFrameByID(0);
	click(pay,"Pay");
	switchTodefaultContent();		
	waitForElementToPresent(bookingConfirmation);
	Thread.sleep(3000);
	if(bookingConfirmation.isDisplayed()) {
		Assert.assertTrue(true);
	}else Assert.assertTrue(false);
	System.out.println("Details of registration:");
	System.out.println(bookingIdPaid.getText());
	System.out.println(bookingDatePaid.getText());
	System.out.println(eventTypePaid.getText());
	
}





	
	
}
