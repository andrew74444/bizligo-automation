package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;



public class CommunityDashboardPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		updateClass(pageheader, "");
		aShot();

	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(Dashboard);
		return ExpectedConditions.visibilityOf(Dashboard);
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	
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
    
	@FindBy(xpath = "//a[normalize-space()='Manage Community Widgets']")
	WebElement manageCommunitywidget;
	
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
	
	@FindBy(xpath = "//h4[normalize-space()='Total Groups']")
	WebElement TotalGroup;
	
	@FindBy(css = "a[ng-click=\"data.RedirectToPageBasedOnRole('groups', '')\"] h3")
	WebElement TotalGroupCount;
	
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	
	@FindBy(xpath="//a[normalize-space()='Campaign Report']")
	WebElement CampaignReport;
	
	@FindBy(xpath="//a[normalize-space()='Campaign Template']")
	WebElement campaignTemplate;
	
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement importcampaign;
	//a[normalize-space()='Statistics']
	@FindBy(xpath="//a[normalize-space()='Manage Resources']")
	WebElement manageresource;
	
	@FindBy(xpath = "//a[normalize-space()='Draft Campaign']")
	WebElement DraftCampaign;

	@FindBy(xpath="//a[normalize-space()='Statistics']")
	WebElement Staticcampaign;
	@FindBy(xpath = "//div[@class='panel panel-info']//a[3]")
	WebElement totakJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]//div[1]//div[2]")
	WebElement totakJobscounts;
    @FindBy(xpath = "//a[@ng-click=\"data.RedirectToPageBasedOnRole('jobs', 'inactive')\"]")
	WebElement totakinactiveJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[2]//div[1]//div[2]")
    WebElement totakInactiveJobscounts;
    @FindBy(xpath = "//a[@ng-click=\"data.RedirectToPageBasedOnRole('promotions', 'rejected')\"]")
   	WebElement rejectedAds;
    @FindBy(xpath = "//div[@class='panel panel-warning g-statistics']//a[2]//div[1]//div[2]")
    WebElement rejectedAdConts;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]")
	WebElement totakJobsapplication;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]//div[1]//div[2]")
    WebElement totakjobsapplicationcounts;
    @FindBy(xpath = "//a[normalize-space()='Email Templates']")
    WebElement emailtemplate;
    @FindBy(xpath = " //a[normalize-space()='Pricing Plan Details']")
    WebElement pricingplan;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]//div[1]//div[2]")
	WebElement totalJobsCount;
   // @FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@class='col-md-3 left_col']/div[@class='left_col scroll-view']/div[@id='sidebar-menu']/div[@class='menu_section']/ul[@class='nav side-menu']/li[3]/a[1]")
  //	WebElement manage;
    @FindBy(xpath = " //a[normalize-space()='Edit']")
   	WebElement edit; 
    @FindBy(xpath="//a[contains(text(),'Global Communities')]")
	WebElement globalCommunities;
    @FindBy(xpath = "//a[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;
	@FindBy(xpath = "//a[normalize-space()='Revenue Reports']")
	WebElement revenuereport;
	@FindBy(xpath = "//a[@title='Manage Community']")
	WebElement managecommunity;
	@FindBy(xpath = "//div[@class='panel panel-warning g-statistics']//div[@class='panel-body']")
	WebElement adstatics;
	@FindBy(xpath = "//a[normalize-space()='Blogs']")
	WebElement Blogs;
	@FindBy(xpath = "//ul[@class='nav child_menu']//a[@title='Manage Categories'][normalize-space()='Categories']")
	WebElement Blogcategories;
    
  
	public void displayManageGroupsPage() throws Exception {
		boolean varExists = false;
		click(Groups, "Groups");
		Thread.sleep(1000);
		waitForElementToPresent(ManageGroups);		
		if(ManageGroups.isDisplayed()) {
			varExists = true;
			System.out.println("ManageGroup is Displayed");
		}
		Assert.assertEquals(varExists, true);
	}
	
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

	public ManageCommunityPage goToManagecommunityPage() {

		this.clickOnAdvertisments();
		waitForElementToPresent(manage);
		click(manage, "Manage");
		waitForElementToPresent(edit);
		click(edit, "Edit");
		return (ManageCommunityPage) openPage(ManageCommunityPage.class);
		// new CommunityPendingRequestsPage(driver);
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
	public ManageCommunityWidgets navigateTomanageWidget() {
		click(manage, "manage");
		waitForElementToPresent(manageCommunitywidget);
		click(manageCommunitywidget, "manage Community widget");
		return (ManageCommunityWidgets) openPage(ManageCommunityWidgets.class);
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
	
	//public EmailTemplatePage navigateToEmailTemplate() {

		//click(emailtemplate, "Email Template");
		//return (EmailTemplatePage) openPage(EmailTemplatePage.class);
		// new CommunityEvents(driver);
	//}

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
	public GlobalCommunitesPage naviagtingToGlobalCommunities() throws Exception
	{
		
		clickElementByJavaScript(globalCommunities);
		Thread.sleep(1000);
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//		new GlobalCommunitesPage(driver, );
		
	}

	public CategoriesPage gotoCategories() throws InterruptedException {
		Thread.sleep(1000);
		click(blogs, "Categories");
		waitForElementToPresent(categories);
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
	public void TotalGroups() throws Exception {
		//boolean varExists = false;
		scrollIntoView(TotalGroup);
		Thread.sleep(1000);
		
		//waitForElementToPresent(this.TotalGroup);
		if(this.TotalGroup.isDisplayed()) {
			
			System.out.println("Total count is " + TotalGroupCount.getText());
			Assert.assertTrue(true);
		}
	}
	public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(composeCampaign);
		this.composeCampaign.click();	
		//click(composeCampaign, "composeCampaign");
		return (ComposeCampaign) openPage(ComposeCampaign.class);
		
	}
	public CampaignTemplatePage navigateToCampaignTemplate() throws Exception {
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(campaignTemplate);
		this.campaignTemplate.click();	
		//click(composeCampaign, "composeCampaign");
		return (CampaignTemplatePage) openPage(CampaignTemplatePage.class);
		
	}public StatisticsManageCampaign NavigatetoStatistics() throws Exception {
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(Staticcampaign);
		this.Staticcampaign.click();	
		//click(composeCampaign, "composeCampaign");
		return (StatisticsManageCampaign) openPage(StatisticsManageCampaign.class);
	}
		
	public CampaignReportPage navigateToCampaignReportPage() throws Exception {
		
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(CampaignReport);
		this.CampaignReport.click();	
		//click(composeCampaign, "composeCampaign");
		return (CampaignReportPage) openPage(CampaignReportPage.class);
		
	}
	public DraftCampaignPage navigateToDraftCampaignPage() throws Exception {
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(DraftCampaign);
		this.DraftCampaign.click();	
		//click(composeCampaign, "composeCampaign");
		return (DraftCampaignPage) openPage(DraftCampaignPage.class);
		
	}
	public ImportContactsPage navigateToImportContactsPage() throws Exception {
		Thread.sleep(3000);
		scrollDownVertically();
		scrollToElement(manageCampaign);
		click(manageCampaign, "manageCampaign");
		Thread.sleep(1000);
		waitForElementToPresent(importcampaign);
		this.importcampaign.click();	
		//click(composeCampaign, "composeCampaign");
		return (ImportContactsPage) openPage(ImportContactsPage.class);
		
	}
	public ManageResourcesPage navigateToManageResourcesPage() throws Exception {
		scrollDownVertically();
		scrollToElement(manageresource);
		click(manageresource, "manageresource");
		return (ManageResourcesPage) openPage(ManageResourcesPage.class);
		
	}
	public PricingPlanDetailsPage navigateToPricingPlanDetailsPage() throws Exception {
		
		click(pricingplan, "Pricing Plan");
		return (PricingPlanDetailsPage) openPage(PricingPlanDetailsPage.class);
		
	}
	public int TotalJobs() throws Exception {
		//boolean varExists = false;
		scrollIntoView(totakJobs);
		String C = totakJobscounts.getText();
        int TC=Integer.parseInt(C);
        System.out.println("Total count is " + TC);
     	Assert.assertTrue(true);  
	      return TC;	
			
	}
	public void pendingAdNotDisplaying() throws Exception {
		waitForElementToPresent(adstatics);
		String AllAds=adstatics.getText();
		String notPresent="Pending Ads";
		System.out.println("AllAds");
		Assert.assertNotSame(AllAds, notPresent);
			
	}
	 public void totalJobsCount() {
			
		   String C = totalJobsCount.getText();
	      int TC=Integer.parseInt(C);
	      System.out.println(TC);
	      System.out.println("CA can check total number of jobs on Statistics of Jobs on Dashboard");
	}
	 public int TotalJobsApplications() throws Exception {
 		//boolean varExists = false;
 		scrollIntoView(totakJobsapplication);
 		String C = totakjobsapplicationcounts.getText();
        int TC=Integer.parseInt(C);
        System.out.println("Total count is " + TC);
     	Assert.assertTrue(true);  
	      return TC;	
 			
 
 	}
	 public int TotalInactiveJobs() throws Exception {
			//boolean varExists = false;
			scrollIntoView(totakinactiveJobs);
			String C = totakInactiveJobscounts.getText();
	        int TC=Integer.parseInt(C);
	        System.out.println("Total count is " + TC);
	     	Assert.assertTrue(true);  
		      return TC;
			
		}
	 public int RejectedAdcounts() {
		 scrollIntoView(rejectedAds);
			String C = rejectedAdConts.getText();
	        int TC=Integer.parseInt(C);
	        System.out.println("Total count is " + TC);
	     	Assert.assertTrue(true); 
		 return TC;
	 }
	 
	 public RevenueReportPage navigateToRevenueReport() {
			waitForElementToPresent(advertisement);
			click(advertisement, "Advertisement");
			waitForElementToPresent(managecommunity);
			scrollUpVertically();
			click(managecommunity, "Manage button");
			waitForElementToPresent(dashboardreport);
			click(dashboardreport, "Dashboard Reports");
			waitForElementToPresent(revenuereport);
			click(revenuereport, "Revenue Report");
			return (RevenueReportPage) openPage(RevenueReportPage.class);	
		}
	 
	 public RevenueReportPage goToRevenueReport() {
			//waitForElementToPresent(dashboardreport);
			click(dashboardreport, "Dashboard Reports");
			waitForElementToPresent(revenuereport);
			click(revenuereport, "Revenue Report");
			return (RevenueReportPage) openPage(RevenueReportPage.class);	
		}
	 
	 public EmailTemplatePage navigateToEmailTemplate() {

			click(emailtemplate, "Email Template");
			return (EmailTemplatePage) openPage(EmailTemplatePage.class);
			// new CommunityEvents(driver);
		}
}

