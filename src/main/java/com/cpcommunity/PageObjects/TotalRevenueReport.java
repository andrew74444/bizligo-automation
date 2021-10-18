package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TotalRevenueReport extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Total Revenue Report']")
	WebElement pageTitle;
	@FindBy(xpath = "//div[@class='col-sm-6 col-md-6']")
	WebElement adRevenue;

    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
		WebElement advertisements;
	    @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
		WebElement manage;
	    @FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
		WebElement managePlans;

	

	
	public void checkTotalRevenuebasedOnTimePeriod() throws InterruptedException {
		
		Thread.sleep(8000);
		String amt=adRevenue.getText();
		System.out.println(amt);

		Thread.sleep(5000);
	 	
	}
	
	 public ManageAdPlansPage goToManageAdPlansPage() {

	 		this.clickOnAdvertisments();
	 		waitForElementToPresent(managePlans);
	 		click(managePlans, "Manage Plans");
	 		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
	 		// new CommunityPendingRequestsPage(driver);
	 	}
	
	
	 public void clickOnAdvertisments() {
	 		click(advertisements, "advertisements");
	 	}

		
	 	
	}
	
	
	
	
	

	
	

