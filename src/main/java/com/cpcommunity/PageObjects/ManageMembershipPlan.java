
package com.cpcommunity.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//a[@title='Click to edit this page']")
	List<WebElement> editt;

	@FindBy(xpath="//button[@id='btn-ok']")
	WebElement ok;
	
	
	
	
	public void errorField() {
		
		 waitForElementToPresent(addnew);
		 click(addnew, "Add new pLan");
		 driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		 scrollToElementAndClick(save);
		 //click(save, "Save");
		 String error=this.errorfield.getText();
		 System.out.println(error);
	}
	
	
	public void createnewmembership(String Name, String Price, String Description,String Period) throws InterruptedException {
		 waitForElementToPresent(addnew);
		 click(addnew, "Add new pLan");
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 waitForElementToPresent(planName);
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
	     waitForElementToPresent(ok);
	     click(ok, "Ok");
	     Thread.sleep(1000);
	}
	
	public void searchplan(String PlaneName) {
		PlaneName=PlaneName+" " + getDateInDDMMMYYYY();
		waitForElementToPresent(search);
		type(search, PlaneName, "Plan Name");
	}
	
	
	public void UpdatePlan(String Name,String Price, String Description) throws InterruptedException {

		Thread.sleep(4000);
		Name=Name+" " + getDateInDDMMMYYYY();
		 type(planName, Name, "Plan name");
		type(price, Price, "price");
		 driver.switchTo().frame(0);
	     EnterinFrame.clear();
	     EnterinFrame.sendKeys(Description);
	     driver.switchTo().defaultContent();
	     driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
	     click(save, "Save");
	     waitForElementToPresent(ok);
	     click(ok, "Ok");
	     Thread.sleep(1000);
	}
	
	public void EditPlan(String PlanName) {
		PlanName=PlanName+" " + getDateInDDMMMYYYY();
		//WebElement editlast=editt.get(editt.size()-1);
		//click(editlast, "Edit");	
		List<WebElement> tdPlanNames = driver.findElements(By.xpath("//table[@id=\"membershipPlansTable\"]//tr//td[3]"));
		System.out.println(tdPlanNames.size());
		for(int i=0; i<=tdPlanNames.size(); i++) {
			WebElement plan = tdPlanNames.get(i);
		    String Name=plan.getText();
		    if(Name.equalsIgnoreCase(PlanName))
			{
		    	
		     driver.findElement(By.xpath("//table[@id=\"membershipPlansTable\"]//tr["+(i+1)+"]//td[2]//a")).click();
			 break;
			}
		}
	
	}
	
	public void inactivate() throws InterruptedException {
		Thread.sleep(4000);
		scrollToElementAndClick(statusInactive);
		click(save, "Save");
		 waitForElementToPresent(ok);
	     click(ok, "Ok");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}