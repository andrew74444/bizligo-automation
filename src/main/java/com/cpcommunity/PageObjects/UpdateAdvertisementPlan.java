package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class UpdateAdvertisementPlan extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pagetitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	@FindBy(xpath = "//nav[@class='navbar navbar-inverse']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Update Advertisement Plan']")
	WebElement pagetitle;
	@FindBy(xpath = "//*[@id='DurationTypeID']")
	WebElement durationType;
	@FindBy(xpath = "//*[@id='AdLocation']")
	WebElement adLocation;
	@FindBy(xpath = "//*[@id='ViewType']")
	WebElement adType;
	@FindBy(xpath = "//*[@for='chkRequiresApproval']")
	WebElement chkRequiresApproval;
	@FindBy(xpath="//button[@id='btnSave']")
	WebElement save;
	
	public ManageAdPlansPage checkDisableElements() throws InterruptedException {
		  
		   return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
		
	}
	
}
