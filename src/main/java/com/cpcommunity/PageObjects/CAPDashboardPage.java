package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CAPDashboardPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		waitForElementToPresent(Dashboard);
		return ExpectedConditions.visibilityOf(Dashboard);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();

	}
	@FindBy(xpath = "//a[normalize-space()='Chambers and Partners']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Dashboard']")
	WebElement Dashboard;

	@FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;

	@FindBy(xpath = "//*[contains(text(),'Manage Member Advertisements')]")
	WebElement manageMemberAdvertisements;

	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
	
	
	
	public ManageAdPlansPage goToManageAdPlansPage() {

		click(advertisements, "advertisements");
		waitForElementToPresent(managePlans);
		click(managePlans, "Manage Plans");
		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
		// new CommunityPendingRequestsPage(driver);
	}
	
	
	
	
	
	
}
