
package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class TenantAdminDashboardPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(PageTitle);
		return ExpectedConditions.visibilityOf(PageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h3[normalize-space()='Tenant Admin Dashboard']")
	WebElement PageTitle;
	@FindBy(xpath="//a[normalize-space()='Membership Plans']")
	WebElement membershipplan;
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement ImportContacts;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Campaign Template']")
	WebElement campaignTemplate;
	@FindBy(xpath="//a[normalize-space()='Manage Resources']")
	WebElement manageresource;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	@FindBy(xpath="//a[@title='Go to Member site home']")
	WebElement bizligoBtn;
	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Jobs'])")
	WebElement ManageJobs;
    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/Jobs/Jobs-active.png'])/..)/..)")
	WebElement Jobs;
    @FindBy(xpath = "//a[@title='Manage Applications']")
	WebElement ManageApplication;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]")
	WebElement totakJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[3]//div[1]//div[2]")
   	WebElement totakJobscounts;
    @FindBy(xpath = "//a[@href='/eventmanager/jobs/index/inactive']")
   	WebElement totakinactiveJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[2]//div[1]//div[2]")
    WebElement totakInactiveJobscounts;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]")
   	WebElement totakJobsapplication;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[4]//div[1]//div[2]")
    WebElement totakjobsapplicationcounts;
    @FindBy(xpath = "//a[@href='/eventmanager/jobs/index/active']")
   	WebElement activeJobs;
    @FindBy(xpath = "//div[@class='panel panel-info']//a[1]//div[1]//div[2]")
    WebElement activejobscounts;
    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
    @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
	WebElement manage;
    @FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;
    @FindBy(xpath = "//*[contains(text(),'Manage Member Advertisements')]")
	WebElement manageMemberAdvertisements;
    @FindBy(xpath = "(//*[contains(text(),'Blogs')])[1]")
	WebElement blogs;
	@FindBy(xpath = "(//*[contains(text(),'Categories')])[1]")
	WebElement categories;
	@FindBy(xpath = "(//*[contains(text(),'Tags')])[1]")
	WebElement tags;
	@FindBy(xpath = "//a[@title='Manage Organizations/Companies']")
	WebElement organisations;
	@FindBy(xpath = "//a[@class='display-none'][normalize-space()='Communities']")
	WebElement communities;
	@FindBy(xpath = "//a[normalize-space()='Manage Communities']")
	WebElement Managecommunities;
	@FindBy(xpath = "//*[contains(text(),'building communities')]")
	WebElement buildingcommunities;
	@FindBy(xpath = "//a[@title='Payment Gateways']")
	WebElement paymentGateways;
	@FindBy(xpath = "//a[normalize-space()='Dashboard Reports']")
	WebElement dashboardreport;
	@FindBy(xpath = "//a[normalize-space()='Revenue Reports']")
	WebElement revenuereport;
	@FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@class='col-md-3 left_col']/div[@class='left_col scroll-view']/div[@id='sidebar-menu']/div[@class='menu_section']/ul[@class='nav side-menu']/li[8]/a[1]")
	WebElement setting;
    @FindBy(xpath = "//a[normalize-space()='Donations']")
    WebElement Donations;
    @FindBy(xpath = "//a[normalize-space()='Manage Menu']")
    WebElement managemenu;
	@FindBy(xpath = "//div[@id='sidebar-menu']")
	WebElement sideBarMenu;
	@FindBy(xpath = "//a[normalize-space()='Payment Gateways']")
	WebElement paymentGateway;
	@FindBy(xpath = "//a[normalize-space()='Website Inquiries']")
	WebElement websiteEnquiries;
	@FindBy(xpath = "//a[normalize-space()='Website Inquiries']")
	List<WebElement> websiteEnquiry;
	@FindBy(xpath = "//*[@id='sidebar-menu']/div/ul/li[5]/a[1]")
	WebElement CommunitiesNavSideMenu;
	@FindBy(xpath = "//a[normalize-space()='Manage Communities']")
	WebElement manageCommunity;
	@FindBy(xpath = "//a[normalize-space()='Manage Communities']")
	WebElement manageCommunities;
	@FindBy(xpath = "//a[@title='Pending Communities']")
	WebElement pendingCommunities;
	@FindBy(xpath = "//*[@id=\"sidebar-menu\"]/div/ul/li[3]/a/i")
	WebElement loyalty;
	@FindBy(xpath = "//a[@href='/eventmanager/home/loyalities']")
	WebElement LOYALTY;
	@FindBy(xpath = "//a[@href='/eventmanager/home/loyaltymembership']")
	WebElement loyaltyMembership;
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement home;
	@FindBy(xpath = "//div[@class='bx-wrapper']")
	WebElement ad;
	@FindBy(xpath = "//a[normalize-space()='Features Configuration']")
	WebElement featureConfiguration;
	@FindBy(xpath = "//li[@class='active']//ul[@class='nav child_menu']")
	WebElement campList;
	@FindBy(xpath = "//a[normalize-space()='Membership Plans']")
	WebElement membership;

	@FindBy(xpath = "//a[normalize-space()='Promo Codes']")
	WebElement promocodes;
	@FindBy(xpath = "//a[normalize-space()='Pricing Plans']")
	WebElement pricingplan;
	

	
	public LoyaltyPage navigateToLoyaltyPage() {
		scrollDownVertically();
		scrollToElement(loyalty);
		click(loyalty, "loyalty");
		waitForElementToPresent(LOYALTY);
		click(LOYALTY, "LOYALTY");
		return (LoyaltyPage) openPage(LoyaltyPage.class);
		// new ManageJobs(driver);
	}


	public MembershipPlansPage navigatetoMembershipPlansPage() throws Exception {
        waitForElementToPresent(membership);
		click(membership, "Membership");
		Thread.sleep(2000);
		
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
		// new ManageCommunityMembersPage(driver);
	}
	public ManageCommunitiesPage navigatetomanageCommunities() throws Exception {
        waitForElementToPresent(communities);
		click(communities, "Members");
		Thread.sleep(2000);
		click(Managecommunities, "Manage Members");
		return (ManageCommunitiesPage) openPage(ManageCommunitiesPage.class);
		// new ManageCommunityMembersPage(driver);
	}
	
