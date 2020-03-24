package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(manageblogs);
	}

	
	@FindBy(xpath="//*[contains(text(),'Add New Post')]")
	WebElement addNewPost;
	
	public void createBlog(Hashtable<String,String> data) throws Exception
	{
		
		
//		click(addNewPost,"addNewPost");
		waitForElementToPresent(this.title);
		
	  type(this.title, data.get("title"), "blogTitle");
	  type(shortdescription,data.get("shortDescription"),"shortDescription");
	  driver.switchTo().frame(0);
	  Thread.sleep(2000);       
	  type(this.content, data.get("content"), "Content");
	  driver.switchTo().defaultContent();
	  selectByVisibleText(categoryid, data.get("categoryID"), "categoryid");
	  click(this.publisheddate, "Published Date");
      waitForElementToPresent(calendar);
      DateManager d = new DateManager(driver);
      String date = d.getCurrentDateString();
      d.selectDate("//*[@class='datepicker-days']",date);
	  click(save,"Save"); 
	  waitForElementToPresent(OkButton);
	  click(OkButton,"Ok Button");
	  Thread.sleep(3000);
	}
	
	public void Updateblog(Hashtable<String,String> data) throws Exception
	{
	   this.title.clear();
	   this.shortdescription.clear();
	   this.createBlog(data);
	}

}
