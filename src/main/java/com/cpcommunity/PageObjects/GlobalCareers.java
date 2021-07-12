package com.cpcommunity.PageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



/**
 * 
 * @author Sasi Vinod Akula
 */
public class GlobalCareers extends BasePage {

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@FindBy(xpath = "//*[contains(text(),'Current Job Openings')]")
	WebElement CurrentJobOpenings;

	@FindBy(xpath = "//*[contains(text(),'View and Apply')]")
	WebElement ViewandApply;
	@FindBy(xpath = "(//button[contains(text(),'View and Apply')])[1]")
	WebElement ViewandApply1;
	
	@FindBy(xpath = "//button[@class='apply-button']")
	List<WebElement> ViewandApplyLst;
	
	@FindBy(xpath = "//div[@id='careersController']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")
	WebElement ViewandApplyQA3;

	@FindBy(xpath = "//*[contains(text(),'Job Requirement Details')]")
	WebElement JobRequirementDetails;

	@FindBy(xpath = "//strong[@class='ng-binding']")
	WebElement JobTitle;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[1]")
	WebElement JobDescription;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[2]")
	WebElement AdditionalDetails;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[3]")
	WebElement Remarks;

	@FindBy(xpath = "//*[contains(text(),'no results found matching your search criteria.')]")
	WebElement noResultsFound;

	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
	WebElement searchByJobTitle;
	
	@FindBy(xpath = "//p[normalize-space()='No results found matching your search criteria']")
	WebElement NoJobFound;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	
	@FindBy(xpath = "//div[@class='job-cont']")
	WebElement searchResult;
	
	@FindBy(xpath = "//strong[normalize-space()='Remarks:']")
	List<WebElement> Remark;
	
	@FindBy(xpath = "//strong[normalize-space()='Additional Details:']")
	List<WebElement> additionalDetails;
	
	@FindBy(xpath = "//a[@href='#/career/48']")
	WebElement viewandApplySE;
	@FindBy(xpath = "//input[@placeholder='Search by Location']")
	WebElement Location;

	@FindBy(xpath = "//div[@class='ng-scope']")
	WebElement sorryMsg;
	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
	WebElement SearchbyJobTitle;

	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement Searchbtn;
	@FindBy(xpath = "//select[@id='JobTypeID']")
	WebElement JobTypeID;

	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement Apply;
	@FindBy(xpath = "//input[@id='Resume']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitBtn;
	@FindBy (xpath="//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//div[@infinite-scroll='data.LoadGlobalJobsOnScroll()']//div[1]//div[1]//div[3]//button[2]")
	WebElement AlreadyApplied;
	@FindBy(xpath = "//button[@class='apply-success']")
	WebElement AlreadyApplied1;
	
	@FindBy(xpath = "//button[@class='apply-success nocursorPoint']")
	WebElement AlreadyAppliedJobRequirement;
	
	// public HomePage(WebDriver driver,ExtentTest test) throws
	// IOException {
	

	public void verifyTheDetails(String JobTitle, String AdditionalDetails, String Remarks) {
		type(searchByJobTitle, JobTitle, "JobTitle");
		click(search, "Searchbtn");
		waitForElementToPresent(CurrentJobOpenings);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + JobTitle + "')]"));
		waitForElementToPresent(ele);
		click(ViewandApply, "ViewandApply");
		waitForElementToPresent(JobRequirementDetails);
		AssertionHelper.verifyText(this.JobTitle.getText(), JobTitle);
		AssertionHelper.verifyText(this.AdditionalDetails.getText(), AdditionalDetails);
		AssertionHelper.verifyText(this.Remarks.getText(), Remarks);
		picture();
	}

	public void verifyNoResultsFound(String JobTitle) {
		type(searchByJobTitle, JobTitle, "JobTitle");
		click(search, "Searchbtn");
		waitForElementToPresent(noResultsFound);
		picture();
	}

	public void searchJob(String jobTitle) {
		type(searchByJobTitle, jobTitle, "job Title");
		click(search, "Searchbtn");
		waitForElementToPresent(CurrentJobOpenings);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + jobTitle + "')]"));
		waitForElementToPresent(ele);
		picture();
	}
