package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;



public class CategoriesPage extends BasePage {

	@FindBy(xpath = "//a[@title='Manage Blogs']")
	WebElement home;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-warning']")
	WebElement Tag;

	@FindBy(xpath = "//*[contains(text(),'New')]")
	WebElement newcategory;

	@FindBy(xpath = "//*[@id='DTE_Field_CategoryName']")
	WebElement categoryname;

	@FindBy(xpath = "//*[@id='DTE_Field_Description']")
	WebElement description;

	@FindBy(xpath = "//*[@id='DTE_Field_IsActive']")
	WebElement status;

	@FindBy(xpath = "//*[contains(text(),'Manage Categories')]")
	WebElement managecategories;

	@FindBy(xpath = "//*[@class = \"btn btn-default btn btn-primary\"]")
	WebElement save;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement ok;
	
	@FindBy(xpath = "//div[@class='DTE_Form_Error']")
	WebElement error;
	
	@FindBy(css = "td:nth-child(5)")
	WebElement postcount;
	
	@FindBy(xpath = "(//td[@class='sorting_1'])[1]")
	WebElement selectcat;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchcat;
	
	@FindBy(xpath = "//a[@class='btn btn-default buttons-selected buttons-edit']")
	WebElement edit;
	
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement update;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement siteTitle;
	
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='Blogs']")
	WebElement blogs;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	
	@FindBy(xpath = "//div[normalize-space()='The Category Name field is required']")
	WebElement categorynameError;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-success']")
	WebElement post;
	
	@FindBy(xpath = "//tbody//tr//td[2]")
	List<WebElement> categories;
	
	
	
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(managecategories);

	}

	public void createCategorie(Hashtable<String,String> data) throws InterruptedException {
		waitForElementToPresent(newcategory);
		click(newcategory, "NewCategory");
		waitForElementToPresent(categoryname);
		type(categoryname, data.get("categoryName")+getSystemCurrentMintues(), "CategoryName");

		type(this.description, data.get("description"), "Description");
		click(save, "Save");
	//	Thread.sleep(4000);
	//	picture();
	}

	public void updatecategorie(Hashtable<String,String> data) throws InterruptedException {
		this.categoryname.clear();
		this.description.clear();
		this.createCategorie(data);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();

	}
	
	public BlogsSummary navigateToBlogsSummarypage() {
		
		waitForElementToPresent(home);
		click(home, "BlogHome");
		return (BlogsSummary) openPage(BlogsSummary.class);
	}
	public void createCategorie(String categoryName,String Statusis, String Description) throws InterruptedException {
		categoryName=categoryName+ " " + getSystemCurrentMintues(); // getDateInDDMMMYYYY();
		click(newcategory, "NewCategory");
		waitForElementToPresent(categoryname);
		type(categoryname, categoryName, "CategoryName");
		type(this.description,Description, "Description");
		//selectUsingIndex(status, 1, "Inactive");
		selectByVisibleText(status, Statusis, "Status");
		click(save, "Save");
		waitForElementToPresent(ok);
		click(ok, "OK");
	//	Thread.sleep(4000);
	//	picture();
	}
	public void checkCancel() {
		click(newcategory, "NewCategory");
		waitForElementToPresent(cancel);
		click(cancel, "Cancel");
		
	}
	
	public void createSameNameCategorie(String categoryName, String Description) throws InterruptedException {
		waitForElementToPresent(newcategory);
		click(newcategory, "NewCategory");
		waitForElementToPresent(categoryname);
		type(categoryname, categoryName, "CategoryName");
		type(this.description,Description, "Description");
		selectUsingIndex(status, 0, "Inactive");
		click(save, "Save");
	//	Thread.sleep(1000);
		waitForElementToPresent(error);
		String errormsg=this.error.getText();
		System.out.println(errormsg);
		
	//	picture();
	}
	
	public void InactiveCategory(String Name) throws InterruptedException {
		//Name=Name+ " " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchcat);
		type(searchcat, Name, "Category name");
	//	Thread.sleep(15000);
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		waitForElementToPresent(edit);
		click(edit, "edit");
	//	Thread.sleep(5000);
		waitForElementToPresent(status);
		selectUsingIndex(status, 0, "Inactive");
	//	Thread.sleep(2000);
		waitForElementToPresent(update);
		click(update, "Update");
	//	Thread.sleep(5000);
		waitForElementToPresent(ok);
		click(ok, "OK");
		
	}
	
	public void activeCategory(String Name) throws InterruptedException {
		//Name=Name+ " " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchcat);
		type(searchcat, Name, "Category name");
	//	Thread.sleep(15000);
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		waitForElementToPresent(edit);
		click(edit, "edit");
	//	Thread.sleep(2000);
		waitForElementToPresent(status);
		selectUsingIndex(status, 1, "Inactive");
	//	Thread.sleep(2000);
		waitForElementToPresent(update);
		click(update, "Update");
	//	Thread.sleep(5000);
		waitForElementToPresent(ok);
		click(ok, "OK");
		
	}
	public BlogsPage gotoBlogsPage() throws InterruptedException {
		waitForElementToPresent(siteTitle);
		click(siteTitle, "Site title");
		waitForElementToPresent(Toggledropdownmenu);
		clickElementByJavaScript(Toggledropdownmenu);
	//	Thread.sleep(5000);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
	//	Thread.sleep(5000);
		waitForElementToPresent(blogs);
		//click(blogs, "Blogs");
		clickElementByJavaScript(blogs);
	
		return (BlogsPage) openPage(BlogsPage.class);	
	}
	
	public void updatecategorie(String Name, String categoryName, String Description) throws InterruptedException {
	//	Name=Name+ " " + getDateInDDMMMYYYY();
		waitForElementToPresent(searchcat);
		type(searchcat, Name, "Category name");
	//	Thread.sleep(15000);
	//	categoryName=categoryName+ " " + getDateInDDMMMYYYY();
		waitForElementToPresent(selectcat);
		click(selectcat, "Select Category");
		waitForElementToPresent(edit);
		click(edit, "edit");
	//	Thread.sleep(2000);
		waitForElementToPresent(categoryname);
		click(categoryname, "Category Name");
		this.categoryname.clear();
		click(update, "Update");
		waitForElementToPresent(categorynameError);
		String Error=this.categorynameError.getText();
		System.out.println(Error);
		type(categoryname, categoryName, "Category Name");
		this.description.clear();
		type(this.description,Description, "Description");
	//	Thread.sleep(2000);
		waitForElementToPresent(status);
		selectUsingIndex(status, 1, "Inactive");
	//	Thread.sleep(2000);
		waitForElementToPresent(update);
		click(update, "Update");
	//	Thread.sleep(5000);
		waitForElementToPresent(ok);
		click(ok, "OK");
		
	}
	public CommunityBlogsPage checkPostCounts(String Name) throws InterruptedException {
		waitForElementToPresent(searchcat);
		type(searchcat, Name, "Category name");
		Thread.sleep(8000);
		waitForElementToPresent(postcount);
        String count=this.postcount.getText();
        System.out.println(count);
        Thread.sleep(2000);
        click(post, "Post");
        return (CommunityBlogsPage) openPage(CommunityBlogsPage.class);
	}
   public TagsPage navigatetoTagpage() {
		
		waitForElementToPresent(Tag);
		click(Tag, "TagPage");
		return (TagsPage) openPage(TagsPage.class);
	}
   
   public void listOfCategories() {
	   
	   waitForElementToPresent(categories);
	  Assert.assertTrue(true);
   }

private void waitForElementToPresent(List<WebElement> categories2) {
	// TODO Auto-generated method stub
	
}
}