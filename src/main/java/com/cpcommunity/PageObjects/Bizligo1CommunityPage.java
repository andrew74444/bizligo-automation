package com.cpcommunity.PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class Bizligo1CommunityPage extends BasePage {
	@Override
	protected void getPageScreenSot() {

		aShot();//

	}//checking github
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		waitForElementToPresent(SheTek);
		return ExpectedConditions.visibilityOf(SheTek);
	}
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@alt='Bizligo']")
	WebElement SheTek;
	 
	@FindBy(xpath = "//span[normalize-space()='Resources']")
	WebElement resources;
	
	@FindBy(xpath = "//div[3]//div[1]//div[5]//dir-pagination-controls[1]//ul[1]//li[4]//a[1]")
	WebElement clickVideo2;
	
	@FindBy(xpath = "//h4[normalize-space()='Covid 19 Video']")
	WebElement updatedVideo;
	
	@FindBy(xpath = "//span[normalize-space()='Groups']")
	WebElement groups;
	
	@FindBy(xpath = "//div[@id='MainContainer']//div[@class='row']//div[1]//a[1]")
	WebElement photos;
	
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]//strong[1]")
	WebElement leaveGroup4;
	
	@FindBy(xpath = "//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//button[1]//strong[1]")
	WebElement joinGroup4;
	
	@FindBy(xpath = "//i[@class='fa fa-check']")
	WebElement yesProceed;
	
	@FindBy(xpath="//button[@ng-click='appData.closeModel()']")
	WebElement cancelPopup;
	
	@FindBy(xpath="//div[@ng-show='appData.showLoginOrJoinMessage']")
	WebElement msgWhenNotMember;
	//a[@title='Manage Community']
	@FindBy(xpath="//a[@title='Manage Community']")//a[@title='Manage Community']
	WebElement manage;
	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
	@FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;
	@FindBy(xpath = "//a[normalize-space()='Donate']")
	WebElement donateBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Proceed']")
	WebElement proceed;
	
	@FindBy(xpath = "//a[normalize-space()='Donate']")
	List<WebElement> donateBtns;
	
	@FindBy(xpath = "//p[@ng-bind-html='data.DonationConfigInfo.DonationPurpose | renderHTMLCorrectly | addTargetBlank']")
	WebElement purpose;
	@FindBy(xpath="//span[normalize-space()='$ 20']")
	WebElement $20;
	
	@FindBy(xpath="//button[2]//span[1]")
	WebElement $10;
	
	@FindBy(xpath="//button[normalize-space()='Other Amount']")
	WebElement otherAmount;
	
	@FindBy(xpath="//input[@value='2']")
	WebElement authorizeBtn;
	 
	@FindBy(xpath="//input[@value='2']")
	List<WebElement> authorizeBtns;
	
	@FindBy(xpath="//ng-repeat[1]//li[1]//label[1]//input[1]")
	List<WebElement> paypalBtns;
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailID;
	
	@FindBy(xpath="//input[@id=\"cardNum\"]")
	WebElement CCnumber;
	
	@FindBy(xpath="//*[@id=\"expiryDate\"]")
	WebElement expDate;
	
	@FindBy(xpath="//*[@id=\"PaymentController\"]/div/div[1]/div/h4")//h4[normalize-space()='Success!']
	WebElement successUponPayment;
		
	@FindBy(xpath = "//button[normalize-space()='Pay through Checkout']")
	WebElement payThroughCheckout;
	
	@FindBy(xpath="//*[@id=\"payBtn\"]")
	WebElement payBtn;
	@FindBy(xpath="//span[normalize-space()='Events']")
	WebElement events;
	
	@FindBy(xpath="//strong[normalize-space()='CSS - Training']")
	WebElement eventName;
	@FindBy(xpath="//strong[normalize-space()='2nd CSS - Training']")
	WebElement eventName2;
	@FindBy(xpath="//a[@ui-sref='community.member']")
	WebElement member;
	@FindBy(xpath="//input[@id='memberName']")
	WebElement searchByMember;
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchBtn;
	@FindBy(xpath="//button[normalize-space()='Connect']")
	WebElement connect;
	@FindBy(xpath="//button[normalize-space()='Send']")
	WebElement send;
	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElement toastMessage;
	@FindBy(xpath = "//span[@ ng-bind=\"member.MemberName | limitTo:14\"]")
	WebElement memberName;
	@FindBy(xpath = "//button[normalize-space()='Cancel Request']")
	WebElement cancelConnectionReq;
	@FindBy(xpath = "//span[@class='label label-warning connected-btn']")
	WebElement pendingBtn;
	@FindBy(xpath = "//span[@ng-bind='group.GroupName'][normalize-space()='Group 2']")
	WebElement group2;
	@FindBy(xpath = "//span[normalize-space()='Members']")
	WebElement memberGroup;//input[@placeholder='Search Members...']
	@FindBy(xpath = "//input[@placeholder='Search Members...']")
	WebElement searchGroupMember;
	@FindBy(xpath = "//span[contains(text(),'Groups')]")
	WebElement Groups;
	@FindBy(xpath = "//span[@ng-bind=\"approvedMember.FullName | limitTo:14\"]")
	WebElement memberGroupName;
	@FindBy(xpath = "//button[contains(text(),'Cancel Request')]")
	WebElement cancelConnectReq;
	@FindBy(xpath = "//i[@class='fa fa-link']")
	WebElement connectLinkIcon;
	@FindBy(xpath = "//span[@ng-bind=\"member.EmailAddress | limitTo:27\"]")
	WebElement memberEmail;
	@FindBy(xpath = "//span[@ng-bind=\"member.Phone\"]")
	WebElement memberPhone;
	@FindBy(xpath = "//textarea[@id='ConnectionNoteArea']")
	WebElement addNote;
	@FindBy(xpath = "//a[@ng-click=\"data.redirectToMenu('group');\"]")
	WebElement group;
	@FindBy(xpath = "//label[normalize-space()='Add Note :']")
	WebElement addNotePopUp;
	@FindBy(xpath = "//button[normalize-space()='Close']")
	WebElement closeConnectionPopUp;
	
	
	
	



	


	
	
	public void resourceForGuestMember() throws InterruptedException {
		Thread.sleep(2000);
		click(cancelPopup,"cancel");
		waitForElementToPresent(resources);
		click(resources,"Resources");
		System.out.println(msgWhenNotMember.getText());
		
		if(msgWhenNotMember.getText().equalsIgnoreCase("Join the community or login if you are already a member")) {
			Assert.assertTrue(true);
			System.out.println("Guest member cannot see resources");
		}else Assert.assertTrue(false);
	}
	public void checkResourceUpdate(String Description) {
		click(resources,"Resources");
		waitForElementToPresent(clickVideo2);
		click(clickVideo2,"click 2");
		waitForElementToPresent(updatedVideo);
		System.out.println(updatedVideo.getText());
		if(Description.equalsIgnoreCase(updatedVideo.getText())) {
			System.out.println("UPdated Resource is visible by member");
			Assert.assertTrue(true);
		}else System.out.println("Updated resource not visible by member");
		
	}
	
	public void checkgroupResource() {
		waitForElementToPresent(resources);
		click(resources,"Resources");
		waitForElementToPresent(photos);
		System.out.println(photos.getAttribute("href"));
		if(photos.getAttribute("href").equals("https://tenant1.bizligotest.com/Content/Uploads/tenant1/1/Resources/Images/c057d593-6929-4e3e-bd52-5de7d77be6ba.png")) {
			System.out.println("member who is not a member of group 2 can see resouces added to group");
			
		}else {System.out.println("Member not able to see resources of group he is not a member.");
		Assert.assertTrue(true);
		}
		
	}
	
	public void resourceWhenLeftGroup() throws InterruptedException {
		waitForElementToPresent(groups);
		click(groups,"Groups");
		waitForElementToPresent(leaveGroup4);
		click(leaveGroup4,"leaveGroup4");
		Thread.sleep(3000);
		//click(yesProceed,"yes proceed");
		Thread.sleep(5000);
		//waitForElementToPresent(resources);
		click(resources,"Resources");
		Thread.sleep(5000);
		waitForElementToPresent(photos);
		System.out.println(photos.getAttribute("href"));
		if(photos.getAttribute("href").equals("https://tenant1.bizligotest.com/Content/Uploads/tenant1/1/Resources/Images/c057d593-6929-4e3e-bd52-5de7d77be6ba.png")) {
			System.out.println("member who is not a member of group 2 can see resouces added to group");
			
		}else {System.out.println("Member not able to see resources of group he is not a member of.");
		Assert.assertTrue(true);
		}
		click(groups,"Groups");
		waitForElementToPresent(joinGroup4);
		click(joinGroup4,"joinGroup4");
		click(yesProceed,"yes proceed");
		
	}
	public ManageAdPlansPage gotoManageAdsplan() {
		waitForElementToPresent(manage);
		click(manage, "Manage Icon button");
		scrollIntoView(advertisements);
		click(advertisements, "advertisements");
		waitForElementToPresent(managePlans);
		click(managePlans, "Manage Plans");
		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
	}
	public void checkUpdatedDonation(String Purpose) throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		if(purpose.getText().equalsIgnoreCase(Purpose)) {
			Assert.assertTrue(true);
			System.out.println("Updated Purpose visible on CA donation page");
		}
	}
	public void CAcanMakeDonation() throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(8000);
		click($10,"$10");
		click(authorizeBtn,"pay through Authorize.net");
		click(payThroughCheckout,"Pay");
		Thread.sleep(6000);
		switchToFrameByID(0);
		waitForElementToPresent(CCnumber);
		type(CCnumber,"4111 1111 1111 1111","card number");
		type(expDate,"12/222","Expiry date of CC");
		type(emailID,"ravi.pujari@xyz.com","email");
		Thread.sleep(2000);
		click(payBtn,"Pay");
		Thread.sleep(10000);
		System.out.println(successUponPayment.getText());
		if(successUponPayment.getText().equalsIgnoreCase("Success!")) {
			Assert.assertTrue(true);
		}
	}
	public void otherOptionAvailable() throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		if(otherAmount.getText().equalsIgnoreCase("Other amount")) {
			Assert.assertTrue(true);
			System.out.println("Other amount visible if TA made custom payment available");
		}
		
	}
	public void makeDonationWhenTAdisablePayment() throws InterruptedException{
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		click($10,"$10");
	
	}
	public void checkAuthorizeGatewayWhenInactivate() throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		click($10,"$10");
		if(authorizeBtns.size()>0) {
			System.out.println("Authorize.net payment gateway  displayed when TA inactivate it");
		}else System.out.println("Authorize.net payment gateway not displayed when TA inactivate it");
		
	}
	public void checkDonationWhenInactivated() {
		if(donateBtns.size()>0) {
			System.out.println("Donation button still available");
			
		}else System.out.println("Donation button not available when donation disabled byTA ");
	}
	public void checkDonationWhenActivated() {
		if(donateBtns.size()>0) {
			System.out.println("Donation button available when TA activate donations");
			Assert.assertTrue(true);			
		}
		else {
			System.out.println("Donation button not available when donation disabled byTA ");
		Assert.assertTrue(false);
		}
		
	}
	public void donationInEventsPage() throws InterruptedException {
		click(events,"Events");
		Thread.sleep(4000);
		click(eventName,"Event upcoming");
		if(donateBtns.size()>0) {
			System.out.println("Donation button available on events page when TA activate donations for a particular community ");
			Assert.assertTrue(true);			
		}
		else {
			System.out.println("Donation button not available on events page when donation disabled byTA ");
		Assert.assertTrue(false);
		}
		
		}
	public void checkNewTabForExternalDonation() throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		waitForElementToPresent(proceed);
		click(proceed,"Proceed");
		String parent=driver.getWindowHandle();
        System.out.println(parent);
		Set<String>s=driver.getWindowHandles();
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
        String childwindow=driver.switchTo().window(child_window).getTitle();
		System.out.println(driver.switchTo().window(child_window).getTitle());
		if(childwindow.contains("PayPal")) {
			System.out.println("New Tab for Payment opens up");
			Assert.assertTrue(true);
		}

		driver.close();
		}

		}
		//switch to the parent window
		driver.switchTo().window(parent);//Send Money, Pay Online or Set Up a Merchant Account - PayPal CA
			
	}
	public void checkPaypalGatewayWhenInactivate() throws InterruptedException {
		click(donateBtn,"Donation");
		Thread.sleep(3000);
		click($10,"$10");
		if(paypalBtns.size()>0) {
			System.out.println("PayPal payment gateway  displayed when TA inactivate it");
		}else System.out.println("PayPal payment gateway not displayed when TA inactivate it");
		
	}
	public void sendConnectionToMember(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(3000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		waitForElementToPresent(connect);
		click(connect,"Connect");
		click(send,"Send Connect request");
		Thread.sleep(4000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request from community");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		waitForElementToPresent(memberName);
		click(memberName,"Member Name");
		waitForElementToPresent(cancelConnectionReq);
		click(cancelConnectionReq,"Cancel connection");
		
	}
	public void checkConnectionStatus(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		click(send,"Send Connect request");
		Thread.sleep(4000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request from community");			
		}
		waitForElementToPresent(memberName);
		System.out.println(pendingBtn.getText());
		if(pendingBtn.getText().equalsIgnoreCase("pending")) {
			System.out.println("Status of connection is pending");
		}
		Thread.sleep(3000);
		click(Groups,"Groups");
		Thread.sleep(5000);
		click(group2,"Group 2");
		click(memberGroup,"Members");
		Thread.sleep(9000);
		type(searchGroupMember,Name,"Name of member");
		Thread.sleep(3000);
		click(searchBtn,"Search");
		Thread.sleep(3000);
		System.out.println(pendingBtn.getText());
		if(pendingBtn.getText().equalsIgnoreCase("pending")) {
			System.out.println("Status of connection in groups is pending");
			System.out.println("Status is showing as pending in both community and groups for same member");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		click(memberGroupName,"Member Name");
		Thread.sleep(2000);
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        Thread.sleep(5000);

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                System.out.println("waiting");
	        		clickElementByJavaScript(cancelConnectReq);
	                }
	        }
		
	}
	public void cancelConnectrequest(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(9000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(9000);
		click(searchBtn,"search");
		waitForElementToPresent(connect);
		click(connect,"Connect");
		click(send,"Send Connect request");
		Thread.sleep(4000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request from community");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		waitForElementToPresent(memberName);
		click(memberName,"Member Name");
		waitForElementToPresent(cancelConnectionReq);
		click(cancelConnectionReq,"Cancel connection");
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(9000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(9000);
		click(searchBtn,"search");
		waitForElementToPresent(connect);
		if(connect.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Connection status is again Connect");
		}
		
	}
	public void connectionRequestToMember(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		click(send,"Send Connect request");
		Thread.sleep(4000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request from community");			
		}
		
	}
	public void checkStatusWhenMemberCancel(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		if(connect.isDisplayed()) {
			System.out.println("If member rejects connection request Connect symbol is seen on member template");
		}
		
	}
	public void checkConnectedIconOnMember(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		if(connectLinkIcon.isDisplayed()) {
			System.out.println("Link icon is present on connected members");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		
	}
	public void memberIsPrivate(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		if(memberEmail.isDisplayed()&&memberPhone.isDisplayed()) {
			System.out.println("Member if private , email and phone is dispalyed");
		}else {
			System.out.println("Member if private, email and phone is not displayed on member card");
			Assert.assertTrue(true);
		}
		
	}
	public void memberDetailsCommunityAndGroup(String Name) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		if(memberEmail.isDisplayed()&&memberPhone.isDisplayed()) {
			System.out.println("Email and Phone of member is dispalyed in Community details");
		}
		click(Groups,"Groups");
		Thread.sleep(5000);
		click(group2,"Group 2");
		click(memberGroup,"Members");
		Thread.sleep(9000);
		type(searchGroupMember,Name,"Name of member");
		Thread.sleep(3000);
		click(searchBtn,"Search");
		Thread.sleep(3000);
		if(memberEmail.isDisplayed()&&memberPhone.isDisplayed()) {
			System.out.println("Email and Phone of member is dispalyed in Groups also");
		}		
		
	}
	public void sendingConnectionAddingNotes(String Name, String Notes) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		type(addNote,Notes,"Notes");
		click(send,"Send Connect request");
		Thread.sleep(6000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request after adding notes");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		waitForElementToPresent(memberName);
		click(memberName,"Member Name");
		waitForElementToPresent(cancelConnectionReq);
		click(cancelConnectionReq,"Cancel connection");
		Thread.sleep(3000);
		click(group,"Groups");
		Thread.sleep(5000);
		click(group2,"Group 2");
		click(memberGroup,"Members");
		Thread.sleep(9000);
		type(searchGroupMember,Name,"Name of member");
		Thread.sleep(6000);
		click(searchBtn,"Search");
		Thread.sleep(3000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		type(addNote,Notes,"Notes");
		click(send,"Send Connect request");
		Thread.sleep(6000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request after adding notes from Groups");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		//waitForElementToPresent(memberName);
		click(memberGroupName,"Member Name");
		Thread.sleep(3000);
		 String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> iterator = allWindowHandles.iterator();
	        Thread.sleep(5000);

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        while (iterator.hasNext()) {
	            String ChildWindow = iterator.next();
	                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                System.out.println("waiting");
	        		clickElementByJavaScript(cancelConnectReq);
	                }
	        }
		
	}
	public void sendingConnectionWithNotes(String Name, String Notes) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		type(addNote,Notes,"Notes");
		click(send,"Send Connect request");
		Thread.sleep(6000);
		System.out.println(toastMessage.getText());
		if(toastMessage.getText().equalsIgnoreCase("Connection request has been sent.")) {
			System.out.println("Member Able to Send request after adding notes");			
		}
	}
	public void checkAddNotesAppearWhenConnect(String Name, String Notes) throws InterruptedException {
		click(member,"Member");
		Thread.sleep(6000);
		type(searchByMember,Name,"Name of member to connect");
		Thread.sleep(6000);
		click(searchBtn,"search");
		Thread.sleep(4000);
		waitForElementToPresent(connect);
		click(connect,"Connect");
		Thread.sleep(2000);
		if(addNotePopUp.getText().contains("Add Note")) {
		System.out.println("Add note pops up when clicking connect on member profile");
		Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		click(closeConnectionPopUp,"close pop up");
	}
	public EventDetailsPage goToPaidEvent() throws InterruptedException {
		click(events,"Events");
		Thread.sleep(7000);
		click(eventName2,"Event upcoming");
		return (EventDetailsPage) openPage(EventDetailsPage.class);
	}



}//
	

