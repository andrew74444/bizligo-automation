
package com.cpcommunity.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FeaturesConfigurations extends BasePage{

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
	//
    @FindBy(xpath="//h2[normalize-space()='Features Configuration']")
    WebElement title;
    @FindBy(xpath = "//div[@class='nav_menu']")
    WebElement pageheader;
    @FindBy(xpath="//label[@class='ng-binding'][contains(text(),'Create Community')]")
    WebElement createcommunity;
    @FindBy(xpath="//label[@class='ng-binding'][contains(text(),'Import Contacts to Community Admin')]")
    WebElement importContacttoCA;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
    WebElement enableCA;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]")
    WebElement disableCA;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div/label[1]")
    WebElement enableIM;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div/label[2]")
    WebElement disableIM;
    @FindBy(xpath = "//div[@id='CREATECOMMUNITY_1_1']//div[@class='panel-body']//div[@class='row']//div[@class='col-md-12 col-sm-12 col-xs-12']//div[@class='col-md-3']//div//button[@id='btnSave']")
    WebElement saveCA;
    @FindBy(xpath = "//div[@id='IMPORTCONTACTS_0_0']//div[@class='panel-body']//div[@class='row']//div[@class='col-md-12 col-sm-12 col-xs-12']//div[@class='col-md-3']//div//button[@id='btnSave']")
    WebElement saveIM;
    @FindBy(xpath = "//span[@class='fa fa-angle-down']")
	WebElement toggledropdown;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath="//*[@class='toast-message']")
	WebElement toastMessage;
	@FindBy(xpath="//div[@class='x_content']")
	WebElement featureConfList;
	
	
    
    public void checkFCenableDisable() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
    	waitForElementToPresent(createcommunity);
    	click(createcommunity, "Create community");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
        String name= enableCA.getText();
        System.out.println(name);
        click(disableCA, "Click enable");
        Thread.sleep(3000);
        String name1=disableCA.getText();
        System.out.println(name1);
        click(enableCA, "Click disable");
    	
    }
    
    public void DisableCreateCommunity() throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
    	waitForElementToPresent(createcommunity);
    	click(createcommunity, "Create community");
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
    	//String en=this.enableCA.getText();
    	if(enableCA.isEnabled()) {
			click(this.disableCA, "Disable");
			click(saveCA, "Save");
		}
		//driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
		if(!enableCA.isEnabled()) {
			click(saveCA, "Save");
		}
		
    Thread.sleep(4000);
    }
    
public void DisableImportContact() throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
    	waitForElementToPresent(importContacttoCA);
    	click(importContacttoCA, "importContact to CA");
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);

			if(enableIM.isDisplayed()) {
				click(this.disableIM, "Disable");
				click(saveIM, "Save");
			}
			//driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
			if(!enableIM.isDisplayed()) {
				click(saveIM, "Save");
			}
			
        Thread.sleep(2000);
    }

public void EnableImportContact() throws InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
	waitForElementToPresent(importContacttoCA);
	click(importContacttoCA, "importContact to CA");
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);

		if(enableIM.isDisplayed()) {
			
			click(saveIM, "Save");
		}
		
		
    Thread.sleep(2000);
}
    
 public void EableCreateCommunity() throws InterruptedException {
    	
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
    	waitForElementToPresent(createcommunity);
    	click(createcommunity, "Create community");
    	driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
    	//String en=this.enableCA.getText();
    	if(enableCA.isEnabled()) {
			
			click(saveCA, "Save");
		}
		//driver.manage().timeouts().implicitlyWait(40,TimeUnit.MINUTES);
		if(!enableCA.isEnabled()) {
			click(this.disableCA, "Disable");
			click(saveCA, "Save");
		}
		
		//System.out.println(dis);
    Thread.sleep(2000);
    }
 
 public HomePage logout() throws InterruptedException {
	Thread.sleep(8000);
		click(toggledropdown, " Menu Drop down");
		waitForElementToPresent(logout);
		click(logout, "logout");
		return (HomePage) openPage(HomePage.class);
	}
 public void disablefeature(String feature) throws Exception {
		
		
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]")); 
		scrollToElement(element);
		click(element, "feature");
		Thread.sleep(3000);
		WebElement toggleButton = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]/../../../../..//*[@class='btn btn-success btn-lg toggle-on']"));
		click(toggleButton, "disabling the feature");
		
		WebElement saveButton = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]/../../../../..//*[@id='btnSave']"));
		this.save(saveButton);
		Thread.sleep(3000);
	}
 
 public void enableFeature(String feature) throws Exception {
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]")); 
		scrollToElement(element);
		click(element, "feature");
		Thread.sleep(3000);
		WebElement toggleButton = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]/../../../../..//*[contains(text(),'Disabled')]"));
		click(toggleButton, "enabling the feature");
		Thread.sleep(2000);
		WebElement saveButton = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]/../../../../..//*[@id='btnSave']"));
		this.save(saveButton);
		Thread.sleep(4000);
	}
	public void clickfeature(String feature) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]")); 
		
		click(element, "feature");
		Thread.sleep(3000);
	}
 public void save(WebElement saveButton)
	{
		click(saveButton, "save");
		waitForElementToPresent(toastMessage);
		SoftAssert st = new SoftAssert();
		st.assertEquals(toastMessage.getText(), "Changes Made Successfully");
		st.assertAll();
	}
 
 public void checkFeatureConfigution() {
	 waitForElementToPresent(featureConfList);
	 Object list= this.featureConfList.getText();
	 Object NotPresent="Import Contacts to Community Admin";
	 
	 Assert.assertNotSame(list, NotPresent);
	 
 }
}