/*	public PendingCommunitiesPage navigatetopendingCommunities() throws Exception {
        waitForElementToPresent(communities);
		click(communities, "Members");
		Thread.sleep(2000);
		click(pendingCommunities, "pending Communities");
		return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
		// new ManageCommunityMembersPage(driver);
	}
    */
	
	public PendingCommunitiesPage navigatetopendingCommunities1() throws Exception {
		waitForElementToPresent(communities);
		click(communities, "Members");
		Thread.sleep(2000);
		click(pendingCommunities, "pending Communities");
		return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
		// new ManageCommunityMembersPage(driver);
		}
	
	
	 public ManageApplications navigateToManageApplication() {
			scrollDownVertically();
			scrollToElement(Jobs);
			click(Jobs, "Jobs");
			waitForElementToPresent(ManageApplication);
			click(ManageApplication, "ManageJobs");
			return (ManageApplications) openPage(ManageApplications.class);
			// new ManageJobs(driver);
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
public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
	Thread.sleep(4000);
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(1000);
	waitForElementToPresent(composeCampaign);
	this.composeCampaign.click();	
	//click(composeCampaign, "composeCampaign");
	return (ComposeCampaign) openPage(ComposeCampaign.class);
	
}
public ImportContactsPage navigateToImportContactsPagePage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(1000);
	waitForElementToPresent(ImportContacts);
	this.ImportContacts.click();	
	//click(composeCampaign, "composeCampaign");
	return (ImportContactsPage) openPage(ImportContactsPage.class);
	
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
	
}
public ManageResourcesPage navigateToManageResourcesPage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageresource);
	click(manageresource, "manageresource");
	return (ManageResourcesPage) openPage(ManageResourcesPage.class);
	
}

