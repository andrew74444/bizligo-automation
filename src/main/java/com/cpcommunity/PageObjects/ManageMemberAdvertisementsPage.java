package com.cpcommunity.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	@FindBy(xpath = "//select[@id='ApprovalStatusText']")
	WebElement statusSearch;
	@FindBy(xpath = "//*[@class='fa fa-plus']")
	WebElement createAd;

	@FindBy(xpath = "//*[@id='btnSearch']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;

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
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement toaster;

	@FindBy(xpath = "//tbody/tr/td[10]")
	WebElement status;
	@FindBy(xpath = "//td[2]/*")
	WebElement action;
	@FindBy(xpath = "//input[@id='DisplayStartDate']")
	WebElement adStartDate;
	@FindBy(xpath = "//tbody//tr[2]//td[@class='day'][7]")
	WebElement dateselect;
	@FindBy(xpath = "//tbody//tr[3]//td[@class='day'][5]")
	WebElement changeDate;
	@FindBy(xpath = "//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[4]/td[6]")
	WebElement changeendDate;
	
	@FindBy(xpath = "//input[@id='DisplayStartDate']")
	WebElement date;
	@FindBy(xpath = "//*[@name='DisplayEndDate']")
	WebElement adEndDate;
	@FindBy(xpath = "//body/div[2]")
	WebElement  adStartDatecalendar;
	@FindBy(xpath = "//body/div[2]/div[3]/table[1]/thead[1]/tr[1]/th[3]")
	WebElement nextMonth;
	@FindBy(xpath = "//body/div[3]/div[3]/table[1]/thead[1]/tr[1]/th[3]")
	WebElement nextMonth1;
	@FindBy(xpath = "//body/div[3]")
	WebElement  adEndDatecalendar;
	
	@FindBy(xpath = "//button[@id='ApproveClick']")
	WebElement  approve;
	
	
	@FindBy(xpath = "//button[normalize-space()='Reject']")//*[contains(text(),'Reject')]
	WebElement  reject;
	
	//@FindBy(xpath = "//body[1]/div[2]/div[3]/table[1]/tbody[1]/tr[4]/td[2]")
	//WebElement  date;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]")
	WebElement  edit;
	
	@FindBy(xpath = "//body[1]/div[3]/div[3]/table[1]/tbody[1]/tr[4]/td[4]")
	WebElement  enddate;

	@FindBy(xpath = "//a[@title='Community Dashboard']")
	WebElement  communitydash;
	
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement adImage;

	@FindBy(xpath = "//input[@id='LinkUrl']")
	WebElement linkUrl;

	@FindBy(xpath = "//*[@id='ApprovalStatusText']")
	WebElement planStatus;
	@FindBy(xpath = "//tr[@class='even']//span[@class='label label-danger'][normalize-space()='REJECTED']")
	WebElement planStatusR;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Home Page");

		return ExpectedConditions.visibilityOf(manageMemberAdvertisements);
	}

	public void verifythedatasavedinDB() {
		String query = "SELECT TOP 10 ID,Name,Price,DurationValue,DurationTypeID,Adlocation,RequiresApproval,createddate,Createdby,isactive,Viewtype,Communityid FROM PromotionPlans ORDER BY ID desc";
	}

	public void rejectAd(String status) throws Exception {
		Thread.sleep(5000);
		waitForElementToPresent(statusSearch);
		selectByVisibleText(statusSearch, status, "waiting for approval");
		click(btnSearch, "Search");
		Thread.sleep(10000);
		
		click(action, "action");
		Thread.sleep(8000);
		//waitForElementToPresent(adStartDate);
//		selectStartAndEndDates();
		click(reject, "Reject");
		Thread.sleep(8000);
		picture();
		
	}
	public void RejectAd(String status) throws Exception {
		driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);
		selectByVisibleText(statusSearch, status, "waiting for approval");
		click(btnSearch, "Search");
		driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);
		Thread.sleep(9000);
		click(action, "action");
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		//waitForElementToPresent(adStartDate);
//		selectStartAndEndDates();
		click(reject, "Reject");
		//Thread.sleep(4000);
		picture();
		
	}
	
	public void approveAd (String planName,String AdImage,String LinkUrl) throws Exception {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		waitForElementToPresent(PlanNameSearch);
		//type(PlanNameSearch, planName, "Plan Name Search");
		selectUsingIndex(statusSearch, 1, "Status");
		click(btnSearch, "Search");
		Thread.sleep(18000);
		//String s = status.getText();
		
			click(edit, "action");
			//click(date, "Select Date");
			//waitForElementToPresent(adStartDatecalendar);
			//Thread.sleep(1000);
			//click(nextMonth, "Next");
			//click(nextMonth, "Next");
			//waitForElementToPresent(dateselect);
			//click(dateselect, "Date");
			Thread.sleep(2000);
		    scrollDownVertically();
			
			//waitForElementToPresent(adImage);
			//type(this.adImage, AdImage, "Ad Image");
			//type(this.linkUrl, LinkUrl, "Link Url");
			click(approve, "Approve");
			
		}
			//Advertisement details saved.
		
	
		
	public void changeDateAd(String planName,String adImage,String linkUrl) throws Exception {
       Thread.sleep(2000);
		waitForElementToPresent(PlanNameSearch);
		//type(PlanNameSearch, planName, "Plan Name Search");
		selectUsingIndex(statusSearch, 2, linkUrl);
		Thread.sleep(5000);
		click(btnSearch, "Search");
		Thread.sleep(8000);
		click(action, "action");
		Thread.sleep(7000);
			click(date, "Select Date");
			waitForElementToPresent(adStartDatecalendar);
			Thread.sleep(1000);
			click(nextMonth, "Next");
			click(nextMonth, "Next");
			waitForElementToPresent(changeDate);
			click(changeDate, "Date");
			click(adEndDate, "Select Date");
			waitForElementToPresent(adEndDatecalendar);
			Thread.sleep(1000);
			waitForElementToPresent(changeendDate);
			click(changeendDate, "Date");
			
			Thread.sleep(2000);
			click(btnSave, "Save");
			
			//Advertisement details saved.
		
	}
		public void approveRejectedAd(String planName,String adImage,String linkUrl,String status) throws Exception {
            Thread.sleep(3000);
			waitForElementToPresent(planStatus);
			selectUsingIndex(planStatus, 1,"planStatus");
			click(btnSearch, "Search");
			Thread.sleep(12000);
				click(action, "action");
				//waitForElementToPresent(adStartDate);
				
				//selectStartAndEndDates();
			    scrollDownVertically();
				//type(this.adImage, adImage, "Ad Image");
				//type(this.linkUrl, linkUrl, "Link Url");
				click(approve, "Approve");
				
				//Advertisement details saved.
	

	}

	private void selectStartAndEndDates() throws Exception {
		click(this.adStartDate, "Ad Start Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(1000);
		click(date, "Date");
		DateManager d = new DateManager(driver);
		String date = d.getCurrentDateString();
	    d.selectDate("TableName",date);
		Thread.sleep(1000);
		
		click(this.adEndDate, "Ad End Date");
		waitForElementToPresent(adEndDatecalendar);
		Thread.sleep(1000);
		click(enddate, "EndDate");
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

	public CommunityDashboardPage gotoCommunityDashboard() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		scrollUpVertically();
		waitForElementToPresent(dashboardreport);
		click(dashboardreport, "Dashboard Reports");
		waitForElementToPresent(communitydash);
		click(communitydash, "Community DashBoard");
		Thread.sleep(6000);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}

}
