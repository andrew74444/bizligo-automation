package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class SATestimonials extends BasePage {
	@FindBy(xpath="//a[contains(text(),'Testimonials')]")
	WebElement Testimonials1;
	
	@FindBy(xpath= "//input[contains(@type,'search')]")
	WebElement Search;
	
	@FindBy(xpath = "//h2[contains(text(),'Websit')]")
	WebElement websiteTestimonial;
	
	@FindBy(xpath = "//*[@id=\"row_19\"]/td[2]/a")
	WebElement approved;
	
	@FindBy(xpath = "//*[@id=\"row_19\"]/td[2]/a")
	WebElement rejected;
	
	@FindBy(xpath = "//select[@id='StatusID']")
	WebElement statusID;
	
	@FindBy(xpath = "//input[contains(@name,'Notes')]")
	WebElement notes;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;
	
	@FindBy(xpath = "//body/div/div/div/div/nav/div/ul/li/a[1]")
	WebElement menu;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(websiteTestimonial);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	public void searchTestimonial(String search) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(Search, search+date, "Search");
		Thread.sleep(5000);
		
	}
	
	public void approveTestimonial(String notes) throws Exception
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		click(approved, "Approved");
		Thread.sleep(5000);
		type(this.notes, notes+date, "Notes");
		Thread.sleep(1000);
		Select drp = new Select(statusID);
		drp.selectByVisibleText("Approved");
		Thread.sleep(5000);
		click(save, "Save");
		Thread.sleep(10000);
		click(menu, "Menu");
		Thread.sleep(5000);
		click(logout, "Logout");
	}
	
	public void rejectTestimonial(String notes) throws Exception
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		click(rejected, "Rejected");
		Thread.sleep(5000);
		type(this.notes, notes, "Notes");
		Thread.sleep(1000);
		Select drp = new Select(statusID);
		drp.selectByVisibleText("Rejected");
		Thread.sleep(5000);
		click(save, "Save");
		Thread.sleep(10000);
		click(menu, "Menu");
		Thread.sleep(10000);
		click(logout, "Logout");
	}
}