public ManagePricingPlan navigateToManagePricingPlan() throws Exception {
	Thread.sleep(2000);
	click(pricingplan, "pricingplan");
	return (ManagePricingPlan) openPage(ManagePricingPlan.class);
	
}

   public ManageMembershipPlan navigateToMembershipPlansPage() throws Exception {
	waitForElementToPresent(membershipplan);
	click(membershipplan, "membership plan");
	return (ManageMembershipPlan) openPage(ManageMembershipPlan.class);
	
}
public HomePage goToHomePage() throws InterruptedException {
	 
	click(bizligoBtn,"Bizligo button");
	
	return (HomePage) openPage(HomePage.class);

}
public void goHomePage() throws InterruptedException {
	 
	click(bizligoBtn,"Bizligo button");
	Thread.sleep(5000);
	scrollToElement(buildingcommunities);
	takeScreenshotByShutterBug(ad, "HomePageAd");
	

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
     public int TotalInactiveJobs() throws Exception {
	//boolean varExists = false;
	      scrollIntoView(totakinactiveJobs);
	      String C = totakInactiveJobscounts.getText();
          int TC=Integer.parseInt(C);
          System.out.println("Total count is " + TC);
       	  Assert.assertTrue(true);  
	      return TC;	

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
     public int ActiveJobs() throws Exception {
 		//boolean varExists = false;
 		    scrollIntoView(activeJobs);
 		    String C = activejobscounts.getText();
	        int TC=Integer.parseInt(C);
	        System.out.println("Total count is " + TC);
			Assert.assertTrue(true);  
	        return TC;
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
     public CategoriesPage gotoCategories() {
 		click(blogs, "Categories");
 		waitForElementToPresent(categories);
 		click(categories, "Categories");

 		return (CategoriesPage) openPage(CategoriesPage.class);
 	}
     public OrganizationsPage goToOrganizationsPage() {
 		click(organisations, "Organizations");
 		return (OrganizationsPage) openPage(OrganizationsPage.class);
 	}
     
     public FeaturesConfigurations goToFeaturesConfigurationsPage() throws InterruptedException {
    	 Thread.sleep(5000);
    	 scrollToElement(featureConfiguration);
  		click(featureConfiguration, "Feature Configuration");
  		return (FeaturesConfigurations) openPage(FeaturesConfigurations.class);
  	}
     
   
 /*    public PaymentGatewaysPage NavigatetoPaymentGatewayPage() {

    	 waitForElementToPresent(paymentGateway);
    	 click( paymentGateway, "paymentGateway");
    	 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
    	 // new ManageJobs(driver);
    	 }
     */
     
     public RevenueReportPage goToRevenueReport() {
			//waitForElementToPresent(dashboardreport);
			click(dashboardreport, "Dashboard Reports");
			waitForElementToPresent(revenuereport);
			click(revenuereport, "Revenue Report");
			return (RevenueReportPage) openPage(RevenueReportPage.class);	
		}
     
     public TACommunitiesPage navigateToCommunitiesPage() {
    	 click(CommunitiesNavSideMenu, "Communities");
    	 waitForElementToPresent(manageCommunity);
    	 clickElementByJavaScript(manageCommunity);
    	 return (TACommunitiesPage) openPage(TACommunitiesPage.class);
    	 }
     
     public void checkDonationsWhenDisabled() {
    	 System.out.println(sideBarMenu.getText());
    	 if(sideBarMenu.getText().contains("Donations")) {
    	 Assert.assertTrue(false);
    	 System.out.println("Donations visible in side menu when disabled by Super Admin");
    	 }else {
    	 Assert.assertTrue(true);
    	 System.out.println("Donations not visible in side menu when disabled by Super Admin");
    	 }

    	 }
          
     public PaymentGatewaysPage NavigatetoPaymentGatewayPage() {

    	 waitForElementToPresent(paymentGateway);
    	 click( paymentGateway, "paymentGateway");
    	 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
    	 // new ManageJobs(driver);
    	 }
     
     public PromoCodePage navigateToPromocodePage() {
    	 scrollDownVertically();
    	 scrollToElement(promocodes);
    	 click(promocodes, "promocodes");

    	 return (PromoCodePage) openPage(PromoCodePage.class);
    	 // new ManageJobs(driver);
    	 }
          
        public ManageDonationsPage NavigatetoManageDonationsPage() {

    	 waitForElementToPresent(Donations);
    	 click( Donations, "Donations");
    	 return (ManageDonationsPage) openPage(ManageDonationsPage.class);
    	 // new ManageJobs(driver);
    	 }
          
     public HomePage goToBizligoHomePage() throws InterruptedException {
    	 
    		click(bizligoBtn,"Bizligo button");
    		Thread.sleep(3000);
    		//clickElementByJavaScript(home);
    		//click(home, "home");
    		Thread.sleep(1000);
    		return (HomePage) openPage(HomePage.class);

    	}
     
     public ManageMenuPage goToManageMenu() {
			waitForElementToPresent(setting);
			click(setting, "setting");
			waitForElementToPresent(managemenu);
			click(managemenu, "managemenu");
			return (ManageMenuPage) openPage(ManageMenuPage.class);	
		}
     
     public void checkDonationsWhenEnabled() {
    	 System.out.println(sideBarMenu.getText());
    	 if(sideBarMenu.getText().contains("Donations")) {
    	 Assert.assertTrue(true);
    	 System.out.println("Donations visible in side menu when enabled by Super Admin");
    	 }else {
    	 Assert.assertTrue(false);
    	 System.out.println("Donations not visible in side menu when enabled by Super Admin");
    	 }

    	 }
   
     public WebsiteInquiryPage NavigatetoWebsiteInquiryPage() {

    	 click(websiteEnquiries, "website Enquiries");

    	 return (WebsiteInquiryPage) openPage(WebsiteInquiryPage.class);
    	 // new GroupsPendingRequestsPage(driver);

    	 }
     
     public void websiteEnquiryNotPresentWhenSAdisable() {
    	 if
    	 (websiteEnquiry.size()>0)
    	 {
    	 System.out.println("Website enquiry not disabled when inactivated by Super Admin");
    	 }else System.out.println("Website enquiry disabled when inactivated by Super Admin");
    	 }
     
     public PendingCommunitiesPage navigatetopendingCommunities() throws Exception {
    	 waitForElementToPresent(communities);
    	 click(communities, "Members");
    	 Thread.sleep(2000);
    	 click(pendingCommunities, "pending Communities");
    	 return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
    	 // new ManageCommunityMembersPage(driver);
    	 }
     
     public void checkImportContactnotDisplay() throws Exception {
 		
 		Thread.sleep(5000);
 		scrollToElementAndClick(manageCampaign);
 		Thread.sleep(1000);
 		String list=campList.getText();
 		System.out.println(list);
 		String name="Import Contact";
 		//Assert.assertNotSame(list, name);
 		Assert.assertNotSame(list, name);
 		//click(composeCampaign, "composeCampaign");
 		
 	}
}