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

		aShot();//

	}
//change
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@FindBy(xpath = "(//*[@name='Email'])[1]")
	WebElement emailAddress;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(.,'Login')]")
	WebElement LoginBtn;

	@FindBy(xpath = "//div[@class='user-text']")
	WebElement usertext;

	@FindBy(xpath = "//*[contains(text(),'Invalid login credentials. Please try again')]")
	WebElement Invalidlogin;

	@FindBy(xpath = "//a[contains(text(),'click here')]")
	WebElement ClickHere;

	@FindBy(xpath = "//*[contains(text(),'Your organization license is pending for approval. Please contact administrator.')]")
	WebElement pendingForApproval;

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
	
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;

	@FindBy(xpath = "//div[normalize-space()='My Advertisements']")
	WebElement myads;
	@FindBy(xpath = "//img[@src='/Content/Images/connectpro_logo.png']")
	WebElement bizligo;
	@FindBy(xpath="//a[contains(text(),'Global Communities')]")
	WebElement globalCommunities;
	@FindBy(xpath="//a[normalize-space()='BizLigo1']")
    WebElement bizligo1;
	@FindBy(xpath="//button[normalize-space()='MANAGE']")
    WebElement bizligo1manage;
	@FindBy(xpath="//a[@title='Manage Community']")
    WebElement manageCommunity;
	@FindBy(xpath = "//button[@class='btn btn-info']")
	WebElement searchbtn;
	@FindBy(xpath = "//input[@id='searchName']")
	WebElement SearchcommunityName;
	@FindBy(xpath = "//input[@placeholder='Search by Community Name']")
	WebElement Searchcommunity;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	
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
	public MyDashboardPage loginToDashboard(String enterEmailAddress, String  password) throws InterruptedException
	 {
		this.login(enterEmailAddress, password);
		 Thread.sleep(5000);
		return (MyDashboardPage) openPage(MyDashboardPage.class);
		 
	 }
	
	public MyProfilePage loginToMyProfilePage(String enterEmailAddress, String password) {
		this.login(enterEmailAddress, password);
		return (MyProfilePage) openPage(MyProfilePage.class);
	}
	
	public MyCommunitiesPage loginToMyCommunitiesPage(String enterEmailAddress, String password) throws InterruptedException {
		this.login(enterEmailAddress, password);
		
		return (MyCommunitiesPage) openPage(MyCommunitiesPage.class);
	}
	
	public ForgotPasswordPage clickOnForgotpassword() {
		click(forgotPassword, "forgot Password");
		return (ForgotPasswordPage) openPage(ForgotPasswordPage.class);

	}
	public TenantAdminDashboardPage loginToTADashboard(String enterEmailAddress, String  password) throws InterruptedException
	 {   
		this.login(enterEmailAddress, password);
		Thread.sleep(4000);
		return (TenantAdminDashboardPage) openPage(TenantAdminDashboardPage.class);
		 
	 }

	public void login(String enterEmailAddress, String password) {
		int t = (int) (Math.random()*10000);
		try {
			Thread.sleep(t);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
		type(this.emailAddress, enterEmailAddress, "email address");
		type(this.password, password, "password");
		
//		this.emailAddress.clear();
//		this.emailAddress.sendKeys(enterEmailAddress);
//		this.password.clear();
//		this.password.sendKeys(password);
//		this.emailAddress.clear();
//		this.emailAddress.sendKeys(enterEmailAddress);
//		this.password.clear();
//		this.password.sendKeys(password);
	
		picture();
		click(LoginBtn, "Login");
		
	}

	// public MyDashboardPage loginToApplication(String enterEmailAddress, String
	// password) {
	public EcoSystemPage loginToApplication(String enterEmailAddress, String password) throws InterruptedException {
		this.login(enterEmailAddress, password);
		 Thread.sleep(5000);
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
		picture();
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
//		click(submitBtn, "submitBtn");
//		waitForElementToPresent(toastMessage);
//
//		String m = "Verification email has been sent to " + EmailAddress;
//		AssertionHelper.verifyText(m, toastMessage.getText());
//		picture();

	}

	public SignupPage clickonSignup() {

		click(signup, "sign up");
		return (SignupPage) openPage(SignupPage.class);
	}

	public SignupPage clickHereToSignup() {

		click(clickHereToSignup, "Click Here To Signup");
		return (SignupPage) openPage(SignupPage.class);
	}

	@FindBy(xpath = "//*[contains(text(),'Your account is suspended')]")
	WebElement suspended;

	public void suspended(String email, String password) {

		this.login(email, password);
		waitForElementToPresent(suspended);
		picture();

	}

	public void waitingForApproval(String email, String password) {

		this.login(email, password);
		waitForElementToPresent(pendingForApproval);
		picture();

	}

	public superAdminDashboardPage superAdminloginToApplication(String email, String password) {
		this.login(email, password);

		return (superAdminDashboardPage) openPage(superAdminDashboardPage.class);
	}

	public AccountSelectPlansPage loginWithPaymentPendingUser(String email, String password) {
		this.login(email, password);
		return (AccountSelectPlansPage) openPage(AccountSelectPlansPage.class);
	}
	public MyDashboardPage loginToMemberdashboard(String enterEmailAddress, String password) throws InterruptedException {
        this.login(enterEmailAddress, password);
        Thread.sleep(8000);
        return (MyDashboardPage) openPage(MyDashboardPage.class);
//        new MyDashboardPage(driver, );        
	}
	
	public ChangePasswordPage loginToChangePassword(String enterEmailAddress, String password) {
        type(this.emailAddress, enterEmailAddress, "email address");
        type(this.password, password, "password");
        click(LoginBtn, "Login");
        return (ChangePasswordPage) openPage(ChangePasswordPage.class);
	
	}
	public MyDashboardPage gotoMyDashboardPage() throws Exception {
		Thread.sleep(8000);
		waitForElementToPresent(Toggledropdownmenu);
		//click(Toggledropdownmenu,"Toggledropdownmenu");
		clickElementByJavaScript(Toggledropdownmenu);
		Thread.sleep(4000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
		 Thread.sleep(8000);
		return (MyDashboardPage) openPage(MyDashboardPage.class);
	}
	public Bizligo1CommunityPage goToMyCommunity(String communityName ) throws InterruptedException {
		Thread.sleep(4000);
		clickElementByJavaScript(globalCommunities);
		waitForElementToPresent(SearchcommunityName);
		picture();
		type(SearchcommunityName, communityName, "Search by Community");
		click(searchbtn, "search btn");
		Thread.sleep(12000);
		//WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		waitForElementToPresent(bizligo1);
		click(bizligo1,"Bizligo 1");
		return (Bizligo1CommunityPage) openPage(Bizligo1CommunityPage.class);
	}
	public Bizligo1CommunityPage goToMyBizCommunity(String communityName ) throws InterruptedException {
		Thread.sleep(4000);
		clickElementByJavaScript(globalCommunities);
		waitForElementToPresent(Searchcommunity);
		picture();
		type(Searchcommunity, communityName, "Search by Community");
		click(search, "search btn");
		Thread.sleep(12000);
		//WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		waitForElementToPresent(bizligo1manage);
		click(bizligo1manage,"Bizligo 1");
		return (Bizligo1CommunityPage) openPage(Bizligo1CommunityPage.class);
	}
}
