package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

public class SystemAdminDashboardPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	@FindBy(xpath = "//h3[contains(text(),'Admin Dashboard')]")
	WebElement SystemAdminDashboardHeader;

	@FindBy(xpath = "(//*[@class='fa fa-chevron-down'])[2]")
	WebElement CommunitiesNavSideMenu;

	@FindBy(xpath = "//a[@title='Pending Communities']")
	WebElement pendingCommunities;

	@FindBy(xpath = "//a[contains(text(),'Pricing Plans')]")
	WebElement PricingPlans;
	
	 @FindBy(xpath="")
	 WebElement communities;
	
	 @FindBy(xpath="//*[text()='Manage Communities']")
	 WebElement manageCommunity;

	@FindBy(xpath = "//*[@class='fa fa-angle-down']")
	WebElement angleDown;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement logout;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(SystemAdminDashboardHeader);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public PendingCommunitiesPage naviagteToPendingCommunities() {
		clickElementByJavaScript(CommunitiesNavSideMenu);
		// click(CommunitiesNavSideMenu,"Communities");
		waitForElementToPresent(pendingCommunities);
		clickElementByJavaScript(pendingCommunities);
		// click(pendingCommunities,"pendingCommunities");

		return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
		// new PendingCommunitiesPage(driver, );

	}

	public PlansPage NavigateManagePricingPlans() {
		click(PricingPlans, "PricingPlans");
		return (PlansPage) openPage(PlansPage.class);
		// new PricingPlans(driver, );

	}

	public HomePage logout() {
		click(angleDown, "System Admin Menu Drop down");
		waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}
	
	
	
	public TACommunitiesPage navigateToCommunitiesPage() {
		click(CommunitiesNavSideMenu, "Communities");
		waitForElementToPresent(manageCommunity);
		click(manageCommunity, "manage Community");
		return (TACommunitiesPage) openPage(TACommunitiesPage.class);
	}

}
