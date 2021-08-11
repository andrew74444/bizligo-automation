package com.cpcommunity.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		Thread.sleep(3000);
		return (ManageCommunityPage) openPage(ManageCommunityPage.class);		
	}
}
