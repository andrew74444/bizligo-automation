package com.cpcommunity.PageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

import junit.framework.Assert;

public class CommunityBlogsPage extends BasePage {

	@Override
	protected void getPageScreenSot() {

		aShot();

	}

	@FindBy(xpath = "//*[contains(text(),'Manage Blog Posts')]")
	WebElement manageblogs;

	@FindBy(xpath = "//*[@id='Title']")
	WebElement title;

	@FindBy(xpath = "//*[@id='ShortDescription']")
	WebElement shortdescription;

	@FindBy(xpath = "//*[@id='CategoryID']")
	WebElement categoryid;

	@FindBy(xpath = "//*[@class = 'select2-selection__rendered']")
	WebElement tags;

	@FindBy(xpath = "//*[@name='IsActive']")
	WebElement status;

	@FindBy(xpath = "//*[@name = 'btnSave']")
	WebElement save;

	@FindBy(tagName = "body")
	WebElement content;

	@FindBy(xpath = "//*[@id = 'PublishedDate']")
	WebElement publisheddate;

	@FindBy(xpath = "//*[@class='datepicker-days']")
	WebElement calendar;
	@FindBy(xpath = "//table[@class=' table-condensed']")
	WebElement calendar2;
	
	@FindBy(xpath = "//*[@id = 'btn-ok']")
	WebElement OkButton;
	
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//*[@id=\"row_40\"]/td[2]/a")
	WebElement editBlog;
	
	@FindBy(xpath = "//body/div/div/div/div/nav/div/ul/li/a[1]")
	WebElement menu;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOut;
	
	@FindBy(xpath = "//*[@id=\"row_29\"]/td[2]/a")
	WebElement editBlogdetails;
	
	@FindBy(xpath = "//a[@title='Click to edit this post']")
	WebElement edit;
	
	@FindBy(xpath = "(//input[@type='search'])[1]")
	WebElement search;
	
	@FindBy(xpath = "//a[@title='Manage Blogs']")
	WebElement home;
	
	@FindBy(css = "tbody tr:nth-child(4) td:nth-child(4)")
	WebElement selectdate;
	@FindBy(xpath = "//td[normalize-space()='18']")
	WebElement Date;
	
	@FindBy(xpath = "//table[@class=' table-condensed']//th[@class='next'][normalize-space()='»']")
	WebElement nextmonth;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-info']")
	WebElement categorires;
	@FindBy(xpath = "//span[@class='glyphicon glyphicon-calendar']")
	WebElement calendetshow;
	
	@FindBy(xpath = "//div[@class='bootstrap-dialog-message']")
	WebElement dateError;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	WebElement canceldateError;
	
