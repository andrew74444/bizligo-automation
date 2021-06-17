package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DirectoryPage extends BasePage{
	
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[3]/div[3]/button")
	WebElement searchButton;

 
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(searchButton);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
  
	@FindBy(xpath = "//*[@id='membername']")
	WebElement serchByName;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/span/span[1]/span/ul/li/input")
	WebElement serchByProfileCategory;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[1]/div[3]/div/span/span[1]/span/ul/li/input")
	WebElement serchBySkillAndInterest;
	@FindBy(xpath = "//*[@id=\"companyname\"]")
	WebElement serchByOrganisation;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/span/span[1]/span/ul/li/input")
	WebElement serchByCommunities;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/span/span[1]/span")
	WebElement serchByBussinessCategory;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[3]/div[1]/div/span/span[1]/span/ul/li/input")
	WebElement serchByGroup;
	@FindBy(xpath = "//*[@id='memberlocation']")
	WebElement serchByLocation;
	@FindBy(xpath = "//*[@id=\"PromotionsImageSlider\"]/div/div/ul/li[2]/img")
	WebElement advertismentImg;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[3]/div[2]/div/div[4]/div/div/div/button")
	WebElement connectButton;
	@FindBy(xpath = "//a[contains(text(),'Abhishek.Samuel')]")
	WebElement firstMemberProfile;
	@FindBy(xpath ="//*[@class='directory-name firstletterCap ng-binding']")
	WebElement profileCompletenessBar;
	
	
	/*public boolean SearchMember() throws Exception {
		scrollIntoView(serchByName);
		Thread.sleep(1000);
		clickElementByJavaScript(serchByName);
		// *[contains(text(),'Save')]
		Thread.sleep(4000);
		picture();
		 {
////			
//		{
		return true;
//		}
	}*/
	public MyProfilePage clickOnMemberProfile() throws InterruptedException {
		scrollIntoView(firstMemberProfile);
		Thread.sleep(1000);
		click(firstMemberProfile,"OpenMemberProfile");
		return (MyProfilePage) openPage(MyProfilePage.class);
		// new CreateCommunityPage(driver);
	}
	
	public boolean profileComplenessViibility() throws InterruptedException {
		Thread.sleep(1000);
		boolean val=profileCompletenessBar.isDisplayed();
		return val;
		
		
	}
	
	

}
