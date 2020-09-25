package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class CreateCommunityPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	
	@FindBy(xpath="//h4[contains(text(),'Create Community')]")
	WebElement CreateCommunityHeading;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(CreateCommunityHeading);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
	
	public GlobalCommunitesPage CreateCommunity(String Name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category,String type ) throws Exception{
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(Name+" "+getDateInDDMMMYYYY(), Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);
		picture();
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//				new GlobalCommunitesPage(driver,);
	}

	public String getCommunityName(String communityName) {
		
		String d = getDateInDDMMMYYYY();
		
		communityName = communityName +" "+ d;
		return communityName;
		
		
	}
	
}
