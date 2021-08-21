package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class UpdateADPage  extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pagetitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}

	@FindBy(xpath = "//nav[@class='navbar navbar-inverse']")
	WebElement pageheader;
	@FindBy(xpath = "//h4[normalize-space()='Update Ad']")
	WebElement pagetitle;
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement adname;
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement planname;
	@FindBy(xpath = "//tbody//tr[2]//td[@class='day'][7]")
	WebElement dateselect;
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement choosefile;
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")
	WebElement adStartDatecalendar;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//div[@class='datetimepicker-days']//th[@class='next']")
	WebElement nextMonth;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastemessage;
	@FindBy(xpath = "//*[@id='DurationTypeID']")
	WebElement durationType;
	@FindBy(xpath = "//*[@id='AdLocation']")
	WebElement adLocation;
	@FindBy(xpath = "//*[@id='ViewType']")
	WebElement adType;
	@FindBy(xpath = "//*[@for='chkRequiresApproval']")
	WebElement chkRequiresApproval;

	public void editPaymentpendingAD(String AdName, String  path) throws InterruptedException {
		
	waitForElementToPresent(planname);
		type(planname, AdName, "Name");
		scrollDownVertically();
		click(save, "Save");
		//waitForElementToPresent(toastemessage);
		//AssertionHelper.verifyText(toastemessage.getText(), "Advertisement details saved.");
		Thread.sleep(2000);
		
	}
	
}


