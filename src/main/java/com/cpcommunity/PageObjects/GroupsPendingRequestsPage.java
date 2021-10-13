package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;



public class GroupsPendingRequestsPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	


	

	@FindBy(xpath="//input[@placeholder='Search by Group Name']")
	WebElement searchGroupName;
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement GroupName;
	
	@FindBy(xpath="//*[contains(text(),'Manage Pending Group Requests')]")
	WebElement ManagePendingGroupRequestsTitle;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(ManagePendingGroupRequestsTitle);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);	

	public void approveMember(String approveEmail) throws Exception {
		new ManageRequests(driver).approveRequest(approveEmail);		
	}

	public void rejectMember(String rejectEmail,String rejectReason) throws Exception {
		new ManageRequests(driver).rejectRequest(rejectEmail, rejectReason);
		
	}
	public void serachGroup(String Group) {
		waitForElementToPresent(searchGroupName);
		type(searchGroupName, Group, "Group");
		if(GroupName.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
}
