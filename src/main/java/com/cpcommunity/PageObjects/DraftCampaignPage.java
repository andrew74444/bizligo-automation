package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DraftCampaignPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(panelTitle);
		return ExpectedConditions.visibilityOf(panelTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//a[contains(text(),\"Bulk Drug Manufacturers Association India(BDMAI) A\")]")
	WebElement pageheader;
	@FindBy(xpath = "//input[@aria-label='Filter for column']")
	WebElement DraftMailFilter;
	@FindBy(xpath = "//h2[normalize-space()='DRAFT CAMPAIGN']")
	WebElement panelTitle;
	@FindBy(xpath = "//div[@id='1624298224450-0-uiGrid-0005-cell']//a[@class='ng-binding ng-scope'][contains(text(),'Bizligo Scheduler Test')]")
	WebElement ClickBizligo ;
	@FindBy(xpath = "div[id='1624404832986-0-uiGrid-0005-cell'] a[class='ng-binding ng-scope']")
	WebElement DraftmailList;

	
	public ComposeCampaign DraftmailDisplay(String CampaignName) throws InterruptedException {
		waitForElementToPresent(DraftMailFilter);
		type(DraftMailFilter, CampaignName, "CampaignName");
		Thread.sleep(2000);
		waitForElementToPresent(DraftmailList);
		waitForElementToPresent(ClickBizligo);
		click(ClickBizligo, "Click");
		return (ComposeCampaign) openPage(ComposeCampaign.class);
	}
	
}
