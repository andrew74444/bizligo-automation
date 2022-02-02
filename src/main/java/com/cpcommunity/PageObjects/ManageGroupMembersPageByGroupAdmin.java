package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

public class ManageGroupMembersPageByGroupAdmin extends BasePage {

	@FindBy(xpath = "//div[@id='myNavbar']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
	//	updateClass(pageheader, "navbar-fixed-top");
	}

	@FindBy(xpath = "(//*[@type='search'])[1]")
	WebElement memberOutSearch;

	@FindBy(xpath = "(//*[@type='search'])[2]")
	WebElement memberinSearch;

	@FindBy(xpath = "//input[@id='selectAllCheckbox']")
	WebElement memberOutCheckBox;
	@FindBy(xpath = "//input[@id='selectAllCheckbox1']")
	WebElement memberInCheckBox;

	@FindBy(xpath = "//*[contains(text(),'Add')]")
	WebElement Add;

	@FindBy(xpath = "//*[contains(text(),'<- Remove')]")
	WebElement Remove;

	@FindBy(xpath = "//*[contains(text(),'Back')]")
	WebElement Back;

	@FindBy(xpath = "//span[normalize-space()='Remove Admin']")
	WebElement RemoveAdmin;

	@FindBy(xpath = "//*[contains(text(),'Make Admin')]")
	WebElement MakeAdmin;

	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;

	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement OkBth;

	@FindBy(xpath = "((//*[@class='col-md-5'])[2])//*[contains(text(),'Showing 1 to 1 of 1 entries')]")
	WebElement waitForTheSearchIn;

	@FindBy(xpath = "((//*[@class='col-md-5'])[1])//*[contains(text(),'Showing 1 to 1 of 1 entries')]")
	WebElement waitForTheSearchOut;

	@FindBy(xpath = "(//tbody)[2]/tr[1]/td[2]")
	WebElement Table2Row1;

	//@FindBy(xpath = "//*[contains(text(),'Add')]")
	
	@FindBy(xpath = "//div[@class='member-page-heading bg-info text-uppercase']")
	WebElement AddBtn;

	@FindBy(xpath = "//*[@id='CommunityUsersTable']/tbody/tr[2]/td[5]")
	WebElement email2;
	
	@FindBy(xpath = "//*[@id='CommunityUsersTable']/tbody/tr[1]/td[5]")
	WebElement email1;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(AddBtn);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	// public void addMember(String email) throws Exception{
	// new ManageMembers(driver).addmember(email);
	// }
	//
	// public void removeMember(String email) throws Exception{
	// new ManageMembers(driver).removeMember(email);
	// }
	// public void makeAdmin(String email) throws Exception{
	// new ManageMembers(driver).makeAdmin(email);
	// }
	// public void removeAdmin(String email) throws Exception{
	// new ManageMembers(driver).removeAdmin(email);
	// }

	public void clickOnYesProceed() throws Exception {
		waitForElementToPresent(YesProceed);

		click(YesProceed, "Yes, Proceed");
		waitForElementToPresent(OkBth);
		click(OkBth, "Ok Button");
	}

	public void memberOutSearch(String email) throws Exception {
		Thread.sleep(2000);
		memberOutSearch.clear();
		type(memberOutSearch, email, "Searching in members not joined");
		waitForElementToPresent(waitForTheSearchOut);
		Thread.sleep(10000);

	}

	public void memberInSearch(String email) throws Exception {

		Thread.sleep(2000);
		memberinSearch.clear();
		type(memberinSearch, email, "Searching in members joined");
		waitForElementToPresent(waitForTheSearchIn);
		Thread.sleep(10000);

	}

	public void memberInCheckBox() throws Exception {
		Thread.sleep(1000);

		click(memberInCheckBox, "Selecting Check box");

		while (true) {
			if (memberInCheckBox.isSelected()) {
				break;
			}
			click(memberInCheckBox, "Selecting Check box");
			Thread.sleep(3000);
		}

		Thread.sleep(1000);
	}

	public void memberOutCheckBox() throws Exception {

		Thread.sleep(2000);

		click(memberOutCheckBox, "Selecting Check box");

		Thread.sleep(2000);

	}

	public void addmember(String email) throws Exception {

		this.memberOutSearch(email);
		this.memberOutCheckBox();

		click(Add, "Add");
		this.clickOnYesProceed();
	}

	public void removeMember(String email) throws Exception {
		this.memberInSearch(email);
		this.memberInCheckBox();

		click(Remove, "Remove");
		this.clickOnYesProceed();
		Thread.sleep(5000);
	}

	public void makeAdmin(String email) throws Exception {
		this.memberInSearch(email);
		click(MakeAdmin, "Make Admin");
		this.clickOnYesProceed();
	}

	public void removeAdmin(String email) throws Exception {

		this.memberInSearch(email);
		click(RemoveAdmin, "Remove Admin");
		this.clickOnYesProceed();
	}

	@FindBy(xpath = "//*[contains(text(),'Please make another member as group admin to remove this member as group admin')]")
	WebElement makeAnotherMemberAsGroupAdmin;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okButton;

	public void checkMakeAnotherMemberAsAdmin(String email) throws Exception {

		//this.memberInSearch(email);
		//this.memberInCheckBox();
		waitForElementToPresent(RemoveAdmin);
		click(RemoveAdmin, "Remove Admin");
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");
		waitForElementToPresent(makeAnotherMemberAsGroupAdmin);
		click(okButton, "ok Button;");
	}

	public boolean ManageMembers(String email) throws Exception {
		this.addmember(email);
		this.makeAdmin(email);
		this.removeAdmin(email);
		this.removeMember(email);
		return true;

	}

	@FindBy(xpath = "//*[contains(text(),'Back')]")
	WebElement back;

	public MyGroupsPage backToMyGroups() {

		click(back, "back");

		return (MyGroupsPage) openPage(MyGroupsPage.class);
	}

	public CommunityDetailsPage backToCommunityDetailsPage() {

		click(back, "back");

		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}

	public String getMember1() {
		
		log.info(email1.getText());
		return email1.getText();	
	}
	
	public String getMember2() {
		
		log.info(email2.getText());
		return email2.getText();	
	}
	
	

}
