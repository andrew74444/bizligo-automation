package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
     
	@FindBy(xpath="//select[@ng-model='data.SearchData.StatusID']")
	WebElement SearchByStatus;

	@FindBy(xpath="(//*[contains(text(),'Search')])[2]")
	WebElement Search;
	
	@FindBy(xpath="//i[@class='fa fa-pencil-square-o']")
	WebElement editGroup;
	
	@FindBy(xpath="(//*[contains(text(),'Manage Members')])[2]")
	WebElement ManageMembers;
	
	@FindBy(xpath="//span[normalize-space()='4']")
	WebElement NumberOnCommunityDisplayCard;
	
	@FindBy(xpath="//span[normalize-space()='BDMAI Mumbai']")
	WebElement NameOnDisplayCard;
	
	
	
	

	@FindBy(xpath="//img[@height='15']")
	WebElement Menu;
	
	public void numberOfMembers() {
		waitForElementToPresent(this.SearchByStatus);
		if (NameOnDisplayCard.isDisplayed()){
			System.out.println("Name Of the community="+ NameOnDisplayCard.getText());
			System.out.println("Total Number of active members displayed="+ NumberOnCommunityDisplayCard.getText());			
			Assert.assertTrue(true);
		}
		
	}
	public void searchGroup1(String GroupName, String Status) throws Exception {
		type(SearchbyGroupName, GroupName,"Search by Group Name");
		waitForElementToPresent(this.SearchByStatus);
	    selectByVisibleText(SearchByStatus,Status,"Search by status");
		click(Search,"Search");
		Thread.sleep(3000);
		WebElement el=driver.findElement(By.xpath("//span[contains(text(),'"+GroupName+"')]"));
		waitForElementToPresent(el);
		String ele=el.getText();
		System.out.println(ele);
		Assert.assertEquals(GroupName, ele);
		
	}
	
	public Create_UpdateGroupPage navigateToEditGroupPage(String groupName) throws Exception {
		
		type(SearchbyGroupName, groupName,"Search by Group Name");   
		 
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+groupName+"')]"));
        waitForElementToPresent(element);
        picture();
        click(element,"Group name");
        waitForElementToPresent(editGroup);
        Thread.sleep(5000);
        picture();
        click(editGroup,"Edit group"); 
        
        return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
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
		//this.searchGroup(GroupName);
		click(Menu,"Menu");
		waitForElementToPresent(ManageMembers);
		click(ManageMembers,"Manage Members");
		return (ManageGroupMembersPage) openPage(ManageGroupMembersPage.class);
//		new ManageGroupMembersPage(driver);
	}
	
	
	
	
	public Create_UpdateGroupPage clickOnCreateBtn(){
		//scrollToElement(Createbtn);
			click(Createbtn," Create Btn");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
		
	}
}
