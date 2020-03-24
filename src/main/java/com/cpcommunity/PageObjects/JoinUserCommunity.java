package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class JoinUserCommunity extends BasePage{
	
	
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	

	@FindBy(xpath = "//*[contains(text(),'Click here to Join')]")
	WebElement clickHereToJoin;
	
	@FindBy(xpath = "//*[contains(text(),'Terms and Conditions')]")
	WebElement termsAndConditions;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//*[@class='swal2-content']")
	WebElement content;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OK;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		waitForElementToPresent(clickHereToJoin);
		return ExpectedConditions.visibilityOf(clickHereToJoin);
	}
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public UpcomingEventsPage clickOnupComingEvents() {

		return (UpcomingEventsPage) openPage(UpcomingEventsPage.class);
//		new UpcomingEventsPage(driver, );
	}

	public GlobalCommunitesPage NavigateToCommunities() {

		return (GlobalCommunitesPage) openPage(GlobalCommunitesPage.class);
//		new GlobalCommunitesPage(driver, );
	}
	
	
	public void successfullyJoinCommunity( ) throws Exception {
		this.clickHereToJoin();
		
		AssertionHelper.verifyText(content.getText(), "You are successfully added to this Community");
		OK.click();
	}
	
	
	public void successfullyJoinCommunity(String TC ) throws Exception {
		this.clickHereToJoin(TC);
		
		AssertionHelper.verifyText(content.getText(), "You are successfully added to this Community");
		click(OK,"Ok");
	}

	public void alreadyMember(String TC ) throws Exception {
		this.clickHereToJoin(TC);

		AssertionHelper.verifyText(content.getText(), "You are already member of this Community");
		OK.click();
	}

	public void NotInvited(String TC ) throws Exception {
		this.clickHereToJoin(TC);

		AssertionHelper.verifyText(content.getText(),
				"You are not invited to this community, you can join the community by clicking on the Join button");
		OK.click();
	}
	
	public void NotInvited( ) throws Exception {
		this.clickHereToJoin();

		AssertionHelper.verifyText(content.getText(),
				"You are not invited to this community, you can join the community by clicking on the Join button");
		OK.click();
	}

	public void clickHereToJoin( ) throws Exception {

		waitForElementToPresent(clickHereToJoin);
		int t = driver.findElements(By.xpath("//*[contains(text(),'Click here to Join')]")).size();
		System.out.println(t);
		click(driver.findElement(By.xpath("(//*[contains(text(),'Click here to Join')])["+t+"]")),"Click here to Join");
		Thread.sleep(2000);
		waitForElementToPresent(OK);
		picture();
//		AssertionHelper.verifyText(content.getText(), "You are already member of this Community");
		
	}

	public void alreadyMember( ) throws Exception {
		this.clickHereToJoin();
		Thread.sleep(2000);
		AssertionHelper.verifyText(content.getText(), "You are already member of this Community");
		OK.click();

	}

	public void clickHereToJoin(String TC ) throws Exception {
		try {

			String parent = driver.getWindowHandle();
			termsAndConditions.click();
			Thread.sleep(2000);
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> I1 = s1.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
					Thread.sleep(2000);
					WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + TC + "')]"));
					waitForElementToPresent(ele);
					AssertionHelper.verifyText(ele.getText(), TC);
					
					picture();
					driver.close();
					driver.switchTo().window(parent);
					checkbox.click();
				}
			}
		} catch (Exception e) {

		}
		click(clickHereToJoin,"click Here To Join");
		
		waitForElementToPresent(OK);
	}

	
	
	
	
	
}
