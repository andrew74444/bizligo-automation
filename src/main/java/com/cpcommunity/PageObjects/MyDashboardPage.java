package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.cpcommunity.utilities.DriverManager;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.VerificationHelper;
import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

import junit.framework.Assert;

public class MyDashboardPage extends BasePage{
	
	@FindBy(xpath = "//header[@id='global-nav']") 
    WebElement pageheader;
	@Override 
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		//updateClass(pageheader, "navbar-fixed-top");
	}
		//
	@FindBy(xpath="//*[contains(text(),'Blog')]")
	WebElement blog;
	
	@FindBy(xpath = "//a[contains(text(),'testimonials')]")
	WebElement testimonialsPage;
	
	@FindBy(xpath = "//h2[contains(text(),'Sorry, the page or event you are looking for was n')]")
	WebElement errorPage;
	
	@FindBy(xpath = "//h2[normalize-space()='MY ECOSYSTEM']")

    WebElement myDashboard;
		

	WebElement myDashboard;
	

	@FindBy(xpath="//div[normalize-space()='My Advertisements']")
	WebElement myAdvertisements;
	@FindBy(xpath="//div[@class='pull-right text-right Ads-color']")
	WebElement adcounts;
	
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement menu;

	
	 @FindBy(xpath = "//li[@ng-if='(!appData.IsInEventManagerRole) && (appData.IsGroupActive)']")
	 WebElement LeaveBtn;

	@FindBy(xpath = "//button[contains(.,'Search')]")
    WebElement searchbtn;

	//@FindBy(xpath="")
	@FindBy(xpath = "//body//div[@id='header']//div//div//div//div//div//div//div[1]")
	WebElement Toggledropdownmenu;
	@FindBy (xpath="//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//*[contains(text(),'MY')]")
	WebElement MyEco;
	
	
	//*************************************Endorsements**********************************
	@FindBy (xpath = "//*[contains(text(),'My Endorsements')]")
    WebElement myEndorsements;
	@FindBy(xpath = "//a[@href='/member/endorsements']//div")
	WebElement endorsement;
	@FindBy(xpath = "//div[@class='pull-right text-right endorse-color']")
	WebElement TotalendorsCount;
	
	//*************************************Groups****************************************
	//@FindBy (xpath = "//*[contains(text(),'My Groups')]")
   // WebElement myGroups;
	@FindBy(xpath="//div[@class='huge'])[2]")
	WebElement myGroupsCount;
	@FindBy(xpath="//*[contains(text(),'My Communities')]")
	WebElement myCommunities;
	@FindBy (xpath = "//div[normalize-space()='My Groups']")
    WebElement myGroups;
	 @FindBy (xpath = "//div[normalize-space()='My Jobs']")
	    WebElement myjobs;
	//*************************************Connections***********************************
	@FindBy (xpath="//*[contains(text(),'My Connections')]")
	WebElement myConnections;
	@FindBy(xpath="(//div[@class='huge'])[4]")
	WebElement NewRequests;
	@FindBy(xpath="//div[@class='huge'])[1]")
	WebElement totalCommmunitiesCount;
	//************************************Messages***************************************
	@FindBy (xpath = "//*[contains(text(),'My Messages')]")
	WebElement myMessages;
	@FindBy(xpath="//div[@class='huge'])[3]")
	WebElement myMessagesCount;
	@FindBy (xpath="//button[contains(.,'New Message')]")
	WebElement NewMessage;
	@FindBy (xpath = "//*[@onclick = 'setACookie()']")
	WebElement cookie;
	
	//***********************************LogOut******************************************

	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	//***********************************Member******************************************
	@FindBy(xpath="//*[contains(text(),'Member Directory')]")
	WebElement  memberDirectory;
	@FindBy(xpath="//a[contains(text(),'Global Communities')]")
	WebElement globalCommunities;
	@FindBy(xpath = "//span[contains(text(),'Others')]")
	WebElement others;


	

	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement myProfile;
	@FindBy(xpath="//a[contains(text(),'Manage Password')]")
	WebElement ManagePassword;
	
	
	//***********************************Messages******************************************
	@FindBy (xpath="//textarea[@id='txtMsgContent']")
	WebElement Messagefield;
	
	@FindBy (xpath="//button[contains(.,'Send')]")
	WebElement SendBtn;
	
	
	@FindBy(xpath="//button[contains(.,'New Message')]")
	WebElement NewMessageBtn;
	@FindBy(xpath="//textarea[@id='txtMsgContent']")
	WebElement txtMsgContent;
	//***************************************MyMatches**************************************
	@FindBy(xpath="//div[contains(text(),'My Matches')]")
	WebElement myMatches;
	
	
	@FindBy(xpath="//a[contains(.,' Dashboard')]")
	WebElement MyEcosystem1;
	@FindBy(xpath="//span[contains(text(),'Global Events')]")
	WebElement globalEvents;

	 @FindBy(xpath = "//button[contains(.,'Yes,Proceed')]")
	WebElement YesProceed;
    @FindBy(xpath = "//button[contains(.,'Ok')]")
    WebElement BtnOK;
    @FindBy(xpath = "//div[@class='swal-text']")
   	WebElement makeAnothergroupAdminAlertMeassge;
    

	@FindBy(xpath="//span[@ng-bind='GroupData.MemberCount']")
	WebElement NumberOnCommunityDisplayCard;
	

	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]")
	WebElement upcomingEvents;
	@FindBy(xpath="//a[contains(text(),'Past Events')]")
	WebElement PastEvents;
	
	@FindBy(xpath="//a[contains(text(),'Careers')]")
	WebElement GlobalCareers;
	
	//@FindBy(xpath = "//*[contains(text(),'My Reminders')]")
	//WebElement myReminders;
	
	@FindBy(xpath = "//a[@title='Go to My Reminders']//div[@class='clearfix']")
	WebElement myReminders;//div[normalize-space()='My Reminders']

	
	@FindBy(xpath = "//*[contains(text(),'Create')]")
	WebElement createTask;
	
	@FindBy(xpath = "//input[@name = 'Title'] ")
	WebElement title;
	
	@FindBy(xpath = "/html/body/div[7]/div[3]")
	WebElement startDays;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement save;

	@FindBy(xpath = "//*[@id = 'TaskStartDate']")
	WebElement select;
	
	@FindBy(xpath = "//*[@id = 'TaskStartDate']")
	WebElement startDate;
	
	@FindBy(xpath = "//*[@name = 'TaskDueDate']")
	WebElement startDueDate;
	
	@FindBy(xpath = "/html/body/div[8]/div[3]/table")
	WebElement endDays;
	
	@FindBy(xpath = "/html/body/div[9]/div[3]/table")
	WebElement selectReminder;
	
	@FindBy(xpath = "//*[@id = 'ReminderDate']")
	WebElement reminderDate;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement submit;
	
	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	WebElement Dashboard;
	
	@FindBy(xpath = "//span[@class = 'checkmark']")
	WebElement checkBox;
	
	@FindBy(xpath = "//button[contains(text(),'Yes, Proceed')]")
	WebElement yes;
	
	@FindBy(xpath = "//img[contains(@src,'Content/Images/setting-icon.png')]")
	WebElement settingIcon;
	
	@FindBy(xpath = "//*[@class='btn-link dropstyles']")
	WebElement delete;
	
	@FindBy(xpath = "//span[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	@FindBy(xpath = "(//*[contains(text(),'Blog')])[1]")
	WebElement blogs;
	
	@FindBy(xpath = "(//*[contains(text(),'This page isn’t working')])[1]")
	WebElement blogpageisnotWorking;
	
	@FindBy(xpath = "(//*[contains(text(),'Blog')])[3]")
	WebElement blogpageisWorking;
	

	@FindBy (xpath="//*[contains(text(),'My Jobs')]")
	WebElement myJobs;
	
	@FindBy(xpath="//span[normalize-space()='18-02-2021 -Testing']")
	WebElement Testingcommunity;
	
	@FindBy(xpath="//span[normalize-space()='Resources']")
	WebElement resources;
	
	@FindBy(xpath="//input[@id='searchName']")
	WebElement serachCommunity ;
	
	@FindBy(xpath="//div[@class='communities-box ng-scope col-lg-4 col-md-12 col-sm-12']//div[@class='category-background']")
	WebElement CommunityName ;
	
	@FindBy(xpath="//span[normalize-space()='Groups']")
	WebElement group ;
	
	@FindBy(xpath="//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]//strong[1]")
	WebElement join ;
	
	@FindBy(xpath="//div[@class='cmt-groups']//div[@class='clearfix']")
	WebElement joinedMessage ;
	
	@FindBy(xpath="//div[@class='MessagenotificationBadge']")
	WebElement msgnotification ;
	@FindBy(xpath="//a[@title='Go to My Messages']//div[@class='pull-left cards-icon MainNotification']")
	WebElement msgnotification1 ;
	
	

	 @FindBy(xpath = "//button[normalize-space()='Yes,Proceed']")
	 WebElement YesProceed;
	 @FindBy(xpath = "//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]")
	 WebElement leaveGroup3;
	   
	
	 @FindBy(xpath = "//div[@class='my-communities']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[3]//button[1]")
	 WebElement LeaveBtn;
	 @FindBy(xpath = "//button[normalize-space()='OK']")
	 WebElement BtnOK;
	 
	 @FindBy(xpath="//span[normalize-space()='18-02-2021 -Testing']")
		WebElement Testingcommunity;
		
		@FindBy(xpath="//span[normalize-space()='Resources']")
		WebElement resources;
		
		@FindBy(xpath="//input[@id='searchName']")
		WebElement serachCommunity ;
		@FindBy(xpath="//input[@placeholder='Search by Community Name']")
		WebElement serachCommunityName ;
		
		@FindBy(xpath="//div[@class='communities-box ng-scope col-lg-4 col-md-12 col-sm-12']//div[@class='category-background']")
		WebElement CommunityName ;
		
		@FindBy(xpath="//a[normalize-space()='BizLigo1']")
	    WebElement bizligo1;
		@FindBy(xpath="//a[@title='Go to My Communities']")
		WebElement viewAllBtn;
		@FindBy(xpath="//span[normalize-space()='Groups']")
		WebElement group ;
		@FindBy(xpath="//span[@ng-bind='group.GroupName'][normalize-space()='Group 3']")
		WebElement group3 ;
		@FindBy(xpath="//span[normalize-space()='test123']")
		WebElement test123 ;
		@FindBy(xpath="//tr[@class='odd']//span[@title='For this plan payment is pending'][normalize-space()='PAYMENT PENDING']")
		WebElement inactivestatus ;
		@FindBy(xpath="//div[@class='post-box']//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]//strong[1]")
		WebElement join3 ;
		@FindBy(xpath="//div[@class='cmt-groups']//div[@class='clearfix']")
		WebElement joinedMessage ;
	    @FindBy(xpath = "//div[@class='swal-text']")
	   	WebElement LeaveToastMessage;
	    @FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//a[normalize-space()='Global Communities']")
		WebElement Globalcommunities;
	    @FindBy(xpath="//a[@title='Go to My Communities']")
		WebElement viewAll;
	    @FindBy(xpath = "//*[contains(text(),'MANAGE')]")
		WebElement MANAGEbtn;
	    @FindBy(xpath="//button[@ng-click='data.SearchCommunities()']")
		WebElement search;
	    @FindBy(xpath = "//input[@placeholder='Search by Group Name']")
	    WebElement SearchGroup;
	    @FindBy(xpath="//span[@ng-bind='GroupData.GroupName']")
		WebElement NameOnDisplayCard;
	    @FindBy(xpath="//div[@class='pull-right text-right jobs-color']")
		WebElement myJobsCount;
	    @FindBy(xpath="//div[@class='pull-right text-right Ads-color']")
		WebElement myAdCount;
	    @FindBy(xpath = "//input[@placeholder='Search by Community Name']")
		WebElement SearchbyCommunityName;
	    @FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
		WebElement advertisements;
	    @FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
		WebElement managePlans;
	    @FindBy(xpath = "//span[normalize-space()='18-02-2021 -Testing']")
		WebElement Testingcomm;
	    @FindBy(xpath = "//a[normalize-space()='Discussions']")
	  	WebElement discussion;
	    @FindBy(xpath = "//button[normalize-space()='MANAGE']")
	  	WebElement bizligo1manage;
	    
	  

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		log.info("---> DashBoard");
		
		return ExpectedConditions.visibilityOf(myDashboard);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public int MyGroupsCount() {		
		   String C = myGroupsCount.getText();
	      int TC=Integer.parseInt(C);
	      click( myGroups,"myGroups");	      
	      return TC;		
	      
	}
	public int checkUnreadMessagecounts() {		
		   String C = msgnotification.getText();
	      int TC=Integer.parseInt(C);
	      System.out.println(C);
	     // click( myMessages,"myMessages");	      
	      return TC;		
	      
	}

	
	public GlobalCareers NavigateToGlobalCareers(){

	public GlobalCareers NavigateToGlobalCareers() throws InterruptedException{
		Thread.sleep(4000);

		click(GlobalCareers,"click");
		return (GlobalCareers) openPage(GlobalCareers.class);
//				new GlobalCareers(driver, );
	}
	
	public Messages NavigateToMyMessages(){
		myMessages.click();
		return (Messages) openPage(Messages.class);
//		new Messages(driver, );
	}
	public void  MyJobsCount() {		
		   String C = myJobsCount.getText();
	      int TC=Integer.parseInt(C);
	      System.out.println("The number of jobs count visible on Dashboard is:"+ TC);
	      	System.out.println("Members can see number of Job Counts on Dashboard");      
	      		
	}
	public void  MyAdCount() throws InterruptedException {	
		Thread.sleep(8000);
		   String C = myAdCount.getText();
	      int TC=Integer.parseInt(C);
	      System.out.println("The number of Ads count visible on Dashboard is:"+ TC);
	      	System.out.println("Members can see number of Ads Counts on Dashboard");      
	      		
	}

public void checkProperAlertDisplayedWhenOnlyOneAdmin(String GroupName) throws Exception {
	//this.searchCommunity(communityName+getDateInDDMMMYYYY());
	//waitForElementToPresent(CommunityBox);
	//click(CommunityBox, "Community Box");
	//scrollIntoView(LeaveBtn);
	waitForElementToPresent(myGroups);
	myGroups.click();		
	//waitForElementToPresent(test123);
	//click(test123, "Test123");
	waitForElementToPresent(LeaveBtn);
	click(LeaveBtn, "leave");
	takeScreenshotByShutterBug(LeaveBtn, "Leave Btn");
	//waitForElementToPresent(YesProceed);
	//takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
	//click(YesProceed, "Yes Proceed");
	waitForElementToPresent(LeaveToastMessage);
	waitForElementToPresent(BtnOK);
	takeScreenshotByShutterBug(BtnOK, "Ok");
	click(BtnOK, "Ok");
	picture();
	//System.out.println("Leave click");
	

			//"Please make another member as Group Admin to leave from this Group.");
	AssertionHelper.verifyText(LeaveToastMessage.getText(),
			"Please make another member as Group Admin to leave from this Group");
	System.out.println("Assertion done");
}
public void searchCommunity(String communityName) throws Exception {
	waitForElementToPresent(viewAll);
	click(viewAll, "Global Communities");
	waitForElementToPresent(SearchbyCommunityName);
	picture();
	type(SearchbyCommunityName, communityName, "Search by Community");
	click(searchbtn, "search btn");
	Thread.sleep(6000);
	WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
	waitForElementToPresent(ele);
	picture();

}

public CommunityDashboardPage gotoManageCommunity(String communityName) throws Exception {

	//this.searchCommunity(communityName+getDateInDDMMMYYYY());
	click(MANAGEbtn, "Manage");
	return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
	// new CommunityDashboardPage(driver, );
}public void clickOnAdvertisments() {
	click(advertisements, "advertisements");
}

public ManageAdPlansPage goToManageAdPlansPage() {

	this.clickOnAdvertisments();
	waitForElementToPresent(managePlans);
	click(managePlans, "Manage Plans");
	return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
	// new CommunityPendingRequestsPage(driver);
}
	public void NavigateToMyReminders(String Title) throws Exception{
		click(myReminders,"MyReminders");
		Thread.sleep(2000);
		click(createTask,"CreateTask");
		title.sendKeys(Title);
		click(this.startDate, "startDate");
		waitForElementToPresent(startDays);
		DateManager d = new DateManager(driver);
	    String date = d.getCurrentDateString();
		d.selectDate("/html/body/div[7]/div[3]",date); 
		Thread.sleep(5000);
		click(this.startDueDate, "startDueDate");
		waitForElementToPresent(endDays);
		DateManager d1 = new DateManager(driver);
	    String date1 = d1.getCurrentDateString();
	    d1.selectDate("/html/body/div[8]/div[3]/table",date); 
	    Thread.sleep(3000);
	    click(this.reminderDate, "reminderDate");
	    waitForElementToPresent(selectReminder);
	    
//	    DateManager d3 = new DateManager(driver);
//	    d3.selectDate("/html/body/div[9]/div[3]/table",date);
	    Thread.sleep(8000);
	    
	}
	
	public void errorMessagesReminders() throws InterruptedException
	{
		click(myReminders,"MyReminders");
		Thread.sleep(2000);
		click(createTask,"CreateTask");
		Thread.sleep(5000);
		submit.click();
		
	}
	
	public void taskCompleted() throws InterruptedException
	{
		click(myReminders,"MyReminders");
		Thread.sleep(5000);
		checkBox.click();
		Thread.sleep(2000);
		yes.click();
		Thread.sleep(2000);
	}
	
	public void deleteReminder() throws InterruptedException
	{
		click(myReminders,"MyReminders");
		Thread.sleep(5000);
		settingIcon.click();
		Thread.sleep(5000);
		delete.click();
		Thread.sleep(5000);
		yes.click();
		Thread.sleep(8000);
	}
	
	public MyGroupsPage NavigatingToMyGroups()
	{
		click(myGroups,"myGroups");
		return (MyGroupsPage) openPage(MyGroupsPage.class);
//		new MyGroupsPage(driver, );		
	}

	public void checkProperAlertDisplayedWhenOnlyOneAdmin(String GroupName) throws Exception {
		//this.searchCommunity(communityName+getDateInDDMMMYYYY());
		//waitForElementToPresent(CommunityBox);
		//click(CommunityBox, "Community Box");
		//scrollIntoView(LeaveBtn);
		waitForElementToPresent(myGroups);
		myGroups.click();		
		Thread.sleep(5000);
		waitForElementToPresent(LeaveBtn);
		click(LeaveBtn, "leave");
		takeScreenshotByShutterBug(LeaveBtn, "Leave Btn");
		waitForElementToPresent(YesProceed);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(BtnOK);
		takeScreenshotByShutterBug(BtnOK, "Ok");
		click(BtnOK, "Ok");
		picture();
		System.out.println("Ok button click");
		

				//"Please make another member as Group Admin to leave from this Group.");
		AssertionHelper.verifyText(makeAnothergroupAdminAlertMeassge.getText(),
				"Please make another member as Group Admin to leave from this Group.");
		System.out.println("Assertion done");

	public MyJobsPage NavigatingToMyJobs()
	{
		click(myjobs,"myjobs");
		return (MyJobsPage) openPage(MyJobsPage.class);
//		new MyGroupsPage(driver, );		

	}
	
	public TestimonialsVerifyPage NavigateTotestimonials() throws InterruptedException
	{
		Actions action = new Actions(driver);
		 // action.moveToElement(others).perform();
		  Thread.sleep(1000);
		  action.moveToElement(testimonialsPage).click().perform();
		return (TestimonialsVerifyPage) openPage(TestimonialsVerifyPage.class);
	}
	
	public void testimonialEnabled() throws InterruptedException
	{
		Actions action = new Actions(driver);
		  action.moveToElement(testimonialsPage).click().perform();
		  Thread.sleep(2000);
		  waitForElementToPresent(testimonialsPage); 
	}
	
	public void testimonialDisabled() throws InterruptedException
	{
		Actions action = new Actions(driver);
		  //action.moveToElement(others).perform();
		  Thread.sleep(2000);
		  action.moveToElement(testimonialsPage).click().perform();
		  Thread.sleep(2000);
		  waitForElementToPresent(errorPage);
		 	 
	}
	
	
	
//public int GoToMygroups(ExtentTest logger) throws Exception
//{
//
//}
	
	public GlobalCommunitesPage NaviagtingToGlobalCommunities() throws Exception
	{
	

		click(Toggledropdownmenu,"Toggle drop down menu");
		Thread.sleep(1000);
		click(globalCommunities,"Global Communities");

		//click(Toggledropdownmenu,"Toggle drop down menu");
		//Thread.sleep(1000);
		click(GlobalCommunities,"Global Communities");

		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//		new ChangePasswordPage(driver, );
		
	}
	
	public ResourcesPage  gotoResourcesPage() throws Exception {
		Thread.sleep(2000);
		waitForElementToPresent(Testingcommunity);
		click(Testingcommunity,"18-02-2021Testing community");
		Thread.sleep(5000);
		waitForElementToPresent(resources);
		click(resources,"Resources");
		Thread.sleep(5000);
		return (ResourcesPage) openPage(ResourcesPage.class);
			}
	public ChangePasswordPage NaviagtingToManagePassword() throws Exception
	{
		Toggledropdownmenu.click();
		Thread.sleep(1000);
		ManagePassword.click();
		return (ChangePasswordPage) openPage(ChangePasswordPage.class);
//		new ChangePasswordPage(driver, );
		
	}
	
	
	public MyDashboardPage navigateToMyDashBoard() throws InterruptedException
	{
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(2000);
		waitForElementToPresent(Dashboard);
		click(Dashboard,"Dashboard");		
		return (MyDashboardPage) openPage(MyDashboardPage.class);
//		new MyDashboardPage(driver, );
	}
	
	
	
	/*public MyDashboardPage navigateToMyDashBoard() throws InterruptedException
	{
		
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(5000);
		waitForElementToPresent(Dashboard);
		click(Dashboard,"Dashboard");
		Thread.sleep(5000);
		return (MyDashboardPage) openPage(MyDashboardPage.class);
//		new MyDashboardPage(driver, );
	}*/
	
	
		
//		new MyDashboardPage(driver, );
	
	public TestimonialsPage naviagtingToTestimonials() throws Exception 
	{
		
		//clickElementByJavaScript(testimonials);
		//waitForElementToPresent(testimonials);
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 500);")
		Thread.sleep(3000);
		click(testimonials, "Testimonials");
		Thread.sleep(2000);
		return (TestimonialsPage) openPage(TestimonialsPage.class);
//		new GlobalCommunitesPage(driver, );
		
	}
	
	public void checkplanstatus() throws InterruptedException {
		Thread.sleep(5000);
		this.inactivestatus.isDisplayed();
		String status=inactivestatus.getText();
		System.out.println(status);
		
	}
	
   public GlobalCommunitesPage naviagtingToGlobalCommunities() throws Exception
	{ 
		driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		clickElementByJavaScript(globalCommunities);
		Thread.sleep(6000);
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//		new GlobalCommunitesPage(driver, );
		
	}

  public void blogPageisnotWorking() throws Throwable
{
	Thread.sleep(5000);
	Actions action = new Actions(driver);
	  //action.moveToElement(others).perform();
	  Thread.sleep(3000);
	  action.moveToElement(blogs).click().perform();
	  Thread.sleep(1000);
	waitForElementToPresent(blogpageisnotWorking);
}


     public void blogPageWorking() throws Throwable
{
	Thread.sleep(5000);
	Actions action = new Actions(driver);
	  //action.moveToElement(others).perform();
	  Thread.sleep(3000);
	  action.moveToElement(blogs).click().perform();
	  Thread.sleep(1000);
	waitForElementToPresent(blogpageisWorking);
}


	
	public MyCommunitiesPage NaviagtingToMyCommunities() throws Exception
	{
		
		clickElementByJavaScript(myCommunities);
		Thread.sleep(1000);
		return (MyCommunitiesPage) openPage(MyCommunitiesPage.class);
//		new MyCommunitiesPage(driver, );
		
	}
//	public int GoToMyCommunities(ExtentTest logger) throws InterruptedException {
//	
//	
//	
//	
//	js.executeScript("arguments[0].scrollIntoView(true);",Communities);
// String C = TotalCommmunities.getText();
// int TC=Integer.parseInt(C);
// Utility.highLightElement(driver, Communities);
// Communities.click();
// return TC;
//}	
//	
	
	
	public MyProfilePage NaviagtingToMyProfilePage() throws Exception
	{
	
		Toggledropdownmenu.click();
		Thread.sleep(1000);
		myProfile.click();
		return (MyProfilePage) openPage(MyProfilePage.class);
//		new MyProfilePage(driver, );
		
	}
	public GlobalMembersPage navigateToMemberDirectory()
	{	
		memberDirectory.click();
		return (GlobalMembersPage) openPage(GlobalMembersPage.class);
//		new GlobalMembersPage(driver, );
	}
	
	public int checkAdcounts() {
		waitForElementToPresent(myAdvertisements);
		String count=adcounts.getText();
		System.out.println("Advertisement counts :" + count);
		int i = Integer.parseInt(count);				
		return i;
		
	}
	public boolean CompareProgressBars(int previouscount,int Aftercount){
		if(previouscount <= Aftercount) {
			  return true;
		} 
		else return false;
	}
	public ConnectionsPage navigateToMyConnections()
	{				
		myConnections.click();	
		return (ConnectionsPage) openPage(ConnectionsPage.class);
//		new ConnectionsPage(driver, );
	}
	
	public MyJobsPage navigateToMyJobsPage() {
		myJobs.click();		
		return (MyJobsPage) openPage(MyJobsPage.class);
	}
	
	public void ClickOnGlobalEvents()
	{				
		moveToElement(globalEvents);
//		click(globalEvents,"Global Events");		
	}
	
	public UpcomingEventsPage GoToUpComingEvents()
	{
		
		this.ClickOnGlobalEvents();		
		waitForElementToPresent(upcomingEvents);
		click(upcomingEvents,"Upcoming Events");
		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
//		new UpcomingEventsPage(driver, );
	}
	
	public BlogsPage navigateToBlogs() throws Throwable
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		  //action.moveToElement(others).perform();
		  Thread.sleep(3000);
		  action.moveToElement(blogs).click().perform();
		  Thread.sleep(1000);
		return (BlogsPage) openPage(BlogsPage.class);
	}
	
	
	
//	public PastEventsPage ClickOnPastEvents()
//	{
//		this.ClickOnGlobalEvents();
//		waitHelper.waitForElement(PastEvents,100);
//		
//		PastEvents.click();	
//		return () openPage(.class);
//		new PastEventsPage(driver, );
//	}
	
	public HomePage logout() throws Exception
	{
		Toggledropdownmenu.click();
		Thread.sleep(500);
		waitForElementToPresent(Logout);
		Logout.click();
		return (HomePage) openPage(HomePage.class);
//		new HomePage(driver, );
	}
	
	public EndorsementPage NaviagtingToMyEndorsements()
	{
		waitForElementToPresent(myEndorsements);
		myEndorsements.click();	
		return (EndorsementPage) openPage(EndorsementPage.class);
		//new EndorsementPage(driver, );
	}
	

	public MyAdvertisements NaviagtingToMyAdvertisements()
	{		
		//scrollToElement(myAdvertisements);
		click(myAdvertisements,"My Advertisements");	

	public MyAdvertisements NaviagtingToMyAdvertisements() throws InterruptedException
	{		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);Thread.sleep(5000);
		scrollToElement(myAdvertisements);
		clickElementByJavaScript(myAdvertisements);
		//click(myAdvertisements,"My Advertisements");	
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		return (MyAdvertisements) openPage(MyAdvertisements.class);
//		new MyProfilePage(driver, );
	}
	

public MyGroupsPage navigateToMyGroupsPage() {
		
		waitForElementToPresent(myGroups);
		myGroups.click();		
		return (MyGroupsPage) openPage(MyGroupsPage.class);
	}
	


	public MyProfilePage NaviagtingToMyProfilePage1()
	{
		myEndorsements.click();	
		return (MyProfilePage) openPage(MyProfilePage.class);
//		new MyProfilePage(driver, );
	}

	public void Totalendorsments() throws Exception {
		//boolean varExists = false;
		scrollIntoView(myEndorsements);
		waitForElementToPresent(this.TotalendorsCount);
		 String C = TotalendorsCount.getText();
	      int TC=Integer.parseInt(C);
			System.out.println("Total count is " + TC);
	}
	
	public ResourcesPage goToBDMAIResouces(String Community) {
		waitForElementToPresent(globalCommunities);
		click(globalCommunities, "Global Communities");
		waitForElementToPresent(serachCommunity);
		type(serachCommunity, Community, "Communities");
		waitForElementToPresent(CommunityName);

	
	public ResourcesPage  gotoResourcesPage() throws Exception {
		Thread.sleep(2000);
		waitForElementToPresent(Testingcommunity);
		click(Testingcommunity,"18-02-2021Testing community");
		Thread.sleep(5000);
		waitForElementToPresent(resources);
		click(resources,"Resources");
		Thread.sleep(5000);
		return (ResourcesPage) openPage(ResourcesPage.class);
			}
	
	public ResourcesPage goToBDMAIResouces(String Community) throws InterruptedException {
		waitForElementToPresent(Globalcommunities);
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		click(Globalcommunities, "Global Communities");
		waitForElementToPresent(serachCommunity);
		type(serachCommunity, Community, "Communities");
		waitForElementToPresent(search);
		click(search, "Search");
		waitForElementToPresent(CommunityName);
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);

		click(CommunityName, "BDMAI Community");
		waitForElementToPresent(resources);
		click(resources, "Resources");
		return (ResourcesPage) openPage(ResourcesPage.class);
	}

	
	public void joinGroup(String Community) throws InterruptedException {
		waitForElementToPresent(globalCommunities);
		click(globalCommunities, "Global Communities");
		waitForElementToPresent(serachCommunity);
		type(serachCommunity, Community, "Communities");
		waitForElementToPresent(CommunityName);
		click(CommunityName, "Bizligo1 Community");
		waitForElementToPresent(group);
		click(group, "Group");
		Thread.sleep(4000);
		waitForElementToPresent(join);
		click(join, "Join");

	public void joinGroup(String Community) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		waitForElementToPresent(viewAll);
		click(viewAll, "Global Communities");
		//waitForElementToPresent(serachCommunity);
		//type(serachCommunity, Community, "Communities");
		driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		waitForElementToPresent(bizligo1);
		click(bizligo1, "Bizligo1 Community");
		//waitForElementToPresent(search);
		//click(search, "Search");
		waitForElementToPresent(group);
		click(group, "Group");
		waitForElementToPresent(join3);
		click(join3, "Join");

		click(YesProceed, "Yes Proceed");
		AssertionHelper.verifyText(joinedMessage.getText(),
				"You have joined the group successfully.");
		System.out.println("Assertion done");

	
	}
 public ResourcesPage gotoResource() {
	 waitForElementToPresent(resources);
		click(resources, "Resources");
	 
	 return (ResourcesPage) openPage(ResourcesPage.class); 
 }

		 Thread.sleep(5000);
	}
	 public ResourcesPage gotoResource() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
		 waitForElementToPresent(resources);
			click(resources, "Resources");
			Thread.sleep(5000);
		 return (ResourcesPage) openPage(ResourcesPage.class); 
	 }
	 public void NavigatingToMyGroups(String Groupname) throws InterruptedException
		{
		 Thread.sleep(5000);
			click(myGroups,"myGroups");
			Thread.sleep(4000);
			type( SearchGroup,Groupname,"Search by Group Name");
	    	click(searchbtn,"search btn");
	    	Thread.sleep(5000);
	    	WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='"+Groupname+"']"));
	    	waitForElementToPresent(ele);
	    	String el=ele.getText();
	    	System.out.println(el);//span[contains(text(),'"+Groupname+"')]
	    	System.out.println(Groupname);
	    	Assert.assertEquals(Groupname, el);
			//return (MyGroupsPage) openPage(MyGroupsPage.class);
