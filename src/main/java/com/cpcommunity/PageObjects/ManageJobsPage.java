package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ManageJobsPage extends BasePage {

	@Override
	protected  void getPageScreenSot() {
	
		aShot();

	}

	@FindBy(xpath = "//button[@id='btnAddNewJob']")
	WebElement btnAddNewJob;

	@FindBy(xpath = "//div[@id='JobsController']//*[contains(text(),'Manage Jobs')]")
	WebElement ManageJobsTitle;

	@FindBy(xpath = "//div[@class='col-sm-8']//input[@id='JobTitle']")
	WebElement JobTitle;

	@FindBy(xpath = "//select[@id='BillingRate']")
	WebElement BillingRate;

	@FindBy(xpath = "(//select[@id='JobTypeID'])[2]")
	WebElement JobTypeID;

	@FindBy(xpath = "//div[@class='col-sm-8']//input[@id='Location']")
	WebElement Location;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement Active;//input[@ng-value='false']

	@FindBy(xpath = "//input[@ng-value='true']")
	WebElement Active1;
	
	@FindBy(xpath = "//button[@id='submitJobForm']")
	WebElement postBtn;

	@FindBy(xpath = "//button[@id='submitJobForm']")
	WebElement Update;
	//button[@id='submitJobForm']
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//div[@class='form-group']//input[@id='JobTitle']")
	WebElement searchWithJobTitle;

	@FindBy(xpath = "//table[@id='manageJobsTable']/tbody/tr[1]/td[2]")
	WebElement Edit;

	@FindBy(tagName = "iframe")
	WebElement JobDescription;

	@FindBy(tagName = "iframe")
	WebElement AdditionalDetails;
	@FindBy(xpath = "//textarea[@id='reMarks']")
	WebElement reMarks;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement makeGlobal;

	@FindBy(tagName = "body")
	WebElement enterTextInframe;

	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement btnSearch;

	@FindBy(xpath = "//label[normalize-space()='In-Active']")
	WebElement InActive;

	@FindBy(xpath = "//a[@class='site_title']")
	WebElement BDMAIHomePage;
	
	@FindBy(xpath = "//a[normalize-space()='Careers']")
	WebElement careers;
	
	@FindBy(xpath = "//a[@class='display-none'][normalize-space()='Communities']")
	WebElement communities;
	
	@FindBy(xpath = "//a[normalize-space()='Manage Communities']")
	WebElement manageCommuties;
	
	@FindBy(xpath = "//a[@title='Go to Member site home']")
	WebElement homepage;
	
	@FindBy(xpath = "//select[@id='CommunityID']")
	WebElement Community;
	
	@FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement angleDown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//div[@class='swal-text']")
	List<WebElement> discardMsgs;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement discardMsg;
    @FindBy(xpath = "//select[@id='CommunityID']")
	WebElement communitiesDropDown;
    @FindBy(xpath = "//div[@class='form-group']//select[@id='JobTypeID']")
	WebElement SearchJobTypeID;
    @FindBy(xpath = "//a[@class='edit-page ng-scope']")
	WebElement manageBtn;
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement SearchByStatus;
    @FindBy(xpath = "//tbody/tr/td[3]")
	 List<WebElement> totalJobResult;
    
	 @FindBy(xpath = "//tbody/tr/td[4]")
	 List<WebElement> totalJobLocationResult;

	 @FindBy(xpath = "//tbody/tr/td[6]")
	 List<WebElement> totalJobtypeIDResult;

	 @FindBy(xpath = "//tbody/tr/td[12]")
	 List<WebElement> totalJobStatusResult;
	 @FindBy(xpath = "//div[@class='form-group']//input[@id='Location']")
	WebElement searchByLocation;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(ManageJobsTitle);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public void UpdateJobName(String Job, String jobTitle) throws Exception {

		type(this.searchWithJobTitle, Job, "searchWithJobTitle");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		this.JobTitle.clear();
		type(this.JobTitle, jobTitle, "JobTitle");
		click(Update, "Update");
		Thread.sleep(2000);
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
	}
	public GlobalCareers navigateToCareerPage() {
		waitForElementToPresent(BDMAIHomePage);
		click(BDMAIHomePage, "HomePage");
		waitForElementToPresent(careers);
		click(careers, "Careers");
		
		return (GlobalCareers) openPage(GlobalCareers.class);	
	}
	public GlobalCareers navigateToglobalCareerPage() {
		waitForElementToPresent(homepage);
		click(homepage, "HomePage");
		
		waitForElementToPresent(careers);
		click(careers, "Careers");
		
		return (GlobalCareers) openPage(GlobalCareers.class);	
	}
	
	public CommunityDetailsPage navigateToCommunityDetailsPage(String name) {
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		scrollToElement(ele);
		click(ele,"name");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}

	public ManageCommunitiesPage navigateToManageCommunitiesPage() throws InterruptedException {
		Thread.sleep(3000);
		click(communities, "Communities");
		waitForElementToPresent(manageCommuties);
		click(manageCommuties, "Manage communities");
		return (ManageCommunitiesPage) openPage(ManageCommunitiesPage.class);
	}
	public void postJob(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		type(this.JobTitle, jobTitle, "JobTitle");
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		type(reMarks, remarks, "reMarks");
		click(Update, "Post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}
	public void postTAJob(String community,String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.Community );
		selectByVisibleText(Community, community, "Community Name");
		Thread.sleep(2000);
		type(this.JobTitle, jobTitle, "JobTitle");
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		type(reMarks, remarks, "reMarks");
		click(Update, "Post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}
	public void inactiveTAJob(String community,String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.Community );
		selectByVisibleText(Community, community, "Community Name");
		Thread.sleep(2000);
		type(this.JobTitle, jobTitle, "JobTitle");
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(InActive, "InActive");
		type(reMarks, remarks, "reMarks");
		click(Update, "Post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(10000);

	}

	public void makeInactiveGlobalJob(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		type(this.JobTitle, jobTitle, "JobTitle");	
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(InActive, "InActive");
		type(reMarks, remarks, "reMarks");
		Thread.sleep(2000);
		click(postBtn, "post");
		Thread.sleep(4000);
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}

	public void makeActiveGlobalJob(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		type(this.JobTitle, jobTitle, "JobTitle");
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		type(reMarks, remarks, "reMarks");
		click(Update, "Post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}
	public void postJobswithoutAdditionalDetailAndRemaks(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			 String makeGlobal) throws Exception {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		type(this.JobTitle, jobTitle, "JobTitle");

	
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		click(Update, "Post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}

	public void UpdateJob(String JobTitle, String UpdateTitle, String BillingRate, String JobTypeID, String Location,
			String Description, String AdditionalDetails, String reMarks, String makeGlobal) throws Exception {

		type(this.searchWithJobTitle, JobTitle, "searchWithJobTitle");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		this.JobTitle.clear();
		this.Location.clear();
		this.reMarks.clear();
		// try {
		// click(driver.findElement(By.xpath("//*[@class='ng-valid ng-dirty
		// ng-valid-parse ng-touched ng-not-empty']")));
		// } catch (Exception e) {
		//
		// }
		
		selectByVisibleText(this.BillingRate, "Select Job Billing Rate","BillingRate");
		selectByVisibleText(this.JobTypeID, "Select Job Type","JobTypeID");

		driver.switchTo().frame(0);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		type(this.JobTitle, UpdateTitle, "JobTitle");
		// DropDownHelper = new DropDownHelper(driver);
		selectByVisibleText(this.BillingRate, BillingRate,"BillingRate");
		selectByVisibleText(this.JobTypeID, JobTypeID,"JobTypeID");

		driver.switchTo().frame(0);
		enterTextInframe.clear();
		type(enterTextInframe, Description, "Description");
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, AdditionalDetails, "AdditionalDetails");
		driver.switchTo().defaultContent();

		type(this.Location, Location, "Location");
		type(this.reMarks, reMarks, "reMarks");
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		click(Update, "Update");
		Thread.sleep(2000);
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);

	}

	public void inActivateJob(String Title) throws Exception {
		waitForElementToPresent(searchWithJobTitle);
		type(searchWithJobTitle, Title, "Title");
		click(btnSearch, "Search");
		Thread.sleep(7000);
		waitForElementToPresent(Edit);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		click(InActive, "InActive");
		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
	}
	public void ActivateJob(String Title2) throws Exception {
		waitForElementToPresent(searchWithJobTitle);
		type(searchWithJobTitle, Title2, "Title");
		click(btnSearch, "Search");
		Thread.sleep(7000);
		waitForElementToPresent(Edit);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		click(Active1, "InActive");
		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
	}
	
	
	public HomePage logout() throws InterruptedException {
		Thread.sleep(2000);
		click(angleDown, "Community Admin Menu Drop down");
		waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}
	public void cancelWithoutSavingJob(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {

		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		type(this.JobTitle, jobTitle, "JobTitle");

	
		selectByVisibleText(this.BillingRate, billingRate,"billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID,"jobTypeID");
		type(this.Location, location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, additionalDetails, "Additional Details");
		driver.switchTo().defaultContent();
		//if (makeGlobal.equalsIgnoreCase("Yes")) {
		click(this.makeGlobal, "makeGlobal");
		//}
		click(Active, "Active");
		type(reMarks, remarks, "reMarks");
		click(cancelBtn, "Cancel");
		waitForElementToPresent(this.discardMsg);
		System.out.println(discardMsg.getText());
        Assert.assertTrue(true);
		

	}
	public void cancelEmptyJobPost() {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		click(cancelBtn, "Cancel");
		if(discardMsgs.size()>0) {
			Assert.assertTrue(false);
		}else Assert.assertTrue(true);	
		
	}
	
	public void checkCommunityOrder() {
		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle );
		System.out.println(communitiesDropDown.getText());
	}
	public void updateByTA(String jobTitle,String Jtitle,String location) throws InterruptedException {
		waitForElementToPresent(this.searchWithJobTitle);
		type(this.searchWithJobTitle, jobTitle, "JobTitle");	
		//seraching job created by CA
		click(btnSearch, "Search");
		Thread.sleep(2000);
		click(Edit,"Edit");
		type(JobTitle, Jtitle, "JobTitle");		
		type(Location,location, "Location");		
		click(Update,"Update job post");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
		
	}
	public void searchByJobTitle(String JobTitle,String Location,String JobTypeID,String Status) throws InterruptedException {
		waitForElementToPresent(this.searchWithJobTitle);
		type(this.searchWithJobTitle, JobTitle, "JobTitle");		
		CheckSearchResult(this.totalJobResult,JobTitle);
		this.searchWithJobTitle.clear();
		Thread.sleep(4000);
		waitForElementToPresent(this.searchByLocation);
		type(this.searchByLocation, Location, "Location");		
		CheckSearchResult(this.totalJobLocationResult,Location);
		this.searchByLocation.clear();
		Thread.sleep(4000);
		waitForElementToPresent(this.SearchJobTypeID);
		selectByVisibleText(this.SearchJobTypeID,JobTypeID , "JobType");		
		CheckSearchResult(this.totalJobtypeIDResult,JobTypeID);
		selectByVisibleText(this.SearchJobTypeID, "Search by Job Type","Search job id ");
		Thread.sleep(4000);
		waitForElementToPresent(this.SearchByStatus);
		selectByVisibleText(this.SearchByStatus, Status, "Status");		
		CheckSearchResult(this.totalJobStatusResult,Status);
		selectByVisibleText(this.SearchByStatus, Status,"Status");
		
		/*System.out.println(totalJobResult.size());
		for(int i =0;i<totalJobResult.size();i++) {
			 String elementText = totalJobResult.get(i).getText(); 
			 System.out.println("value of jobsearch:"+elementText);
			 Assert.assertEquals(JobTitle,elementText);
			}*/
		
		
		
		/*type(this.searchByLocation,Location,"Location");
		click(btnSearch, "Search");
		Thread.sleep(3000);
		String Loc=locationSearch.getText();
		System.out.println(Loc);
		Assert.assertEquals(Location.toLowerCase(), Loc.toLowerCase());		
		searchByLocation.clear();
		Thread.sleep(2000);
		
		selectByVisibleText(this.SearchJobTypeID, JobTypeID,"JobTypeID");
		click(btnSearch, "Search");
		Thread.sleep(3000);
		WebElement jobSearch= driver.findElement(By.xpath("//td[normalize-space()='Part Time']"));
		String jobSear=jobSearch.getText();
		System.out.println(jobSear);
		System.out.println(JobTypeID);
		Assert.assertEquals(JobTypeID, jobSear);
		selectByVisibleText(this.SearchJobTypeID, "Search by Job Type","Search job id ");
		Thread.sleep(3000);
		
		selectByVisibleText(this.SearchByStatus, Status,"Status");
		click(btnSearch, "Search");
		Thread.sleep(3000);
		*/
		
		
	}
	public void CheckSearchResult(List<WebElement> totalJobResult, String controlValue) throws InterruptedException {
		click(btnSearch, "Search");
		Thread.sleep(8000);
		System.out.println(totalJobResult.size());
		/*for(int i =0;i<totalJobResult.size();i++) {
			 String elementText = totalJobResult.get(i).getText(); 
			 //System.out.println("value of jobsearch:"+elementText);
			 Assert.assertEquals(controlValue.toLowerCase(),elementText.toLowerCase());
			}*/
		
		
	}
}
