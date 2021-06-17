package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class EndorsementPage extends BasePage{
	
	@FindBy(xpath = "//div[@id='myNavbar']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		//updateClass(pageheader, "navbar-fixed-top");
	}
	
		
	
	
	@FindBy(xpath="//div[contains(text(),'Endorsements')]")
	WebElement pageHeading;
	
	@FindBy(xpath="//*[contains(text(),'Reject')][1]")
	WebElement Reject;
	@FindBy(xpath="//*[contains(text(),'Approve')][1]")
	WebElement Approve;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageHeading);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
public EndorsementPage Approve(){
		
		//log.info("Clicking on Approve button....");
				
		click(this.Approve,"Approve");
		return (EndorsementPage) openPage(EndorsementPage.class);
//				new EndorsementPage(driver, TCID);
	}
	
	public boolean AcceptedToastMessage(){
		AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Accepted Successfully");
		if(SuccessPopup.getText().equalsIgnoreCase("Endorsement Accepted Successfully")){
			return true;
		}
		return false;
	}	
	
	public EndorsementPage Reject(){
		
		//log.info("Clicking on Reject button....");
				
		click(Reject,"Reject");
		return (EndorsementPage) openPage(EndorsementPage.class);
//		new (driver, TCID);
	}
	public boolean RejectedToastMessage()
	{
		
		AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Rejected Successfully");
		if(SuccessPopup.getText().equalsIgnoreCase("Endorsement Rejected Successfully")){
			return true;
		}
		return false;
	}
	
}
