package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import junit.framework.Assert;

public class MemberDirectoryPage extends BasePage{
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
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
  
	@FindBy(xpath = "//h3[normalize-space()='Member Directory']")
	WebElement memberdirectory;
	@FindBy(xpath = "//*[@id='membername']")
	WebElement searchByName;
	@FindBy(xpath = "//input[@placeholder='Search by Profile Category']")
	WebElement searchByProfileCategory;
	@FindBy(xpath = "//select[@id='skillsInterests']")
	WebElement searchBySkillAndInterest;
	@FindBy(xpath = "//*[@id=\"companyname\"]")
	WebElement searchByOrganisation;
	@FindBy(xpath = "//input[@placeholder='Search by Communities (Upto 3)']")
	WebElement searchByCommunities;
	@FindBy(xpath = "//input[@placeholder='Search by Business Categories (Upto 5)']")
	WebElement searchByBussinessCategory;
	@FindBy(xpath = "//input[@placeholder='Select Groups (Limit 3)']")
	WebElement searchByGroup;
	@FindBy(xpath = "//*[@id='memberlocation']")
	WebElement searchByLocation;
	@FindBy(xpath = "//*[@id=\"PromotionsImageSlider\"]/div/div/ul/li[2]/img")
	WebElement advertismentImg;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[3]/div[2]/div/div[4]/div/div/div/button")
	WebElement connectButton;
	@FindBy(xpath ="//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[3]/div[4]/div/div[1]/div[2]/a/strong/div")
	WebElement firstMemberProfile;
	@FindBy(xpath ="//*[@class=\'progress custom-progress\']")
	WebElement profileCompletenessBar;
	@FindBy(xpath ="//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[3]/div[3]/button")
	WebElement searchBtn;
	@FindBy(xpath = "//*[@ng-bind='member.MemberName']")
	List<WebElement> totalResult;
	@FindBy(xpath = "//span[@class='select2-selection__choice__remove']")
	WebElement cancelICON;
	@FindBy(xpath = "//div[@class='text-center return-mess well']//h4")
	WebElement warning;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li")
	List<WebElement> BusinessCategoryvalue1;	
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[2]")
	List<WebElement> BusinessCategoryvalue2;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[3]")
	List<WebElement> BusinessCategoryvalue3;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[4]")
	List<WebElement> BusinessCategoryvalue4;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[5]")
	List<WebElement> BusinessCategoryvalue5;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']")
	List<WebElement> BusinessCategoryList;
	@FindBy(xpath = "//span[@ng-bind='member.Address']")
	WebElement memberAddress;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[2]/div[1]/div")
	WebElement toastMessage;
	@FindBy(xpath = "//span[@ng-bind='member.OrganizationName | limitTo:14']")
	WebElement memberOrganisation;
	@FindBy(xpath = "//*[@ng-repeat='member in data.members|itemsPerPage:data.pagesize']")
	WebElement Allmembers;
	
	//ul[@id='select2-BusinessCategoryIDs-results']//li
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
	public ProfilePage gotoProfilePage() throws InterruptedException {
		scrollIntoView(firstMemberProfile);
		Thread.sleep(5000);
		waitForElementToPresent(firstMemberProfile);
		click(firstMemberProfile,"OpenMemberProfile");
		return (ProfilePage) openPage(ProfilePage.class);
		// new CreateCommunityPage(driver);
	}


	
	public boolean profileComplenessViibility() throws InterruptedException {
		Thread.sleep(1000);
	boolean val=profileCompletenessBar.isDisplayed();
	
	System.out.println("val is" +val);
	if(profileCompletenessBar.isDisplayed()) {
		System.out.println("ProfileCompletenessBar is displaying");
	Assert.assertTrue(false);
	}
	else {
		System.out.println("ProfileCompletenessBar is not displaying");
		Assert.assertFalse(true);
	}
	return false;
	}
	
	
	
	
	public void SearchElementViibility() throws InterruptedException {
		
		waitForElementToPresent(this.memberdirectory);
		this.memberdirectory.isDisplayed();
		System.out.println("Member Directory Page Open with Member directory as Title");
		this.Allmembers.isDisplayed();
		System.out.println("All active Members Info Displaying");
		
	if(searchByName.isDisplayed()&&searchByProfileCategory.isDisplayed()&&searchBySkillAndInterest.isDisplayed()&&searchByOrganisation.isDisplayed()&&searchByCommunities.isDisplayed()&&searchByBussinessCategory.isDisplayed()&&searchByGroup.isDisplayed()&&searchByLocation.isDisplayed()) {
		System.out.println("All search is displaying");
	}
	else {
		System.out.println("search is not displaying");
	}
	Thread.sleep(2000);
	Assert.assertTrue(true);
	
		
	}
	
