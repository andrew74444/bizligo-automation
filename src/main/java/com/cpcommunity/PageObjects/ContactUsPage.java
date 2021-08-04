package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class ContactUsPage extends BasePage{
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(contactUs);
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Contact Us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	WebElement contactUsBtb;
	
	@FindBy(xpath = "//input[@id='ContactName']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='Organization']")
	WebElement organization;
	
	@FindBy(xpath = "//input[@id='MailingAddress']")
	WebElement mailingAdd;
	
	@FindBy(xpath = "//input[@id='ContactPhone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='ContactEmail']")
	WebElement email;
	
	@FindBy(xpath = "//select[@id='ContactPreference']")
	WebElement contactPreference;
	
	@FindBy(xpath = "//textarea[@id='Details']")
	WebElement comments;
	
	@FindBy(xpath = "//input[@id='ReleaseInfo']")
	WebElement yesBtn;
	
	@FindBy(xpath = "//input[@id='ReleaseInfo1']")
	WebElement noBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement reset;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//div[@class='bootstrap-dialog-message']")
	WebElement successMsg;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//p[@id='ContentID']")
	WebElement contentBelowComments;
	
	
	public void verifyContactPage() {
		if(contactUs.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Guest Member able to access Contact Us page");
		}else Assert.assertTrue(false);
		
	}
	public void verifyContactPageWhenSuperAdminDisable() {
		if(contactUs.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Guest Member able to access Contact Us page");
		}else Assert.assertTrue(false);
		
	}
	public void checkAndSubmitEquiryForm(String Name,String Organization,String Address,String Phone,String Email,String Comments) throws InterruptedException {
		type(name,Name,Name);
		type(organization,Organization,Organization);
		type(mailingAdd,Address,Address);
		type(phone,Phone,Phone);
		type(email,Email,Email);
		type(comments,Comments,Comments);
		click(submit,"Submit");
		Thread.sleep(3000);
		waitForElementToPresent(successMsg);
		System.out.println(successMsg.getText());
		if(successMsg.getText().equalsIgnoreCase("Your Enquiry is received. We will respond to you shortly.")) {
			System.out.println("Member able to submit enquiry form from ContactUs Page");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		click(closeBtn,"Close");
	}
	public void clientNameBySuperAdmin(String Name) {
		waitForElementToPresent(contentBelowComments);
		String x=contentBelowComments.getText();
		System.out.println(x);
		if (x.contains(Name)) {
			System.out.println("Client name by super admin is displayed on Contact Us page");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		
	}

}
