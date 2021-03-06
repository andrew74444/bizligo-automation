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

import java.util.Calendar;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.VerificationHelper;
import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

public class MyDashboardPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
		
	@FindBy(xpath="//*[contains(text(),'Blog')]")
	WebElement blog;
	
	@FindBy(xpath = "//a[contains(text(),'testimonials')]")
	WebElement testimonialsPage;
	
	@FindBy(xpath = "//h2[contains(text(),'Sorry, the page or event you are looking for was n')]")
	WebElement errorPage;
	
	@FindBy(xpath = "(//*[contains(text(),'My Dash')])[2]")
	WebElement myDashboard;
	
	
	
	@FindBy(xpath="//*[contains(text(),'My Advertisements')]")
	WebElement myAdvertisements;
	
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement menu;
	
	
	
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
	
	//*************************************Groups****************************************
	@FindBy (xpath = "//*[contains(text(),'My Groups')]")
    WebElement myGroups;
	@FindBy(xpath="//div[@class='huge'])[2]")
	WebElement myGroupsCount;
	@FindBy(xpath="//*[contains(text(),'My Communities')]")
	WebElement myCommunities;
	

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
	@FindBy(xpath="//a[contains(text(),'Global Communities')]")
	WebElement GlobalCommunities;
	
	
	
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
	
	
	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]")
	WebElement upcomingEvents;
	@FindBy(xpath="//a[contains(text(),'Past Events')]")
	WebElement PastEvents;
	
	@FindBy(xpath="//a[contains(text(),'Global Careers')]")
	WebElement GlobalCareers;
	
	@FindBy(xpath = "//*[contains(text(),'My Reminders')]")
	WebElement myReminders;
	
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
	
	@FindBy(xpath = "(//*[contains(text(),'This page isn�t working')])[1]")
	WebElement blogpageisnotWorking;
	
	@FindBy(xpath = "(//*[contains(text(),'Blog')])[3]")
	WebElement blogpageisWorking;
	
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
	public GlobalCareers NavigateToGlobalCareers(){
		click(GlobalCareers,"click");
		return (GlobalCareers) openPage(GlobalCareers.class);
//				new GlobalCareers(driver, );
	}
	
	public Messages NavigateToMyMessages(){
		myMessages.click();
		return (Messages) openPage(Messages.class);
//		new Messages(driver, );
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
		click(GlobalCommunities,"Global Communities");
		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//		new ChangePasswordPage(driver, );
		
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
	
	
	
public GlobalCommunitesPage naviagtingToGlobalCommunities() throws Exception
	{
		
		clickElementByJavaScript(globalCommunities);
		Thread.sleep(1000);
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
	
	
	
	public ConnectionsPage navigateToMyConnections()
	{				
		myConnections.click();	
		return (ConnectionsPage) openPage(ConnectionsPage.class);
//		new ConnectionsPage(driver, );
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
	
//	public EndorsementPage NaviagtingToMyEndorsements()
//	{
//		
//		myEndorsements.click();	
//		return (EndorsementPage) openPage(EndorsementPage.class);
////		new EndorsementPage(driver, );
//	}
	
	public MyAdvertisements NaviagtingToMyAdvertisements()
	{		
		scrollToElement(myAdvertisements);
		click(myAdvertisements,"My Advertisements");	
		return (MyAdvertisements) openPage(MyAdvertisements.class);
//		new MyProfilePage(driver, );
	}
	
	
	
	public MyProfilePage NaviagtingToMyProfilePage1()
	{
		myEndorsements.click();	
		return (MyProfilePage) openPage(MyProfilePage.class);
//		new MyProfilePage(driver, );
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
////		System.out.println("==============="+TagName+"===============");
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

 
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean verifySuccessLogin(){
		return new VerificationHelper(driver).isDisplayed(Toggledropdownmenu);
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

	
	
	
}
