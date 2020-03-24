package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ManageApplications extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
	
	@FindBy(xpath="//button[@id='btnSearch']")
	WebElement btnSearch;
	
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
	
	@FindBy(xpath = "//*[@type='submit']")
    WebElement update;	
	
	@FindBy(xpath = "//td[contains(text(),'Candidate Name:')]")
	WebElement CandidateName;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
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
		AssertionHelper.verifyText(toastMessage.getText(), "Job application updated.");
		Thread.sleep(7000);
		
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
}
