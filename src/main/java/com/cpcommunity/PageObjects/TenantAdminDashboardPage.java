package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class TenantAdminDashboardPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(PageTitle);
		return ExpectedConditions.visibilityOf(PageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h3[normalize-space()='Tenant Admin Dashboard']")
	WebElement PageTitle;
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement ImportContacts;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Campaign Template']")
	WebElement campaignTemplate;
	@FindBy(xpath="//a[normalize-space()='Manage Resources']")
	WebElement manageresource;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	@FindBy(xpath="//a[@title='Go to Member site home']")
	WebElement bizligoBtn;
	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Jobs'])")
	WebElement ManageJobs;
    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/Jobs/Jobs-active.png'])/..)/..)")
	WebElement Jobs;
    @FindBy(xpath = "//a[@title='Manage Applications']")
	WebElement ManageApplication;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]")
	WebElement totakJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]//div[1]//div[2]")
   	WebElement totakJobscounts;
    @FindBy(xpath = "//a[@href='/eventmanager/jobs/index/inactive']")
   	WebElement totakinactiveJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[2]//div[1]//div[2]")
    WebElement totakInactiveJobscounts;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]")
   	WebElement totakJobsapplication;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]//div[1]//div[2]")
    WebElement totakjobsapplicationcounts;
    @FindBy(xpath = "//a[@href='/eventmanager/jobs/index/active']")
   	WebElement activeJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[1]//div[1]//div[2]")
    WebElement activejobscounts;
  
  
   
    
    
	 public ManageApplications navigateToManageApplication() {
			scrollDownVertically();
			scrollToElement(Jobs);
			click(Jobs, "Jobs");
			waitForElementToPresent(ManageApplication);
			click(ManageApplication, "ManageJobs");
			return (ManageApplications) openPage(ManageApplications.class);
			// new ManageJobs(driver);
		}
	 public ManageJobsPage navigateToManageJobsPage() {
			scrollDownVertically();
			scrollToElement(Jobs);
			click(Jobs, "Jobs");
			waitForElementToPresent(ManageJobs);
			click(ManageJobs, "ManageJobs");
			return (ManageJobsPage) openPage(ManageJobsPage.class);
			// new ManageJobs(driver);
		}
public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(composeCampaign);
	this.composeCampaign.click();	
	//click(composeCampaign, "composeCampaign");
	return (ComposeCampaign) openPage(ComposeCampaign.class);
	
}
public ImportContactsPage navigateToImportContactsPagePage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(ImportContacts);
	this.ImportContacts.click();	
	//click(composeCampaign, "composeCampaign");
	return (ImportContactsPage) openPage(ImportContactsPage.class);
	
}
public CampaignTemplatePage navigateToCampaignTemplate() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(campaignTemplate);
	this.campaignTemplate.click();	
	//click(composeCampaign, "composeCampaign");
	return (CampaignTemplatePage) openPage(CampaignTemplatePage.class);
	
}
public ManageResourcesPage navigateToManageResourcesPage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageresource);
	click(manageresource, "manageresource");
	return (ManageResourcesPage) openPage(ManageResourcesPage.class);
	
}
public HomePage goToHomePage() {
	 
	click(bizligoBtn,"Bizligo button");
	
	return (HomePage) openPage(HomePage.class);

}
   public int TotalJobs() throws Exception {
	//boolean varExists = false;
	    scrollIntoView(totakJobs);
	    String C = totakJobscounts.getText();
        int TC=Integer.parseInt(C);
        System.out.println("Total count is " + TC);
		Assert.assertTrue(true);  
        return TC;
	
}
     public int TotalInactiveJobs() throws Exception {
	//boolean varExists = false;
	      scrollIntoView(totakinactiveJobs);
	      String C = totakInactiveJobscounts.getText();
          int TC=Integer.parseInt(C);
          System.out.println("Total count is " + TC);
       	  Assert.assertTrue(true);  
	      return TC;	

}
     public int TotalJobsApplications() throws Exception {
    		//boolean varExists = false;
    		scrollIntoView(totakJobsapplication);
    		String C = totakjobsapplicationcounts.getText();
  	        int TC=Integer.parseInt(C);
  	        System.out.println("Total count is " + TC);
  			Assert.assertTrue(true);  
  	        return TC;
    		
    	}
     public int ActiveJobs() throws Exception {
 		//boolean varExists = false;
 		    scrollIntoView(activeJobs);
 		    String C = activejobscounts.getText();
	        int TC=Integer.parseInt(C);
	        System.out.println("Total count is " + TC);
			Assert.assertTrue(true);  
	        return TC;
 			
 		
 	}
}