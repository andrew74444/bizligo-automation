package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	@FindBy(xpath = "(//*[contains(text(),'Browse')])[1]")
	WebElement Browse;

	@FindBy(xpath = "//*[contains(text(),'Upload')]")
	WebElement Upload;

	@FindBy(xpath = "(//*[contains(text(),'Active')])[1]")
	WebElement Active;

	@FindBy(xpath = "//*[contains(text(),'In-Active')]")
	WebElement InActive;

	@FindBy(xpath = "//span[contains(text(),'Create')]")
	WebElement Create;

	@FindBy(xpath = "//*[contains(text(),'Save')]")
	WebElement Save;

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

	public ManageGroupsPage createGroup(String name, String Description, String City, String State,
			String GroupCategory, String GroupType, String LogoImagePath ) throws Exception {
		name = name+" "+dateInNumbers();
		this.fillGroupDetails(name, Description, City, State, GroupType, LogoImagePath);
		waitForElementToPresent(Create);
		scrollToElement(Create);
		click(Create, "Create");
		return (ManageGroupsPage) openPage(ManageGroupsPage.class);
		// new ManageGroupsPage(driver, );
	}

	public ManageGroupsPage editGroup(String Name, String Description, String City, String State, String GroupCategory,
			String GroupType, String LogoImagePath ) throws Exception {

		this.fillGroupDetails(Name, Description, City, State,  GroupType, LogoImagePath);
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
		
		
		 int index = stringToInt(getSystemCurrentDate());
	        if(index>25) {
	        	index = 1;
	        }
	    selectUsingIndex(this.GroupCategory, index,"Group Category");
		
		selectByVisibleText(this.GroupType, groupType,"GroupType");
		
		click(changeImageLink,"change Image Link");

		 waitForElementToPresent(Browse);
		click(Browse," Browse");
		 Thread.sleep(10000);
		 System.out.println(projectFloder(logoImagePath));
		 Runtime.getRuntime().exec(projectFloder(logoImagePath));
		Thread.sleep(10000);
		click(Upload, "Upload");
		Thread.sleep(10000);
		picture();
	}

	public GroupDetailsPage updateGroup(String Name, String Description, String City, String State,
	        String GroupType, String logoImagePath,String newGroupName ) throws Exception
	{
	    this.fillGroupDetails(Name, Description, City, State,  GroupType, logoImagePath);
	    type(this.Name, newGroupName+" "+dateInNumbers(), "new Group Name");
	    click(Save, "Save");
	    return (GroupDetailsPage) openPage(GroupDetailsPage.class);
	}

}
