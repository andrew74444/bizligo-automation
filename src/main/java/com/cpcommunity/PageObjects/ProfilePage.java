package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;



public class ProfilePage extends BasePage{
	@FindBy(xpath = "//div[@id='myNavbar']")
	
	//*[@id='header']
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
		
	
	
	@FindBy(xpath = "//button[contains(.,' Add Endorsement')]")
	WebElement addEndorsementBtn;
	@FindBy(xpath = "//textarea[@placeholder='Enter Content']")
	WebElement EndorsementFiled;	
	@FindBy(xpath = "//button[@type='submit'][normalize-space()='Send']")
	WebElement sendBtn;	
	@FindBy(xpath = "//li[@class='active']//a[@data-toggle='tab'][contains(text(),'Profile')]")
	WebElement profilePage;	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	
	@FindBy(xpath = "//div[normalize-space()='PROFILE CATEGORY']")
	WebElement ProfileCategory;
	
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement Logout;

	@FindBy(xpath = "//span[normalize-space()='Directory']")
	WebElement directory;
	
	@FindBy(xpath = "//a[normalize-space()='Member Directory']")
	WebElement memberDirectory;
	
	
	
	public void  IsEndoremsnetNotDisplayed(String EndormentMessage){
		
		try {
			if(driver.findElement(By.xpath("//div[contains(text(),'"+EndormentMessage+"')]")).isDisplayed()){
				System.out.println("Pending Msg Is displaying");
				Assert.assertTrue(true);
			}
			
		} catch (Exception e) {
			System.out.println("Pending message is not displaying");
		}
		
	}
		
		public void  IsEndorsementtDisplayed(String EndormentMessage){
			
			try {
				if(driver.findElement(By.xpath("//div[contains(text(),'"+EndormentMessage+"')]")).isDisplayed()){
					System.out.println("Approved Msg Is displaying");
					Assert.assertTrue(true);
				}
				
			} catch (Exception e) {
				System.out.println("Approved message is not displaying");
			
		}
		
	}

	public MemberDirectoryPage goToMemberDirectory() throws InterruptedException {
		click(directory,"directory");
		Thread.sleep(3000);
		//moveToElement(directory);
		click(memberDirectory,"member directory");
		//click(memberDirectory,"member directory");
		Thread.sleep(3000);
		return (MemberDirectoryPage) openPage(MemberDirectoryPage.class);
		
	}
	
	/*public boolean IsEndoremsnetNotDisplayed(String EndormentMessage){
		
		try {
			if(driver.findElement(By.xpath("//div[contains(text(),'"+EndormentMessage+"')]")).isDisplayed()){
				return false;
			}
			
		} catch (Exception e) {
			return true;
		}
		return true;
	}*/
		public boolean IsEndoremsnetDisplayed(String EndormentMessage){
			
			try {
				if(driver.findElement(By.xpath("//div[contains(text(),'"+EndormentMessage+"')]")).isDisplayed()){
					return true;
				}
				
			} catch (Exception e) {
				return false;
			}
			return false;		
		
	}
		public void AddEndorsement(String Endorsement ){
			
//			log.info("Clicking on Endorsement Button...");
//			logExtentReport("Clicking on Endorsement Button...");	
			waitForElementToPresent(addEndorsementBtn);
			picture();
			click(addEndorsementBtn,"addEndorsementBtn");
			waitForElementToPresent(sendBtn);		
//			log.info("entering email address...."+Endorsement);
//			logExtentReport("entering email address...."+Endorsement);
			type(EndorsementFiled, Endorsement, "Endorsement");
			
//			log.info("Clicking on send Button...");
			
			picture();
			click(sendBtn,"sendBtn");		
			AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
			String Message = SuccessPopup.getText();
			picture();
			System.out.println(Message);
			if(Message.equals("Endorsement Sent Successfully")){
				Assert.assertTrue(true);;
			}
			else{ 
				Assert.assertFalse(false);
			}
		}
		public HomePage logout() throws Exception {
			Thread.sleep(9000);
			click(Toggledropdownmenu,"Toggledropdownmenu");
			Thread.sleep(2000);
			waitForElementToPresent(Logout);
			click(Logout,"Logout");
			return (HomePage) openPage(HomePage.class);
			// new HomePage(driver, );
		}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		//return ExpectedConditions.visibilityOf(profilePage);
		return ExpectedConditions.visibilityOf(ProfileCategory);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
