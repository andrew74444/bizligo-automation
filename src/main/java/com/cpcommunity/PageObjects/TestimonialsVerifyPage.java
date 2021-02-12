package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import javax.naming.directory.SearchControls;
import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import junit.framework.Assert;

public class TestimonialsVerifyPage extends BasePage {
	
	@FindBy(xpath="//h2[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	@FindBy(xpath = "//*[contains(text(),'I have')]")
	WebElement textVerify1;
	
	@FindBy(xpath = "//*[contains(text(),'Submitting test')]")
	WebElement testimonialContent;
	
	@FindBy(xpath = "//*[contains(text(),'Success,')]")
	WebElement contentVerfying1;
	
	@FindBy(xpath = "//*[contains(text(),'WOW')]")
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
		Thread.sleep(5000);
		Assert.assertEquals(expected, actual+date);
		Thread.sleep(5000);
	}
	


	public void  TestimonialisnotVisible(String actual) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		String expected = contentVerfying1.getText();
		String expected1 = contentVerfying2.getText();
		Thread.sleep(5000);
		Assert.assertNotSame(expected,actual+date);
		Thread.sleep(2000);
		Assert.assertNotSame(expected1,actual+date);
		Thread.sleep(2000);
		driver.close();
		
	}

}
