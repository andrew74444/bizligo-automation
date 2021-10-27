package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class CampaignTemplatePage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(panelTitle);
		return ExpectedConditions.visibilityOf(panelTitle);
	}
//changes
	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath="//h2[normalize-space()='CAMPAIGN E-MAIL TEMPLATES']")
	WebElement panelTitle;
	@FindBy(xpath="//button[normalize-space()='Add Template']")
	WebElement addTemplate;
	@FindBy(xpath = "//a[normalize-space()='Community Admin']")
	WebElement angleDown;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//div[@id='CampaignCtrl']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[2]//div[1]//ul[1]//li[2]//a[1]//i[1]")
	WebElement edit;


	@FindBy(xpath = "//div[@class='email-contarea']//div[3]//div[1]//div[1]//div[2]//div[1]//ul[1]//li[2]//a[1]//i[1]")
	WebElement edit3;

	@FindBy(xpath = "//input[@id='Description']")
	WebElement description;
	@FindBy(xpath = "//input[@id='Name']")
	WebElement name;
	@FindBy(xpath = "//input[@id='EmailSubject']")
	WebElement emailSubject;
	@FindBy(xpath = "//input[@id='EmailHeader']")
	WebElement emailHeader;
	@FindBy(xpath = "//input[@id='FromEmail']")
	WebElement fromEmail;
	@FindBy(xpath = "//iframe[@title='Rich Text Editor, Template']")
	WebElement template;

	//@FindBy(xpath = "//button[normalize-space()='Update']")

	@FindBy(xpath = "//span[@ng-if='data.isEdit']")
	WebElement update;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath = "//div[@class='toggle-group']")
	WebElement togglebutton;
	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(xpath = "//label[@class='btn btn-success toggle-on']")
	WebElement active;
	@FindBy(xpath="//label[@class='btn btn-danger active toggle-off']")
	WebElement inactive;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	
	
	
	public void AddTemplateVisibility() {
		waitForElementToPresent(addTemplate);
		if(addTemplate.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	public HomePage logout() throws InterruptedException {
		Thread.sleep(4000);
	    scrollIntoViewAndClick(angleDown);
		//waitForElementToPresent(angleDown);
		//click(angleDown, "Community Admin Menu Drop down");
		Thread.sleep(2000);
		//waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}
	
	public void edittemplate(String Description, String Name, String Subject, String Header, String Email, String Template) throws InterruptedException {
		waitForElementToPresent(edit);
		click(edit, "Edit");

		Thread.sleep(2000);

		Thread.sleep(4000);

		waitForElementToPresent(description);
		this.description.clear();
		type(description, Description, "Description");
		waitForElementToPresent(name);
		this.name.clear();
		type(name, Name, "Name");
		waitForElementToPresent(emailSubject);
		this.emailSubject.clear();
		type(emailSubject, Subject, "Email Subject");
		waitForElementToPresent(emailHeader);
		this.emailHeader.clear();
		type(emailHeader, Header, "Emal Header");
		waitForElementToPresent(fromEmail);
		this.fromEmail.clear();
		type(fromEmail, Email, "From Email");
		scrollIntoView(template);
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(Template);
		driver.switchTo().defaultContent();
		//scrollDownVertically();
		//waitForElementToPresent(template);
		//this.template.clear();
		
		Thread.sleep(2000);
		scrollIntoViewAndClick(update);
		Thread.sleep(2000);
		AssertionHelper.verifyText(toastMessage.getText(), "Template Updated");
		Thread.sleep(4000);
	}
	public void inactivate() throws InterruptedException {
		waitForElementToPresent(edit);

		click(edit, "Edit");
		Thread.sleep(2000);
		scrollDownVertically();
		waitForElementToPresent(togglebutton);
			click(inactive, "active first");
			Thread.sleep(2000);
			click(active, "Inactive now");
			Thread.sleep(5000);
			waitForElementToPresent(update);
			click(update, "Update");
			Thread.sleep(4000);
	
	}
	public void activate() throws InterruptedException {
		waitForElementToPresent(edit);
		click(edit, "Edit");
		Thread.sleep(2000);
		scrollDownVertically();
		waitForElementToPresent(togglebutton);
		if(active.isDisplayed()) {
			click(active, "InActive now");
			Thread.sleep(2000);
			click(inactive, "Active now");
			Thread.sleep(5000);
			waitForElementToPresent(update);
			click(update, "Update");
			Thread.sleep(4000);
		}
		else {

		click(edit3, "Edit");
		Thread.sleep(8000);
		scrollDownVertically();
		waitForElementToPresent(togglebutton);
		
			click(active, "Active now");
			Thread.sleep(3000);
			
			click(update, "Update");
			Thread.sleep(7000);
		}
	}
		/*else {
			click(inactive, "Active now");
			Thread.sleep(5000);
			click(inactive, "Active now");
			Thread.sleep(3000);
			
			click(update, "Update");
			Thread.sleep(8000);
		}*/
			
	
	
		/*
		 * public void activate() throws InterruptedException { Thread.sleep(4000);
		 * waitForElementToPresent(edit3); click(edit3, "Edit"); Thread.sleep(8000);
		 * scrollDownVertically(); waitForElementToPresent(togglebutton);
		 * 
		 * click(inactive, "Active now"); waitForElementToPresent(update); click(update,
		 * "Update"); Thread.sleep(7000); }
		 */
	
	public void Activate() throws InterruptedException {
		Thread.sleep(4000);
		waitForElementToPresent(edit);
		click(edit, "Edit");
		Thread.sleep(8000);
		scrollDownVertically();
		waitForElementToPresent(togglebutton);
	
			click(inactive, "Active now");
			waitForElementToPresent(update);
			click(update, "Update");
			Thread.sleep(7000);
		}
		/*else {
			click(active, "Active now");
			Thread.sleep(5000);

			click(inactive, "Active now");
			Thread.sleep(5000);
			waitForElementToPresent(update);
			click(update, "Update");
			Thread.sleep(4000);

		}
	
		}
	public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
		//scrollDownVertically();
		Thread.sleep(4000);

		}*/
	
		
	public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
		//scrollDownVertically();
		Thread.sleep(6000);

		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(500);
		waitForElementToPresent(composeCampaign);
		this.composeCampaign.click();	


		Thread.sleep(6000);

		//click(composeCampaign, "composeCampaign");
		return (ComposeCampaign) openPage(ComposeCampaign.class);
		
}
	
	
}
