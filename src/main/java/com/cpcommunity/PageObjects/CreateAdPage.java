package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAdPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(title);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//h4[normalize-space()='Create Ad']")
	WebElement title;
	
	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement Adtitle;
	
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement startDate;
	
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement choosefile;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	
	@FindBy(xpath = "//button[@class='btn btn-danger padding-space']")
	WebElement cancel;
	
	@FindBy(xpath = "//button[normalize-space()='Proceed to Payment']")
	WebElement prceedpayment;
	//td[normalize-space()='24']
	@FindBy(xpath = "//tbody//tr[2]//td[@class='day'][7]")
	WebElement dateselect;
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//div[@class='datetimepicker datetimepicker-dropdown-bottom-right dropdown-menu']")//
	WebElement  adStartDatecalendar;
	@FindBy(xpath = "//div[@class='datetimepicker-days']//th[@class='next']")
	WebElement nextMonth;
	
	
	public void createandsaveAd(String adtitle,  String path) throws InterruptedException{
		click(Adtitle, "Ad title");
		type(Adtitle, adtitle, ID);
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
		Thread.sleep(1000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		click(save, "Save");
		Thread.sleep(4000);
	}
	
	public void createAdandSave(String AdName) throws InterruptedException {
		waitForElementToPresent(Adtitle);
		AdName=AdName+getSystemCurrentMintues();
		type(Adtitle, AdName, "Advertisement name");
		Thread.sleep(1000);
		waitForElementToPresent(date);
		click(date, "Select Date");
		waitForElementToPresent(adStartDatecalendar);
	
		Thread.sleep(1000);
		click(nextMonth, "Next");
		click(nextMonth, "Next");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date");
	
		waitForElementToPresent(choosefile);
		String path1 = projectFloder("\\src\\test\\resources\\testImages\\Files\\ChromeImage3.jpeg");
		type(choosefile, path1, "Image Path");
	scrollDownVertically();
	waitForElementToPresent(save);
	click(save, "Save");
	Thread.sleep(15000);
		
	}
	
	
	
}
