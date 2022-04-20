package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class EventTicketPage extends BasePage {

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");

		aShot();

	}

	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed')]")
	WebElement ticketsProcessed;
	@FindBy(xpath = "//*[@class='panel panel-default']//*[contains(text(),'Success')]")
	WebElement success;
	@FindBy(xpath = "//*[contains(text(),'Your tickets have processed.. You will receive an email with the details to join the online meeting')]")
	WebElement onlineEventRegistrationSuccess;
	@FindBy(xpath = "//*[@class='panel panel-default']")
	WebElement bookingSummary;
	@FindBy(xpath = "//*[@class='col-md-6 pull-left']/*")
	WebElement booking;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(booking);//success
	}

	public void successfulRegistration() throws Exception {

		waitForElementToPresent(ticketsProcessed);
		
		Thread.sleep(3000);
		AssertionHelper.verifyText(ticketsProcessed.getText(),
		
		"Your tickets have processed. You will receive an email with the details.");
		// "Your tickets have processed"
		// Your tickets have processed.. You will receive an email with the details to
		// join the online meeting.

	}

	public void onlineEventsuccessfulRegistration() {
		onlineEventRegistrationSuccess.isDisplayed();
		takeScreenshotByShutterBug(bookingSummary, "online Event Registration Booking Summary");
	}

}
