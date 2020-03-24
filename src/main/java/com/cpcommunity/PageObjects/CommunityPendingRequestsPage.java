package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class CommunityPendingRequestsPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	 @FindBy(xpath="//*[contains(text(),'There are no pending requests')]")
	 WebElement thereAreNoPendingRequests;
	
	@FindBy(xpath="//*[contains(text(),'Approve')]")
	WebElement Approve;
	
	public void verifyNoPendingRequests() {
		thereAreNoPendingRequests.isDisplayed();
	}

	public void approveMember(String approveEmail) throws Exception {
		new ManageRequests(driver).approveRequest(approveEmail);
		
	}

	public void rejectMember(String rejectEmail,String rejectReason) throws Exception {
		new ManageRequests(driver).rejectRequest(rejectEmail, rejectReason);
		
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(Approve);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
