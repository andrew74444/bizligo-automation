package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageCommunitiesPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h2[normalize-space()='Manage Communities']")
	WebElement pageTitle;
	@FindBy(xpath = "//input[@id='NameSearch']")
	WebElement searchByName;
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;
	@FindBy(xpath = "//a[@title='Click to edit this Community']")
	WebElement edit;
	@FindBy(xpath = "//label[normalize-space()='Networking']")
	WebElement networking;
	@FindBy(xpath = "//p[normalize-space()='Test data']")
	WebElement about;
	@FindBy(xpath = "//select[@id='CommunityTypeID']")
	WebElement Type;
	@FindBy(xpath = "//label[@class='btn btn-danger active toggle-off']")
	WebElement inactive;
	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement active;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;
	@FindBy(xpath = "//button[@id='btnCancel']")
	WebElement cancel;
	@FindBy(xpath = "//select[@id='GroupCategoryId']")
	WebElement categoryType;
	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(xpath = "//a[@title='Go to Member site home']")
	WebElement homePage;
	@FindBy(xpath = "//a[normalize-space()='Global Communities']")
	WebElement globalcommunties;
	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;
	
	

	
    public void searchCommunity(String Community) throws InterruptedException {
	waitForElementToPresent(searchByName);
	type(searchByName, Community, "Community Name");
	click(search, "Search");
	Thread.sleep(4000);
         }



   public void EditCommunities(String About, String Category,String type) throws InterruptedException {
	   waitForElementToPresent(edit);
		click(edit, "Edit");
		Thread.sleep(3000);
		waitForElementToPresent(networking);
		click(networking, "Networking");
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(About);
		driver.switchTo().defaultContent();
		selectByVisibleText(categoryType, Category, "Category");
	    selectByVisibleText(Type, type, "Type");
	    click(active, "Inactive");
	    Thread.sleep(2000);
	    waitForElementToPresent(YesProceed);
	    click(YesProceed, "Yes Proceed");
	    Thread.sleep(2000);
	    click(save, "Save");
	    Thread.sleep(4000);
     }
public GlobalCommunitesPage navigateToglobalcommunities() {
	click(homePage, "Bizligo Home page");
	waitForElementToPresent(globalcommunties);
	click(globalcommunties, "Global communities");
	return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);	
}



}
