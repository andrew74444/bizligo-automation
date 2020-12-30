//package com.cpcommunity.PageObjects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.apache.log4j.Logger;
//
//import com.uiFramework.pamTen.cpcommunity.helper.assertion.VerificationHelper;
//
//
//
//
//
//public class MyDashboardPage extends BasePage{
//	
//	@FindBy(xpath = "//*[@id='header']")
//	WebElement pageheader;
//	@Override
//	protected  void getPageScreenSot() {
//	
//		updateClass(pageheader, "");
//		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
//	}
//		
//	@FindBy(xpath="//*[contains(text(),'Blog')]")
//	WebElement blog;
//	
//	@FindBy(xpath="//*[contains(text(),'My Advertisements')]")
//	WebElement myAdvertisements;
//	
//	
//	
//	@FindBy(xpath="//span[@title='Toggle dropdown menu']")
//	WebElement Toggledropdownmenu;
//	@FindBy (xpath="//*[@id='toast-container']/div/div[3]")
//	WebElement SuccessPopup;
//	
//	
//	//*************************************Endorsements**********************************
//	@FindBy (xpath = "//*[contains(text(),'My Endorsements')]")
//    WebElement myEndorsements;
//	
//	//*************************************Groups****************************************
//	@FindBy (xpath = "//*[contains(text(),'My Groups')]")
//    WebElement myGroups;
//	@FindBy(xpath="//a[@href='/groups/mygroups']//*[@class='huge']")
//	WebElement myGroupsCount;
//	//*************************************Connections***********************************
//	@FindBy (xpath="//*[contains(text(),'My Connections')]")
//	WebElement myConnections;
//	@FindBy(xpath="(//div[@class='huge'])[4]")
//	WebElement NewRequests;
//	
//	
//	
//	@FindBy(xpath="//a[@href='/communities/mycommunities']//*[@class='huge']")
//	WebElement totalcommunities;
//	
//	@FindBy(xpath="//a[@href='/communities/mycommunities']//*[@class='new-notifications bg-danger']")
//	WebElement unreadCommunities;
//	
//	
//	@FindBy(xpath="//*[contains(text(),'My Communities')]")
//	WebElement myCommunities;
//	
//	@FindBy(xpath="//div[@class='huge'])[1]")
//	WebElement totalCommmunitiesCount;
//	//************************************Messages***************************************
//	@FindBy (xpath = "//*[contains(text(),'My Messages')]")
//	WebElement myMessages;
//	@FindBy(xpath="//div[@class='huge'])[3]")
//	WebElement myMessagesCount;
//	
//	@FindBy (xpath="//button[contains(.,'New Message')]")
//	WebElement NewMessage;
//	
//	//***********************************LogOut******************************************
//
//	
//	@FindBy(xpath="//a[contains(text(),'Logout')]")
//	WebElement Logout;
//	//***********************************Member******************************************
//	@FindBy(xpath="//a[contains(text(),'Member Directory')]")
//	WebElement memberDirectory;
//	
//	@FindBy(xpath="//a[contains(text(),'Global Communities')]")
//	WebElement globalCommunities;
//	
//	
//	
//	@FindBy(xpath="//a[contains(text(),'My Profile')]")
//	WebElement myProfile;
//	
//	@FindBy(xpath="//a[contains(text(),'Manage Password')]")
//	WebElement ManagePassword;
//	@FindBy(xpath="//a[contains(text(),'Global Communities')]")
//	WebElement GlobalCommunities;
//	
//	
//	
//	//***********************************Messages******************************************
//	@FindBy (xpath="//textarea[@id='txtMsgContent']")
//	WebElement Messagefield;
//	
//	@FindBy (xpath="//button[contains(.,'Send')]")
//	WebElement SendBtn;
//	
//	
//	@FindBy(xpath="//button[contains(.,'New Message')]")
//	WebElement NewMessageBtn;
//	@FindBy(xpath="//textarea[@id='txtMsgContent']")
//	WebElement txtMsgContent;
//	//***************************************MyMatches**************************************
//	@FindBy(xpath="//div[contains(text(),'My Matches')]")
//	WebElement myMatches;
//	
//	
//	@FindBy(xpath="//a[contains(.,' Dashboard')]")
//	WebElement Dashboard;
//	@FindBy(xpath="//span[contains(text(),'Global Events')]")
//	WebElement globalEvents;
//	
//	
//	@FindBy(xpath="//a[contains(text(),'Upcoming Events')]")
//	WebElement upcomingEvents;
//	@FindBy(xpath="//a[contains(text(),'Past Events')]")
//	WebElement PastEvents;
//	
//	@FindBy(xpath="//a[contains(text(),'Global Careers')]")
//	WebElement GlobalCareers;
//	
//	
//	
//	
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		
//		log.info("---> DashBoard");
//		
//		return ExpectedConditions.visibilityOf(memberDirectory);
//	}
//
//	
////	public ZohoCRMPage gotoCRM() {
////		
////		click(crm,"CRM Link");
////		return () openPage(.class);
////	}
////	
////	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
//	
//	public int MyGroupsCount() {		
//		   String C = myGroupsCount.getText();
//	      int TC=Integer.parseInt(C);
//	      click( myGroups,"myGroups");	      
//	      return TC;		
//	}
//	
//	
//	public void openDashobardPage() {
//		
//	}
//	
//	
//	public GlobalCareers NavigateToGlobalCareers(){
//		click(GlobalCareers,"click");
//		return (GlobalCareers) openPage(GlobalCareers.class);
////				new GlobalCareers(driver, );
//	}
//	
//	public Messages NavigateToMyMessages(){
//		myMessages.click();
//		return (Messages) openPage(Messages.class);
////		new Messages(driver, );
//	}
//	
//	
//	public MyGroupsPage NavigatingToMyGroups()
//	{
//		click(myGroups,"myGroups");
//		return (MyGroupsPage) openPage(MyGroupsPage.class);
////		new MyGroupsPage(driver, );		
//	}
//	
////public int GoToMygroups(ExtentTest logger) throws Exception
////{
////
////}
//	
//	public GlobalCommunitesPage NaviagtingToGlobalCommunities() throws Exception
//	{
//	
//		click(Toggledropdownmenu,"Toggle drop down menu");
//		Thread.sleep(1000);
//		click(GlobalCommunities,"Global Communities");
//		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
////		new ChangePasswordPage(driver, );
//		
//	}
//	
//	
//	public ChangePasswordPage NaviagtingToManagePassword() throws Exception
//	{
//	
//		Toggledropdownmenu.click();
//		Thread.sleep(1000);
//		ManagePassword.click();
//		return (ChangePasswordPage) openPage(ChangePasswordPage.class);
////		new ChangePasswordPage(driver, );
//		
//	}
//	
//	
//	public MyDashboardPage navigateToMyDashBoard(){
//		click(Toggledropdownmenu,"Toggledropdownmenu");
//		waitForElementToPresent(Dashboard);
//		click(Dashboard,"Dashboard");		
//		return (MyDashboardPage) openPage(MyDashboardPage.class);
////		new MyDashboardPage(driver, );
//	}
//	
//	
//	
//	
//	public GlobalCommunitesPage naviagtingToGlobalCommunities() throws Exception
//	{
//		click(Toggledropdownmenu,"Toggledropdownmenu");
//		waitForElementToPresent(globalCommunities);
//		clickElementByJavaScript(globalCommunities);
//		Thread.sleep(1000);
//		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
////		new GlobalCommunitesPage(driver, );
//		
//	}
//	
//	public MyCommunitiesPage NaviagtingToMyCommunities() throws Exception
//	{
//		
//		clickElementByJavaScript(myCommunities);
//		Thread.sleep(1000);
//		return (MyCommunitiesPage) openPage(MyCommunitiesPage.class);
////		new MyCommunitiesPage(driver, );
//		
//	}
////	public int GoToMyCommunities(ExtentTest logger) throws InterruptedException {
////	
////	
////	
////	
////	js.executeScript("arguments[0].scrollIntoView(true);",Communities);
//// String C = TotalCommmunities.getText();
//// int TC=Integer.parseInt(C);
//// Utility.highLightElement(driver, Communities);
//// Communities.click();
//// return TC;
////}	
////	
//	
//	
//	public MyProfilePage NaviagtingToMyProfilePage() throws Exception
//	{
//	
//		Toggledropdownmenu.click();
//		Thread.sleep(1000);
//		myProfile.click();
//		return (MyProfilePage) openPage(MyProfilePage.class);
////		new MyProfilePage(driver, );
//		
//	}
//	public GlobalMembersPage navigateToGlobalMembers()
//	{
//			
//		memberDirectory.click();
//		return (GlobalMembersPage) openPage(GlobalMembersPage.class);
////		new GlobalMembersPage(driver, );
//	}
//	
//	
//	
//	public ConnectionsPage navigateToMyConnections()
//	{				
//		myConnections.click();	
//		return (ConnectionsPage) openPage(ConnectionsPage.class);
////		new ConnectionsPage(driver, );
//	}
//	
//	public void ClickOnGlobalEvents()
//	{				
//		moveToElement(globalEvents);
////		click(globalEvents,"Global Events");		
//	}
//	public UpcomingEventsPage GoToUpComingEvents()
//	{
//		
//		this.ClickOnGlobalEvents();		
//		waitForElementToPresent(upcomingEvents);
//		click(upcomingEvents,"Upcoming Events");
//		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
////		new UpcomingEventsPage(driver, );
//	}
//	
//	
////	public PastEventsPage ClickOnPastEvents()
////	{
////		this.ClickOnGlobalEvents();
////		waitHelper.waitForElement(PastEvents,100);
////		
////		PastEvents.click();	
////		return () openPage(.class);
////		new PastEventsPage(driver, );
////	}
//	
//	public HomePage logout() throws Exception
//	{
//		Toggledropdownmenu.click();
//		Thread.sleep(500);
//		waitForElementToPresent(Logout);
//		Logout.click();
//		return (HomePage) openPage(HomePage.class);
////		new HomePage(driver, );
//	}
//	
////	public EndorsementPage NaviagtingToMyEndorsements()
////	{
////		
////		myEndorsements.click();	
////		return (EndorsementPage) openPage(EndorsementPage.class);
//////		new EndorsementPage(driver, );
////	}
//	
//	public MyAdvertisements NaviagtingToMyAdvertisements()
//	{		
//		scrollToElement(myAdvertisements);
//		click(myAdvertisements,"My Advertisements");	
//		return (MyAdvertisements) openPage(MyAdvertisements.class);
////		new MyProfilePage(driver, );
//	}
//	
//	
//	@FindBy(xpath="//*[contains(text(),'Posts')]")
//	WebElement posts;
//	
//	public BlogsPage goToBlogsPage() {
//		 click(blog,"blog");
//		 
//		 
//		 return (BlogsPage) openPage(BlogsPage.class);
//			
//		}
//	
//	public MyProfilePage NaviagtingToMyProfilePage1()
//	{
//		
//		
//		myEndorsements.click();	
//		return (MyProfilePage) openPage(MyProfilePage.class);
////		new MyProfilePage(driver, );
//	}
//	
//	
//	
//	
// 
//// public void Groups(ExtentTest logger) throws InterruptedException
//// {
//// 	JavascriptExecutor js = (JavascriptExecutor) driver;
//// 	WebDriverWait wait = new WebDriverWait(driver, 20);
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Groups')]")));
////		Thread.sleep(2000);
//// 	WebElement Grp = GroupsViewDetails;
////     js.executeScript("arguments[0].scrollIntoView(true);",Grp);
////     Utility.highLightElement(driver, GroupsViewDetails);
////     GroupsViewDetails.click();
//// }
//// public void AcceptConnectionRequest(String SenderMemberName,ExtentTest logger) throws InterruptedException
//// {
//// 	WebDriverWait wait=new WebDriverWait(driver, 20);
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
//// 	ConnectionsLink.click();
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(.,'My Connections')]")));
//// 	Thread.sleep(2000);
//// 	String TotalRequestsMessage = NewRequests.getText();
//// 	String[]  TRS = TotalRequestsMessage.split("\\s");
//// 	int TotalRequests=Integer.parseInt(TRS[0]);    	
//// 	for(int i=1;i<=TotalRequests;i++)
//// 	{
//// 		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
////     	if(MemberName.equalsIgnoreCase(SenderMemberName))
////     	{
////     		driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[1]")).click();
////     	}
////     	
////     	else {
////     		logger.log(LogStatus.FAIL,"Member request is not Processed");
////     	}
////     	}
////     	
////     	
////     }
//// public void RejectConnectionRequest(String SenderMemberName, ExtentTest logger) throws InterruptedException
//// {
//// 	WebDriverWait wait=new WebDriverWait(driver, 20);
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
//// 	ConnectionsLink.click();
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(.,'My Connections')]")));
//// 	Thread.sleep(2000);
//// 	String TotalRequestsMessage = NewRequests.getText();
//// 	String[]  TRS = TotalRequestsMessage.split("\\s");
//// 	int TotalRequests=Integer.parseInt(TRS[0]);    	
//// 	for(int i=1;i<=TotalRequests;i++)
//// 	{  		                                                                                                          
//// 		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
//// 		if(MemberName.equalsIgnoreCase(SenderMemberName))
//// 		{
//// 			driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[4]/button[2]")).click();
//// 		}
//// 	}     
//// 	Utility.WaitForElementToVisible(driver, "//h1[contains(.,'My Connections')]");
//// 	
//// 	try {
//// 		for(int i=1;i<=TotalRequests;i++)
////     	{  		                                                                                                          
////     		String MemberName = driver.findElement(By.xpath("//*[@id='removeinnercss']/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div["+i+"]/div/div[2]/strong/a")).getText();
////     		if(MemberName.equalsIgnoreCase(SenderMemberName))
////     		{
////     			logger.log(LogStatus.FAIL,"Member request is not Rejected");
////     		}
////     	}
////		} catch (Exception e) {
////			logger.log(LogStatus.PASS,"Member Reject request is Processed");
////		}
//// 	
//// 	
//// }
//// 
//// 
////public void navigateToDashboadPage() throws Exception
////{	
////	Utility.WaitForElementToVisible(driver, WelcomemenuDropDown);
////	Utility.highLightElement(driver, Welcomemenu);
////	Welcomemenu.click();
////	Thread.sleep(1000);
////	Utility.highLightElement(driver, Dashboard);
////	Dashboard.click();
////	Thread.sleep(4000);
////}
////
////
////public void NavigateToMessages(String connectRecieverEmailID, String connectReciverEmailPwd,
////		String senderMemberName, String message1, String appUrl,String ConnectSenderEmailID,
////		String ConnectSenderPwd, String message2,String recieverMemberName, ExtentTest logger) throws Exception{
////	
////	
////	LoginPagejava Login_Page = new LoginPagejava (driver);
////	Login_Page.login(connectRecieverEmailID, connectReciverEmailPwd, logger);
////	WebDriverWait wait=new WebDriverWait(driver, 20);
////	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(MenuDropDown)));
////	Thread.sleep(3000);
////	//String dateName = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss").format(new Date());
////	DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//// Date date = new Date();
////	String Message = message1+" "+dateFormat.format(date);
////	MessagesLink.click();
////	Thread.sleep(6000);
////	NewMessageBtn.click();
////	Thread.sleep(2000);
////	driver.findElement(By.xpath("//span[contains(.,'"+senderMemberName+"')]")).click();
////	Thread.sleep(2000);
////	txtMsgContent.sendKeys(Message);
////	SendBtn.click();
////	Thread.sleep(3000);
////	Utility.highLightElement(driver, driver.findElement(By.xpath("//p[contains(.,'"+Message+"')]")));
////	Thread.sleep(1000);
////	
////	List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
////	String i = Integer.toString(elements.size());
////	String SharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+i+"]/div[2]/p")).getText();	
////	SoftAssert softAssertion= new SoftAssert();
////	softAssertion.assertEquals(SharedMessage, Message);
////	softAssertion.assertAll();
////	driver.manage().deleteAllCookies();
////	driver.get(appUrl);
////	Login_Page.login(ConnectSenderEmailID, ConnectSenderPwd, logger);
////	Date date1 = new Date();
////	String ReplyMessage = message2+" "+dateFormat.format(date1);
////	MessagesLink.click();
////	Thread.sleep(6000);
////	NewMessageBtn.click();
////	Thread.sleep(2000);
////	driver.findElement(By.xpath("//span[contains(.,'"+recieverMemberName+"')]")).click();
////	Thread.sleep(2000);
////	txtMsgContent.sendKeys(ReplyMessage);
////	SendBtn.click();
////	Thread.sleep(3000);
////	Utility.highLightElement(driver, driver.findElement(By.xpath("//p[contains(.,'"+ReplyMessage+"')]")));
////	Thread.sleep(1000);
////	
////	List<WebElement> elements1 = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
////	String j = Integer.toString(elements1.size());
////	String ReplySharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+j+"]/div[2]/p")).getText();	
////	
////	softAssertion.assertEquals(ReplySharedMessage, ReplyMessage);
////	softAssertion.assertAll();
////	
////	
////     
////	   	        
//////			
//////	   	     for(WebElement el:elements)
//////	 		{	
//////		String Message1 =el.getText();
//////		System.out.println(Message1);
//////		String TagName=el.getTagName();
//////		System.out.println("==============="+TagName+"===============");
//////		//System.out.println(el.getTagName()+": "+el.getText());
//////		
//////	 		}
//////	
////	
////}
//// 
//// 
//// 
////
//// public void SelectMember(String MemberName, ExtentTest logger) throws InterruptedException
//// {
//// 	WebDriverWait wait=new WebDriverWait(driver, 20);
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(.,'"+MemberName+"')]")));
//// 	driver.findElement(By.xpath("//span[contains(.,'"+MemberName+"')]")).click();
//// 	Thread.sleep(2000);
//// }
//// public void SendMessage(String Message,ExtentTest logger) throws InterruptedException
//// {
//// 	WebDriverWait wait=new WebDriverWait(driver, 20);
//// 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Msgfield)));
//// 	Messagefield.sendKeys(Message);
//// 	SendBtn.click();
//// 	Thread.sleep(2000);
//// 	SoftAssert SA = new SoftAssert();
//// 	SA.assertEquals(driver.findElement(By.xpath("//p[contains(.,'"+Message+"')]")), Message);
//// 	SA.assertAll();
//// 	Thread.sleep(2000);
//// }
//
////	public void AllCommunities(ExtentTest logger)
////	{
////		WebDriverWait wait = new WebDriverWait(driver, 20);
//// 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WelcomemenuDropDown)));
//// 	Utility.highLightElement(driver, AllCommunities);
////		AllCommunities.click();
////	}
//
// 
// 
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public boolean verifySuccessLogin(){
//		return new VerificationHelper(driver).isDisplayed(Toggledropdownmenu);
//	}
//
//
//	
//
//
//	public String totalCommunitiesCount() {
//		return totalcommunities.getText();
//		
//	}
//	
//	public int totalGroupsCount() {
//		
//		return stringToInt(myGroupsCount.getText());
//		
//	}
//	
//	
//
//
//	public void checkUnreadCountIsDisplayed() {
//		unreadCommunities.isDisplayed();
//		
//	}
//	
////	public void logExtentReport(String s1){
////		TestBase.test.log(Status.INFO, s1);
////	}
//
////	public CommunityDetailsPage navigateToCommunityDetailsPage(String communityName) {
////		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+communityName+"')]"));
////		JavaScriptHelper js = JavaScriptHelper;
////		js.clickElement(ele);
////		
////		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
//////		new CommunityDetailsPage(driver, );
////	}
//
//	
//	
//	
//}
