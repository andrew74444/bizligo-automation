package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.android.dx.util.ByteArray.GetCursor;

import junit.framework.Assert;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;


public class TestimonialsPage extends BasePage
{
	
	@FindBy(xpath="//input[@id='Title']")
	WebElement title;
	
	@FindBy(xpath="//textarea[@id='Details']")
	WebElement testimonial;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submit;
	
	@FindBy(xpath="//button[@id='btnReset']")
	WebElement reset;
	
	@FindBy(xpath = "//div[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement oK;
	
	@FindBy(xpath = "/html[1]/body[1]/div[7]/div[1]/div[1]/div[2]/button[1]")
	WebElement okbtn;

	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(testimonials);
	}
	
	
	public void SubmitTestimonials(String Title, String Testimonial) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.title, Title, "TestimonialTitle");//+date
		//Thread.sleep(5000);
		waitForElementToPresent(testimonial);
		type(this.testimonial,Testimonial+date,"Testimonial");
		//Thread.sleep(5000);
		waitForElementToPresent(submit);
		click(submit,"Submit button");
		//Thread.sleep(5000);
		waitForElementToPresent(oK);
		click(oK,"Ok");
//		waitForElementToPresent(okbtn);
		//Thread.sleep(6000);
//		click(okbtn,"OKbtn");
		//Thread.sleep(5000);
	}
	
	public void ResetTestimonial(String Title, String Testimonial) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.title, Title+date, "TestimonialTitle");
		//Thread.sleep(5000);
		waitForElementToPresent(testimonial);
		type(this.testimonial,Testimonial+date,"Testimonial");
		//Thread.sleep(5000);
		waitForElementToPresent(reset);
		click(reset,"Reset button");
		//Thread.sleep(6000);
	}
	@FindBy(xpath = "//*[contains(text(),'This is an im')]")
	WebElement textVerify1;
	
	public void  TestimonialisVisible(String actual) throws InterruptedException
	{
	//	String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		String expected = textVerify1.getText();
		//Thread.sleep(5000);
		Assert.assertEquals(expected, actual);//+date
		//Thread.sleep(5000);
	}
	@FindBy(css = "div[class='ng-scope'] div div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1)")
	WebElement contentVerfying1;
	@FindBy(xpath = "(//*[text()='and rejected by admin'])[1]")
			WebElement rejected;

	public void  TestimonialisnotVisible(String actual) throws InterruptedException
	{
		
	
		String expected = rejected.getText();
	
		Assert.assertNotSame(expected,actual);
			
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}

	
	
}	
