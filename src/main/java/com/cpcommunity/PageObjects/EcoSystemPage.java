package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.cpcommunity.utilities.DriverManager;

public class EcoSystemPage extends BasePage {

	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement myEcosystem;

	@FindBy(xpath = "//*[@class='dropdown-menu']//*[contains(text(),'My Ecosystem')] | //*[@class='dropdown-menu gretdrpmenu']//*[contains(text(),'My Ecosystem')]")
	WebElement myEcosystemInMenu;
	
	@FindBy(xpath = "//a[contains(.,'Dashboard')]")
	WebElement DashBoard;
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@FindBy(xpath = "(//*[contains(text(),'Global Communities')])[2]")
	WebElement globalCommunities;

	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;

	@FindBy(xpath = "//*[@id='mycommunitestab']//a[contains(text(),'VIEW ALL')]")
	WebElement viewAll;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement Logout;

	@FindBy(xpath = "//*[contains(text(),'Blog')]")
	WebElement blog;

	@FindBy(xpath = "//*[contains(text(),'My Advertisements')]")
	WebElement myAdvertisements;
	// *************************************Endorsements**********************************
	@FindBy(xpath = "//*[contains(text(),'My Endorsements')]")
	WebElement myEndorsements;

	// *************************************Groups****************************************
	@FindBy(xpath = "//*[contains(text(),'My Groups')]")
	WebElement myGroups;
	@FindBy(xpath = "//*[contains(text(),'My Jobs')]")
	WebElement myJobs;
	@FindBy (xpath="//*[contains(text(),'My Connections')]")
	WebElement myConnections;
	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Applications'])")
	WebElement ManageApplications;
	
	@FindBy (xpath = "//*[contains(text(),'My Messages')]")
	WebElement myMessages;
	
	@FindBy(xpath="//a[contains(text(),'Member Directory')] | //a[contains(text(),'Global Members')]")
	WebElement memberDirectory;
	
	
	//*[@class='fa fa-arrow-left'] | //*[@class='fa fa-tv']
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement myProfile;
	
	@FindBy(xpath="//a[contains(text(),'Manage Password')]")
	WebElement ManagePassword;

