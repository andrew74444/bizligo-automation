package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.Color;

import com.google.errorprone.annotations.Var;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class EmailTemplatePage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Email Templates']")
	WebElement pageTitle;
	@FindBy(xpath = "//a[@id='Groups']")
	WebElement group;
	@FindBy(xpath = "//a[@id='Events']")
	WebElement events;
	@FindBy(xpath = "//div[@class='row']//div[1]//div[1]//div[1]//div[2]//div[1]//a[1]//i[1]")
	WebElement editevents;
	@FindBy(xpath = "//input[@id='EmailSubject']")
	WebElement emailsubject;
	@FindBy(xpath = "//input[@id='EmailHeader']")
	WebElement emailheader;
	@FindBy(xpath = "//input[@id='FromEmail']")
	WebElement fromEmail;
	@FindBy(xpath = "//body")
	WebElement enterTextInframe;
	//@FindBy(xpath = "//body/p[1]")
	//WebElement enterTextInframes2;
	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//input[@id='BccList']")
	WebElement BCClist;
	@FindBy(xpath = "//input[@id='CcList']")
	WebElement CClist;
	@FindBy(xpath = "//div[@id='toast-container']")
	WebElement toastMessage;
	@FindBy(xpath = "//div[@id='qepmar71vb0g1fa3sij0t']")
	WebElement resettoastMessage;
	@FindBy(xpath = "//input[@id='KeyName']")
	WebElement templateName;
	@FindBy(xpath = "//input[@id='Description']")
	WebElement description;
	@FindBy(xpath = "//button[normalize-space()='Reset Template']")
	WebElement resetTemplate;
    @FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
    WebElement yesProceed;
    @FindBy(xpath = "//div[@class='bootbox-body']")
    WebElement resetmsg;
    @FindBy(xpath = "//a[normalize-space()='Email Templates']")
    WebElement emailtemplate;
    @FindBy(xpath = "//small[normalize-space()='The Email subject is required.']")
    WebElement emailReq;
    @FindBy(xpath = "//small[normalize-space()='The Email header is required.']")
    WebElement emailheaderReq;
    @FindBy(xpath = "//small[normalize-space()='Please enter a value']")
    WebElement fromemailReq;
    @FindBy(xpath = "//div[@class='email-btn-heading']")
    WebElement allFeatures;
    @FindBy(xpath = "//div[@class='emil-edited-icon']//i[@class='fa fa-pencil-square']")
    WebElement editGroup;
    @FindBy(xpath = "//a[normalize-space()='Back to Filters']")
    WebElement backtoFilter;
    @FindBy(xpath = " //a[@id='Advertisements']")
    WebElement advertisements;
    @FindBy(xpath = "  //div[@class='row']//div[1]//div[1]//div[1]//div[2]//div[1]//a[1]//i[1]")
    WebElement advertisementsEdit;
    @FindBy(xpath = "//span[@id='inbox-id']")
	WebElement boxId;
	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement emailName;
	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement setBtn;
	
 
	 public void clickGroup() {
    	 waitForElementToPresent(group);
    	this.group.click();
	
	}
	 public void EditEvents(String Template, String Footer, String Subject, String Header, String Email, String bcc) throws InterruptedException {
    	 waitForElementToPresent(events);
    	this.events.click();
    	waitForElementToPresent(editevents);
    	this.editevents.click();
    	waitForElementToPresent(this.emailsubject);
		this.emailsubject.clear();
		this.emailheader.clear();
		this.fromEmail.clear();
		this.BCClist.clear();
		type(emailsubject, Subject, "Email Subject");
		type(emailheader, Header, "Email Header");
		type(fromEmail, Email, "From Email");
		type(BCClist, bcc, "BCC List");
				
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Header);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, Footer, "Footer");
		driver.switchTo().defaultContent();
		
		click(save, "Save");
		//waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Success! Template changed successfully.");
		Thread.sleep(7000);
	}
	 public void SameCCandBCC(String Template, String Footer, String Subject, String Header, String Email, String bcc, String cc) throws InterruptedException {
    	 waitForElementToPresent(events);
    	this.events.click();
    	waitForElementToPresent(editevents);
    	this.editevents.click();
    	waitForElementToPresent(this.emailsubject);
		this.emailsubject.clear();
		this.emailheader.clear();
		this.fromEmail.clear();
		this.BCClist.clear();
		this.CClist.clear();
		type(emailsubject, Subject, "Email Subject");
		type(emailheader, Header, "Email Header");
		type(fromEmail, Email, "From Email");
		type(BCClist, bcc, "BCC List");
		type(CClist, cc, "BCC List");		
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Header);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, Footer, "Footer");
		driver.switchTo().defaultContent();
		
		click(save, "Save");
		//waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Success! Template changed successfully.");
		Thread.sleep(7000);
	}
	public void CheckTemplateAndDescriptionReadOnly(){
		 waitForElementToPresent(events);
	    	this.events.click();
	    	waitForElementToPresent(editevents);
	    	this.editevents.click();
	    	 WebElement readOnly = this.templateName;
	    	 WebElement readOnly2= this.description;
	         Assert.assertTrue(readOnly.getAttribute("readOnly").equals("true"),"Template ReadOnly");
	         Assert.assertTrue(readOnly2.getAttribute("readOnly").equals("true"),"Description ReadOnly");
	         System.out.println("Template is Read Only");
	         System.out.println("Description is Read Only");
	}
	public void CheckResetTemplateButtonReadOnly() throws InterruptedException{
		    waitForElementToPresent(advertisements);
	    	this.advertisements.click();
	    	waitForElementToPresent(advertisementsEdit);
	    	this.advertisementsEdit.click();
	    	Thread.sleep(2000);
	    	scrollDownVertically();
	    	 WebElement readOnly1 = this.resetTemplate;
	    	 System.out.println("ResetTemplate is Read Only");
	     Assert.assertTrue( true, readOnly1.getAttribute("readOnly1"));
	         System.out.println("ResetTemplate is Read Only");
	
	}
	public void CheckResetTemplateButtonEnable() throws InterruptedException{
		 waitForElementToPresent(events);
	    	this.events.click();
	    	waitForElementToPresent(editevents);
	    	this.editevents.click();
	    	Thread.sleep(2000);
	    	scrollDownVertically();
	    	 WebElement enableMode = this.resetTemplate;
	         Assert.assertTrue(true, enableMode.getAttribute("enableMode"));
	         System.out.println("Reset Template is enable mode");
	         
	}
	 public void ResetTemplate(String Template, String Footer, String Subject, String Header, String Email, String bcc) throws InterruptedException {
    	 waitForElementToPresent(events);
    	this.events.click();
    	waitForElementToPresent(editevents);
    	this.editevents.click();
    	waitForElementToPresent(this.emailsubject);
		this.emailsubject.clear();
		this.emailheader.clear();
		this.fromEmail.clear();
		this.BCClist.clear();
		type(emailsubject, Subject, "Email Subject");
		type(emailheader, Header, "Email Header");
		type(fromEmail, Email, "From Email");
		type(BCClist, bcc, "BCC List");
				
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Header);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, Footer, "Footer");
		driver.switchTo().defaultContent();
		
		click(resetTemplate, "reset Template");
		Thread.sleep(2000);
		click(yesProceed, "leave");
		//takeScreenshotByShutterBug(yesProceed, "Leave Btn");
		//AssertionHelper.verifyText(toastMessage.getText(), "Success! Template changed successfully.");
		
	}
	 public void checkColorOfEditButton() {

			click(emailtemplate, "Email Template");
			waitForElementToPresent(editevents);
			
			String color = this.editevents.getCssValue("color");
			System.out.println(color);
			String hex = Color.fromString(color).asHex();
			System.out.println(hex);
			String expected="#1abb9c";
			Assert.assertEquals(hex,expected);
			
		}
	 public void RequiredFieldValidity(String Subject, String Header, String Email) throws InterruptedException {
    	 waitForElementToPresent(events);
    	this.events.click();
    	waitForElementToPresent(editevents);
    	this.editevents.click();
    	waitForElementToPresent(this.emailsubject);
    	type(emailsubject, Subject, "Email Subject");
    	type(emailheader, Header, "Email Header");
    	 type(fromEmail, Email, "From Email");
	    Thread.sleep(3000);
    	 click(save, "Save");
    	 waitForElementToPresent(emailReq);
    	 String error1=this.emailReq.getText();
    	 String error2=this.emailheaderReq.getText();
    	 String error3=this.fromemailReq.getText();
    	 System.out.println(error1 +"\n"+ error2 +"\n"+ error3);
        
	 }
	 public void checkJobsNotPresent() {
	    	String AllFeatures=this.allFeatures.getText();
	    	String Notpresent="Jobs";
	    	System.out.println("Jobs is not Present in Pricing Plan Page");
	    	Assert.assertNotEquals(Notpresent, AllFeatures, "Job is not present");
	    }
	 public void clickBackToFilter() {
		 waitForElementToPresent(group);
	    	this.group.click();
	    	waitForElementToPresent(editGroup);
	    	click(editGroup, "Edit");
	    	waitForElementToPresent(backtoFilter);
	    	click(backtoFilter, "Back to Filter");
	 }
	 public void CheckCancel(String Template, String Footer, String Subject, String Header, String Email, String bcc) throws InterruptedException {
    	 waitForElementToPresent(events);
    	this.events.click();
    	waitForElementToPresent(editevents);
    	this.editevents.click();
    	waitForElementToPresent(this.emailsubject);
		this.emailsubject.clear();
		this.emailheader.clear();
		this.fromEmail.clear();
		this.BCClist.clear();
		type(emailsubject, Subject, "Email Subject");
		type(emailheader, Header, "Email Header");
		type(fromEmail, Email, "From Email");
		type(BCClist, bcc, "BCC List");
				
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Header);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, Footer, "Footer");
		driver.switchTo().defaultContent();
		
		click(cancel, "cancel");
		waitForElementToPresent(yesProceed);
		click(yesProceed, "Yes Proceed");
	}
	 public void changeFromEmail(String Template, String Footer, String Subject, String Header, String Email, String bcc) throws InterruptedException {
    	 waitForElementToPresent(group);
    	this.group.click();
    	waitForElementToPresent(editGroup);
    	this.editGroup.click();
    	waitForElementToPresent(this.emailsubject);
		this.emailsubject.clear();
		this.emailheader.clear();
		this.fromEmail.clear();
		this.BCClist.clear();
		type(emailsubject, Subject, "Email Subject");
		type(emailheader, Header, "Email Header");
		type(fromEmail, Email, "From Email");
		type(BCClist, bcc, "BCC List");
				
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Header);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		enterTextInframe.clear();
		type(enterTextInframe, Footer, "Footer");
		driver.switchTo().defaultContent();
		
		click(save, "Save");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Success! Your changes saved successfully.");
		Thread.sleep(7000);
	}
	 public void openGuerillamail(String emailName) throws InterruptedException, AWTException {
			// Thread.sleep(5000);
		     //((JavascriptExecutor)driver).executeScript("window.open()");
		    // Thread.sleep(2500);
		    // ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
		     //driver.switchTo().window(wins.get(1));
		     driver.get("https://www.guerrillamail.com/");
		     Thread.sleep(5000);
		     click(boxId,"BoxID");
		     Thread.sleep(5000);
		     this.emailName.clear();
		     Thread.sleep(2000);
		     type(this.emailName, emailName, "emailName");
		     Thread.sleep(5000);
		     click(setBtn,"set Button");
		     Thread.sleep(180000);
		     Actions ac = new Actions(driver);
		     ac.contextClick().build().perform();
		     Thread.sleep(5000);
		     Robot r = new Robot();
		     r.keyPress(KeyEvent.VK_DOWN);
		     Thread.sleep(5000);
		     r.keyPress(KeyEvent.VK_DOWN);
		     Thread.sleep(5000);
		     r.keyPress(KeyEvent.VK_ENTER);
		    // Thread.sleep(1000);
		    // click(emailVerify,"passwordVerify");
		   //  Thread.sleep(1500);
		    // String password = passWord.getText();
		   //  Thread.sleep(2000);
		    // ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
		    // driver.switchTo().window(wins1.get(0));
		     Thread.sleep(8000);
		 }
}
