package com.cpcommunity.PageObjects;
//package com.w2a.zoho.PageObjects;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.testng.asserts.SoftAssert;
//
//import com.aventstack.extentreports.Status;
//import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
//
//
//
//import com.uiFramework.pamTen.cpcommunity.helper.wait.WaitHelper;
//
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
///**
// * 
// * @author Bhanu Pratap
// */
//public class Gmail1 {
//
//	private WebDriver driver;
//	
//
//	WaitHelper waitHelper;
//	String TCID;
//	int j = 0;
//	@FindBy(xpath = "//input[@type='email']")
//	WebElement Email;
//	@FindBy(xpath = "//span[contains(.,'Next')]")
//	WebElement NextBtn;
//	@FindBy(xpath = "//input[@type='password']")
//	WebElement password;
//	@FindBy(xpath = "//*[@class='zF']")
//	WebElement UnreadMail;
//	@FindBy(xpath = "//h2[@class='hP']")
//	WebElement EmailSubject;
//	@FindBy(xpath = "//input[@type='email']")
//	WebElement emailfield;
//	@FindBy(xpath = "//input[@name='Password']")
//	WebElement passwordfield;
//	@FindBy(xpath = "//button[contains(.,'Log In')]")
//	WebElement LogInBtn;
//	@FindBy(xpath = "//input[@id='oldpassword']")
//	WebElement oldpassword;
//	@FindBy(xpath = "//input[@id='newpassword']")
//	WebElement Newpassword;
//	@FindBy(xpath = "//input[@id='confirmpassword']")
//	WebElement Confirmpassword;
//	@FindBy(xpath = "//button[contains(.,' Save')]")
//	WebElement SaveBtn;
//	@FindBy(xpath = "//*/tbody/tr[3]/td/table/tbody/tr/td/div/div/p[3]/a")
//	WebElement VerificationLink;
//	@FindBy(xpath = "//button[contains(.,'Verify')]")
//	WebElement VerifyBtn;
//	@FindBy(xpath = "//*[@id='removeinnercss']/section/div/div/div/div[2]/a")
//	WebElement LoginBtn;
//	@FindBy(xpath = "(//div[@class='asa'])[9]")
//	WebElement RefreshBtn;
//
//	@FindBy(xpath = "//*/section/div/div/div/h4")
//	WebDriver RegistrationConfirmation;
//	@FindBy(xpath = "//*/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/span/p[4]/a")
//	WebElement ResetYourPasswordLink1;
//	@FindBy(xpath = "//*/tbody/tr[3]/td/table/tbody/tr/td/div/div[1]/p[4]/a")
//	WebElement ResetYourPasswordLink2;
//	@FindBy(xpath = "//*/tbody/tr[3]/td/table/tbody/tr/td/div/p[3]/a")
//	WebElement JoinComminutyLink;
//	@FindBy(xpath = "//*/tbody/tr[3]/td/table/tbody/tr/td/div/p[3]/span/a")
//	WebElement communitydetailshere;
//	@FindBy(xpath = "//*[@id='gb']/div[1]/div[1]/div/div[5]/div[1]/a/span")
//	WebElement GmailMenu;
//	@FindBy(xpath = "//a[contains(.,'Sign out')]")
//	WebElement Signout;
//	@FindBy(xpath = "//div[@aria-label='Back to Inbox']")
//	WebElement BacktoInbox;
//	@FindBy(xpath = "//*[@id='profileIdentifier']")
//	WebElement profileIdentifier;
//	@FindBy(xpath = "//button[contains(.,'Remove an account')]")
//	WebElement Removeanaccount;
//	@FindBy(xpath = "//*[@id='ow235']/div[2]/div/div/div/ul[1]/li[1]/div/div[2]/p[3]")
//	WebElement CloseIcon;
//	@FindBy(xpath = "//span[contains(.,'Yes, remove')]")
//	WebElement YesRemove;
//	@FindBy(xpath = "//a[contains(text(),'Reset Your Password')]")
//	WebElement ResetYourPassword;
//
//	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[2]")
//	WebElement signIn;
//
//	@FindBy(xpath = "(//*[@data-saferedirecturl])[2]")
//	WebElement termsandConditions;
//	@FindBy(xpath = "(//*[@data-saferedirecturl])[1]")
//	WebElement joinCommunity;
//
//	public Gmail1() {
//		this.driver = driver;
//		this.TCID = TCID;
//		PageFactory.initElements(driver, this);
//
//		driver.get(
//				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//		waitHelper = new WaitHelper(driver);
//		// waitHelper.waitForElement(emailAddress,100);
//		picture();
//		
//	}
//
//	public LoginPage joinCommunity() throws Exception {
//		waitHelper.waitForElementToPresent(joinCommunity, 100);
//		String url = new JavaScriptHelper(driver).target_blank(joinCommunity);
//		driver.get(url);
//
//		Thread.sleep(5000);
//
//		picture();
//		return (LoginPage) openPage(LoginPage.class);
////		new LoginPage(driver, TCID);
//	}
//
//	public void verifyTC(String TC) {
//		String url = new JavaScriptHelper(driver).target_blank(termsandConditions);
//		driver.get(url);
//		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + TC + "')]"));
//		waitHelper.waitForElementToPresent(ele, 100);
//		AssertionHelper.verifyText(ele.getText(), TC);
//		picture();
//	}
//
//	public void EmailLogin(String email, String Pwd) throws Exception {
//
//		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//		String browserName = caps.getBrowserName();
//		String browserVersion = caps.getVersion();
//		System.out.println(browserName);
//		System.out.println(browserVersion);
//
//		// Get OS name.
//		String os = System.getProperty("os.name").toLowerCase();
//		System.out.println(os);
//		// try {
//		// String url = driver.getCurrentUrl();
//		// if (url.equalsIgnoreCase("https://www.google.com/gmail/about/")) {
//		//
//		//
//		// } else {
//		// driver.get("https://www.google.com/gmail/about/new/");
//		// }
//		//
//		// waitHelper.waitForElement(signIn, 100);
//		// Thread.sleep(3000);
//		// new JavaScriptHelper(driver).target_blank(signIn);
//		// Thread.sleep(2000);
//		// signIn.click();
//		// //
//		// driver.findElement(By.xpath("//*[@id='identifierLink']/div[2]/p")).click();
//		// } catch (Exception e) {
//		// }
//		waitHelper.waitForElementToPresent(Email, 100);
//		Email.sendKeys(email);
//		NextBtn.click();
//		waitHelper.waitForElementToPresent(password, 100);
//		password.sendKeys(Pwd);
//		waitHelper.waitForElementToPresent(NextBtn, 100);
//		NextBtn.click();
//		Thread.sleep(30000);
//		waitHelper.waitForElement(RefreshBtn, 100);
//		// //log.info("Clicking Refresh icon");
//
//		picture();
//	}
//
//	public String EmailNotification(String subject) throws Exception {
//
//		
//		Thread.sleep(15000);
//		//log.info("Search for Mail Email..." + subject);
//		Thread.sleep(2000);
//		while (true) {
//			List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
//			for (int i = 0; i < unreademeil.size(); i++) {
//				if (driver.findElements(By.xpath("//span[@class='bqe']")).get(i).getText().equals(subject)) {
//					//log.info(subject + " Email is recieved ...");
//					driver.findElements(By.xpath("//*[@class='zF']")).get(i).click();
//					Thread.sleep(3000);
//					picture();
//					return subject;
//				}
//			}
//			if (j == 12) {
//				SoftAssert softAssertion = new SoftAssert();
//				softAssertion.assertEquals("Email is not Recieved", subject + " Email should be Recieved");
//				softAssertion.assertAll();
//				picture();
//				return null;
//			}
//			j++;
//
//			Thread.sleep(2000);
//
//		}
//
//	}
//
//	public String PaymentGateWayConfiguration(String subject, String PaymentGateway) throws Exception {
//
//		Thread.sleep(2000);
//		waitHelper.waitForElement(RefreshBtn, 100);
//		//log.info("Clicking Refresh icon");
//		RefreshBtn.click();
//		Thread.sleep(4000);
//		while (true) {
//			List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
//			for (int i = 0; i < unreademeil.size(); i++) {
//				if (driver.findElements(By.xpath("//span[@class='bqe']")).get(i).getText().equals(subject)) {
//					String content = driver.findElement(By.xpath("(//span[@class='y2'])[" + i + "]")).getText();
//					System.out.println(content);
//					if (content.contains(PaymentGateway)) {
//						//log.info(subject + " Email is recieved ...");
//						driver.findElements(By.xpath("//*[@class='zF']")).get(i).click();
//						Thread.sleep(3000);
//						picture();
//						return subject;
//					}
//				}
//			}
//			if (j == 6) {
//				SoftAssert softAssertion = new SoftAssert();
//				softAssertion.assertEquals("Email is not Recieved", subject + " Email should be Recieved");
//				softAssertion.assertAll();
//				return null;
//			}
//			j++;
//			RefreshBtn.click();
//			Thread.sleep(4000);
//		}
//	}
//
//	public LoginPage ClickOnhereLink() throws Exception {
//
//		Thread.sleep(3000);
//		List<WebElement> t = driver.findElements(By.xpath("//a[contains(text(),'here')]"));
//		int i = t.size();
//		WebElement ele = driver.findElement(By.xpath("(//a[contains(text(),'here')])[" + i + "]"));
//		String url = new JavaScriptHelper(driver).target_blank(ele);
//		driver.get(url);
//		waitHelper.waitForElementToPresent(password, 100);
//		return (LoginPage) openPage(LoginPage.class);
////		new LoginPage(driver, TCID);
//
//	}
//
//	// AssertionHelper.verifyText(SuccessPopup.getText(), "Endorsement has been
//	// sent
//	// Successfully.");
//
//	public ResetPasswordPage ClickOnForgotPasswordLink() throws Exception {
//
//		Thread.sleep(3000);
//		List<WebElement> t = driver.findElements(By.xpath("//a[contains(text(),'Reset Your Password')]"));
//		int i = t.size();
//		WebElement ele = driver.findElement(By.xpath("(//a[contains(text(),'Reset Your Password')])[" + i + "]"));
//		String url = new JavaScriptHelper(driver).target_blank(ele);
//		driver.get(url);
//		waitHelper.waitForElementToPresent(password, 100);
//		return (ResetPasswordPage) openPage(ResetPasswordPage.class);
////		new ResetPasswordPage(driver, TCID);
//
//	}
//
//	public boolean VerifyEMailSubject(String s1, String s2) {
//		if (s1.equalsIgnoreCase(s2)) {
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//
//}