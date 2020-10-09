package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class superAdminDashboardPage extends BasePage {
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(welcome);
	}
	@Override
	protected void getPageScreenSot() {
		aShot();
	}

	@FindBy(xpath="//*[contains(text(),'Welcome')]")
	WebElement welcome;
	
	@FindBy(xpath="(//*[@class='fa fa-chevron-down'])")
	WebElement configuration;
	
	@FindBy(xpath="(//i[@class='fa fa-gear'])[3]")
	WebElement featuresConfiguration;
	
	public SuperAdminFeatureConfigurationPage goToFeatureConfigurationsPage() {
		click(configuration, "configuration");
		waitForElementToPresent(featuresConfiguration);
		click(featuresConfiguration, "features Configuration");
		
		return (SuperAdminFeatureConfigurationPage) openPage(SuperAdminFeatureConfigurationPage.class);
	}

}
