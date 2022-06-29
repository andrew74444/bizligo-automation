package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class MyEventsPage extends BasePage{
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(myEvents);
		return ExpectedConditions.visibilityOf(myEvents);
	}
	@FindBy(xpath = "//h2[normalize-space()='My Events']")
	WebElement myEvents;
	@FindBy(xpath = "//div[@ng-hide='data.isEventsLoading']//div[@class='row']")
	//	@FindBy(xpath = "//*[@class='event-title']/*/*[@ng-bind='Event.EventName']")
	WebElement totalEvents;
	@FindBy(xpath = "//input[@id='eventDateRange']")
	WebElement searchByDate;
	@FindBy(xpath = "//input[@name='daterangepicker_start']")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@name='daterangepicker_end']")
	WebElement endDate;
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement apply;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//div[@ng-hide='data.isEventsLoading']//div[@class='row']")
	WebElement eventSearchByDate;
	
	
	public void registeredEventPresentInMyevents(String Event) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToPresent(totalEvents);
		if(totalEvents.getText().contains(Event)) {
			System.out.println("Registred event present on My Events page");
			Assert.assertTrue(true);
		}else {
			System.out.println("Registered Event not present on My Events Page");
			Assert.assertTrue(false);
		}
	}
	
    public void searchByEventDate(String StartDate,String EndDate,String Event) throws InterruptedException {
    	waitForElementToPresent(eventSearchByDate);
    	waitForElementToPresent(eventSearchByDate);
    	click(searchByDate,"Search By Date");
    	startDate.clear();
    	type(startDate,StartDate,"Start Date");//"08/07/2021"
    	endDate.clear();
    	type(endDate,EndDate,"End Date");//"09/30/2021"
    	click(apply,"Apply");
    	click(search,"Search");
    	Thread.sleep(3000);
    	System.out.println(Event);
    	waitForElementToPresent(eventSearchByDate);
    	if(eventSearchByDate.getText().contains(Event)) {
    		System.out.println("We can search events by date in My Events");
    	}else System.out.println("Events not visible if searched by date");
    	
    }


}
