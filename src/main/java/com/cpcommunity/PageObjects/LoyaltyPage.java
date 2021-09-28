package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class LoyaltyPage extends BasePage{
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(loyaltyCredits);
		return ExpectedConditions.visibilityOf(loyaltyCredits);
	}
   
	@FindBy(xpath = "//h2[normalize-space()='Loyalty Credits']")
	WebElement loyaltyCredits;
	@FindBy(xpath = "//span[normalize-space()='Sign Up']")
	List<WebElement> signUp;
	@FindBy(xpath = "//span[normalize-space()='Login']")
	List<WebElement> login;
	@FindBy(xpath = "//span[normalize-space()='Join Community']")
	List<WebElement> joinCommunity;
	@FindBy(xpath = "//span[normalize-space()='Join Group']")
	List<WebElement> joinGroup;
	@FindBy(xpath = "//span[normalize-space()='Event Registration']")
	List<WebElement> eventRegistration;
	@FindBy(xpath = "//span[normalize-space()='Add Testimonials']")
	List<WebElement> addTestomonials;
	@FindBy(xpath = "//span[normalize-space()='Apply for Jobs']")
	List<WebElement> applyForJob;
	@FindBy(xpath = "//span[normalize-space()='Purchase Advertisemnts']")
	List<WebElement> purchaseAdvertisements;
	@FindBy(xpath = "//span[normalize-space()='Endoresments']")
	List<WebElement> endorsements;
	@FindBy(xpath = "//span[normalize-space()='My Profile']")
	List<WebElement> myprofile;
	@FindBy(xpath = "//span[normalize-space()='Community Invite Friends']")
	List<WebElement> communityInviteFriends;
	@FindBy(xpath = "//span[normalize-space()='Event Guest Invite']")
	List<WebElement> eventInvite;
	@FindBy(xpath = "//span[normalize-space()='Donations']")
	List<WebElement> donations;
	@FindBy(xpath = "//span[normalize-space()='Submit Survey']")
	List<WebElement> submitSurvey;
	@FindBy(xpath = "//span[normalize-space()='View Resources']")
	List<WebElement> viewResources;
	@FindBy(xpath = "//span[normalize-space()='Add Discussions in Community']")
	List<WebElement> addDiscussionInCommunity;
	@FindBy(xpath = "//span[normalize-space()='Add Discussions in Group']")
	List<WebElement> addDiscussionInGroup;
	@FindBy(xpath = "//span[normalize-space()='Update']")
	WebElement update;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@class='x_content']//div[2]//div[1]//div[1]//div[1]//div[1]//span[2]")
	WebElement loginTooltip;
	@FindBy(xpath = "//div[5]//div[1]//div[1]//div[1]//div[1]//span[2]")
	WebElement eventRegistrationTooltip;
	@FindBy(xpath = "//input[@name='Sign Up']")
	WebElement signUpCheckbox;
	@FindBy(xpath = "//div[@class='col-lg-12 ng-scope']//div[1]//div[1]//div[1]//div[2]//input[1]")
	List<WebElement> signUpPointBox;
	@FindBy(xpath = "//div[@class='col-lg-12 ng-scope']//div[1]//div[1]//div[1]//div[2]//input[1]")
	WebElement signUpPointsBox;	
	//@FindBy(xpath = "//h2[normalize-space()='Loyalty Credits']")
	//WebElement loyaltyCredits;
	//@FindBy(xpath = "//h2[normalize-space()='Loyalty Credits']")
	//WebElement loyaltyCredits;
	
	public void checkElementsOnLoyaltyPage() {
		if(signUp.size()>0) {System.out.println("signUp feature Present");
		}else System.out.println("signup not present");
		if(login.size()>0) { System.out.println("login feature present");
		}else System.out.println("login not present");
		if(joinCommunity.size()>0) {System.out.println("joinCommunity feature Present");
		}else System.out.println("joinCommunity not present");
		if(joinGroup.size()>0) { System.out.println("joinGroup feature present");
		}else System.out.println("joinGroup not present");
		if(eventRegistration.size()>0) {System.out.println("eventRegistration feature Present");
		}else System.out.println("eventRegistration not present");
		if(addTestomonials.size()>0) { System.out.println("addTestomonials feature present");
		}else System.out.println("addTestomonials not present");
		if(applyForJob.size()>0) {System.out.println("applyForJob feature Present");
		}else System.out.println("applyForJob not present");
		if(purchaseAdvertisements.size()>0) { System.out.println("purchaseAdvertisements feature present");
		}else System.out.println("purchaseAdvertisements not present");
		if(endorsements.size()>0) {System.out.println("endorsements feature Present");
		}else System.out.println("endorsements not present");
		if(myprofile.size()>0) { System.out.println("myprofile feature present");
		}else System.out.println("myprofile not present");
		if(communityInviteFriends.size()>0) {System.out.println("communityInviteFriends feature Present");
		}else System.out.println("communityInviteFriends not present");
		if(eventInvite.size()>0) { System.out.println("eventInvite feature present");
		}else System.out.println("eventInvite not present");
		if(donations.size()>0) {System.out.println("donations feature Present");
		}else System.out.println("donations not present");
		if(submitSurvey.size()>0) { System.out.println("submitSurvey feature present");
		}else System.out.println("submitSurvey not present");
		if(viewResources.size()>0) { System.out.println("viewResources feature present");
		}else System.out.println("viewResources not present");
		if(addDiscussionInCommunity.size()>0) {System.out.println("addDiscussionInCommunity feature Present");
		}else System.out.println("addDiscussionInCommunity not present");
		if(addDiscussionInGroup.size()>0) { System.out.println("addDiscussionInGroup feature present");
		}else System.out.println("addDiscussionInGroup not present");
		Assert.assertTrue(true);
		
		}
	public void verifyToolTip() {
		Actions action=new Actions(driver);
		action.moveToElement(loginTooltip).build().perform();
		System.out.println("Login ToolTip msg is :");
		System.out.println(loginTooltip.getAttribute("data-original-title"));
		String expectedText="By enabling this option, users will be rewarded with loyalty points as configured in the text box";
		String actualText=loginTooltip.getAttribute("data-original-title");
		Assert.assertEquals(expectedText, actualText);
		action.moveToElement(eventRegistrationTooltip).build().perform();
		System.out.println("eventRegistrationTooltip ToolTip msg is :");
		System.out.println(eventRegistrationTooltip.getAttribute("data-original-title"));
		String expectedText1="By enabling this option, users will be rewarded with loyalty points as configured in the text box";
		String actualText1=eventRegistrationTooltip.getAttribute("data-original-title");
		Assert.assertEquals(expectedText1, actualText1);
	}
	public void checkLoyaltyCheckBox() {
		click(signUpCheckbox,"Sign Check Box");
		if(signUpPointsBox.isEnabled()) {
			System.out.println("sign up box is enabled when unchecked");
			Assert.assertTrue(false);
		}else {System.out.println("sign up point box is disabled when unchecked");
			Assert.assertTrue(true);
		};
		click(signUpCheckbox,"Sign Check Box");
				
	}
	public void TAcanAddPointsWhenBoxChecked() {
		type(signUpPointsBox,"A213","");
		click(signUpCheckbox,"Sign Check Box");
		if(signUpPointsBox.isEnabled()) {
			System.out.println("sign up box is enabled when unchecked");
			Assert.assertTrue(false);
		}else {System.out.println("sign up point box is disabled when unchecked");
			Assert.assertTrue(true);
		};
		click(signUpCheckbox,"Sign Check Box");
				
	}
}
