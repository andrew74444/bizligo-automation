package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;





public class Messages extends BasePage{
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	
	@FindBy(xpath="//span[@class='fa fa-pencil-square-o']")
	WebElement newMessage;
	
	
	@FindBy(xpath="//h2[@class='MessagesHeader text-uppercase']")
	WebElement MessagesHeader;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	WebElement PrivacyPolicy;
	
	@FindBy(xpath="//i[@class='fa fa-paper-plane']")
	WebElement Send;
	@FindBy(xpath="//*[@id='txtMsgContent']")
	WebElement txtMsg;
	
	@FindBy(xpath="//*[contains(text(),'Click here')]")
	WebElement ClickHere;
	@FindBy(xpath = "//a[contains(.,'Upcoming Events')]")
	WebElement UpcomingEvents;
	
	@FindBy(xpath="//span[contains(.,'Events')]")
	WebElement Events;
	
	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(MessagesHeader);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public void messageDisplayed(String MemberName,String Message) throws Exception{
		click(newMessage,"newMessage");
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'"+MemberName+"')])[1]"));
		waitForElementToPresent(element);
		click( element,"Member Name");
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
		String i = Integer.toString(elements.size());
		String SharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+i+"]/div[2]/p")).getText();	
		AssertionHelper.verifyText(SharedMessage, Message);
		Thread.sleep(3000);
		
	}
	
	public String SendNewMessage(String MemberName,String NewMessage) throws Exception{
		click( newMessage,"new Message");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'"+MemberName+"')])[1]"));
		waitForElementToPresent(element);
		click(element,"Member Name" );
		scrollToElement(PrivacyPolicy);
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	    Date date = new Date();
		String Message = NewMessage+" "+dateFormat.format(date);
		Thread.sleep(2000);
		txtMsg.sendKeys(Message);
		Thread.sleep(10000);
//		click("Send", Send);
		clickElementByJavaScript(Send);
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li"));
		String i = Integer.toString(elements.size());
		String SharedMessage = driver.findElement(By.xpath("//*[@id='ChatController']/div/div/div[1]/div/div/div[2]/div[1]/ul/li["+i+"]/div[2]/p")).getText();	
		AssertionHelper.verifyText(SharedMessage, Message);
		Thread.sleep(2000);	
		return Message;
	}
}
