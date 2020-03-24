package com.cpcommunity.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class MyProfilePage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@FindBy(xpath = "//a[@data-toggle='tab'][contains(text(),'My Profile')]")
	WebElement MyProfile;
	@FindBy(xpath = "//i[@title='Edit Profile']")
	WebElement EditBtn;

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
	@FindBy(xpath = "//label[@title='Visible only to your connections']")
	WebElement PrivateRdnBtn;
	@FindBy(xpath = "//input[@value='0']")
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

	@FindBy(xpath = "//a[contains(.,' Apply LinkedIn Profile')]")
	WebElement ApplyLinkedInProfileBtn;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(EditBtn);
	}

	
	
	public void clickOnEditButton( ) throws Exception {
		
		click(EditBtn,"EditBtn");
		Thread.sleep(2000);
		picture();
	}

	public boolean updateCompanyProfile(String CompanyName,String CompanyEmail,String CompanyPhone,String CompanyExt) {

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
			String PSummary, String Ytube, String LUrl, String FUrl, String TUrl ) throws Exception {

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
		click(PublicRdnBtn,"Public Radio Btn");
		picture();
//		new TestBase().captureScreen(, driver);
		return this.UpdateProfile();
	}

	public boolean UpdateProfile( ) throws Exception {
		scrollIntoView(MyProfileSaveBtn);
		Thread.sleep(1000);		
		clickElementByJavaScript(MyProfileSaveBtn);
		//*[contains(text(),'Save')]
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

	public boolean SelectEmailPrivate( ) throws Exception {

		this.clickOnEditButton();
		scrollIntoView(MyProfileSaveBtn);
		boolean PEmail = PrivateEmail.isSelected();
		if (PEmail) {
			click(MyProfileCancelBtn,"MyProfileCancelBtn");
			Thread.sleep(1000);
			return PEmail;
		} else {

			click(PrivateEmail,"PrivateEmail");
			Thread.sleep(1000);
			boolean status = this.UpdateProfile();
			return status;

		}
	}

	public boolean UnSelectEmailPrivate( ) throws Exception {
		this.clickOnEditButton();
		scrollIntoView(MyProfileSaveBtn);
		boolean PEmail = PrivateEmail.isSelected();
		if (PEmail) {
			Thread.sleep(1000);

			click(PrivateEmail,"PrivateEmail");
			boolean status = this.UpdateProfile();
			return status;
		} else {
			boolean status = this.UpdateProfile();
			return status;
		}

	}

	public boolean SelectPhonePrivate(String PPhone ) throws Exception {

		this.clickOnEditButton();
		Phone.clear();
		
		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		boolean PEmail = PrivatePhoneNo.isSelected();
		System.out.println(PEmail);
		if (PEmail) {
			click(MyProfileCancelBtn,"MyProfileCancelBtn");
			return PEmail;
		}

		else {

			click(PrivatePhoneNo,"PrivatePhoneNo");
			Thread.sleep(1000);
			boolean Status = this.UpdateProfile();
			return Status;
		}
	}

	public boolean UnSelectPhonePrivate(String PPhone ) throws Exception {
		this.clickOnEditButton();
		Phone.clear();
		
		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		picture();
//		new TestBase().captureScreen(, driver);
		boolean PEmail = PrivatePhoneNo.isSelected();
		if (PEmail) {
			Thread.sleep(1000);
			click(PrivatePhoneNo,"PrivatePhoneNo");
			Thread.sleep(2000);
		}

		Boolean status = this.UpdateProfile();

		Thread.sleep(2000);
		// String MyPhNo = myProfilePageSavedPhoneno.getText();
		return status;
	}

	public boolean PrivateRadioButton(String PPhone ) throws Exception {

		this.clickOnEditButton();
		Thread.sleep(1000);
		Phone.clear();
		
		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		Thread.sleep(5000);
		click(PrivateRdnBtn,"PrivateRdnBtn");
		boolean status = this.UpdateProfile();
		return status;
	}

	public boolean publicRadioButton(String PPhone ) throws Exception {

		this.clickOnEditButton();
		Phone.clear();
		
		executeScript("arguments[0].value='" + PPhone + "';", Phone);
		executeScript("arguments[0].scrollIntoView(true);", MyProfileSaveBtn);
		Thread.sleep(5000);
		click(PublicRdnBtn,"PublicRdnBtn");
		Thread.sleep(1000);
		return this.UpdateProfile();

	}

	public void scrollToProtfolio() {
		scrollToElement(Skills_Interests);
	}

	public boolean AddProtfolio(String title, String url ) throws Exception {

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
		click(PortfolioSaveBtn,"PortfolioSaveBtn");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Portfolio Saved Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (SuccessPopup.getText().equalsIgnoreCase("Portfolio Saved Successfully")) {
			return true;
		}
		else {
			return false;
		}
		

	}

	public boolean updatePortfolio(String title, String url ) throws Exception {
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
		click(PortfolioTitle,"PortfolioTitle");
		click(UpdateBtn,"UpdateBtn");
		waitForElementToPresent(SuccessPopup);
		String Message = SuccessPopup.getText();
		AssertionHelper.verifyText(Message, "Portfolio Updated Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (Message.equalsIgnoreCase("Portfolio Updated Successfully")) 
		{
			return true;
		}
		 else {
			return false;
		}

	}

	public boolean DeletePortfolio(String title, String url ) throws Exception {
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

	public boolean clickOnSkillsSavebutton( ) throws Exception {
		Thread.sleep(1000);
		click(SkillsSaveBtn,"SkillsSaveBtn");
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

	public boolean AddSkills(String Skills ) throws Exception {
		this.ClickOnEditSkillsBtn();
		type(AddSkills, Skills, "AddSkills");
		
		Thread.sleep(1000);
		AddSkills.sendKeys(Keys.ENTER);
		picture();
//		new TestBase().captureScreen(, driver);
		Thread.sleep(1000);
		return this.clickOnSkillsSavebutton();
	}

	public boolean DeleteSkills( ) throws Exception {
		this.ClickOnEditSkillsBtn();
		click(DeleteSkillsBtn,"DeleteSkillsBtn");
		return this.clickOnSkillsSavebutton();
	}

	public boolean AddInterests(String interests ) throws Exception {
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

	public boolean clickOnInterestsSavebutton( ) throws Exception {
		Thread.sleep(1000);
		click(InterestsSaveBtn,"InterestsSaveBtn");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Skills and Interests Saved Successfully");
		picture();
//		new TestBase().captureScreen(, driver);
		if (SuccessPopup.getText().equalsIgnoreCase("Skills and Interests Saved Successfully")) {
			return true;
		}
		return false;
	}

	public boolean DeleteInterests( ) throws Exception {
		this.ClickOnEditInterestsBtn();
		Thread.sleep(2000);
		waitForElementToPresent(DeleteInterestBtn);
		picture();
//		new TestBase().captureScreen(, driver);
		click(DeleteInterestBtn,"DeleteInterestBtn");
		picture();
//		new TestBase().captureScreen(, driver);
		return this.clickOnInterestsSavebutton();
	}

	public void ChangeProfilePicture() throws Exception {
		click(changeProfilePictureLink,"changeProfilePictureLink");
		Thread.sleep(2000);
		click(BrowseBtn,"BrowseBtn");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:/workspace/CPCommunityQA/src/main/resources/configfile/ExeFiles/ChromeImage1.exe");
		Thread.sleep(4000);
		click(UploadBtn,"UploadBtn");
		Thread.sleep(3000);
	}

	public void ChangeCompanypicture() throws InterruptedException, IOException {

		clickElementByJavaScript(companyProfileTab);
		click(changeProfilePictureLink,"changeProfilePictureLink");
		Thread.sleep(2000);
		click(CompanyBrowsebtn,"CompanyBrowsebtn");
		Thread.sleep(5000);
		Runtime.getRuntime()
				.exec("D:/workspace/CPCommunityQA/src/main/resources/configfile/ExeFiles/ChromeImage2	.exe");
		Thread.sleep(4000);
		click(UploadBtn,"UploadBtn");
	}

	public boolean updateCompanyProfile(String CName, String CEmail, String CPhone, String CExt, String Fax, String CDesc,
			String CLUrl, String CFUrl, String CTUrl, String CGUrl) throws Exception {
		
		
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
		click(profileCategoryFieldSaveBtn,"profile Category Field SaveBtn");
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
		click(DeleteportfolioBtn,"DeleteportfolioBtn");
		Thread.sleep(1000);
		this.clickOnSaveProfileCatogories();

	}
	
	
	public boolean verifyLinkedInData(String LinkedInData){		
	
		Boolean status= true;
		String[] s =LinkedInData.split("\\s");
		 String LinkedInName = s[0]+" "+ s[1];
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

//	 public UpdatewithlinkedinPage applyWithLinkedIn()throws Exception
//	 {
//	
//	
//	
//	
//	 click(ApplyLinkedInProfileBtn,"ApplyLinkedInProfileBtn");
//	
////	 updatewithlinkedinPage updatewithlinkedin_Page = new  updatewithlinkedinPage(driver);
////	 String LinkedDate = updatewithlinkedin_Page.ApplyWithLinkedIn(LinkedinEmail, LinkedInPwd);
//	 
//	
//	return new UpdatewithlinkedinPage(driver, );
//	 }
	
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
