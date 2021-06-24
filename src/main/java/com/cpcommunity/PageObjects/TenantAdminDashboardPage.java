package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TenantAdminDashboardPage extends BasePage{
	
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(TADashboard);
		return ExpectedConditions.visibilityOf(TADashboard);
	}
	@FindBy(xpath = "//h3[contains(text(),'Tenant Admin Dashboard')]")
	WebElement TADashboard;
	
	@FindBy(xpath = "//a[normalize-space()='Manage Campaign']")
	WebElement ManageCampaign;
	
	@FindBy(xpath = "//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	
	public ComposeCampaignPage NavigatetoComposeCampaignPage() {

		click(ManageCampaign, "ManageCampaign");
		waitForElementToPresent(composeCampaign);
		click(composeCampaign, "compose campaign");
		return (ComposeCampaignPage) openPage(ComposeCampaignPage.class);
		// new GroupsPendingRequestsPage(driver);

	}

}
