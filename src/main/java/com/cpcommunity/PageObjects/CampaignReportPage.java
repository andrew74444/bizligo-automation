package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class CampaignReportPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(panelTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement SuccessPopup;
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//input[@id='EmailCampaignSearch']")
	WebElement SearchbyCampaign;
	@FindBy(xpath = "//h2[normalize-space()='CAMPAIGN REPORT']")
	WebElement panelTitle;
	@FindBy(xpath = "//input[@id='EmailSubjectSearch']")
	WebElement searchbySubject;
	@FindBy(xpath = "//input[@id='ToEmailSearch']")
	WebElement searchbyToEmail;
	@FindBy(xpath = "//input[@id='ScheduledAtSearch']")
	WebElement SearchbySentAt;
	@FindBy(xpath = "//select[@id='SentStatusSearch']")
	WebElement selectEmailStatus;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement reset;
	@FindBy(xpath = "//button[@id='34021']")
	WebElement viewDetail;
	@FindBy(xpath = "//td[@ng-bind='maininfo.CampaignName']")
	List<WebElement> CampaignName;
	@FindBy(xpath = "//td[@ng-bind='maininfo.ToEmail']")
	List<WebElement> Emails;
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")
	WebElement DateBlock;
	@FindBy(xpath = "//td[@class='day old'][normalize-space()='30']")
	WebElement date;
	@FindBy(xpath = "//div[@class='datetimepicker-days']//table//tfoot//tr[2]//th[@class='clear']")
	WebElement clear;
	@FindBy(xpath = "//h4[normalize-space()='Email Detail View']")
	WebElement EmaildetailVeiw;
	
	public void CheckSendMail(String Campaign,String Status, String Subject, String Email) throws InterruptedException {
		waitForElementToPresent(SearchbyCampaign);
		type(SearchbyCampaign, Campaign, "Campaign");
		waitForElementToPresent(search);
		click(search, "Search");
		this.SearchbyCampaign.clear();
		Thread.sleep(5000);
		waitForElementToPresent(SearchbySentAt);
		click(SearchbySentAt, "Sentdate");
		waitForElementToPresent(DateBlock);
		waitForElementToPresent(date);
		click(date, "Date30");
		waitForElementToPresent(search);
		click(search, "Search");
		Thread.sleep(7000);
		waitForElementToPresent(SearchbySentAt);
		click(SearchbySentAt, "Sentdate");
		waitForElementToPresent(clear);
		click(clear, "Clear");
		Thread.sleep(7000);
		waitForElementToPresent(selectEmailStatus);
		//selectUsingIndex(selectEmailStatus, 2, "Sent");
		selectByVisibleText(selectEmailStatus,Status, "Email");
		waitForElementToPresent(search);
		click(search, "Search");
		selectUsingIndex(selectEmailStatus, 0, "Sent");
		Thread.sleep(7000);
		waitForElementToPresent(searchbySubject);
		type(searchbySubject, Subject, "Subject");
		waitForElementToPresent(search);
		click(search, "Search");
		this.searchbySubject.clear();
		Thread.sleep(8000);
		waitForElementToPresent(searchbyToEmail);
		type(searchbyToEmail, Email, "Email");
		click(search, "Search");
		//this.searchbyToEmail.clear();
		Thread.sleep(8000);
		waitForElementToPresent(viewDetail);
		click(viewDetail, "ViewDetails");
		AssertionHelper.verifyText(SuccessPopup.getText(), "Mails History Loaded");
		
					}
		
}
