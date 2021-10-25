package com.cpcommunity.PageObjects;



import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class MyJobsPage extends BasePage {
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(SearchBtn);
		
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//input[@ng-model='data.MyJobsDataObj.JobName']")
	WebElement searchByjobTitle;
	@FindBy(xpath =  "//select[@ng-model='data.MyJobsDataObj.JobTypeId']")
	WebElement serchByJobType;
	@FindBy(xpath = "//input[@ng-model='data.MyJobsDataObj.Location']")
	WebElement serchBLocation;
	@FindBy(xpath =  "//input[@ng-model='data.data.MyJobsDataObj.CommunityName']")
	WebElement serchByCommunity;		
	@FindBy(xpath = "//button[contains(@ng-click,'data.SearchJobs()')]")
	WebElement SearchBtn;
	@FindBy(xpath = "//button[contains(@ng-click,'data.ResetJobs()')]")
	WebElement ResetBtn;


	@FindBy(xpath = "//button[normalize-space()='View']")
	WebElement view;

	
	@FindBy(xpath = "(//div[@class='Job-title']//h4)")
	List<WebElement> totalJobTitleResult;
	@FindBy(xpath = "(//div[@class='job-location']//span[@class='ng-binding'])")
	List<WebElement> totalJobLocationResult;
	@FindBy(xpath = "(//div[@class='col-lg-6 col-xs-6 text-left job-type']//em)")
	List<WebElement> totalJobTypeResult;
	@FindBy(xpath = "(//div[@class='col-lg-6 col-xs-6 text-right']")
	List<WebElement> totalJobs;

		

	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement angleDown;
	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
	WebElement searchJobTitle;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//h5[contains(text(),'Last Updated Date:')]")
	WebElement jobUpdates;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	 @FindBy(xpath = "//div[@id='removeinnercss']//div[1]//div[2]//div[1]//h4") 
	 List<WebElement> searchJobTitleResult;

	
	
	

	public void searchJob(String jobTitle, String Location, String jobTypeID,
			String Community ) throws InterruptedException {
		
		waitForElementToPresent(this.searchByjobTitle);
		type(this.searchByjobTitle, jobTitle, "JobTitle");		
		CheckSearchResult(this.totalJobTitleResult,jobTitle);
		this.searchByjobTitle.clear();
		
		waitForElementToPresent(this.serchBLocation);
		type(this.serchBLocation, Location, "location");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJobLocationResult,Location);
		this.serchBLocation.clear();
		
		waitForElementToPresent(this.serchByJobType);
		selectByVisibleText(this.serchByJobType, jobTypeID, "JobTypeID");
		Thread.sleep(2000);
		CheckSearchResult(this.totalJobTypeResult,jobTypeID);
		Thread.sleep(2000);
		selectUsingIndex(this.serchByJobType,0,"JobTypeID");
		
		//waitForElementToPresent(this.serchByCommunity);
		//selectByVisibleText(this.serchByCommunity, Community, "Community");
		//CheckSearchResult(this.totalJobResult,Community);
		//selectUsingIndex(this.serchByCommunity,0,"Community");	
		
		click(ResetBtn, "Reset button");
		Thread.sleep(3000);
		
	}

		public void CheckSearchResult(List<WebElement> totalJobResult, String controlValue) throws InterruptedException {
			click(SearchBtn, "Search button");
			Thread.sleep(3000);
			System.out.println(totalJobResult.size());
			for(int j=0; j<totalJobResult.size(); j++) {
				String actualVal=(totalJobResult.get(j).getText());
				Assert.assertEquals(controlValue.toLowerCase(), actualVal.toLowerCase());
			}			
		}
		public void CheckJobs(List<WebElement> totalJobResult) {
			
		}
         public void ListOfJobs() {
        	 waitForElementToPresent(totalJobs);
        	 totalJobs.indexOf(totalJobs);

        	 
			
		}


    	


         public void FindappliedJobs(String Jobtitle) throws InterruptedException {
        	 waitForElementToPresent(searchByjobTitle);
        	type(searchByjobTitle, Jobtitle, "Job TItle");
        	click(SearchBtn, "Search button");
			Thread.sleep(3000);
			click(view, "View");
			waitForElementToPresent(jobUpdates);
		String Value=this.jobUpdates.getText();
			System.out.println(Value);
		}
         public String getSystemCurrentDate() {
     		Date date = new Date();
     		SimpleDateFormat formatter = new SimpleDateFormat("d");
     		String strDate = formatter.format(date);
     		return strDate;
     	}

		private void waitForElementToPresent(List<WebElement> totalJobs2) {
			// TODO Auto-generated method stub
			
		}

		

		public HomePage logout() {
			clickElementByJavaScript(angleDown);
			//click(angleDown, "Community Admin Menu Drop down");
			waitForElementToPresent(logout);
			click(logout, "logout");
			return (HomePage) openPage(HomePage.class);
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
		public void searchJob(String JobTitle) throws InterruptedException {
			Thread.sleep(3000);
			waitForElementToPresent(this.searchJobTitle);
			type(this.searchJobTitle, JobTitle, "JobTitle");
			//type(this.searchLocation,location,"Location");
			click(btnSearch, "Search");
			Thread.sleep(4000);
			System.out.println(searchJobTitleResult.size());
			for(int i =0;i<searchJobTitleResult.size();i++) {
				 String elementText = searchJobTitleResult.get(i).getText(); 
				 System.out.println("value of jobsearch:"+elementText);
				 Assert.assertEquals(JobTitle,elementText);
				}
			searchJobTitle.clear();
			
		}

}