public void JobNotDisplayed(String Title1) throws InterruptedException {
		
		waitForElementToPresent(searchByJobTitle);
		type(searchByJobTitle,Title1 , "Job TItle");
		click(search, "Search button");
		Thread.sleep(2000);
		if(NoJobFound.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
public void JobDisplayed(String Title1) {
		
		waitForElementToPresent(searchByJobTitle);
		type(searchByJobTitle,Title1 , "Job TItle");
		click(search, "Search button");
		if(searchResult.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
public void CheckAdditionaltitleAndRemarkNotDisplaying(String Title1) throws InterruptedException {
	waitForElementToPresent(searchByJobTitle);
	type(searchByJobTitle, Title1, "Software Engineer");
	click(search, "Search");
	Thread.sleep(2000);
    scrollIntoView(ViewandApply);
    clickElementByJavaScript(ViewandApply);
	//click(ViewandApply, "View and Apply");
	Thread.sleep(4000);
	//Assert.assertEquals(0, Remark.size());
	//Assert.assertEquals(0, additionalDetails.size());
	System.out.println("Additional details And Remarks is not  displaying");
}
	
	public LoginPage viewAndApply() throws InterruptedException {
	waitForElementToPresent(ViewandApply);
	clickElementByJavaScript(ViewandApply);
		//click(ViewandApply, "Apply");
		
		return (LoginPage) openPage(LoginPage.class);
	}
	public void searchJobWhenNotGlobal(String jobTitle,String location) {
		type(SearchbyJobTitle, jobTitle, "job Title");
		type(Location, location, "location");		
		click(Searchbtn, "Searchbtn");
		waitForElementToPresent(sorryMsg);
		System.out.println(sorryMsg.getText());	
		AssertionHelper.verifyTrue(this.sorryMsg.getText().contains("Sorry!"));
		
		picture();
	}
	public void applyToJob(String path) throws InterruptedException {
		clickElementByJavaScript(ViewandApply1);
		//click(ViewandApply1, "ViewandApply");
		waitForElementToPresent(Apply);
		click(Apply, "Apply");
		chooseFile.sendKeys(path);
		Thread.sleep(1000);
		click(submitBtn,"submit");
		Thread.sleep(3000);
		System.out.println(SuccessPopup.getText());
		}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		

		return ExpectedConditions.visibilityOf(CurrentJobOpenings);
	}
	public void searchJobAlreadyApplied(String jobTitle,String jobType,String Location) {
		type(SearchbyJobTitle, jobTitle, "job Title");
		
		selectByVisibleText(this.JobTypeID, jobType,"JobTypeID");
		type(this.Location, Location, "Location");
		click(Searchbtn, "Searchbtn");
		waitForElementToPresent(CurrentJobOpenings);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + jobTitle + "')]"));
		waitForElementToPresent(ele);
		picture();
		clickElementByJavaScript(AlreadyApplied1);
		//click(AlreadyApplied1, "AlreadyApplied");
		waitForElementToPresent(JobRequirementDetails);		
		click(AlreadyAppliedJobRequirement, "AlreadyApplied");
		AssertionHelper.verifyText(this.AlreadyAppliedJobRequirement.getText(),"AlreadyApplied");
		clickElementByJavaScript(AlreadyAppliedJobRequirement);
		//JavascriptExecutor ex=(JavascriptExecutor)driver;
		//ex.executeScript("arguments[0].click()",AlreadyAppliedJobRequirement );
		boolean val=AlreadyAppliedJobRequirement.isSelected();
		System.out.println(val);
		//Assert.assertEquals(true, val);
		//String Attribute=AlreadyAppliedJobRequirement.getAttribute("class");
		//System.out.println(Attribute);
		//AssertionHelper.
	}
	public void searchJobGlobal(String jobTitle,String jobType,String Location) {
		type(SearchbyJobTitle, jobTitle, "job Title");
		
		selectByVisibleText(this.JobTypeID, jobType,"JobTypeID");
		type(this.Location, Location, "Location");
		click(Searchbtn, "Searchbtn");
		waitForElementToPresent(CurrentJobOpenings);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + jobTitle + "')]"));
		waitForElementToPresent(ele);
		picture();
	}
	// public void logExtentReport(String s1){
	// TestBase.test.log(Status.INFO, s1);
	// }

}