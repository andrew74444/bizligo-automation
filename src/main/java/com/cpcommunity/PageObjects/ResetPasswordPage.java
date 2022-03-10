package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ResetPasswordPage extends BasePage{
	
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@FindBy(xpath = "//input[@name='Password']")
	WebElement Password;

	@FindBy(xpath = "//input[@name='ConfirmPassword']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	WebElement Reset;

	@FindBy(xpath = "//li[contains(text(),'The link is already expired or already been used.')]")
	WebElement Expired;

	@FindBy(xpath = "//input[@name='Email']")
	WebElement Email;

	@FindBy(xpath = "//p[contains(text(),'Your password has been reset successfully.')]")
	WebElement resetSuccessful;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(Password);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public void enterDetails(String Email, String Password, String ConfirmPassword) {
		//ResetPasswordPage
	//	String EMail = this.Email.getText();
	//	AssertionHelper.verifyText(EMail, Email);
		type( this.Password, Password,"Password");
		type( this.ConfirmPassword, ConfirmPassword,"Confirm Password");
		
		click( Reset,"Reset");

	}

	public ResetPasswordConfirmation resetPassword(String Email, String Password, String ConfirmPassword) {

		this.enterDetails(Email, Password, ConfirmPassword);
		return (ResetPasswordConfirmation) openPage(ResetPasswordConfirmation.class);
//		new ResetPasswordConfirmation(driver, );

	}

	public void Expired(String Email, String Password, String ConfirmPassword) {

		this.enterDetails(Email, Password, ConfirmPassword);
		waitForElementToPresent(Expired);

	}
	
	
}