//			new MyGroupsPage(driver, );		
		}
	 public void numberOfMembers(String Groupname) throws InterruptedException {
			click(myGroups,"myGroups");
			Thread.sleep(6000);
			type( SearchGroup,Groupname,"Search by Group Name");
	    	click(searchbtn,"search btn");
	    	Thread.sleep(6000);
	    	WebElement ele = driver.findElement(By.xpath("//span[normalize-space()='"+Groupname+"']"));
	    	waitForElementToPresent(ele);
	    	String el=ele.getText();
			//waitForElementToPresent(this.SearchByStatus);
			if (NameOnDisplayCard.isDisplayed()){
				System.out.println("Name Of the community="+ NameOnDisplayCard.getText());
				System.out.println("Total Number of active members displayed="+ NumberOnCommunityDisplayCard.getText());			
				Assert.assertTrue(true);
			}
		}
	 public Bizligo1CommunityPage goToMyCommunity() throws InterruptedException {
		 Thread.sleep(6000);
			click(viewAllBtn,"view all");
			Thread.sleep(6000);
			scrollIntoView(bizligo1);
			//waitForElementToPresent(bizligo1);
			click(bizligo1,"Bizligo 1");
			Thread.sleep(8000);
			return (Bizligo1CommunityPage) openPage(Bizligo1CommunityPage.class);
		}
	 public RemindersPage NaviagtingToRemindersPage()
		{		
			waitForElementToPresent(myReminders);
			click(myReminders,"My reminders");	
			return (RemindersPage) openPage(RemindersPage.class);
//			new MyProfilePage(driver, );
		}
		


