package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TA_DashboardPage extends BasePage{

	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(TADashboard);
	}

	
	 @FindBy(xpath="//h3[normalize-space()='Tenant Admin Dashboard']")
	 WebElement TADashboard;
	 
	 @FindBy(xpath="//a[@title='Go to Member site home']")
	 WebElement bizligoBtn;
	 
	
	 
	 public HomePage goToHomePage() {
		 
			click(bizligoBtn,"Bizligo button");
			
			return (HomePage) openPage(HomePage.class);
		
	 }
	 
	 
	 
	 
	 
	 
	
	
}
