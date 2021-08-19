package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class ResourcesPage  extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
			return ExpectedConditions.visibilityOf(panelTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		//updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//strong[normalize-space()='Resources']")
	WebElement panelTitle;
	@FindBy(xpath = "//div[@id='myNavbar']")
	WebElement pageheader;
	@FindBy(xpath = "//h4[normalize-space()='testingVideo']")
	WebElement resource1;
	@FindBy(xpath = "//h4[normalize-space()='Test Video']")
	WebElement resource2;
	@FindBy(xpath = "//img[@class='media-object']")
	WebElement NotMemberResourcevedio;
	@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
	WebElement YesProceed;
	@FindBy(xpath = "//div[@class='bootbox-body']")
	WebElement Message;
	@FindBy(xpath = "//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]")
    WebElement leaveGroup3;
	@FindBy(xpath="//span[normalize-space()='Groups']")
    WebElement group ;
	@FindBy(xpath = "//span[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//div[@ng-show='PromotionPlans.length']//div[@class='row']")
	WebElement adPlans;
	
	public void checkResources1() {
		waitForElementToPresent(resource1);
		if(this.resource1.isDisplayed()&&this.resource1.isEnabled()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public void checkResources2() throws InterruptedException {
		Thread.sleep(8000);
		waitForElementToPresent(resource2);
		if(this.resource2.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		 Thread.sleep(5000);
		    click(group,"Groups");
		    Thread.sleep(5000);
		   // waitForElementToPresent(leaveGroup3);
		    click(leaveGroup3, "Leave3");
	}
	
	
public void checkResourceNotDisplaying() throws InterruptedException {
		waitForElementToPresent(NotMemberResourcevedio);
		this.NotMemberResourcevedio.click();
		waitForElementToPresent(Message);
		String message=Message.getText();
		log.info(message);
		System.out.println(message);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		Thread.sleep(4000);
		
	}
	
public void checkInactiveAdvertisementNotPresent() throws InterruptedException {
	//waitForElementToPresent(BDMAIcomm);
	//click(BDMAIcomm, "BDMAI");
	//clickElementByJavaScript(BDMAIcomm);

	scrollToElementAndClick(advertisement);
	waitForElementToPresent(adPlans);
	String Allplans=this.adPlans.getText();
	String Notpresent="Test@1122";
	System.out.println("Inactive Plan is not present");
	Assert.assertNotSame(Notpresent, Allplans, "Inactive Plan is not present");
	
}
	
	
	
}
