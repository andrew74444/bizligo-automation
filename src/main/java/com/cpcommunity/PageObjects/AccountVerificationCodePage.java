package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cpcommunity.utilities.DriverManager;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class AccountVerificationCodePage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		updateClass(pageheader, "");

		aShot();

	}

	@FindBy(xpath = "//input[@value='SEND']")
	WebElement send;

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@FindBy(xpath = "//input[@id='verify-code']")
	WebElement verifyCode;

	@FindBy(xpath = "//input[@value='VERIFY']")
	WebElement verifyBtn;

	

	@FindBy(xpath = "//*[contains(text(),'Your Email is Verified Successfully. Please click on Ok to purchase the membership plan')]")
	WebElement YourEmailisVerifiedSuccessfullyPleaseClickOnOkToPurchaseTheMembershipplan;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okBtn;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(send);
	}

	public ForgotPasswordPage clickOnForgotpassword() {

		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}

	public void clickOnSend() throws Exception {

		click(send, "send");
		Thread.sleep(3000);
//		return(AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);

	}

	public String getURL() throws Exception {

		return DriverManager.getDriver().getCurrentUrl();

	}

	public AccountSelectPlansPage verifyCode(String otp) {

		picture();
		waitForElementToPresent(verifyCode);
		type(verifyCode, otp, "verification Code: " + otp);
		picture();
		click(verifyBtn, "verify Button");
		waitForElementToPresent(okBtn);
		picture();
		YourEmailisVerifiedSuccessfullyPleaseClickOnOkToPurchaseTheMembershipplan.isDisplayed();
		click(okBtn, "ok Button");
		return (AccountSelectPlansPage) openPage(AccountSelectPlansPage.class);
	}

	public Gmail goToGmail() {
		
		return(Gmail) openPage(Gmail.class);
		
	}

	public void open(String url) {
		DriverManager.getDriver().get(url);
		
//		return (AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);
		
	}

}