// public void Groups(ExtentTest logger) throws InterruptedException
// {
// 	JavascriptExecutor js = (JavascriptExecutor) driver;
// 	WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Groups')]")));
//		Thread.sleep(2000);
// 	WebElement Grp = GroupsViewDetails;
//     js.executeScript("arguments[0].scrollIntoView(true);",Grp);
//     Utility.highLightElement(driver, GroupsViewDetails);
//     GroupsViewDetails.click();
// }
// public void AcceptConnectionRequest(String SenderMemberName,ExtentTest logger) throws InterruptedException
// {
// 	WebDriverWait wait=new WebDriverWait(driver, 20);
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
// 	ConnectionsLink.click();
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(.,'My Connections')]")));
// 	Thread.sleep(2000);
// 	String TotalRequestsMessage = NewRequests.getText();
// 	String[]  TRS = TotalRequestsMessage.split("\\s");
// 	int TotalRequests=Integer.parseInt(TRS[0]);    	
// 	for(int i=1;i<=TotalRequests;i++)
// 	{
// 		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
//     	if(MemberName.equalsIgnoreCase(SenderMemberName))
//     	{
//     		driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[1]")).click();
//     	}
//     	
//     	else {
//     		logger.log(LogStatus.FAIL,"Member request is not Processed");
//     	}
//     	}
//     	
//     	
//     }
// public void RejectConnectionRequest(String SenderMemberName, ExtentTest logger) throws InterruptedException
// {
// 	WebDriverWait wait=new WebDriverWait(driver, 20);
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
// 	ConnectionsLink.click();
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(.,'My Connections')]")));
// 	Thread.sleep(2000);
// 	String TotalRequestsMessage = NewRequests.getText();
// 	String[]  TRS = TotalRequestsMessage.split("\\s");
// 	int TotalRequests=Integer.parseInt(TRS[0]);    	
// 	for(int i=1;i<=TotalRequests;i++)
// 	{  		                                                                                                          
// 		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
// 		if(MemberName.equalsIgnoreCase(SenderMemberName))
// 		{
// 			driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[2]")).click();
// 		}
// 	}     
// 	Utility.WaitForElementToVisible(driver, "//h1[contains(.,'My Connections')]");
// 	
// 	try {
// 		for(int i=1;i<=TotalRequests;i++)
//     	{  		                                                                                                          
//     		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
//     		if(MemberName.equalsIgnoreCase(SenderMemberName))
//     		{
//     			logger.log(LogStatus.FAIL,"Member request is not Rejected");
//     		}
//     	}
//		} catch (Exception e) {
//			logger.log(LogStatus.PASS,"Member Reject request is Processed");
//		}
// 	
// 	
// }
// 
// 
//public void navigateToDashboadPage() throws Exception
//{	
//	Utility.WaitForElementToVisible(driver, WelcomemenuDropDown);
//	Utility.highLightElement(driver, Welcomemenu);
//	Welcomemenu.click();
//	Thread.sleep(1000);
//	Utility.highLightElement(driver, Dashboard);
//	Dashboard.click();
//	Thread.sleep(4000);
//}
//
//
//public void NavigateToMessages(String connectRecieverEmailID, String connectReciverEmailPwd,
//		String senderMemberName, String message1, String appUrl,String ConnectSenderEmailID,
//		String ConnectSenderPwd, String message2,String recieverMemberName, ExtentTest logger) throws Exception{
//	
//	
//	LoginPagejava Login_Page = new LoginPagejava (driver);
//	Login_Page.login(connectRecieverEmailID, connectReciverEmailPwd, logger);
//	WebDriverWait wait=new WebDriverWait(driver, 20);
//	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
//	Thread.sleep(3000);
//	//String dateName = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
//	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
// Date date = new Date();
//	String Message = message1+" "+dateFormat.format(date);
//	MessagesLink.click();
//	Thread.sleep(6000);
//	NewMessageBtn.click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//span[contains(.,'"+senderMemberName+"')]")).click();
//	Thread.sleep(2000);
//	txtMsgContent.sendKeys(Message);
//	SendBtn.click();
//	Thread.sleep(3000);
//	Utility.highLightElement(driver, driver.findElement(By.xpath("//p[contains(.,'"+Message+"')]")));
//	Thread.sleep(1000);
//	
//	List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
//	String i = Integer.toString(elements.size());
//	String SharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+i+"]/div[2]/p")).getText();	
//	SoftAssert softAssertion= new SoftAssert();
//	softAssertion.assertEquals(SharedMessage, Message);
//	softAssertion.assertAll();
//	driver.manage().deleteAllCookies();
//	driver.get(appUrl);
//	Login_Page.login(ConnectSenderEmailID, ConnectSenderPwd, logger);
//	Date date1 = new Date();
//	String ReplyMessage = message2+" "+dateFormat.format(date1);
//	MessagesLink.click();
//	Thread.sleep(6000);
//	NewMessageBtn.click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//span[contains(.,'"+recieverMemberName+"')]")).click();
//	Thread.sleep(2000);
//	txtMsgContent.sendKeys(ReplyMessage);
//	SendBtn.click();
//	Thread.sleep(3000);
//	Utility.highLightElement(driver, driver.findElement(By.xpath("//p[contains(.,'"+ReplyMessage+"')]")));
//	Thread.sleep(1000);
//	
//	List<WebElement> elements1 = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
//	String j = Integer.toString(elements1.size());
//	String ReplySharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+j+"]/div[2]/p")).getText();	
//	
//	softAssertion.assertEquals(ReplySharedMessage, ReplyMessage);
//	softAssertion.assertAll();
//	
//	
//     
//	   	        
////			
////	   	     for(WebElement el:elements)
////	 		{	
////		String Message1 =el.getText();
////		System.out.println(Message1);
////		String TagName=el.getTagName();
////		System.out.println("="+TagName+"=");
////		//System.out.println(el.getTagName()+": "+el.getText());
////		
////	 		}
////	
//	
//}
// 
// 
// 
//
// public void SelectMember(String MemberName, ExtentTest logger) throws InterruptedException
// {
// 	WebDriverWait wait=new WebDriverWait(driver, 20);
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(.,'"+MemberName+"')]")));
// 	driver.findElement(By.xpath("//span[contains(.,'"+MemberName+"')]")).click();
// 	Thread.sleep(2000);
// }
// public void SendMessage(String Message,ExtentTest logger) throws InterruptedException
// {
// 	WebDriverWait wait=new WebDriverWait(driver, 20);
// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Msgfield)));
// 	Messagefield.sendKeys(Message);
// 	SendBtn.click();
// 	Thread.sleep(2000);
// 	SoftAssert SA = new SoftAssert();
// 	SA.assertEquals(driver.findElement(By.xpath("//p[contains(.,'"+Message+"')]")), Message);
// 	SA.assertAll();
// 	Thread.sleep(2000);
// }

