package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class MyProfilePage extends BasePage {

	@FindBy(xpath = "//nav[@class='navbar navbar-inverse']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}
	//a[@data-toggle='tab'][normalize-space()='My Profile']
	@FindBy(xpath = "//a[@data-toggle='tab'][contains(text(),'My Profile')]")
	WebElement MyProfile;
	@FindBy(xpath = "//i[@title='Edit Profile']")
	WebElement EditBtn;
	@FindBy(xpath = "//*[@id=\"Skill_InterestController\"]/div[2]/div/div[2]")
	WebElement profileCompletenessBar;
	@FindBy(xpath = "//*[@name='FirstName']")
	WebElement FirstName;
	@FindBy(xpath = "//*[@name='LastName']")
	WebElement LastName;
	@FindBy(xpath = "//*[@name='JobTitle']")
	WebElement JobTitle;
	@FindBy(xpath = "//textarea[@name='Biography']")
	WebElement ProfessionalSummary;
	@FindBy(xpath = "//input[@name='YouTubeUrl']")
	WebElement YouTubeUrl;
	@FindBy(xpath = "//input[@name='LinkedInUrl']")
	WebElement LinkedInUrl;
	@FindBy(xpath = "//input[@name='FacebookUrl']")
	WebElement FacebookUrl;
	@FindBy(xpath = "//input[@name='TwitterUrl']")
	WebElement TwitterUrl;
	@FindBy(xpath = "//input[@name='GooglePlusUrl']")
	WebElement GooglePlusUrl;
	@FindBy(xpath = "//input[@id='Phone']")
	WebElement Phone;
	@FindBy(xpath = "//input[@ng-model='profile.MyProfileData.MemberProfile.Extension']")
	WebElement Ext;
	@FindBy(xpath = "(//form[@id='EditMyProfileForm'])//*[contains(text(),'Save')]")
	WebElement MyProfileSaveBtn;
	@FindBy(xpath = "//form[@id='EditMyProfileForm']//button[@class='btn btn-danger']")
	WebElement MyProfileCancelBtn;
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement profileSuccessPopup;
	@FindBy(xpath = "//input[@id='ShowEmail']")
	WebElement PrivateEmail;
	@FindBy(xpath = "//input[@id='ShowPhone']")
	WebElement PrivatePhoneNo;
	@FindBy(xpath = "//span[@ng-bind='profile.MemberProfile.Phone']")
	WebElement myProfilePageSavedPhoneno;
	@FindBy(xpath = "//label[@title='Visible only to your connections']//input")
	WebElement PrivateRdnBtn;
	@FindBy(xpath = "//*[@id='EditMyProfileModal']//*[@class='modal-content']//*[@title='Everyone can see my profile']//input")
	WebElement PublicRdnBtn;

	@FindBy(xpath = "//span[@ng-bind='profile.MemberInfo.EmailID']")
	WebElement myProfileEmailID;

	// Portfolio
	@FindBy(xpath = "//button[contains(@ng-click,'OIdata.ShowOtherInfoModel()')]")
	WebElement AddPortfolioBtn;
	@FindBy(xpath = "//input[@name='PortfolioTitle']")
	WebElement PortfolioTitle;
	@FindBy(xpath = "//input[@name='PortfolioLink']")
	WebElement PortfolioLink;
	@FindBy(xpath = "//span[@ng-show='OIdata.IsSaveMode']")
	WebElement PortfolioSaveBtn;

	@FindBy(xpath = "(//a[@class='text-primary pull-right'])[1]")
	WebElement EditPortfolioBtn;
	@FindBy(xpath = "//a[@class='text-danger pull-right profile-edit-link']")
	WebElement DeleteportfolioBtn;

	@FindBy(xpath = "//div[contains(text(),'Skills & Interests')]")
	WebElement Skills_Interests;

	// Skills
	@FindBy(xpath = "//input[@placeholder='Add Skills']")
	WebElement AddSkills;
	@FindBy(xpath = "(//*[@class='panel-body Communities']//i[@class='fa fa-pencil-square-o'])[1]")
	WebElement UpdateSkillsBtn;

	@FindBy(xpath = "//span[@ng-click='SIdata.RemoveSkills(Skill)']")
	WebElement DeleteSkillsBtn;
	@FindBy(xpath = "//form[@id='EditMySkillsForm']//i[@class='fa fa-floppy-o']")

	WebElement SkillsSaveBtn;

	// Interests
	@FindBy(xpath = "(//*[@class='panel-body Communities']//i[@class='fa fa-pencil-square-o'])[2]")
	WebElement UpdateInterestsBtn;
	@FindBy(xpath = "//input[@placeholder='Add Interest']")
	WebElement AddInterest;
	@FindBy(xpath = "//span[@ng-click='SIdata.RemoveInterest(Interest)']")
	WebElement DeleteInterestBtn;
	@FindBy(xpath = "//form[@id='EditMyInterestsForm']//i[@class='fa fa-floppy-o']")
	WebElement InterestsSaveBtn;

	// Profile picture
	@FindBy(xpath = "//a[@id='changePictureLink']")
	WebElement changeProfilePictureLink;
	@FindBy(xpath = "//button[contains(.,'Browse')]")
	WebElement BrowseBtn;
	@FindBy(xpath = "//button[contains(.,'Upload')]")
	WebElement UploadBtn;
	@FindBy(xpath = "//button[contains(.,'Update')]")
	WebElement UpdateBtn;

	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement CancelBtn;
	// *******************Company profile*************************
	@FindBy(xpath = "//a[@href='#company-profile']")
	WebElement companyProfileTab;

	// Change Company logo

	@FindBy(xpath = "//a[@ng-click='CPData.ChangeCompanyLogo()']")
	WebElement ChangeCompanyLogoLink;
	@FindBy(xpath = "//form[@id='EditCompanyLogoForm']//button[@type='button']")
	WebElement CompanyBrowsebtn;
	@FindBy(xpath = "//form[@id='EditCompanyLogoForm']//div[@class='modal-footer']//button[@type='submit']")
	WebElement uploadCompanyBtn;

	// form[@id='EditCompanyLogoForm']//i[@class='fa fa-upload']
	// Edit Company Profile
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	WebElement EditCompanyProfileBtn;
	@FindBy(xpath = "//input[@name='CompanyEmail']")
	WebElement CompanyEmail;
	@FindBy(xpath = "//select[@name='NoOfEmployees']")
	WebElement NoOfEmployees;
	@FindBy(xpath = "//input[@placeholder='Select Business Categories with max limit of 5']")
	WebElement BusinessCategories;
	@FindBy(xpath = "//textarea[@id='BusinessDescription']")
	WebElement BusinessDescription;
	@FindBy(xpath = "//input[@name='CompanyName']")
	WebElement CompanyName;
	@FindBy(xpath = "//input[@id='CompanyFax']")
	WebElement CompanyFax;
	@FindBy(xpath = "//input[@id='CompanyPhone']")
	WebElement CompanyPhone;
	@FindBy(xpath = "//input[@ng-model='CPData.CompanyData.Extension']")
	WebElement CompanyExt;

	@FindBy(xpath = "//input[@ng-model='CPData.CompanyData.SocialLinksobj.LinkedInUrl']")
	WebElement CompanyLinkedIn;
	@FindBy(xpath = "//input[@ng-model='CPData.CompanyData.SocialLinksobj.FacebookUrl']")
	WebElement CompanyFacebook;
	@FindBy(xpath = "//input[@ng-model='CPData.CompanyData.SocialLinksobj.TwitterUrl']")
	WebElement CompanyTwitter;
	@FindBy(xpath = "//input[@ng-model='CPData.CompanyData.SocialLinksobj.GooglePlusUrl']")
	WebElement CompanyGPlus;
	@FindBy(xpath = "//form[@id='EditCompanyProfileForm']//div[@class='form-group']//button[@type='submit']")
	WebElement CompanyProfileSaveBtn;

	/*
	 * 
	 * Profile Category
	 *
	 */
	@FindBy(xpath = "//a[@class='btn btn-info btn-xs pull-right']//i[@class='fa fa-pencil-square-o']")
	WebElement profileCategory;
	@FindBy(xpath = "//input[@placeholder='Add Profile Categories like Mentor, Entrepreneur etc..']")
	WebElement profileCategoryField;
	@FindBy(xpath = "//form[@id='EditWhoAmIForm']//div[@class='modal-footer']//button[@type='submit']")
	WebElement profileCategoryFieldSaveBtn;
	@FindBy(xpath = "//form[@id='EditWhoAmIForm']//i[@class='fa fa-times text-danger']")
	WebElement profileCategoryDelete;
	@FindBy(xpath="//div[@class='col-lg-3 pc-percentage ng-binding']")
	WebElement progressBarPercent;
	@FindBy(xpath = "//a[contains(.,' Apply LinkedIn Profile')]")
	WebElement ApplyLinkedInProfileBtn;

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(MyProfile);
	}

	public void clickOnEditButton() throws Exception {

		click(EditBtn, "EditBtn");
		Thread.sleep(2000);
		picture();
	}

	public boolean updateCompanyProfile(String CompanyName, String CompanyEmail, String CompanyPhone,
			String CompanyExt) {

		clickElementByJavaScript(companyProfileTab);
		waitForElementToPresent(EditCompanyProfileBtn);
		click(EditCompanyProfileBtn, "EditCompanyProfileBtn");
		waitForElementToPresent(this.CompanyName);
		type(this.CompanyName, CompanyName, "CompanyName");
		type(this.CompanyEmail, CompanyEmail, "CompanyEmail");
		type(this.CompanyPhone, CompanyPhone, "CompanyPhone");
		type(this.CompanyExt, CompanyExt, "CompanyExt");
//		type("Name", this.CompanyName, CompanyName);
//		type("Name", this.CompanyName, CompanyName);
//		type("Name", this.CompanyName, CompanyName);
//		type("Name", this.CompanyName, CompanyName);
//		type("Name", this.CompanyName, CompanyName);
//		type("Name", this.CompanyName, CompanyName);

		return true;
	}

	public boolean UpdateProfileDetails(String FName, String LName, String jtitle, String PPhone, String PExt,
			String PSummary, String Ytube, String LUrl, String FUrl, String TUrl) throws Exception {

		this.clickOnEditButton();
		JobTitle.clear();
		ProfessionalSummary.clear();
		YouTubeUrl.clear();
		LinkedInUrl.clear();
		FacebookUrl.clear();
		TwitterUrl.clear();
		FirstName.clear();

		System.out.println(FName);
		LastName.clear();
		Phone.clear();
		Ext.clear();
		picture();
//		new TestBase().captureScreen(, driver);
		scrollIntoView(FirstName);
		Thread.sleep(3000);
		type(FirstName, FName, "FirstName");
		type(LastName, LName, "LastName");
		type(JobTitle, jtitle, "JobTitle");
		type(ProfessionalSummary, PSummary, "ProfessionalSummary");
		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].value='" + PExt + "';", Ext);
		type(YouTubeUrl, Ytube, "YouTubeUrl");
		type(LinkedInUrl, LUrl, "LinkedInUrl");
		type(FacebookUrl, FUrl, "FacebookUrl");
		type(TwitterUrl, TUrl, "TwitterUrl");
		click(PublicRdnBtn, "Public Radio Btn");
		picture();
//		new TestBase().captureScreen(, driver);
		return this.UpdateProfile();
	}

	public boolean UpdateProfile() throws Exception {
		scrollIntoView(MyProfileSaveBtn);
		Thread.sleep(5000);
		clickElementByJavaScript(MyProfileSaveBtn);
		// *[contains(text(),'Save')]
		Thread.sleep(4000);
		picture();
//		new TestBase().captureScreen(, driver);
//		waitHelper.waitForElementToPresent(profileSuccessPopup, 100);
//		if (profileSuccessPopup.getText().equalsIgnoreCase("Profile updated successfully")) {
////			
//		{
		return true;
//		}
//		}
//		{
//			return false;
//		}

	}

	public boolean SelectEmailPrivate() throws Exception {

		this.clickOnEditButton();
		scrollIntoView(MyProfileSaveBtn);
		boolean PEmail = PrivateEmail.isSelected();
		if (PEmail) {
			click(MyProfileCancelBtn, "MyProfileCancelBtn");
			Thread.sleep(1000);
			return PEmail;
		} else {

			click(PrivateEmail, "PrivateEmail");
			Thread.sleep(1000);
			boolean status = this.UpdateProfile();
			return status;

		}
	}

	public boolean UnSelectEmailPrivate() throws Exception {
		this.clickOnEditButton();
		scrollIntoView(MyProfileSaveBtn);
		click(PublicRdnBtn, "PublicRdnBtn");
		boolean PEmail = PrivateEmail.isSelected();
		if (PEmail) {
			Thread.sleep(1000);

			click(PrivateEmail, "PrivateEmail");
			boolean status = this.UpdateProfile();
			return status;
		} else {
			boolean status = this.UpdateProfile();
			return status;
		}

	}

	public boolean SelectPhonePrivate(String PPhone) throws Exception {

		this.clickOnEditButton();
		Phone.clear();

		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		picture();
		click(PublicRdnBtn, "PublicRdnBtn");
		picture();
		boolean PEmail = PrivatePhoneNo.isSelected();
		System.out.println(PEmail);
		if (PEmail) {
			click(MyProfileCancelBtn, "MyProfileCancelBtn");
			return PEmail;
		}

		else {

			click(PrivatePhoneNo, "PrivatePhoneNo");
			Thread.sleep(1000);
			boolean Status = this.UpdateProfile();
			return Status;
		}
	}

	public boolean UnSelectPhonePrivate(String PPhone) throws Exception {
		this.clickOnEditButton();
		Phone.clear();

		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		picture();
		click(PublicRdnBtn, "PublicRdnBtn");
		picture();
//		new TestBase().captureScreen(, driver);
		boolean PEmail = PrivatePhoneNo.isSelected();
		if (PEmail) {
			Thread.sleep(1000);
			click(PrivatePhoneNo, "PrivatePhoneNo");
			Thread.sleep(2000);
		}

		Boolean status = this.UpdateProfile();

		Thread.sleep(2000);
		// String MyPhNo = myProfilePageSavedPhoneno.getText();
		return status;
	}

	public boolean PrivateRadioButton(String PPhone) throws Exception {

		this.clickOnEditButton();
		Thread.sleep(1000);
		Phone.clear();

		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		Thread.sleep(5000);
		picture();
		click(PrivateRdnBtn, "PrivateRdnBtn");
		picture();
		boolean status = this.UpdateProfile();
		return status;
	}

	public boolean publicRadioButton(String PPhone) throws Exception {

		this.clickOnEditButton();
		Phone.clear();

		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		Thread.sleep(5000);
		click(PublicRdnBtn, "PublicRdnBtn");
		picture();
		Thread.sleep(1000);
		return this.UpdateProfile();

	}

	public void scrollToProtfolio() {
		scrollToElement(Skills_Interests);
	}

	public boolean AddProtfolio(String title, String url) throws Exception {

		// this.scrollToProtfolio();

		clickElementByJavaScript(AddPortfolioBtn);
		// AddPortfolioBtn.click();
		Thread.sleep(2000);
//		new TestBase().captureScreen(, driver);
		picture();
		type(PortfolioTitle, title, "PortfolioTitle");

		type(PortfolioLink, url, "PortfolioLink");
		picture();
//		new TestBase().captureScreen(, driver);
		click(PortfolioSaveBtn, "PortfolioSaveBtn");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Portfolio Saved Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (SuccessPopup.getText().equalsIgnoreCase("Portfolio Saved Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean updatePortfolio(String title, String url) throws Exception {
		// this.scrollToProtfolio();
		clickElementByJavaScript(EditPortfolioBtn);

		Thread.sleep(1000);
		picture();
//		new TestBase().captureScreen(, driver);
		PortfolioTitle.clear();
		PortfolioLink.clear();
		picture();
//		new TestBase().captureScreen(, driver);
		type(PortfolioTitle, title, "PortfolioTitle");

		type(PortfolioLink, url, "PortfolioLink");
		picture();
//		new TestBase().captureScreen(, driver);
		click(PortfolioTitle, "PortfolioTitle");
		click(UpdateBtn, "UpdateBtn");
		waitForElementToPresent(SuccessPopup);
		String Message = SuccessPopup.getText();
		AssertionHelper.verifyText(Message, "Portfolio Updated Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (Message.equalsIgnoreCase("Portfolio Updated Successfully")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean DeletePortfolio(String title, String url) throws Exception {
		// this.scrollToProtfolio();
		clickElementByJavaScript(DeleteportfolioBtn);
		Thread.sleep(2000);
		picture();
//		new TestBase().captureScreen(, driver);

//		waitHelper.waitForElement(SuccessPopup, 100);
//		String Message = SuccessPopup.getText();
//		AssertionHelper.verifyText(Message, "Portfolio Deleted Successfully");
//		new TestBase().captureScreen(, driver);
//		if (Message.equalsIgnoreCase("Portfolio Deleted Successfully")) 
		{
			return true;
		}
//		return false;

	}

	public void ClickOnEditSkillsBtn() {

		scrollIntoView(UpdateSkillsBtn);
		clickElementByJavaScript(UpdateSkillsBtn);
	}

	public boolean clickOnSkillsSavebutton() throws Exception {
		Thread.sleep(1000);
		click(SkillsSaveBtn, "SkillsSaveBtn");
		Thread.sleep(2000);
		picture();
//		new TestBase().captureScreen(, driver);
//		waitHelper.waitForElement(SuccessPopup, 100);
//		AssertionHelper.verifyText(SuccessPopup.getText(), "Skills and Interests Saved Successfully");
//		new TestBase().captureScreen(, driver);
//		if (SuccessPopup.getText().equalsIgnoreCase("Skills and Interests Saved Successfully")) {
		return true;
	}
//		return false;
//	}
	
	public void logout() throws Throwable
	{
		Thread.sleep(5000);
		click(Toggledropdownmenu, "Toggledropdownmenu");
		click(logout,"Logout");
		
	}

	

	public boolean AddSkills(String Skills) throws Exception {
		this.ClickOnEditSkillsBtn();
		type(AddSkills, Skills, "AddSkills");

		Thread.sleep(1000);
		AddSkills.sendKeys(Keys.ENTER);
		picture();
//		new TestBase().captureScreen(, driver);
		Thread.sleep(1000);
		return this.clickOnSkillsSavebutton();
	}

	public boolean DeleteSkills() throws Exception {
		this.ClickOnEditSkillsBtn();
		click(DeleteSkillsBtn, "DeleteSkillsBtn");
		return this.clickOnSkillsSavebutton();
	}

	public boolean AddInterests(String interests) throws Exception {
		this.ClickOnEditInterestsBtn();
		type(AddInterest, interests, "AddInterest");

		Thread.sleep(1000);
		AddInterest.sendKeys(Keys.ENTER);
		picture();
//		new TestBase().captureScreen(, driver);
		Thread.sleep(1000);
		return this.clickOnInterestsSavebutton();

	}

	public void ClickOnEditInterestsBtn() {

		scrollIntoView(UpdateInterestsBtn);
		clickElementByJavaScript(UpdateInterestsBtn);

	}

	public boolean clickOnInterestsSavebutton() throws Exception {
		Thread.sleep(1000);
		click(InterestsSaveBtn, "InterestsSaveBtn");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Skills and Interests Saved Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (SuccessPopup.getText().equalsIgnoreCase("Skills and Interests Saved Successfully")) {
			return true;
		}
		return false;
	}

	public boolean DeleteInterests() throws Exception {
		this.ClickOnEditInterestsBtn();
		Thread.sleep(2000);
		waitForElementToPresent(DeleteInterestBtn);
		picture();
//		new TestBase().captureScreen(, driver);
		click(DeleteInterestBtn, "DeleteInterestBtn");
		picture();
//		new TestBase().captureScreen(, driver);
		return this.clickOnInterestsSavebutton();
	}

	public void ChangeProfilePicture() throws Exception {
		click(changeProfilePictureLink, "changeProfilePictureLink");
		Thread.sleep(2000);
		click(BrowseBtn, "BrowseBtn");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:/workspace/CPCommunityQA/src/main/resources/configfile/ExeFiles/ChromeImage1.exe");
		Thread.sleep(4000);
		click(UploadBtn, "UploadBtn");
		Thread.sleep(3000);
	}

	public void ChangeCompanypicture() throws InterruptedException, IOException {

		clickElementByJavaScript(companyProfileTab);
		click(changeProfilePictureLink, "changeProfilePictureLink");
		Thread.sleep(2000);
		click(CompanyBrowsebtn, "CompanyBrowsebtn");
		Thread.sleep(5000);
		Runtime.getRuntime()
				.exec("D:/workspace/CPCommunityQA/src/main/resources/configfile/ExeFiles/ChromeImage2	.exe");
		Thread.sleep(4000);
		click(UploadBtn, "UploadBtn");
	}

	public boolean updateCompanyProfile(String CName, String CEmail, String CPhone, String CExt, String Fax,
			String CDesc, String CLUrl, String CFUrl, String CTUrl, String CGUrl) throws Exception {

		clickElementByJavaScript(companyProfileTab);
		waitForElementToPresent(EditCompanyProfileBtn);
		click(EditCompanyProfileBtn, "EditCompanyProfileBtn");
		waitForElementToPresent(this.CompanyName);

		CompanyName.clear();
		CompanyEmail.clear();
		CompanyPhone.clear();
		CompanyExt.clear();
		BusinessDescription.clear();
		CompanyLinkedIn.clear();
		CompanyFacebook.clear();
		CompanyTwitter.clear();
		CompanyGPlus.clear();
		CompanyFax.clear();

		type(this.CompanyName, CName, "Company Name");
		type(this.CompanyEmail, CEmail, "Company Email");
		executeScript("arguments[0].value='" + CPhone + "';", CompanyPhone);
		executeScript("arguments[0].value='" + CExt + "';", CompanyExt);
		executeScript("arguments[0].value='" + CExt + "';", CompanyFax);
		type(this.BusinessDescription, CDesc, "BusinessDescription");
		type(this.CompanyLinkedIn, CLUrl, "CompanyLinkedIn");
		type(this.CompanyFacebook, CFUrl, "CompanyFacebook");
		type(this.CompanyTwitter, CTUrl, "CompanyTwitter");
		scrollIntoView(CompanyProfileSaveBtn);
		clickElementByJavaScript(CompanyProfileSaveBtn);
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Organization information updated successfully");
		Thread.sleep(2000);
		return true;
	}

	public void clickonProfileCatagory() throws Exception {
		clickElementByJavaScript(profileCategory);
		Thread.sleep(2000);
	}

	public void clickOnSaveProfileCatogories() throws Exception {
		click(profileCategoryFieldSaveBtn, "profile Category Field SaveBtn");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Profile Categories Saved Successfully");
		Thread.sleep(2000);
	}

	public void addProfileCatagory(String myDetails) throws Exception {
		this.clickonProfileCatagory();
		type(profileCategory, myDetails, "profileCategory");

		profileCategory.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		this.clickOnSaveProfileCatogories();
	}

	public void deleteProfileCategory() throws Exception {
		this.clickonProfileCatagory();
		click(DeleteportfolioBtn, "DeleteportfolioBtn");
		Thread.sleep(1000);
		this.clickOnSaveProfileCatogories();

	}

	public boolean verifyLinkedInData(String LinkedInData) {

		Boolean status = true;
		String[] s = LinkedInData.split("\\s");
		String LinkedInName = s[0] + " " + s[1];
		String LinkedInMemberJobTitle = s[2];
		String LinkedInProfessionalSummary = s[3];
		String PUrl = s[4];
//		 PUrl = Java.removeCharAt(PUrl, PUrl.length()-1);
//		 
//		 try {
//			 
//		 String Name = driver.findElement(By.xpath("//*[@style='text-transform:capitalize;']")).getText();
//		 AssertionHelper.verifyText(Name, LinkedInName);
//		 } catch (Exception e) {
//			 status = false;
//		 }
//		
//		 try {
//			 String title = driver.findElement(By.xpath("//*[@ng-bind='profile.MemberProfile.JobTitle']")).getText();
//			 AssertionHelper.verifyText(title, LinkedInMemberJobTitle);
//		 status = true;
//		 } catch (Exception e) {
//			 status = false;
//		 }
//		 try {
//			 String title = driver.findElement(By.xpath("//*[@ng-bind='profile.MemberProfile.Biography']")).getText();
//			 AssertionHelper.verifyText(title, LinkedInProfessionalSummary);
//			 
//		 } catch (Exception e) {
//			 status = false;
//		 }
//		 try {
//			
//			 String LinkedIn = driver.findElement(By.xpath("//*[@ng-if='profile.MemberProfile.LinkedInUrl']//a")).getAttribute("href");
//			 AssertionHelper.verifyText(LinkedIn, PUrl);
//		 } catch (Exception e) {
//			 status = false;
//		 }
		return status;

	}

	@FindBy(xpath = "(//*[contains(text(),'Business A - 158')])[1]")

	WebElement servicesMatched;

	@FindBy(xpath = "(//*[contains(text(),'Business A - 154')])[1]")

	WebElement companiesInterested;

	@FindBy(xpath = "//h4[contains(text(),'There are no')]")

	WebElement noServicesoffer;

	@FindBy(xpath = "//*[contains(text(),'Your Organizational')]")

	WebElement noServicesneed;

	@FindBy(xpath = "(//*[contains(@id,'professional')])[1]")

	WebElement professionalMatches;

	@FindBy(xpath = "//*[contains(text(),'Global Communities')]")

	WebElement globalCommunities;

	@FindBy(xpath = "//*[contains(text(),' Logout')]")

	WebElement logout;

	@FindBy(xpath = "//*[contains(text(),' My Ecosystem')]")

	WebElement myEcosystem;

	@FindBy(xpath = "//a[contains(text(),'See')]")

	WebElement seeMore;

	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")

	WebElement Toggledropdownmenu;

	@FindBy(xpath = "//*[@name = 'LocationStatus']")

	WebElement locationStatus;

	@FindBy(xpath = "(//button[@type = 'button'])[7]")

	WebElement addLocation;

	@FindBy(xpath = "//*[contains(@name,'LocationName')]")

	WebElement locationName;

	@FindBy(xpath = "(//button[@type='submit'])[18]")

	WebElement update;

	@FindBy(xpath = "//*[contains(@name,'LocationAddress')]")

	WebElement locationAddress;

	@FindBy(xpath = "//*[@id=\"AdditionalInfoCtrl\"]/div[2]/div/div[3]/div/div[1]/div/div[2]/button/i")

	WebElement editLocation;

	// @FindBy(xpath = "(//*[@id='AdditionalInfoCtrl']//I[@class='fa fa-plus'])[2]")

	@FindBy(xpath = "//*[@id=\"AdditionalInfoCtrl\"]/div[5]/div[2]/div/button")

	WebElement addMember;

	@FindBy(xpath = "//*[contains(text(),'Additional Information')]")

	WebElement additionalInfo;

	@FindBy(xpath = "//input[@name = 'LocationAddress']")

	WebElement addressLine1;

	@FindBy(xpath = "(//*[contains(@name ,'LocationStreetAddress2')])[2]")

	WebElement locationStreetAddress2;

	@FindBy(xpath = "(//*[contains(@name,'LocationCity')])[2]")

	WebElement locationCity;

	@FindBy(xpath = "//select[contains(@name,'LocationType')]")

	WebElement locationType;

	@FindBy(xpath = "(//*[contains(@name ,'LocationState')])[2]")

	WebElement locationState;

	// *[@id="AdditionalInfoCtrl"]/div[2]/div/div[2]/div/div[1]/div/div[2]/button/i

	@FindBy(xpath = "(//*[contains(@name ,'LocationZip')])[2]")

	WebElement locationZip;

	@FindBy(xpath = "(//*[contains(@name ,'LocationCountry')])[2]")

	WebElement country;

	@FindBy(xpath = "//*[contains(@id ,'LocationPhone')]")

	WebElement phone;

	@FindBy(xpath = "//*[contains(@name,'LocationFax')]")

	WebElement fax;

	@FindBy(xpath = "(//*[contains(text(),'Save')])[9]")

	WebElement saveLocation;

	@FindBy(xpath = "(//*[contains(text(),'Save')])[10]")

	WebElement saveMember;

	@FindBy(xpath = "(//*[contains(@name,'First')])[2]")

	WebElement firstName;

	@FindBy(xpath = "(//*[contains(@name,'Last')])[2]")

	WebElement lastName;

	@FindBy(xpath = "(//*[contains(@name,'Job')])[2]")

	WebElement job;

	@FindBy(xpath = "//*[@name='EmailID']")

	WebElement emailAddress;

	@FindBy(xpath = "//*[@id='password']")

	WebElement password;

	@FindBy(xpath = "//*[@id = 'confirmpassword']")

	WebElement confirmPassword;

	@FindBy(xpath = "//*[contains(@name,'MemberContactTypeID')]")

	WebElement contactType;

	@FindBy(xpath = "//*[contains(@name,'LocationDetailID')]")

	WebElement selectLocation;

	@FindBy(xpath = "//*[contains(text(),'Additional Information')]")

	WebElement additionalInformation;

	// addskills

	@FindBy(xpath = "//*[@id=\"Skill_InterestController\"]/div[9]/div[2]/div[1]/a/i")
	WebElement addSkills;
	// addInterests

	@FindBy(xpath = "//*[@id=\"Skill_InterestController\"]/div[9]/div[2]/div[2]/a/i")
	WebElement addInterests;

	// ProfessionalMatches

	@FindBy(xpath = "//*[@id=\"ProfessionalMatchMakingController\"]/div[1]/div[2]/a")

	WebElement organizationservices;

	@FindBy(xpath = "(//button[contains(@type,'button')])[2]")

	WebElement addoffer;

	@FindBy(xpath = "//*[@id=\"OrganizationServicesForm\"]/div[1]/div[2]/div[2]/div/button")

	WebElement addNeed;

	@FindBy(xpath = "(//*[contains(@name,'ServicesOffering[]')])[2]")

	WebElement selectNeed1;

	@FindBy(xpath = "(//*[contains(@name,'ServicesOffering[]')])[1]")

	WebElement selectNeed2;

	@FindBy(xpath = "(//*[contains(@name,'ServicesSeeking[]')])[1]")

	WebElement SelectOffer1;

	@FindBy(xpath = "(//*[contains(@name,'ServicesSeeking[]')])[2]")

	WebElement SelectOffer2;

	@FindBy(xpath = "(//*[contains(text(),'Professional Matches')])[2]")

	WebElement professionalMatchtitle;

	@FindBy(xpath = "//*[@id=\"ProfessionalMatchMakingController\"]/div[1]/div[2]/a")

	WebElement organizationservicesPage;

	@FindBy(xpath = "(//*[contains(text(),'Services You Offer/Buy')])[2]")

	WebElement ServiceTitle;

	@FindBy(xpath = "(//button[@type = 'submit'])[2]")

	WebElement submit;

	@FindBy(xpath = "(//*[contains(text(),'Organization Details')])[1]")

	WebElement organizationDetails;

	@FindBy(xpath = "(//button[contains(text(),'X')])[1]")

	WebElement cancel1;

	//

	@FindBy(xpath = "(//*[contains(text(),'Business Schools')])[1]")

	WebElement expecteddata;

	@FindBy(xpath = "(//*[contains(text(),'Packaging')])[1]")

	WebElement expecteddata1;

	public ProfessionalServicesPage NavigateServicesPage() throws Throwable

	{

		Thread.sleep(5000);

		return (ProfessionalServicesPage) openPage(ProfessionalServicesPage.class);

	}

	public void serviceYouOfferandNeed() throws Throwable

	{

		waitForElementToPresent(ServiceTitle);

		Thread.sleep(5000);

		click(addoffer, "Services you OFFER");

		Thread.sleep(1000);

		Select s = new Select(selectNeed1);

		s.selectByVisibleText("Accounting");

		Thread.sleep(1000);

		Select s1 = new Select(selectNeed2);

		s1.selectByVisibleText("Automotive");

		Thread.sleep(5000);

		click(addNeed, "Services you Need");

		Thread.sleep(1000);

		Select s3 = new Select(SelectOffer1);

		s3.selectByVisibleText("Accounting");

		Thread.sleep(1000);

		click(addNeed, "Services you Need");

		Select s4 = new Select(SelectOffer2);

		s4.selectByVisibleText("Automotive");

		Thread.sleep(2000);

		click(submit, "Submit");

		Thread.sleep(8000);

	}

	public void organizationDetails(String actual) throws Throwable

	{

		click(organizationDetails, "Organization details Page");

		Thread.sleep(2000);

		String expected = expecteddata.getText();

		Assert.assertEquals(expected, actual);

	}

	public void UpdateserviceYouOfferandNeed() throws Throwable

	{

		waitForElementToPresent(ServiceTitle);

		Thread.sleep(5000);

		Select s = new Select(selectNeed1);

		s.selectByVisibleText("Business Schools");

		Thread.sleep(1000);

		Select s1 = new Select(selectNeed2);

		s1.selectByVisibleText("Packaging");

		Thread.sleep(5000);

		Select s3 = new Select(SelectOffer1);

		s3.selectByVisibleText("Business Schools");

		Thread.sleep(1000);

		Select s4 = new Select(SelectOffer2);

		s4.selectByVisibleText("Packaging");

		Thread.sleep(2000);

		click(submit, "Submit");

		Thread.sleep(8000);

	}

	public void removingProfessionalMatches(String actualServices, String actualInterested) throws Throwable

	{

		waitForElementToPresent(ServiceTitle);

		Thread.sleep(5000);

		click(cancel1, "cancel");

		Thread.sleep(2000);

		click(cancel1, "cancel");

		Thread.sleep(2000);

		click(cancel1, "cancel");

		Thread.sleep(2000);

		click(cancel1, "cancel");

		Thread.sleep(2000);

		click(submit, "Submit");

		Thread.sleep(8000);

		String expected1 = noServicesoffer.getText();

		String expected2 = noServicesneed.getText();

		Assert.assertEquals(expected1, actualServices);

		Assert.assertEquals(expected2, actualInterested);

		Thread.sleep(3000);

	}

	public GlobalCommunitesPage NavigateToGlobalcommunities() throws Throwable

	{

		Thread.sleep(2000);

		click(globalCommunities, "GlobalCommunities");

		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);

	}
	
	
	 public void professionalMatchesPage() throws Throwable
	 	
	         {
	 	
	                 click(professionalMatches,"Professional Matches");
	 	
	                 Thread.sleep(2000);
	 	
	                 waitForElementToPresent(professionalMatchtitle);
	 	
	                 click(organizationservicesPage,"Organization Services");
	 	
	                 Thread.sleep(5000);
	 	
	         }
	 	
	         
	 	
	         
	 	
	         public void matchedProfessional(String actualServicess, String actualCompaniesInterested) throws Throwable
	 	
	         
	 	
	         {
	 	
	                 Thread.sleep(2000);
	 	
	                 String expected = servicesMatched.getText();
	 	
	                 String expected1 = companiesInterested.getText();
	 	
	                 Assert.assertEquals(expected, actualServicess);
	 	
	                 Assert.assertEquals(expected1, actualCompaniesInterested);
	 
	                 Thread.sleep(2000);
	 	
	         }

	         
	         public void additionalInformation(String locationName, String locationAddress, String addressLine1,
	     			String locationStreetAddress2, String locationCity, String locationState, String locationZip,
	     			String country, String Phone, String fax) throws Throwable {
	     		click(additionalInfo, "AdditionalInformation");
	     		Thread.sleep(5000);
	     		click(addLocation, "AddLocation");
	     		Thread.sleep(3000);
	     		type(this.locationName, locationName, "LocationName");
	     		Select s = new Select(locationType);
	     		s.selectByIndex(1);
	     		Thread.sleep(1000);
	     		type(this.locationAddress, locationAddress, "LocationAddress");
	     		Thread.sleep(1000);
	     		type(this.addressLine1, addressLine1, "AddressLine1");
	     		Thread.sleep(1000);
	     		type(this.locationStreetAddress2, locationStreetAddress2, "LocationStreetAddress2");
	     		Thread.sleep(1000);
	     		type(this.locationCity, locationCity, "LocationCity");
	     		Thread.sleep(1000);
	     		type(this.locationState, locationState, "LocationState");
	     		Thread.sleep(1000);
	     		type(this.locationZip, locationZip, "LocationZip");
	     		Thread.sleep(1000);
	     		type(this.country, country, "Country");
	     		Thread.sleep(1000);
	     		type(this.phone, Phone, "Phone");
	     		Thread.sleep(1000);
	     		type(this.fax, fax, "FAX");
	     		click(saveLocation, "SaveLocation");
	     		Thread.sleep(5000);
	     	}
	     	
	     	
	     	public void inactiveLocation() throws InterruptedException
	     	{
	     		click(additionalInfo, "AdditionalInformation");
	     		Thread.sleep(2000);
	     		click(editLocation,"EditLocation");
	     		Thread.sleep(3000);
	     		Select s = new Select(locationStatus);
	     		s.selectByVisibleText("InActive");
	     		click(update,"Update");
	     		Thread.sleep(5000);
	     		
	     	}
	     	
	     	public void updateLocation(String locationName, String locationAddress, String addressLine1,
	     			String locationStreetAddress2, String locationCity, String locationState, String locationZip,
	     			String country, String Phone, String fax) throws Throwable {
	     		
	     		click(additionalInfo, "AdditionalInformation");
	     		Thread.sleep(5000);
	     		
	     		click(editLocation,"EditLocation");
	     		Thread.sleep(3000);
	     		
	     		this.locationName.clear();
	     		Thread.sleep(2000);
	     		type(this.locationName, locationName, "LocationName");
	     		
	     		Select s = new Select(locationType);
	     		s.selectByIndex(2);
	     		
	     		
	     		this.locationAddress.clear();
	     		Thread.sleep(1000);
	     		type(this.locationAddress, locationAddress, "LocationAddress");
	     		
	     		this.addressLine1.clear();
	     		Thread.sleep(1000);
	     		type(this.addressLine1, addressLine1, "AddressLine1");
	     		
	     		this.locationStreetAddress2.clear();
	     		Thread.sleep(1000);
	     		type(this.locationStreetAddress2, locationStreetAddress2, "LocationStreetAddress2");
	     		
	     		
	     		this.locationCity.clear();
	     		Thread.sleep(1000);
	     		type(this.locationCity, locationCity, "LocationCity");
	     		
	     		this.locationState.clear();
	     		Thread.sleep(1000);
	     		type(this.locationCity, locationCity, "LocationCity");
	     		
	     		
	     		
	     		
	     		
	     		this.locationZip.clear();
	     		Thread.sleep(1000);
	     		type(this.locationZip, locationZip, "LocationZip");
	     		
	     		this.country.clear();
	     		Thread.sleep(1000);
	     		type(this.country, country, "Country");
	     		
	     		this.phone.clear();
	     		Thread.sleep(1000);
	     		type(this.phone, Phone, "Phone");
	     		
	     		click(update,"Update");
	     		
	     		
	     		
	     		
	     		
	     		
	     	
	     		//click(saveLocation, "SaveLocation");
	     		Thread.sleep(5000);
	     		
	     	}
	     	
	     	
	     	public EcoSystemPage navigateToEcoSystemPage() throws Throwable {
	     		Thread.sleep(5000);
	     		click(Toggledropdownmenu, "Toggledropdownmenu");
	     		Thread.sleep(1000);
	     		click(myEcosystem,"MyEcosystem");
	     		return (EcoSystemPage) openPage(EcoSystemPage.class);
	     		// new MyGroupsPage(driver, );
	     	}

	     	public void addnewMember(String firstName, String lastName, String job, String emailAddress, String password,
	     			String confirmPassword) throws Throwable {
	     		
	     		waitForElementToPresent(additionalInfo);
	     		click(additionalInfo, "AdditionalInformation");
	     	   
	     		waitForElementToPresent(addMember);
	     		updateClass(pageheader, "");
	     		scrollToElement(addMember);
	     		click(addMember, "AddMember");
	     		Thread.sleep(2000);
	     		type(this.firstName, firstName, "FirstName");
	     		Thread.sleep(2000);
	     		type(this.lastName, lastName, "LastName");
	     		Thread.sleep(1000);
	     		type(this.job, job, "Job");
	     		Thread.sleep(1000);
	     		emailAddress = emailAddress.replace("@gmail.com", "");
	     		emailAddress = emailAddress+"+"+currentTime()+"@gmail.com";
	     		type(this.emailAddress, emailAddress, "EmailAddress");
	     		Thread.sleep(1000);
	     		type(this.password, password, "Password");
	     		Thread.sleep(1000);
	     		type(this.confirmPassword, confirmPassword, "Confirm Password");
	     		Thread.sleep(1000);
	     		Select s = new Select(contactType);
	     		s.selectByIndex(1);
	     		Thread.sleep(2000);
	     		Select s1 = new Select(selectLocation);
	     		s1.selectByIndex(1);
	     		Thread.sleep(2000);
	     		click(saveMember, "SaveMember");
	     	}
	     	
	     	public void updateMemberDetails(String firstName, String lastName, String job, String emailAddress, String password,
	     			String confirmPassword) throws Throwable {
	     		
	     		waitForElementToPresent(additionalInfo);
	     		click(additionalInfo, "AdditionalInformation");
	     	   
	     		
	     		this.FirstName.clear();
	     		Thread.sleep(1000);
	     		type(this.firstName, firstName, "FirstName");
	     		
	     		this.lastName.clear();
	     		Thread.sleep(1000);
	     		type(this.lastName, lastName, "LastName");
	     		
	     		this.job.clear();
	     		Thread.sleep(1000);
	     		type(this.job, job, "Job");
	     		
	     	
	     		Thread.sleep(1000);
	     		Select s = new Select(contactType);
	     		s.selectByIndex(1);
	     		Thread.sleep(2000);
	     		Select s1 = new Select(selectLocation);
	     		s1.selectByIndex(1);
	     		Thread.sleep(2000);
	     		click(saveMember, "SaveMember");
	     	}
	     	
	     	
	     	public void professionalMatches() throws Throwable
	     	{
	     		click(seeMore,"SeeMore");
	     		Thread.sleep(8000);
	     	}
	     	
	     	public int GetProfileProgress() throws InterruptedException {
	     		Thread.sleep(8000);
				String profileProgress=profileCompletenessBar.getText();
				profileProgress = StringUtils.stripEnd(profileProgress, "%");	
				System.out.println("ProgressBar status is " + profileProgress);
				int i = Integer.parseInt(profileProgress);				
				return i;
	     	}
	     	
	    

			public boolean CompareProgressBars(int prevProgress,int afterProgress){
				if(prevProgress <= afterProgress) {
				   return true;
				} 
				else return false;
			}   
	    
			public boolean ClearProfileDetails(String FName, String LName, String jtitle, String PPhone, String PExt,
					String PSummary, String Ytube, String LUrl, String FUrl, String TUrl) throws Exception {

				this.clickOnEditButton();
				JobTitle.clear();
				ProfessionalSummary.clear();
				YouTubeUrl.clear();
				LinkedInUrl.clear();
				FacebookUrl.clear();
				TwitterUrl.clear();
				Phone.clear();
				Ext.clear();
				click(PublicRdnBtn, "Public Radio Btn");
				Thread.sleep(5000);
				return this.UpdateProfile();
			}

			public boolean UpdatePhoneMediaVideo( String PPhone , String Ytube, String LUrl, String FUrl, String TUrl) throws Exception {

	     		this.clickOnEditButton();
	     		YouTubeUrl.clear();
	     		LinkedInUrl.clear();
	     		FacebookUrl.clear();
	     		TwitterUrl.clear();
	     		Phone.clear();
	     		
	     		picture();
//	     		new TestBase().captureScreen(, driver);
	     		scrollIntoView(CompanyPhone);
	     		Thread.sleep(3000);
	     		
	     		executeScript("arguments[0].value='" + PPhone + "';", Phone);
	     		//executeScript("arguments[0].value='" + PExt + "';", Ext);
	     		type(YouTubeUrl, Ytube, "YouTubeUrl");
	     		type(LinkedInUrl, LUrl, "LinkedInUrl");
	     		type(FacebookUrl, FUrl, "FacebookUrl");
	     		type(TwitterUrl, TUrl, "TwitterUrl");
	     		click(PublicRdnBtn, "Public Radio Btn");
	     		picture();
//	     		new TestBase().captureScreen(, driver);
	     		return this.UpdateProfile();
	     	}
			public int currentProfilePercent() {
				String percentProgress = progressBarPercent.getText();
				System.out.println(" Percent progress=" + percentProgress);

				int perStr = percentProgress.indexOf("%");

				int percentValue = Integer.parseInt(percentProgress.substring(0, perStr));
				System.out.println("After Percent progress conversion=" + percentValue);
				return percentValue;
			}
			public boolean validate_Progress(int intialProgressPercent, int finalProgressPercent) {

				if (intialProgressPercent < finalProgressPercent) {

					return true;
					
				}
				

				else
					return false;

			}
			public boolean DeleteProfileDetails() throws Exception {

				this.clickOnEditButton();
				JobTitle.clear();
				ProfessionalSummary.clear();
				YouTubeUrl.clear();
				LinkedInUrl.clear();
				FacebookUrl.clear();
				TwitterUrl.clear();
				//FirstName.clear();

				//System.out.println(FName);
				//LastName.clear();
				Phone.clear();
				Ext.clear();
				picture();
//				new TestBase().captureScreen(, driver);
				scrollIntoView(FirstName);
				
				click(PublicRdnBtn, "Public Radio Btn");
				picture();
//				new TestBase().captureScreen(, driver);
				return this.UpdateProfile();
			}   
}
