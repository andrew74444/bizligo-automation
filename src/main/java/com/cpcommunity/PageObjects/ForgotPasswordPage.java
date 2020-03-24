package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class ForgotPasswordPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
		
	
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement Submit;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(emailAddress);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);	

	public LoginPage SendForgotPasswordEmail(String emailAddress){		
		
		type(this.emailAddress, emailAddress, "Email");
		click(Submit,"Submit");
		return (LoginPage) openPage(LoginPage.class);
//		new LoginPage(driver);
	}
}
