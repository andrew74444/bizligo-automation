package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class SystemAdminDashboardPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	
	@FindBy(xpath="//h3[contains(text(),'System Admin Dashboard')]")
	WebElement SystemAdminDashboardHeader;
	
	
	@FindBy(xpath="//ul[@class='nav side-menu']//li[3]//a[1]//span[1]")
	WebElement CommunitiesNavSideMenu;
	
	@FindBy(xpath="//a[@title='Pending Communities']")
	WebElement pendingCommunities;
	
	@FindBy(xpath="//a[contains(text(),'Pricing Plans')]")
	WebElement PricingPlans;
//	
//	@FindBy(xpath="//*[@id='center_column']/h1")
//	WebElement authenticate;
//	
//	@FindBy(xpath="//*[@id='create-account_form']/div/p")
//	WebElement createAnAccountMessage;
	
	@FindBy(xpath="//*[@class='fa fa-angle-down']")
	WebElement angleDown;	

	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logout;
	
	
		
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(SystemAdminDashboardHeader);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public PendingCommunitiesPage naviagteToPendingCommunities(){
		click(CommunitiesNavSideMenu,"Communities");
		waitForElementToPresent(pendingCommunities);
		click(pendingCommunities,"pendingCommunities");
		
		return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
//				new PendingCommunitiesPage(driver, );
	
	}
	
	public PlansPage NavigateManagePricingPlans() {
		click(PricingPlans,"PricingPlans");
		return (PlansPage) openPage(PlansPage.class);
//		new PricingPlans(driver, );
		
	}
	
	
	
	public HomePage logout() {
		click(angleDown,"System Admin Menu Drop down");
		waitForElementToPresent(logout);
		click(logout,"logout");		
		return (HomePage) openPage(HomePage.class);
	}
	
	
	
	
	
}
