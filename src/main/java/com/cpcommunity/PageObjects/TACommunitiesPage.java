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

//	@FindBy(xpath="")
//	WebElement ;
	
	
//		Community created successfully
	
	
	public void AddNewCommunity (String Name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category, String type) throws Exception {
			
		click(createCommunity,"create Community");
		waitForElementToPresent(pricingPlan);
		scrollToElement(pricingPlan);
		selectByVisibleText(pricingPlan, "All Plans 1", "pricing Plan");
		scrollToElement(showing);
		Name = Name+" "+date();
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(Name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);
		
		type(nameSearch, Name, "Community Name Search");
		click(searchBtn, "search Button");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+Name+"')]"));
		waitForElementToPresent(ele);
		SoftAssert st = new SoftAssert();
		st.assertEquals(communityNameinFirstRow.getText(), Name);
				
		
		
		
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
