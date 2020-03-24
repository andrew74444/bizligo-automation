package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ServeysPage extends BasePage

{
	@FindBy(xpath = "//i[@class='icon-plus']")
	WebElement addBtn;

	@FindBy(xpath = "//*[@id='Name']")
	WebElement name;

	@FindBy(xpath = "//*[@id='EventID']")
	WebElement eventID;

	@FindBy(xpath = "//*[@id='Title']")
	WebElement title;

	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(tagName = "iframe")
	WebElement iframe;

	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	WebElement Save;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement saveSurvey;
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		driver.switchTo().frame("surveyFrame");
		
		return ExpectedConditions.visibilityOf(addBtn);
	}

	public void createServey() throws Exception {
		waitForElementToPresent(addBtn);
		click(addBtn, "back to PaymentGateways");
		waitForElementToPresent(name);
		click(addBtn,"Add Question");
		waitForElementToPresent(title);
		title.sendKeys("hgjh");
		Save.click();
		
		
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		

	}

}
