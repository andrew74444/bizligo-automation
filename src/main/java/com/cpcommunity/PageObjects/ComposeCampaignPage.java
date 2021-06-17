package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class ComposeCampaignPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(composeCampaign);
	}
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement pageheader;
	
	@FindBy(xpath = "//h3[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	@FindBy(xpath = "//button[normalize-space()='Send']")
	WebElement sendBtn;
	
	@FindBy(xpath = "//span[normalize-space()='To Email Required']")
	WebElement emailrequiredError;
	
	@FindBy(xpath = "//span[normalize-space()='Campaign Template Is Required']")
	WebElement campaignTempError;
	
	@FindBy(xpath = "//span[normalize-space()='Campaign Name Is Required']")
	WebElement campaignNameError;
	
	@FindBy(xpath = "//span[normalize-space()='The Subject is required']")
	WebElement subjectRequiredError;
	
	@FindBy(xpath = "//label[normalize-space()='Do you want to schedule']")
	WebElement doyouwantschedule;
	
	@FindBy(xpath = "//input[@id='MailScheduleCheck']")
	WebElement mailScheduleCheck;
	
	@FindBy(xpath = "//input[@id='BulkMailDateSchedular']")
	WebElement dateSchedular;
	
	@FindBy(xpath = "//body[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[4]")
	WebElement dateToBeSelected;
	
	@FindBy(xpath = "//body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[11]")
	WebElement hourToBeSelected;
	
	@FindBy(xpath = "//span[normalize-space()='10:20']")
	WebElement minuteToBeSelected;
	
	@FindBy(xpath = "//a[normalize-space()='Add Contacts']")
	WebElement addContacts;
	
	@FindBy(xpath = "//select[@ng-model='SelectedContactType']")
	WebElement communityDropdown;
	
	@FindBy(xpath = "//div[@class='col-md-8 col-sm-8 col-xs-12 ng-scope']")
	WebElement communityDropdown1;
	
	@FindBy(xpath = "//div[@ng-class=\"{'ui-grid-all-selected': grid.selection.selectAll}\"]")
	WebElement nameCheckbox;
	
	@FindBy(xpath = "//div[@id='ContactsModal']//button[@id='saveImage']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//select[@ng-model='SelectCampaigin']")
	WebElement selectCampaign;
	
	@FindBy(xpath = "//button[@class='btn btn-info']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	
	
	

	
	
	
	


	
	
	
	public void emailWithoutRecipeintDetails() {
		
		click(sendBtn,"send button");
		if(emailrequiredError.isDisplayed()&&campaignTempError.isDisplayed()&&campaignNameError.isDisplayed()&&subjectRequiredError.isDisplayed()) {
			//logInfo("");
			System.out.println("Error msg displaying in all mandatory fields");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Error msg not displaying in mandatory fields");
			Assert.assertTrue(false);
		}
	}
	
	public void emailsAtParticularTime() throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,"Groups","Groups");
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(2000);
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
		click(mailScheduleCheck,"check mailschedule checkbox");
		waitForElementToPresent(dateSchedular);
		click(dateSchedular,"Bulk mail date Schedular");
		click(dateToBeSelected,"Date Selected");
		click(hourToBeSelected,"Hour Selected");
		click(minuteToBeSelected,"Minute to be selected");
		picture();
		String x=dateSchedular.getText();
		System.out.println("the text on date schedular is:"+ x);
		click(sendBtn,"save button");
		
		//AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement Sent Successfully");
		/*String Message = SuccessPopup.getText();
		picture();
		System.out.println(Message);*/
		/*if(Message.equals("Endorsement Sent Successfully")){
			Assert.assertTrue(true);;
		}
		else{ 
			Assert.assertFalse(false);
		}*/
		
		
	}
	public void upcomingEvents(String communityName,String community2) throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,"Upcoming Events RSVP ed users",communityName);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(2000);
	    click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,community2,community2);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
