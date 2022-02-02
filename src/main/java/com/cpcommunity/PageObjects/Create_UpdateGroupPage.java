package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;






public class Create_UpdateGroupPage extends BasePage {

	@Override
	protected  void getPageScreenSot() {
		aShot();
	}
	

	@FindBy(xpath = "//input[@id='Name']")
	WebElement Name;

	@FindBy(xpath = "//textarea[@id='Description']")
	WebElement Description;

	@FindBy(xpath = "//input[@id='State']")
	WebElement State;

	@FindBy(xpath = "//input[@id='City']")
	WebElement City;

	@FindBy(xpath = "//select[@id='GroupCategoryId']")
	WebElement GroupCategory;

	@FindBy(xpath = "//select[@id='GroupTypeID']")
	WebElement GroupType;

	@FindBy(xpath = "//a[@id='changeImageLink']")
	WebElement changeImageLink;

	@FindBy(xpath = "//*[@id='EditMyGroupImageForm']//*[contains(text(),'Browse')]")
	WebElement Browse;

	@FindBy(xpath = "//*[@id='EditMyGroupImageForm']//*[contains(text(),'Upload')]")
	WebElement Upload;

	@FindBy(xpath = "(//*[contains(text(),'Active')])[1]")
	WebElement Active;

	@FindBy(xpath = "//*[contains(text(),'In-Active')]")
	WebElement InActive;

	@FindBy(xpath = "//span[@class='ng-binding']")
	WebElement Create;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement Save;

	@FindBy(xpath = "//select[@id='GroupTypeID']")
	WebElement groupType;
	
	@FindBy (xpath = "//span[normalize-space()='Groups']")
    WebElement Groups;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement BDMAIHomePage;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		 
		return ExpectedConditions.visibilityOf(Name);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public ManageGroupsPage createGroup(String name, String Description, String City, String State
			) throws Exception {
		name = name+getDateInDDMMMYYYY();
		type(Name, name, "groupname");
		type(this.Description, Description, "Description");
		type(this.State, State, "Groupstate");
		type(this.City, City, "Groupcity");
			
		Select drp = new Select(GroupType);
		drp.selectByVisibleText("Public");
		Thread.sleep(5000);
		Select drp1 = new Select(GroupCategory);
		drp1.selectByVisibleText("NGO");
		Thread.sleep(5000);
		waitForElementToPresent(Create);
	    scrollToElement(Create);
		return (ManageGroupsPage) openPage(ManageGroupsPage.class);
		// new ManageGroupsPage(driver, );
	}

	public GroupDetailsPage editGroup(String Name, String Description, String City, String State, String GroupType, String LogoImagePath ) throws Exception {

		this.fillGroupDetails(Name, Description, City, State,  GroupType, LogoImagePath);
		click(Save, "Save");
		return (GroupDetailsPage) openPage(GroupDetailsPage.class);
		// new ManageGroupsPage(driver, );

	}
	public ManageGroupsPage editGroupName(String Name ) throws Exception {

		picture();
		Thread.sleep(15000);
		type(this.Name, Name, "Name");
		click(Save, "Save");
		return (ManageGroupsPage) openPage(ManageGroupsPage.class);
		// new ManageGroupsPage(driver, );

	}

	
	public void fillGroupDetails(String name, String description, String city, String state, 
			String groupType, String logoImagePath ) throws Exception {

		picture();
		Thread.sleep(15000);
		type(this.Name, name, "Name");
		type(this.Description, description, "Description");
		type(this.City, city, "City");
		type(this.State, state, "State");
		
		
		/* int index = stringToInt(getSystemCurrentDate());
	        if(index>25) {
	        	index = 1;
	        }
	    selectUsingIndex(this.GroupCategory, index,"Group Category");*/
		
		selectByVisibleText(this.GroupType, groupType,"GroupType");
		Thread.sleep(5000);
		click(changeImageLink,"change Image Link");
		
		 waitForElementToPresent(Browse);
		 Thread.sleep(1000);
		click(Browse," Browse");
		 StringSelection ss = new StringSelection(logoImagePath);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  Robot robot = new Robot();
		     robot.delay(350);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		    
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.keyRelease(KeyEvent.VK_V);
		    
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		// System.out.println(projectFloder(logoImagePath));
		// Runtime.getRuntime().exec(projectFloder(logoImagePath));
		waitForElementToPresent(Upload);
		click(Upload, "Upload");
		Thread.sleep(10000);
		picture();
	}
	
	public GroupDetailsPage updateGroup(String Name, String Description, String City, String State,
	        String GroupType, String logoImagePath,String newGroupName ) throws Exception
	{
	    this.fillGroupDetails(Name, Description, City, State,  GroupType, logoImagePath);
	    type(this.Name, newGroupName+" "+getDate(), "new Group Name");
	    click(Save, "Save");
	    return (GroupDetailsPage) openPage(GroupDetailsPage.class);
	}
	
	public GroupPage navigateToGroupPage() throws InterruptedException {
		//Thread.sleep(2000);
		waitForElementToPresent(BDMAIHomePage);
		click(BDMAIHomePage, "HomePage");
		waitForElementToPresent(Groups);
		click(Groups, "Groups");
		
		return (GroupPage) openPage(GroupPage.class);	
	}
}
