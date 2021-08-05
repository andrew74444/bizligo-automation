package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MembersPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(members);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub

	}
	@FindBy(xpath = "//strong[normalize-space()='Members']")
	WebElement members;

	@FindBy(xpath = "//div[@class='media block-update-card img-bg']")
	List<WebElement> spotlightedmembers;
	
	
	
	
	
	public void checkListOfMembers() {
		waitForElementToPresent(spotlightedmembers);
		int Memberscount=this.spotlightedmembers.size();
		System.out.println(Memberscount);
		
	}

	private void waitForElementToPresent(List<WebElement> spotlightedmembers2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
}
