package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class LoginPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		updateClass(pageheader, "");

		aShot();

	}

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@FindBy(xpath = "//*[@name='Email']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(.,'Login')]")
	WebElement LoginBtn;

	@FindBy(xpath = "//div[@class='user-text']")
	WebElement usertext;

	@FindBy(xpath = "//li[contains(text(),'Invalid login credentials. Please try again')]")
	WebElement Invalidlogin;

	@FindBy(xpath = "//a[contains(text(),'click here')]")
	WebElement ClickHere;

	@FindBy(xpath = "//div[@class='col-xs-12 text-right']//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//input[@readonly]")
	WebElement ResendEmail;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//a[@class='forgot-password']")
	WebElement forgotPassword;

	@FindBy(xpath = "//*[contains(text(),'Sign up')]")
	WebElement signup;

	@FindBy(xpath = "//*[contains(text(),'Not a member? Click here to Signup')]")
	WebElement clickHereToSignup;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Login Page");

		return ExpectedConditions.visibilityOf(LoginBtn);
	}

	// public FaceBookPage clickOnFacewbook() {
	// Facebook.click();
	// return (FaceBookPage) openPage(FaceBookPage.class);
	//// new FaceBookPage(driver, );
	// }
	//
	public ForgotPasswordPage clickOnForgotpassword() {
		click(forgotPassword, "forgot Password");
		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}

	public void login(String enterEmailAddress, String password) {
		type(this.emailAddress, enterEmailAddress, "email address");
		type(this.password, password, "password");
		click(LoginBtn, "Login");
	}

	// public MyDashboardPage loginToApplication(String enterEmailAddress, String
	// password) {
	public EcoSystemPage loginToApplication(String enterEmailAddress, String password) {
		this.login(enterEmailAddress, password);
		return (EcoSystemPage) openPage(EcoSystemPage.class);
		// new MyDashboardPage(driver, );
	}

	public SystemAdminDashboardPage SystemAdminloginToApplication(String EmailAddress, String password) {
		this.login(EmailAddress, password);
		return (SystemAdminDashboardPage) openPage(SystemAdminDashboardPage.class);
		// new SystemAdminDashboardPage(driver, );
	}

	// public PendingCommunitiesPage SystemAdminloginToRejctCommunity(String
	// enterEmailAddress, String password) {
	// this.login(enterEmailAddress, password);
	// return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
	//// new PendingCommunitiesPage(driver, );
	// }

	public void InvalidloginToApplication(String EmailAddress, String password) {

		this.login(EmailAddress, password);
		waitForElementToPresent(Invalidlogin);
		Invalidlogin.isDisplayed();

		// new LoginPage(driver, );
	}

	public JoinUserCommunity joinUserCommunityLogin(String emailAddress, String password) {

		this.login(emailAddress, password);
		return (JoinUserCommunity) openPage(JoinUserCommunity.class);
	}

	public void accountLocked(String EmailAddress, String password) throws Exception {

		this.login(EmailAddress, password);
		waitForElementToPresent(Invalidlogin);
		emailAddress.clear();
		this.password.clear();
		this.login(EmailAddress, password);
		Thread.sleep(3000);
		emailAddress.clear();
		this.password.clear();
		this.login(EmailAddress, password);
	}

	public void ReSend_Email_Verification_Confirmation(String EmailAddress, String password) {

		this.login(EmailAddress, password);
		waitForElementToPresent(ClickHere);
		picture();
		click(ClickHere, "Click Here");
		waitForElementToPresent(submitBtn);
		AssertionHelper.verifyText(EmailAddress, ResendEmail.getText());
		picture();
		click(submitBtn, "submitBtn");
		waitForElementToPresent(toastMessage);

		String m = "Verification email has been sent to " + EmailAddress;
		AssertionHelper.verifyText(m, toastMessage.getText());
		picture();

	}

	public void signup() {

		click(signup, "sign up");
	}

	public void clickHereToSignup() {

		click(clickHereToSignup, "Click Here To Signup");
	}

}

// public JoinUserCommunity joinUserCommunityLogin(String enterEmailAddress,
// String password) {
//
// this.login(enterEmailAddress, password);
// return (JoinUserCommunity) openPage(JoinUserCommunity.class);
//// new JoinUserCommunity(driver, );
// }

// public void clickOnClickHereLink() {
// log.info("clicking on Click Here...");
//// logExtentReport("clicking on Click Here...");
// waitForElementToPresent(ClickHere, ObjectReader.reader.getExplicitWait());
// click(ClickHere,"ClickHere");
// }

// public boolean verifySuccessLoginMsg() {
// return new VerificationHelper(driver).isDisplayed(usertext);
// }

// public boolean verifyInvalidlogin() {
// return new VerificationHelper(driver).isDisplayed(Invalidlogin);
// }
//
// public boolean LoginPagedisplayed() {
// return new VerificationHelper(driver).isDisplayed(LoginBtn);
// }
//
// public boolean verificationMailSent() {
//
// return true;
// }

// public ZohoCRMPage gotoCRM() {
//
// click(crm,"CRM Link");
// return () openPage(.class);
// }
//
// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
