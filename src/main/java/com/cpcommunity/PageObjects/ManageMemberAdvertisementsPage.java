package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;



public class ManageMemberAdvertisementsPage extends BasePage {

	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}

	@FindBy(xpath = "//h2[contains(text(),'Manage Member Advertisements')]")
	WebElement manageMemberAdvertisements;

	@FindBy(xpath = "//*[@id='PlanNameSearch']")
	WebElement PlanNameSearch;

	@FindBy(xpath = "//*[@class='fa fa-plus']")
	WebElement createAd;

	@FindBy(xpath = "//*[@id='btnSearch']")
	WebElement btnSearch;

	// @FindBy(tagName = "")
	// WebElement PromotionPlanName;

	@FindBy(xpath = "//*[@id='PromotionPlanName']")
	WebElement duration;

	@FindBy(xpath = "//*[@id='DurationTypeID']")
	WebElement durationType;

	@FindBy(xpath = "//*[@id='AdLocation']")
	WebElement adLocation;

	@FindBy(xpath = "//*[@id='ViewType']")
	WebElement adType;

	@FindBy(xpath = "//*[@id='IsNotify']")
	WebElement isNotify;

	@FindBy(xpath = "//*[@id='btnSave']")
	WebElement btnSave;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement toaster;

	@FindBy(xpath = "//tbody/tr/td[10]")
	WebElement status;
	@FindBy(xpath = "//td[2]/*")
	WebElement action;
	@FindBy(xpath = "//*[@name='DisplayStartDate']")
	WebElement adStartDate;
	
	
	@FindBy(xpath = "//*[@name='DisplayEndDate']")
	WebElement adEndDate;

	@FindBy(xpath = "(//*[@class='datetimepicker-days'])[1]")
	WebElement  adStartDatecalendar;
	
	@FindBy(xpath = "(//*[@class='datetimepicker-days'])[2]")
	WebElement  adEndDatecalendar;
	
	@FindBy(xpath = "//*[contains(text(),'Approve')]")
	WebElement  approve;
	
	
	@FindBy(xpath = "//*[contains(text(),'Reject')]")
	WebElement  reject;
	

	

	
	
	@FindBy(xpath = "//*[@name='AdImage']")
	WebElement adImage;

	@FindBy(xpath = "//*[@name='LinkUrl']")
	WebElement linkUrl;
	
	
	@FindBy(xpath = "//*[@id='ApprovalStatusText']")
	WebElement planStatus;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Home Page");

		return ExpectedConditions.visibilityOf(manageMemberAdvertisements);
	}

	public void verifythedatasavedinDB() {
		String query = "SELECT TOP 10 ID,Name,Price,DurationValue,DurationTypeID,Adlocation,RequiresApproval,createddate,Createdby,isactive,Viewtype,Communityid FROM PromotionPlans ORDER BY ID desc";
	}

	public void rejectAd(String planName) throws Exception {
		this.searchAd(planName);
		click(action, "action");
		waitForElementToPresent(adStartDate);
//		selectStartAndEndDates();
		click(reject, "Reject");
		Thread.sleep(4000);
		picture();
		
	}
	
	public void approveAd(String planName,String adImage,String linkUrl) throws Exception {

		this.searchAd(planName);
		String s = status.getText();
		if (s.equalsIgnoreCase("WAITING FOR APPROVAL")) {
			click(action, "action");
			waitForElementToPresent(adStartDate);
			
			selectStartAndEndDates();
			
					
			type(this.adImage, adImage, "Ad Image");
			type(this.linkUrl, linkUrl, "Link Url");
			click(approve, "Approve");
			
			//Advertisement details saved.
		}

	}

	private void selectStartAndEndDates() throws Exception {
		click(this.adStartDate, "Ad Start Date");
		waitForElementToPresent(adStartDatecalendar);
		DateManager d = new DateManager(driver);
		String date = d.getCurrentDateString();
		d.selectDate("TableName",date);
		
		
		click(this.adEndDate, "Ad End Date");
		waitForElementToPresent(adEndDatecalendar);			
		String selectDate=String.valueOf(d.getCurrentDate()+1);
		d.selectDate("((//*[@class='datetimepicker-days'])[2])",selectDate);
	}

	
	public void searchAd(String planName) throws Exception {
		waitForElementToPresent(PlanNameSearch);
		type(PlanNameSearch, planName, "Plan Name Search");
		
		selectByVisibleText(planStatus, "WAITING FOR APPROVAL","planStatus");
		click(btnSearch, "Search");
		Thread.sleep(6000);
	}
	
	public void verifyPurchasedAdisDisplayed(String planName) throws Exception {
		this.searchAd(planName);
		AssertionHelper.verifyText(status.getText(), "WAITING FOR APPROVAL");		
		
		
	}

	

}
