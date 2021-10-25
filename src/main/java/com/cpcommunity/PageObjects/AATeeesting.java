package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AATeeesting extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(CreateCommunityBtn);
	}
	
	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}

	@FindBy(xpath = "//button[normalize-space()='Create Community']")
	WebElement CreateCommunityBtn;
	
	@FindBy(xpath = "")
	WebElement Test;
	
	@FindBy(xpath = "")
	WebElement test2;
	
	@FindBy(xpath = "")
	WebElement tesst3;
	
	@FindBy(xpath = "")
	WebElement test4;
	
	
}
