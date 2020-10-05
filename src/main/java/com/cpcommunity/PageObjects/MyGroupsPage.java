package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class MyGroupsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	
	@FindBy(xpath = "//h3[contains(.,'My Groups')]")
    WebElement myGroups;

	@FindBy(xpath = "//*[@type='text']")
    WebElement SearchGroup;
    
    @FindBy(xpath = "//button[@id='CreateCommunity']")
    WebElement CreateCommunityBtn;
    
    @FindBy(xpath = "//*[@id='toast-container']")
    WebElement ToastMessage;
    @FindBy(xpath = "//button[contains(.,' Leave')]")
    WebElement LeaveBtn;
    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    WebElement CancelBtn;
    @FindBy(xpath = "//span[@title='Menu']")
    WebElement CommunityDashboardMenu;
    @FindBy(xpath = "//button[contains(.,'Search')]")
    WebElement searchbtn;
    
    
    @FindBy(xpath = "//button[contains(.,'Ok')]")
    WebElement BtnOK;
    @FindBy(xpath = "//img[@src='/Content/Images/search.png']")
    		WebElement searchImage;
    @FindBy(xpath = "//img[@height='17']")
    		WebElement Menu;
    @FindBy(xpath = "//*[contains(text(),'Manage Members')]")
	WebElement ManageMembers;
  
    
    public ManageGroupMembersPageByGroupAdmin manageGroupMembers(String groupName ) throws Exception {
    	groupName = groupName+" "+getDateInDDMMMYYYY();
    	this.searchGroup(groupName);
    	waitForElementToPresent(Menu);
    	picture();
    	Menu.click();
    	waitForElementToPresent(ManageMembers);
    	picture();
    	ManageMembers.click();
    	
		return (ManageGroupMembersPageByGroupAdmin) openPage(ManageGroupMembersPageByGroupAdmin.class);
//		new ManageGroupMembersPageByGroupAdmin(driver, );
		
	}
    
    public GroupDetailsPage NaviagtingToGroupDetailsPage(String GroupName) throws Exception {
    	this.searchGroup(GroupName);
    	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+GroupName+"')]"));
    	waitForElementToPresent(ele);
    	ele.click();
    	return (GroupDetailsPage) openPage(GroupDetailsPage.class);
//    	new GroupDetailsPage(driver, );
    }
    
    
    public void searchGroup(String groupName) throws Exception{
    	SearchGroup.clear();
    	type( SearchGroup, groupName,"Search by Group Name");
    	click(searchbtn,"search btn");
    	Thread.sleep(6000); 
    	
    }
    
    
    public boolean cancel(String groupName) throws Exception {
    	groupName = groupName+" "+getDateInDDMMMYYYY();
    	this.searchGroup(groupName);
		click(CancelBtn,"Leave"); 
		waitForElementToPresent(ToastMessage);
		AssertionHelper.verifyText(ToastMessage.getText(), "Your request processed successfully");
		this.searchGroup(groupName);
		if(searchImage.isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
    public boolean LeaveGroup(String groupName) throws Exception  {
    	groupName = groupName+" "+getDateInDDMMMYYYY();
    	this.searchGroup(groupName);
		click(LeaveBtn,"Leave"); 
		waitForElementToPresent(ToastMessage);
		AssertionHelper.verifyText(ToastMessage.getText(), "You have removed successfully from the Group");
		
		if(searchImage.isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}	
	}
    
    
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(myGroups);
	}

	@FindBy(xpath="//*[contains(text(),'Inactive')]")
	WebElement inActive;
	
	@FindBy(xpath="//h2[contains(text(),'This Group Is No Longer Available')]")
	WebElement groupNotAvailable;
	
	@FindBy(xpath="//*[contains(text(),'My Groups')]")
	WebElement myGroupsbutton;

	
	public void goToInActivegroup(String groupName) throws Exception {
	
		this.searchGroup(groupName);
		waitForElementToPresent(inActive);
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'"+groupName+"')]/.."));
		driver.get(getAttributeValue(ele, "href"));
		waitForElementToPresent(myGroupsbutton);
		Thread.sleep(3000);
		AssertionHelper.verifyText( groupNotAvailable.getText(),"This Group Is No Longer Available");
		Thread.sleep(3000);
		picture();
		
	}


    @FindBy(xpath = "")
    WebElement Groupname;

    @FindBy(xpath = "//*[@class='fa fa-pencil-square-o']")
    WebElement editGroup;

		
		public Create_UpdateGroupPage navigateToEditGroupPage(String groupName) throws Exception {
		       
			groupName = groupName+" "+getDate();
	        this.searchGroup(groupName);
	        
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
		
		
		
		
		
		
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	