	@FindBy(xpath="//span[contains(text(),'Global Events')]")
	WebElement globalEvents;
	@FindBy(xpath = "//*[contains(text(),'MANAGE')]")
	WebElement MANAGEbtn;
	
	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]")
	WebElement upcomingEvents;
	@FindBy(xpath="//a[contains(text(),'Past Events')]")
	WebElement PastEvents;
	
	@FindBy(xpath="//a[contains(text(),'Careers')]")
	WebElement GlobalCareers;
	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/Jobs/Jobs-active.png'])/..)/..)")
	WebElement Jobs;
	@FindBy(xpath = "//*[contains(text(),'No matches right')]")
    WebElement textMessage;
	@FindBy(xpath = "//div[@class='pull-right text-right endorse-color']")
	WebElement TotalendorsCount;      
	
	@FindBy(xpath = "//*[contains(text(),'My Matches')]")
	WebElement myMatches;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement Home;
	
	
	
	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(Home);
	}

	public HomePage logout() throws Exception {
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(500);
		waitForElementToPresent(Logout);
		click(Logout,"Logout");
		return (HomePage) openPage(HomePage.class);
		// new HomePage(driver, );
	}
	public MyDashboardPage gotoMyDashboardPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(500);
		waitForElementToPresent(DashBoard);
		click(DashBoard,"DashBoard");
		return (MyDashboardPage) openPage(MyDashboardPage.class);
	}	
	
	public void Totalendorsments() throws Exception {
		//boolean varExists = false;
		scrollToElement(TotalendorsCount);
		waitForElementToPresent(this.TotalendorsCount);
		 String C = TotalendorsCount.getText();
	      int TC=Integer.parseInt(C);
			System.out.println("Total count is " + TC);
	}

	public GlobalCommunitesPage goToGlobalCommunities() throws Exception {
		// click(Toggledropdownmenu,"Toggledropdownmenu");
		waitForElementToPresent(globalCommunities);
		clickElementByJavaScript(globalCommunities);
		// Thread.sleep(1000);
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// new GlobalCommunitesPage(driver, );

	}
	public CommunityDashboardPage gotoManageCommunity(String communityName) throws Exception {

		//this.searchCommunity(communityName+getDateInDDMMMYYYY());
		//this.searchCommunity(communityName);
		click(MANAGEbtn, "Manage");
		Thread.sleep(5000);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		// new CommunityDashboardPage(driver, );
	}
	public CommunityDashboardPage navigateToManageCommunityPage() throws Exception {

		click(MANAGEbtn, "Manage");
		Thread.sleep(5000);
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		
	}

	public MyJobsPage navigateToMyJobsPage() throws InterruptedException {
		scrollIntoView(myJobs);
		myJobs.click();		
		Thread.sleep(3000);
		return (MyJobsPage) openPage(MyJobsPage.class);
	}
	public MyEcosystemPage gotoMyEcosystemPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(1000);
		waitForElementToPresent(myEcosystem);
		click(myEcosystem,"myEcosystem");
		return (MyEcosystemPage) openPage(MyEcosystemPage.class);
	}	
	public void myMatches(String actual) throws Throwable
		
	        {
		
	                Thread.sleep(5000);
		
	                click(myMatches,"MyMatches");
		
	                Thread.sleep(8000);
		
	                String expected = textMessage.getText();
		
	                Assert.assertEquals(expected, actual);
		
	                
		
	        }
	
	
	public MyCommunitiesPage goToMyCommunities() throws Exception {
		
		try {
			waitForElementToPresent(viewAll);
			click(viewAll, "view All");	
		} catch (Exception e) {
			
			driver.navigate().refresh();
			Thread.sleep(10000);
			waitForElementToPresent(viewAll);
			click(viewAll, "view All");
			
		}
		
		
		
		
		return (MyCommunitiesPage) openPage(MyCommunitiesPage.class);
	}

	public EcoSystemPage goToMyEcosystem() {
		click(Toggledropdownmenu, "Toggledropdownmenu");
		waitForElementToPresent(myEcosystemInMenu);
		click(myEcosystemInMenu, "My Ecosystem In Menu Drop Down");
		return (EcoSystemPage) openPage(EcoSystemPage.class);
	}

	public GlobalCareers goToGlobalCareers() {
		click(GlobalCareers, "click");
		return (GlobalCareers) openPage(GlobalCareers.class);
		// new GlobalCareers(driver, );
	}

	public Messages goToMyMessages() {
		click(myMessages,"myMessages");
		return (Messages) openPage(Messages.class);
		// new Messages(driver, );
	}

	public MyGroupsPage goToMyGroups() {
		click(myGroups, "myGroups");
		return (MyGroupsPage) openPage(MyGroupsPage.class);
		// new MyGroupsPage(driver, );
	}

	// public int GoToMygroups(ExtentTest logger) throws Exception
	// {
	//
	// }

	public GlobalCommunitesPage goToGlobalCommunitiesFromMenuDropDown() throws Exception {

		click(Toggledropdownmenu, "Toggle drop down menu");
		Thread.sleep(1000);
		click(globalCommunities, "Global Communities");
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// new ChangePasswordPage(driver, );

	}

	public ChangePasswordPage goToManagePassword() throws Exception {

		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(1000);
		click(ManagePassword,"ManagePassword");
		return (ChangePasswordPage) openPage(ChangePasswordPage.class);
		// new ChangePasswordPage(driver, );

	}

	// public int GoToMyCommunities(ExtentTest logger) throws InterruptedException {
	//
	//
	//
	//
	// js.executeScript("arguments[0].scrollIntoView(true);",Communities);
	// String C = TotalCommmunities.getText();
	// int TC=Integer.parseInt(C);
	// Utility.highLightElement(driver, Communities);
	// Communities.click();
	// return TC;
	// }
	//

	public MyProfilePage goToMyProfilePage() throws Exception {

		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(1000);
		click(myProfile,"myProfile");
		return (MyProfilePage) openPage(MyProfilePage.class);
		// new MyProfilePage(driver, );

	}

	public GlobalMembersPage goToMembersPage() {

		click(memberDirectory,"memberDirectory");
		return (GlobalMembersPage) openPage(GlobalMembersPage.class);
		// new GlobalMembersPage(driver, );
	}

	public ConnectionsPage goToMyConnections() {
		click(myConnections,"myConnections");
		return (ConnectionsPage) openPage(ConnectionsPage.class);
		// new ConnectionsPage(driver, );
	}

	public void eventsMenu() {
		moveToElement(globalEvents);
		// click(globalEvents,"Global Events");
	}

	public UpcomingEventsPage goToUpComingEvents() {

		this.eventsMenu();
		waitForElementToPresent(upcomingEvents);
		click(upcomingEvents, "Upcoming Events");
		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
		// new UpcomingEventsPage(driver, );
	}

	// public PastEventsPage ClickOnPastEvents()
	// {
	// this.ClickOnGlobalEvents();
	// waitHelper.waitForElement(PastEvents,100);
	//
	// PastEvents.click();
	// return () openPage(.class);
	// new PastEventsPage(driver, );
	// }

	// public EndorsementPage NaviagtingToMyEndorsements()
	// {
	//
	// myEndorsements.click();
	// return (EndorsementPage) openPage(EndorsementPage.class);
	//// new EndorsementPage(driver, );
	// }

	public MyAdvertisements goToMyAdvertisements() {
		scrollToElement(myAdvertisements);
		click(myAdvertisements, "My Advertisements");
		return (MyAdvertisements) openPage(MyAdvertisements.class);
		// new MyProfilePage(driver, );
	}

	@FindBy(xpath = "//*[contains(text(),'Posts')]")
	WebElement posts;

	public BlogsPage goToBlogsPage() {
		click(blog, "blog");

		return (BlogsPage) openPage(BlogsPage.class);

	}
	public ManageApplications navigateToManageApplicationsPage() {
		scrollDownVertically();
		scrollToElement(Jobs);
		click(Jobs, "Jobs");
		waitForElementToPresent(ManageApplications);
		click(ManageApplications, "ManageApplications");
		//click(ManageApplications, "ManageApplications");
		return (ManageApplications) openPage(ManageApplications.class);
		// new ManageApplications(driver);
	}

//	public MyProfilePage NaviagtingToMyProfilePage1() {
//
//		myEndorsements.click();
//		return (MyProfilePage) openPage(MyProfilePage.class);
//		// new MyProfilePage(driver, );
//	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	public EndorsementPage NaviagtingToMyEndorsements()
	 {
	
	 myEndorsements.click();
	 return (EndorsementPage) openPage(EndorsementPage.class);
	 }
}