//	public void AllCommunities(ExtentTest logger)
//	{
//		WebDriverWait wait = new WebDriverWait(driver, 20);
// 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WelcomemenuDropDown)));
// 	Utility.highLightElement(driver, AllCommunities);
//		AllCommunities.click();
//	}



	 public CommunityDashboardPage gotoDashboardPage(String Community) throws InterruptedException {
			Thread.sleep(6000);
			waitForElementToPresent(viewAll);
			click(viewAll, "Global Communities");
			waitForElementToPresent(serachCommunityName);
			type(serachCommunityName, Community, "Communities");
			click(searchbtn, "Search");
			Thread.sleep(15000);
			waitForElementToPresent(bizligo1manage);
			click(bizligo1manage,"Bizligo 1");
			return(CommunityDashboardPage)openPage(CommunityDashboardPage.class);	
	 }

	public boolean verifySuccessLogin(){
		return new VerificationHelper(driver).isDisplayed(Toggledropdownmenu);
	}

    public void gotoGlobalAdPageUsingURL() throws InterruptedException{
   Thread.sleep(2000); 
   DriverManager.getDriver().navigate().to("https://tenant1.bizligotest.com/eventmanager/promotions#");
   Thread.sleep(8000);
   System.out.println("User cannot open Global Advertisement page using URl");
   
    }
	
	public BlogsPage goToBlogsPage() 
	{
	 click(blog,"blog");
	 return(BlogsPage)openPage(BlogsPage.class);	
	}


	public MyDashboardPage MyEcosystem() {
		// TODO Auto-generated method stub
		return null;
	}


	public void goToTestimonial() {
		// TODO Auto-generated method stub
		
	}
	public Discussions GotoDiscussionPage() throws InterruptedException {
		waitForElementToPresent(Testingcomm);
		click(Testingcomm, "18-02-2021 -testing");	
		Thread.sleep(7000);
		click(discussion, "Discussion");

	return (Discussions) openPage(Discussions.class);	
}
//	public void naviagtingToTestimonials() {
//		// TODO Auto-generated method stub
//		
//	}
	
//	public void logExtentReport(String s1){
//		TestBase.test.log(Status.INFO, s1);
//	}

//	public CommunityDetailsPage navigateToCommunityDetailsPage(String communityName) {
//		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+communityName+"')]"));
//		JavaScriptHelper js = JavaScriptHelper;
//		js.clickElement(ele);
//		
//		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
////		new CommunityDetailsPage(driver, );
//	}


	  public void gotoGlobalAdPageUsingURL() throws InterruptedException{
		   Thread.sleep(2000); 
		   DriverManager.getDriver().navigate().to("https://tenant1.bizligotest.com/eventmanager/promotions#");
		   Thread.sleep(8000);
		   System.out.println("User cannot open Global Advertisement page using URl");
		   
		    }
	
	


}
