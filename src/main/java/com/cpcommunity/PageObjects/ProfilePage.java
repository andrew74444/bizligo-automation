package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class ProfilePage extends BasePage{
	@FindBy(xpath = "//div[@id='myNavbar']")
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
	@FindBy(xpath = "//a[@data-toggle='tab'][contains(text(),'Organization Details')]")
	WebElement profilePage;	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//*[@id=\"Skill_InterestController\"]/div[2]/div/div[2]")
	WebElement profileCompletenessBar;
	@FindBy(xpath = "//a[@ng-click='SIdata.AddSkills()']")
	WebElement UpdateSkillsBtn;
	@FindBy(xpath = "//input[@placeholder='Add Skills']")
	WebElement AddSkills;
	@FindBy(xpath = "//form[@id='EditMySkillsForm']//i[@class='fa fa-floppy-o']")
	WebElement SkillsSaveBtn;
	@FindBy(xpath = "//label[contains(.,'Content :')]")
	WebElement content;
	@FindBy(xpath = "//form[@id='EndorsementForm']//button[contains(text(),'Send')]")
	WebElement sendendors;
	@FindBy(xpath = "//small[@class='help-block'][contains(text(),'Content is Required')]")
	WebElement contentError1;
	
	@FindBy(xpath = "//small[@class='help-block'][contains(text(),'500 characters')]")
	WebElement contentError2;
	@FindBy(xpath = "//button[@class='close'][@xpath='1']")
	WebElement closeContent;
	
	
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
	/*	public boolean AddEndorsement(String Endorsement ){
			
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
		}*/
public void AddEndorsement(String Endorsement, String Endorsement2, String Endorsement3, String Endorsement4) throws InterruptedException{
			//commited in Github
//			log.info("Clicking on Endorsement Button...");
//			logExtentReport("Clicking on Endorsement Button...");	
			waitForElementToPresent(addEndorsementBtn);
			picture();
			click(addEndorsementBtn,"addEndorsementBtn");
			waitForElementToPresent(content);
//			log.info("entering email address...."+Endorsement);
//			logExtentReport("entering email address...."+Endorsement);
			type(EndorsementFiled,Endorsement, "Endorsement");
//			log.info("Clicking on send Button...");
			picture();
			click(sendendors,"sendendorsement");		
			AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
			String Message = SuccessPopup.getText();
			picture();
			System.out.println(Message);
			
			click(addEndorsementBtn,"addEndorsementBtn");
			waitForElementToPresent(content);
//			log.info("entering email address...."+Endorsement);
//			logExtentReport("entering email address...."+Endorsement);
			type(EndorsementFiled,Endorsement2, "Endorsement");
//			log.info("Clicking on send Button...");
			picture();
			click(sendendors,"sendendorsement");		
			AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
			Message = SuccessPopup.getText();
			picture();
			System.out.println(Message);
			Thread.sleep(2000);
			click(addEndorsementBtn,"addEndorsementBtn");
			waitForElementToPresent(content);
//			log.info("entering email address...."+Endorsement);
//			logExtentReport("entering email address...."+Endorsement);
			type(EndorsementFiled,Endorsement3, "Endorsement");
//			log.info("Clicking on send Button...");
			picture();
			click(sendendors,"sendendorsement");	
			
			//waitForElementToPresent(contentError1);
			String Message2=contentError1.getText();
		   if(Message2.equals("Content is Required")){ 
			   System.out.println("Content is Required");
			}
		   else {
			   System.out.println("False");
		   }
		    
		    Thread.sleep(2000);
		    waitForElementToPresent(content);
//			log.info("entering email address...."+Endorsement);
//			logExtentReport("entering email address...."+Endorsement);
			type(EndorsementFiled,Endorsement4, "Endorsement");
//			log.info("Clicking on send Button...");
			picture();
			click(sendendors,"sendendorsement");	
			scrollIntoView(contentError2);
			waitForElementToPresent(contentError2);
			String Message3=contentError2.getText();
		    if(Message3.equals("Content must be more than 2 and less than 500 characters")){ 
		    	System.out.println("Content must be more than 2 and less than 500 characters");
				//return false;
			}
         }

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		
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
