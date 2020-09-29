package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;





public class EditCommunityPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
	@FindBy(xpath="//h4[contains(text(),'Edit Community')]")
	WebElement EditCommunityHeading;
	
	
	@FindBy(xpath="//div[@class='user-text']")
	WebElement usertext;
	
//	@FindBy(xpath="//*[@id='email_create']")
//	WebElement registrationEmailAddress;
	
	@FindBy(xpath="//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;
	
	@FindBy(xpath="//label[@class='btn btn-danger active toggle-off']")
	WebElement toggleOff;
	
	@FindBy(xpath="//label[@class='btn btn-success toggle-on']")
	WebElement toggleOn;
	
	@FindBy(xpath="//button[contains(.,'Save')]")
	WebElement Save;
	
	@FindBy(xpath = "//select[@id='CommunityTypeID']")
    WebElement CommunityType;
	
	@FindBy(xpath = "//span[@class='ng-binding']")
    WebElement Savebtn;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(EditCommunityHeading);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
	
	public CommunityDashboardPage saveCommunity() {
		click(Save,"Save");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}
	
	public CommunityDashboardPage editcommunity(String Name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category,String type,String StateName,String CityName,String FacebookUrl,String TwitterUrl,String LinkedInUrl,String LogoImagePath, String websiteUrl, String ImagePath, String CommunityUpdate, String communityNameUpdate) throws Exception{
		CreateOrEditCommunityPage EditCommunity = new CreateOrEditCommunityPage(driver); 		
		EditCommunity.UpdateCommunity(Name+" "+getDateInDDMMMYYYY(), Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type,StateName, CityName, FacebookUrl, TwitterUrl, LinkedInUrl, LogoImagePath, websiteUrl, ImagePath, CommunityUpdate, communityNameUpdate);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
//		new CommunityDashboardPage(driver);				
	}
	
	
	public void addTermsAndConditions(String TC) throws Exception
	{
		CreateOrEditCommunityPage EditCommunity = new CreateOrEditCommunityPage(driver);
		EditCommunity.TC(TC);
	}

	public EcoSystemPage inActiveCommunity() throws Exception{
		
		picture();
		
		clickElementByJavaScript(toggleOn);
		waitForElementToPresent(YesProceed);
		picture();
		YesProceed.click();
		picture();
		Thread.sleep(1000);
		clickElementByJavaScript(Save);
		picture();
		return (EcoSystemPage) openPage(EcoSystemPage.class);
//		new MyCommunitiesPage(driver);
		
	}	

	public void ActiveCommunity() throws Exception{
		
		
		clickElementByJavaScript(toggleOff);
		waitForElementToPresent(YesProceed);
		YesProceed.click();
		Thread.sleep(1000);
		clickElementByJavaScript(Save);
		
	}

	public CommunityDashboardPage updateCommunityType(String type) throws Exception {
		 selectByVisibleText(CommunityType, type, "CommunityType");
		 waitForElementToPresent(YesProceed);
		 click(YesProceed,"Yes Proceed button");
		 Thread.sleep(1000);
		 clickElementByJavaScript(Savebtn);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}
}
