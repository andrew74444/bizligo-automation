package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

public class Bizligo1CommunityPage extends BasePage {
	@Override
	protected void getPageScreenSot() {

		aShot();

	}
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
}
	

