package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import com.cpcommunity.utilities.DriverManager;

public class Gmail extends BasePage {

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement nextBtn;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//*[@class='asf T-I-J3 J-J5-Ji']")
	WebElement RefreshBtn;

	@FindBy(xpath = "//span[contains(.,'Events')]")
	WebElement Events;

	@FindAll({ @FindBy(xpath = ""), @FindBy(xpath = "") })
	List<WebElement> elementsList;

	@FindBy(xpath = "(//*[@data-saferedirecturl])[1]")
	WebElement joinCommunity;

	@FindBy(xpath = "(//*[@data-saferedirecturl])[2]")
	WebElement termsandConditions;
	
	@FindBy(xpath = "//span[@id='inbox-id']")
	WebElement boxId;
	@FindBy(xpath = "//input[@value='nancy']")
	WebElement emailName;
	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement setBtn;
	
	
	
	
	int j = 0;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
//		System.out.println(driver + "Gmail Login Page");
		DriverManager.getDriver().navigate().to(
				"https://accounts.google.com/o/oauth2/auth/identifier?client_id=717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com&scope=profile%20email&redirect_uri=https%3A%2F%2Fstackauth.com%2Fauth%2Foauth2%2Fgoogle&state=%7B%22sid%22%3A1%2C%22st%22%3A%2259%3A3%3Abbc%2C16%3Ab9ac33d13d48edea%2C10%3A1602037935%2C16%3A9718ddac74e7f6e0%2C8ee44d90224dd142a8bfb6cc2b0ac2b8016d306d13ace572b24f1c89d12d7427%22%2C%22cdl%22%3Anull%2C%22cid%22%3A%22717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com%22%2C%22k%22%3A%22Google%22%2C%22ses%22%3A%22e0ab48c7efe74f8ab4a9cbdd205004cf%22%7D&response_type=code&flowName=GeneralOAuthFlow");
		
