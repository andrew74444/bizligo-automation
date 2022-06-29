package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
	
	
	
	public CommunityDashboardPage saveCommunity() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToPresent(Save);
		click(Save,"Save");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}
	
	public CommunityDashboardPage editcommunity(String Name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category,String type,String StateName,String CityName,String FacebookUrl,String TwitterUrl,String LinkedInUrl,String LogoImagePath, String websiteUrl, String ImagePath, String CommunityUpdate, String communityNameUpdate) throws Exception{
		CreateOrEditCommunityPage EditCommunity = new CreateOrEditCommunityPage(driver); 		
		EditCommunity.UpdateCommunity(Name+getDateInDDMMMYYYY(), Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type,StateName, CityName, FacebookUrl, TwitterUrl, LinkedInUrl, LogoImagePath, websiteUrl, ImagePath, CommunityUpdate, communityNameUpdate+getDateInDDMMMYYYY());
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
//		new CommunityDashboardPage(driver);				
	}
	  @FindBy(xpath = "//select[@name='CommunityCategory']")
	    WebElement CommunityCategory;
	  @FindBy(xpath = "  (//*[@class='form-group']/*[@class='col-md-6 col-sm-9 col-xs-12']/*/*[@class='img-thumbnail'])[1]")
			  WebElement logo;
	  @FindBy(xpath = "//a[@title='Edit Community']")
		WebElement EditCommunity;
	  @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
		WebElement manage;
	public void updateCommunitycategoryAndVerifyingCommunityLogo(String Category1,String Category2) throws InterruptedException {
		Thread.sleep(3000);
		waitForElementToPresent(logo);
		String image1=logo.getAttribute("src");
		System.out.println(image1);
		waitForElementToPresent(CommunityCategory);
		  Select Cat = new Select(CommunityCategory);  
	        Cat.selectByVisibleText(Category1);
	        waitForElementToPresent(Savebtn);
		       clickElementByJavaScript(Savebtn);
		       Thread.sleep(3000);       
		   	waitForElementToPresent(manage);
			click(manage, "manage");
		      waitForElementToPresent(EditCommunity);
				click(EditCommunity, "EditCommunity");
				Thread.sleep(2000);
				scrollDownVertically();
				waitForElementToPresent(logo);
				String image2=logo.getAttribute("src");
				System.out.println(image2);
				if(image1.equals(image2)) {
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
					System.out.println("When community Catergory changed that community logo also changed");
				}
				
				waitForElementToPresent(CommunityCategory);
				scrollToElement(CommunityCategory);
				  Select Cat1 = new Select(CommunityCategory);
			       
			        Cat1.selectByVisibleText(Category2);
			        waitForElementToPresent(Savebtn);
				       clickElementByJavaScript(Savebtn);
				       Thread.sleep(5000);
			
				
	}
	
	public void addTermsAndConditions(String TC) throws Exception
	{
		CreateOrEditCommunityPage EditCommunity = new CreateOrEditCommunityPage(driver);
		EditCommunity.TC(TC);
	}

	public EcoSystemPage inActiveCommunity() throws Exception{
		
	//	picture();
	//	Thread.sleep(5000);
		scrollDownVertically();//added on 07/04
		 scrollIntoView(toggleOn);//added on 07/04
		clickElementByJavaScript(toggleOn);
		waitForElementToPresent(YesProceed);
	//	picture();
		click(YesProceed,"YesProceed");
	//	picture();
		
		 scrollIntoView(Save);//added on 07/04
		clickElementByJavaScript(Save);
		Thread.sleep(5000);
	//	picture();
		return (EcoSystemPage) openPage(EcoSystemPage.class);
//		new MyCommunitiesPage(driver);
		
	}	

	public void ActiveCommunity() throws Exception{
		
		
		clickElementByJavaScript(toggleOff);
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		Thread.sleep(1000);
		clickElementByJavaScript(Save);
		
	}

	public CommunityDashboardPage updateCommunityType(String type) throws Exception {
		Thread.sleep(5000);
		 waitForElementToPresent(CommunityType);
		 scrollToElement(CommunityType);
		 selectByVisibleText(CommunityType, type, "CommunityType");
		 waitForElementToPresent(YesProceed);
		 click(YesProceed,"Yes Proceed button");
		// Thread.sleep(1000);
		 waitForElementToPresent(Savebtn);
		 clickElementByJavaScript(Savebtn);
		 Thread.sleep(5000);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	}
}
