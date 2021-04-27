package com.cpcommunity.PageObjects;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@FindBy(xpath = "//*[@id='Phone']")
	WebElement phone;

	@FindBy(xpath = "//*[@id='organizationName']")
	WebElement organizationName;

	@FindBy(xpath = "(//*[@id='BusinessCategories']/..)//input")
	WebElement businessCategories;

	@FindBy(xpath = "//*[@id='NoOfEmployees']")
	WebElement noOfEmployees;

	@FindBy(xpath = "//*[@id='Website']")
	WebElement website;

	@FindBy(xpath = "//*[@id='CorporateAddress']")
	WebElement corporateAddress;

	@FindBy(xpath = "//*[@id='BusinessDescription']")
	WebElement businessDescription;

	@FindBy(xpath = "//*[contains(text(),'Save & Continue ')]")
	WebElement saveAndContinue;

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@FindBy(xpath = "//*[contains(text(),'Email address already exists. Please enter a new Email address')]")
	WebElement emailAddressAlreadyExists;

	@FindBy(xpath = "//*[contains(text(),'Organization is already exists')]")
	WebElement organizationIsAlreadyExists;
	
	// @FindBy(xpath = "")
	// WebElement ;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(firstName);
	}

	public ForgotPasswordPage clickOnForgotpassword() {

		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}

	public AccountVerificationCodePage signup(String firstName, String lastName, String emailAddress, String phNo,
			String password, String isB2B, String isNewOrg, String corporateAddress, String organizationName,
			String website, String businessDescription, String businessCategories, String isOrgRequired)
			throws Exception {

		HashMap<String, String> list = new HashMap<String, String>();

		type(this.firstName, firstName, "first Name");
		type(this.lastName, lastName, "last Name");
		emailAddress = emailAddress.replace("@gmail.com", "");
		emailAddress = emailAddress + "+" + currentTime() + "@gmail.com";
		list.put("email", emailAddress);
		type(this.emailAddress, emailAddress, "email Address");
		type(this.phone, phNo, "phone No");
		type(this.password, password, "password");
		type(this.confirmPassword, password, "confirm Password");

		if (isB2B.equalsIgnoreCase("yes")) {
			this.fillOrgDetails(isNewOrg, corporateAddress, organizationName, website, businessDescription,
					businessCategories);
		} else {
			if (isOrgRequired.equalsIgnoreCase("yes")) {
				this.fillOrgDetails(isNewOrg, corporateAddress, organizationName, website, businessDescription,
						businessCategories);
			} else {
				log.info(this.organizationName.isEnabled());
				log.info(this.corporateAddress.isEnabled());
				log.info(this.website.isEnabled());
				log.info(this.businessDescription.isEnabled());
				log.info(this.businessCategories.isEnabled());
			}
		}
		click(saveAndContinue, "Save And Continue");
		return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);

	}

	public void fillOrgDetails(String isNewOrg, String corporateAddress, String organizationName, String website,
			String businessDescription, String businessCategories) throws Exception {
		if (isNewOrg.equalsIgnoreCase("yes")) {
			type(this.corporateAddress, corporateAddress, "corporate Address");
			Thread.sleep(1000);
			this.corporateAddress.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			this.corporateAddress.sendKeys(Keys.ENTER);
			organizationName = organizationName + getDateInDDMMMYYYY();

			type(this.organizationName, organizationName, "organization Name");
			type(this.website, website, "website");
			type(this.businessDescription, businessDescription, "business Description");
			selectByVisibleText(noOfEmployees, "151-200", "151-200");

			click(this.businessCategories, "business Categories");
			type(this.businessCategories, businessCategories, "business Categories");
			// this.corporateAddress.sendKeys(Keys.ENTER);
			WebElement element = driver.findElement(By.xpath("//li[contains(text(),'" + businessCategories + "')]"));
			click(element, businessCategories);

		} else {
			type(this.organizationName, organizationName, "organization Name");
			WebElement ele = driver.findElement(By.xpath(
					"//*[@class='dropdown-menu ng-isolate-scope']//*[contains(text(),'" + organizationName + "')]"));
			click(ele, organizationName);
			Thread.sleep(10000);
			log.info(this.organizationName.isEnabled());
			log.info(this.corporateAddress.isEnabled());
			log.info(this.website.isEnabled());
			log.info(this.businessDescription.isEnabled());
			log.info(this.businessCategories.isEnabled());
		}
	}

	public void checkUserAbleToSignUpWithExsitingEmail(String emailAddress) {

		type(this.emailAddress, emailAddress, "email Address");
		waitForElementToPresent(emailAddressAlreadyExists);
		picture();

	}

	public void checkUserAbleToSignUpWithExsitingOrganizationName(String orgName) {
		type(this.organizationName, orgName, "org Name");
		click(password, "password");
		waitForElementToPresent(organizationIsAlreadyExists);
		picture();

	}

}
