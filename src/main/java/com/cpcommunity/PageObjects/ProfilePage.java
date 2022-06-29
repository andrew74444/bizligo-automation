package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



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
		
	@FindBy(xpath = "//div[normalize-space()='PROFILE CATEGORY']")
	WebElement ProfileCategory;
	@FindBy(xpath="//span[contains(text(),'Directory')]")
	WebElement Directory;
	@FindBy(xpath="//a[contains(text(),'Member Directory')]")
	WebElement memberDirectory;
	@FindBy(xpath = "//button[contains(.,' Add Endorsement')]")
	WebElement addEndorsementBtn;
	@FindBy(xpath = "//textarea[@placeholder='Enter Content']")
	WebElement EndorsementFiled;	
	@FindBy(xpath = "(//button[contains(.,'Send')])[2]")
	WebElement sendBtn;	

	//@FindBy(xpath = "//a[@data-toggle='tab'][contains(text(),'Organization Details')]")

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profilePage;	
	 @FindBy(xpath = "//div[@class='progress custom-progress']")
		List<WebElement> profileCompletenessBardisplay;
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
//	@FindBy(xpath = "//label[contains(.,'Content :')]")
	@FindBy(xpath = "//*[@class='col-sm-12']/*[@class='form-group has-feedback']/*[@ng-model='profile.endorsement.Content']")//added on 22/03
	WebElement content;
	@FindBy(xpath = "//form[@id='EndorsementForm']//button[contains(text(),'Send')]")
	
	WebElement sendendors;
	@FindBy(xpath = "//small[@class='help-block'][contains(text(),'Content is Required')]")
	WebElement contentError1;

	
	//@FindBy(xpath = "//small[@class='help-block'][contains(text(),'500 characters')]")
	//WebElement contentError2;
	//@FindBy(xpath = "//button[@class='close'][@xpath='1']")
	//WebElement closeContent;


	
	@FindBy(xpath = "//small[@class='help-block'][contains(text(),'500 characters')]")
	WebElement contentError2;
	@FindBy(xpath = "//div[@class='modal-header']//button[@type='button'][normalize-space()='×']")
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
		
/*		
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

*/

/*	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		
		return ExpectedConditions.visibilityOf(profilePage);
	}
*/
	
/*	public boolean profileComplenessViibility() throws InterruptedException {
		Thread.sleep(1000);
	
	if(!profileCompletenessBar.isDisplayed()) {
		System.out.println("ProfileCompletenessBar is not displaying");
	
	}
	return true;
		
	}
	
	*/
		
	
	

		
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
	//	return ExpectedConditions.visibilityOf(profilePage);
		return ExpectedConditions.visibilityOf(ProfileCategory);//commented on 22/03
	//	return ExpectedConditions.visibilityOf(memberName);//for add endorsement method
	}

	public void AddEndorsement(String Endorsement, String Endorsement2, String Endorsement3, String Endorsement4) throws InterruptedException{
		waitForElementToPresent(addEndorsementBtn);
		picture();
		click(addEndorsementBtn,"addEndorsementBtn");
		waitForElementToPresent(content);
		type(EndorsementFiled,Endorsement, "Endorsement");
		picture();
		click(sendendors,"sendendorsement");		
		AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
		String Message = SuccessPopup.getText();
		picture();
		System.out.println(Message);
		//Thread.sleep(2000);
		click(addEndorsementBtn,"addEndorsementBtn");
		waitForElementToPresent(content);
		type(EndorsementFiled,Endorsement2, "Endorsement");
		picture();
		click(sendendors,"sendendorsement");		
		AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
		Message = SuccessPopup.getText();
		picture();
		System.out.println(Message);
		Thread.sleep(6000);
		click(addEndorsementBtn,"addEndorsementBtn");
		waitForElementToPresent(content);
		type(EndorsementFiled,Endorsement3, "Endorsement");
		picture();
		click(sendendors,"sendendorsement");	
		String Message2=contentError1.getText();
	   if(Message2.equals("Content is Required")){ 
		   System.out.println("Content is Required");
		   waitForElementToPresent(closeContent);
		   this.closeContent.click();
		}
	   else {
		   System.out.println("False");
	   }
	    
	    Thread.sleep(2000);
	    waitForElementToPresent(addEndorsementBtn);
		picture();
		click(addEndorsementBtn,"addEndorsementBtn");
	    waitForElementToPresent(content);
		type(EndorsementFiled,Endorsement4, "Endorsement");
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

//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	//all this elements for add endorsement through my ecosystems page
	@FindBy(xpath="//*[@ng-bind='member.MemberName']")//added on 22/03
	WebElement memberName;
	@FindBy(xpath="//*[@class='modal-header']/*[text()='Endorsements ']")//added on 22/03
	WebElement outside;

	public void AddEndorsement(String Endorsement) throws InterruptedException{
		Thread.sleep(3000);
		waitForElementToPresent(memberName);//added on 22/03
		click(memberName,"memberName");
//		log.info("Clicking on Endorsement Button...");
//		logExtentReport("Clicking on Endorsement Button...");	
		waitForElementToPresent(addEndorsementBtn);
	//	picture();
		click(addEndorsementBtn,"addEndorsementBtn");
		waitForElementToPresent(content);		
//		log.info("entering email address...."+Endorsement);
//		logExtentReport("entering email address...."+Endorsement);
	//	type(EndorsementFiled, Endorsement, "Endorsement");//commented 0n 22/03
	//	type(content, Endorsement, "Endorsement");//added on 22/03
		
//		log.info("Clicking on send Button...");
		
	//	picture();
		content.sendKeys(Endorsement);//added on 22/03
		//click(sendendors,"sendendorsement");
		outside.click();
		hardClick(sendendors);
		Thread.sleep(2000);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
		String Message = SuccessPopup.getText();
	//	picture();
		System.out.println(Message);
		if(Message.equals("Endorsement Sent Successfully")){
			Assert.assertTrue(true);;
		}
		else{ 
			Assert.assertFalse(false);
		}
	}
	public MemberDirectoryPage gotoMemberDirectoryPage() throws Exception {
		click(Directory,"Directory");
		Thread.sleep(5000);
		waitForElementToPresent(memberDirectory);
		click(memberDirectory,"MemberDirectory");
		Thread.sleep(5000);
		return (MemberDirectoryPage) openPage(MemberDirectoryPage.class);
		// new MyProfilePage(driver, );

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
	public void profileComplenessViibility() throws InterruptedException {
	//	Thread.sleep(1000);
		Assert.assertEquals(0, profileCompletenessBardisplay.size());
	
		System.out.println("ProfileCompletenessBar not is displaying");
	//Assert.assertTrue(true);
	}
}
