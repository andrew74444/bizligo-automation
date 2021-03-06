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
		type(this.title, Title+date, "TestimonialTitle");
		Thread.sleep(5000);
		type(this.testimonial,Testimonial+date,"Testimonial");
		Thread.sleep(5000);
		click(submit,"Submit button");
		Thread.sleep(5000);
		click(oK,"Ok");
		Thread.sleep(6000);
		click(okbtn,"OKbtn");
		Thread.sleep(5000);
	}
	
	public void ResetTestimonial(String Title, String Testimonial) throws InterruptedException
	{
		String date = ": "+getSystemCurrentDate()+"-"+getSystemCurrentMonth()+"-"+getSystemCurrentYear();
		type(this.title, Title+date, "TestimonialTitle");
		Thread.sleep(5000);
		type(this.testimonial,Testimonial+date,"Testimonial");
		Thread.sleep(5000);
		click(reset,"Reset button");
		Thread.sleep(6000);
	}
	
	

	



	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		
	}

	
	
}	
