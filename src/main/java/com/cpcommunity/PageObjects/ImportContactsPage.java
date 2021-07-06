package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class ImportContactsPage extends BasePage {

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
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h3[normalize-space()='Import Contacts']")
	WebElement panelTitle;
	@FindBy(xpath = "//input[@id='csvEmailFile']")
	WebElement chooseFile;
	@FindBy(xpath = "//span[@id='CSVErrorMessage']")
	WebElement uploaderror;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastmessage;
	@FindBy(xpath = "//button[normalize-space()='Import']")
	WebElement importContact;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	@FindBy(xpath="//span[@id='CSVErrorMessage']")
	WebElement Error;
	@FindBy(xpath = "//button[normalize-space()='Import']")
	WebElement importBtn;
	@FindBy(xpath = "//span[@id='CSVErrorMessage']")
	WebElement errorMsg;
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup; //div[contains(@class,'toast-message')and contains(text(),'Bulk Mail sent.')]
	
	
	
	public void uploadFile(String Filepath) throws InterruptedException {
	waitForElementToPresent(chooseFile);
	//chooseFile.sendKeys("C:\\Temp\\Book7.csv");
	type(chooseFile,Filepath,"FileName");
	Thread.sleep(2000);
	waitForElementToPresent(importContact);
	click(importContact, "Import");
	AssertionHelper.verifyText(toastmessage.getText(), "Contacts saved");
	System.out.println("File is upload successfully");
	Thread.sleep(4000);
	
}
	public void uploadMissingNameFile(String Filepath) throws InterruptedException, IOException {
		waitForElementToPresent(chooseFile);
		//this.chooseFile.sendKeys("C:\\Temp\\SampleInputfile.csv");
		type(chooseFile,Filepath,"FileName");
		waitForElementToPresent(importContact);
		click(importContact, "Import");
		waitForElementToPresent(Error);
		if(Error.isDisplayed()) {
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public void uploadInvalidemails(String Filepath) throws InterruptedException, IOException {
		waitForElementToPresent(chooseFile);
		//this.chooseFile.sendKeys("C:\\Temp\\SampleInputfile.csv");
		type(chooseFile,Filepath,"FileName");
		waitForElementToPresent(importContact);
		click(importContact, "Import");
		waitForElementToPresent(Error);
		if(Error.isDisplayed()) {
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
		scrollDownVertically();
		Thread.sleep(2000);
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(500);
		waitForElementToPresent(composeCampaign);
		this.composeCampaign.click();	
		//click(composeCampaign, "composeCampaign");
		return (ComposeCampaign) openPage(ComposeCampaign.class);
		
}
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
}