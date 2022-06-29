package com.cpcommunity.PageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

//	@FindBy(xpath = "//input[@id='CompanyName']")
	@FindBy(xpath = "//*[@class='input-group b2cSelectOrgDiv']/*[@id='organizationName']")//added on 21/03
	WebElement organizationName;

	//@FindBy(xpath = "(//*[@id='BusinessCategories']/..)//input")
	@FindBy(xpath = "//*[@class='select2-search select2-search--inline']/*[@role='textbox']")//added on 21/03
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
//		list.put("email", emailAddress);
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
		waitForElementToPresent(saveAndContinue);
		click(saveAndContinue, "Save And Continue");
		return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);

	}
	//added on 16/05
	@FindBy(xpath="//*[text()='Email address already exists. Please enter a new Email address']")
	WebElement message;
	public void signUpWithExistingEmail(String email) {
		waitForElementToPresent(emailAddress);
		type(this.emailAddress, email, "email Address");
		lastName.click();
		waitForElementToPresent(message);
		if(message.isDisplayed()) {
			System.out.println("User not able to register with existing email");
		}else {
			System.out.println("User  able to register with existing email");
		}
	}

	public void fillOrgDetails(String isNewOrg, String corporateAddress, String organizationName, String website,
			String businessDescription, String businessCategories) throws Exception {
		if (isNewOrg.equalsIgnoreCase("yes")) {
			type(this.corporateAddress, corporateAddress, "corporate Address");
			Thread.sleep(1000);
			this.corporateAddress.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			this.corporateAddress.sendKeys(Keys.ENTER);
			organizationName = organizationName + getSystemCurrentHourIn12Hour();//getDateInDDMMMYYYY()

			type(this.organizationName, organizationName, "organization Name");
			
			click(this.businessCategories, "business Categories");
			type(this.businessCategories, businessCategories, "business Categories");
			// this.corporateAddress.sendKeys(Keys.ENTER);
			WebElement element = driver.findElement(By.xpath("//li[contains(text(),'" + businessCategories + "')]"));
			click(element, businessCategories);
			website = website.replace(".com", "");
			website = website + "+" + currentTime() + ".com";
			type(this.website, website, "website");
			type(this.businessDescription, businessDescription, "business Description");
			selectByVisibleText(noOfEmployees, "151-200", "151-200");

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
		System.out.println(organizationIsAlreadyExists.getText());
	//	picture();

	}

	public AccountVerificationCodePage signupPage(String firstName, String lastName, String emailAddress,String password,
            String confirmPassword,String organizationName,String website, String businessDescription,String phNo,String corporateAddress,String businessCategories)
            throws Exception {
		String date=getDateInDDMMMYYYY().replace(" ", "");
		System.out.println(date);
		organizationName = organizationName +date;
		emailAddress = emailAddress+date+"@sharklasers.com";
        type(this.firstName, firstName, "first Name");
        type(this.lastName, lastName, "last Name");
        type(this.emailAddress, emailAddress, "email Address");
        type(this.password, password, "password");
        type(this.confirmPassword, confirmPassword, "confirm Password");
        type(this.phone, phNo, "phone No");
        type(this.corporateAddress, corporateAddress, "corporate Address");
        Actions ac = new Actions(driver);
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ENTER).build().perform();
        type(this.organizationName, organizationName, "organization Name");
        type(this.website, website, "website");
        type(this.businessDescription, businessDescription, "business Description");
        click(noOfEmployees,"No Of Employees");
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ENTER).build().perform();
        type(this.businessCategories,businessCategories,"Business Categories");
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2500);
        ac.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
        click(saveAndContinue, "Save And Continue");
        return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);

    }
	
	public AccountVerificationCodePage signupExistingORG(String firstName, String lastName, String emailAddress,String password, 
			String confirmPassword,String phNo, String organizationName)
			throws Exception {
		
		type(this.firstName, firstName, "first Name");
		type(this.lastName, lastName, "last Name");
		emailAddress = emailAddress.replace("@gmail.com", "");//added on 16/05
		emailAddress = emailAddress + "+" + currentTime() + "@gmail.com";	
		System.out.println(emailAddress);
		type(this.emailAddress, emailAddress, "email Address");
		
		type(this.password, password, "password");
		type(this.confirmPassword, confirmPassword, "confirm Password");
		type(this.phone, phNo, "phone No");
		type(this.organizationName, organizationName, "organization Name");
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		ac.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		click(saveAndContinue, "Save And Continue");
		return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);
		
	}
	
	public AccountVerificationCodePage signupPageWithoutORG(String firstName, String lastName, String emailAddress,String password, 
			String confirmPassword,String phNo) throws Throwable
	{
		type(this.firstName, firstName, "first Name");
		type(this.lastName, lastName, "last Name");
		type(this.emailAddress, emailAddress, "email Address");
		type(this.password, password, "password");
		type(this.confirmPassword, confirmPassword, "confirm Password");
		type(this.phone, phNo, "phone No");
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		ac.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		click(saveAndContinue, "Save And Continue");
		return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);
	}
	//added on 21/03 for send button
	 @FindBy(xpath = "//*[@class='form-group']/*[@ng-click='SiData.SendVerificationCode(SiData.Sendcodeby)']")
	 WebElement sendButton ;
	public void send() throws InterruptedException {
		
		waitForElementToPresent(sendButton);
		click(sendButton,"send button");
		
		
	}
	 @FindBy(xpath = "//*[@form='code-verify']")
	WebElement textBox;
	 @FindBy(xpath = "//*[@value='VERIFY']")
	 WebElement verify;
	 Gmail gmail=new Gmail();
	 public void enterCode() {
		

	System.out.println(gmail.code);
//	textBox.sendKeys(gmail.code);
//	click(verify,"verify");
	
	 }
	public void newTab() {
	//	driver.switchTo().Window(WindowType.TAB);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
}
	public void backToOldTab() {
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		}
	@FindBy(xpath="(//*[@ng-data='plan.data'])[21]")
			WebElement unlimitedPlan;
	@FindBy(xpath="//*[@ng-click='OnSubmitPlan()']")
	WebElement submitBtn;
	@FindBy(xpath="//*[@id='btnconfirm']")
	WebElement okBtn;
	public void selectPlan() {
		scrollDownVertically();
		click(unlimitedPlan,"select plan");
		waitForElementToPresent(submitBtn);
		click(submitBtn,"Submit button");
		waitForElementToPresent(okBtn);
		click(okBtn,"OK button");

	}
	}
