package com.cpcommunity.PageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;



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

	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
	WebElement SearchbyJobTitle;

	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement Searchbtn;

	@FindBy(xpath = "(//button[contains(text(),'View and Apply')])[1]")
	WebElement ViewandApply;

	@FindBy(xpath = "//button[@class='apply-success']")
	WebElement ApplyAlready;
	
	@FindBy(xpath = "//button[normalize-space()='Already Applied']")
	WebElement Applysuccess;

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

	

	// public HomePage(WebDriver driver,ExtentTest test) throws
	// IOException {
	

	public void verifyTheDetails(String JobTitle, String AdditionalDetails, String Remarks) {
		type(SearchbyJobTitle, JobTitle, "JobTitle");
		click(Searchbtn, "Searchbtn");
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
		type(SearchbyJobTitle, JobTitle, "JobTitle");
		click(Searchbtn, "Searchbtn");
		waitForElementToPresent(noResultsFound);
		picture();
	}

	public void searchJob(String jobTitle) {
		type(SearchbyJobTitle, jobTitle, "job Title");
		click(Searchbtn, "Searchbtn");
		waitForElementToPresent(CurrentJobOpenings);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + jobTitle + "')]"));
		waitForElementToPresent(ele);
		picture();
	}
    
	public void ApplyJobs() {
		scrollIntoView(ApplyAlready);
		waitForElementToPresent(ApplyAlready);
		click(ApplyAlready, "Apply Already");
		waitForElementToPresent(Applysuccess);
		if(Applysuccess.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		

		return ExpectedConditions.visibilityOf(CurrentJobOpenings);
	}

	// public void logExtentReport(String s1){
	// TestBase.test.log(Status.INFO, s1);
	// }

}