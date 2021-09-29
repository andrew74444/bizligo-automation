package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RevenueReportPage extends BasePage {

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

	//
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Revenue Reports']")
	WebElement pageTitle;
	@FindBy(xpath = "//a[normalize-space()='Member Revenue Report']")
	WebElement memberrevenue;
	@FindBy(xpath = "//a[normalize-space()='Total Revenue Based On Time Period Report']")
	WebElement totaltimeperiodrevenue;
	@FindBy(xpath = "//div[@id='1626658164458-3-uiGrid-000E-cell']")
	WebElement johnRevenue;
	@FindBy(xpath = "//div[@id='1626658164458-3-uiGrid-000E-cell']")
	WebElement tablechart;
	
	
	
	
	public TotalRevenueReport goToTotalReport() throws InterruptedException {
		Thread.sleep(6000);
		waitForElementToPresent(totaltimeperiodrevenue);
		click(totaltimeperiodrevenue, "Revenue");
       Thread.sleep(6000);
		return (TotalRevenueReport) openPage(TotalRevenueReport.class);	
	}
	public MemberRevenueReport goTomemberReport() throws InterruptedException {
		Thread.sleep(10000);
		waitForElementToPresent(memberrevenue);
		click(memberrevenue, "Revenue");
        Thread.sleep(2000);
		return (MemberRevenueReport) openPage(MemberRevenueReport.class);	
	}
}
