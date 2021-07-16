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
		updateClass(pageheader, "");
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
	
	
	public void checkResources1() {
		waitForElementToPresent(resource1);
		if(this.resource1.isDisplayed()&&this.resource1.isEnabled()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public void checkResources2() {
		waitForElementToPresent(resource2);
		if(this.resource2.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
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
		Thread.sleep(2000);
		
	}
	
	
	
	
	
}
