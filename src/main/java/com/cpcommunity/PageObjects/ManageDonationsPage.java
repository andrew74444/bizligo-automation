package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class ManageDonationsPage extends BasePage{
	@Override
	protected  void getPageScreenSot() {
	

		aShot();//

		aShot();


	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(ManageDonations);
	}
	@FindBy(xpath = "//h2[normalize-space()='Manage Donations']")
	WebElement ManageDonations;
 
	@FindBy(xpath = "//button[normalize-space()='Add Donation']")
	WebElement AddBtn;

	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBtn;
    
	@FindBy(xpath = "//*[@id=\"DonationsTable\"]/tbody/tr[1]/td[3]")
	WebElement communityNameWhenSearched;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/p[1]")
	WebElement firstEditBtn;

	@FindBy(xpath = "//p[@class='glyphicon glyphicon-pencil']")
	WebElement editBtn;

	@FindBy(xpath = "//input[@id='ActiveCommunities']")
	WebElement selectCommunity;
	
	@FindBy(xpath = "//div[normalize-space()='Donation with this community is already configured.']")
	WebElement errorMsgForCommunity;
	
	@FindBy(xpath = "//ul[@id='typeahead-4-3189']")
	WebElement selectCommunityDropdown;
	
	@FindBy(xpath = "//div[@id='cke_1_contents']")
	WebElement purpose;
	
	@FindBy(xpath = "//input[@name=\"internal[]\"]")
	WebElement enterAmount;
	
	@FindBy(xpath = "//*[@id=\"AddDonationForm\"]/div/div/div[4]/div/div/div[2]/div/input")
	WebElement enterAmount2;
	
	@FindBy(xpath = "//*[@id=\"AddDonationForm\"]/div/div/div[4]/div/div/div[3]/div/input")
	WebElement enterAmount3;
	
	@FindBy(xpath = "//*[@id=\"AddDonationForm\"]/div/div/div[4]/div/div/div[4]/div/input")
	WebElement enterAmount4;
	
	@FindBy(xpath = "//*[@id=\"AddDonationForm\"]/div/div/div[4]/div/div/div[5]/div/input")
	WebElement enterAmount5;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;
	
	@FindBy(tagName = "body")
	WebElement enterTextInframe;

	@FindBy(xpath= "//button[normalize-space()='Yes, Proceed']")
	WebElement yesProceed;
	
	@FindBy(xpath= "//div[7]//div[1]//div[1]//div[1]//label[1]")
	WebElement status;
	
	@FindBy(xpath= "//div[@class='toggle btn btn-danger off']//label[@class='btn btn-danger active toggle-off'][normalize-space()='In-Active']")
	WebElement statusInactive;
	
	@FindBy(xpath= "//button[normalize-space()='Update']")
	WebElement update;
	
	@FindBy(xpath= "//*[@id=\"typeahead-4-7721\"]")
	WebElement communityInDropdown;
	
	@FindBy(xpath= "//input[@value='2']")
	WebElement external;
	 
	@FindBy(xpath= "//input[@value='1']")
	WebElement internal;
	
	@FindBy(xpath= "//input[@id='ExternalUrl']")
	WebElement externalURL;
	
	
	
	public void addDonation(String communityName) throws InterruptedException {
		click(AddBtn,"Add donation");
		//communityName=communityName+" "+getDateInDDMMMYYYY();
		type(selectCommunity,communityName,"Community Name");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys("Charity");
		driver.switchTo().defaultContent();
		type(enterAmount,"10","Dollar 10");
		cancelBtn.click();
		yesProceed.click();
		click(AddBtn,"Add donation");
		if(saveBtn.isEnabled())System.out.println("empty Donation form can be saved");
		else System.out.println("Empty Donation form cannot be saved");
		//click(saveBtn,"save");
		click(AddBtn,"Add donation");
		Thread.sleep(3000);
		type(selectCommunity,communityName,"Community Name");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys("Charity");
		driver.switchTo().defaultContent();
		type(enterAmount,"10","Dollar 10");
		type(enterAmount2,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount3,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount4,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount5,"10","Dollar 10");
		click(saveBtn,"save");
		
	}
	
	public void addDonationToExistingCommunity(String communityName) throws InterruptedException, AWTException {
		click(AddBtn,"Add donation");
		//System.out.println(selectCommunityDropdown.getText());
		type(selectCommunity,communityName,"Community Name");
		Thread.sleep(2000);
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		if(errorMsgForCommunity.getText().equalsIgnoreCase("Donation with this community is already configured.")) {
			System.out.println("Donation cannot be made to existing society, error message comes up");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		
		}
	
   public void inactiveCommunity(String communityName) throws InterruptedException, AWTException {
	   click(AddBtn,"Add donation");
		//System.out.println(selectCommunityDropdown.getText());
		type(selectCommunity,communityName,"Community Name");
		Thread.sleep(2000);
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);	
		
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys("Charity");
		driver.switchTo().defaultContent();
		selectCommunity.click();
		
		communityInDropdown.click();
		System.out.println(communityInDropdown.getText());
		communityInDropdown.click();
		Thread.sleep(2000);
		System.out.println(errorMsgForCommunity.getText());
		Thread.sleep(2000);  
	   
   }
   
   public void filterByCommunityName(String Community) {
	   type(searchBtn,Community,Community);
	   System.out.println(communityNameWhenSearched.getText());
	   if(Community.equalsIgnoreCase(communityNameWhenSearched.getText())) {
		   Assert.assertTrue(true);
		   System.out.println("TA can filter donations by community name");
	   }else {
		   Assert.assertTrue(false);
		   System.out.println("TA cannot filter Donations by community name");
	   }
	   
   }
   
   public void inactivateDonation(String Community) throws InterruptedException {
	   type(searchBtn,Community,Community);
	   editBtn.click();
	   status.click();
	   update.click();
	   Thread.sleep(2000);
	   
   }
   public void activateDonation(String Community) throws InterruptedException {
	   type(searchBtn,Community,Community);
	   editBtn.click();
	   Thread.sleep(2000);
	   statusInactive.click();
	   update.click();
	   Thread.sleep(2000);
	   
   }
   public void makeDonationExternal(String Community,String URL) throws InterruptedException {
	   type(searchBtn,Community,Community);
	   editBtn.click();
	   Thread.sleep(2000);
	   waitForElementToPresent(external);
	   click(external,"External Donation Payment");	   
	   type(externalURL,URL,URL);
	   update.click();
	   Thread.sleep(2000);
	   
   }
   public void makeDonationInternal(String Community) throws InterruptedException {
	   type(searchBtn,Community,Community);
	   editBtn.click();
	   Thread.sleep(2000);
	   waitForElementToPresent(external);
	   click(internal,"Internal");
	   type(enterAmount,"10","Dollar 10");
		type(enterAmount2,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount3,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount4,"10","Dollar 10");
		Thread.sleep(2000);
		type(enterAmount5,"10","Dollar 10");		
	   update.click();
	   Thread.sleep(2000);
	   
   }
   
}
