package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;



public class MeetingAccountsPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}

	@FindBy(xpath = "//*[@class='fa fa-gear']")
	WebElement action;

	@FindBy(xpath = "//*[contains(text(),'Ok')]")
	WebElement OkBtn;

	@FindBy(xpath = "//*[@name='txtAPIKey']")
	WebElement txtAPIKey;

	@FindBy(xpath = "//*[@name='txtAPISecret']")
	WebElement txtAPISecret;
	@FindBy(xpath = "(//*[@name='EmailID'])[2]")
	WebElement EmailID;
	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement SaveBtn;
	                                                                        
	@FindBy(xpath = "//*[contains(text(),'Zoom meeting account set up successfully')]")
	WebElement setupsuccessfully;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAnAccount;
	@FindBy(xpath = "//*[@class='btn btn-success toggle-on']")
	WebElement activeBtn;

	@FindBy(xpath = "//*[@class='btn btn-danger active toggle-off']")
	WebElement inActiveBtn;

	@FindBy(xpath = "//*[contains(text(),'Update')]")
	WebElement Update;

	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		
		
		return ExpectedConditions.visibilityOf(action);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	@FindBy(xpath="//*[@class='swal-button-container']/*[text()='Ok']")//added on 06/04
	WebElement okBtn;
	public MeetingAccountsPage inActivateZoom() throws Exception {
		click(action,"action");//added on 06/04
		waitForElementToPresent(activeBtn);
		click(activeBtn,"activeBtn");
		Thread.sleep(500);
		click(Update,"Update");
		waitForElementToPresent(okBtn);//added on 06/04
		click(okBtn,"okBtn");//added on 06/04
		return (MeetingAccountsPage) openPage(MeetingAccountsPage.class);
//		new MeetingAccountsPage(driver, );

	}

	public MeetingAccountsPage activateZoom() throws Exception {
		click(action,"action");//added on 06/04
		waitForElementToPresent(inActiveBtn);
		click(inActiveBtn,"inActiveBtn");
		Thread.sleep(500);
		click(Update,"Update");
		waitForElementToPresent(okBtn);//added on 06/04
		click(okBtn,"okBtn");//added on 06/04
		return (MeetingAccountsPage) openPage(MeetingAccountsPage.class);
//				new MeetingAccountsPage(driver, );

	}
	public MeetingAccountsPage configureZoom(String APIKey, String APISecret, String EmailID) {
		waitForElementToPresent(action);
		click(action,"action");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"OkBtn");
		waitForElementToPresent(SaveBtn);
		
		type(txtAPIKey, APIKey, "txtAPIKey");
		type(txtAPISecret, APISecret, "txtAPISecret");
		type(this.EmailID, EmailID, "EmailID");
	
		click(SaveBtn,"SaveBtn");
		waitForElementToPresent(setupsuccessfully);
		click(OkBtn,"OkBtn");
		return (MeetingAccountsPage) openPage(MeetingAccountsPage.class);
//		new MeetingAccountsPage(driver, );
	}
	
}
