package com.cpcommunity.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;
import com.cpcommunity.utilities.DriverManager;

public class EcoSystemPage extends BasePage {

	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement myEcosystem;

	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement myEcosystemInMenu;
	
	@FindBy(xpath = "//a[contains(.,'Dashboard')]")
	WebElement DashBoard;
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

//	@FindBy(xpath = "(//a[normalize-space()='Global Communities'])[2]")
	@FindBy(xpath = "//*[@class='nav navbar-nav navbar-right']/*/*[text()='Global Communities']")//added 0n 22/03
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
	@FindBy (xpath="//*[contains(text(),'Requests')]")
	WebElement requests;
	@FindBy(xpath = "(//*[@class='col-md-3 left_col']//*[@title='Manage Applications'])")
	WebElement ManageApplications;
	
	@FindBy (xpath = "//*[contains(text(),'My Messages')]")
	WebElement myMessages;
	
	@FindBy (xpath = "//*[@class='dropdown']/*[@class='dropdown-toggle']/*[text()='Directory ']")//added on 21/03
	WebElement directory; 
	//@FindBy(xpath="//a[contains(text(),'Member Directory')] | //a[contains(text(),'Global Members')]")//commented on 21/03
	@FindBy(xpath="//*[@class='dropdown-menu']/*/*[text()='Member Directory']")//added on 21/03
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
	
//	@FindBy(xpath="//a[contains(text(),'Careers')]")
	@FindBy(xpath="//*[@class='nav navbar-nav navbar-right']/*/*[text()='Careers']")//added on 05/04
	WebElement GlobalCareers;
	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/Jobs/Jobs-active.png'])/..)/..)")
	WebElement Jobs;
	@FindBy(xpath = "//*[contains(text(),'No matches right')]")
    WebElement textMessage;
	@FindBy(xpath = "//div[@class='pull-right text-right endorse-color']")
	WebElement TotalendorsCount;      
	
	@FindBy(xpath = "//*[contains(text(),'My Matches')]")
	WebElement myMatches;
	//@FindBy(xpath = "//a[contains(text(),'Home')]")
	//WebElement Home;
	@FindBy(xpath = "//h2[normalize-space()='MY ECOSYSTEM']")
	WebElement Home;
	@FindBy(xpath="//a[@class=\"btn btn-default top-btn1 btn-sm dropdown-toggle\"]")
	WebElement toggleDropDown;
	@FindBy(xpath="//a[normalize-space()='My Events']")
	WebElement myEvents;

	@FindBy(xpath="//*[text()=' Articles']")//added 0n 21/03
	WebElement articles;
	@FindBy(xpath="//*[@class='col-lg-6 col-sm-6 col-md-6 col-xs-12 footer-logo']/*[@alt='Bizligo']")//added on 28/03
	WebElement logo;
	@FindBy(xpath="//*[@class='progress']/*[@role='progressbar']")
	WebElement progress;
	
	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
	
