package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class ComposeCampaign extends BasePage {

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
	
	
	@FindBy(xpath = "//*[@class='toast-message'][contains(text(),'Bulk Mail sent.')]")
	WebElement toastMessage;
	@FindBy(xpath = "//div[@class='toast-title']")
	WebElement toasttitle;
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//label[@id='toLabel']")
	WebElement ToLabel;
	@FindBy(xpath = "//input[@id='subject']")
	WebElement subjectField;
	@FindBy(xpath = "//iframe[@id='myEditor_0_ifr']")
	WebElement MessageField;
	@FindBy(xpath = "//input[@id='MultiFileUpload']")
	WebElement Upload;
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement Reset;
	@FindBy(xpath = "//button[@class='btn btn-info']")
	WebElement Save;
	@FindBy(xpath = "//button[normalize-space()='Send']")//button[@class='btn-primary btn btn-close']//i[@class='fa fa-paper-plane']
	WebElement Send;
	@FindBy(xpath = "//input[@id='MailScheduleCheck']")
	WebElement mailCheck;
	@FindBy(xpath = "//div[@id='ContactsModal']//div[@class='modal-dialog']")
	WebElement addContactdialogmodal;
	@FindBy(xpath="//h3[normalize-space()='Compose Campaign']")
	WebElement panelTitle;
	@FindBy(xpath="//a[normalize-space()='Add Contacts']")
	WebElement addContacts;
	@FindBy(xpath="//optgroup[@label='Communities']")
	WebElement optcommunities;
	@FindBy(xpath="//select[@ng-model='SelectedContactType']")
	WebElement dropdown;
	@FindBy(xpath="//optgroup[@label='Groups']")
	WebElement optGroups;
	@FindBy(xpath="//div[@id='1623947906722-0-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']")
	WebElement clickselect;
	@FindBy(xpath="//div[@id='ContactsModal']//button[@id='saveImage']")
	WebElement saveAddContacts;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement selectcommunities;
	@FindBy(xpath="//div[@class='host']")
	WebElement addedEmails;
	@FindBy(xpath="//div[@title='Bip-Pharma New Products Launch 2021']")
	WebElement upcomingeventRegistered;
	@FindBy(xpath="//div[@class='ui-grid-cell-contents ng-binding ng-scope']")
	WebElement SelectedEventsCount;
	@FindBy(xpath="//div[@title='BDMAI Annual Day Celebrations & Pharma product launch']")
	WebElement pasteventRegistered;
	@FindBy(xpath="//div[contains(text(),'8')]")
	WebElement totalNumbersupcomingEvent;
	@FindBy(xpath="//div[contains(text(),'5')]")
	WebElement totalNumberspastEvent;
	@FindBy(xpath="//div[@id='1623947906722-0-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope ui-grid-row-selected']")
	WebElement selectedFirstEvent;
	@FindBy(xpath="//div[@id='1623947906722-1-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope ui-grid-row-selected']")
	WebElement selectedSecondEvent;
	@FindBy(xpath="//div[@id='1623947906722-1-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']")
	WebElement selectSecondEvent;
	@FindBy(xpath="//div[@ng-class=\"{'ui-grid-all-selected': grid.selection.selectAll}\"]")
	WebElement selectAll;
	@FindBy(xpath="///div[@id='1623947906722-0-uiGrid-0004-cell']//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']")
	WebElement selectFirstEvent;
	@FindBy(xpath="//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0007']//div[@role='columnheader']//div//input[@aria-label='Filter for column']")
	WebElement SearchEventsname;
	@FindBy(xpath="//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0008']//div[@role='columnheader']//div//input[@aria-label='Filter for column']")
	WebElement SearchEmailID;
	@FindBy(xpath="//select[@id='SelectCampaigndrop']")
	WebElement selectCampaign;
	@FindBy(xpath="//option[contains(text,'selectCampaign')]")
	List<WebElement> selectCampaigntemplate;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[8]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	List<WebElement> select1Group;
	@FindBy(xpath="//input[@id='MailScheduleCheck']")
	WebElement scheduleDate;
	@FindBy(xpath="//input[@id='BulkMailDateSchedular']")
	WebElement PickScheduleDate;
	@FindBy(xpath="//input[@id='BulkMailDateSchedular']")
	WebElement ScheduleDatebox;
	@FindBy(xpath="//body[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[1]")
	WebElement ScheduleDateselect;
	//body[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[1]
	@FindBy(xpath="//div[@ng-click='selectButtonClick(row, $event)']")
	WebElement selectEventclick;
	@FindBy(xpath="//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0008']//div[@role='columnheader']//div//div[@class='ui-grid-filter-container ng-scope']")
	WebElement searchContactsemail;
	@FindBy(xpath="//div[@title='Aana Mack']")
	WebElement Contactsemail;
	@FindBy(xpath="//div[@title='test1@gmail.com']")
	List<WebElement> email;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement ImportContacts;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	@FindBy(xpath="//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope']")
	List<WebElement> ListOfContacts;
	@FindBy(xpath="//button[@ng-click='closePopup()']//span[@aria-hidden='true'][normalize-space()='×']")
	WebElement cancelPopup;
	
	
	public void Addcontact(String Campaign, String Message) throws InterruptedException { 
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		//click(dropdown, "Select options");
		//selectByVisibleText(optcommunities, Communities, "Communities");
		selectUsingIndex(dropdown, 1, "Communities");
		Thread.sleep(2000);
		scrollIntoView(selectcommunities);
		waitForElementToPresent(selectcommunities);
		click(selectcommunities, "clickselect");
		waitForElementToPresent(saveAddContacts);
		click(saveAddContacts, "Save");
		Thread.sleep(3000);
		waitForElementToPresent(addedEmails);
		waitForElementToPresent(selectCampaign);
		selectByVisibleText(selectCampaign,Campaign, "Campaign");
		Thread.sleep(2000);
		scrollIntoView(MessageField);
		waitForElementToPresent(MessageField);
		//type(MessageField,Message, "Message");
		Thread.sleep(2000);
		scrollIntoView(scheduleDate);
		//waitForElementToPresent(scheduleDate);
		click(scheduleDate, "Date");
		waitForElementToPresent(ScheduleDatebox);
		clickElementByJavaScript(ScheduleDateselect);
		scrollIntoView(Send);
		waitForElementToPresent(Send);
		click(Send, "Send");
		//AssertionHelper.verifyText(toastMessage.getText(), "Success!");
		
	}
	public void UpcomingEventcheck(String Events) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		//click(dropdown, "Select options");
		selectByVisibleText(dropdown, Events, "Upcoming Events");
		//selectUsingIndex(dropdown, 3, "Events");
		Thread.sleep(2000);
		click(selectAll, "selectAllEvent");
		waitForElementToPresent(upcomingeventRegistered);
		String eventname=this.upcomingeventRegistered.getText();
		System.out.println("Event: " +eventname);
		//Thread.sleep(2000);
		//scrollIntoView(totalNumbersEvent);
		waitForElementToPresent(totalNumbersupcomingEvent);
		String Totalevents=this.totalNumbersupcomingEvent.getText();
		System.out.println("Total Event Count: " +Totalevents);
		waitForElementToPresent(selectAll);
		
		if(selectAll.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public void PastEventCheck(String Events2) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		Thread.sleep(2000);
		selectByVisibleText(dropdown, Events2, "Past Events");
		Thread.sleep(2000);
		waitForElementToPresent(pasteventRegistered);
		String eventname=this.pasteventRegistered.getText();
		System.out.println("Event: " +eventname);
		//Thread.sleep(2000);
		//scrollIntoView(totalNumbersEvent);
		waitForElementToPresent(totalNumberspastEvent);
		String Totalevents=this.totalNumberspastEvent.getText();
		System.out.println("Total Event Count: " +Totalevents);
		
		if(pasteventRegistered.isDisplayed()&&totalNumberspastEvent.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	public void AllMember(String Members) throws InterruptedException {
		
		selectByVisibleText(dropdown, Members, "Events");
		Thread.sleep(2000);
		click(selectAll, "selectAllEvent");
		waitForElementToPresent(selectAll);
		if(selectAll.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
}
	
	public void SendEvents(String Events, String EventsName, String Campaign) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		//selectUsingIndex(dropdown, 3, "Events");
		Thread.sleep(1000);
		selectByVisibleText(dropdown,Events, "Events");
		Thread.sleep(1000);
		scrollIntoView(SearchEventsname);
		waitForElementToPresent(SearchEventsname);
		Thread.sleep(1000);
		type(SearchEventsname,EventsName, "Events Name");
		waitForElementToPresent(selectAll);
		Thread.sleep(1000);
		click(selectAll, "select EventName");
		waitForElementToPresent(saveAddContacts);
		click(saveAddContacts, "Save");
		Thread.sleep(3000);
		waitForElementToPresent(selectCampaign);
		selectByVisibleText(selectCampaign,Campaign, "Campaign");
		Thread.sleep(2000);
		scrollIntoView(Send);
		waitForElementToPresent(Send);
		click(Send, "Send");
		/*String toastmessage = toastMessage.getText();
		//AssertionHelper.verifyText(toastMessage.getText(), "Success!");
		//System.out.println(toasttitle);
		System.out.println(toastmessage);
		String expected="Bulk Mail sent.";
		if(toastmessage.equalsIgnoreCase(expected)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("fail");
		}*/
	}
		public void checkAddedContacts(String importedContacts, String Email1) throws InterruptedException {
			waitForElementToPresent(addContacts);
			click(addContacts, "Add Contacts");
			Thread.sleep(2000);
			waitForElementToPresent(addContactdialogmodal);
			waitForElementToPresent(dropdown);
			Thread.sleep(2000);
			getAllDropDownData(dropdown);
			selectByVisibleText(dropdown,importedContacts, "Imported contacts");
			//selectUsingIndex(dropdown,18, "ImportedContacts");
			Thread.sleep(4000);
			waitForElementToPresent(SearchEventsname);
			type(SearchEventsname,Email1, "importedContacts");
			String Name=this.Contactsemail.getText();
			if(Name.contains("Aana Mack")) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}	
			
		}
		public void checkNotImported(String importedContacts, String Email1) throws InterruptedException {
			waitForElementToPresent(addContacts);
			click(addContacts, "Add Contacts");
			//driver.switchTo().frame(1);
			Thread.sleep(2000);
			waitForElementToPresent(addContactdialogmodal);
	       Thread.sleep(2000);
			waitForElementToPresent(dropdown);
			selectByVisibleText(dropdown,importedContacts, "Imported contacts");
			Thread.sleep(5000);
			waitForElementToPresent(SearchEmailID);
			type(SearchEmailID,Email1, "importedContacts");
			Thread.sleep(2000);
			waitForElementToPresent(email);
			int emaildim =this.email.size();
			if(emaildim==1) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
				
			
		}
		public void CheckMember(String importedContacts, String Member ) throws InterruptedException {
			waitForElementToPresent(addContacts);
			click(addContacts, "Add Contacts");
			//driver.switchTo().frame(1);
			Thread.sleep(2000);
			waitForElementToPresent(addContactdialogmodal);
	       Thread.sleep(2000);
			waitForElementToPresent(dropdown);
			selectByVisibleText(dropdown,importedContacts, "Imported contacts");
			Thread.sleep(3000);
			waitForElementToPresent(SearchEventsname);
			type(SearchEventsname,Member, "importedContacts");
			Thread.sleep(2000);
		   waitForElementToPresent(email);
		    int emailval=email.size();
		    System.out.println(emailval);
		    Thread.sleep(6000);
		    waitForElementToPresent(cancelPopup);
		    click(cancelPopup, "Cancel");
			
		}
		public void VerifyAddedContacts(String importedContacts, String Email2) throws InterruptedException {
			waitForElementToPresent(addContacts);
			click(addContacts, "Add Contacts");
			Thread.sleep(2000);
			waitForElementToPresent(addContactdialogmodal);
			waitForElementToPresent(dropdown);
			Thread.sleep(2000);
			getAllDropDownData(dropdown);
			selectByVisibleText(dropdown,importedContacts, "Imported contacts");
			//selectUsingIndex(dropdown,18, "ImportedContacts");
			Thread.sleep(4000);
			waitForElementToPresent(SearchEventsname);
			type(SearchEventsname,Email2, "importedContacts");
			waitForElementToPresent(email);
			//String Name=this.Contactsemail.getText();
			 int emailval1=email.size();
			 if(emailval1>1) {
				 Assert.assertTrue(true);
			 }
			 else {
				 Assert.assertTrue(false);
			 }
			
		}
		
	public void SendToGroups(String Campaign) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		selectUsingIndex(dropdown, 2, "Groups");
		Thread.sleep(3000);
		waitForElementToPresent(selectAll);
		click(selectAll, "Select");
		Thread.sleep(2000);
		waitForElementToPresent(saveAddContacts);
		click(saveAddContacts, "Save");
		Thread.sleep(3000);
		waitForElementToPresent(selectCampaign);
		selectByVisibleText(selectCampaign, Campaign, "Campaign");
		Thread.sleep(2000);
		scrollIntoView(Send);
		waitForElementToPresent(Send);
		click(Send, "Send");
		Thread.sleep(3000);
		waitForElementToPresent(toasttitle);
		//Thread.sleep(3000);
		String toasttile=toasttitle.getText();
		//String toastmessage = toastMessage.getText();
		AssertionHelper.verifyText(toasttitle.getText(), "Success");
		System.out.println(toasttitle);
		//System.out.println(toastmessage);
		String expected="Success!";
		if(toasttitle.equals(expected)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("fail");
		}
	}
	private void waitForElementToPresent(List<WebElement> select1Group2) {
		// TODO Auto-generated method stub
		
	}

	private void click(List<WebElement> clickselect2, String elementName) {
		// TODO Auto-generated method stub
		
	}

	private void scrollIntoView(List<WebElement> clickselect2) {
		// TODO Auto-generated method stub
		
	}
	
	public void CheckMembercount(String importedContacts ) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		//click(dropdown, "Select options");
		selectByVisibleText(dropdown,importedContacts, "Imported contacts");
		//selectUsingIndex(dropdown, 5, "Organisation");
		Thread.sleep(2000);
		waitForElementToPresent(ListOfContacts);
		int count=this.ListOfContacts.size();
		System.out.println(count);
		
		
	}
	public ImportContactsPage navigateToImportContactsPagePage() throws Exception {
		Thread.sleep(3000);
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(500);
		waitForElementToPresent(ImportContacts);
		this.ImportContacts.click();	
		//click(composeCampaign, "composeCampaign");
		return (ImportContactsPage) openPage(ImportContactsPage.class);
		
	}
	public void AddContacts(String ContactsValue) throws InterruptedException {
		waitForElementToPresent(addContacts);
		click(addContacts, "Add Contacts");
		//driver.switchTo().frame(1);
		Thread.sleep(2000);
		waitForElementToPresent(addContactdialogmodal);
       Thread.sleep(2000);
		waitForElementToPresent(dropdown);
		//click(dropdown, "Select options");
		selectByVisibleText(dropdown,ContactsValue, "Organisation");
		//selectUsingIndex(dropdown, 7, "Organisation");
		Thread.sleep(2000);
		scrollIntoView(selectAll);
		click(selectAll, "clickselect");
		waitForElementToPresent(saveAddContacts);
		click(saveAddContacts, "Save");
		Thread.sleep(2000);
		waitForElementToPresent(addedEmails);
		String val=this.addedEmails.getText();
		System.out.println(val);
		if(addedEmails.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	public void fieldVisibility() throws InterruptedException {
		waitForElementToPresent(panelTitle);
		waitForElementToPresent(addContacts);
		waitForElementToPresent(ToLabel);
		waitForElementToPresent(subjectField);
		waitForElementToPresent(Upload);
		waitForElementToPresent(Reset);
		waitForElementToPresent(Save);
		scrollIntoView(Send);
		waitForElementToPresent(Send);
		
		
		if(panelTitle.isDisplayed()&&addContacts.isDisplayed()&&ToLabel.isDisplayed()&&subjectField.isDisplayed()&&
				Upload.isDisplayed()&&Reset.isDisplayed()&&Save.isDisplayed()&&Send.isDisplayed())
		{
			System.out.println("All search is displaying");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("search is not displaying");
			Assert.assertTrue(false);
		     }
}
	
	public void checkTemplatenotDisplay() {
		waitForElementToPresent(selectCampaign);
		click(selectCampaign, "Select campaign template");
		String value=selectCampaign.getText();
		System.out.println(value);
	    if(value.contains("Bizligo Scheduler test")) {
		Assert.assertFalse(true);
	}
	    else {
	    	Assert.assertFalse(false);
	    }
	}
	public void checkTemplateDisplay() {
		waitForElementToPresent(selectCampaign);
		click(selectCampaign, "Select campaign template");
		String value=selectCampaign.getText();
		System.out.println(value);
	    if(value.contains("Bizligo Scheduler Test")) {
		Assert.assertTrue(true);
	}
	    else {
	    	Assert.assertTrue(false);
	    }
	}
	
	
	
	
}