package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class ImportContactsPage extends BasePage{
	
	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(importContacts);
	}
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement pageheader;
	
	@FindBy(xpath = "//h3[normalize-space()='Import Contacts']")
	WebElement importContacts;
	
	@FindBy(xpath = "//input[@id='csvEmailFile']")
	WebElement chooseFile;
	
	@FindBy(xpath = "//a[normalize-space()='Sample Input File']")
	WebElement sampleinputFile;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Import']")
	WebElement importBtn;
    
	@FindBy(xpath = "//span[@id='CSVErrorMessage']")
	WebElement errorMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Manage Campaign']")
	WebElement ManageCampaign;
	
	@FindBy(xpath = "//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup; //div[contains(@class,'toast-message')and contains(text(),'Bulk Mail sent.')]
	

	
	public void errorMsgWhenEmptyEmailRecords(String path) throws InterruptedException {
		
		waitForElementToPresent(chooseFile);
		chooseFile.sendKeys(path);
		Thread.sleep(3000);
		click(importBtn,"Import File");
		if(errorMsg.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Error msg appears:"+ errorMsg.getText());
		}
	}
	
    public void csvFileWithDuplicateRecords(String path) throws InterruptedException {
		
		waitForElementToPresent(chooseFile);
		chooseFile.sendKeys(path);
		Thread.sleep(3000);
		click(importBtn,"Import File");
		Thread.sleep(3000);
		System.out.println("Success in saving Contacts from CSV file:"+ SuccessPopup.getText());
		
		
	}

    public ComposeCampaignPage NavigatetoComposeCampaignPage() {

	click(ManageCampaign, "ManageCampaign");
	waitForElementToPresent(composeCampaign);
	click(composeCampaign, "compose campaign");
	return (ComposeCampaignPage) openPage(ComposeCampaignPage.class);
	// new GroupsPendingRequestsPage(driver);

   }
}
