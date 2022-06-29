package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MemberRevenueReport extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Member Revenue Report']")
	WebElement pageTitle;
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	WebElement johnRevenue;
	@FindBy(xpath = "//i[@aria-label='Grid Menu']")
	WebElement menu;
	@FindBy(xpath = "//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0007']//div[@role='columnheader']//div//input[@aria-label='Filter for column']")
	WebElement membername;
	@FindBy(xpath = "//li[@id='menuitem-10']//button[@type='button']")
	WebElement email;
	
	public void checkRevenue(String member) throws InterruptedException {
		//Thread.sleep(8000);
		waitForElementToPresent(membername);
		type(membername, member, "Member Name");
		//Thread.sleep(8000);
		waitForElementToPresent(menu);
		click(menu, "Menu");
	//	Thread.sleep(1000);
		waitForElementToPresent(email);
		click(email, "email Id");
		waitForElementToPresent(menu);
		click(menu, "menu");
		String amt=johnRevenue.getText();
		System.out.println(amt);
	}
}
