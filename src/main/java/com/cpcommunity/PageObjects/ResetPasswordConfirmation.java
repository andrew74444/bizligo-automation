package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;


public class ResetPasswordConfirmation extends BasePage{
	
	
	@FindBy(xpath="//p[contains(text(),'Your password has been reset successfully.')]")
	WebElement resetSuccessful;
		
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
//	public ResetPasswordConfirmation(WebDriver driver,String ) {
//		this.driver = driver;
//		this.=;
//		PageFactory.initElements(driver, this);
//		waitHelper = new WaitHelper(driver);
//		waitHelper.waitForElement(,ObjectReader.reader.getExplicitWait());
//		new TestBase().captureScreen(, driver);
//		TestBase.logExtentReport("Reset Password Confirmation Object Created");
//		
//	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(resetSuccessful);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
