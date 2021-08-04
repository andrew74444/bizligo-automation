package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

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
	
	@FindBy(xpath="((//tbody/tr[1]/td[2])/a[2])")
	WebElement manageMembers;
	@FindBy(xpath = "//input[@id='Name']")
    WebElement CommunityName;
    @FindBy(xpath = "//select[@name='CommunityCategory']")
    WebElement CommunityCategory;
    @FindBy(xpath = "//select[@id='CommunityTypeID']")
    WebElement CommunityType;
    @FindBy(xpath = "//input[@value='1']")
    WebElement PNetworking;
    @FindBy(xpath = "//input[@value='2']")
    WebElement PMarketing;
    @FindBy(xpath = "//input[@value='3']")
    WebElement PBranding;
    @FindBy(xpath = "//input[@value='4']")
    WebElement PBuildingRelationship;
    @FindBy(xpath = "//input[@value='5']")
    WebElement PGrowMyBusiness;
    @FindBy(xpath = "//input[@value='6']")
    WebElement PInvestInBusiness;
    @FindBy(xpath = "//input[@value='7']")
    WebElement POther;
    @FindBy(tagName = "body")
    WebElement enterTextInframe;
    @FindBy(tagName = "iframe")
    WebElement iframe;
    @FindBy(xpath = "//button[@id='btnSave']")
    WebElement Createbtn;
    @FindBy(xpath = "//span[@class='fa fa-edit']")
    WebElement Editbtn;
    @FindBy(xpath = "//button[@id='btnSave']//i[@class='fa fa-floppy-o']")
    WebElement saveBtn;
    @FindBy(xpath = "//*[@id=\"CommunityForm\"]/div[1]/div/small[4]")
    WebElement errorMsgOfDuplicateCommunity;
    @FindBy(xpath = "//img[@class='img-responsive select-img focused']")
    WebElement themeReadable;
    

