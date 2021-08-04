package com.cpcommunity.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class ManageCommunityPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(title);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
		
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h4[normalize-space()='Edit Community']")
	WebElement title;
	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(tagName = "//a[@id='changePictureLink']")
	WebElement changeImageLink;
	@FindBy(xpath = "//button[@onclick=\"document.getElementById('uploadGroupLogo').click();\"]")
	WebElement Browse;
	@FindBy(xpath = "//form[@id='EditMyGroupLogoForm']//button[@type='submit'][normalize-space()='Upload']")
	WebElement Upload;
	@FindBy(xpath = "//label[normalize-space()='Standard']")
	WebElement standard;
	@FindBy(xpath = "//button[@id='btnSave']")
	WebElement save;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastmessage;
	@FindBy(xpath = "//span[@id='inbox-id']")
	WebElement boxId;
	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement emailName;
	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement setBtn;
	@FindBy(xpath = "//body/div[@class='container body']/div[@class='main_container']/div[@class='col-md-3 left_col']/div[@class='left_col scroll-view']/div[@id='sidebar-menu']/div[@class='menu_section']/ul[@class='nav side-menu']/li[13]/a[1]")
	WebElement advertisement;
	@FindBy(xpath = "//a[normalize-space()='Manage Plans']")
	WebElement manageplan;
	
	
	public void editCommunityLogo(String about,String updatecommunity, String termandcond, String logoImagePath ) throws InterruptedException, IOException {
		Thread.sleep(4000);
		waitForElementToPresent(standard);
		click(standard, "Standard");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(about);
		driver.switchTo().defaultContent();
		scrollDownByPixel(30);
		driver.switchTo().frame(1);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(updatecommunity);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		enterTextInframe.clear();
		enterTextInframe.sendKeys(termandcond);
		driver.switchTo().defaultContent();
		scrollDownByPixel(30);
		//click(changeImageLink,"change Image Link");
       clickElementByJavaScript(changeImageLink);
		 waitForElementToPresent(Browse);
		click(Browse," Browse");
		 Thread.sleep(10000);
		 System.out.println(projectFloder(logoImagePath));
		 Runtime.getRuntime().exec(projectFloder(logoImagePath));
		Thread.sleep(10000);
		click(Upload, "Upload");
		scrollDownByPixel(100);
		Thread.sleep(1000);
		click(save, "Save");
		picture();
		AssertionHelper.verifyText(toastmessage.getText(), "Community details updated successfully");
	}
	
	public void openGuerillamail(String emailName) throws InterruptedException, AWTException {
		// Thread.sleep(5000);
	     //((JavascriptExecutor)driver).executeScript("window.open()");
	    // Thread.sleep(2500);
	    // ArrayList<String>wins = new ArrayList<String>(driver.getWindowHandles());
	     //driver.switchTo().window(wins.get(1));
	     driver.get("https://www.guerrillamail.com/");
	     Thread.sleep(5000);
	     click(boxId,"BoxID");
	     Thread.sleep(5000);
	     this.emailName.clear();
	     Thread.sleep(2000);
	     type(this.emailName, emailName, "emailName");
	     Thread.sleep(5000);
	     click(setBtn,"set Button");
	     Thread.sleep(180000);
	     Actions ac = new Actions(driver);
	     ac.contextClick().build().perform();
	     Thread.sleep(5000);
	     Robot r = new Robot();
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_DOWN);
	     Thread.sleep(5000);
	     r.keyPress(KeyEvent.VK_ENTER);
	    // Thread.sleep(1000);
	    // click(emailVerify,"passwordVerify");
	   //  Thread.sleep(1500);
	    // String password = passWord.getText();
	   //  Thread.sleep(2000);
	    // ArrayList<String>wins1 = new ArrayList<String>(driver.getWindowHandles());
	    // driver.switchTo().window(wins1.get(0));
	     Thread.sleep(8000);
	 }
	
	public ManageAdPlansPage NavigateTomanageAdpage() {

		click(advertisement, "Advertisement");
		waitForElementToPresent(manageplan);
		click(manageplan, "Manage Plan");
		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
		// new GroupsPendingRequestsPage(driver);
	}

	
	
	
	
}