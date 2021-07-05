package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusinessDirectoryPage extends BasePage{

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[3]/div[3]/button")
	WebElement searchButton;
//commenting for error24/june
 
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
  
	@FindBy(xpath = "//a[contains(@class,'form-group')]")
	WebElement searchByName;
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
	@FindBy(xpath ="//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[3]/div[3]/button")
	WebElement searchbtn;
	
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
		return false;
		
		
	}
	
	public  void clickOnserchByBussinessCategory() throws InterruptedException {
		scrollIntoView(serchByBussinessCategory);
		Thread.sleep(1000);
		click(serchByBussinessCategory,"BussinessCategory");
	}
	
	public void clickOnsearchByName() throws InterruptedException {
		/*scrollIntoView(searchByName);
		Thread.sleep(1000);
		click(searchByName,"MemberName");
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		waitForElementToPresent(ele);*/
		scrollIntoView(searchByName);
		waitForElementToPresent(searchByName);
		click(searchByName,"MemberName");
		//type(searchByName, Name, "Search by Name");
		click(searchbtn, "search btn");
		Thread.sleep(2000);
		picture();
	}
	
	public void searchByName(String Name) throws Exception{
		searchByName.clear();
    	log.info(Name);
    	type(searchByName, Name,"Search by Name");
    	click(searchbtn,"search btn");
    	Thread.sleep(3000); 
	}
	
	
	
}

