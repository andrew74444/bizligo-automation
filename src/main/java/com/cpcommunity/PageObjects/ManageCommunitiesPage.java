package com.cpcommunity.PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ManageCommunitiesPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		//updateClass(pageheader, "");
		aShot();
	}
	
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement revenuereport;
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Manage Communities']")
	WebElement pageTitle;
	@FindBy(xpath = "//input[@id='NameSearch']")
	WebElement searchByName;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//a[@title='Click to edit this Community']")
	WebElement edit;
	@FindBy(xpath = "//label[normalize-space()='Networking']")
	WebElement networking;
	@FindBy(xpath = "//p[normalize-space()='Test data']")
	WebElement about;
	@FindBy(xpath = "//select[@id='CommunityTypeID']")
	WebElement Type;
	@FindBy(xpath = "//label[@class='btn btn-danger active toggle-off']")
	WebElement inactive;
	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement active;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;
	@FindBy(xpath = "//button[@id='btnCancel']")
	WebElement cancel;
	@FindBy(xpath = "//select[@id='GroupCategoryId']")
	WebElement categoryType;
	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(xpath = "//a[@title='Go to Member site home']")
	WebElement homePage;
	@FindBy(xpath = "//a[normalize-space()='Global Communities']")
	WebElement globalcommunties;
	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement searchbystatus;
	@FindBy(xpath = "//tbody//td[3]")
	List<WebElement> planList;
	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
    @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
	WebElement manage;
	@FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;
	@FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement toggledropdown;
    @FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement tenantmodule;
	@FindBy(xpath = "//button[@id='btnAddNew']")
	WebElement createCommunity;
	@FindBy(xpath = "//input[@id='Name']")
	WebElement name;
	@FindBy(xpath = "//small[contains(text(),'Community already exists. Please enter a different')]")
	WebElement samecommunityerror;
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement communityrequest;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement ok;
	@FindBy(xpath = "//a[@class='btn btn-xs btn-primary']")
	WebElement managecommunity;
	@FindBy(xpath = "//h4[normalize-space()='Published Events']")
	WebElement publishEvent;
	

	
	public CommunityEventsPage clickcommunity() {
		
		waitForElementToPresent(managecommunity);
		click(managecommunity, "manage community");
	scrollToElement(publishEvent);
		click(publishEvent, "Publish event");
		return (CommunityEventsPage) openPage(CommunityEventsPage.class);
	}
	  
	
    public void searchCommunity(String Community) throws InterruptedException {
	waitForElementToPresent(searchByName);
	type(searchByName, Community, "Community Name");
	click(search, "Search");
	Thread.sleep(8000);
         }


    public void searchinactiveCommunity() throws InterruptedException {
    	waitForElementToPresent(searchbystatus);
    	selectUsingIndex(searchbystatus, 2, "Inactve");
    	click(search, "Search");
    	Thread.sleep(5000);

  	 List<WebElement> elementList= this.planList;
  		String[] obtainedList= new String[elementList.size()]  ;
  		for(int i=0; i<=1;i++) {
  			obtainedList[i]=elementList.get(i).getText();
  		System.out.println(obtainedList[i]);
  		}
  		//Thread.sleep(5000); 
  		
             }
    
   
    
    public void clickOnAdvertisments() throws InterruptedException {
 		click(advertisements, "advertisements");
 		Thread.sleep(1000);
 	}
    
    public ManageAdPlansPage goToManageAdPlansPage() throws InterruptedException {
    	Thread.sleep(5000);
         scrollToElement(advertisements);
 		this.clickOnAdvertisments();
 		waitForElementToPresent(managePlans);
 		click(managePlans, "Manage Plans");
 		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
 		// new CommunityPendingRequestsPage(driver);
 	}


    public CommunityEventsPage clickcommunity() {

    	waitForElementToPresent(managecommunity);
    	click(managecommunity, "manage community");
    	scrollToElement(publishEvent);
    	click(publishEvent, "Publish event");
    	return (CommunityEventsPage) openPage(CommunityEventsPage.class);
    	}

   public void EditCommunities(String Name,String About, String Category,String type) throws InterruptedException {
	   Name=Name+" " + getDateInDDMMMYYYY();
	   this.searchCommunity(Name);
	   waitForElementToPresent(edit);
		click(edit, "Edit");
		Thread.sleep(3000);
		waitForElementToPresent(networking);
		click(networking, "Networking");
		clickElementByJavaScript(networking);
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(About);
		driver.switchTo().defaultContent();
		selectByVisibleText(categoryType, Category, "Category");
	    selectByVisibleText(Type, type, "Type");
	   // click(active, "Inactive");
	    clickElementByJavaScript(active);
	    Thread.sleep(2000);
	    clickElementByJavaScript(save);
	    //waitForElementToPresent(YesProceed);
	   // click(YesProceed, "Yes Proceed");
	    Thread.sleep(2000);
	   // click(save, "Save");
	   
	   
     }
   
   public void ActivateCommunities(String Community , String About, String Category,String type) throws InterruptedException {
	   waitForElementToPresent(searchByName);
		type(searchByName, Community, "Community Name");
		click(search, "Search");
		//Thread.sleep(4000);
	   waitForElementToPresent(edit);
		click(edit, "Edit");
		//Thread.sleep(3000);
		waitForElementToPresent(networking);
		click(networking, "Networking");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(About);
		driver.switchTo().defaultContent();
		selectByVisibleText(categoryType, Category, "Category");
	    selectByVisibleText(Type, type, "Type");
	    click(inactive, "active");
	    Thread.sleep(1000);
	    
	    click(save, "Save");
	   // Thread.sleep(4000);
     }
   
public GlobalCommunitesPage navigateToglobalcommunities() throws InterruptedException {
	Thread.sleep(8000);
	click(homePage, "Bizligo Home page");
	waitForElementToPresent(globalcommunties);
	click(globalcommunties, "Global communities");
	return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);	
}

public RevenueReportPage navigateToRevenueReport() {
	
	waitForElementToPresent(dashboardreport);
	click(dashboardreport, "Dashboard Reports");
	waitForElementToPresent(revenuereport);
	click(revenuereport, "Revenue Report");
	return (RevenueReportPage) openPage(RevenueReportPage.class);	
}
public void createSameCommunity(String Name) {
	
	waitForElementToPresent(createCommunity);
	click(createCommunity, "Create Community");
	waitForElementToPresent(name);
	type(name, Name, "Name");
	click(networking, "Networking");
	String error=this.samecommunityerror.getText();
	System.out.println(error);
    
} 
}
