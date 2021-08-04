package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminLogin extends BasePage 
{
	@FindBy(xpath = "//h4[contains(text(),'Login to')]")
	WebElement login;

	@FindBy(xpath = "//*[@placeholder='Email Address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@name='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
	WebElement LoginBtn;
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(login);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	public AdminPage adminloginToApplication(String emailAddress, String password) throws InterruptedException 
	{
		Thread.sleep(5000);
		type(this.emailAddress, emailAddress, "email address");
		type(this.password, password, "password");
		click(LoginBtn, "Login");
		return (AdminPage) openPage(AdminPage.class);
		
	}
	public superAdminDashboardPage superAdminloginToApplication(String emailAddress, String password) throws InterruptedException 
	{
		Thread.sleep(5000);
		type(this.emailAddress, emailAddress, "email address");
		type(this.password, password, "password");
		click(LoginBtn, "Login");
		return (superAdminDashboardPage) openPage(superAdminDashboardPage.class);
		
	}



	




	

}
