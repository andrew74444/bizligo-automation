package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
	
	@FindBy(xpath = "//a[@class='edit-page ng-scope']")
	WebElement manageBtn;
	
	@FindBy(xpath = "//span[@ng-if='data.SimilarInterestPeopleWidgetConfigured.CommunityWidgetEditedName.length == 0']")
	List<WebElement> skillinterest;
	
	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	WebElement skillint;
	
	public void verifyskillnameChanged() throws InterruptedException {
		waitForElementToPresent(skillint);
		String changeevent=this.skillint.getText();
		System.out.println(changeevent);
	    String Expected="SKILL AND INTEREST";
	   Assert.assertEquals(changeevent, Expected); 
	}
	
	
	public void checkListOfMembers() {
		waitForElementToPresent(spotlightedmembers);
		int Memberscount=this.spotlightedmembers.size();
		System.out.println(Memberscount);
		
	}

	private void waitForElementToPresent(List<WebElement> spotlightedmembers2) {
		// TODO Auto-generated method stub
		
	}
	
	public void VerifySAINotDisplaying() throws InterruptedException {
		Thread.sleep(500);
		Assert.assertEquals(0, skillinterest.size());
		System.out.println("Skill and Interest is Not Displaying");
		
	}
	
	public ManageCommunityPage gotoDashboardpage() {
		waitForElementToPresent(manageBtn);
		click(manageBtn, "Manage Button");
		return (ManageCommunityPage) openPage(ManageCommunityPage.class);		
	}
	
	
	
	
	
	
	
	
}
