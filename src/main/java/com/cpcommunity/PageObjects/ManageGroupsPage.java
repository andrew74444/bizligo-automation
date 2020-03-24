package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


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
	
	@FindBy(xpath="(//span[contains(text(),'Edit Group')]")
	WebElement editGroup;
	
	@FindBy(xpath="(//*[contains(text(),'Manage Members')])[2]")
	WebElement ManageMembers;
	
	
	
	

	@FindBy(xpath="//img[@height='15']")
	WebElement Menu;
	
	
	public void searchGroup(String GroupName) throws Exception {
		type(SearchbyGroupName, GroupName,"Search by Group Name");
		click(Search,"Search");
		Thread.sleep(5000);
		
	}
	
	public Create_UpdateGroupPage editGroup() throws Exception {
		click(Menu,"Menu");
		Thread.sleep(1000);
		click(editGroup,"editGroup");
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
	
	
	
	
	public Create_UpdateGroupPage clickOnCreateBtn(){
		scrollToElement(Createbtn);
		click(Createbtn," Create Btn");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
		
	}
}
