package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class CommunityEventsPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		aShot();
	}

	@FindBy(xpath = "//a[contains(.,' New')]")
	WebElement New;
	@FindBy(xpath = "(//*[@class=' select-checkbox'])[1]")
	WebElement firstEventRowCheckBox;
	@FindBy(xpath = "//*/tbody/tr[1]/td[4]")
	WebElement FirstEventTitleName;
	@FindBy(xpath = "//a[normalize-space()='Testing Event 1']")
	WebElement searchEventName;
	@FindBy(xpath = "//a[normalize-space()='TestingToday']")
	WebElement searchEventName1;
	@FindBy(xpath = "//*/tbody/tr[2]")
	WebElement SecondRow;
	@FindBy(xpath = "//*/tbody/tr[2]/td[4]")
	WebElement CopiedEvent;
	@FindBy(xpath = "//i[@class='fa fa-copy']")
	WebElement CopyBtn;
	@FindBy(xpath = "//button[contains(.,' Yes, Proceed')]")
	WebElement YesProceedbtn;
	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement Okbtn;
	@FindBy(xpath = "//*[@id='EventNameSearch']")
	WebElement EventNameSearch;
	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement btnSearch;
	@FindBy(xpath = "//*/tbody/tr[1]/td[4]/i")
	WebElement EditEvent;
	@FindBy(xpath="//*[@id='btnCheckinEvent']")
	WebElement btnCheckinEvent;
	@FindBy(xpath = "//a[normalize-space()='Book Tickets']")
	WebElement bookTicket;	
	@FindBy(xpath = "//select[@id='selectticketcount']")
	WebElement selectticketcount;
	@FindBy(xpath="//input[@id='AttendeeLastName00']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='AttendeeFirstName00']")
	WebElement firstname;	
	@FindBy(css = "input[placeholder='Email Address'][name='EmailID[]']")
	WebElement emailId;
	@FindBy(xpath = "//h4[normalize-space()='Event Attendees']")
	WebElement eventAtttendee;
	@FindBy(xpath = "//a[normalize-space()='aexibition']")
	WebElement eventname;
	@FindBy(xpath = "//button[@class='btn btn-primary'][normalize-space()='Save & Continue']")
	WebElement saveandContinue;
	@FindBy(xpath = "//button[@ng-click='PublishChanges=false;SubmitTicketDetails(true)']")
	WebElement TicketsSaveAndContinueBtn;
	@FindBy(xpath = "//*[@id='AdditionalInformationForm']/div[4]/div[2]/div/button[1]")
	WebElement AddtionalinfomationSaveAndContinueBtn;
	
	public CreateOrEditEvent searchEventName(String eventname) throws InterruptedException {
		waitForElementToPresent(EventNameSearch);
		type(EventNameSearch, eventname, "Event Name");
		click(btnSearch, "Search");
		Thread.sleep(4000);
		waitForElementToPresent(searchEventName);
		click(searchEventName, "Eventname");
		return (CreateOrEditEvent) openPage(CreateOrEditEvent.class);
		
	}
	public CreateOrEditEvent searchEventName1(String eventname) throws InterruptedException {
		waitForElementToPresent(EventNameSearch);
		type(EventNameSearch, eventname, "Event Name");
		click(btnSearch, "Search");
		Thread.sleep(4000);
		waitForElementToPresent(searchEventName1);
		click(searchEventName1, "Eventname");
		return (CreateOrEditEvent) openPage(CreateOrEditEvent.class);
		
	}
	

	public CreateOrEditEvent NewEvent() throws InterruptedException {

		click(New, "New button");
		Thread.sleep(4000);
		return (CreateOrEditEvent) openPage(CreateOrEditEvent.class);
		// new CreateOrEditEvent(driver);
	}

	public CreateOrEditEvent clickonEvent(String eventTitleName) {
		click(EditEvent, eventTitleName);
		return (CreateOrEditEvent) openPage(CreateOrEditEvent.class);
		// new CreateOrEditEvent(driver);
	}

	public void CopyEvent(String eventTitleName) throws Exception {
		this.SearchEvent(eventTitleName);
		click(firstEventRowCheckBox, "First Event Row CheckBox");
		click(CopyBtn, "Copy Button");
		click(YesProceedbtn, "YesProceed");
		waitForElementToPresent(Okbtn);
		click(Okbtn, "Ok button");
		Thread.sleep(3000);
		// System.out.println(CopiedEvent.getText());
		// Utility.Alert(driver, "Title of the copied event is "+CopiedEvent.getText());
		AssertionHelper.verifyText(CopiedEvent.getText(), " Copy Of " + eventTitleName);

	}
	
	@FindBy(xpath="//select[@id='EventStatusSearch']")
	WebElement EventStatusSearch;
	public void SearchEvent(String eventTitleName) throws Exception {

		type(EventNameSearch, eventTitleName, "Event Name Search");
		selectByVisibleText(EventStatusSearch, "Published", "Published");
		click(btnSearch, "button Search");
		Thread.sleep(6000);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub

		return ExpectedConditions.visibilityOf(New);
	}
	public void SearchEventbyname(String eventTitleName) throws Exception {

		type(EventNameSearch, eventTitleName, "Event Name Search");
		click(btnSearch, "button Search");
		Thread.sleep(6000);
		waitForElementToPresent(eventname);
		click(eventname, "axibition");
		
		
	}
	 public void checkcustomfield() throws InterruptedException {
		   Thread.sleep(10000);
		  // scrollToElementAndClick(saveandContinue);
		   scrollToElement(saveandContinue);
		   clickElementByJavaScript(saveandContinue);
		   driver.manage().timeouts().implicitlyWait(20,TimeUnit.MINUTES);
		   clickElementByJavaScript(TicketsSaveAndContinueBtn);
			//click(TicketsSaveAndContinueBtn, "Tickets Save And ContinueBtn");
			Thread.sleep(10000);
			clickElementByJavaScript(AddtionalinfomationSaveAndContinueBtn);
		   
		   System.out.println("Custom field not editable");
		   
	   }
	public CheckInPage checkIn(Hashtable<String, String> data) throws Exception {
		this.SearchEvent(data.get("eventName")+" "+getDateInDDMMMYYYY());
		click(firstEventRowCheckBox,"firstEventRowCheckBox");
		Thread.sleep(1000);
		click(btnCheckinEvent, "Checkin Event");		
		return (CheckInPage) openPage(CheckInPage.class);
	}
	public void gotoCheckin(String eventname, String email1, String NameF, String NameL) throws Exception {
		this.SearchEvent(eventname+" "+getDateInDDMMMYYYY());

		Thread.sleep(2000);
		click(firstEventRowCheckBox,"firstEventRowCheckBox");
		Thread.sleep(1000);
		click(btnCheckinEvent, "Checkin Event");	
		 waitForElementToPresent(bookTicket);
		   click(bookTicket, "Book Ticket");
		  Thread.sleep(5000);
		   selectUsingIndex(selectticketcount, 1, "Selct Ticket");
		  Thread.sleep(1000);
		
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0,500)", "");
	
		 waitForElementToPresent(emailId);
		 type(emailId, email1, "Event nme");
          Thread.sleep(2000);
		 type(firstname, NameF, "Name");
		 Thread.sleep(2000);
		 type(lastname, NameL, "Name");
		 
		   
		
	}
	
	public void bookTicket() {
		waitForElementToPresent(bookTicket);
		click(bookTicket, "Book ticket");
	}
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
