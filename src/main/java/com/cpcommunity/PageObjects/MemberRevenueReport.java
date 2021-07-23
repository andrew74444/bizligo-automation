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
	@FindBy(css = "div[id='1627000972293-2-uiGrid-000D-cell'] div[class='ui-grid-cell-contents ng-binding ng-scope']")
	WebElement johnRevenue;
	
	public void checkRevenue() throws InterruptedException {
		Thread.sleep(6000);
		String amt=johnRevenue.getText();
		System.out.println(amt);
	}
}