//		Community created successfully

	
	public void searchCommunity(String name) {
		type(nameSearch, name, "Community Name Search");
		click(searchBtn, "search Button");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		waitForElementToPresent(ele);
		SoftAssert st = new SoftAssert();
		st.assertEquals(communityNameinFirstRow.getText(), name);
	}
	
	
	
	public void AddNewCommunity (String name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String Other,String About,String Category, String type,String pricingPlan) throws Exception {
			
		click(createCommunity,"create Community");
		waitForElementToPresent(this.pricingPlan);
		scrollToElement(this.pricingPlan);
		pricingPlan = pricingPlan+getDateInDDMMMYYYY();
		selectByVisibleText(this.pricingPlan, pricingPlan, "pricing Plan");
		scrollToElement(showing);
		name = name+getDateInDDMMMYYYY();
		new CreateOrEditCommunityPage(driver).FillCommunityDetails(name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, Other, About, Category, type);
		searchCommunity(name);
		
				
		
		
		
}


	
	

	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(createCommunity);
	}







	public void UpdateCommunity(String name,String Networking,String Marketing,String BuildingRelationship,String Branding,String GrowMyBusiness,String InvestInBusiness,String OtherName,String About,String Category,String type,String StateName,String CityName,String FacebookUrl,String TwitterUrl,String LinkedInUrl,String LogoImagePath,String websiteUrl,String ImagePath,String communityUpdate, String updateCommunityName) throws Exception {
		name = name+" "+getDateInDDMMMYYYY();
		searchCommunity(name);
		updateCommunityName = updateCommunityName+" "+getDateInDDMMMYYYY();
		clickElementByJavaScript(CommunityEdit);
		
//		clickByVisibleScreen("D:\\workspace\\bizligo-automation\\src\\test\\resources\\testImages\\Files\\TA Community Edit Button.png");
		
//		
//		click(CommunityEdit,"Community Edit");
		
		new CreateOrEditCommunityPage(driver).UpdateCommunity(name, Networking, Marketing, BuildingRelationship, Branding, GrowMyBusiness, InvestInBusiness, OtherName, About, Category, type, StateName, CityName, FacebookUrl, TwitterUrl, LinkedInUrl, LogoImagePath, websiteUrl, ImagePath, communityUpdate, updateCommunityName);
	}



	public ManageCommunityMembersPage navigateTomanageMembers(String name) {
		
		name = name+" "+getDateInDDMMMYYYY();
		searchCommunity(name);
		clickElementByJavaScript(manageMembers);
		return (ManageCommunityMembersPage) openPage(ManageCommunityMembersPage.class);
	}
    public ManageCommunityMembersPage navigateToManageMembers(String name) {
		
		//name = name+" "+getDateInDDMMMYYYY();
		searchCommunity(name);
		clickElementByJavaScript(manageMembers);
		return (ManageCommunityMembersPage) openPage(ManageCommunityMembersPage.class);
	}


	 



	public int checkActivePricingPlans() {
		click(createCommunity,"create Community");
		waitForElementToPresent(this.pricingPlan);
		scrollToElement(this.pricingPlan);
		log.info(getAllDropDownData(pricingPlan));
		return getTotalCountOfDropDown(pricingPlan)-1;
		
	}



	public void InActivateCommunity(String name) throws Exception {
		name = name+" "+getDateInDDMMMYYYY();
		searchCommunity(name);
		
		clickElementByJavaScript(CommunityEdit);

		new CreateOrEditCommunityPage(driver).InActiavteCommunity();
		
	}


    public void createCommunity(String Name,String About,String Networking, String Marketing, String BuildingRelationship,
	    		String Branding, String GrowMyBusiness, String InvestInBusiness, String Other,String Category,String type,String PricingPlan ) throws InterruptedException  {
    	click(createCommunity,"create Community");
    	CommunityName.clear();
    	Name = Name+getDateInDDMMMYYYY();
		type(CommunityName, Name,"Name");       
        driver.switchTo().frame(iframe);
        enterTextInframe.clear();
        type(enterTextInframe, About,"CommunityAbout");       
        driver.switchTo().defaultContent();
        if ("Networking".equalsIgnoreCase(Networking)) {
        	
            click(PNetworking,"Networking");
        }
        if ("Marketing".equalsIgnoreCase(Marketing)) {
        	
            click(PMarketing,"Marketing");
        }
        if ("Building Relationship".equalsIgnoreCase(BuildingRelationship)) {
        	
        	click(PBuildingRelationship,"BuildingRelationship");
        }
        if ("Branding".equalsIgnoreCase(Branding)) {
        	
            click(PBranding,"Branding");
        }
        if ("Grow My Business".equalsIgnoreCase(GrowMyBusiness)) {
        	
            click(PGrowMyBusiness,"GrowMyBusiness");
        }
        if ("Invest In Business".equalsIgnoreCase(InvestInBusiness)) {
        	
            click(PInvestInBusiness,"PInvestInBusiness");
        }
        if ("Other".equalsIgnoreCase(Other)) {
        	
            click(POther,"Other");
        }
        //selectUsingIndex(CommunityCategory, index,"Community Category");
        selectByVisibleText(CommunityCategory, Category, "CommunityCategory");
        selectByVisibleText(CommunityType, type, "CommunityType");
        selectByVisibleText(this.pricingPlan, PricingPlan, "pricing Plan");
		
        picture();
        click(Createbtn,"Create btn");
        Thread.sleep(3000);
        System.out.println( toastMessage.getText());
        if(toastMessage.getText().equalsIgnoreCase("Community created successfully")) 
        		{
        	Assert.assertTrue(true);
        		}
    }
        public void TA_editCommunity(String Name,String EditedName,String About,String Other,String Category) throws InterruptedException {
    		Name = Name+getDateInDDMMMYYYY(); 
    		type(nameSearch, Name, "Community Name Search");
    		click(searchBtn, "search Button");
    		Thread.sleep(5000);
    		click(Editbtn,"Edit Community");
    		EditedName=EditedName+getDateInDDMMMYYYY(); 
    		type(CommunityName, EditedName,"Name");
    		click(saveBtn,"Save");
    		System.out.println( toastMessage.getText());
            if(toastMessage.getText().equalsIgnoreCase("Community details updated successfully")) 
            		{
            	Assert.assertTrue(true);
            		}
           
    	}
        public void checkPaymentPlan(String ActivePlan,String InactivePlan){
    		click(createCommunity,"create Community");
    		waitForElementToPresent(pricingPlan);
    		scrollIntoView(pricingPlan);
    		System.out.println(pricingPlan.getText());
    		System.out.println(ActivePlan);
    		if(pricingPlan.getText().contains(ActivePlan)) {
    			System.out.println("Active Payment plans visible in dropdown");
    			Assert.assertTrue(true);
    		}else {
    			System.out.println("Active Payment plans not visible");
    			Assert.assertTrue(false);
    		}
    		if(pricingPlan.getText().contains(InactivePlan)) {
    			System.out.println("Inactive Plans visible in dropdown");
    			Assert.assertTrue(false);
    		}else {System.out.println("Inactive plans not visible in dropdown");
    		Assert.assertTrue(true);
    		}
    		
    		 //selectByVisibleText(this.pricingPlan, ActivePlan, "pricing Plan");
    			
    	}
        public void createCommunityWithExistingName(String Name) throws InterruptedException {
    		click(createCommunity,"create Community");
        	CommunityName.clear();
        	type(CommunityName, Name,"Name");
        	CommunityName.click();
        	PNetworking.click();
        	Thread.sleep(7000);
        	System.out.println(errorMsgOfDuplicateCommunity.getText());
        	AssertionHelper.verifyText(errorMsgOfDuplicateCommunity.getText(), "Community already exists. Please enter a different community name");
    	}
       




       
        
    	
    }


	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	

