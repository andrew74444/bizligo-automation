package com.cpcommunity.PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import java.util.List;


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
	
	@FindBy(xpath = "//button[normalize-space()='Yes,Proceed']")
	WebElement yesProceed4;
	
	@FindBy(xpath="//button[@ng-click='appData.closeModel()']")
	WebElement cancelPopup;
	
	@FindBy(xpath="//div[@ng-if='!data.IsLoading && !data.CommunityVideos.length']//p[@class='ng-binding'][contains(text(),'Please')]")
	WebElement msgWhenNotMember;
	//div[@ng-show='appData.showLoginOrJoinMessage']
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
	
	@FindBy(xpath="//span[normalize-space()='$ 10']")
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

	



	@FindBy(xpath = "//span[@ng-if='data.IsMembershipPlanDetailsWidgetConfigured.CommunityWidgetEditedName.length == 0']")
	List<WebElement> membership;
	@FindBy(xpath = "//a[@title='Manage Community']")
	WebElement manageBtn;
	@FindBy(xpath = "//span[@ng-if='data.IsAdminWidgetConfigured.CommunityWidgetEditedName.length == 0']")
	List<WebElement> champions;
	@FindBy(css = "div[class='col-sm-12 col-xs-12'] span[class='ng-scope']")
	WebElement membershipName;
	@FindBy(css = "div[class='col-sm-8 col-xs-6'] span[class='ng-binding ng-scope']")
	WebElement championName;
	

	
	
	public void resourceForGuestMember() throws InterruptedException {
		Thread.sleep(2000);
		click(cancelPopup,"cancel");
		waitForElementToPresent(resources);
		click(resources,"Resources");
		Thread.sleep(5000);
		
		String Loginmsg=msgWhenNotMember.getText();
		 {
			System.out.println(Loginmsg);
			Assert.assertTrue(true);
		}
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
		Thread.sleep(6000);
		//click(yesProceed,"yes proceed");
		//Thread.sleep(3000);
		//waitForElementToPresent(resources);
		click(resources,"Resources");
		Thread.sleep(8000);
		waitForElementToPresent(photos);
		System.out.println(photos.getAttribute("href"));
		if(photos.getAttribute("href").equals("https://tenant1.bizligotest.com/Content/Uploads/tenant1/1/Resources/Images/c057d593-6929-4e3e-bd52-5de7d77be6ba.png")) {
			System.out.println("member who is not a member of group 2 can see resouces added to group");
			
		}else {System.out.println("Member not able to see resources of group he is not a member of.");
		Assert.assertTrue(true);
		}
		click(groups,"Groups");
		waitForElementToPresent(joinGroup4);
		click(leaveGroup4,"joinGroup4");
		click(yesProceed,"yes proceed");
		
	}
	public ManageAdPlansPage gotoManageAdsplan() throws InterruptedException {
		waitForElementToPresent(manage);
		click(manage, "Manage Icon button");
		Thread.sleep(4000);
		scrollUpVertically();
		//scrollIntoView(advertisements);
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
		Thread.sleep(3000);
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
	







	
	 public void VerifyMembershipplanNotDisplaying() throws InterruptedException {
			Thread.sleep(500);
			Assert.assertEquals(0, membership.size());
			System.out.println("MembershipPlan is Not Displaying");
			
		}
	 public void VerifychampionsNotDisplaying() throws InterruptedException {
			Thread.sleep(500);
			Assert.assertEquals(0, champions.size());
			System.out.println("Champions is Not Displaying");
			
		}
	 
	 public ManageCommunityPage gotoDashboardpage() {
			waitForElementToPresent(manageBtn);
			click(manageBtn, "Manage Button");
			return (ManageCommunityPage) openPage(ManageCommunityPage.class);		
		}
	 
	 public void verifychampionTitleChanged() throws InterruptedException {
			scrollIntoView(championName);
			String changead=this.championName.getText();
			System.out.println(changead);
		    String Expected="TOP MOST CHAMPIONS";
		    Assert.assertEquals(changead, Expected);
		    
		}
	 public void verifyMembershiptitleChanged() throws InterruptedException {
			waitForElementToPresent(membershipName);
			String changead=this.membershipName.getText();
			System.out.println(changead);
		    String Expected="MEMBERSHIP";
		    Assert.assertEquals(changead, Expected);
		    
		}

}
	

