package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage {
	
	@FindBy(xpath = "//h2[contains(text(),'Administrator')]")
	WebElement administrator;
	
	@FindBy(xpath = "//a[contains(text(),'Configuration')]//span")
	WebElement configuration;
	
	@FindBy(xpath = "//*[@id=\"tenantidval\"]")
	WebElement tenantIndividual;
	
	@FindBy(xpath = "//a[contains(text(),'Features Configuration')]")
	WebElement featuresconfiguration;
	
	@FindBy(xpath = "//div[14]//div[1]//div[1]//h4[1]")
	WebElement testimonials;
	
	@FindBy(xpath = "//div[@id='TESTMONIALS_13_13']//div//div//div//div//div//div//label[contains(text(),'Enabled')]")
	WebElement disabled;
	
	@FindBy(xpath = "//div[@id='TESTMONIALS_13_13']//div//div//div//div//div//button[@id='btnSave']")
	WebElement save;
	
	@FindBy(xpath = "//div[@id='TESTMONIALS_13_13']//div//div//div//div//div//div//label[contains(text(),'Disabled')]")
	WebElement enabled;
	
	@FindBy(xpath = "(//*[contains(text(),'Blog')])[1]")
	WebElement blogs;
	
	@FindBy(xpath = "//*[@id=\"BLOG_0_0\"]/div/div/div/div[1]/div/div/label[2]")
	WebElement disabledBlog;
	
	@FindBy(xpath = "//*[@id=\"BLOG_0_0\"]/div/div/div/div[1]/div/div/span")
	WebElement enabledBlog;
	
	@FindBy(xpath = "(//*[@id=\"btnSave\"])[1]")
	WebElement saveButton;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(administrator);
	}
	
	public void testimonialsDisabled() throws Exception
	{
		click(configuration, "Configuration");
		Thread.sleep(3000);
		click(featuresconfiguration, "FeaturesConfiguration");
		Thread.sleep(3000);
		click(testimonials, "testimonials");
		Thread.sleep(3000);
		click(disabled, "disabled");
		Thread.sleep(3000);
		click(save, "Save");
		Thread.sleep(5000);
	}
	
	public void testimonialEnabled() throws Exception 
	{
		click(configuration, "Configuration");
		Thread.sleep(10000);
		click(featuresconfiguration, "FeaturesConfiguration");
		Thread.sleep(10000);
		click(testimonials, "testimonials");
		Thread.sleep(10000);
		click(enabled, "enabled");
		Thread.sleep(10000);
		click(save, "Save");
		Thread.sleep(5000);
	}
	
	public void blogsdisabled() throws Exception 
	{
		Select s = new Select(tenantIndividual);
		s.selectByIndex(1);
		click(configuration, "Configuration");
		Thread.sleep(10000);
		click(featuresconfiguration, "FeaturesConfiguration");
		Thread.sleep(10000);
		click(blogs, "blogs");
		Thread.sleep(10000);
		click(disabledBlog, "DisabledBlog");
		Thread.sleep(10000);
		click(saveButton, "SaveButton");
		Thread.sleep(5000);
	}
	
	public void blogsEnabled() throws Exception 
	{
		Select s = new Select(tenantIndividual);
		s.selectByIndex(1);
		click(configuration, "Configuration");
		Thread.sleep(10000);
		click(featuresconfiguration, "FeaturesConfiguration");
		Thread.sleep(10000);
		click(blogs, "blogs");
		Thread.sleep(10000);
		click(enabledBlog, "EnabledBlog");
		Thread.sleep(10000);
		click(saveButton, "SaveButton");
		Thread.sleep(5000);
	}
	
	

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}

}
