package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;




public class CommunityInviteMembersPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	
		aShot();
	}
	
	
	

	@FindBy(xpath = "//button[@id='btnInvite']")
	WebElement btnInvite;

	@FindBy(xpath = "//input[@type='search']")
	WebElement search;

	@FindBy(xpath = "//td[contains(@class,'select-checkbox')]")
	WebElement select_Checkbox;

	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OkBtn;
	
	 @FindBy(xpath="//*[contains(text(),'Showing 1 to 1 of 1 entries')]")
	 WebElement Showing1to1of1entries;

	@FindBy(xpath = "//*[contains(text(),'1 row selected')]")
	WebElement rowselected;
	
	@FindBy(xpath = "//*[contains(text(),'There are no members available.')]")
	WebElement noMembersAvailable;

	public void InviteMembers(String Email1, String Email2, String Email3, String Email4, String Email5, String Email6,
			String Email7) throws Exception {

		try {
			this.invite(Email1);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
			
		}
		
		try {
			this.invite(Email2);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
		}
		
		try {
			this.invite(Email3);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
		}
		
		try {
			this.invite(Email4);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
		}
		
		try {
			this.invite(Email5);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
		}
		
		try {
			this.invite(Email6);	
		} catch (Exception e) {
			picture();
			noMembersAvailable.isDisplayed();
		}
		
		try {
			this.invite(Email7);	
		} catch (Exception e) {
			 picture();
			 noMembersAvailable.isDisplayed();
		}
	}
	
	
	
	public void invite(String Email) throws Exception {
		
	//	search.clear();
		type(search, Email,"Search");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+Email+"')]"));
		waitForElementToPresent(ele);
		waitForElementToPresent(Showing1to1of1entries);
		click(select_Checkbox,"select_Checkbox");
	//	waitForElementToPresent(rowselected);
		click(btnInvite,"btnInvite" );
	//	picture();
		waitForElementToPresent(YesProceed);
		click(YesProceed,"Yes Proceed");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"Ok Btn");
	//	Thread.sleep(1000);
//		waitForElementToPresent(noMembersAvailable);
//		
//		search.clear();
		
		
	}
	

	public void InviteMembers(String Email1, String Email2, String Email3, String Email4
			 ) throws Exception {

		type(search, Email1,"Search");
		Thread.sleep(5000);
		click(select_Checkbox,"select_Checkbox");
//		Thread.sleep(1000);
		waitForElementToPresent(btnInvite);
		click(btnInvite,"btnInvite");
//		picture();
		waitForElementToPresent(YesProceed);
		click(YesProceed,"Yes Proceed");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"Ok Btn");
//		Thread.sleep(1000);
		driver.navigate().refresh();
		search.clear();

		type(search, Email2,"Search");
		Thread.sleep(5000);
		click(select_Checkbox,"select_Checkbox");
	//	Thread.sleep(1000);
		waitForElementToPresent(btnInvite);
		click( btnInvite,"btnInvite");
	//	picture();
		waitForElementToPresent(YesProceed);
		click( YesProceed,"Yes Proceed");
		waitForElementToPresent(OkBtn);
		click( OkBtn,"Ok Btn");
	//	Thread.sleep(1000);
		driver.navigate().refresh();
		search.clear();

		type(search, Email3,"Search");
		Thread.sleep(5000);
		click(select_Checkbox,"select_Checkbox");
//		Thread.sleep(1000);
		waitForElementToPresent(btnInvite);
		click(btnInvite,"btnInvite");
//		picture();
		waitForElementToPresent(YesProceed);
		click(YesProceed,"Yes Proceed");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"Ok Btn");
	//	Thread.sleep(1000);
		driver.navigate().refresh();
		search.clear();

		type(search, Email4,"Search");
		Thread.sleep(5000);
		click(select_Checkbox,"select_Checkbox");
	//	Thread.sleep(1000);
		waitForElementToPresent(btnInvite);
		click(btnInvite,"btnInvite");
	//	picture();
		waitForElementToPresent(YesProceed);
		click(YesProceed,"Yes Proceed");
		waitForElementToPresent(OkBtn);
		click(OkBtn,"Ok Btn");
	//	Thread.sleep(1000);
		search.clear();		

	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		
		return ExpectedConditions.visibilityOf(btnInvite);
	}

@FindBy(xpath="//*[@id='AllUsersTable']")
	WebElement info;
@FindBy(xpath="//*[@class='user-profile dropdown-toggle']")
WebElement dropDown;
@FindBy(xpath="//*[@class='LogOutNewAdmin']")
WebElement logout;
public HomePage logOut() {
	waitForElementToPresent(info);
	waitForElementToPresent(dropDown);
	clickElementByJavaScript(dropDown,"dropDown");
	waitForElementToPresent(logout);
	click(logout,"logout");
	return (HomePage) openPage(HomePage.class);
}
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
