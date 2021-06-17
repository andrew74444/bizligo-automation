package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;


import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;



public class ManageApplications<WebElements> extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	@FindBy(xpath = "//input[@id='JobLocationSearch']")
    WebElement Location;
	
	@FindBy(xpath = "//select[@id='IsActiveSearch']")
	WebElement JobByStatus;
	
	@FindBy(xpath = "//select[@id='JobtypeSearch']")
	WebElement JobTypeID;

	@FindBy(xpath = "//input[@id='JobTitleSearch']")
	WebElement JobTitle;

	@FindBy(xpath="//button[@id='btnSearch']")
	WebElement btnSearch;
	
	@FindBy(xpath="//button[@id='btnReset']")
	WebElement btnReset;
	
	@FindBy(xpath="//table[@id='manageApplicationTable']/tbody/tr[1]/td[2]")
	WebElement FirstRow;
	
	@FindBy(xpath="//table[@id='manageApplicationTable']/tbody/tr[2]/td[2]")
	WebElement secondRow;
	
	@FindBy(xpath = "//h2[contains(text(),'Job Application Details')]")
    WebElement JobApplicationDetails;
	
	@FindBy(xpath = "//textarea[@id='comment']")
    WebElement Remark;
	
	@FindBy(xpath = "//label[contains(text(),'Ignore')]")
    WebElement Ignore;
	
	@FindBy(xpath = "//label[contains(text(),'Accept')]")
    WebElement Accept;
	
	@FindBy(xpath = "//*[@type='submit']")
    WebElement update;	
	
	@FindBy(xpath = "//td[contains(text(),'Candidate Name:')]")
	WebElement CandidateName;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	
	@FindBy(xpath="//*[@id=\"manageApplicationTable\"]/tbody/tr/td[2]/a")
	WebElement editbtn;
	
	@FindBy(xpath = "//tbody/tr/td[3]")
	List<WebElement> totalJobtitleResult;
	@FindBy(xpath = "//tbody/tr/td[10]")
	List<WebElement> totalJoblocationResult;
	@FindBy(xpath = "//tbody/tr/td[4]")
	List<WebElement> totalJobtypeIDResult;
	@FindBy(xpath = "//tbody/tr/td[11]")
	List<WebElement> totalJobstatusResult;
	@FindBy(xpath = "//tbody/tr/td[7]/a")
	WebElement downloadresume;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(btnSearch);
		return ExpectedConditions.visibilityOf(btnSearch);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
public void AcceptApplication(String Remark) throws Exception {
		
		click(FirstRow,"FirstRow");
		waitForElementToPresent(CandidateName);		
		type(this.Remark, Remark,"Remark");		
		click(update,"update");		
		waitForElementToPresent(toastMessage);
		Thread.sleep(3000);
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		
		
	}
public void searchJob(String jobTitle, String Location, String jobTypeID,
		String Status ) throws InterruptedException {
	
	waitForElementToPresent(this.JobTitle);
	type(this.JobTitle, jobTitle, "JobTitle");		
	CheckSearchResult(this.totalJobtitleResult,jobTitle);
	this.JobTitle.clear();
	
	waitForElementToPresent(this.Location);
	type(this.Location, Location, "location");
	CheckSearchResult(this.totalJoblocationResult,Location);
	this.Location.clear();
	
	waitForElementToPresent(this.JobTypeID);
	selectByVisibleText(this.JobTypeID, jobTypeID, "JobTypeID");
	CheckSearchResult(this.totalJobtypeIDResult,jobTypeID);
	selectUsingIndex(this.JobTypeID,0,"JobTypeID");
	
	waitForElementToPresent(this.JobByStatus);
	selectByVisibleText(this.JobByStatus, Status, "Status");
	CheckSearchResult(this.totalJobstatusResult,Status);
	selectUsingIndex(this.JobByStatus,0,"Status");	
	
	click(btnReset, "Reset button");
	Thread.sleep(3000);
	
}

	public void CheckSearchResult(List<WebElement> totalJobResult, String controlValue) throws InterruptedException {
		click(btnSearch, "Search button");
		Thread.sleep(3000);
		System.out.println(totalJobResult.size());
		for(int j=0; j<totalJobResult.size(); j++) {
			String actualVal=(totalJobResult.get(j).getText());
			Assert.assertEquals(controlValue.toLowerCase(), actualVal.toLowerCase());
		}			
	}
	
	public void Ignore(String Remark) throws Exception {
		click(secondRow,"secondRow");
		waitForElementToPresent(CandidateName);		
		type(this.Remark, Remark,"Remark");	
		click(Ignore,"Ignore");
		click(update,"update");		
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		Thread.sleep(7000);
	}
	public void Edit() throws InterruptedException {
		click(editbtn, "Editbtn");
		waitForElementToPresent(update);	
		click(Accept,"Accept");
		click(update,"update");
		Thread.sleep(3000);
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		
		
	}
	public void ClickDownload(String folderpath) throws InterruptedException, URISyntaxException, MalformedURLException {
		waitForElementToPresent(downloadresume);
		click(downloadresume, "download Resume");
		Thread.sleep(3000);
		boolean isFileExists = false;
		
		String[] pathContents = downloadresume.getAttribute("href").split("/");
		String fileName = pathContents[pathContents.length-1];
		
		//URL urlpath = null;
		//urlpath= new URL(downloadresume.getAttribute("href"));
		//String folderpath= "C:\\Users\\sorat\\Downloads\\";
 		//String fileName = FilenameUtils.getName(urlpath.getPath());
		//String fileName = urlpath.getFile();
		 System.out.println("Folder path = " + folderpath);
		 System.out.println(" File= " + fileName);
		 File file = new File(folderpath + fileName);		
		 if (file.exists()) {
			isFileExists = true;
		    file.delete();
		}
		Assert.assertTrue(isFileExists);
	}
		
		
}

