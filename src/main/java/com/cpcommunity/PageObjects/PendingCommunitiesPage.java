package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class PendingCommunitiesPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
	
	@FindBy(xpath="//h2[contains(text(),'Pending Communities')]")
	WebElement pendingCommunitiesHeader;
	
	
	@FindBy(xpath="//input[@id='NameSearch']")
	WebElement NameSearch;
	
	@FindBy(xpath="//button[@id='btnSearch']")
	WebElement btnSearch;
	
	@FindBy(xpath="//a[contains(text(),'View')]")
	WebElement Viewbtn;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement Name;
	
	@FindBy(xpath="//button[@id='btnReject']")
	WebElement btnReject;
	
	@FindBy(xpath="//button[@id='btnApprove']")
	WebElement btnApprove;
	@FindBy(xpath="//input[@id='rejectReason']")
	WebElement rejectReason;
	
	@FindBy(xpath="//div[@class='bootbox modal fade bootbox-confirm in']//div[@class='modal-footer']//button[2]")
	WebElement ApproveYesProceed;
	
	@FindBy(xpath="//form[@id='RejectCommunityRequestForm']//div[@class='modal-footer']//button[@type='submit']")
	WebElement rejectYesProceed;
	
	@FindBy(xpath="//*[contains(text(),'Ok')]")
	WebElement OkBtn;	

	
	@FindBy(xpath="//*[contains(text(),'There are no Communities available')]")
	WebElement noCommunitiesAvailable;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(pendingCommunitiesHeader);
	}
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	

	public void Searchcommmunity(String communityname ) throws Exception{
		
		type(this.NameSearch, communityname, "Name");
		click(btnSearch,"btn Search"); 
		Thread.sleep(7000);
		picture();
			
	}
	
	public void viewCommunityDetails() throws Exception
	{
		Thread.sleep(2000);
		click(Viewbtn,"View btn");
		waitForElementToPresent(Name);
	}
	
	
	public void rejectCommunity(String communityName, String rejectReason ) throws Exception{
		this.Searchcommmunity(communityName);
		this.viewCommunityDetails();
		
		clickElementByJavaScript(btnReject);
		waitForElementToPresent(this.rejectReason); 
		type(this.rejectReason, rejectReason,"Reject Reason");
		click(rejectYesProceed,"Yes Proceed"); 
		waitForElementToPresent(this.OkBtn);
		click( OkBtn,"Ok Btn");
		Thread.sleep(6000);
		picture();
//		new TestBase().captureScreen(rejectReason, driver);
		
	}
	
	public void approveCommunity(String communityName ) throws Exception{
		this.Searchcommmunity(communityName+" "+getDateInDDMMMYYYY());
		this.viewCommunityDetails();
		clickElementByJavaScript(btnApprove);	
		waitForElementToPresent(this.ApproveYesProceed);
		click(ApproveYesProceed,"Yes Proceed"); 
		waitForElementToPresent(this.OkBtn);
		click(OkBtn,"Ok Btn"); 
		Thread.sleep(6000);
		picture();
	}


	public void checkCommunityNotDisplayed(String communityName) throws Exception {
		 this.Searchcommmunity(communityName+" "+getDateInDDMMMYYYY());
		waitForElementToPresent(noCommunitiesAvailable);
	}
}
