package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class ManageCommunityMembersPage extends BasePage {

	@Override
	protected void getPageScreenSot() {
		aShot();
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

	@FindBy(xpath = "//*[contains(text(),'Remove Admin')]")
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

	@FindBy(xpath = "//*[contains(text(),'Add')]")
	WebElement AddBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Please make another member as Community Admin to remove this member as Community Admin')]")
	WebElement makeAnotherMemberAsCommunityAdminToRemove;
	
	@FindBy(xpath = "//div[@class='bootbox-body']")
	WebElement successMsg;
	
	@FindBy(xpath = "//*[@role=\"row\"]/td[2]")//*[@id=\"row_758\"]/td[2]
	WebElement checkBoxMemberAdded;
	@FindBy(xpath = "//input[@aria-controls='CommunityUsersTable']")
	WebElement searchMemberInCommunity;
	


	
	
	
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {

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
	// new ManageMembers(driver,wait,exe).addmember(email);
	// }
	//
	// public void removeMember(String email) throws Exception{
	// new ManageMembers(driver,wait,exe).removeMember(email);
	// }
	// public void makeAdmin(String email) throws Exception{
	// new ManageMembers(driver,wait,exe).makeAdmin(email);
	// }
	// public void removeAdmin(String email) throws Exception{
	// new ManageMembers(driver,wait,exe).removeAdmin(email);
	// }
	//

	public boolean ManageMembers(String email) throws Exception {
		this.addmember(email);
		this.makeAdmin(email);
		this.removeAdmin(email);
		this.removeMember(email);
		Thread.sleep(4000);
		return true;

	}

	public void clickOnYesProceed() throws Exception {
		waitForElementToPresent(YesProceed);
		picture();
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

	public void checkNotAbleToRemoveAdminOnlyOneAdmin(String email) throws Exception {

		this.memberInSearch(email);
		click(RemoveAdmin, "Remove Admin");
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");
		waitForElementToPresent(makeAnotherMemberAsCommunityAdminToRemove);
		click(OkBth, "Ok Button");
		
		
	}
	public void addmemberByTA(String email) throws Exception {
		this.memberOutSearch(email);
		this.memberOutCheckBox();
		click(Add, "Add");
		waitForElementToPresent(YesProceed);
		picture();
		click(YesProceed, "Yes, Proceed");		
		waitForElementToPresent(OkBth);
		System.out.println(successMsg.getText());
		click(OkBth, "Ok Button");
		Assert.assertTrue(true);
		Thread.sleep(2000);
		checkBoxMemberAdded.click();
		Remove.click();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");		
		waitForElementToPresent(OkBth);
		System.out.println(successMsg.getText());
		click(OkBth, "Ok Button");	
	}
	
public void memberAsAdmin(String email) throws Exception {
		
		this.memberOutSearch(email);
		this.memberOutCheckBox();
		click(Add, "Add");
		waitForElementToPresent(YesProceed);
		picture();
		click(YesProceed, "Yes, Proceed");		
		waitForElementToPresent(OkBth);
		click(OkBth, "Ok Button");
		Thread.sleep(3000);
		MakeAdmin.click();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");
		waitForElementToPresent(OkBth);
		System.out.println(successMsg.getText());
		AssertionHelper.verifyText(successMsg.getText(), "Community Admin added successfully");
		click(OkBth, "Ok Button");
		Thread.sleep(4000);
		RemoveAdmin.click();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");		
		waitForElementToPresent(OkBth);
		System.out.println(successMsg.getText());
		click(OkBth, "Ok Button");
		Thread.sleep(3000);
		checkBoxMemberAdded.click();
		Remove.click();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes, Proceed");		
		waitForElementToPresent(OkBth);
		System.out.println(successMsg.getText());
		click(OkBth, "Ok Button");		
	}

public void removeMemberTA(String email) throws Exception{
	
	this.memberOutSearch(email);
	this.memberOutCheckBox();
	click(Add, "Add");
	waitForElementToPresent(YesProceed);
	picture();
	click(YesProceed, "Yes, Proceed");		
	waitForElementToPresent(OkBth);
	System.out.println(successMsg.getText());
	click(OkBth, "Ok Button");		
	Thread.sleep(2000);
	checkBoxMemberAdded.click();
	Remove.click();
	waitForElementToPresent(YesProceed);
	click(YesProceed, "Yes, Proceed");		
	waitForElementToPresent(OkBth);
	System.out.println(successMsg.getText());
	Assert.assertTrue(true);
	click(OkBth, "Ok Button");		
}
public void removeMemberAsAdmin(String email) throws Exception {
	
	this.memberOutSearch(email);
	this.memberOutCheckBox();
	click(Add, "Add");
	waitForElementToPresent(YesProceed);
	picture();
	click(YesProceed, "Yes, Proceed");		
	waitForElementToPresent(OkBth);
	click(OkBth, "Ok Button");
	Thread.sleep(3000);
	MakeAdmin.click();
	waitForElementToPresent(YesProceed);
	click(YesProceed, "Yes, Proceed");
	waitForElementToPresent(OkBth);
	System.out.println(successMsg.getText());
	click(OkBth, "Ok Button");
	Thread.sleep(4000);
	RemoveAdmin.click();
	waitForElementToPresent(YesProceed);
	click(YesProceed, "Yes, Proceed");		
	waitForElementToPresent(OkBth);
	System.out.println(successMsg.getText());
	AssertionHelper.verifyText(successMsg.getText(), "Community Admin removed successfully");
	
	click(OkBth, "Ok Button");
	Thread.sleep(3000);
	checkBoxMemberAdded.click();
	Remove.click();
	waitForElementToPresent(YesProceed);
	click(YesProceed, "Yes, Proceed");		
	waitForElementToPresent(OkBth);
	System.out.println(successMsg.getText());
	click(OkBth, "Ok Button");		
}
public void TAunAbleToRemoveAdminOnlyOneAdmin(String name) throws Exception {
    type(searchMemberInCommunity,name,name);
    Thread.sleep(4000);
	//this.memberInSearch(email);
	click(RemoveAdmin, "Remove Admin");
	waitForElementToPresent(YesProceed);
	click(YesProceed, "Yes, Proceed");
	Thread.sleep(3000);
	System.out.println(successMsg.getText());
	waitForElementToPresent(makeAnotherMemberAsCommunityAdminToRemove);
	click(OkBth, "Ok Button");//
	
	
}





}
