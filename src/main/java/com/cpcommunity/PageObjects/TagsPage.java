package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;

import org.apache.log4j.Logger;


public class TagsPage extends BasePage {

	@FindBy(xpath = "//*[contains(text(),'New')]")
	WebElement createtag;

	@FindBy(xpath = "//*[contains(text(),'Manage Tags')]")
	WebElement managetags;

	@FindBy(xpath = "//*[@id='DTE_Field_TagName']")
	WebElement tagname;

	@FindBy(xpath = "//*[@id='DTE_Field_Description']")
	WebElement tagdescription;

	@FindBy(xpath = "//*[@class = 'btn btn-default btn btn-primary']")
	WebElement save;

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

	
}