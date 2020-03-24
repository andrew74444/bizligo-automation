package com.cpcommunity.PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ChangePasswordPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	
	
	@FindBy(xpath="//input[@id='OldPassword']")
	WebElement OldPassword;
	
	@FindBy(xpath="//input[@name='NewPassword']")
	WebElement NewPassword;
	
	@FindBy(xpath="//input[@name='ConfirmPassword']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[contains(.,'Change password')]")
	WebElement Changepassword;
	

	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(OldPassword);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return (ZohoCRMPage) openPage(ZohoCRMPage.class);
//	}
	public void enterOldPassword(String OldPassword){
//		log.info("entering OldPassword...."+OldPassword);
//		logExtentReport("entering OldPasswords...."+OldPassword);		
		type(this.OldPassword, OldPassword, "OldPassword");
	}
	public void enterNewPassword(String NewPassword){
//		log.info("entering password...."+NewPassword);
//		logExtentReport("entering password...."+NewPassword);		
		type(this.NewPassword, NewPassword, "NewPassword");
	}
	public void enterConfirmPassword(String ConfirmPassword){
//		log.info("entering ConfirmPassword...."+ConfirmPassword);
//		logExtentReport("entering ConfirmPassword...."+ConfirmPassword);
		type(this.ConfirmPassword, ConfirmPassword, "Confirm Password");
	}
	
	
	public void clickOnChangepasswordBtn(){
//		log.info("clicked on Login Button...");
//		logExtentReport("clicked on Login Button...");		
		click(Changepassword, "Change password");
	}
	public LoginPage Changepassword(String OldPassword,String NewPassword, String ConfirmPassword){
		this.enterOldPassword(OldPassword);
		this.enterNewPassword(NewPassword);
		this.enterConfirmPassword(ConfirmPassword);
		
		this.clickOnChangepasswordBtn();
		return (LoginPage) openPage(LoginPage.class);
//		LoginPage(driver, TCID);		
	}
	
	
	
}
