package com.cpcommunity.PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	WebElement sendBtn;//button[@class='btn-primary btn btn-close']//i[@class='fa fa-paper-plane']
	
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
	WebElement SuccessPopup; //div[contains(@class,'toast-message')and contains(text(),'Bulk Mail sent.')]
	
	@FindBy(xpath = "//input[@ng-model='colFilter.term']")
	WebElement nameTextBox;
	//div[@id='1623937804998-0-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']
	
	@FindBy(xpath="//div[@ng-click='selectButtonClick(row, $event)']")
	WebElement nameFirstBox;
	
	@FindBy(xpath="//ul[@class='tag-list']")
	WebElement toEmailList;
	
	@FindBy(xpath="//i[@class='mce-ico mce-i-emoticons']")
	WebElement emailEmoticon;
	
	@FindBy(xpath="//a[@aria-label='cool']//img[@role='presentation']")
	WebElement smileyEmoticon;	
	
	@FindBy(xpath="//*[@id=\"1624407060051-0-uiGrid-0004-cell\"]/div/div/div")
	WebElement member1;
	
	@FindBy(xpath="//div[@id='1624407060051-1-uiGrid-0004-cell']")
	WebElement member2;
	
	@FindBy(xpath="//div[@id='1624407060051-3-uiGrid-0004-cell']")
	WebElement member3;
	
	@FindBy(xpath="//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'][1]")
	List<WebElement> members;//C:\Users\rugup\OneDrive\Documents\testing class.txt
	
	@FindBy(xpath="//input[@id='MultiFileUpload']")
	WebElement fileUpload;
	
	@FindBy(xpath="//div[@ng-click='selectButtonClick(row, $event)']")
	WebElement csvFileResult;
	
	
	
	
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
		click(sendBtn,"send button");
		
		
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
	public void addAllActiveOrganization(String communityName) throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,communityName,"Groups");
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(3000);
	    System.out.println(toEmailList.getText());
	    Assert.assertTrue(true);
	    
	 
	}
	
	public void addSelectCommunity(String communityName,String subCommunity) throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,communityName,"Community");
	    Thread.sleep(2000);
	    waitForElementToPresent(nameTextBox);
	    type(nameTextBox,subCommunity,subCommunity);
	    Thread.sleep(2000);
	    nameFirstBox.click();
	    //click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(3000);
	    if(toEmailList.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }
	    
	    System.out.println(toEmailList.getText());
	    //if(toEmailList.getSize()>0) {
	    Assert.assertTrue(true);
	    
	 
	}
	public void upcomingEvents(String communityName,String community2) throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
		System.out.println(communityName);
	    selectByVisibleText(communityDropdown,communityName,communityName);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(4000);
	    click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,community2,community2);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    waitForElementToPresent(nameTextBox);
	    type(nameTextBox,"BDMAI","BDMAI");
	    Thread.sleep(2000);
	    nameFirstBox.click();
	   // click(nameCheckbox,"name check box");
	    Thread.sleep(2000);
	    //click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    if(toEmailList.isDisplayed()) {
	    	Assert.assertTrue(true);
	    }
	    System.out.println(toEmailList.getText());
	    waitForElementToPresent(selectCampaign);
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
	    click(sendBtn,"send email");
	    Thread.sleep(2000);
	   /* String Message = SuccessPopup.getText();
	    * 
	   
		picture();
		System.out.println(Message); */
	
	}
	
	public void emailWithEditor(String communityName) throws InterruptedException{
		waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
		System.out.println(communityName);
	    selectByVisibleText(communityDropdown,communityName,communityName);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(2000);
	    waitForElementToPresent(selectCampaign);
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
	    Thread.sleep(2000);
	    click(emailEmoticon,"emoticons");
	    click(smileyEmoticon,"smiley");
	    click(sendBtn,"send email");
	    Thread.sleep(4000);
	    /*String Message = SuccessPopup.getText();
	    
	    
		picture();
		System.out.println(Message);
		*/
	
		
	}
	public void saveDraft(String communityName) throws InterruptedException{
		waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
		System.out.println(communityName);
	    selectByVisibleText(communityDropdown,communityName,communityName);
	    Thread.sleep(2000);
	    click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(2000);
	    waitForElementToPresent(selectCampaign);
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
	    Thread.sleep(2000);
	    click(saveBtn,"saving the draft");
	    Thread.sleep(2000);
	   // String actual = driver.switchTo().alert().getText();
	   // System.out.println(actual);
	}
	
	public void selectAllMembers(String communityName) throws InterruptedException{
		waitForElementToPresent(addContacts);
		fileUpload.sendKeys("C:\\Users\\rugup\\OneDrive\\Documents\\testing class.txt");
		/*click(addContacts,"add contacts");
		Thread.sleep(2000);
		System.out.println(communityName);
	    selectByVisibleText(communityDropdown,communityName,communityName);
	    Thread.sleep(4000);
	    click(member1,"member1");
	    click(member2,"member2");
	    click(member3,"member3");
	    //click(nameCheckbox,"name check box");
	    click(SaveBtn,"save button");
	    Thread.sleep(2000);
	    waitForElementToPresent(selectCampaign);
	    selectByVisibleText(selectCampaign,"chamber of commerce","chamber of commerce");
	    Thread.sleep(2000);
	    click(sendBtn,"send email");
	    Thread.sleep(4000);
	   // String actual = driver.switchTo().alert().getText();
	   // System.out.println(actual);*/
	}
	
	public void checkImportContacts(String communityName, String typeName) throws InterruptedException {
		//waitForElementToPresent(mailScheduleCheck);
        waitForElementToPresent(addContacts);		
		click(addContacts,"add contacts");
		Thread.sleep(2000);
	    selectByVisibleText(communityDropdown,communityName,"Import Contacts");
	    Thread.sleep(2000);
	    //click(nameCheckbox,"name check box");
	    //click(SaveBtn,"save button");
	    Thread.sleep(5000);
	    type(nameTextBox,typeName,"duplicate");
	    if(csvFileResult.isDisplayed()) {
	    	Assert.assertTrue(true);
	    	System.out.println("Contact from CSV file is there in Import Contacts list");
	    }
	    
	    }
	   
	/*public String getDateInDDMMYYYY() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
	}*/
	public String getDateInDDMMMYYYY() {

		// SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		String strDate = formatter.format(getDate());
		System.out.println("Date Format with dd MMMM yyyy : " + strDate);
		return strDate;
	}
	    
	 
	}
	
