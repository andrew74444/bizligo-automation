package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

public class ProfessionalServicesPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	@FindBy(xpath = "//*[@id=\"ProfessionalMatchMakingController\"]/div[1]/div[2]/a")
	WebElement organizationservices;
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[2]")
	WebElement addoffer;
	
	@FindBy(xpath = "(//button[contains(@type,'button')])[3]")
	WebElement addNeed;
	
	@FindBy(xpath = "//*[contains(@name,'ServicesOffering[]')]")
	WebElement selectOffer;
	
	@FindBy(xpath = "//*[contains(@name,'ServicesSeeking[]')]")
	WebElement selectNeed;
	
	@FindBy(xpath = "(//*[contains(text(),'Services You Offer/Buy')])[2]")
	WebElement ServiceTitle;
	
	
	
	
	public void serviceYouOffer() throws Throwable
	{
		waitForElementToPresent(ServiceTitle);
		Thread.sleep(5000);
		click(addoffer,"Services you OFFER");
		Thread.sleep(1000);
		Select s = new Select(selectOffer);
		s.selectByVisibleText("Accounting");
		Thread.sleep(1000);
		click(addoffer,"Services you OFFER");
		Thread.sleep(1000);
		s.selectByVisibleText("Automotive");
	}

	
	public void serviceYouNeed() throws Throwable
	{
		waitForElementToPresent(ServiceTitle);
		Thread.sleep(5000);
		click(addNeed,"Services you Need");
		Thread.sleep(1000);
		Select s = new Select(selectNeed);
		s.selectByVisibleText("Accounting");
		Thread.sleep(1000);
		click(addNeed,"Services you Need");
		Thread.sleep(1000);
		s.selectByVisibleText("Automotive");
	}
}
