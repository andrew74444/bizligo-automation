package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class TACommunitiesPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	 @FindBy(xpath="//*[id='btnAddNew']")
	 WebElement createCommunity;
	
	@FindBy(xpath="//*[id='PricingPlan']")
	WebElement pricingPlan;
	
	@FindBy(xpath="//*[contains(text(),'Showing')]")
	WebElement showing;
	
	@FindBy(xpath="//*[@class='toast-message']")
	WebElement toastMessage;
	
//		Community created successfully
	
	
	public void AddNewCommunity (String Name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category, String type) throws Exception {
			
		click(createCommunity,"create Community");
		waitForElementToPresent(pricingPlan);
		scrollToElement(pricingPlan);
		selectByVisibleText(pricingPlan, "All Plans 1", "pricing Plan");
		scrollToElement(showing);
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(Name+" "+date(), Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);
	
		
}


	
	

	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(createCommunity);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
