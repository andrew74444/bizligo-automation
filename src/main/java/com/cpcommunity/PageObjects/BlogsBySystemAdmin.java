package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.cpcommunity.PageObjects.BasePage;
import com.cpcommunity.PageObjects.CategoriesPage;
import com.cpcommunity.PageObjects.CommunityBlogsPage;
import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

public class BlogsBySystemAdmin extends BasePage 
{

	@FindBy(xpath = "//h2[contains(text(),'Manage Blog Posts')]")
	WebElement manageBlogPosts;
	
	@FindBy(xpath = "//button[@id='btnAddNew']")
	WebElement addNewPost;
	
	@FindBy(xpath = "//input[@id='Title']")
	WebElement title;
	
	@FindBy(xpath = "//textarea[@id='ShortDescription']")
	WebElement shortDescription;
	
	@FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement content;
	
	@FindBy(xpath = "//select[@id='CategoryID']")
	WebElement categoryID;
	
	@FindBy(xpath = "//form[@id='blogPostForm']//div//div//span//span//span//ul")
	WebElement tags;
	
	@FindBy(xpath = "//input[@id='PublishedDate']")
	WebElement publishedDate;
	
	@FindBy(xpath = "//select[@id='IsActive']")
	WebElement status;
	
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;
	
	@FindBy(xpath = "//button[@id='btnCancel']")
	WebElement cancel;
	
	@FindBy(xpath = "//*[@class='datepicker-days']")
	WebElement calendar;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(manageBlogPosts);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	public void AddnewPost(String title,String ShortDescription,String content) throws Exception
	{
		click(addNewPost,"AddnewPost");
		Thread.sleep(5000);
		 type(this.title,title, "blogTitle");
		  type(this.shortDescription,ShortDescription,"shortDescription");
		  driver.switchTo().frame(0);
		  Thread.sleep(2000);       
		  type(this.content,content, "Content");
		  driver.switchTo().defaultContent();
		  Select category = new Select(categoryID);
		  category.selectByVisibleText("CategoryID");
		  click(this.publishedDate, "Published Date");
	      waitForElementToPresent(calendar);
	      DateManager d = new DateManager(driver);
	      String date = d.getCurrentDateString();
	      d.selectDate("//*[@class='datepicker-days']",date);
		  click(save,"Save"); 
	}
	
	
	public CommunityBlogsPage navigateToCommunityBlogsPage() throws Throwable
	{	
		Thread.sleep(5000);
		return (CommunityBlogsPage) openPage(CommunityBlogsPage.class);
//		new MyDashboardPage(driver, );
	}
	
	public CategoriesPage navigateToCategoriesPage() throws Throwable
	{
		Thread.sleep(5000);
		return (CategoriesPage) openPage(CategoriesPage.class);
	}

}
