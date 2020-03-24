package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;

import org.apache.log4j.Logger;

public class BlogsPage2 extends BasePage {

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
	WebElement success;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(manageblogs);

	}

	public void Creatblog(String title, String shortDescription, String categoryID, String Tags, String content)
			throws Exception {
		type(this.title, title, "blogTitle");
		type(shortdescription, shortDescription, "shortDescription");

		driver.switchTo().frame(0);
		Thread.sleep(2000);
		type(this.content, content, "Content");
		driver.switchTo().defaultContent();

		selectUsingVisibleText(categoryid, categoryID);
		// type(tags, Tags, "Tags");

		click(this.publisheddate, "Published Date");
		waitForElement(calendar, expTime);
		DateManager d = new DateManager(driver);
		String date = d.getCurrentDateString();
		d.selectDate("//*[@class='datepicker-days']", date);

		picture();
		click(save, "Save");
		waitForElement(calendar, expTime);
		click(success, "Success");
	}

	private void waitForElement(WebElement calendar2, int expTime) {
		// TODO Auto-generated method stub
		
	}

	private void selectUsingVisibleText(WebElement categoryid2, String categoryID3) {
		// TODO Auto-generated method stub

	}

	public void Updateblog(String title, String shortdescription, String categoryID, String Tags, String content)
			throws Exception {
		this.title.clear();
		this.shortdescription.clear();
		this.Creatblog(title, shortdescription, categoryID, Tags, content);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();

	}
}
