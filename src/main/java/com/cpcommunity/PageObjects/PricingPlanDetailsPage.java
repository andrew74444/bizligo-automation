package com.cpcommunity.PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PricingPlanDetailsPage extends BasePage {

	@FindBy(xpath = "//h2[contains(text(),'Pricing Plan Details')]")
	WebElement pricingPlanDetailsTitle;

	@FindBy(xpath = "(//*[@class='row plan-detail-cont']//*[contains(text(),'$')]/..)/span")
	WebElement price;
	
	@FindBy(xpath = "((//*[@class='row plan-detail-cont'])[1])//*[@ng-bind='data.PricingPlanDetails.Name']")
	WebElement pricingPlanName;
	@FindBy(xpath = "//*[contains(text(),'Date')]//*[@ng-bind='data.PricingPlanDetails.StartDateStr']")
	WebElement startDate;
	@FindBy(xpath = "//*[contains(text(),'Date')]//*[@ng-bind='data.PricingPlanDetails.EndDateStr']")
	WebElement endDate;
	@FindBy(xpath = "//*[contains(text(),'Number of Admins: Upto')]//*")
	WebElement numberofAdmins;
	@FindBy(xpath = "//*[contains(text(),'Number of Groups: Upto')]//*")
	WebElement numberofGroups;
	@FindBy(xpath = "//*[contains(text(),'Number of Members: Upto')]//*")
	WebElement numberofMembers;
	@FindBy(xpath = "//*[contains(text(),'Storage: ')]//*")
	WebElement storage;
	@FindBy(xpath = "//*[contains(text(),'Support: ')]//*")
	WebElement support;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]")
	WebElement featurescontains;
	 @FindBy(xpath = "//a[normalize-space()='Email Templates']")
	    WebElement emailtemplate;
	
	public void checkFeaturedisbled(String feature) {
		driver.findElement(By.xpath("((//*[@class='row plan-detail-cont'])[2]//*[contains(text(),'" + feature
				+ "')]/..)//i[@class='fa fa-times-circle']"));
	}

	public void checkFeatureEnabled(String feature) {
		driver.findElement(By.xpath("((//*[@class='row plan-detail-cont'])[2]//*[contains(text(),'" + feature
				+ "')]/..)//i[@class='fa fa-check-circle-o']"));
	}

	public void checkPlanDetails(HashMap<String, String> ftr_list) {
		
		if (ftr_list.containsKey("Events")) {
			checkFeatureEnabled("Events");
		} else {
			checkFeaturedisbled("Events");
		}
		if (ftr_list.containsKey("Advertisements")) {
			checkFeatureEnabled("Advertisements");
		} else {
			checkFeaturedisbled("Advertisements");
		}
		if (ftr_list.containsKey("Manage Campaign")) {
			checkFeatureEnabled("Manage Campaign");
		} else {
			checkFeaturedisbled("Manage Campaign");
		}
		if (ftr_list.containsKey("Payment Gateways")) {
			checkFeatureEnabled("Payment Gateways");
		} else {
			checkFeaturedisbled("Payment Gateways");
		}
		if (ftr_list.containsKey("Groups")) {
			checkFeatureEnabled("Groups");
		} else {
			checkFeaturedisbled("Groups");
		}
		if (ftr_list.containsKey("Zoom")) {
			checkFeatureEnabled("Zoom");
		} else {
			checkFeaturedisbled("Zoom");
		}
		if (ftr_list.containsKey("Surveys")) {
			checkFeatureEnabled("Surveys");
		} else {
			checkFeaturedisbled("Surveys");
		}
		if (ftr_list.containsKey("Membership Plans")) {
			checkFeatureEnabled("Membership Plans");
		} else {
			checkFeaturedisbled("Membership Plans");
		}
		if (ftr_list.containsKey("CRM")) {
			checkFeatureEnabled("CRM");
		} else {
			checkFeaturedisbled("CRM");
		}
		if (ftr_list.containsKey("Blog")) {
			checkFeatureEnabled("Blog");
		} else {
			checkFeaturedisbled("Blog");
		}
		
		if (ftr_list.containsKey("Member Activity Report")) {
			checkFeatureEnabled("Member Activity Report");
		} else {
			checkFeaturedisbled("Member Activity Report");
		}
		
		if (ftr_list.containsKey("Community Members")) {
			checkFeatureEnabled("Community Members");
		} else {
			checkFeaturedisbled("Community Members");
		}

		
		verifyText(price.getText(),ftr_list.get("price"));
		verifyText(pricingPlanName.getText(),ftr_list.get("plan Name") );
		verifyText(startDate.getText(), ftr_list.get("startDate"));
		verifyText(endDate.getText(), ftr_list.get("endDate"));
		verifyText(numberofAdmins.getText(), ftr_list.get("Number of Admins"));
		
		verifyText(numberofGroups.getText(), ftr_list.get("Number of Groups"));
		verifyText(numberofMembers.getText(),ftr_list.get("Number of Members") );
		verifyText(storage.getText(), ftr_list.get("Storage"));
		verifyText(support.getText(), ftr_list.get("Support"));
		
		
		

		
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pricingPlanDetailsTitle);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();

	}
    public void checkJobsPresent() {
    	String expected=this.featurescontains.getText();
    	String actual="Jobs";
    	System.out.println("Jobs is not Present in Pricing Plan Page");
    	Assert.assertNotEquals(actual, expected, "Job is not present");
    }
    public EmailTemplatePage navigateToEmailTemplate() {

		click(emailtemplate, "Email Template");
		return (EmailTemplatePage) openPage(EmailTemplatePage.class);
	}
}