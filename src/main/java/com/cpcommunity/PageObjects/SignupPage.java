package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class SignupPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		updateClass(pageheader, "");

		aShot();

	}

	@FindBy(xpath = "//*[@name='FirstName']")
	WebElement firstName;

	@FindBy(xpath = "//*[@name='LastName']")
	WebElement lastName;

	@FindBy(xpath = "//*[@name='EmailAddress']")
	WebElement emailAddress;

	@FindBy(xpath = "//*[@name='Password']")
	WebElement password;

	@FindBy(xpath = "//*[@name='ConfirmPassword']")
	WebElement confirmPassword;

	@FindBy(xpath = "//*[@id='organizationName']")
	WebElement organizationName;

	@FindBy(xpath = "//*[@id='BusinessCategories']")
	WebElement businessCategories;

	@FindBy(xpath = "//*[@id='NoOfEmployees']")
	WebElement noOfEmployees;

	@FindBy(xpath = "//*[@id='Website']")
	WebElement website;

	@FindBy(xpath = "//*[@id='corporateAddress']")
	WebElement corporateAddress;
	
	@FindBy(xpath = "//*[@id='BusinessDescription']")
	WebElement businessDescription;

	@FindBy(xpath = "//*[contains(text(),'Save & Continue ')]")
	WebElement saveAndContinue;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
//
//	@FindBy(xpath = "")
//	WebElement ;
//
//	@FindBy(xpath = "")
//	WebElement ;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		

		return ExpectedConditions.visibilityOf(firstName);
	}

	public ForgotPasswordPage clickOnForgotpassword() {

		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}

}