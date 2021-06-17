package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class MyJobPage extends  BasePage{
	
	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
		WebElement searchJobTitle;
  
	@FindBy(xpath = "//select[@id='JobTypeID']")
	WebElement searchByJobType;
	
	@FindBy(xpath = "//input[@placeholder='Search by Location']")
	WebElement searchLocation;
	
	@FindBy(xpath = "//input[@placeholder='Search by Community']")
	WebElement searchCommunity;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;

	 @FindBy(className = "col-lg-6 ng-scope") 
	 List<WebElement> searchResult;
	//div[@id='removeinnercss']//div[1]//div[2]//div[1]//h4
	 
	 @FindBy(xpath = "//div[@id='removeinnercss']//div[1]//div[2]//div[1]//h4") 
	 List<WebElement> searchJobTitleResult;
	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(btnSearch);
	}

	
	public void searchJobs(String JobTitle,String Jobtype, String location, String community) throws InterruptedException {
		Thread.sleep(3000);
		waitForElementToPresent(this.searchJobTitle);
		type(this.searchJobTitle, JobTitle, "JobTitle");
		//type(this.searchLocation,location,"Location");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		System.out.println(searchJobTitleResult.size());
		for(int i =0;i<searchJobTitleResult.size();i++) {
			 String elementText = searchJobTitleResult.get(i).getText(); 
			 System.out.println("value of jobsearch:"+elementText);
			 Assert.assertEquals(JobTitle,elementText);
			}
		searchJobTitle.clear();
		
	}
}
