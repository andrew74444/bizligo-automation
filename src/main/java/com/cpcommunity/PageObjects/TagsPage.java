package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;


public class TagsPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'New')]")
	WebElement createtag;

	@FindBy(xpath = "//a[@class='btn btn-lg btn-info']")
	WebElement category;

	@FindBy(xpath = "//*[contains(text(),'Manage Tags')]")
	WebElement managetags;

	@FindBy(xpath = "//*[@id='DTE_Field_TagName']")
	WebElement tagname;

	@FindBy(xpath = "//*[@id='DTE_Field_Description']")
	WebElement tagdescription;

	@FindBy(xpath = "//*[@class = 'btn btn-default btn btn-primary']")
	WebElement save;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement ok;
	
	@FindBy(xpath = "//td[@class='sorting_1']")
	WebElement selectcat;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchtag;
	
	@FindBy(xpath = "//a[@class='btn btn-default buttons-selected buttons-edit']")
	WebElement edit;
	
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement update;
	
	@FindBy(xpath = "//*[@id='DTE_Field_IsActive']")
	WebElement status;
	
	@FindBy(xpath = "//div[normalize-space()='The Tag Name field is required']")
	WebElement tagnameError;
	
	@FindBy(xpath = "//*[@id='DTE_Field_Description']")
	WebElement description;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement siteTitle;
	
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='Blogs']")
	WebElement blogs;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	
	@FindBy(xpath = "//div[@class='DTE_Form_Error']")
	WebElement error;
	
	@FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement Toggledropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//tbody//tr//td[2]")
	List<WebElement> tags;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(managetags);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();
	}
	public void createTag(Hashtable<String, String> data) throws Exception {
		
		click(createtag, "CreateTag");
		waitForElementToPresent(tagname);
		type(tagname, data.get("tagName"), "tagName");
		type(tagdescription, data.get("description"), "Description");
		click(save, "Save");
		Thread.sleep(3000);
		picture();
		
	}

	public void updateTag(Hashtable<String, String> data) throws Exception {
		this.tagname.clear();
		this.tagdescription.clear();
		this.createTag(data);
	}

	public void createTag(String Name, String Description) throws Exception {
		Name=Name+ " " + getDateInDDMMMYYYY();
		click(createtag, "CreateTag");
		waitForElementToPresent(tagname);
		type(tagname, Name, "tagName");
		type(tagdescription, Description, "Description");
		click(save, "Save");
		waitForElementToPresent(ok);
		click(ok, "OK");
		Thread.sleep(4000);
		picture();
		
	}
	
	public void sameNameTag(String Name, String Description) throws Exception {
		Thread.sleep(7000);
		click(createtag, "CreateTag");
		waitForElementToPresent(tagname);
		Thread.sleep(2000);
		type(tagname, Name, "tagName");
		type(tagdescription, Description, "Description");
		click(save, "Save");
		Thread.sleep(3000);
		waitForElementToPresent(error);
		String errormsg=this.error.getText();
		System.out.println(errormsg);
		
	}
	public void cancelTag() throws Exception {
		click(createtag, "CreateTag");
		waitForElementToPresent(tagname);
		click(cancel, "Cancel");
		Thread.sleep(3000);
		picture();
		
	}
	public void Inactivetag(String Name) throws InterruptedException {
		waitForElementToPresent(searchtag);
		type(searchtag, Name, "Category name");
		Thread.sleep(15000);
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		waitForElementToPresent(edit);
		click(edit, "edit");
		Thread.sleep(5000);
		selectUsingIndex(status, 0, "Inactive");
		Thread.sleep(3000);
		click(update, "Update");
		Thread.sleep(5000);
		click(ok, "OK");
		
	}
	
	public void activeTags(String Name) throws InterruptedException {
		waitForElementToPresent(searchtag);
		type(searchtag, Name, "Category name");
		Thread.sleep(15000);
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		waitForElementToPresent(edit);
		click(edit, "edit");
		Thread.sleep(2000);
		selectUsingIndex(status, 1, "Inactive");
		Thread.sleep(2000);
		click(update, "Update");
		Thread.sleep(5000);
		click(ok, "OK");
		
	}
	
	public void updateTag(String Name, String tagName, String Description) throws InterruptedException {
		tagName=tagName+ " " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchtag);
		type(searchtag, Name, "Category name");
		Thread.sleep(8000);
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		Thread.sleep(3000);
		waitForElementToPresent(edit);
		click(edit, "edit");
		Thread.sleep(8000);
		click(tagname, "Category Name");
		this.tagname.clear();
		click(update, "Update");
		waitForElementToPresent(tagnameError);
		String Error=this.tagnameError.getText();
		System.out.println(Error);
		type(tagname, tagName, "Category Name");
		this.description.clear();
		type(this.description,Description, "Description");
		Thread.sleep(6000);
		selectUsingIndex(status, 1, "Inactive");
		Thread.sleep(5000);
		click(update, "Update");
		Thread.sleep(7000);
		click(ok, "OK");
		
	}
	public BlogsPage gotoBlogsPage() throws InterruptedException {
		waitForElementToPresent(siteTitle);
		click(siteTitle, "Site title");
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
		Thread.sleep(5000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
		Thread.sleep(5000);
		waitForElementToPresent(blogs);
		//click(blogs, "Blogs");
		clickElementByJavaScript(blogs);
	Thread.sleep(2000);
		return (BlogsPage) openPage(BlogsPage.class);	
	}
	 public CategoriesPage navigatetoCategoriesPagepage() {
			
			waitForElementToPresent(category);
			click(category, "categoryPage");
			return (CategoriesPage) openPage(CategoriesPage.class);
		}
	 public HomePage logout() throws InterruptedException {
		 
		 waitForElementToPresent(Toggledropdown);
			clickElementByJavaScript(Toggledropdown);
			Thread.sleep(3000);
			waitForElementToPresent(logout);
			click(logout, "Logout");
		 
		 return (HomePage) openPage(HomePage.class);	 
	 } 
	 
	 public void listOfTags() {
		   
		   waitForElementToPresent(tags);
		  Assert.assertTrue(true);
	   }

	private void waitForElementToPresent(List<WebElement> tags2) {
		// TODO Auto-generated method stub
		
	}
}