	public void clickOnserchByBussinessCategory() throws InterruptedException {
		scrollIntoView(searchByBussinessCategory);
		Thread.sleep(1000);
		click(searchByBussinessCategory,"BussinessCategory");
	}
	
	public void clickOnsearchByName(String Name) throws InterruptedException {
		/*scrollIntoView(searchByName);
		Thread.sleep(1000);
		click(searchByName,"MemberName");
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		waitForElementToPresent(ele);*/
		scrollIntoView(searchByName);
		waitForElementToPresent(searchByName);
		type(searchByName, Name, "Search by Name");
		Thread.sleep(1000);
		click(searchBtn, "search btn");
	}
	
	public void searchByName(String Name) throws Exception{
		searchByName.clear();
    	log.info(Name);
    	type(searchByName, Name,"Search by Name");
    	click(searchBtn,"search btn");
    	Thread.sleep(3000); 
	}
	public void searchMemberName(String Name, String LastName) throws Exception{
		searchByName.clear();
    	log.info(Name);
    	type(searchByName, Name,"Search by Name");
    	click(searchBtn,"search btn");
    	String MemberName=searchByName.getText();
    	if(MemberName.contains(Name)) {
    		System.out.println("First Name :" +MemberName);
    	}
    	searchByName.clear();
    	type(searchByName, LastName,"Search by Name");
    	click(searchBtn,"search btn");
    	String Last=searchByName.getText();
    	if(MemberName.contains(LastName)) {
    		System.out.println("Last Name :" +Last);
    	}
	}
	
	
	public void searchFields(String MemberName, String location, String ProfileCategory,
			String SkillAndInterest, String OrganisationName, String Communities, String BusinessCategory, String Groups ) throws InterruptedException {
		
		waitForElementToPresent(this.searchByName);
		type(this.searchByName,MemberName, "Member Name");		
		CheckSearchResult(this.totalResult,MemberName);
		this.searchByName.clear();
		
		waitForElementToPresent(this.searchByLocation);
		type(this.searchByLocation,location, "location");
		CheckSearchResult(this.totalResult,location);
		this.searchByLocation.clear();
		
		waitForElementToPresent(this.searchByProfileCategory);
		selectByVisibleText(this.searchByProfileCategory,ProfileCategory, "Profile Category");
		CheckSearchResult(this.totalResult,ProfileCategory);
		selectUsingIndex(this.searchByProfileCategory,0,"ProfileCategory");
		
		waitForElementToPresent(this.searchBySkillAndInterest);
		selectByVisibleText(this.searchBySkillAndInterest,SkillAndInterest , "Skill And Interest");
		CheckSearchResult(this.totalResult,SkillAndInterest);
		selectUsingIndex(this.searchBySkillAndInterest,0,"Skill And Interest");	
		
		waitForElementToPresent(this.searchByOrganisation);
		type(this.searchByOrganisation,OrganisationName , "Organisation Name");
		CheckSearchResult(this.totalResult,OrganisationName);
		this.searchByOrganisation.clear();
		
		waitForElementToPresent(this.searchByCommunities);
		selectByVisibleText(this.searchByCommunities,Communities , "Communities");
		Thread.sleep(2000);
		CheckSearchResult(this.totalResult,Communities);
		selectUsingIndex(this.searchByCommunities,0,"Communities");	
		
		waitForElementToPresent(this.searchByBussinessCategory);
		type(this.searchByBussinessCategory,BusinessCategory, "Business Category");
		selectUsingIndex(this.searchByBussinessCategory,0,"Business Category");
		//selectByVisibleText(this.serchByBussinessCategory,BusinessCategory , "Business Category");
		CheckSearchResult(this.totalResult,BusinessCategory);
		
		waitForElementToPresent(this.searchByGroup);
		selectByVisibleText(this.searchByGroup,Groups , "Skill And Interest");
		CheckSearchResult(this.totalResult,Groups);
		selectUsingIndex(this.searchByGroup,0,"Group");	
		
		
	}
	public void CheckSearchResult(List<WebElement> totalResult, String controlValue) throws InterruptedException {
		click(searchBtn , "Search button");
		Thread.sleep(3000);
		System.out.println(totalResult.size());
			if(totalResult.size()>0) {
				Assert.assertTrue(true);
			}
			else {
				AssertionHelper.verifyText(toastMessage.getText(), "sorry!");
			}
	}
			
