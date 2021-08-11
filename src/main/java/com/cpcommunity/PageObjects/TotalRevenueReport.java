package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TotalRevenueReport extends BasePage{

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
	@FindBy(xpath = "//h2[normalize-space()='Total Revenue Report']")
	WebElement pageTitle;
	@FindBy(xpath = "//div[@class='col-sm-6 col-md-6']")
	WebElement adRevenue;
	
	
	public void checkTotalRevenuebasedOnTimePeriod() throws InterruptedException {
		//System.out.println("total");
		Thread.sleep(5000);
		//scrollDownByPixel(60);
		String amt=adRevenue.getText();
		System.out.println(amt);
		/*JavascriptExecutor jse = (JavascriptExecutor) driver;
	 	Object o = jse.executeScript("return document.tablechart.getAttribute('class')");
	 	String s = (String) o;
	 	System.out.println(s);*/
	 	
	}
	
	
	
	
	
	
	
}
