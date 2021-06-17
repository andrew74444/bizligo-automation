package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;



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
	
	@FindBy(xpath = "//div[@class='form-group']//select[@id='JobTypeID']")
	WebElement SearchJobTypeID;
	
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement SearchByStatus;

	@FindBy(xpath = "//div[@class='col-sm-8']//input[@id='Location']")
	WebElement Location;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	WebElement Active;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement postBtn;

	@FindBy(xpath = "//span[contains(text(),'Update')]")
	WebElement Update;

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

	@FindBy(xpath = "//label[contains(text(),'In-Active')]")
	WebElement InActive;


	@FindBy(xpath = "//div[@class='form-group']//input[@id='Location']")
	WebElement searchByLocation;
	
	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'texas')]")
	WebElement locationSearch;
	
	
	@FindBy(xpath = "//div[@id='manageJobsTable_info']")
	WebElement showingEntries;
	
	 @FindBy(xpath = "//tbody/tr/td[3]")
	 List<WebElement> totalJobResult;
     
	 @FindBy(xpath = "//tbody/tr/td[4]")
	 List<WebElement> totalJobLocationResult;

	 @FindBy(xpath = "//tbody/tr/td[6]")
	 List<WebElement> totalJobtypeIDResult;

	 @FindBy(xpath = "//tbody/tr/td[12]")
	 List<WebElement> totalJobStatusResult;

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

	
	
	
	
	public CommunityDetailsPage navigateToCommunityDetailsPage(String name) {
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
		scrollToElement(ele);
		click(ele,"name");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
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
		click(postBtn, "post");

		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job posted.");
		Thread.sleep(7000);

	}
	
	public void searchByJobTitle(String JobTitle,String Location,String JobTypeID,String Status) throws InterruptedException {
		waitForElementToPresent(this.searchWithJobTitle);
		type(this.searchWithJobTitle, JobTitle, "JobTitle");		
		CheckSearchResult(this.totalJobResult,JobTitle);
		this.searchWithJobTitle.clear();
		
		waitForElementToPresent(this.searchByLocation);
		type(this.searchByLocation, Location, "Location");		
		CheckSearchResult(this.totalJobLocationResult,Location);
		this.searchByLocation.clear();
		
		waitForElementToPresent(this.SearchJobTypeID);
		selectByVisibleText(this.SearchJobTypeID,JobTypeID , "JobType");		
		CheckSearchResult(this.totalJobtypeIDResult,JobTypeID);
		selectByVisibleText(this.SearchJobTypeID, "Search by Job Type","Search job id ");
		
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
		Thread.sleep(5000);
		System.out.println(totalJobResult.size());
		for(int i =0;i<totalJobResult.size();i++) {
			 String elementText = totalJobResult.get(i).getText(); 
			 //System.out.println("value of jobsearch:"+elementText);
			 Assert.assertEquals(controlValue.toLowerCase(),elementText.toLowerCase());
			}
		
		
	}

	public void makeGlobalJob(String JobTitle, String makeGlobal) throws Exception {
		type(this.searchWithJobTitle, JobTitle, "JobTitle");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}

		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
	}

	public void UpdateJob(String JobTitle, String UpdateTitle, String BillingRate, String JobTypeID, String Location,
			String Description, String AdditionalDetails, String reMarks, String makeGlobal) throws Exception {

		type(this.searchWithJobTitle, JobTitle, "searchWithJobTitle");
		click(btnSearch, "Search");
		Thread.sleep(4000);
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
		/*driver.switchTo().frame(0);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();*/

		type(this.JobTitle, UpdateTitle, "JobTitle");
		Thread.sleep(3000);
		// DropDownHelper = new DropDownHelper(driver);
		selectByVisibleText(this.BillingRate, BillingRate,"BillingRate");
		selectByVisibleText(this.JobTypeID, JobTypeID,"JobTypeID");
		type(this.Location, Location, "Location");
		Thread.sleep(3000);

		driver.switchTo().frame(0);
		enterTextInframe.clear();
		Thread.sleep(3000);
		type(enterTextInframe, Description, "Description");
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		Thread.sleep(3000);
		type(enterTextInframe, AdditionalDetails, "AdditionalDetails");
		driver.switchTo().defaultContent();

		type(this.reMarks, reMarks, "reMarks");
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);

	}

	public void inActivateJob(String jobTitle) throws Exception {
		type(this.searchWithJobTitle, jobTitle, "searchWithJobTitle");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		click(Edit, "Edit");
		waitForElementToPresent(this.JobTitle);
		click(InActive, "InActive");
		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		Thread.sleep(7000);
	}

}