		// https://multi2.ezysubscribe.com/Account/VerificationCode?Datas=mK0FMnGiCMXF/0vLvc26TQ==
		return ExpectedConditions.visibilityOf(email);
	}

	public Gmail open(String url) {

		DriverManager.getDriver().navigate().to(
				"https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		////https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin
	//	picture();
		return (Gmail) openPage(Gmail.class);
	}

	public Gmail open() {

		DriverManager.getDriver().navigate().to(
				"https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	////	https://accounts.google.com/o/oauth2/auth/identifier?client_id=717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com&scope=profile%20email&redirect_uri=https%3A%2F%2Fstackauth.com%2Fauth%2Foauth2%2Fgoogle&state=%7B%22sid%22%3A1%2C%22st%22%3A%2259%3A3%3Abbc%2C16%3Ab9ac33d13d48edea%2C10%3A1602037935%2C16%3A9718ddac74e7f6e0%2C8ee44d90224dd142a8bfb6cc2b0ac2b8016d306d13ace572b24f1c89d12d7427%22%2C%22cdl%22%3Anull%2C%22cid%22%3A%22717762328687-iludtf96g1hinl76e4lc1b9a82g457nn.apps.googleusercontent.com%22%2C%22k%22%3A%22Google%22%2C%22ses%22%3A%22e0ab48c7efe74f8ab4a9cbdd205004cf%22%7D&response_type=code&flowName=GeneralOAuthFlow
		
		//	https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin
		//picture();
		return (Gmail) openPage(Gmail.class);
	}

	public void Login(String email, String password) throws Exception {

try {
	Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	String browserName = caps.getBrowserName();
	String browserVersion = caps.getVersion();
	System.out.println(browserName);
	System.out.println(browserVersion);

	// Get OS name.
	String os = System.getProperty("os.name").toLowerCase();
	System.out.println(os);

	waitForElementToPresent(this.email);
	type(this.email, email, "Email");
	clickElementByJavaScript(nextBtn);
//	click(nextBtn, "Next");
	waitForElementToPresent(this.password);
	type(this.password, password, "password");
	waitForElementToPresent(nextBtn);
	clickElementByJavaScript(nextBtn);
	log.info("Navigating to Gmail - 1");
	DriverManager.getDriver().get("https://mail.google.com/mail/u/0/");
	waitForElementToPresent(RefreshBtn);
//	clickElementByJavaScript(RefreshBtn);
//	log.info("Navigating to Gmail - 2");
//	clickElementByJavaScript(RefreshBtn);
//	
//	DriverManager.getDriver().get("https://mail.google.com/mail/u/0/");// 118 to 128 commented by me
//	log.info("Navigating to Gmail - 3");
//	DriverManager.getDriver().get("https://mail.google.com/mail/u/0/");
//	log.info("Navigating to Gmail - 4");
//	DriverManager.getDriver().get("https://mail.google.com/mail/u/0/");
//	waitForElementToPresent(RefreshBtn);
//	
} catch (Exception e) {
	log.info("Navigating to Gmail - 5");

	DriverManager.getDriver().navigate().to("https://mail.google.com/mail/u/0/");
//	Thread.sleep(30000);
	
	waitForElementToPresent(RefreshBtn);
	 click(RefreshBtn, "Refresh Btn");//removed the comment by me
	
}		
	

		
	

	}

	public void emailNotification(String subject) throws Exception {

		log.info("checking email");
		picture();
		
		Thread.sleep(15000);
		while (true) {
			List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
			for (int i = 0; i < unreademeil.size(); i++) {
				if (driver.findElements(By.xpath("//span[@class='bqe']")).get(i).getText().equals(subject)) {
					click(driver.findElements(By.xpath("//*[@class='zF']")).get(i), subject);
					Thread.sleep(5000);
					picture();
					return;
				}
			}
			if (j == 25) {
				SoftAssert softAssertion = new SoftAssert();
				softAssertion.assertEquals(subject + " is not Recieved", subject + " Email should be Recieved");
				softAssertion.assertAll();
				picture();
				return;
			}
			j++;
			Thread.sleep(2000);
		}

	}

	public LoginPage joinCommunity() throws Exception {
		waitForElementToPresent(joinCommunity);
		int t = driver.findElements(By.xpath("(//span[@style='font-family:verdana'])//*[contains(.,'Apple')]")).size();
		if (t != 1) {
			t = t * 2;
			t--;
		}

		String url = target_blank(driver.findElement(By.xpath("((//*[@data-saferedirecturl]))[" + t + "]")));
		driver.get(url);

		Thread.sleep(5000);

		picture();
		return (LoginPage) openPage(LoginPage.class);
	}

	public void verifyTC(String TC) throws Exception {
		String GmailUrl = driver.getCurrentUrl();
		String url = target_blank(termsandConditions);
		driver.get(url);
		String xpath1 = "//*[contains(text(),'";
		String xpath2 = TC;
		String xpath3 = "')]";
		// *[contains(text(),'TC')]

		String xpath = xpath1 + xpath2 + xpath3;
		System.out.println(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		waitForElementToPresent(ele);
		AssertionHelper.verifyText(ele.getText(), TC);
		picture();
		driver.get(GmailUrl);

	}

	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	@FindBy(xpath = "//*[contains(text(),'email address: ')]//*")
	WebElement otp;

	public String getOtp() {
		picture();
		String otp = this.otp.getText().replace(".", "");
		log.info(otp);
		return otp;
	}
 public void openGuerillamail(String emailName) throws InterruptedException, AWTException {
	 Thread.sleep(5000);
     //((JavascriptExecutor)driver).executeScript("window.open()");
     //Thread.sleep(2500);
    // ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
    // driver.switchTo().window(wins.get(1));
     //driver.get("https://www.guerrillamail.com/");
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
     Thread.sleep(1000);
     /*click(emailVerify,"passwordVerify");
     Thread.sleep(1500);
     String password = passWord.getText();
     Thread.sleep(2000);
     ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
     driver.switchTo().window(wins1.get(0));
     Thread.sleep(2000);*/
 }
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
 @FindBy(xpath="//*[text()='Password Reset']")
 WebElement reset;
 
 @FindBy(xpath=" (//*[text()='Password Reset'])[2]")
 WebElement reset1;
 
 @FindBy(xpath="//*[text()='Reset Your Password']")
 WebElement clickReset;
 
 @FindBy(xpath="//*[text()='Reset Password']")
 WebElement passwordRestConfirmation;

 @FindBy(xpath = "//input[@name='Password']")
	WebElement Password;

	@FindBy(xpath = "//input[@name='ConfirmPassword']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//button[contains(text(),'Reset')]")
	WebElement Reset;
 
public void reset() throws InterruptedException {
	
	Thread.sleep(5000);
	click(reset1,"Password Reset Mail");
	
	Thread.sleep(2000);
	click(clickReset,"Reset link");
	
	String currentHandle= driver.getWindowHandle();

	
	Thread.sleep(2000);

	
	//Get all the handles currently available
	Set<String> handles=driver.getWindowHandles();
	for(String actual: handles) {
	
	//Switch to the opened tab
		
	driver.switchTo().window(actual);

	}
	
	
	
	
	
	Thread.sleep(2000);
	 String text=passwordRestConfirmation.getText();
	 System.out.println(text);
	 
	 Thread.sleep(2000);
	 TypeByJavaScript("Pamten@789",Password);

	 
	 Thread.sleep(2000);
	 TypeByJavaScript("Pamten@789",ConfirmPassword);
	 
	 Thread.sleep(5000);
//JavascriptExecutor js=(JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", Reset)
	 

	 
	 click(Reset,"resetting the password");
	 Thread.sleep(5000);
	 
	 }

 

}
