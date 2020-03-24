package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Hashtable;

import org.apache.log4j.Logger;



public class CategoriesPage extends BasePage {

	

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

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(managecategories);

	}

	public void createCategorie(Hashtable<String,String> data) throws InterruptedException {
		click(newcategory, "NewCategory");
		waitForElementToPresent(categoryname);
		type(categoryname, data.get("categoryName"), "CategoryName");

		type(this.description, data.get("description"), "Description");
		click(save, "Save");
		Thread.sleep(4000);
		picture();
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
}