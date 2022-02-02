package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
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

import org.testng.Assert;

import java.io.File;
import java.util.List;


import org.apache.log4j.Logger;


import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ManageApplications extends BasePage{
	
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

	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement JobTitleName;
	
	@FindBy(xpath="//button[normalize-space()='Search']")

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

	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]/span[1]")
    WebElement edit;
	
	@FindBy(xpath = "//button[normalize-space()='Update']")
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

	@FindBy(xpath = "//input[@id='JobTitleSearch']")
	WebElement searchByJob;
	
	@FindBy(xpath = "//input[@id='JobTitleSearch']")
	WebElement searchWithJobTitle;
	

	@FindBy(xpath = "//input[@id='JobLocationSearch']")
	WebElement searchByLocation;
	
	@FindBy(xpath = "//a[normalize-space()='Download Resume']")
	WebElement downloadResume;
	
	@FindBy(id = "comment")
	WebElement reMarks;
	
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-pencil']")
	WebElement actionEdit;

	
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
		waitForElementToPresent(FirstRow);
		click(FirstRow,"FirstRow");
		waitForElementToPresent(CandidateName);		
		type(this.Remark,Remark,"Remark");	
		//Thread.sleep(2000);
		waitForElementToPresent(update);
		click(update,"update");		
		waitForElementToPresent(toastMessage);
		//Thread.sleep(3000);
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
	
	//click(btnReset, "Reset button");
	//Thread.sleep(3000);
	
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
		//Thread.sleep(3000);
		waitForElementToPresent(toastMessage);
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
		
		

	public void updateJob(String jobTitle, String remarks ) throws InterruptedException {
		waitForElementToPresent(searchByJob);
		type(searchByJob, jobTitle, "Job Title");
		click(btnSearch, "Search");
		waitForElementToPresent(edit);
		click(edit, "Edit");
		waitForElementToPresent(Remark);
		type(Remark, remarks, "Remarks");
		click(update, "Updates");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		//Thread.sleep(7000);
		
	}
	public void searchByJobTitle1(String JobTitle,String Location) throws InterruptedException {
		type(this.searchWithJobTitle, JobTitle, "JobTitle");
		type(this.searchByLocation,Location,"Location");
		click(btnSearch, "Search");
		Thread.sleep(3000);
		//List <WebElement> col=driver.findElements(By.xpath("//*[@id=\"manageJobsTable\"]/thead/tr/th[3]"));
	    List <WebElement> col=driver.findElements(By.xpath("//*[@id=\"manageJobsTable\"]/thead/tr/th"));
		System.out.println("The number of columns are: "+ col.size());
		 List <WebElement> row=driver.findElements(By.xpath("//*[@id=\"manageJobsTable\"]/tbody/tr/t[3]"));
		System.out.println("The number of rows are: "+ row.size());
			
		//AssertionHelper.verifyText(JobTitleName.getText(),JobTitle);
		picture();
	}
	public void searchByJobTitle(String JobTitle,String Location) throws InterruptedException {
		type(this.searchWithJobTitle, JobTitle, "JobTitle");
		type(this.searchByLocation,Location,"Location");
		click(btnSearch, "Search");
		Thread.sleep(6000);
		AssertionHelper.verifyText(JobTitleName.getText(),JobTitle);
		picture();
		String name=downloadResume.getAttribute("href");
		System.out.println("download 1"+downloadResume.getAttribute("href"));

		name =name.substring(name.lastIndexOf("/"));
		System.out.print("update file name" +name);
	    click(downloadResume,"download resume");
	    log.info("downloading resume");
	    Thread.sleep(10000);
	    //Task.Delay(5000).Wait();//wait for sometime till download is completed
	    String path = "C:\\Users\\rugup\\downloads";//the path of the folder where the file will be downloaded
	    
	    if (CheckFile(path,name))//we check if the directory or folder exists
	    {
	    	log.info("asserting whether file downloaded");
	    	Assert.assertTrue(true);
	    }
	                        
	        else
	        {
	        	log.info("asserting whether file not downloaded");
	            Assert.assertTrue(false);
	        }
	   
	}
	public boolean CheckFile(String path,String name) // the name of the zip file which is obtained, is passed in this method
	{
		log.info("Making string of file name and path");
		System.out.println(name);
	    String currentFile = path+"/"+name+"" ;
	    System.out.println(currentFile);
	    File f=new File(currentFile);
	    if (f.exists()) //helps to check if the zip file is present
	    { 
	    	log.info("checking size of file");
	    	if(f.length()>0 ){  
	    		DeleteFilesAndDirectory(f);
	    		return true; //if the zip file exists return boolean true
	    	}else {
	    		DeleteFilesAndDirectory(f);
	    		return false;
	    	}
	    }
	    else
	    {
	        return false; // if the zip file does not exist return boolean false
	    }
	}
	public void DeleteFilesAndDirectory(File f)
	{
	   
		    log.info("Deleting files");
	        f.delete(); //delete the downloaded zip file
	    
	}  
	public void updateApplicationByAdmin(String JobTitle,String Location,String reMarks) throws InterruptedException {
		type(this.searchWithJobTitle, JobTitle, "JobTitle");
		type(this.searchByLocation,Location,"Location");
		click(btnSearch, "Search");
		//Thread.sleep(6000);
		waitForElementToPresent(actionEdit);
		this.actionEdit.click();
		Thread.sleep(3000);
		type(this.reMarks,reMarks,"Remarks");
		click(update,"update");
		//Thread.sleep(2000);
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		Thread.sleep(7000);
		//AssertionHelper.verifyText(showingEntries.getText(), "Showing 1 to 1 of 1 entries");
	}

}

