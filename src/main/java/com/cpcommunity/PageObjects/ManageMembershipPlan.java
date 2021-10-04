
package com.cpcommunity.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageMembershipPlan extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(title);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
		aShot();
	}
	@FindBy(xpath="//body//div[@class='container body']//div[@class='row']//div[@class='row']//h2[1]")
	WebElement title;
	
	@FindBy(xpath="//button[normalize-space()='Add New Plan']")
	WebElement addnew;
	
	@FindBy(xpath="//input[@id='Name']")
	WebElement planName;
	
	@FindBy(xpath="//input[@id='Price']")
	WebElement price;
	
	@FindBy(xpath="//body//p")
	WebElement EnterinFrame;
	
	@FindBy(xpath="//input[@id='DurationValue']")
	WebElement durationperiod;
	
	@FindBy(xpath="//select[@id='DurationTypeID']")
	WebElement durationtype;
	
	@FindBy(xpath="//div[5]//div[1]//div[1]//div[1]//label[1]")
	WebElement allowReneval;
	
	@FindBy(xpath="//div[6]//div[1]//div[1]//div[1]//label[1]")
	WebElement requiredapproval;
	
	@FindBy(xpath="//div[7]//div[1]//div[1]//div[1]//label[1]")
	WebElement statusActive;
	
	@FindBy(xpath="//div[7]//div[1]//div[1]//div[1]//label[2]")
	WebElement statusInactive;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement save;
	
	@FindBy(xpath="//small[@data-fv-for='Details'][normalize-space()='This field is required']")
	WebElement errorfield;
	
	@FindBy(xpath="input[type='search']")
	WebElement search;
	
	@FindBy(xpath="//a[@title='Click to edit this page']")
	WebElement edit;
	
	
	
	
	public void createnewmembership(String Name, String Price, String Description,String Period) throws InterruptedException {
		 waitForElementToPresent(addnew);
		 click(addnew, "Add new pLan");
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 click(save, "Save");
		 String error=this.errorfield.getText();
		 System.out.println(error);
		 scrollToElement(planName);
		Thread.sleep(4000);
		 Name=Name+" " + getDateInDDMMMYYYY();
		 type(planName, Name, "Plan name");
		 type(price, Price, "Price");
		 driver.switchTo().frame(0);
	     EnterinFrame.clear();
	     EnterinFrame.sendKeys(Description);
	     driver.switchTo().defaultContent();
	     driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
	     type(durationperiod, Period, "Duration Period");
	     selectUsingIndex(durationtype, 4, "Duration type");
	     click(save, "Save");
	}
	
	public void searchplan(String PlaneName) {
		PlaneName=PlaneName+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(search);
		type(search, PlaneName, "Plan Name");
	}
	
	
	public void editPlan(String Name,String Price, String Description) throws InterruptedException {
		waitForElementToPresent(edit);
		click(edit, "Edit");
		Thread.sleep(4000);
		 type(planName, Name, "Plan name");
		type(price, Price, "price");
		 driver.switchTo().frame(0);
	     EnterinFrame.clear();
	     EnterinFrame.sendKeys(Description);
	     driver.switchTo().defaultContent();
	     driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
	   
	     click(save, "Save");
		
	}
}