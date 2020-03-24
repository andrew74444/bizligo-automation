package com.cpcommunity.PageObjects;
//package com.w2a.zoho.PageObjects;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.apache.log4j.Logger;
//
//import com.uiFramework.pamTen.cpcommunity.helper.wait.WaitHelper;
//
//public class ZoomMeeting extends BasePage{
//	
//	
//WaitHelper waitHelper;
//	
//	@FindBy(xpath="//h2[contains(text(),'Manage Meeting Accounts')]")
//	WebElement ManageMeetingAccounts;
//	
//	@FindBy(xpath="//i[@class='fa fa-gear']")
//	WebElement Action;
//	
//	@FindBy(xpath="//*[(contains(text(),'Ok'))]")
//	WebElement Ok;
//	
//	@FindBy(xpath="//*[@name='txtAPIKey']")
//	WebElement txtAPIKey;
//	
//	@FindBy(xpath="//*[@name='txtAPISecret']")
//	WebElement txtAPISecret;
//	
//	@FindBy(xpath="(//*[@name='EmailID'])[2]")
//	WebElement EmailID;
//	
//	
//		
//	
//	
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return ExpectedConditions.visibilityOf(ManageMeetingAccounts);
//	}	
//	
//	public void configureMeetingAccount() {
//		picture();
//		click(Action,"Action");
//		waitHelper.waitForElement(Ok,100);
//		picture();
//		click(Ok,"Ok");
//		waitHelper.waitForElement(Ok,100);
//				
//	}
//
//	
////	public ZohoCRMPage gotoCRM() {
////		
////		click(crm,"CRM Link");
////		return () openPage(.class);
////	}
////	
////	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
//	
//	
//}
