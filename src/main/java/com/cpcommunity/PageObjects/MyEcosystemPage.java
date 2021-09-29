package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyEcosystemPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(MyEcosystem);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//h2[contains(text(),'MY ECOSYSTEM')]")
	WebElement MyEcosystem;
	@FindBy(xpath = "//div[@id='myNavbar']")
	WebElement pageheader;
	@FindBy(xpath = "//div[normalize-space()='My Jobs']")
	WebElement myJobs;
	@FindBy(xpath = "//div[normalize-space()='My Groups']")
	WebElement myGroups;
	
	
	
	
	
	public MyJobsPage navigateToMyJobsPage() {
		scrollIntoView(myJobs);
		myJobs.click();		
		return (MyJobsPage) openPage(MyJobsPage.class);
	}
	
}