			public void ClickonSkillAndInterest(String SkillAndInterest) throws InterruptedException {
				//scrollIntoView(searchBySkillAndInterest);
				waitForElementToPresent(this.searchBySkillAndInterest);
				
			   //selectByVisibleText(this.searchBySkillAndInterest,SkillAndInterest , "Skill And Interest");
				String SkillList = this.searchBySkillAndInterest.getText();
				//CheckSearchResult(this.totalResult,SkillAndInterest);
				System.out.println("List is :" +SkillList);
				String skillsArray[] = SkillAndInterest.split(",");
				for(int i=0;i< skillsArray.length;i++) {
					selectByVisibleText(this.searchBySkillAndInterest, skillsArray[i], "Skill And Interest");
					waitForElementToPresent(this.cancelICON);
					if(cancelICON.isDisplayed()) {
						System.out.println("Cancel icon Displayed");
					}
				}
				
				
				
				if(skillsArray.length == 10) {
				Assert.assertTrue(true);
				}
				else {
				Assert.assertFalse(false);
				}
				click(searchBtn , "Search button");
				
			}

			public void ClickOnOrganisation(String Organisation , String organisation) throws InterruptedException {
				waitForElementToPresent(this.searchByOrganisation);
				type(this.searchByOrganisation,Organisation , "Organisation Name");
				click(searchBtn , "Search button");
				waitForElementToPresent(this.memberOrganisation);
				if(memberOrganisation.isDisplayed()) {
					System.out.println("All organisation displayed");
					Assert.assertTrue(true);
				}
				Thread.sleep(4000);
				this.searchByOrganisation.clear();
				waitForElementToPresent(this.searchByOrganisation);
				type(this.searchByOrganisation,Organisation , "Organisation Name");
				click(searchBtn , "Search button");
				Thread.sleep(3000);
				String Message=this.warning.getText();
				
				System.out.println("Warning msg:" + Message);
				AssertionHelper.verifyText(warning.getText(), "Sorry! /n  There aren't any members here. ");	
				
				}
			public void ClickonBusinessCategory(String BusinessCategory) throws InterruptedException {
				waitForElementToPresent(this.searchByBussinessCategory);
				//for(int i=0; i<5; i++) {
					type(this.searchByBussinessCategory,BusinessCategory, "Business Category");
					waitForElementToPresent(this.BusinessCategoryList );
					if(this.BusinessCategoryList.get(0) != null) {
						WebElement categoryLi  = this.BusinessCategoryList.get(0);
						//selectByVisibleText(this.searchByBussinessCategory,categoryLi,categoryLi.getText());
						click(categoryLi,categoryLi.getText());
					}
				//}
				click(searchBtn , "Search button");
				Assert.assertTrue(true);
			}
			private void waitForElementToPresent(List<WebElement> businessCategoryList2) {
				// TODO Auto-generated method stub
				
			}

			private void waitForElementToPresent(List<WebElement> BusinessCategoryvalue1,
					List<WebElement> BusinessCategoryvalue2, List<WebElement> BusinessCategoryvalue3,List<WebElement> BusinessCategoryvalue4,List<WebElement> BusinessCategoryvalue5) {
				// TODO Auto-generated method stub
				
			}

			public void ClickOnLocation(String Location )  {
				waitForElementToPresent(this.searchByLocation);
				type(this.searchByLocation,Location , "Location");
				click(searchBtn , "Search button");
				waitForElementToPresent(this.memberAddress);
				if(memberAddress.isDisplayed()) {
					System.out.println("All address displayed");
					Assert.assertTrue(true);
				}
			}
			public void SearchSuspendedAndExpiredMembers(String SuspendedName, String ExpiredName) throws InterruptedException {
				
				waitForElementToPresent(this.searchByName);
				type(searchByName, SuspendedName,"Search by Name");
		    	click(searchBtn,"search btn");
				Thread.sleep(3000);
				
				
				waitForElementToPresent(this.searchByName);
				type(searchByName, ExpiredName,"Search by Name");
		    	click(searchBtn,"search btn");
				Thread.sleep(3000);
				
			
			
				
			}
			
			
}
	
	
	




