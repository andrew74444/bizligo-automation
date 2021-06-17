package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ProfilePage extends BasePage{
	@FindBy(xpath = "//*[@id='header']")
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
	@FindBy(xpath = "(//button[contains(.,'Send')])[2]")
	WebElement sendBtn;	
	@FindBy(xpath = "//li[@class='active']//a[@data-toggle='tab'][contains(text(),'Profile')]")
	WebElement profilePage;	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//*[@id=\"Skill_InterestController\"]/div[2]/div/div[2]")
	WebElement profileCompletenessBar;
	
	public boolean IsEndoremsnetNotDisplayed(String EndormentMessage){
		
		try {
			if(driver.findElement(By.xpath("//div[contains(text(),'"+EndormentMessage+"')]")).isDisplayed()){
				return false;
			}
			
		} catch (Exception e) {
			return true;
		}
		return true;
	}
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
		public boolean AddEndorsement(String Endorsement ){
			
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
				return true;
			}
			else{ 
				return false;
			}
		}
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(profilePage);
		return ExpectedConditions.visibilityOf(profilePage);
	}
	
	public boolean profileComplenessViibility() throws InterruptedException {
		Thread.sleep(1000);
	
	if(!profileCompletenessBar.isDisplayed()) {
		System.out.println("ProfileCompletenessBar is not displaying");
	
	}
	return true;
		
	}
	
	
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
