package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class ManageRequests extends BasePage{
	
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return ExpectedConditions.visibilityOf(crm);
//	}
	
	public ManageRequests(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//*[@type='search']")
	WebElement memberSearch;	
	
	@FindBy(xpath="//td[contains(@class,'select-checkbox')]")
	WebElement selectCheckBox;
	
	@FindBy(xpath="//*[contains(text(),'Approve')]")
	WebElement Approve;
	
	@FindBy(xpath="//*[contains(text(),'Reject')]")
	WebElement Reject;	
	
	@FindBy(xpath="//*[@id='rejectReason']")
	WebElement rejectReason;
	
	@FindBy(xpath="(//button[contains(.,'Yes, Proceed')])[2]")
	WebElement ApproveYesProceed;
	
	@FindBy(xpath="(//button[contains(.,'Yes, Proceed')])[1]")
	WebElement RejectYesProceed;
	@FindBy(xpath="//button[contains(.,'Ok')]")
	WebElement OkBth;

	
	public void approveRequest(String email) throws Exception {
	//	Thread.sleep(2000);
	//	memberSearch.clear();
		type(memberSearch, email,"Searching in member to Approve");
		Thread.sleep(5000);
		click(selectCheckBox,"selectCheckBox");
		Thread.sleep(500);
		click(Approve,"Approve");
		waitForElementToPresent(ApproveYesProceed);
	//	click(ApproveYesProceed,"Yes Proceed");
		clickElementByJavaScript(ApproveYesProceed);
		waitForElementToPresent(OkBth);
		click( OkBth,"Yes, Proceed");
		Thread.sleep(3000);
	}
	
	
	public void rejectRequest(String email, String rejectReason) throws Exception {
	//	Thread.sleep(2000);
	//	memberSearch.clear();
		type(memberSearch, email,"Searching in member to reject");
		Thread.sleep(5000);
		click(selectCheckBox,"selectCheckBox");
		Thread.sleep(500);
		click(Reject,"Reject");
		waitForElementToPresent(RejectYesProceed);
		type(this.rejectReason, rejectReason,"Reject for Reason");
	//	click(RejectYesProceed,"Yes Proceed");
		clickElementByJavaScript(RejectYesProceed);
		Thread.sleep(2000);
		waitForElementToPresent(OkBth);
		click( OkBth,"Yes, Proceed");
		Thread.sleep(4000);
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
