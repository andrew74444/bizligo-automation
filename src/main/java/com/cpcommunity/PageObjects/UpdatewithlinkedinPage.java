package com.cpcommunity.PageObjects;
//package com.w2a.zoho.PageObjects;
//
//import java.util.Iterator;
//import java.util.Set;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.uiFramework.pamTen.cpcommunity.helper.wait.WaitHelper;
//
//
//public class UpdatewithlinkedinPage {
//
//	
//	WaitHelper waitHelper;
//	String TCID;
//
//	public UpdatewithlinkedinPage(WebDriver driver, String TCID) {
//		this.driver = driver;
//		this.TCID = TCID;
//		PageFactory.initElements(driver, this);
//		waitHelper = new WaitHelper(driver);
//		int size = driver.findElements(By.tagName("iframe")).size();
//		System.out.println(size);
//
//		// waitHelper.waitForElement(SigninwithLinkedIn,ObjectReader.reader.getExplicitWait());
//		new TestBase().captureScreen(TCID, driver);
//		TestBase.logExtentReport("Update with linkedin Page  Page Object Created");
//
//	}
//
//	@FindBy(xpath = "//button[contains(.,'Sign in with LinkedIn')]")
//	WebElement SigninwithLinkedIn;
//
//	@FindBy(xpath = ".//*[@type='text']")
//	WebElement LinkedInEmail;
//	@FindBy(xpath = "//*[@type='password']")
//	WebElement LinkedInpassword;
//	@FindBy(xpath = ".//*[@type='submit']")
//	WebElement AllowAccess;
//
//	@FindBy(xpath = "//input[@name='FirstName']")
//	WebElement FirstName;
//	@FindBy(xpath = "//input[@name='LastName']")
//	WebElement LastName;
//	@FindBy(xpath = "//input[@name='JobTitle']")
//	WebElement JobTitle;
//	@FindBy(xpath = "//input[@name='LinkedInUrl']")
//	WebElement LinkedInUrl;
//
//	@FindBy(xpath = "//button[@id='nav-settings__dropdown-trigger']")
//	WebElement navsettingsdropdown;
//	@FindBy(xpath = "//span[contains(.,'View profile')]")
//	WebElement Viewprofile;
//	@FindBy(xpath = "//*[@class='pv-top-card-section__name inline t-24 t-black t-normal']")
//	WebElement MemberName;
//	@FindBy(xpath = "//*[@class='pv-top-card-section__headline mt1 t-18 t-black t-normal']")
//	WebElement LinkedJobTitle;
//
//	@FindBy(xpath = "//a[@data-control-name='edit_top_card']")
//	WebElement EditProfile;
//
//	@FindBy(xpath = "//*[@class='pv-top-card-section__summary-text mt4 ember-view']//*[@class='lt-line-clamp__line lt-line-clamp__line--last']")
//	WebElement ProfessionalSummary;
//	@FindBy(xpath = "//span[@id='full-visibilityLevel']")
//	WebElement fullvisibilityLevel;
//	@FindBy(xpath = "//*[contains(text(),'Activity')]")
//	WebElement Activity;
//
//	@FindBy(xpath = "//label[@for='visibilityLevel']")
//	WebElement visibilityLevel;
//
//	@FindBy(xpath = "//button[contains(.,' Save')]")
//	WebElement SaveBtn;
//
//	@FindBy(xpath = "//button[contains(.,'OK')]")
//	WebElement OKBtn;
//
//	// String X =
//	// {"xdOrigin":"https://cpcommunityqa.azurewebsites.net","xdChannel":"6afdffd5-1aab-498d-86ae-560f832a04db","framework":"@linkedin/xdoor-sdk","version":"0.1.143","debug":false}
//
//	public String ApplyWithLinkedIn(String Email, String password) throws Exception {
//
//		Thread.sleep(6000);
//
//		int size = driver.findElements(By.tagName("iframe")).size();
//		System.out.println(size);
//
//		for (int i = 0; i <= size; i++) {
//			try {
//				driver.switchTo().frame(i);
//				System.out.println("iframe is" + i);
//				SigninwithLinkedIn.click();				
//				System.out.println("clicked iframe is " + i);
//				driver.switchTo().defaultContent();
//				break;
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//		}
//
//		Thread.sleep(3000);
//		String parent = driver.getWindowHandle();
//		String url = driver.getCurrentUrl();
//
//		Thread.sleep(1000);
//		Set<String> s1 = driver.getWindowHandles();
//		Iterator<String> I1 = s1.iterator();
//		String LinkedInData = null;
//		while (I1.hasNext()) {
//			String child_window = I1.next();
//			if (!parent.equals(child_window)) {
//				driver.switchTo().window(child_window);
//				Thread.sleep(2000);
//				LinkedInEmail.sendKeys(Email);
//
//				LinkedInpassword.sendKeys(password);
//
//				AllowAccess.click();
//				driver.switchTo().window(parent);
//				waitHelper.waitForElement(FirstName, ObjectReader.reader.getExplicitWait());
//
//				Thread.sleep(3000);
//
//				driver.get("https://www.linkedin.com/");
//				Thread.sleep(3000);
//				waitHelper.waitForElement(navsettingsdropdown, ObjectReader.reader.getExplicitWait());
//				navsettingsdropdown.click();
//				Thread.sleep(2000);
//				waitHelper.waitForElement(Viewprofile, ObjectReader.reader.getExplicitWait());
//				Viewprofile.click();
//				
//				// Utility.WaitForElementToVisible(driver,
//				// LinkedEditProfileBtn);
//				// Utility.ScrollToView(driver, EditProfile);
//
//				waitHelper.waitForElement(MemberName, ObjectReader.reader.getExplicitWait());
//				String LinkedInName = MemberName.getText();
//				String LinkedInMemberJobTitle = LinkedJobTitle.getText();
//				String LinkedInProfessionalSummary = ProfessionalSummary.getText();
//				String profileUrl = driver.getCurrentUrl();
//				driver.get("https://www.linkedin.com/public-profile/settings?trk=d_flagship3_profile_self_view_public_profile");
//
//				LinkedInData = LinkedInName + " " + LinkedInMemberJobTitle + " " + LinkedInProfessionalSummary + " "
//						+ profileUrl;
//
//				try {
//					Thread.sleep(3000);
//					Activity.isDisplayed();
//
//				} catch (Exception e) {
//					visibilityLevel.click();
//					waitHelper.waitForElement(Activity, ObjectReader.reader.getExplicitWait());					
//				}
//				driver.get(url);
//				Thread.sleep(2000);
//				Thread.sleep(4000);
//				SaveBtn.click();
//				Thread.sleep(2000);
//				OKBtn.click();
//			}
//
//		}
//		return LinkedInData;
//	}
//
//	public MyProfilePage returnPage() {
//		return new MyProfilePage(driver, TCID);
//	}
//
//}
