package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationsPage extends BasePage {

	
	@FindBy(xpath="//h3[contains(text(),'NOTIFICATIONS')]")
	WebElement notifications;
	
	@FindBy(xpath = "//*[@class='header active']")
	WebElement header;

	@FindBy(xpath = "//*[@id='header']")
	WebElement groupPageHeader;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(notifications);

	}

	@Override
	protected void getPageScreenSot() {
		updateClass(header, "");	
		
	}

	public Discussions viewPost(String d) {
		
		String[] arr1 = splitStringBy(d, "\\s");
		String[] arr2 = splitStringBy(d, "/");
		int month = stringToInt(arr2[0]);
		int day = stringToInt(arr2[1]);
		
		String[] arr3 = splitStringBy(arr1[0], ":");
		int hr = stringToInt(arr3[0]);
		
		d=month+"/"+day+"/"+arr2[2]+" "+hr+":"+arr3[1];
		log.info(d);
		
		
		
		
		
		return (Discussions) openPage(Discussions.class);
		
	}
	
	
	

}
