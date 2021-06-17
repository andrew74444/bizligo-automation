package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PublishedEventsPage extends BasePage {
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	@FindBy(xpath = "//a[@id='btnNewEvent']")
	WebElement Newbtn;
	

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	@FindBy(xpath="//a[@id='btnCopyEvent']")
	WebElement btncopy;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	WebElement chkSelect;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(Newbtn);
		return ExpectedConditions.visibilityOf(Newbtn);
	}
	public void  CopyEvents() {
		waitForElementToPresent(this.chkSelect);
		click(this.chkSelect, "Select");
		waitForElementToPresent(this.btncopy);
		click(this.btncopy, "Copy");
	}
	
}
