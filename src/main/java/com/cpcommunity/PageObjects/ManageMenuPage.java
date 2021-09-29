package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageMenuPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(PageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}

	
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Manage Menu']")
	WebElement PageTitle;
	@FindBy(xpath = "//button[normalize-space()='Add Menu']")
	WebElement addmenu;
	@FindBy(xpath = "//input[@id='Title']")
	WebElement name;
	@FindBy(xpath = "//input[@value='2']")
	WebElement fromlink;
	@FindBy(xpath = "//input[@value='1']")
	WebElement FromPage;
	@FindBy(xpath = "//select[@id='PageId']")
	WebElement pageId;
	@FindBy(xpath = "//input[@id='DisplayOrder']")
	WebElement displayordre;
	@FindBy(css = "input[value='true'][name='MenuType']")
	WebElement mainmenu;
	@FindBy(css = "input[value='false'][name='MenuType']")
	WebElement submenu;
	@FindBy(xpath = "//button[normalize-space()='Save']]")
	WebElement save;
}
