package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import javax.naming.directory.SearchControls;
import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import junit.framework.Assert;

public class TestimonialsVerifyPage extends BasePage {
	
	@FindBy(xpath="//h2[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	@FindBy(xpath = "//*[contains(text(),'This is an im')]")
	WebElement textVerify1;
	
	//@FindBy(xpath = "//a[@title='Click to edit this entry']")
	//WebElement edittesti;
		
	//@FindBy(xpath = "//select[@id='StatusID']")
	//WebElement status;
		
	//@FindBy(xpath = "//input[@id='Notes']")
	//WebElement notes;
	
	@FindBy(xpath = "//*[contains(text(),'Submitting test')]")
	WebElement testimonialContent;
	
	@FindBy(css = "div[class='ng-scope'] div div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1)")
	WebElement contentVerfying1;
	
	@FindBy(xpath = "")
	WebElement contentVerfying2;
	
	@FindBy(xpath = "//*[contains(text(),'Alex in')]")
	WebElement contentVerfying3;
	
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(testimonials);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}
	
	public void  TestimonialisVisible(String actual) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		String expected = textVerify1.getText();
		//Thread.sleep(5000);
		Assert.assertEquals(expected, actual+date);
		//Thread.sleep(5000);
	}
	


	public void  TestimonialisnotVisible(String actual) throws InterruptedException
	{
		
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		String expected = contentVerfying1.getText();
		//String expected1 = contentVerfying2.getText();
		//Thread.sleep(2000);
		Assert.assertNotSame(expected,actual+date);
		Thread.sleep(2000);
		//Assert.assertNotSame(expected1,actual+date);
		//Thread.sleep(2000);
		driver.close();
			
	}

}
