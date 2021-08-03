package com.cpcommunity.PageObjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cpcommunity.utilities.DriverManager;


public class AdminHomePage extends BasePage 
{

	@FindBy(xpath = "//h4[contains(text(),'Login to')]")
	WebElement login;
	
	@FindBy(xpath = "(//a[contains(.,'Login')])[1]")
	WebElement LOGINBtn;
	@FindBy(xpath = "//img[@src='/Content/Images/connectpro_logo.png']")
	WebElement header;
	

	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(header);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	public AdminLogin navigateToAdminLogin() throws Exception
	{
		waitForElementToPresent(LOGINBtn);
		Thread.sleep(1000);
		click(LOGINBtn, "LOGIN");
		return (AdminLogin) openPage(AdminLogin.class);	
		
	}

	

	public AdminHomePage open(String url) {

		DriverManager.getDriver().navigate().to(url);
		System.out.println("Page Opened");
		return (AdminHomePage) openPage(AdminHomePage.class);
	}

}

