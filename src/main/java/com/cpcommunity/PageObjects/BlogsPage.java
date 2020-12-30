package com.cpcommunity.PageObjects;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogsPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(SearchBtn);
	}

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@FindBy(xpath = "//select")
	WebElement selectCommuntiy;
	@FindBy(xpath = "//*[@id='term']")
	WebElement blogsPostName;
	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@id='term']")
	WebElement search;
	@FindBy(xpath = "(//*[contains(text(),'updating the new')])[1]")
	WebElement verifyBlog;
	
	@FindBy(xpath = "//*[contains(text(),'No Posts found')]")
	WebElement noPosts;
	
	@FindBy(xpath = "(//*[contains(text(),'This page isn’t working')])[1]")
	WebElement blogpageisnotWorking;
	

	public void searchPost(String communityName, String blogName) {
		communityName = communityName + " " + getDateInDDMMMYYYY();
		selectByVisibleText(selectCommuntiy, communityName, "selecting Communtiy");
		type(blogsPostName, blogName, "Post Name to search");
		click(SearchBtn, "Search");
		WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + blogName + "')]"));
		waitForElementToPresent(ele);
		ele.isDisplayed();
	}
	
	
	
	public void searchPostByMember(String search) throws Throwable
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.search,search+date,"Search");
		Thread.sleep(1000);
		click(SearchBtn,"searchbutton");
		String expected = verifyBlog.getText();
		if(search.contains(expected))
		{
			System.out.println("Both are equals");
			
		}
		Thread.sleep(4000);
	}
	
	public void inactiveBlogPost(String Search) throws Throwable
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.search,search+date,"Search");
		Thread.sleep(1000);
		waitForElementToPresent(noPosts);	
	}
	
	public void pageIsNotWorking()
	{
		waitForElementToPresent(blogpageisnotWorking);
	}
	
	
	public void searchPost(Hashtable<String,String> data) throws InterruptedException {
		selectByVisibleText(selectCommuntiy, data.get("communityName"), "selecting Communtiy");
		type(blogsPostName, data.get("title"), "Post Name to search");
		
		click(SearchBtn, "Search");
		Thread.sleep(15000);
		
		try {
			WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + data.get("title") + "')]"));
			waitForElementToPresent(ele);
			ele.isDisplayed();
		} catch (Exception e) {
			log.info("Post is not displayed");

		}

	}
	
	

}
