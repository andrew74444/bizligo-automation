package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import org.apache.log4j.Logger;



public class TACommunitiesPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	 @FindBy(xpath="//*[@id='btnAddNew']")
	 WebElement createCommunity;
	
	@FindBy(xpath="//*[@id='PricingPlan']")
	WebElement pricingPlan;
	
	@FindBy(xpath="//*[contains(text(),'Showing')]")
	WebElement showing;
	
	@FindBy(xpath="//*[@class='toast-message']")
	WebElement toastMessage;
	
	@FindBy(xpath="//input[@id='NameSearch']")
	WebElement nameSearch;
	
	
	@FindBy(xpath="//*[@class='fa fa-search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]")
	WebElement communityNameinFirstRow;

	@FindBy(xpath="((//tbody/tr[1]/td[2])/a[1])")
	WebElement CommunityEdit;
	
	
//		Community created successfully

	
	public void searchCommunity(String name) {
		type(nameSearch, name, "Community Name Search");
		click(searchBtn, "search Button");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		waitForElementToPresent(ele);
		SoftAssert st = new SoftAssert();
		st.assertEquals(communityNameinFirstRow.getText(), name);
	}
	
	
	
	public void AddNewCommunity (String name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category, String type) throws Exception {
			
		click(createCommunity,"create Community");
		waitForElementToPresent(pricingPlan);
		scrollToElement(pricingPlan);
		selectByVisibleText(pricingPlan, "All Plans 1", "pricing Plan");
		scrollToElement(showing);
		name = name+" "+date();
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);
		searchCommunity(name);
		
				
		
		
		
}


	
	

	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(createCommunity);
	}







	public void UpdateCommunity(String name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String OtherName,String About,String Category,String type,String StateName,String CityName,String FacebookUrl,String TwitterUrl,String LinkedInUrl,String LogoImagePath,String websiteUrl,String ImagePath,String updateCommunityName) throws Exception {
		name = name+" "+date();
		searchCommunity(name);
		updateCommunityName = updateCommunityName+" "+date();
//		clickElementByJavaScript(CommunityEdit);
		click(CommunityEdit,"Community Edit");
		new CreateOrEditCommunityPage(driver).UpdateCommunity(name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, OtherName, About, Category, type, StateName, CityName, FacebookUrl, TwitterUrl, LinkedInUrl, LogoImagePath, websiteUrl, ImagePath, updateCommunityName);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