	//	waitForElementToPresent(articles);//for wait purpose
	//	waitForElementToPresent(logo);//for wait purpose
		waitForElementToPresent(progress);//for wait purpose
		return ExpectedConditions.visibilityOf(Home);
	}
	
	public HomePage logout() throws Exception {
	
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
	//	click(Toggledropdownmenu,"Toggledropdownmenu");
		//Thread.sleep(500);
		
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
		waitForElementToPresent(viewAll);
		waitForElementToPresent(wait1);
		waitForElementToPresent(wait2);
		waitForElementToPresent(globalCommunities);
		clickElementByJavaScript(globalCommunities);
		// Thread.sleep(1000);
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
		// new GlobalCommunitesPage(driver, );

	}
	public CommunityDashboardPage gotoManageCommunity(String communityName) throws Exception {


	//	this.searchCommunity(communityName+getDateInDDMMMYYYY());
	//	this.searchCommunity(communityName);
		waitForElementToPresent(MANAGEbtn);
		click(MANAGEbtn, "Manage");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		// new CommunityDashboardPage(driver, );
	}

	/*
	 * public CommunityDashboardPage navigateToManageCommunityPage() throws
	 * Exception {
	 * 
	 * click(MANAGEbtn, "Manage");
	 * //this.searchCommunity(communityName+getDateInDDMMMYYYY());
	 * //this.searchCommunity(communityName); click(MANAGEbtn, "Manage");
	 * Thread.sleep(5000); return (CommunityDashboardPage)
	 * openPage(CommunityDashboardPage.class); // new CommunityDashboardPage(driver,
	 * ); }
	 */

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


	/*public MyEventsPage gotoMyEventsPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(1000);
		waitForElementToPresent(myEvents);
		click(myEvents,"myEvents");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}*/	

	public void myMatches(String actual) throws Throwable
		
	        {
		
	                Thread.sleep(5000);
		
	                click(myMatches,"MyMatches");
		
	                Thread.sleep(8000);
		
	                String expected = textMessage.getText();
		
	                Assert.assertEquals(expected, actual);
		
	                
		
	        }
	
	@FindBy(xpath="//*[@class='category-img']")
			WebElement wait;
	@FindBy(xpath="(//*[@ng-click='data.SearchSimilarBusiness()'])")
			WebElement wait2;
	public MyCommunitiesPage goToMyCommunities() throws Exception {
		
		waitForElementToPresent(viewAll);
		waitForElementToPresent(wait);//added 0n 05/04 for waiting purpose
		waitForElementToPresent(wait2);//added 0n 05/04 for waiting purpose
			click(viewAll, "view All");	
			
//		try {
//			waitForElementToPresent(viewAll);
//			click(viewAll, "view All");	
//		//	clickByJavaExecutor(viewAll);	
//		} catch (Exception e) {
//			
//			driver.navigate().refresh();
//			Thread.sleep(12000);
//			waitForElementToPresent(viewAll);
//			click(viewAll, "view All");
//			
//		}
		
		return (MyCommunitiesPage) openPage(MyCommunitiesPage.class);
	}

	
	private void clickByJavaExecutor(WebElement viewAll2) {
		// TODO Auto-generated method stub
		
	}

	public EcoSystemPage goToMyEcosystem() {
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu, "Toggledropdownmenu");
	//	click(Toggledropdownmenu, "Toggledropdownmenu");
		waitForElementToPresent(myEcosystemInMenu);
		click(myEcosystemInMenu, "My Ecosystem In Menu Drop Down");
		return (EcoSystemPage) openPage(EcoSystemPage.class);
	}
	@FindBy(xpath="//*[@class='text-right']/*[@title='Go to My Communities']")
	WebElement view;
	public GlobalCareers goToGlobalCareers() throws InterruptedException {

		scrollDownVertically();//added on 05/04
		waitForElementToPresent(GlobalCareers);//added on 05/04
		waitForElementToPresent(view);//added on 05/04
	
		click(GlobalCareers, "Global careers");
		
		return (GlobalCareers) openPage(GlobalCareers.class);
		// new GlobalCareers(driver, );
	}

	public Messages goToMyMessages() {
		waitForElementToPresent(wait1);
		waitForElementToPresent(myMessages);
		click(myMessages,"myMessages");
		return (Messages) openPage(Messages.class);
		// new Messages(driver, );
	}
	@FindBy(xpath="(//*[@class='cm-group-name']/*/*/*)[1]")
			WebElement wait1;
	@FindBy(xpath="(//*[@class='text-right']/*[text()='VIEW ALL'])[1]")
			WebElement wait22;
	public MyGroupsPage goToMyGroups() {
		waitForElementToPresent(wait1);//added on 13/04 
		waitForElementToPresent(wait22);//added on 13/04 
		waitForElementToPresent(myGroups);
		clickElementByJavaScript(myGroups);
		//click(myGroups, "myGroups");
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
		
	//	Thread.sleep(2000);	
		waitForElementToPresent(wait1);//added on 13/04 
		waitForElementToPresent(wait22);//added on 13/04 
		
		waitForElementToPresent(articles);//added on 14/03
			
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		//Thread.sleep(1000);
		waitForElementToPresent(myProfile);//added on 14/03
		
		click(myProfile,"myProfile");
		return (MyProfilePage) openPage(MyProfilePage.class);
		// new MyProfilePage(driver, );

	}

	public GlobalMembersPage goToMembersPage() {
		waitForElementToPresent(articles);//added on 19/04
		waitForElementToPresent(wait1);//added on 19/04 
		waitForElementToPresent(wait22);//added on 19/04 
		
		click(directory,"Directory");//added on 21/03
		
      waitForElementToPresent(memberDirectory);//added on 21/03
		hardClick(memberDirectory);
		return (GlobalMembersPage) openPage(GlobalMembersPage.class);
		// new GlobalMembersPage(driver, );
	}
	public MemberDirectoryPage gotoMemberDirectoryPage() throws Exception {
		waitForElementToPresent(wait1);//added on 19/04 
		waitForElementToPresent(wait22);//added on 19/04 
		waitForElementToPresent(articles);//added on 19/04
		
		click(directory,"Directory");

		waitForElementToPresent(memberDirectory);
	//	click(memberDirectory,"MemberDirectory");
		clickElementByJavaScript(memberDirectory);
		return (MemberDirectoryPage) openPage(MemberDirectoryPage.class);
		// new MyProfilePage(driver, );

	}
	public ConnectionsPage goToMyConnections() {
		waitForElementToPresent(wait1);
		waitForElementToPresent(myConnections);
		click(myConnections,"myConnections");
		return (ConnectionsPage) openPage(ConnectionsPage.class);
		// new ConnectionsPage(driver, );
	}
	public void goToMyConnectionRequests() {
		waitForElementToPresent(wait1);
		waitForElementToPresent(wait22);
		waitForElementToPresent(articles);

		waitForElementToPresent(requests);
		click(requests,"Requests");
		
		// new ConnectionsPage(driver, );
	}
	@FindBy(xpath="(//*[@class='panel-title pull-right ng-binding'])[2]")
	WebElement NewRequests;
	
	
	@FindBy(xpath="//h1[contains(text(),'My Connections')]")
	WebElement MyConnectionsTitle;	

	   public void RejectConnectionRequest(String SenderMemberName ) throws InterruptedException
	    {
	    	waitForElementToPresent(MyConnectionsTitle);
	    	String TotalRequestsMessage = NewRequests.getText();
	    	String[]  TRS = TotalRequestsMessage.split("\\s");
	    	int TotalRequests=Integer.parseInt(TRS[0]);   	
	    	for(int i=1;i<=TotalRequests;i++)
	    	{  		                                                                                                          
	    		String MemberName = driver.findElement(By.xpath("(//*[@class='ng-binding'])["+i+"]")).getText();
	    		if(MemberName.equalsIgnoreCase(SenderMemberName))
	    		{
	    			driver.findElement(By.xpath("(//*[contains(text(),'Reject')])["+i+"]")).click();
	    		}
	    	}     
	    	Thread.sleep(3000);
	    	waitForElementToPresent(MyConnectionsTitle);
	    	
	    	try {
	    		for(int i=1;i<=TotalRequests;i++)
	        	{  		                                                                                                          
	        		String MemberName = driver.findElement(By.xpath("(//*[@class='ng-binding'])["+i+"]")).getText();
	        		if(MemberName.equalsIgnoreCase(SenderMemberName))
	        		{
	        			AssertionHelper.markFail();
	        		}
	        	}
			} catch (Exception e) {
				AssertionHelper.markPass();
			}
	    	
	    	
	    }

	  @FindBy(xpath="(//*[@class='cm-group-name'])[1]")
			   WebElement name2;
	public void eventsMenu() {
		waitForElementToPresent(name2);
		waitForElementToPresent(globalEvents);
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
	@FindBy(xpath="(//*[@class='cm-group-name'])[1]")
			WebElement name;
	@FindBy(xpath="	(//*[@title='Go to My Communities'])[1]")
			WebElement title;
	public UpcomingEventsPage navigateToUpComingEvents() throws InterruptedException {
		waitForElementToPresent(name);
		waitForElementToPresent(title);
		waitForElementToPresent(globalEvents);
		Thread.sleep(3000);
	//	scrollToElement(globalEvents);
	//	clickElementByJavaScript(globalEvents,"Global Events");
		click(globalEvents,"Global Events");
	
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
		waitForElementToPresent(viewAll);
		waitForElementToPresent(wait);
		waitForElementToPresent(wait2);
		waitForElementToPresent(blog);
		clickElementByJavaScript(blog, "blog");

		return (BlogsPage) openPage(BlogsPage.class);

	}
	@FindBy(xpath = "//*[@jsselect='heading']")
	WebElement blogpageisnotWorking;

	public void blogPageIsNotWorking() {
		waitForElementToPresent(viewAll);
		waitForElementToPresent(wait);
		waitForElementToPresent(wait2);
		waitForElementToPresent(blog);
		clickElementByJavaScript(blog, "blog");

		waitForElementToPresent(blogpageisnotWorking);
		if(blogpageisnotWorking.isDisplayed()) {
			Assert.assertTrue(true);
		}
	
	}
	@FindBy(xpath = "(//*[contains(text(),'Blog')])[3]")
	WebElement blogpageisWorking;
	public void blogPageIsWorking() {
		waitForElementToPresent(viewAll);
		waitForElementToPresent(wait);
		waitForElementToPresent(wait2);
		waitForElementToPresent(blog);
		clickElementByJavaScript(blog, "blog");

		waitForElementToPresent(blogpageisWorking);
		if(blogpageisWorking.isDisplayed()) {
			Assert.assertTrue(true);
		}
	
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
	public MyEventsPage gotoMyEventsPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(1000);
		waitForElementToPresent(myEvents);
		click(myEvents,"myEvents");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}	
public  MyEventsPage goToMyEventsPage() throws InterruptedException {
	waitForElementToPresent(name);
	waitForElementToPresent(title);
	Thread.sleep(3000);
		waitForElementToPresent(toggleDropDown);
		clickElementByJavaScript(toggleDropDown,"Toggle Drop Down Menu");
		waitForElementToPresent(myEvents);
		click(myEvents,"My events");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}
@FindBy(xpath = "//*[@class='nav navbar-nav navbar-right']/*/*[text()='Contact Us']")
WebElement contactUs;
@FindBy(xpath = "//*[@ng-click='data.SearchSimilarBusiness()']")
WebElement search;

public ContactUsPage NavigateToContactUsPage() throws InterruptedException {
	
Thread.sleep(10000);
	scrollDownVertically();
	waitForElementToPresent(search);//added on 11/04
waitForElementToPresent(contactUs);//added on 11/04

	click(contactUs, "Contact Us");
	return (ContactUsPage) openPage(ContactUsPage.class);
	
}
public void gotoPricingPlanUsingURL() throws InterruptedException{
	//   Thread.sleep(2000); 
	   DriverManager.getDriver().navigate().to("https://tenant1.bizligotest.com/eventmanager/pricing");
//	   Thread.sleep(8000);
	   System.out.println("User cannot open Pricing Plan page using URl");
	   
	    }

@FindBy(xpath="//div[normalize-space()='My Advertisements']")
WebElement myAdvertisements1;
@FindBy(xpath="//div[@class='pull-right text-right Ads-color']")
WebElement adcounts;

public int checkAdcounts() {
	waitForElementToPresent(viewAll);
	waitForElementToPresent(wait1);
	waitForElementToPresent(wait2);
	waitForElementToPresent(myAdvertisements1);
	scrollToElement(myAdvertisements1);
	String count=adcounts.getText();
	System.out.println("Advertisement counts :" + count);
	int i = Integer.parseInt(count);				
	return i;
	
}
public MyAdvertisements NaviagtingToMyAdvertisements() throws InterruptedException
{	waitForElementToPresent(viewAll);
waitForElementToPresent(wait1);
waitForElementToPresent(wait2);

	waitForElementToPresent(myAdvertisements);
	scrollToElement(myAdvertisements);
	clickElementByJavaScript(myAdvertisements);
	

	return (MyAdvertisements) openPage(MyAdvertisements.class);
//	new MyProfilePage(driver, );
}public boolean CompareProgressBars(int previouscount,int Aftercount){
	if(previouscount <= Aftercount) {
		  return true;
	} 
	else return false;
}

}

	
 /*   public  MyEventsPage goToMyEventsPage() {
		
		click(toggleDropDown,"Toggle Drop Down Menu");
		click(myEvents,"My events");
		return (MyEventsPage) openPage(MyEventsPage.class);
	}
*/

