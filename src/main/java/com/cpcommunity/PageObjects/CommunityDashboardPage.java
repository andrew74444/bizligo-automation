package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class CommunityDashboardPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@FindBy(xpath = "(//*[contains(text(),'Posts')])[1]")
	WebElement posts;
	
	@FindBy(xpath = "(//*[contains(text(),'Blogs')])[1]")
	WebElement blogs;

	@FindBy(xpath = "(//*[contains(text(),'Categories')])[1]")
	WebElement categories;

	@FindBy(xpath = "(//*[contains(text(),'Tags')])[1]")
	WebElement tags;

	@FindBy(xpath = "//*[@class='fa fa-angle-down']")
	WebElement angleDown;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement logout;

	@FindBy(xpath = "//h2[contains(text(),'Dashboard')]")
	WebElement Dashboard;

	@FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
	WebElement manage;

	@FindBy(xpath = "(//*[contains(text(),' Invite Members')])")
	WebElement invitePeople;

	@FindBy(xpath = "(//*[contains(text(),'Groups')])[1]")
	WebElement Groups;

	@FindBy(xpath = "(//*[contains(text(),'Pending Requests')])[1]")
	WebElement CommunityPendingRequest;

	@FindBy(xpath = "(//*[contains(text(),'Pending Requests')])[2]")
	WebElement groupPendingRequest;

	@FindBy(xpath = "(//*[contains(text(),'Manage Groups')])")
	WebElement ManageGroups;

	@FindBy(xpath = "(//a[contains(.,'Members')])[2]")
	WebElement Members;

	@FindBy(xpath = "(//a[contains(.,'Manage Members')])[1]")
	WebElement ManageMembers;

	@FindBy(xpath = "//*[@title='Meeting Accounts']")
	WebElement MeetingAccounts;

	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/Jobs/Jobs-active.png'])/..)/..)")
	WebElement Jobs;
	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Jobs'])")
	WebElement ManageJobs;

	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Applications'])")
	WebElement ManageApplications;

	@FindBy(xpath = "//a[@title='Edit Community']")
	WebElement EditCommunity;

	@FindBy(xpath = "//*[contains(text(),'Pending Invitations')]")
	WebElement PendingInvitations;
	@FindBy(xpath = "(//*[contains(text(),'Pending Requests')])[1]")
	WebElement CommunityPendingRequests;

	@FindBy(xpath = "//a[@title='Payment Gateways']")
	WebElement paymentGateways;

	@FindBy(xpath = "//a[@title='Manage Events']")
	WebElement Events;

	@FindBy(xpath = "//a[contains(text(),'Membership Plans')]")
	WebElement MembershipPlans;

	// @FindBy(xpath="//input[@id='EventNameSearch']")
	// WebElement EventNameSearch;

	@FindBy(xpath = "//button[@id='btnSearch']")
	WebElement btnSearch;

	@FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;

	@FindBy(xpath = "//*[contains(text(),'Manage Member Advertisements')]")
	WebElement manageMemberAdvertisements;

	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
	
	@FindBy(xpath = "//a[contains(text(),'Promo Code')]")
	WebElement promoCode;
	
	@FindBy(xpath = "//a[normalize-space()='Manage Campaign']")
	WebElement ManageCampaign;
	
	@FindBy(xpath = "//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	@FindBy(xpath = "//a[normalize-space()='Statistics']")
	WebElement statistics;
	
	@FindBy(xpath = "//a[normalize-space()='Import Contacts']")
	WebElement ImportContacts;
	
	
	

	public PromoCodePage goToPromoCodePage() {

		scrollToElement(Events);
		waitForElementToPresent(promoCode);
		click(promoCode, "promoCode");
		return (PromoCodePage) openPage(PromoCodePage.class);
		// new CommunityPendingRequestsPage(driver);
	}
	
	public void clickOnAdvertisments() {
		click(advertisements, "advertisements");
	}

	public ManageAdPlansPage goToManageAdPlansPage() {

		this.clickOnAdvertisments();
		waitForElementToPresent(managePlans);
		click(managePlans, "Manage Plans");
		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
		// new CommunityPendingRequestsPage(driver);
	}

	public ManageMemberAdvertisementsPage navigateToMemberAdvertisements() {

		this.clickOnAdvertisments();
		waitForElementToPresent(manageMemberAdvertisements);
		click(manageMemberAdvertisements, "Manage Member Advertisements");
		return (ManageMemberAdvertisementsPage) openPage(ManageMemberAdvertisementsPage.class);
		// new CommunityPendingRequestsPage(driver);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(Dashboard);
		return ExpectedConditions.visibilityOf(Dashboard);
	}

	public HomePage logout() {
		click(angleDown, "Community Admin Menu Drop down");
		waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}
	// public void searchByEventName(String eventTitle) throws Exception
	// {
	// type(EventNameSearch, eventTitle, "Event Name Search");
	// click(btnSearch,"btnSearch");
	// Thread.sleep(5000);
	// }

	public CommunityPendingRequestsPage NavigateToCommunityPendingRequets() {

		click(Members, "Members");
		waitForElementToPresent(CommunityPendingRequest);
		click(CommunityPendingRequest, "Community Pending Request");
		return (CommunityPendingRequestsPage) openPage(CommunityPendingRequestsPage.class);
		// new CommunityPendingRequestsPage(driver);
	}

	public MeetingAccountsPage navigateToMeetingAccounts() throws Exception {
		scrollToElement(Events);
		Thread.sleep(500);
		click(MeetingAccounts, "Meeting Accounts");
		return (MeetingAccountsPage) openPage(MeetingAccountsPage.class);
		// new MeetingAccountsPage(driver);
	}

	public PlansPage navigateToMembershipPlans() throws Exception {
		Thread.sleep(500);
		scrollIntoView(pricingPlanDetails);
		Thread.sleep(500);
		click(MembershipPlans, "Membership Plans");
		return (PlansPage) openPage(PlansPage.class);
		// new MeetingAccountsPage(driver);
	}

	public PaymentGatewaysPage navigateToPaymentGateways() {
		click(paymentGateways, "payment Gateways");
		return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
		// new PaymentGatewaysPage(driver);
	}

	public EditCommunityPage navigateToEditCommunityPage() throws Exception {
		click(manage, "manage");
		Thread.sleep(1000);
		click(EditCommunity, "EditCommunity");
		return (EditCommunityPage) openPage(EditCommunityPage.class);
		// new EditCommunityPage(driver);
	}

	public GroupsPendingRequestsPage NavigateToCommunitygroupPendingRequets() {

		click(Groups, "Groups");
		waitForElementToPresent(groupPendingRequest);
		click(groupPendingRequest, "group Pending Request");
		return (GroupsPendingRequestsPage) openPage(GroupsPendingRequestsPage.class);
		// new GroupsPendingRequestsPage(driver);

	}
	
	public ComposeCampaignPage NavigatetoComposeCampaignPage() {

		click(ManageCampaign, "ManageCampaign");
		waitForElementToPresent(composeCampaign);
		click(composeCampaign, "compose campaign");
		return (ComposeCampaignPage) openPage(ComposeCampaignPage.class);
		// new GroupsPendingRequestsPage(driver);

	}
	
	public ImportContactsPage NavigatetoImportContactsPage() {

		click(ManageCampaign, "ManageCampaign");
		waitForElementToPresent(ImportContacts);
		click(ImportContacts, "Import Contacts");
		return (ImportContactsPage) openPage(ImportContactsPage.class);
		// new GroupsPendingRequestsPage(driver);

	}
	
	public StatisticsManageCampaign NavigatetoStatistics() {

		click(ManageCampaign, "ManageCampaign");
		waitForElementToPresent(statistics);
		click(statistics, "statistics");
		return (StatisticsManageCampaign) openPage(StatisticsManageCampaign.class);
		// new GroupsPendingRequestsPage(driver);

	}


	public ManageCommunityMembersPage navigateToManageCommunityMembers() throws Exception {

		click(Members, "Members");
		Thread.sleep(1000);
		click(ManageMembers, "Manage Members");
		return (ManageCommunityMembersPage) openPage(ManageCommunityMembersPage.class);
		// new ManageCommunityMembersPage(driver);
	}

	public CommunityInviteMembersPage navigateToinvitePeople() {
		click(manage, "manage");
		waitForElementToPresent(invitePeople);
		click(invitePeople, "invitePeople");
		return (CommunityInviteMembersPage) openPage(CommunityInviteMembersPage.class);
		// new CommunityInviteMembersPage(driver);

	}

	public CommunityPendingRequestsPage navigateToPendingRequests() {

		click(Members, "Members");
		waitForElementToPresent(CommunityPendingRequests);
		click(CommunityPendingRequests, "Community Pending Requests");
		return (CommunityPendingRequestsPage) openPage(CommunityPendingRequestsPage.class);
		// new CommunityPendingRequestsPage(driver);

	}

	public ManageJobsPage navigateToManageJobsPage() {
		scrollDownVertically();
		scrollToElement(Jobs);
		click(Jobs, "Jobs");
		waitForElementToPresent(ManageJobs);
		click(ManageJobs, "ManageJobs");
		return (ManageJobsPage) openPage(ManageJobsPage.class);
		// new ManageJobs(driver);
	}

	public ManageApplications navigateToManageApplicationsPage() {
		scrollDownVertically();
		scrollToElement(Jobs);
		click(Jobs, "Jobs");
		waitForElementToPresent(ManageApplications);
		click(ManageApplications, "ManageApplications");
		return (ManageApplications) openPage(ManageApplications.class);
		// new ManageApplications(driver);
	}

	public CommunityEventsPage navigateToEvents() {

		click(Events, "Events");
		return (CommunityEventsPage) openPage(CommunityEventsPage.class);
		// new CommunityEvents(driver);

	}

	// public CommunityPendingRequestsPage navigateToPendingInvitations(){
	// ClickOn.button("manage", manage);
	// waitForElement(Dashboard,100);
	// ClickOn.button("Pending Invitations", PendingInvitations);
	// return new CommunityPendingRequestsPage(driver);
	//
	// }

	public ManageGroupsPage navigateToManageGroupsPage() throws Exception {
		click(Groups, "Groups");
		Thread.sleep(1000);
		click(ManageGroups, "Manage Groups"); 
		return (ManageGroupsPage) openPage(ManageGroupsPage.class);
		// new ManageGroupsPage(driver);
	}

	public CommunityDetailsPage navigateToCommunityDetailsPage(String name) throws Exception {
		
		scrollUpVertically();
		
		WebElement ele = driver.findElement(By.xpath("//*[@class='nav_menu']//*[contains(text(),'"+name+"')]"));
		click(ele, "Community Name " +name);
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
		// new ManageGroupsPage(driver);
	}

	@FindBy(xpath = "//*[@class='communities-name']")
	WebElement CommunityName;

	public CommunityBlogsPage gotoManageBlogs() {

		click(blogs, "ManageBlogs");
		waitForElementToPresent(posts);
		click(posts, "ManagePosts");

		return (CommunityBlogsPage) openPage(CommunityBlogsPage.class);
	}

	public CategoriesPage gotoCategories() {
		click(blogs, "Categories");
		waitForElementToPresent(posts);
		click(categories, "Categories");

		return (CategoriesPage) openPage(CategoriesPage.class);
	}

	public TagsPage gotoTags() {
		click(blogs, "Tags");
		waitForElementToPresent(tags);
		click(tags, "Tags");

		return (TagsPage) openPage(TagsPage.class);

	}

	public void checkMembershipPlansNotAvailable() {
		
		try {
			if(MembershipPlans.isDisplayed()) {
				AssertionHelper.verifyFalse(true);
			}
			
		} catch (Exception e) {
			AssertionHelper.verifyTrue(true);;
		}
	}

	@FindBy(xpath="(//*[@src='/Content/Images/Surveys.png'])[1]")
	WebElement serveysMenu;
	
	@FindBy(xpath="(//*[@src='/Content/Images/Surveys.png'])[2]")
	WebElement serveys;
	
	public ServeysPage GoToServeysPage() {
		click(serveysMenu,"serveys Menu");
		waitForElementToPresent(serveys);
		click(serveys,"serveys");
		return (ServeysPage) openPage(ServeysPage.class);
	}
	
	@FindBy(xpath="//*[contains(text(),'Pricing Plan Details')]")
	WebElement pricingPlanDetails;
	
	public PricingPlanDetailsPage navigateToPricingPlansDetailsPage() {
		
		
		
		click(pricingPlanDetails,"pricingPlanDetails");
		
		
		return (PricingPlanDetailsPage) openPage(PricingPlanDetailsPage.class);
	}

}
