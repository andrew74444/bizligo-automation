package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SelectnewMembershipPlan extends BasePage {
	
	
	@FindBy(xpath = "//*[contains(text(),'Select Plan')]")
	WebElement selectPlan;
	
	@FindBy(xpath = "(//div[1]/div[1]/div[1]/div[3]/a[1])[2]")
	WebElement selectMembershipPlan;
	
	@FindBy(xpath = "(//*[contains(text(),'Next')])[1]")
	WebElement Next;
	
	@FindBy(xpath = "(//*[@value='2'])[2]")
	WebElement authorize;
	
	@FindBy(xpath = "//button[normalize-space()='Pay through Checkout']")
	WebElement authorizeProccedbtn;
	
	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement pageheader;

	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(selectPlan);
	}
	
	public AuthorizeGateway MembershipPlansPage() throws Throwable
	{
		click(selectMembershipPlan, "select Membership Plan");
		Thread.sleep(5000);
		click(Next, "Next");
		Thread.sleep(5000);
		waitForElementToPresent(authorize);
		click(authorize, "authorize button");
		Thread.sleep(5000);
		click(authorizeProccedbtn, "Proceed button");
		Thread.sleep(10000);
		return (AuthorizeGateway) openPage(AuthorizeGateway.class);
	}

}
