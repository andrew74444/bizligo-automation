package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;

public class CommunityDetailsPage extends BasePage {

	@FindBy(xpath = "//a[normalize-space()='Discussions']")
	WebElement discussion;

	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement joinByEmailPopUp;

	@FindBy(xpath = "(//*[contains(text(),'Ok')])")
	WebElement Ok;

	@FindBy(xpath = "(//*[contains(text(),'Join')])[1]")
	WebElement Join;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//*[contains(text(),'Yes, Proceed')]")
	WebElement YesProceed;

	// @FindBy(xpath="//*[@id='ctype_column']/h1")
	// WebElement authenticate;
	//
	// @FindBy(xpath="//*[@id='create-account_form']/div/p")
	// WebElement createAnAccountMessage;

	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	WebElement RejectBtn;

	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	WebElement AcceptBtn;

	@FindBy(xpath = "//span[contains(text(),'Groups')]")
	WebElement Groups;

	@FindBy(xpath = "//*[contains(text(),'There were no groups found')]")
	WebElement noGroups;

	@FindBy(xpath = "//input[@placeholder='Search by Groups']")
	WebElement SearchbyGroupName;

	@FindBy(xpath = "//input[@placeholder='Search Groups...']")
	WebElement SearchbyGroupName1;

	@FindBy(xpath = "(//button[contains(text(),'Search')])")
	WebElement GroupsSearchBtn;

	@FindBy(xpath = "//button[contains(.,' Join')]")
	WebElement JoinGroup;

	@FindBy(xpath = "//button[contains(text(),'Yes,Proceed')]")
	WebElement GroupsYesProceed;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OkBtn;

	@FindBy(xpath = "//*[contains(text(),'Leave')]")
	WebElement Leave;

	@FindBy(xpath = "//*[contains(text(),'Cancel')]")
	WebElement Cancel;

	@FindBy(xpath = "//img[@srcset='/Content/Images/drop-menu.png']")
	WebElement MenuDropDown;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement Logout;

	// @FindBy(tagName = "iframe")
	// WebElement iframe;

	// @FindBy(tagName = "body")
	// WebElement Postfield;

	@FindBy(xpath = "//header[@id='global-nav']")
	WebElement pageheader;

	@FindBy(xpath = "//a[normalize-space()='Discussions']")
	WebElement discussions;

	@FindBy(xpath = "//button[normalize-space()='Create New Post']")
	WebElement newPostBtn;

	@FindBy(xpath = "//button[normalize-space()='Post']")
	WebElement postBtn;
	
	@FindBy(xpath = "body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3)")
	WebElement discussionMenu;

	@FindBy(xpath = "//span[@class='ng-scope open']//ul[@class='dropdown-menu ng-scope']//li[@class='ng-scope']//a[@href='javascript:;'][normalize-space()='Edit']")
	WebElement editPost;

	@FindBy(xpath = "//span[@class='ng-scope open']//ul[@class='dropdown-menu ng-scope']//li[@class='ng-scope']//a[@href='javascript:;'][normalize-space()='Delete']")
	WebElement deletePost;


	@FindBy(xpath = "//input[@id='discussionTitle']")
	WebElement discussionTitle;

	@FindBy(xpath = "//iframe[@title='Rich Text Editor, PostContent']")
	WebElement postContent;

	@FindBy(xpath = "//div[@id='copsDisable']")
	WebElement tagMembers;
	
	
	@FindBy(xpath = "//span[@class='menu-highlighted']")
	WebElement taggedmember;
	
	@FindBy(xpath = "//*[@ng-show='appData.CommunityInfo.Description']")
	WebElement About;

	@FindBy(xpath = "//small[contains(text(),'Member')]")
	WebElement Member;

	@FindBy(xpath = "//i[@class='fa fa-lock']")
	WebElement lock;

	@FindBy(xpath = "//*[@class='menus ng-scope']/*/*[contains(text(),'Members')]")
	WebElement navbarMembers;

	@FindBy(xpath = "//*[@class='media block-update-card img-bg']")
	WebElement MemberdisplayCard;

	@FindAll({ @FindBy(xpath = "//dir-pagination-controls//a[@class]") })
	List<WebElement> Pagination;

	@FindBy(xpath = "(//button[contains(text(),'Connect')])[1]")
	WebElement connectButton;

	@FindBy(xpath = "//*[contains(text(),'Send')]")
	WebElement connectionSendbtn;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;

