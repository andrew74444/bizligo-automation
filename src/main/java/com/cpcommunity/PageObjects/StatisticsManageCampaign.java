package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class StatisticsManageCampaign extends BasePage{
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement pageheader;
	@FindBy(xpath = "//h3[normalize-space()='Statistics']")
	WebElement statistics;
	
	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(statistics);
	}
     
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//p[normalize-space()='Sent Campaign']")
	WebElement sentCampaign;
	
	@FindBy(id="EmailsSentCount")
	WebElement numberOfSentCampaign;
	
	@FindBy(xpath="//th[@aria-label='S.No']")
	WebElement serialNo;
	
	@FindBy(xpath="//*[contains(@class,'sorting')and contains(text(),'From Email')]")
	WebElement fromEmail;
	
	@FindBy(xpath="//*[contains(@class,'sorting')and contains(text(),'To Email')]")
	WebElement toEmail;
	
	@FindBy(xpath="//*[contains(@class,'sorting')and contains(text(),'Campaign Name')]")
	WebElement campaignName;
	
	@FindBy(xpath="//*[contains(@class,'sorting')and contains(text(),'Email Subject')]")
	WebElement emailSubject;
	
	public void statisticsReport() throws InterruptedException {
		waitForElementToPresent(submitBtn);
		click(submitBtn,"submit");
		waitForElementToPresent(sentCampaign);
		Thread.sleep(2000);
		String x=numberOfSentCampaign.getText();
		System.out.println("The number of emails sent= "+ x);
		click(sentCampaign,"Emails sent");
		//waitForElementToPresent(serialNo);//&& toEmail.isDisplayed()&& campaignName.isDisplayed()&& emailSubject.isDisplayed()
		Thread.sleep(4000);
		if(serialNo.isDisplayed() ) {
			System.out.println("All the required fields of email statistics are displayed1");
		}
		if(fromEmail.isDisplayed() ) {
			System.out.println("All the required fields of email statistics are displayed2");
		}
		if(toEmail.isDisplayed() ) {
			System.out.println("All the required fields of email statistics are displayed3");
		}
		if(serialNo.isDisplayed()&& fromEmail.isDisplayed()&& toEmail.isDisplayed() ) {
			System.out.println("All the required fields of email statistics are displayed");
			Assert.assertTrue(true);
		}else {
			System.out.println("All the required fields are not displayed");
			Assert.assertTrue(false);
		}
	}
}
