package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.apache.log4j.Logger;



import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class ManageJobsPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

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

    @FindBy(xpath = "//div[@class='form-group']//input[@id='Location']")
    WebElement searchByLocation;
    
    @FindBy(xpath = "//div[@id='manageJobsTable_info']")
    WebElement showingEntries;

	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement JobByStatus;
	
	@FindBy(xpath = "//select[@id='JobTypeID']")
	WebElement JobTypeID1;

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
	
	@FindBy(xpath = "//button[@id='btnReset']")
	WebElement btnReset;

	@FindBy(xpath = "//label[contains(text(),'In-Active')]")
	WebElement InActive;
	
	@FindBy(xpath = "//tbody/tr/td[3]")
	List<WebElement> totalJobtitleResult;
	@FindBy(xpath = "//tbody/tr/td[4]")
	List<WebElement> totalJoblocationResult;
	@FindBy(xpath = "//tbody/tr/td[6]")
	List<WebElement> totalJobtypeIDResult;
	@FindBy(xpath = "//tbody/tr/td[12]")
	List<WebElement> totalJobstatusResult;

	// input[@id,'JobTitle']

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
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]"));
		scrollToElement(ele);
		click(ele, "name");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}

	public void postJob(String jobTitle, String billingRate, String jobTypeID, String location, String description,
			String additionalDetails, String remarks, String makeGlobal) throws Exception {

		click(btnAddNewJob, "Add New Job");
		waitForElementToPresent(this.JobTitle);
		type(this.JobTitle, jobTitle, "JobTitle");

		selectByVisibleText(this.BillingRate, billingRate, "billingRate");
		selectByVisibleText(this.JobTypeID, jobTypeID, "jobTypeID");
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

	public void UpdateJob(String JobTitle, String BillingRate, String JobTypeID, String Location,
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

		//selectByVisibleText(this.BillingRate, "Select Job Billing Rate", "BillingRate");
		Thread.sleep(2000);
		selectByVisibleText(this.JobTypeID, "Select Job Type", "JobTypeID");

		/*driver.switchTo().frame(0);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();*/

		type(this.JobTitle, JobTitle, "JobTitle");
		// DropDownHelper = new DropDownHelper(driver);
		selectByVisibleText(this.BillingRate, BillingRate, "BillingRate");
		selectByVisibleText(this.JobTypeID, JobTypeID, "JobTypeID");

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
		waitForElementToPresent(toastMessage);
		Thread.sleep(3000);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		

	}
	
	public void EditJob(String JobTitle, String BillingRate, String Location,
			String Description, String AdditionalDetails, String reMarks, String makeGlobal) throws Exception {

		Thread.sleep(3000);
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

		driver.switchTo().frame(0);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		driver.switchTo().defaultContent();

		type(this.JobTitle, JobTitle, "JobTitle");
		// DropDownHelper = new DropDownHelper(driver);
		selectByVisibleText(this.BillingRate, BillingRate, "BillingRate");
		//selectByVisibleText(this.JobTypeID, JobTypeID, "JobTypeID");
		type(this.Location, Location, "Location");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		type(enterTextInframe, Description, "Description");
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, AdditionalDetails, "AdditionalDetails");
		driver.switchTo().defaultContent();

		
		type(this.reMarks, reMarks, "reMarks");
		if (makeGlobal.equalsIgnoreCase("Yes")) {
			click(this.makeGlobal, "makeGlobal");
		}
		click(Active, "Active");
		click(Update, "Update");
		waitForElementToPresent(toastMessage);
		Thread.sleep(3000);
		AssertionHelper.verifyText(toastMessage.getText(), "Job updated.");
		

	}

	public void searchJobs(String jobTitle,String location, String jobType, String Status) throws InterruptedException {

		scrollIntoView(searchByLocation);
		waitForElementToPresent(searchByLocation);
		//click(Location, "location");
		type(searchByLocation, location, "Search by location");
		// click(btnSearch, "search btn");
		Thread.sleep(1000);
	}

	public void searchByJobTitle1(String jobTitle) throws InterruptedException {

		scrollIntoView(searchWithJobTitle);
		waitForElementToPresent(searchWithJobTitle);
		type(searchWithJobTitle, jobTitle, "Search by Job Title");
		// click(btnSearch, "search btn");
		Thread.sleep(1000);
	}
	public void SelectJobTypeID(String jobType) throws InterruptedException {
		scrollIntoView(JobTypeID);
		waitForElementToPresent(JobTypeID);
		//click(JobTypeID, "JobTypeID");
		selectByVisibleText(this.JobTypeID, "Select Job Type", "JobTypeID");
		Thread.sleep(1000);
		//select.selectByIndex(2);
		// waitForElementToPresent(JobTypeID);
	}
		
		public void SelectJobByStatus(String Status) throws InterruptedException {
			//scrollIntoView(JobByStatus);
			waitForElementToPresent(JobByStatus);
			Select select1 = new Select(JobByStatus);
			selectByVisibleText(this.JobByStatus, "Select Job Status", "Status");
			Thread.sleep(1000);
			//select1.selectByIndex(1);
			click(btnSearch, "Search");
		
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

	public void searchJob(String jobTitle, String location, String jobTypeID,
			String Status ) throws InterruptedException {
		
		waitForElementToPresent(this.searchWithJobTitle);
		type(this.searchWithJobTitle, jobTitle, "JobTitle");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJobtitleResult,jobTitle);
		Thread.sleep(2000);
		this.searchWithJobTitle.clear();
		
		waitForElementToPresent(this.searchByLocation);
		type(this.searchByLocation, location, "location");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJoblocationResult,location);
		Thread.sleep(2000);
		this.searchByLocation.clear();
		
		waitForElementToPresent(this.JobTypeID1);
		selectByVisibleText(this.JobTypeID1,jobTypeID, "JobTypeID");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJobtypeIDResult,jobTypeID);
		Thread.sleep(2000);
		selectUsingIndex(this.JobTypeID1,0,"JobTypeID");
		Thread.sleep(2000);
		
		waitForElementToPresent(this.JobByStatus);
		selectByVisibleText(this.JobByStatus,Status, "Status");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJobstatusResult,Status);
		Thread.sleep(2000);
		selectUsingIndex(this.JobByStatus,0,"Status");	
		
		//click(btnReset, "Reset button");
		Thread.sleep(3000);
		
	}

		public void CheckSearchResult(List<WebElement> totalJobResult, String controlValue) throws InterruptedException {
			Thread.sleep(2000);
			click(btnSearch, "Search button");
			Thread.sleep(3000);
			System.out.println(totalJobResult.size());
			for(int j=0; j<totalJobResult.size(); j++) {
				String actualVal=(totalJobResult.get(j).getText());
				Thread.sleep(2000);
				Assert.assertEquals(controlValue.toLowerCase(), actualVal.toLowerCase());
			}			
		}
}
