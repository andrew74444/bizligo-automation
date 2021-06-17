package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;


public class ManageGroupsPage extends BasePage{
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
		
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(Createbtn);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement Createbtn;
	
	@FindBy(xpath="//input[@placeholder='Search by Group Name']")
	WebElement SearchbyGroupName;

	@FindBy(xpath="(//*[contains(text(),'Search')])[2]")
	WebElement Search;
	
	//@FindBy(xpath="(//span[contains(text(),'Edit Group')]")
	@FindBy(xpath="(//button[@ng-click='data.EditGroup(Group.GroupID)'][1])")
	WebElement EditGroup;
	
	@FindBy(xpath="(//div[@ng-show='data.IsCommunityAdmin'][1]//a[@class='dropdown-toggle'])")
	WebElement ToggleEdit;
	
	@FindBy(xpath="(//div[@id='info-card-id']")
	WebElement Editmember;

	@FindBy(xpath="(//*[contains(text(),'Manage Members')])[2]")
	WebElement ManageMembers;

	@FindBy(xpath="//img[@height='15']")
	WebElement Menu;
	@FindBy(xpath = "(//div[@class='communities-box'])")
	List<WebElement> totalgroups;
	
	@FindBy(xpath = "(//div[@class='category-backgrouund'])[3]")
	WebElement CommunityBox;
	@FindBy(xpath = "(//*[contains(text(),' Leave')])")
	WebElement Leavebtn;
	@FindBy(xpath = "//button[contains(.,'Yes,Proceed')]")
	WebElement YesProceed;
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement Okbtn;
	@FindBy(xpath = "//*[contains(text(),'Please make another member as Community Admin to remove this member as Community Admin')]")
	WebElement makeAnotherAdminAlertMeassge;
	@FindBy(xpath = "//*[contains(text(),'\"Please make another member as Group Admin to leave from this Group.')]")
	WebElement makeAnothergroupAdminAlertMeassge;
	@FindBy(xpath = "//*[@class='swal2-container swal2-center swal2-fade swal2-shown']/div")
	WebElement makeAnotherAdminAlertPopUp;
	
	
	
	public void searchGroup(String GroupName) throws Exception {
		type(SearchbyGroupName, GroupName,"Search by Group Name");
		click(Search,"Search");
		Thread.sleep(5000);
		
	}
	
	public Create_UpdateGroupPage editGroup() throws Exception {
		click(ToggleEdit,"ToggleEdit");
		Thread.sleep(1000);
		waitForElementToPresent(EditGroup);
		click(EditGroup,"EditGroup");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
	}
	
	public ManageGroupMembersPage navigateToManageGroupMembers(String GroupName) throws Exception
	{
		this.searchGroup(GroupName);
		click(Menu,"Menu");
		waitForElementToPresent(ManageMembers);
		click(ManageMembers,"Manage Members");
		return (ManageGroupMembersPage) openPage(ManageGroupMembersPage.class);
//		new ManageGroupMembersPage(driver);
	}
	public void GroupCount() throws InterruptedException {
		//click(SearchBtn, "Search button");
		Thread.sleep(3000);
		System.out.println("total Groups are " + this.totalgroups.size());
		if(this.totalgroups.size()>0) {
			
		}
	}	
	
	public void LeaveGroup() throws InterruptedException {
		waitForElementToPresent(CommunityBox);
		click(CommunityBox, "Community Box");
		Thread.sleep(3000);
		waitForElementToPresent(Leavebtn);
		click(Leavebtn, "Leave button");
	}
	
	public Create_UpdateGroupPage clickOnCreateBtn(){
		//scrollToElement(Createbtn);
			click(Createbtn," Create Btn");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
		
	}
	public void checkProperAlertDisplayedWhenOnlyOneAdmin(String communityName) throws Exception {
		//this.searchCommunity(communityName+getDateInDDMMMYYYY());
		waitForElementToPresent(CommunityBox);
		click(CommunityBox, "Community Box");
		Thread.sleep(3000);
		click(Leavebtn, "leave");
		takeScreenshotByShutterBug(Leavebtn, "Leave Btn");
		waitForElementToPresent(YesProceed);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(Okbtn);
		takeScreenshotByShutterBug(Okbtn, "Ok");
		click(Okbtn, "Ok");
		picture();
		System.out.println("Ok button click");
		

				//"Please make another member as Group Admin to leave from this Group.");
		AssertionHelper.verifyText(makeAnotherAdminAlertMeassge.getText(),
				"Please make another member as Community Admin to remove this member as Community Admin");
		System.out.println("Assertion done");
	}
}
