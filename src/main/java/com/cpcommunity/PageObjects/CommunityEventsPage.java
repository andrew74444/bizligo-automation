package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;

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
	
	
	

	public CreateOrEditEvent NewEvent() {

		click(New, "New button");
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

	public CheckInPage checkIn(Hashtable<String, String> data) throws Exception {
		this.SearchEvent(data.get("eventName")+" "+date());
		click(firstEventRowCheckBox,"firstEventRowCheckBox");
		Thread.sleep(1000);
		click(btnCheckinEvent, "Checkin Event");		
		return (CheckInPage) openPage(CheckInPage.class);
	}
	
	
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
