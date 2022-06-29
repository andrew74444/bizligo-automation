package com.cpcommunity.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


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
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement Createbtn;
	
	@FindBy(xpath="//span[@class='ng-binding']")
	WebElement Creategroupbtn;
	
	@FindBy(xpath="//input[@placeholder='Search by Group Name']")
	WebElement SearchbyGroupName;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//img")
	WebElement manageedit;
	
	@FindBy(xpath="(//*[contains(text(),'Search')])[2]")
	WebElement Search;

	@FindBy(xpath="//i[@class='fa fa-pencil-square-o']")
	WebElement editGroup1;
	
	@FindBy(xpath="//div[@class='btn-group pull-right post_menu open']//span[contains(text(),'Edit Group')]")
	WebElement editGroup;
	
	@FindBy(xpath="(//*[contains(text(),'Manage Members')])[2]")
	WebElement ManageMembers;
	
	@FindBy(xpath="//select[@ng-model='data.SearchData.StatusID']")
	WebElement SearchByStatus;
	
	

	@FindBy(xpath="//img[@height='15']")
	WebElement Menu;
	
	
	public void searchGroup(String GroupName) throws Exception {
		type(SearchbyGroupName, GroupName,"Search by Group Name");
		click(Search,"Search");
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		
	}
	
	public Create_UpdateGroupPage editGroup() throws Exception {
		click(Menu,"Menu");
		//driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		waitForElementToPresent(editGroup);
		click(editGroup,"editGroup");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
	}
	
      public Create_UpdateGroupPage navigateToEditGroupPage(String groupName) throws Exception {
		
		type(SearchbyGroupName, groupName,"Search by Group Name");   
		 
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+groupName+"')]"));
        waitForElementToPresent(element);
        picture();
        click(element,"Group name");
        waitForElementToPresent(editGroup1);
        //driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        picture();
        click(editGroup1,"Edit group"); 
        
        return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
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
		//scrollToElement(Createbtn);
		waitForElementToPresent(Createbtn);
			click(Createbtn," Create Btn");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
		}
	
	public ManageGroupsPage clickOnCreateGroupBtn(){
		//scrollToElement(Createbtn);
		//	click(Creategroupbtn," Creategroupbtn");
			clickElementByJavaScript(Creategroupbtn,"Creategroupbtn");
			return (ManageGroupsPage) openPage(ManageGroupsPage.class);
		//return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
//		new Create_UpdateGroupPage(driver, );
		}
	
	
	public void searchGroup1(String GroupName, String Status) throws Exception {
		type(SearchbyGroupName, GroupName,"Search by Group Name");
		waitForElementToPresent(this.SearchByStatus);
	    selectByVisibleText(SearchByStatus,Status,"Search by status");
		click(Search,"Search");
		driver.manage().timeouts().implicitlyWait(900, TimeUnit.SECONDS);
		WebElement el=driver.findElement(By.xpath("//span[contains(text(),'"+GroupName+"')]"));
		waitForElementToPresent(el);
		String ele=el.getText();
		System.out.println(ele);
		Assert.assertEquals(GroupName, ele);
		
	}

	public Create_UpdateGroupPage gotoUpdategroup() throws InterruptedException {
		
		waitForElementToPresent(manageedit);
		click(manageedit, "Manage Edit");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		click(editGroup1, "Edit");
		return (Create_UpdateGroupPage) openPage(Create_UpdateGroupPage.class);
		
	}
}
