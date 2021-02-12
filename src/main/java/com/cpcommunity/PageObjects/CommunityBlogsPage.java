package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

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

	@FindBy(xpath = "//*[@id = 'btn-ok']")
	WebElement OkButton;
	
	@FindBy(xpath = "//*[@id=\"btnCancel\"]")
	WebElement cancel;
	
	@FindBy(xpath = "//*[@id=\"row_40\"]/td[2]/a")
	WebElement editBlog;
	
	@FindBy(xpath = "//body/div/div/div/div/nav/div/ul/li/a[1]")
	WebElement menu;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOut;
	
	@FindBy(xpath = "//*[@id=\"row_29\"]/td[2]/a")
	WebElement editBlogdetails;
	
	@FindBy(xpath = "(//input[@type='search'])[1]")
	WebElement search;
	//(//input[@type='search'])[1]

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(manageblogs);
	}

	
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
		Thread.sleep(5000);
		cancel.click();
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

}
