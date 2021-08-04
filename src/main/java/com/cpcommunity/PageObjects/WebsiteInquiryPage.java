package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class WebsiteInquiryPage extends BasePage{
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(websiteInquiry);
		return ExpectedConditions.visibilityOf(websiteInquiry);
	}
   
	@FindBy(xpath = "//div[@role='main']//div//div[1]//div[1]//div[1]//div[1]//h2[1]")
	WebElement websiteInquiry;
	
	@FindBy(xpath = "//table[@id='contactTable']/tbody/tr[1]/td[2]")
	WebElement firstSearchResult;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBar;
	
	@FindBy(xpath = "//div[@id='Message']")
	WebElement message;
	
	@FindBy(xpath = "//input[@id='Notes']")
	WebElement addComments;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//select[@id='Status']")
	WebElement status;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMsg;
	
	
	public void checkEnquiryAtTApage(String Name,String Message) {
		type(searchBar,Name,Name);
		click(firstSearchResult,"First Result of Search");
		waitForElementToPresent(message);
		System.out.println(message.getText());
		if(message.getText().equalsIgnoreCase(Message)) {
			System.out.println("Enquiry By Member Visible at TA Page");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	}
	public void editByTA(String Name,String Note) throws InterruptedException {
		type(searchBar,Name,Name);
		click(firstSearchResult,"First Result of Search");
		waitForElementToPresent(message);
		type(addComments,Note, Note);
		selectByVisibleText(status,"CLOSED","CLOSED");
		click(saveBtn,"save");
		Thread.sleep(4000);
		System.out.println(toastMsg.getText());
		if(toastMsg.getText().equalsIgnoreCase("Notes updated successfully")) {
			
		}
		
		
	}
	
}
