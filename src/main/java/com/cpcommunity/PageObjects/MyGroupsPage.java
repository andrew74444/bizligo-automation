package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class MyGroupsPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='global-nav']")
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

   // @FindBy(xpath = "//button[contains(.,'Yes,Proceed')]")
   // WebElement YesProceed;
    @FindBy(xpath = "//*[@id='toast-container']")
    WebElement ToastMessage;

  //  @FindBy(xpath = "//li[@ng-if='(!appData.IsInEventManagerRole) && (appData.IsGroupActive)']")
   // WebElement LeaveBtn;
   
    @FindBy(xpath = "//*[@id='toast-container']")
    WebElement ToastMessage;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm btn-remove'][1]")
    List<WebElement> LeaveBtn;

    @FindBy(xpath = "//button[contains(.,'Cancel')]")
    WebElement CancelBtn;
    @FindBy(xpath = "//span[@title='Menu']")
    WebElement CommunityDashboardMenu;
    @FindBy(xpath = "//button[contains(.,'Search')]")
    WebElement searchbtn;

    @FindBy(xpath = "//body//div[@class='container body']//div[@role='main']//div//div//div[4]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]")
	WebElement CommunityBox;
    @FindBy(xpath = "//button[contains(.,'Yes,Proceed')]")
	WebElement YesProceed;


    @FindBy(xpath = "//button[contains(.,'Ok')]")
    WebElement BtnOK;
    @FindBy(xpath = "//img[@src='/Content/Images/search.png']")
    WebElement searchImage;
    @FindBy(xpath = "//img[@height='17']")
    WebElement Menu;
    @FindBy(xpath = "//*[contains(text(),'Manage Members')]")
	WebElement ManageMembers;
    @FindBy(xpath = "//*[contains(text(),'\"Please make another member as Group Admin to leave from this Group.')]")

	//WebElement makeAnothergroupAdminAlertMeassge;


	//WebElement makeAnothergroupAdminAlertMeassge;


 //  	WebElement makeAnothergroupAdminAlertMeassge;
	
    
    
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
	
	

   

    
    public ManageGroupMembersPageByGroupAdmin manageGroupMembers(String groupName ) throws Exception {
    	groupName = groupName+" "+getDateInDDMMMYYYY();
    	this.searchGroup(groupName);
    	waitForElementToPresent(Menu);
    	picture();
    	click(Menu,"Menu");
    	waitForElementToPresent(ManageMembers);
    	picture();
    	click(ManageMembers,"ManageMembers");
    	
		return (ManageGroupMembersPageByGroupAdmin) openPage(ManageGroupMembersPageByGroupAdmin.class);
//		new ManageGroupMembersPageByGroupAdmin(driver, );
		
	}
    
   
    public GroupDetailsPage NaviagtingToGroupDetailsPage(String GroupName) throws Exception {
    	this.searchGroup(GroupName);
    	WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'"+GroupName+"')]"));
    	waitForElementToPresent(ele);
    	click(ele,"GroupName");
    	return (GroupDetailsPage) openPage(GroupDetailsPage.class);
//    	new GroupDetailsPage(driver, );
    }
    
    
    public void searchGroup(String groupName) throws Exception{
    	SearchGroup.clear();
    	log.info(groupName);
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

		public void checkProperAlertDisplayedWhenOnlyOneAdmin(String GroupName) throws Exception {
			//this.searchCommunity(communityName+getDateInDDMMMYYYY());
			//waitForElementToPresent(CommunityBox);
			//click(CommunityBox, "Community Box");
			//scrollIntoView(LeaveBtn);
			waitForElementToPresent(myGroups);
			myGroups.click();		
			Thread.sleep(5000);
			waitForElementToPresent(LeaveBtn);
			click(LeaveBtn, "leave");
			takeScreenshotByShutterBug(LeaveBtn, "Leave Btn");
			waitForElementToPresent(YesProceed);
			takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
			click(YesProceed, "Yes Proceed");
			waitForElementToPresent(BtnOK);
			takeScreenshotByShutterBug(BtnOK, "Ok");
			click(BtnOK, "Ok");
			picture();
			System.out.println("Ok button click");
			

					//"Please make another member as Group Admin to leave from this Group.");
			AssertionHelper.verifyText(makeAnothergroupAdminAlertMeassge.getText(),
					"Please make another member as Group Admin to leave from this Group.");
			System.out.println("Assertion done");
		}

		
		

		private void takeScreenshotByShutterBug(List<WebElement> leaveBtn2, String imageName) {
			// TODO Auto-generated method stub
			
		}

		private void click(List<WebElement> leaveBtn2, String elementName) {
			// TODO Auto-generated method stub
			
		}

		private void waitForElementToPresent(List<WebElement> leaveBtn2) {
			// TODO Auto-generated method stub
			
		}
		
	}

		
		
		

		
	

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	