	@FindBy(xpath = "//a[@class='site_title']")
	WebElement siteTitle;
	
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='Blogs']")
	WebElement blogs;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	
	@FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@role='main']/div/div[4]")
	WebElement form;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(manageblogs);
	}

	@FindBy(xpath="//button[normalize-space()='Add New Post']")
	WebElement addNewpost;
	@FindBy(xpath="//*[contains(text(),'Add New Post')]")
	WebElement addNewPost;
	
	public void createBlog(String title, String shortDescription, String content) throws Throwable
	{
	 
	  String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
	  type(this.title, title+date, "blogTitle");
	  Thread.sleep(3000);
	  type(shortdescription,"shortDescription","shortDescription");
	  driver.switchTo().frame(0);
	  Thread.sleep(2000);       
	  type(this.content,"content", "Content");
	  driver.switchTo().defaultContent();
	  Select s = new Select(categoryid);
	  s.selectByIndex(2);
	  click(this.publisheddate, "Published Date");
      waitForElementToPresent(calendar);
      DateManager d = new DateManager(driver);
      String date1 = d.getCurrentDateString();
      d.selectDate("//*[@class='datepicker-days']",date1);
	  click(save,"Save"); 
	  waitForElementToPresent(OkButton);
	  click(OkButton,"Ok Button");
	  Thread.sleep(3000);
	}
	public void createPost(String title, String shortDescription, String content) throws Throwable
	{
	 waitForElementToPresent(addNewpost);
	 clickElementByJavaScript(addNewpost);
	 //click(addNewpost, "Add New Post");
	 title=title+getDateInDDMMMYYYY();
	//  String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
	  type(this.title, title, "blogTitle");
	  Thread.sleep(3000);
	  type(shortdescription,shortDescription,"shortDescription");
	  driver.switchTo().frame(0);
	  Thread.sleep(2000);       
	  type(this.content,content, "Content");
	  driver.switchTo().defaultContent();
	  Select s = new Select(categoryid);
	  s.selectByIndex(2);
	  click(this.publisheddate, "Published Date");
      waitForElementToPresent(calendar);
      DateManager d = new DateManager(driver);
      String date1 = d.getCurrentDateString();
      d.selectDate("//*[@class='datepicker-days']",date1);
     
      Thread.sleep(9000);  
	 selectUsingIndex(status, 0, "Status");
	  click(save,"Save"); 
	  waitForElementToPresent(OkButton);
	  click(OkButton,"Ok Button");
	  Thread.sleep(5000);
	}
	
	
	public void Updateblog(String search, String title, String shortDescription, String content ) throws Throwable
	{
	   String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
	   type(this.search,search+date, "Search");
	   Thread.sleep(2000);
	   editBlog.click();
	   Thread.sleep(5000);
	   this.title.clear();
	   Thread.sleep(2000);
	   this.shortdescription.clear();
	   Thread.sleep(2000);
	   this.createBlog(title+date, shortDescription, content);
	}
	
	public void canceledBlog(String title, String shortDescription, String content) throws Throwable
	{
		scrollUpVertically();
		clickElementByJavaScript(addNewpost);
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		  type(this.title, title+date, "blogTitle");
		  Thread.sleep(3000);
		  type(shortdescription,"shortDescription","shortDescription");
		  driver.switchTo().frame(0);
		  Thread.sleep(2000);       
		  type(this.content,"content", "Content");
		  driver.switchTo().defaultContent();
		  Select s = new Select(categoryid);
		  s.selectByIndex(2);
		  click(this.publisheddate, "Published Date");
	      waitForElementToPresent(calendar);
	      DateManager d = new DateManager(driver);
	      String date1 = d.getCurrentDateString();
	      d.selectDate("//*[@class='datepicker-days']",date1);
		Thread.sleep(9000);
		click(cancel, "Cancel");
		//cancel.click();
		Thread.sleep(3000);
	}
	
	public void logOut() throws Throwable
	{
		Thread.sleep(5000);
		click(menu, "Menu");
		Thread.sleep(5000);
		click(logOut, "Logout");
	}
	
	public void editBlog(String search) throws Throwable
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.search,search+date,"Search");
		Thread.sleep(2000);
		click(editBlogdetails,"EditBlog");
		Thread.sleep(3000);
		Select s = new Select(status);
		s.selectByIndex(1);
		Thread.sleep(5000);
		click(save,"Save");
		waitForElementToPresent(OkButton);
		click(OkButton,"Ok Button");
		
	}
	public void Updatedate(String searchName) throws Throwable
	{
		type(this.search,searchName,"Search");
	   Thread.sleep(8000);
	   click(edit,"EditBlog");
	   Thread.sleep(8000);
	   click(this.publisheddate, "Published Date");
	      waitForElementToPresent(calendar);
	      DateManager d = new DateManager(driver);
	      String date1 = d.getCurrentDateString();
	      d.selectDate("//*[@class='datepicker-days']",date1);
		Thread.sleep(9000);
		// click(this.publisheddate, "Published Date");
	    // waitForElementToPresent(calendar);
	     //Thread.sleep(3000);
	    // click(nextmonth, "Next");
	    // click(nextmonth, "Next");
	    // click(nextmonth, "Next");
	    // click(nextmonth, "Next");
	    // Thread.sleep(3000);
	    // click(selectdate, "Date");
	     Thread.sleep(3000);
	     click(save,"Save");
	     waitForElementToPresent(dateError);
	     String Error=this.dateError.getText();
	     System.out.println(Error);
	    // click(canceldateError, "Cancel");
	     //Thread.sleep(2000);
	     //click(cancel, "Cancel");
	     Thread.sleep(2000);
			waitForElementToPresent(OkButton);
			click(OkButton,"Ok Button");
		
	}
	
	public void Updatepost(String searchName, String shortDescription, String category ) throws Throwable
	{  
		Thread.sleep(3000);
		type(this.search,searchName,"Search");
	   Thread.sleep(15000);
	   click(edit,"EditBlog");
		Thread.sleep(5000);
		  type(shortdescription,shortDescription,"shortDescription");
		  Thread.sleep(3000);
		  //selectByVisibleText(categoryid, category, "Category");
		  //click(this.publisheddate, "Published Date");
	     // waitForElementToPresent(calendar);
	      //DateManager d = new DateManager(driver);
	     // String date1 = d.getCurrentDateString();
	    //  d.selectDate("//*[@class='datepicker-days']",date1);
			Thread.sleep(2000);
		// scrollIntoViewAndClick(save);
		click(save,"Save");
		Thread.sleep(2000);
		waitForElementToPresent(OkButton);
		click(OkButton,"Ok Button");
		
	}
	public void inactivatePost(String searchName) throws Throwable
	{

		type(this.search,searchName,"Search");
		Thread.sleep(15000);
		click(edit,"EditBlog");
		Thread.sleep(3000);
		Select s = new Select(status);
		s.selectByIndex(1);
		Thread.sleep(5000);
		click(save,"Save");
		waitForElementToPresent(OkButton);
		click(OkButton,"Ok Button");
		
	}
	public void activatePost(String searchName) throws Throwable
	{

		type(this.search,searchName,"Search");
		Thread.sleep(15000);
		click(edit,"EditBlog");
		Thread.sleep(3000);
		Select s = new Select(status);
		s.selectByIndex(0);
		click(this.publisheddate, "Published Date");
	      waitForElementToPresent(calendar);
	      DateManager d = new DateManager(driver);
	      String date1 = d.getCurrentDateString();
	      d.selectDate("//*[@class='datepicker-days']",date1);
		Thread.sleep(9000);
		
		click(save,"Save");
		waitForElementToPresent(OkButton);
		click(OkButton,"Ok Button");
		
	}
	
    public BlogsSummary navigateToBlogsSummarypage() {
		scrollUpVertically();
		waitForElementToPresent(home);
		click(home, "BlogHome");
		return (BlogsSummary) openPage(BlogsSummary.class);
	}
    
    public CategoriesPage gotoCategoriespage() {
    	scrollUpVertically();
    	click(categorires, "Categories");
    	return (CategoriesPage) openPage(CategoriesPage.class);	
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
}
