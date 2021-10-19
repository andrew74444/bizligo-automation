package com.cpcommunity.PageObjects;



import java.util.concurrent.TimeUnit;


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

		updateClass(pageheader, "");

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

	WebElement NotMemberResource;
	//@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
//	WebElement YesProceed;
	
	
	//public void checkResources1() {

	WebElement NotMemberResourcevedio;
	@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
	WebElement YesProceed;
	@FindBy(xpath = "//div[@class='bootbox-body']")
	WebElement Message;
	@FindBy(xpath="//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]//strong[1]")
	WebElement leaveGroup3 ;
	@FindBy(xpath = "//strong[normalize-space()='Leave']")
    WebElement leave;//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]
	@FindBy(xpath="//span[normalize-space()='Groups']")
    WebElement group ;
	@FindBy(xpath = "//span[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//div[@ng-show='PromotionPlans.length']//div[@class='row']")
	WebElement adPlans;
	
	public void checkResources1() throws InterruptedException {
		Thread.sleep(4000);

		waitForElementToPresent(resource1);
		if(this.resource1.isDisplayed()&&this.resource1.isEnabled()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

/*	public void checkResources2() {
		waitForElementToPresent(resource2);
		if(this.resource2.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	*/
	
	/*
public MembershipPlansPage checkResourceNotDisplaying() throws InterruptedException {
		waitForElementToPresent(NotMemberResource);
		this.NotMemberResource.click();
		waitForElementToPresent(YesProceed);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		Thread.sleep(2000);
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}
*/	
	

	public void checkResources2() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
		waitForElementToPresent(resource2);
		if(this.resource2.isDisplayed()) {
			Assert.assertTrue(true);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		    click(group,"Groups");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		   // waitForElementToPresent(leaveGroup3);
		    click(leaveGroup3, "Leave");
	}
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
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
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
