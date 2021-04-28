package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

public class SystemAdminDashboardPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement SystemAdminDashboardHeader;

	//@FindBy(xpath = "(//*[@class='fa fa-chevron-down'])[2]")
	//WebElement CommunitiesNavSideMenu;
	
	@FindBy(xpath = "//*[@id='sidebar-menu']/div/ul/li[5]/a[1]")
	WebElement CommunitiesNavSideMenu;

	@FindBy(xpath = "//a[@title='Pending Communities']")
	WebElement pendingCommunities;

	@FindBy(xpath = "//a[contains(text(),'Pricing Plans')]")
	WebElement PricingPlans;

	@FindBy(xpath = "//*[@id='sidebar-menu']/div/ul/li[5]/a[1]")
	WebElement communities;

	@FindBy(xpath = "//a[normalize-space()='Manage Communities']")
	WebElement manageCommunity;

	@FindBy(xpath = "//*[@class='fa fa-angle-down']")
	WebElement angleDown;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement logout;

	@FindBy(xpath="//*[@title='Manage Organizations/Companies']")
	WebElement Organizations;
	@FindBy(xpath="//*[@title='Membership Plans']/i")
	WebElement 	membershipPlans;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(SystemAdminDashboardHeader);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	
	
	
	
	
	public PendingCommunitiesPage naviagteToPendingCommunities() {
		clickElementByJavaScript(CommunitiesNavSideMenu);
		// click(CommunitiesNavSideMenu,"Communities");
		waitForElementToPresent(pendingCommunities);
		clickElementByJavaScript(pendingCommunities);
		// click(pendingCommunities,"pendingCommunities");

		return (PendingCommunitiesPage) openPage(PendingCommunitiesPage.class);
		// new PendingCommunitiesPage(driver, );

	}

	public PlansPage NavigateManagePricingPlans() {
		click(PricingPlans, "PricingPlans");
		return (PlansPage) openPage(PlansPage.class);
		// new PricingPlans(driver, );

	}

	public HomePage logout() {
		click(angleDown, "System Admin Menu Drop down");
		waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}

	public TACommunitiesPage navigateToCommunitiesPage() {
		click(CommunitiesNavSideMenu, "Communities");
		waitForElementToPresent(manageCommunity);
		clickElementByJavaScript(manageCommunity);
		return (TACommunitiesPage) openPage(TACommunitiesPage.class);
	}

	public OrganizationsPage goToOrganizationsPage() {
		click(Organizations, "Organizations");
		return (OrganizationsPage) openPage(OrganizationsPage.class);
	}

	public TenantAdminMemberShipPlansPage goToMembershipPlansPage() {
		scrollToElement(membershipPlans);
		click(membershipPlans, "Membership Plans");
		return (TenantAdminMemberShipPlansPage) openPage(TenantAdminMemberShipPlansPage.class);
	}
	
	
	public SATestimonials navigatetoTestimonials() throws Exception
	
	        {
		
	                click(testimonials,"Testimonials");
	
	                waitForElementToPresent(websiteTestimonial);
		
	                Thread.sleep(5000);
	
	                return (SATestimonials) openPage(SATestimonials.class);
		
	        }
	
	@FindBy(xpath = "//h2[contains(text(),'Websit')]")
	WebElement websiteTestimonial;
	
	@FindBy(xpath="//a[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	@FindBy(xpath = "//a[contains(text(),'Blogs')]//span")
	WebElement blogs;
	
	@FindBy(xpath = "//div[@id='sidebar-menu']//div//a[contains(text(),'Posts')]")
	WebElement posts;
	
	@FindBy(xpath = "(//*[contains(text(),'Catego')])[1]")
	WebElement categorie;
	
		
	        public BlogsBySystemAdmin navigateToSystemAdminBlogs() throws Exception
		
	        {
	
	                click(blogs,"Blogs");
	
	                Thread.sleep(5000);
		
	                click(posts,"posts");
		
	                Thread.sleep(5000);
	
	                return (BlogsBySystemAdmin) openPage(BlogsBySystemAdmin.class);
		
	        }
	
	        
	
	        
	
	        public BlogsBySystemAdmin navigateToSystemAdminBlogs1() throws Exception
	
	        {
		
	                click(blogs,"Blogs");
	
	                Thread.sleep(5000);
		
	                click(categorie,"Categorie");
		
	                Thread.sleep(2000);
		
	                return (BlogsBySystemAdmin) openPage(BlogsBySystemAdmin.class);
		
	        }
}
