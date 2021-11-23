package com.cpcommunity.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.cpcommunity.utilities.DriverManager;
import com.cpcommunity.utilities.waitHelper;
import com.mongodb.event.ConnectionPoolWaitQueueEnteredEvent;
import com.tigervnc.rdr.Exception;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

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
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	WebElement update;
	@FindBy(xpath = "//input[@id='Action']")
	WebElement URL;
	@FindBy(xpath = "//label[normalize-space()='Inactive']")
	WebElement inactive;
	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement active;
	@FindBy(xpath = "//td[@ng-click='data.EditMenuForm(menu);']")
	List<WebElement> editlast;
	@FindBy(xpath = "//tr[@ng-repeat='menu in data.MenusDataArr']")
	List<WebElement> menu;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
	WebElement yesproceed;
	@FindBy(xpath="//a[@title='Go to Member site home']")
	WebElement bizligoBtn;
	@FindBy(xpath="//select[@id='ParentId']")
	WebElement parentMenu;
	@FindBy(xpath="//a[normalize-space()='Contact']")
	WebElement contact;
	@FindBy(xpath="//div[@class='toast toast-success']")
	WebElement toastmsg;
	@FindBy(xpath="//div[@class='toast-title']")
	WebElement toastupdate;
	
	
	
	
	
	public void AddMenu(String Name, String display, String url) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addmenu));
		//waitForElementToPresent(addmenu);
		click(addmenu, "Add menu");
		waitForElementToPresent(name);
		type(name, Name, "Name");
		click(fromlink, "Link");
		type(displayordre, display, "Display order");
		type(URL, url, "url");
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		click(save, "Save");
		waitForElementToPresent(toastmsg);
		AssertionHelper.verifyText(toastmsg.getText(), "Success!");
		String msg1=this.toastmsg.getText();
		System.out.println(msg1);
		
	}
public void AddSubMenu(String Name, String display, String url, String menu) throws InterruptedException {
		
		waitForElementToPresent(addmenu);
		click(addmenu, "Add menu");
		waitForElementToPresent(name);
		type(name, Name, "Name");
		click(fromlink, "Link");
		type(displayordre, display, "Display order");
		type(URL, url, "url");
		click(submenu, "SubMenu");
		selectByVisibleText(parentMenu, menu, "Blogs");
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		click(save, "Save");
		AssertionHelper.verifyText(toastmsg.getText(), "Success!");
		//clickElementByJavaScript(save);
	}
	
public void InactiveMenu(String Name, String display, String url) throws InterruptedException {
       
     
		WebElement edit=editlast.get(editlast.size()-1);
		waitForElementToPresent(edit);
		click(edit, "Edit");
		waitForElementToPresent(name);
		type(name, Name, "Name");
		click(fromlink, "Link");
		type(displayordre, display, "Display order");
		type(URL, url, "url");
		click(inactive, "Inactive");
		click(update, "Update");
		waitForElementToPresent(toastupdate);
		AssertionHelper.verifyText(toastupdate.getText(), "Success!");
		
	}
public void CheckMenu() throws InterruptedException {
	
	waitForElementToPresent(menu);
	int T =menu.size();
	System.out.println(T);
	int j = 1;
	for (int i = 1; i <= T; i++) {

		if  (i > 0 && i <= T) {
			String MenuName= driver
					.findElement(By.cssSelector("tbody tr:nth-child("+j+")")).getText();
			System.out.println(MenuName);	
			j++;
		
		}
	}
	
}

private void waitForElementToPresent(List<WebElement> menu2) {
	// TODO Auto-generated method stub
	
}
public void UpdateMenu(String Name, String display, String url) throws InterruptedException {
	
	WebElement edit=editlast.get(editlast.size()-1);
	click(edit, "Edit");
	//waitForElementToPresent(name);
	type(name, Name, "Name");
	click(fromlink, "Link");
	type(displayordre, display, "Display order");
	type(URL, url, "url");
	click(active, "Inactive");
	click(update, "Update");
	waitForElementToPresent(toastupdate);
	AssertionHelper.verifyText(toastupdate.getText(), "Success!");
}

public void CancelpopUp(String Name, String display, String url) throws InterruptedException {
	
	waitForElementToPresent(addmenu);
	click(addmenu, "Add menu");
	waitForElementToPresent(name);
	type(name, Name, "Name");
	click(fromlink, "Link");
	type(displayordre, display, "Display order");
	type(URL, url, "url");
	//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	click(cancel, "Cancel");
	waitForElementToPresent(yesproceed);
	click(yesproceed, "Yes Proceed");
	//clickElementByJavaScript(save);
}
public void checkURLclick() throws InterruptedException{
  // Thread.sleep(3000);
	scrollToElement(bizligoBtn);
	//click(bizligoBtn,"Bizligo button");
	clickElementByJavaScript(bizligoBtn);
	clickElementByJavaScript(contact);
//wait.until(ExpectedCond)
	String name=driver.getTitle();
	System.out.println(name);
	   
	    }
public HomePage goToHomePage() throws InterruptedException {
	//Thread.sleep(3000);
	scrollToElement(bizligoBtn);
	clickElementByJavaScript(bizligoBtn);
	
	return (HomePage) openPage(HomePage.class);
}
}