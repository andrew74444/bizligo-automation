package com.cpcommunity.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath = "//input[@id='CodebyEmail']")
	WebElement email;
	@FindBy(xpath = "//input[@id='CodebyPhone']")
	WebElement phone;
	@FindBy(xpath = "//input[@value='SEND']")
	WebElement send;
	@FindBy(xpath = "//input[@ng-click='SiData.SendVerificationCode(SiData.Sendcodeby)']")
	WebElement send1;

	@FindBy(xpath = "//header[@id='global-nav']")
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

		return ExpectedConditions.visibilityOf(send1);
	}

	public ForgotPasswordPage clickOnForgotpassword() {

		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}

	public void clickOnSend() throws Exception{
		
	waitForElementToPresent(email);
	click(email, "radio button");
		click(send, "send");
		Thread.sleep(3000);
//		return(AccountVerificationCodePage) openPage(AccountVerificationCodePage.class);

	}
	public SelectnewMembershipPlan clickOnSend(String email) throws Exception {
       // clickElementByJavaScript(send);
		waitForElementToPresent(this.email);
		click(this.email, "Email");
		click(phone, "Phone");
		click(this.email, "Email");
		click(send, "send");
		Thread.sleep(3000);
		return(SelectnewMembershipPlan) openPage(SelectnewMembershipPlan.class);

	}

	private void waitForElementToPresent(String email2) {
		// TODO Auto-generated method stub
		
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
	/*public LoginPage clickOnSendToNavigateHomepage(String emailName) throws Exception {
		 
        click(send, "send");
        Thread.sleep(5000);
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Thread.sleep(2500);
        ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wins.get(1));
        driver.get("https://www.guerrillamail.com/");
        Thread.sleep(5000);
        click(boxId,"BoxID");
        Thread.sleep(5000);
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
        Thread.sleep(8000);
        click(emailVerify,"passwordVerify");
        Thread.sleep(1500);
        String password = passWord.getText();
        Thread.sleep(2000);
        ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wins1.get(0));
        Thread.sleep(2000);
        verifyCodeField.sendKeys(password);
        Thread.sleep(5000);
        click(verifyBtn, "Click");
        Thread.sleep(1500);
        click(oK, "Ok Button");
        Thread.sleep(3000);
        return(LoginPage) openPage(LoginPage.class);
 
    }*/
}