	@FindBy(xpath = "//u[contains(.,'Terms and Conditions')]")
	WebElement termsAndConditions;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "(//*[contains(text(),'Careers')])[1]")
	WebElement Careers;

	@FindBy(xpath = "//*[contains(text(),'Current Job Openings')]")
	WebElement CurrentJobOpenings;

	@FindBy(xpath = "//input[@placeholder='Search by Job Title']")
	WebElement SearchByJobTitle;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement Search;

	@FindBy(xpath = "//a[contains(text(),'View and Apply')]")
	WebElement ViewandApply;

	@FindBy(xpath = "//*[contains(text(),'Job Requirement Details')]")
	WebElement JobRequirementDetails;

	@FindBy(xpath = "//strong[@class='ng-binding']")
	WebElement JobTitle;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[1]")
	WebElement JobDescription;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[2]")
	WebElement AdditionalDetails;

	@FindBy(xpath = "(//div[@class='job-right-heading ng-binding'])[3]")
	WebElement Remarks;

	@FindBy(xpath = "//button[contains(.,'Apply')]")
	WebElement Apply;

	@FindBy(xpath = "//input[@id='Resume']")
	WebElement Resume;

	@FindBy(xpath = "//textarea[@id='OptionalMessage']")
	WebElement OptionalMessage;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement Submit;

	@FindBy(xpath = "//*[contains(text(),'Already Applied')]")
	WebElement AlreadyApplied;

	@FindBy(xpath = "//*[contains(text(),'no results found matching your search criteria.')]")
	WebElement noResultsFound;

	@FindBy(xpath = "//*[@title='Manage Community']/img")
	WebElement manageCommunity;

	@FindBy(xpath = "//a[normalize-space()='Advertisements']")
	WebElement Advertisements;

	@FindBy(xpath = "//*[@value='Invite Friends']")
	WebElement inviteFriends;

	@FindBy(xpath = "//*[@id='inviteMembersForm']//*[@name='FirstName']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='inviteMembersForm']//*[@name='LastName']")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='inviteMembersForm']//*[@name='EmailID']")
	WebElement EmailID;

	@FindBy(xpath = "//*[@id='btnInvites']")
	WebElement invitebtn;

	@FindBy(xpath = "//li/a/span[contains(text(),'Events')]")
	WebElement eventsMenu;

	@FindBy(xpath = "//*[@ng-bind='appData.jsResourcesErrorHandler.Community.ThereArentAnyEvents']")
	WebElement noEvents;

	@FindBy(xpath = "//*[@id='eventsController']//*[@type='text']")
	WebElement events;

	@FindBy(xpath = "//*[@id='eventsController']//button[contains(text(),'Search')]")
	WebElement eventsSearchButton;

	@FindBy(xpath = "//*[@class='top-header2 top-strip']/..")
	WebElement header;

	//@FindBy(xpath = "//*[@class='ads-cont']")
	@FindBy(xpath = "//*[@id='PromotionsImageSlider']")
	WebElement ad;

	@FindBy(xpath = "//*[@class='navbar-brand community-top-logo']/..")
	WebElement communityTopLogo;

	@FindBy(xpath = "//*[contains(text(),'Plan Name')]/following-sibling::span")
	WebElement planName;

	@FindBy(xpath = "//*[contains(text(),'Expiry Date')]/following-sibling::span")
	WebElement expiryDate;
	
	 @FindBy(tagName = "body")
	 WebElement enterTextInframe;
	 
	 @FindBy(tagName = "iframe")
	 WebElement iframe;

	@Override
	protected void getPageScreenSot() {

		updateClass(header, "");
		aShot();
//		String n = "header";
//		updateClass(header, n);
	}

	public AdvertismentPurchasePage clickOnAdvertisements() throws Exception {

		//click(navbarMembers, "Members");
		Thread.sleep(5000);
		scrollDownVertically();
//		updateClass(header, "");
	//	scrollToElement(inviteFriends);
waitForElementToPresent(Advertisements);
		clickElementByJavaScript(Advertisements);
		// click(Advertisements, "Advertisements link");
		return (AdvertismentPurchasePage) openPage(AdvertismentPurchasePage.class);
	}
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		scrollUpVertically();
		return ExpectedConditions.visibilityOf(home);//Groups
	}

	public EditCommunityPage managecommunity() throws InterruptedException {

	//	Thread.sleep(1000);
		Thread.sleep(3000);

		waitForElementToPresent(manageCommunity);

//		click(manageCommunity, "Manage Community");
		click(manageCommunity, "manage Community");

		return (EditCommunityPage) openPage(EditCommunityPage.class);
	}
	@FindBy(xpath="(//*[text()='View and Apply'])[1]")
			WebElement view;
	public void searchJob(String JobTitle) throws Exception {
		waitForElementToPresent(Careers);
		click(Careers, "Careers");
		waitForElementToPresent(view);
		waitForElementToPresent(CurrentJobOpenings);
		type(SearchByJobTitle, JobTitle, "Search By Job Title");
		click(Search, "Search");
		Thread.sleep(6000);
		WebElement ele = driver.findElement(By.xpath("(//*[contains(text(),'" + JobTitle + "')])[1]"));
		waitForElementToPresent(ele);
		ele.isDisplayed();
		click(ele, " JobTitle ");
		Thread.sleep(3000);
	}

	public void verifyUpdateJobDetails(String JobTitle, String AdditionalDetails, String Remarks) throws Exception {
		this.searchJob(JobTitle);
		click(ViewandApply, "ViewandApply");
		waitForElementToPresent(JobRequirementDetails);
		AssertionHelper.verifyText(this.JobTitle.getText(), JobTitle);
		AssertionHelper.verifyText(this.AdditionalDetails.getText(), AdditionalDetails);
		AssertionHelper.verifyText(this.Remarks.getText(), Remarks);
	}

	public void verifyInActiveJob(String JobTitle) throws Exception {
		click(Careers, "Careers");
		waitForElementToPresent(CurrentJobOpenings);
		type(SearchByJobTitle, JobTitle, "Search By Job Title");
		click(Search, "Search");
		waitForElementToPresent(noResultsFound);
		Thread.sleep(3000);

	}

	public void applyJob(String JobTitle, String Resume, String OptionalMessage) throws Exception {
		this.searchJob(JobTitle);
		click(ViewandApply, "ViewandApply");
		waitForElementToPresent(Apply);
		click(Apply, "Apply");
		waitForElementToPresent(this.Resume);

		type(this.Resume, projectFloder("\\src\\test\\resources\\testImages\\Files\\ChromePDF1.pdf"), "Resume");
		type(this.OptionalMessage, OptionalMessage, "Optional Message");
		click(Submit, "Submit");
		waitForElementToPresent(CurrentJobOpenings);
		this.searchJob(JobTitle);
		waitForElementToPresent(AlreadyApplied);
		click(AlreadyApplied, "AlreadyApplied");
		waitForElementToPresent(AlreadyApplied);
		// return new GlobalCareers(driver, OptionalMessage);
	}

	public void sendconnection() throws Exception {

		click(navbarMembers, "Clicking on Members in the nav bar ");
		waitForElementToPresent(MemberdisplayCard);
		int i = 1;
		int totalPages = 1;
		// try {
		// totalPages = Pagination.size();
		// } catch (Exception e) {
		// totalPages=1;
		// }

		// for(int i=1;i<=totalPages;)

		while (i <= totalPages) {
			try {

				click(navbarMembers, "Nav Bar");
				waitForElementToPresent(MemberdisplayCard);
				int d = driver.findElements(By.xpath("//*[@class='media block-update-card img-bg']")).size();
				int j = 1;

				while (j <= d) {
					try {

						// new
						// JavaScriptHelper(driver).scrollToElement(driver.findElement(By.xpath("((//*[@class='media
						// block-update-card col-sm-12 img-bg']))//button")));
						driver.findElement(
								By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])//button"))
								.isDisplayed();
						if (j > 2 && j <= d) {
							j = j - 2;
							scrollToElement(driver.findElement(
									By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])")));
							break;
						} else {
							break;
						}

					} catch (Exception e) {
						if (j > 2 && j <= d) {
							j = j - 2;
							scrollToElement(driver.findElement(
									By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])")));
							j = j + 2;
						}

						j++;
					}
				}

				// connectButton.isDisplayed();
				click(connectButton, "connectButton");
				waitForElementToPresent(connectionSendbtn);
		//		picture();
				click(connectionSendbtn, "connection Send btn");
				Thread.sleep(2000);
			//	picture();
				return;
			} catch (Exception e) {
				i++;
				// System.out.println(i);
				WebElement element = driver.findElement(By.xpath("(//dir-pagination-controls//a[@class])[" + i + "]"));
				click(element, "Pagination " + i);
				waitForElementToPresent(MemberdisplayCard);
				Thread.sleep(3000);
			}
		}
	}
	@FindBy(xpath="//*[@placeholder='Search by Member Name']")
	WebElement searchByName;
	@FindBy(xpath="//*[text()='Search']")
	WebElement serachBtn;
	@FindBy(xpath="//*[text()='Connect']")
	WebElement connect;
	@FindBy(xpath="	//*[text()='Pending']")
	WebElement pending;
	@FindBy(xpath="	(//*[@class='col-xs-12 text-right']/*)[2]")
	WebElement send;
	@FindBy(xpath="	(//*[@class='m-d-name firstletterCap']/*)[1]")
			WebElement Name1;
	@FindBy(xpath="//*[text()=' Cancel Request']")
	WebElement cancel;
	public void sendconnection(String name) throws Exception {
		waitForElementToPresent(navbarMembers);
		click(navbarMembers, "Clicking on Members in the nav bar ");
		waitForElementToPresent(MemberdisplayCard);
		waitForElementToPresent(searchByName);
		type(searchByName,name,"searchByName");
	
		click(searchBtn, "Search button");
		waitForElementToPresent(connect);
		click(connect, "Connect");
		waitForElementToPresent(send);
		click(send, "send");
		waitForElementToPresent(pending);
		click(Name1, "name");
		waitForElementToPresent(cancel);
		click(cancel, "Cancel request");

		}

	public void verifycommunityDetails(String communityName, String Description, String State, String City,
			String FbUrl, String linkedinUrl, String twitterUrl, String type) throws Exception {

		communityName = communityName + " " + getDateInDDMMMYYYY();
		if (driver.findElement(By.xpath("//span[contains(.,'" + communityName + "')]")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("Community name should be updated", "Community Name is not Updated");

		}

		scrollToElement(Member);
	//	Thread.sleep(2000);
		String CommunityAbout = About.getText();

		AssertionHelper.verifyText(CommunityAbout, Description);

		if (driver.findElement(By.xpath("//span[contains(.,'" + State + "')]")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("State name should be updated", "State Name is not Updated as " + State);
		}

		if (driver.findElement(By.xpath("//span[contains(.,'" + City + "')]")).isDisplayed())

		{
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("City name should be updated", "City Name is not Updated as " + City);
		}

		if (driver.findElement(By.xpath("//a[@href='" + FbUrl + "']")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("FbUrl name should be updated", "City Name is not Updated as " + FbUrl);
		}
		if (driver.findElement(By.xpath("//a[@href='" + linkedinUrl + "']")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("linkedinUrl name should be updated",
					"City Name is not Updated as " + linkedinUrl);
		}
		if (driver.findElement(By.xpath("//a[@href='" + twitterUrl + "']")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("twitterUrl name should be updated",
					"City Name is not Updated as " + twitterUrl);
		}
		// if (driver.findElement(By.xpath("//a[@href='" + googlePlusUrl +
		// "']")).isDisplayed()) {
		// AssertionHelper.verifyTrue(true);
		// } else {
		//// AssertionHelper.verifyText("googlePlusUrl name should be updated",
		//// "City Name is not Updated as " + googlePlusUrl);
		// }

		if (type.equalsIgnoreCase("private")) {
			if (lock.isDisplayed()) {
				AssertionHelper.verifyTrue(true);
			} else {
				AssertionHelper.verifyText("Community type is not updated", "Community type is not as " + type);
			}

		}
	}

	public Discussions sharePosts(String postMessage, String postFile, String linkURL, String linkName,
			String postImage, String postComment) throws Exception {
		click(discussions, "discussions");//added on 10/05
	//	 new Discussions().addPosts(postMessage, postFile, linkURL, linkName,
	//	 postImage, postComment);
		return (Discussions) openPage(Discussions.class);

	}

	public Discussions CheckNonMemberNotAbleTosharePosts() throws Exception {

		return (Discussions) openPage(Discussions.class);

	}

	
	@FindBy(xpath="//*[@class='input-group-btn']/*[text()='Search']")
	WebElement search;
	@FindBy(xpath="	(//*[@class='btn btn-subscribe ng-scope'])[1]")
			WebElement subscribe;
	public Discussions postDiscussions(String discussionTitle, String postContent,String tagMember) throws Throwable //Postdiscussions is the method name
	{
		waitForElementToPresent(discussion); 
	click(discussion, "discussion");
	//Thread.sleep(10000);
	waitForElementToPresent(subscribe);//added on 09/05
	waitForElementToPresent(search);//added on 09/05
	waitForElementToPresent(newPostBtn);
	click(newPostBtn, "CreatePost");
	//Thread.sleep(20000);
	waitForElementToPresent(this.discussionTitle);
	type(this.discussionTitle, discussionTitle, "discussions");
	Thread.sleep(10000);
	switchToFrameByID(0);
	type(enterTextInframe,postContent,"TestContent");
	switchTodefaultContent();
//	Thread.sleep(5000);
	waitForElementToPresent(tagMembers);
	type(this.tagMembers, tagMember, "TaggingMembers");
	click(taggedmember, tagMember);
//	Thread.sleep(5000);
	waitForElementToPresent(postBtn);
	click(postBtn, "postButton");
	Thread.sleep(5000);
	return (Discussions) openPage(Discussions.class);
	
	}
	@FindBy(xpath="//*[@placeholder='Search Discussion...']")
	WebElement searchBox;
	@FindBy(xpath="(//*[@class='title-section media-body'])[1]")
			WebElement title;
	public Discussions searchDiscussions(String discussionTitle) throws Throwable
	{
		waitForElementToPresent(discussion); 
	click(discussion, "discussion");
	
	waitForElementToPresent(subscribe);
	
	waitForElementToPresent(searchBox);
	
	type(searchBox,discussionTitle,"Discussion Title");
	
	waitForElementToPresent(search);
	click(search,"search button");
	waitForElementToPresent(subscribe);
	waitForElementToPresent(title);

return (Discussions) openPage(Discussions.class);
	
	}
	public void UnsubscribeCommunitydiscussion() throws InterruptedException 
	{
		waitForElementToPresent(discussion); 
		click(discussion, "discussion");
		waitForElementToPresent(unsubscribeBtn);
	click(unsubscribeBtn, "unsubscribeBtn");
	Thread.sleep(2000);
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Success!Unsubscribed. You will no longer receive notifications for this post");
//	Thread.sleep(7000);
	}
	 @FindBy(xpath = "(//button[@type='button'][normalize-space()='Unsubscribe'])[1]")
	 WebElement unsubscribeBtn;
	 
	 @FindBy(xpath = "(//button[@type='button'][normalize-space()='Subscribe'])[1]")
	 WebElement subscribeBtn;

	public void SubscribeCommunitydiscussion() throws InterruptedException 
	{
		waitForElementToPresent(discussion); 
		click(discussion, "discussion");
//		waitForElementToPresent(unsubscribeBtn);
//	click(unsubscribeBtn, "unsubscribeBtn");
//	Thread.sleep(2000);
//	waitForElementToPresent(toastMessage);
//	AssertionHelper.verifyText(toastMessage.getText(), "Success!Unsubscribed. You will no longer receive notifications for this post");
//	Thread.sleep(4000);
	waitForElementToPresent(subscribeBtn);
	click(subscribeBtn, "subscribeBtn");
	Thread.sleep(2000);
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Success! You will receive notifications if any user adds the comment");
//	Thread.sleep(7000);
	
	}
	
	
@FindBy(xpath="//*[@class='text-uppercase']/*[text()='Champions']")
	WebElement champion;
@FindBy(xpath="//*[@class='col-sm-12 cm-group-name']/*/*/*[@ng-bind='group.GroupName']")
WebElement Name;
	public void searchGroup(String groupName) throws Exception {
	//	Thread.sleep(4000);
	//	waitForElementToPresent(champion);//added on 06/04 for wait purpose
		click(Groups, "Groups");
		waitForElementToPresent(Name);//added on 06/04 for wait purpose
		waitForElementToPresent(SearchbyGroupName);
	//	Thread.sleep(6000);
	//	picture();
	//	SearchbyGroupName.clear();
		type(SearchbyGroupName, groupName, "Group Name");
		click(GroupsSearchBtn, "Groups Search Btn");
	//	Thread.sleep(5000);

	}

	public GroupDetailsPage navigateToGroupDetailsPage(String groupName) throws Exception {
	//	groupName = groupName + " " + getDateInDDMMMYYYY();
		this.searchGroup(groupName);
	Thread.sleep(2000);
		waitForElementToPresent(driver.findElement(By.xpath("//*[@class='col-sm-12 cm-group-name']/*/a")));
	//	driver.findElement(By.xpath("//*[@tooltip='" + groupName + "']")).click();
		driver.findElement(By.xpath("//*[@class='col-sm-12 cm-group-name']/*/a")).click();
		return (GroupDetailsPage) openPage(GroupDetailsPage.class);
		// new GroupDetailsPage(driver);

	}

	public GroupDetailsPage navigateToGroupDetailsPageWithoutDate(String groupName) throws Exception {

		this.searchGroup(groupName);
		driver.findElement(By.xpath("//*[@tooltip='" + groupName + "']")).click();
		return (GroupDetailsPage) openPage(GroupDetailsPage.class);
		// new GroupDetailsPage(driver);

	}

	public void JoinGroups(String groupName) throws Exception {
	//	groupName = groupName + " " + getDateInDDMMMYYYY();
		this.searchGroup(groupName);
		clickElementByJavaScript(JoinGroup);
		waitForElementToPresent(GroupsYesProceed);
		click(GroupsYesProceed, "GroupsYesProceed");
		waitForElementToPresent(toastMessage);

	}

	public void PublicGroupJoinedSuccessfully(String GroupName) throws Exception {
		this.JoinGroups(GroupName);
		AssertionHelper.verifyText(toastMessage.getText(), "You have joined the group succcesfully");
	//	Thread.sleep(6000);

	}

	public void PrivateGroupJoinedSuccessfully(String GroupName) throws Exception {
		this.JoinGroups(GroupName);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request processed successfully");
//Thread.sleep(2000);
	}

	public boolean LeaveGroup(String publicGroup) throws Exception {
		this.searchGroup(publicGroup);
		waitForElementToPresent(Leave);
		click(Leave, "Leave");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "You have removed successfully from the Group");
	//	Thread.sleep(3000);
		waitForElementToPresent(JoinGroup);
		if (JoinGroup.isDisplayed()) {
			return true;
		}
		return false;

	}

	public boolean cancelRequest(String publicGroup) throws Exception {
		waitForElementToPresent(Cancel);
		click(Cancel, "Cancel");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request processed successfully");
	//	Thread.sleep(3000);
		waitForElementToPresent(JoinGroup);
		if (JoinGroup.isDisplayed()) {
			return true;
		}
		return false;

	}

	public boolean joinCommunity() throws Exception

	{
		click(Join, "Join");
		waitForElementToPresent(YesProceed);
		click(YesProceed, "YesProceed");
		Thread.sleep(5000);
		if (Join.isDisplayed()) {
			return false;
		}
		return true;
	}

	public void notInvitedalreadymember() {

		waitForElementToPresent(joinByEmailPopUp);
		AssertionHelper.verifyText(joinByEmailPopUp.getText(),
				"You are not invited to this community, you can join the community by clicking on the Join button");
	}

	public void alredyMember() {
		waitForElementToPresent(joinByEmailPopUp);
		AssertionHelper.verifyText(joinByEmailPopUp.getText(), "");
	}

	public boolean acceptCommunityRequest() throws Exception {
		waitForElementToPresent(AcceptBtn);
		click(AcceptBtn, "AcceptBtn");
		waitForElementToPresent(YesProceed);
	//	picture();
		click(YesProceed, "Yes Proceed");
		Thread.sleep(4000);
	//	picture();
		try {
			if (AcceptBtn.isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public boolean acceptCommunityRequest(String TC) throws Exception {

		click(AcceptBtn, "AcceptBtn");
		waitForElementToPresent(YesProceed);
		String parent = driver.getWindowHandle();
	//	picture();
		click(termsAndConditions, "termsAndConditions");
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				Thread.sleep(2000);
				WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + TC + "')]"));
				waitForElementToPresent(ele);
				AssertionHelper.verifyText(ele.getText(), TC);
			//	picture();
				driver.close();
				driver.switchTo().window(parent);
				click(checkbox, "checkbox");
			}
		}
		click(YesProceed, "YesProceed");
		Thread.sleep(4000);
		picture();
		try {
			if (AcceptBtn.isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public boolean rejectCommunityRequest() throws Exception {

		click(RejectBtn, "RejectBtn");
		waitForElementToPresent(YesProceed);
		click(YesProceed, "YesProceed");
		//commented on 12/04
	//	Thread.sleep(5000);
		//waitForElementToPresent(Join);
	//	picture();
	try {
		if (RejectBtn.isDisplayed()) {
			return false;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	public GlobalCommunitesPage NavigateToGlobalCommunities() {

		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// new GlobalCommunitesPage(driver);
	}

	public void verifymembershipPlan(String membershipPlan, String groupName, String jobTitle, String resume,
			String optionalMessage) throws Exception {

		if (membershipPlan.equalsIgnoreCase("Advertisements")) {
			click(Advertisements, "Advertisements");
			Thread.sleep(6000);
		}

		if (membershipPlan.equalsIgnoreCase("Groups")) {
			this.PublicGroupJoinedSuccessfully(groupName);
		}

		if (membershipPlan.equalsIgnoreCase("Careers")) {
			this.applyJob(jobTitle, resume, optionalMessage);
		}

	}

	public void verifyAdImage(String expectedImgFileName) throws Exception {
		click(navbarMembers, "Members");
		Thread.sleep(5000);
//		updateClass(header, "");

		takeScreenshotByShutterBug(ad, "communityAdImage");
		expectedImgFileName="\\src\\test\\resources\\testImages\\Files\\ChromeImage3.jpeg";

		Imagediff.check(expectedImgFileName, "\\screenshots\\communityAdImage.png");
	}

	public void inviteFriends(Hashtable<String, String> data) throws InterruptedException {
		clickElementByJavaScript(inviteFriends);
		// click(inviteFriends,"Invite Friends");
		waitForElementToPresent(invitebtn);
		type(EmailID, data.get("friendEmail"), "invite");
		type(firstName, "Ellis", "invite");
		type(lastName, "watson", "invite");
	//	picture();
		click(invitebtn, "invite button");
		Thread.sleep(5000);
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Invitation sent successfully");
	//	picture();

	}

	public void clickOnEventsInTheMenu() {
		waitForElementToPresent(eventsMenu);
		click(eventsMenu, "Events");
	}

	public void verifyNoEvents() {
		this.clickOnEventsInTheMenu();

		waitForElementToPresent(noEvents);

		AssertionHelper.verifyText(noEvents.getText(), "There aren't any events at this time.");
	}

	public void VerifyNoGroups() {
		click(Groups, "Groups");
		waitForElementToPresent(noGroups);
		AssertionHelper.verifyText(noGroups.getText(), "There were no groups found");

	}
	@FindBy(xpath="(//*[@class='event-text-box'])[1]")
			WebElement details;
	public void searchEvent(Hashtable<String, String> data) {
		this.clickOnEventsInTheMenu();
		waitForElementToPresent(details);
		type(events, data.get("eventName"), "event Search");// + " " + getDateInDDMMMYYYY()
		click(eventsSearchButton, "Events Search Button");
		String eventName = data.get("eventName");// + " " + getDateInDDMMMYYYY()
		WebElement ele = driver
				.findElement(By.xpath("//*[@id='MainContainer']//*[contains(text(),'" + eventName + "')]"));
		waitForElementToPresent(ele);
		ele.isDisplayed();

	}

	public void clickonLogo() {

		setAttribute(communityTopLogo, "_self", "target");
		driver.get(communityTopLogo.getAttribute("href"));
		picture();

	}

	public void verifyMembershipDetails(String membershipPlan, String durations) throws Exception {
		AssertionHelper.verifyText(planName.getText(), membershipPlan);
		Thread.sleep(1000);

		int T1 = stringToInt(getSystemCurrentDate());
		int T2 = stringToInt(durations);
		System.out.println(T1 + T2);
		String expiryDate = getSystemCurrentMonth() + "-" + intToString(T1 + T2) + "-" + getSystemCurrentYear();
		System.out.println(expiryDate);
		AssertionHelper.verifyText(this.expiryDate.getText(), expiryDate);
	}
	public void verifyMembershipPlan(String membershipPlan) throws Exception {
		waitForElementToPresent(planName);//added on 18/04
		AssertionHelper.verifyText(planName.getText(), membershipPlan);
		}

	@FindBy(xpath = "//*[contains(text(),'RENEW')]")
	WebElement renew;

	public MembershipPlansPage renewMemberShipPlan() throws Exception {

		click(discussion, "discussion");
//		updateClass(header, "");
		Thread.sleep(4000);
		click(renew, "renew");
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}
//**********below method for changing membership plan added on 18/04**********\\	
	@FindBy(xpath="//*[text()='Membership Plan Details']")
	WebElement plan;
	@FindBy(xpath="//*[text()='UPGRADE']")
	WebElement upgrade;
	public MembershipPlansPage changeMemberShipPlan() throws Exception {

		waitForElementToPresent(plan);
		
		waitForElementToPresent(upgrade);
		click(upgrade,"upgrade");
		
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}
	@FindBy(xpath="//*[text()='RENEW']")
	WebElement Renew;
	public MembershipPlansPage renewFreeMemberShipPlan() throws Exception {

		waitForElementToPresent(plan);
		
		waitForElementToPresent(Renew);
		scrollToElement(Renew);
		click(Renew,"Renew");
		
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}

	@FindBy(xpath = "//*[contains(text(),'Payment Pending')]")
	WebElement paymentPending;

	public void verifyPaymentPendingDisplayed() {
		waitForElementToPresent(paymentPending);
		paymentPending.isDisplayed();

	}

	@FindBy(xpath = "//*[contains(text(),'In order to join this group, please join the community')]")
	WebElement joinCommunityPopUp;

	@FindBy(xpath = "//button[contains(text(),'No')]")
	WebElement no;

	public void checkMemberIsnotAbleToJoinGroupWithoutJoiningCommunity(String groupName) throws Exception {
		groupName = groupName + " " + getDateInDDMMMYYYY();
		this.searchGroup(groupName);
		clickElementByJavaScript(JoinGroup);
		waitForElementToPresent(GroupsYesProceed);
		click(GroupsYesProceed, "GroupsYesProceed");
		waitForElementToPresent(joinCommunityPopUp);
		click(no, "No");
		// navigateToGroupDetailsPage(groupName);
	}

	@FindBy(xpath = "//*[@title='Manage Group']")
	WebElement Menu;
	@FindBy(xpath = "//*[contains(text(),'Manage Members')]")
	WebElement ManageMembers;

	public ManageGroupMembersPageByGroupAdmin navigateToManageGroupMembers(String groupName) throws Exception {

//		groupName = groupName + " " + getDateInDDMMMYYYY();
		this.searchGroup(groupName);
		waitForElementToPresent(Menu);
	//	picture();
		Menu.click();
		waitForElementToPresent(ManageMembers);
	//	picture();
		ManageMembers.click();
		return (ManageGroupMembersPageByGroupAdmin) openPage(ManageGroupMembersPageByGroupAdmin.class);
	}

	@FindBy(xpath = "(//*[contains(text(),'Members')])[1]")
	WebElement members;

	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;

	@FindBy(xpath = "(//*[contains(text(),'Business A - 158')])[1]")

	WebElement servicesMatched;

	@FindBy(xpath = "(//*[contains(text(),'Business A - 154')])[1]")

	WebElement companiesInterested;

	@FindBy(xpath = "//h4[contains(text(),'There are no Organizations seekin')]")

	WebElement noServicessetup;

	@FindBy(xpath = "//h4[contains(text(),'Your Organizationa')]")

	WebElement noCompaniesinterested;

	@FindBy(xpath = "(//*[contains(text(),'Professional Matches')])[1]")

	WebElement professionalMatches;

	@FindBy(xpath = "//*[contains(text(),'secondary')]")

	WebElement locationVerifying;

	@FindBy(xpath = "//*[contains(text(),'Additional Information')]")

	WebElement additionalInfo;

	@FindBy(xpath = "(//*[contains(text(),'SA Carnals')])[1]")

	WebElement memberCard;

	@FindBy(xpath = "//button[contains(text(),'Search')]")

	WebElement searchBtn;

	@FindBy(xpath = "//*[contains(@id,'member')]")

	WebElement memberSearch;

	@FindBy(xpath = "//a[@data-toggle='tab'][contains(text(),'My Profile')]")

	WebElement MyProfile;
	
	
	public void matchedProfessional(String memberSearch) throws Throwable
		
	        
		
	        {
		
	           click(members,"Members");
	
	           Thread.sleep(2000);
		
	                type(this.memberSearch,memberSearch,"MemberSearch");
		
	                Thread.sleep(1000);
		
	                click(searchBtn,"SearchButton");
		
	                Thread.sleep(6000);
		
	                click(memberCard,"MemberCard");
		
	                Thread.sleep(5000);
	
	                click(professionalMatches,"Professional Matches");
	
	                Thread.sleep(5000);
		
	        }
		
		
	public void additionalInfo(String memberSearch) throws Throwable
		
	{
		
	        click(members,"Members");
		
	           Thread.sleep(2000);
	
	                type(this.memberSearch,memberSearch,"MemberSearch");
		
	                Thread.sleep(1000);
		
	                click(searchBtn,"SearchButton");
		
	                Thread.sleep(6000);
	
	                click(memberCard,"MemberCard");
		
	                Thread.sleep(5000);
		
	                click(additionalInfo,"AdditionalInformation");
		
	                Thread.sleep(3000);
		
	}
		
		
		
	public MyProfilePage navigateToMyProfilePage() throws Throwable {
		
	        Thread.sleep(5000);
		
	        click(Toggledropdownmenu, "Toggledropdownmenu");
		
	        Thread.sleep(1000);
		
	        click(MyProfile,"My ProfilePage");
		
	        return (MyProfilePage) openPage(MyProfilePage.class);
	}
	        // new MyGroupsPage(driver, );
	
	
	public void communityDetailsMembers(String memberSearch,String actual) throws Throwable
		
	        {
	
	                click(members,"Members");
		
	                Thread.sleep(2000);
	
	                type(this.memberSearch,memberSearch,"MemberSearch");
		
	                Thread.sleep(1000);
		
	                click(searchBtn,"SearchButton");
		
	                Thread.sleep(4000);
	
	                click(memberCard,"MemberCard");
		
	                Thread.sleep(5000);
		
	                click(additionalInfo,"AdditionalInfo");
	
	                Thread.sleep(5000);
	
	                String expected = locationVerifying.getText();
	
	                Assert.assertEquals(actual, expected);        
		
	        }
	
	
	

	public void memberDetailsPage(String memberSearch, String actualServices, String actualInterested)
			throws Throwable {
		click(members, "Members");
		Thread.sleep(2000);
		type(this.memberSearch, memberSearch, "MemberSearch");
		Thread.sleep(1000);
		click(searchBtn, "SearchButton");
		Thread.sleep(6000);
		click(memberCard, "MemberCard");
		Thread.sleep(5000);
		click(professionalMatches, "Professional Matches");
		Thread.sleep(5000);
		String expected1 = noServicessetup.getText();
		String expected2 = noCompaniesinterested.getText();
		Assert.assertEquals(actualServices, expected1);
		Assert.assertEquals(actualInterested, expected2);
		Thread.sleep(8000);
		
		
	

	}
	public HomePage logout() throws Exception {
	//	Thread.sleep(2000);
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
		
				
		waitForElementToPresent(Logout);
		click(Logout,"Logout");
		return (HomePage) openPage(HomePage.class);
		
	}
@FindBy(xpath="//*[@ng-click='data.goToDonationsSection()']")
	WebElement donate;

@FindBy(xpath="//*[text()='Champions']")
WebElement wait1;
@FindBy(xpath="//*[text()='select payment method']")
WebElement selectMethod;
@FindBy(xpath="(//*[@ng-model='data.SelectedinternalPrice'])[1]")
		WebElement USD;
@FindBy(xpath="(//*[@ng-value='payment.Id'])[2]")
		WebElement authorize;
@FindBy(xpath="(//*[@class='btn btn-primary center-block']/*)[1]")
		WebElement proceed;
public void makingDonation() throws InterruptedException {
	waitForElementToPresent(wait1);
	waitForElementToPresent(donate);
	click(donate,"donate");

}
@FindBy(xpath = "//input[@id='cardNum']")
WebElement cardNum;

@FindBy(xpath = "//input[@id='expiryDate']")
WebElement ExpiryDate;

@FindBy(xpath = "//input[@id='cvv']")
WebElement CVV;
@FindBy(xpath = "//*[@name='email']")
WebElement email;

@FindBy(xpath = "//*[@id='payBtn']")
WebElement PayBtn;

@FindBy(xpath = "//*[@class='text-center']/*[text()='Your Payment processed successfully and Thanks for Donating.']")
WebElement success;
public void makingPayment() {
	waitForElementToPresent(cardNum);
	type(cardNum, "4111111111111111", "card Num");
	waitForElementToPresent(ExpiryDate);
	type(ExpiryDate, "0525", "Expiry Date");
	waitForElementToPresent(CVV);
	type(CVV, "025", "CVV");
	waitForElementToPresent(email);
	type(email, "yogesh.bhor141@yahoo.com", "email");
	waitForElementToPresent(PayBtn);
    click(PayBtn, "payBtn");
    waitForElementToPresent(success);
    System.out.println(success.getText());
}
public AuthorizeGateway paymentByauthorize() throws Exception {
	waitForElementToPresent(selectMethod);
	waitForElementToPresent(USD);
	click(USD,"1 USD");
	waitForElementToPresent(authorize);
	click(authorize,"authorize");
	waitForElementToPresent(proceed);
	click(proceed,"proceed");
	Thread.sleep(10000);
	return (AuthorizeGateway) openPage(AuthorizeGateway.class);
}

@FindBy(xpath = "(//*[text()='Resources'])[1]")
WebElement resources;

@FindBy(xpath = "(//*[@class='col-md-4 ng-scope']/*/*)[1]")
WebElement resource1;
@FindBy(xpath = "(//*[@class='col-md-4 ng-scope']/*/*)[2]")
		WebElement resource2;
public void  checkingResources() throws Exception {


		waitForElementToPresent(resources);
		click(resources,"Resources");
		
		waitForElementToPresent(resource1);
		if(this.resource1.isDisplayed()&&this.resource1.isEnabled()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
			}


public void  checkingResources2() throws Exception {


	waitForElementToPresent(resources);
	click(resources,"Resources");
	
	waitForElementToPresent(resource2);
	if(this.resource2.isDisplayed()&&this.resource2.isEnabled()) {
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
		}

@FindBy(xpath="(//*[@class='col-md-4 ng-scope']/*)[2]")
WebElement resourceTitle;


public void checkResource(String title) {
	waitForElementToPresent(resources);
	click(resources,"Resources");

	
	waitForElementToPresent(resourceTitle);
	String Value=resourceTitle.getAttribute("data-title");
	System.out.println(Value);
	
    if(title.equals(Value)) {
    	Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}
    }
@FindBy(xpath="(//*[@class='text-center jumbotron ng-scope']/*)[1]")
		WebElement text;
public void resourceNotdisplaying() {
	waitForElementToPresent(resources);
	click(resources, "resources");
	
	waitForElementToPresent(text);
	String msg=text.getText();
	System.out.println(msg);
}
@FindBy(xpath="(//*[@class='col-lg-6 col-lg-offset-3']/*/p)[4]")
WebElement photos;
public void checkgroupResource() {
	waitForElementToPresent(resources);
	click(resources,"Resources");
	waitForElementToPresent(photos);
	System.out.println(photos.getText());
	
}
@FindBy(tagName = "body")
WebElement Postfield;

@FindBy(xpath = "//input[@placeholder='Search Discussion...']")
WebElement searchDiscussion;

@FindBy(xpath = "//button[contains(text(),'Search')]")
WebElement Searchbtn;
@FindBy(xpath = "//*[contains(text(),'Create New Post')]")
WebElement	createNewPost;
@FindBy(xpath = "//*[contains(text(),'Join this community to participate in the discussion')]/..//*//*[contains(text(),'Cancel')]")
WebElement JoinThisCommunityCancelButton;
@FindBy(xpath = "(//*[contains(text(),'Like')])[1]")
WebElement clickFirstPostLike;

@FindBy(xpath = "(//*[contains(text(),'Like')])[2]")
WebElement clickFirstCommentLike;
@FindBy(xpath = "//*[@id='NewPostForm']//button[contains(text(),'Post')]")
WebElement PostBtn;
@FindBy(xpath = "(//*[@data-placeholder='Write a comment...'])[1]")
WebElement FirstPostComment;


public void CheckNonMemberIsNotAbleToPostLikeComment() throws Exception {
	
	
	click(discussions, "discussions");

	waitForElementToPresent(searchDiscussion);
	waitForElementToPresent(createNewPost);
	click(createNewPost, "create New Post");
	waitForElementToPresent(PostBtn);
	
	scrollIntoView(Searchbtn);

	type(discussionTitle, "discussion Title", "discussion Title");


	waitForElementToPresent(JoinThisCommunityCancelButton);
	click(JoinThisCommunityCancelButton, "Cancel Button");
	Thread.sleep(2000);

	click(clickFirstPostLike, "First Post Like");
	waitForElementToPresent(JoinThisCommunityCancelButton);
	click(JoinThisCommunityCancelButton, "Cancel Button");
	Thread.sleep(2000);

	click(FirstPostComment, "Post field");
	waitForElementToPresent(JoinThisCommunityCancelButton);
	click(JoinThisCommunityCancelButton, "Cancel Button");
	Thread.sleep(1000);

}
@FindBy(xpath="//*[@ui-sref='community.event']")
	WebElement event;
  @FindBy(xpath="//*[@class='communities-name']/*")
  WebElement name;
  public EventsPage gotoevents() throws InterruptedException {
	
	
		waitForElementToPresent(event);
		click(event, "Events");
		Thread.sleep(3000);
		return (EventsPage) openPage(EventsPage.class);
		
	}
@FindBy(xpath="//*[@ng-click='data.redirectoAdvertisements()']")
  WebElement ads;
@FindBy(xpath="(//*[text()='Select Plan'])[1]")
		WebElement plan2;
  public void NonCommunityMemberCannotSeeAdPalns() {
	  String currentpage=driver.getCurrentUrl();
	  System.out.println(currentpage);
	  waitForElementToPresent(ads);
	click(ads,"Advertisments") ;
	 String newpage=driver.getCurrentUrl();
	 System.out.println(newpage);
	if(newpage.equals(currentpage)) {
		  Assert.assertTrue(true);
		  System.out.println("Non community member cannot see ad plans");
	}
	else {
		  Assert.assertTrue(false);
		 
		  }
  }
@FindBy(xpath="//*[@ng-form='PromotionPlanInfo']/*/*[@class='row']")
  WebElement list;
public void inActivePlanIsNotPresent(String name) {
	  waitForElementToPresent(ads);
		click(ads,"Advertisments") ;
		waitForElementToPresent(list);
		String plans=list.getText();
		name=name+ "" + getDateInDDMMMYYYY();
	//driver.findElement(By.xpath("(//*[@title='"+name+"'])[1]"));
		System.out.println(list);
		
		if(plans.contains(name)) {
			Assert.assertTrue(false);
		}
		else{
			Assert.assertTrue(true);
			System.out.println("InActive Plan is not present");
		}
	
}
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
