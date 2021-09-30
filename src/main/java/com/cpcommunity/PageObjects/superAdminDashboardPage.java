package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class superAdminDashboardPage extends BasePage {
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(Title);
	}
	@Override
	protected void getPageScreenSot() {
		aShot();//
	}

	@FindBy(xpath="//*[contains(text(),'Welcome')]")
	WebElement welcome;
	@FindBy(xpath="//a[@title='Go to Member site home']")
	WebElement Title;

	
	@FindBy(xpath="//a[normalize-space()='Configuration']//i[@class='fa fa-gear']")
	WebElement configuration;//*[@class='fa fa-chevron-down'])
	
	@FindBy(xpath="(//i[@class='fa fa-gear'])[3]")
	WebElement featuresConfiguration;
	//
	public SuperAdminFeatureConfigurationPage goToFeatureConfigurationsPage() throws InterruptedException {
		Thread.sleep(3000);
		click(configuration, "configuration");
		waitForElementToPresent(featuresConfiguration);
		click(featuresConfiguration, "features Configuration");
		
		return (SuperAdminFeatureConfigurationPage) openPage(SuperAdminFeatureConfigurationPage.class);
	}

}
