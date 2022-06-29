package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class CreateCommunityPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	
	@FindBy(xpath="//h4[contains(text(),'Create Community')]")
	WebElement CreateCommunityHeading;
	@FindBy(xpath = "//input[@id='Name']")
	WebElement name;
	@FindBy(xpath = "//small[contains(text(),'Community already exists. Please enter a different')]")
	WebElement samecommunityerror;
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement communityrequest;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement ok;
	@FindBy(xpath = "//input[@class='ng-pristine ng-untouched ng-valid ng-empty'][@value='4']")
	WebElement networking;
	@FindBy(xpath = "//body//p")
	WebElement about;
	@FindBy(xpath = "//select[@id='CommunityTypeID']")
	WebElement Type;
	@FindBy(xpath = "//select[@id='GroupCategoryId']")
	WebElement categoryType;
	@FindBy(xpath = "//body")
	WebElement enterTextInframe;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement create;
	
	
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
		
	//	updateClass(pageheader, "");
		log.info(Name);
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(Name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);//+getDateInDDMMMYYYY()
	//	picture();
		
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//				new GlobalCommunitesPage(driver,);
	}

	public String getCommunityName(String communityName) {
		
		String d = getDateInDDMMMYYYY();
		
		communityName = communityName+d;
		return communityName;
		
		
	}
	public String samecommunity(String Name) throws InterruptedException {
		waitForElementToPresent(name);
		type(name, Name, "Name");
	//	Thread.sleep(2000);
		click(networking, "Networking");
		String error=this.samecommunityerror.getText();
		System.out.println(error);
		
		return Name;
		
	}
	
	public String Createcommunity(String Name,String About, String Category,String type) throws InterruptedException {
	//	Name=Name+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(name);
		type(name, Name, "Name");
		//type(name, Name, "Name");
		//Thread.sleep(3000);
		click(networking, "Networking");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(About);
		driver.switchTo().defaultContent();
		selectByVisibleText(categoryType, Category, "Category");
		driver.switchTo().frame(2);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(About);
		driver.switchTo().defaultContent();
		selectUsingIndex(Type, 1, "Type");
		
	    click(create, "Create");
	    waitForElementToPresent(communityrequest);
	    String request=this.communityrequest.getText();
	    System.out.println(request);
	    click(ok, "Ok");
		return Name;
		
		
		
	}
}
