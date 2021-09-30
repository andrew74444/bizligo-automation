
package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class SuperAdminFeatureConfigurationPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(featuresConfigurationTitle);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();//
	}
	//
	
	@FindBy(xpath="//h2[contains(text(),'Features Configuration')]")
	WebElement featuresConfigurationTitle;
	
	@FindBy(xpath="//*[@id='selectedMemebershipPlan']")
	WebElement selecteMemebershipPlan;
	
	@FindBy(xpath="//*[@class='toast-message']")
	WebElement toastMessage;
	
	
	public void disablefeature(String feature) throws Exception {
		
		
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]")); 
		scrollToElement(element);
		click(element, "feature");
		Thread.sleep(3000);
		WebElement toggleButton = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]/../../../../..//*[@class='btn btn-success btn-lg toggle-on']"));
		click(toggleButton, "disabling the feature");
		
		if(feature.equals("Membership Plans")) {
			Thread.sleep(5000);
			waitForElementToPresent(selecteMemebershipPlan);
			selectByVisibleText(selecteMemebershipPlan, "0Free Plan - 1 Year (1 Year(s))", "MembershipPlan");
		}
		
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
		WebElement saveButton = driver.findElement(By.xpath("//div[@id='"+feature+"']//div[@class='panel-body']//div[@class='row']//div[@class='col-md-12 col-sm-12 col-xs-12']//div[@class='col-md-3']//div//button[@id='btnSave']"));
		this.save(saveButton);
	}
	public void clickfeature(String feature) throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'"+feature+"')]")); 
		
		click(element, "feature");
	}

	public void save(WebElement saveButton)
	{
		click(saveButton, "save");
		waitForElementToPresent(toastMessage);
		SoftAssert st = new SoftAssert();
		st.assertEquals(toastMessage.getText(), "Changes Made Successfully");
		st.assertAll();
	}
	
	
}