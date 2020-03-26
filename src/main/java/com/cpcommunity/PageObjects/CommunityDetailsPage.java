package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	@FindBy(xpath = "//*[@class='header']//*[contains(text(),'Discussion')]")
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

	@FindBy(xpath = "//*[@ng-show='appData.CommunityInfo.Description']")
	WebElement About;

	@FindBy(xpath = "//small[contains(text(),'Member')]")
	WebElement Member;

	@FindBy(xpath = "//i[@class='fa fa-lock']")
	WebElement lock;

	@FindBy(xpath = "//*[@class='navbar mynav']//*[contains(text(),'Members')]")
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

	@FindBy(xpath = "//*[@title='Manage Community']")
	WebElement manageCommunity;

	@FindBy(xpath = "//strong[contains(text(),'Advertisements')]")
	WebElement Advertisements;

	@FindBy(xpath = "//*[@value='Invite Friends']")
	WebElement inviteFriends;

	@FindBy(xpath = "//*[@id='inviteSelect-selectized']")
	WebElement invitefield;

	@FindBy(xpath = "//*[@id='btnInvites']")
	WebElement invitebtn;

	@FindBy(xpath = "//*[@id='navbar']//*[contains(text(),'Events')]")
	WebElement eventsMenu;

	@FindBy(xpath = "//*[@ng-bind='appData.jsResourcesErrorHandler.Community.ThereArentAnyEvents']")
	WebElement noEvents;

	@FindBy(xpath = "//*[@id='eventsController']//*[@type='text']")
	WebElement events;

	@FindBy(xpath = "//*[@id='eventsController']//button[contains(text(),'Search')]")
	WebElement eventsSearchButton;

	@FindBy(xpath = "//*[@class='top-strip']/..")
	WebElement header;

	@FindBy(xpath = "//*[@class='ads-cont']")
	WebElement ad;

	@FindBy(xpath = "//*[@class='navbar-brand community-top-logo']/..")
	WebElement communityTopLogo;

	@FindBy(xpath = "//*[contains(text(),'Plan Name')]/following-sibling::span")
	WebElement planName;

	@FindBy(xpath = "//*[contains(text(),'Expiry Date')]/following-sibling::span")
	WebElement expiryDate;

	@Override
	protected void getPageScreenSot() {

		updateClass(header, "");
		aShot();
		String n = "header";
		updateClass(header, n);
	}

	public AdvertismentPurchasePage clickOnAdvertisements() throws Exception {

		click(navbarMembers, "Members");
		Thread.sleep(5000);
		updateClass(header, "");
		scrollToElement(inviteFriends);

		clickElementByJavaScript(Advertisements);
		// click(Advertisements, "Advertisements link");
		return (AdvertismentPurchasePage) openPage(AdvertismentPurchasePage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		scrollUpVertically();
		return ExpectedConditions.visibilityOf(discussion);
	}

	public EditCommunityPage managecommunity() throws InterruptedException {

		Thread.sleep(1000);
		Thread.sleep(1000);
		
		
		waitForElementToPresent(manageCommunity);
		
//		click(manageCommunity, "Manage Community");
		manageCommunity.click();
			
		
		
		
		
		return (EditCommunityPage) openPage(EditCommunityPage.class);
	}

	public void searchJob(String JobTitle) throws Exception {
		click(Careers, "Careers");
		waitForElementToPresent(CurrentJobOpenings);
		type(SearchByJobTitle, JobTitle, "Search By Job Title");
		click(Search, "Search");
		Thread.sleep(6000);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + JobTitle + "')]"));
		waitForElementToPresent(ele);
		ele.isDisplayed();
		click(ele, "");
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
		
		type(this.Resume, projectFloder(Resume), "Resume");
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
				picture();
				click(connectionSendbtn, "connection Send btn");
				Thread.sleep(2000);
				picture();
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

	public void verifycommunityDetails(String communityName, String Description, String State, String City,
			String FbUrl, String linkedinUrl, String twitterUrl, String type) throws Exception {

		communityName = communityName + " " + date();
		if (driver.findElement(By.xpath("//span[contains(.,'" + communityName + "')]")).isDisplayed()) {
			AssertionHelper.verifyTrue(true);
		} else {
			AssertionHelper.verifyText("Community name should be updated", "Community Name is not Updated");

		}

		scrollToElement(Member);
		Thread.sleep(2000);
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
//		 new Discussions().addPosts(postMessage, postFile, linkURL, linkName,
		// postImage, postComment);
		return (Discussions) openPage(Discussions.class);

	}

	public Discussions CheckNonMemberNotAbleTosharePosts() throws Exception {

		return (Discussions) openPage(Discussions.class);

	}

	public void searchGroup(String groupName) throws Exception {
		Thread.sleep(4000);
		click(Groups, "Groups");
		waitForElementToPresent(SearchbyGroupName);
		Thread.sleep(6000);
		picture();
		SearchbyGroupName.clear();
		type(SearchbyGroupName, groupName, "Group Name");
		click(GroupsSearchBtn, "Groups Search Btn");
		Thread.sleep(5000);

	}

	public GroupDetailsPage navigateToGroupDetailsPage(String groupName) throws Exception {
		groupName = groupName + " " + dateInNumbers();
		this.searchGroup(groupName);
		driver.findElement(By.xpath("//*[@tooltip='" + groupName + "']")).click();
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
		groupName = groupName + " " + dateInNumbers();
		this.searchGroup(groupName);
		clickElementByJavaScript(JoinGroup);
		waitForElementToPresent(GroupsYesProceed);
		click(GroupsYesProceed, "GroupsYesProceed");
		waitForElementToPresent(toastMessage);

	}

	public void PublicGroupJoinedSuccessfully(String GroupName) throws Exception {
		this.JoinGroups(GroupName);
		AssertionHelper.verifyText(toastMessage.getText(), "You have joined the group succcesfully");
		Thread.sleep(6000);

	}

	public void PrivateGroupJoinedSuccessfully(String GroupName) throws Exception {
		this.JoinGroups(GroupName);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request processed successfully");

	}

	public boolean LeaveGroup(String publicGroup) throws Exception {
		this.searchGroup(publicGroup);
		click(Leave, "Leave");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "You have removed successfully from the Group");
		Thread.sleep(3000);
		waitForElementToPresent(JoinGroup);
		if (JoinGroup.isDisplayed()) {
			return true;
		}
		return false;

	}

	public boolean cancelRequest(String publicGroup) throws Exception {

		click(Cancel, "Cancel");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request processed successfully");
		Thread.sleep(3000);
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

		click(AcceptBtn, "AcceptBtn");
		waitForElementToPresent(YesProceed);
		picture();
		YesProceed.click();
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

	public boolean acceptCommunityRequest(String TC) throws Exception {

		click(AcceptBtn, "AcceptBtn");
		waitForElementToPresent(YesProceed);
		String parent = driver.getWindowHandle();
		picture();
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
				picture();
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
		Thread.sleep(15000);
		waitForElementToPresent(Join);
		picture();
		try {
			if (Join.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
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
		updateClass(header, "");

		takeScreenshotByShutterBug(ad, "communityAdImage");
		Imagediff.check(expectedImgFileName, "\\screenshots\\communityAdImage.png");
	}

	public void inviteFriends(Hashtable<String, String> data) {
		clickElementByJavaScript(inviteFriends);
		// click(inviteFriends,"Invite Friends");
		waitForElementToPresent(invitebtn);
		type(invitefield, data.get("friendEmail"), "invite");
		invitefield.sendKeys(Keys.ENTER);
		picture();
		click(invitebtn, "invite button");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Invitation sent successfully");
		picture();

	}

	public void clickOnEventsInTheMenu() {
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

	public void searchEvent(Hashtable<String, String> data) {
		this.clickOnEventsInTheMenu();
		type(events, data.get("eventName") + " " + date(), "event Search");
		click(eventsSearchButton, "Events Search Button");
		String eventName = data.get("eventName") + " " + date();
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + eventName + "')]"));
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

	@FindBy(xpath = "//*[contains(text(),'RENEW')]")
	WebElement renew;

	public MembershipPlansPage renewMemberShipPlan() {

		click(discussion, "");
		click(renew, "renew");
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
		groupName = groupName + " " + dateInNumbers();
		this.searchGroup(groupName);
		clickElementByJavaScript(JoinGroup);
		waitForElementToPresent(GroupsYesProceed);
		click(GroupsYesProceed, "GroupsYesProceed");
		waitForElementToPresent(joinCommunityPopUp);
		click(no, "No");
		// navigateToGroupDetailsPage(groupName);
	}

	@FindBy(xpath = "//img[@height='16']")
	WebElement Menu;
	@FindBy(xpath = "//*[contains(text(),'Manage Members')]")
	WebElement ManageMembers;

	public ManageGroupMembersPageByGroupAdmin navigateToManageGroupMembers(String groupName) throws Exception {

		groupName = groupName + " " + dateInNumbers();
		this.searchGroup(groupName);
		waitForElementToPresent(Menu);
		picture();
		Menu.click();
		waitForElementToPresent(ManageMembers);
		picture();
		ManageMembers.click();
		return (ManageGroupMembersPageByGroupAdmin) openPage(ManageGroupMembersPageByGroupAdmin.class);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
