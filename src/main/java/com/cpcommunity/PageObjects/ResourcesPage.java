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
	WebElement NotMemberResource;
	@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
	WebElement YesProceed;
	
	
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
	
	
public MembershipPlansPage checkResourceNotDisplaying() throws InterruptedException {
		waitForElementToPresent(NotMemberResource);
		this.NotMemberResource.click();
		waitForElementToPresent(YesProceed);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		Thread.sleep(2000);
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}
	
	
	
	
	
}
