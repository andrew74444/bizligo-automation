package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		enterTextInframe.sendKeys(Description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(AdditionalDetails);
		driver.switchTo().defaultContent();

		type(this.Location, Location, "Location");
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
