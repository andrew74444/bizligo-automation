package com.cpcommunity.PageObjects;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import com.cpcommunity.utilities.DateManager;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import com.uiFramework.pamTen.cpcommunity.helper.calendar.DateManager;


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
	@FindBy(xpath = "//input[@id='membername']")
	WebElement searchByName;
	@FindBy(xpath = "//input[@placeholder='Search by Profile Category']")
	WebElement searchByProfileCategory;
	@FindBy(xpath = "//input[@placeholder='Search by Skills and Interests']")
	WebElement searchBySkillAndInterest;
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement searchBySkillAndInterestValue;
		
	@FindBy(xpath = "//ul[@id='select2-skillsInterests-results']")
	WebElement skillCategoryList;
	
	@FindBy(xpath = "//li[@role='treeitem']")
	WebElement errorOfSkillCategory;
	
	@FindBy(xpath = "//li[@title='running race']//span[@role='presentation'][normalize-space()='×']")
	WebElement runningcancelBtn;
	
	@FindBy(xpath = "//div[@class='col-lg-6 col-md-6 col-sm-6 organizations-profile-card ng-scope']")
	WebElement resultOfSkills;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement searchByOrganisation;
	@FindBy(xpath = "//input[@placeholder='Search by Communities (Upto 3)']")
	WebElement searchByCommunities;
	@FindBy(xpath = "//input[@placeholder='Search by Business Categories (Upto 5)']")
	WebElement searchByBussinessCategory;
	@FindBy(xpath = "//input[@class='select2-search__field'][@placeholder='Search By Business Category (Upto 5)']")
	WebElement searchByBussinessCat;
	
	@FindBy(xpath = "//input[@placeholder='Select Groups (Limit 3)']")
	WebElement searchByGroup;
	@FindBy(xpath = "//input[@id='memberlocation']")
	WebElement searchByLocation;
	@FindBy(xpath = "//*[@id=\"PromotionsImageSlider\"]/div/div/ul/li[2]/img")
	WebElement advertismentImg;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[3]/div[2]/div/div[4]/div/div/div/button")
	WebElement connectButton;
	@FindBy(xpath ="//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[3]/div[4]/div/div[1]/div[2]/a/strong/div")
	WebElement firstMemberProfile;
	@FindBy(xpath ="//div[@ng-bind='member.MemberName']")
	List<WebElement> MemberProfileList;
	@FindBy(xpath = "//i[@title='Download Excel']")
	WebElement excelDownload1;
	
	@FindBy(xpath = "//i[@title='Download Word']")
	WebElement wordDownload2;
	@FindBy(xpath = "//i[@title='Download Excel']")
   List <WebElement> excelDownload;
    @FindBy(xpath = "//i[@title='Download Word']")
    List<WebElement> wordDownload;
    @FindBy(xpath = "//div[@class='progress custom-progress']")
	List<WebElement> profileCompletenessBar;
    @FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@ng-bind='member.MemberName']")
	List<WebElement> totalResult;
	@FindBy(xpath = "//span[@class='select2-selection__choice__remove']")
	WebElement cancelICON;
	@FindBy(xpath = "//div[@class='text-center return-mess well']//h4")
	WebElement warning;
	@FindBy(xpath = "//p[normalize-space()=\"There aren't any members here.\"]")
    WebElement warning2;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li")
	WebElement BusinessCategoryvalue1;	
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[2]")
	WebElement BusinessCategoryvalue2;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[3]")
	List<WebElement> BusinessCategoryvalue3;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[4]")
	List<WebElement> BusinessCategoryvalue4;
	@FindBy(xpath = "//ul[@id='select2-BusinessCategoryIDs-results']//li[5]")
	List<WebElement> BusinessCategoryvalue5;
	@FindBy(xpath = "//ul[@class='select2-results__options']//li")
	List<WebElement> BusinessCategoryList;
	@FindBy(xpath = "//span[@ng-bind='member.Address']")
	WebElement memberAddress;
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[4]/div[2]/div[1]/div")
	WebElement toastMessage;
	@FindBy(xpath = "//span[@ng-bind='member.OrganizationName | limitTo:14']")
	WebElement memberOrganisation;
	@FindBy(xpath = "//*[@ng-repeat='member in data.members|itemsPerPage:data.pagesize'][1]")
	WebElement Allmembers;
	@FindBy(xpath = "//*[@ng-repeat='member in data.members|itemsPerPage:data.pagesize']")
	List<WebElement> membersDiv;
	@FindBy(xpath = "//div[@class='row member-directory-page']//div[2]//div[1]//div[1]//div[2]//a[1]//strong[1]//div[1]")
	WebElement memberNameAndrew;
	@FindBy(xpath = "//div[@class='directory-name firstletterCap ng-binding']")
	WebElement memberName;
	@FindBy(xpath = "//ul[@id='select2-WhoAmIs-results']")
	WebElement profileCategoryList;
	@FindBy(xpath = "//li[@role='treeitem']")
	WebElement errorOfProfileCategory;
	@FindBy(xpath = "//li[@title='greatness']//span[@role='presentation'][normalize-space()='×']")
	WebElement greatnesscancelBtn;
	@FindBy(xpath = "//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@class='row member-directory-page']/div[@class='col-lg-9 ng-scope']/div/div[@class='row directory-box']/div")
	WebElement resultOfProfileCategory;
	@FindBy(xpath = "//li[@title='Mentor']//span[@role='presentation'][normalize-space()='×']")
	WebElement mentorcancelBtn;
	@FindBy(xpath = "//div[@class='panel-body']")
	WebElement memberProfileCategory;
	@FindBy(xpath = "//ul[@id='select2-CommunityIDs-results']")
	WebElement communitiesList;
	@FindBy(xpath = "//span[@role='presentation'][normalize-space()='×']")
	WebElement cancelCommutiesBtn;
	@FindBy(xpath = "//i[@title='Download Word']")
	List<WebElement> wordDownload1;
	@FindBy(xpath = "//h4[normalize-space()='Sorry!']")
	WebElement errorBtnWhenMemberNotShowing;
	@FindBy(xpath = "//p[normalize-space()=\"There aren't any members here.\"]")
	WebElement errorBtnWhenMemberNotShowing2;
	@FindBy(xpath = "//h3[normalize-space()='Member Directory']")
	WebElement memberDirectoryHeader;	
	@FindBy(xpath = "//input[@id='membername']")
	WebElement searchMemberName;
	@FindBy(xpath = "//button[normalize-space()='Add Note']")
	WebElement addNote;
	
	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	WebElement titleOfAddNote;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Note']")
	WebElement Note;
	
	@FindBy(xpath = "//input[@name='IsReminder']")
	WebElement setReminder;
	
	@FindBy(xpath = "//input[@id='ReminderDate']")
	WebElement reminderDate;
	
	@FindBy(xpath = "/html/body/div[5]/div[3]/table")
	WebElement selectReminder;
	@FindBy(xpath = "/html/body/div[5]/div[2]/table/tbody/tr/td/span[@class=\"hour active\"]")
	WebElement currentHour;
	@FindBy(xpath = "/html/body/div[5]/div[1]/table/tbody/tr/td/span[@class=\"minute\"]")
	WebElement currentMinutes;
	@FindBy(xpath = "/html/body/div[5]/div[1]/table/tbody/tr/td/span[@class=\"minute\"]")
	List<WebElement> CurrentMinutes;
	
	@FindBy(xpath = "//div[@class='datetimepicker-minutes']//th[@class='next']")
	WebElement arrowButton;
	
	
	//@FindBy(xpath = "//*[@id = 'ReminderDate']")
	//WebElement reminderDate;/html/body/div[5]/div[2]/table/tbody/tr/td/span[@class="hour active"]
	
	@FindBy(xpath = "//span[@ng-show='profile.IsSaveNoteMode']")
	WebElement saveNote;
	
	@FindBy(xpath = "//a[@class='text-primary note-edit']")
	WebElement editNote;
	
	@FindBy(xpath = "//div[@class='col-lg-12']//div//div[1]//div[2]//div[2]//a[2]//i[1]")
	WebElement deleteNote;
	
	@FindBy(xpath = "//span[contains(text(),'Update')]")
	WebElement updateNote;
	
	@FindBy(xpath="//div[@class='toast toast-success']")
	WebElement toastMsg;
	@FindBy(xpath = "//div[@class='directory-name firstletterCap ng-binding']")
	WebElement memberSelected;

	


	
	
	
	
	
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
	public ProfilePage goToProfilePage() throws Exception {

		scrollIntoView(MemberProfileList);
		//Thread.sleep(5000);
		waitForElementToPresent(MemberProfileList);
		if(MemberProfileList.size() > 0) {
			click(MemberProfileList.get(0),"OpenMemberProfile");		
		}
		Thread.sleep(4000);
		return (ProfilePage) openPage(ProfilePage.class);
		// new MyProfilePage(driver, );
	}
	public MyProfilePage goToMyProfilePage() throws InterruptedException {
		scrollIntoView(MemberProfileList);
		//Thread.sleep(5000);
		waitForElementToPresent(MemberProfileList);
		if(MemberProfileList.size() > 0) {
			click(MemberProfileList.get(0),"OpenMemberProfile");		
		}
		
		return (MyProfilePage) openPage(MyProfilePage.class);
		// new CreateCommunityPage(driver);
	}
	public ProfilePage gotoJohnProfilepage() throws InterruptedException {
		scrollIntoView(MemberProfileList);
		//Thread.sleep(5000);
		waitForElementToPresent(MemberProfileList);
		if(MemberProfileList.size() > 0) {
			click(MemberProfileList.get(0),"OpenMemberProfile");		
		}
		return (ProfilePage) openPage(ProfilePage.class);
		// new CreateCommunityPage(driver);
	}


	
	private void click(List<WebElement> memberProfile2, String elementName) {
		// TODO Auto-generated method stub
		
	}

	private void scrollIntoView(List<WebElement> memberProfile2) {
		// TODO Auto-generated method stub
		
	}

	public void profileComplenessViibility() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(0, profileCompletenessBar.size());
	
		System.out.println("ProfileCompletenessBar not is displaying");
	//Assert.assertTrue(true);
	}

	public void SearchElementViibility() throws InterruptedException {
		
		waitForElementToPresent(searchByName);
		waitForElementToPresent(searchByProfileCategory);
		waitForElementToPresent(searchBySkillAndInterest);
		waitForElementToPresent(searchByOrganisation);
		waitForElementToPresent(searchByCommunities);
		waitForElementToPresent(searchByBussinessCat);
		waitForElementToPresent(searchByGroup);
		//scrollIntoView(Send);
		waitForElementToPresent(searchByLocation);
	if(searchByName.isDisplayed()&&searchByProfileCategory.isDisplayed()&&searchBySkillAndInterest.isDisplayed()&&searchByOrganisation.isDisplayed()&&searchByCommunities.isDisplayed()&&searchByBussinessCat.isDisplayed()&&searchByGroup.isDisplayed()&&searchByLocation.isDisplayed()) {
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
	
	
	public void searchFields(String MemberName, String location,String ProfileCat, String OrganisationName,String Communities,
			String Groups, String SkillAndInterest  ) throws InterruptedException {
			
		
		waitForElementToPresent(this.searchByName);
		type(this.searchByName,MemberName, "Member Name");		
		click(searchBtn , "Search button");
		this.searchByName.clear();
		
		waitForElementToPresent(this.searchByLocation);
		type(this.searchByLocation,location, "location");
		click(searchBtn , "Search button");
		this.searchByLocation.clear();
		
		waitForElementToPresent(this.searchByProfileCategory);
		//click(searchByProfileCategory, "Profile Category");
		type(this.searchByProfileCategory,ProfileCat , "Profile catagory");
		click(searchBtn , "Search button");
		this.searchByProfileCategory.clear();
		
		waitForElementToPresent(this.searchByOrganisation);
		type(this.searchByOrganisation,OrganisationName , "Organisation Name");
		click(searchBtn , "Search button");
		this.searchByOrganisation.clear();
		Thread.sleep(2000);
		waitForElementToPresent(this.searchBySkillAndInterest);
		type(this.searchBySkillAndInterest,SkillAndInterest , "Skill and Interest");
		click(searchBtn , "Search button");
		waitForElementToPresent(membersDiv);
		if(membersDiv.size() > 0) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		Thread.sleep(4000);
		waitForElementToPresent(this.searchByCommunities);
		type(this.searchByCommunities,Communities , "Communities");
		Thread.sleep(2000);
		click(searchBtn , "Search button");
		this.searchByCommunities.clear();
		
		waitForElementToPresent(this.searchByGroup);
		type(this.searchByGroup,Groups , "Group");
		click(searchBtn , "Search button");
		this.searchByGroup.clear();
		
		
	}
	
			
			public void ClickonSkillAndInterest(String SkillAndInterest) throws InterruptedException {
				Thread.sleep(5000);
				
				searchBySkillAndInterest.click();
				String Skilllist=skillCategoryList.getText();
				System.out.println(Skilllist);
				if(Skilllist.contains("Hockey")) {
					System.out.println("Skill list contains list of values");
				}else System.out.println("Skill list not asserted");
				Thread.sleep(2000);	
				searchBySkillAndInterest.click();
				Select select=new Select(driver.findElement(By.xpath("//select[@id='skillsInterests']")));
				//select.selectByVisibleText("Hockey");
				//select.selectByVisibleText("running race");				
				String[] skillArr = SkillAndInterest.split(",");
				for(int i=0;i<skillArr.length;i++) {
					select.selectByVisibleText(skillArr[i]);
				}
				
				try {
					select.selectByVisibleText("Hockey");
					
				}catch(Exception e) {
					System.out.println("Element cannot be selected again");
					
				}
				if(runningcancelBtn.isDisplayed()) {
					System.out.println("running race cancel button is displayed");
					Assert.assertTrue(true);
				}
								
				click(searchBtn,"search");
				Thread.sleep(3000);
				
				if(resultOfSkills.isDisplayed()) {
					System.out.println("Skills and Interest search result is displaying");
					Assert.assertTrue(true);
					
				}
			}

			public void ClickOnOrganisation(String Organisation1 , String organisation) throws InterruptedException {
				waitForElementToPresent(this.searchByOrganisation);
				type(this.searchByOrganisation,Organisation1 , "Organisation Name");
				click(searchBtn , "Search button");
				waitForElementToPresent(this.Allmembers);
				if(Allmembers.isDisplayed()) {
					System.out.println("All organisation displayed");
					Assert.assertTrue(true);
				}
				Thread.sleep(4000);
				this.searchByOrganisation.clear();
				waitForElementToPresent(this.searchByOrganisation);
				type(this.searchByOrganisation,organisation , "Organisation Name");
				click(searchBtn , "Search button");
				Thread.sleep(3000);
				   String Message=this.warning.getText();
	                String message2=this.warning2.getText();
					System.out.println("Warning msg:" + Message);
					System.out.println("Warning msg:" + message2);
					AssertionHelper.verifyText(warning.getText(), "Sorry!");	
					AssertionHelper.verifyText(warning2.getText(), "There aren't any members here.");  
				}
			public void ClickonBusinessCategory(String bussinessCategory,String BussinessCategory1) throws InterruptedException {
				//Thread.sleep(5000);
				waitForElementToPresent(searchByBussinessCat);
				click(searchByBussinessCat, "Bussiness Category");
				this.searchByBussinessCat.sendKeys(bussinessCategory);
				//type(searchByBussinessCat, bussinessCategory, "BussinessCategory");
				Actions ac = new Actions(driver);
		        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		        Thread.sleep(2500);
		        ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		        Thread.sleep(2500);
		        ac.sendKeys(Keys.ENTER).build().perform();
				//type(this.searchByBussinessCat,bussinessCategory, "Business Category");
				Thread.sleep(1000);
				/*List<WebElement> options=this.BusinessCategoryList;
				for(WebElement option: options) {
					if(option.getText().equalsIgnoreCase("Accommodation"))
					{
						option.click();		
						break;
					}
					
				}
			   // waitForElementToPresent(this.searchByBussinessCategory);
				type(this.searchByBussinessCategory,BussinessCategory1, "Business Category1");
				List<WebElement> options1=this.BusinessCategoryList;
				for(WebElement option1: options1) {
					if(option1.getText().equalsIgnoreCase("Accommodation and Food Services"))
					{
						option1.click();
						break;
					}
				}
				*/
				//type(this.searchByBussinessCategory,BusinessCategoryList, "Business Category");
				//String BusinessListList = this.searchByBussinessCategory.getText();
				//System.out.println("List is :" +BusinessListList);
				//String BusinesssArray[] = BusinessCategoryList.split(",");
				//CheckSearchResult(this.totalResult,SkillAndInterest);
				//selectUsingIndex(this.searchByBussinessCategory,0,"Business Category");	
			}
				
			private void waitForElementToPresent(List<WebElement> businessCategoryList2) {
				// TODO Auto-generated method stub
				
			}

			private void waitForElementToPresent(List<WebElement> BusinessCategoryvalue1,
					List<WebElement> BusinessCategoryvalue2, List<WebElement> BusinessCategoryvalue3,List<WebElement> BusinessCategoryvalue4,List<WebElement> BusinessCategoryvalue5) {
				// TODO Auto-generated method stub
				
			}

			public void ClickOnLocation(String Location ) throws InterruptedException  {
				waitForElementToPresent(this.searchByLocation);
				type(this.searchByLocation,Location , "Location");
				click(searchBtn , "Search button");
				Thread.sleep(5000);
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
				Assert.assertTrue(true);
				
				
				waitForElementToPresent(this.searchByName);
				type(searchByName, ExpiredName,"Search by Name");
		    	click(searchBtn,"search btn");
				Thread.sleep(3000);
                String Message=this.warning.getText();
                String message2=this.warning2.getText();
				System.out.println("Warning msg:" + Message);
				System.out.println("Warning msg:" + message2);
				AssertionHelper.verifyText(warning.getText(), "Sorry!");	
				AssertionHelper.verifyText(warning2.getText(), "There aren't any members here.");
				}
				
			public void excelAndwordDisplay() throws InterruptedException  {
				boolean md=memberdirectory.isDisplayed();
				System.out.println(md);
				Thread.sleep(10000);
			    Assert.assertEquals(0, wordDownload.size());
			    Assert.assertEquals(0, excelDownload.size());

				/*if(excelDownload==null) {
					System.out.println("excel not displayed");
					Assert.assertTrue(true);
					if(wordDownload==null) {
						System.out.println("word not displayed");
						Assert.assertTrue(true);
					}
					else {
						Assert.assertTrue(false);
					}
				}*/
				
				}
			public  ProfilePage MemberWithPendingEndorsement(String MemberName) throws InterruptedException {
				
				type(searchByName,MemberName,"Name of Member");//search pending member
				click(searchBtn,"search");
				Thread.sleep(3000);
				 memberNameAndrew.click();
				 Thread.sleep(3000);
				return (ProfilePage) openPage(ProfilePage.class);
				
				
		}
				
			public  ProfilePage MemberWithRejectedEndorsement(String MemberName) throws InterruptedException {
				Thread.sleep(2000);
				type(searchByName,MemberName,"Name of Member");//search pending member
				click(searchBtn,"search");
				Thread.sleep(5000);
				memberName.click();
				 Thread.sleep(8000);
				return (ProfilePage) openPage(ProfilePage.class);
				
				
		}
			
			public void profileCategoryList() throws InterruptedException {
				searchByProfileCategory.click();
				String profilelist=profileCategoryList.getText();
				System.out.println(profilelist);
				if(profilelist.contains("Mentor")) {
					System.out.println("Profile list contains list of values");
				}else System.out.println("Profile list not asserted");
				Thread.sleep(2000);	
				searchByProfileCategory.click();
				Select select=new Select(driver.findElement(By.xpath("//select[@id='WhoAmIs']")));
				select.selectByVisibleText("Mentor");
				select.selectByVisibleText("Great");
				for(int i=2;i<10;i++) {
				select.selectByIndex(i);
				}
				try {
					select.selectByIndex(10);
					select.selectByIndex(11);
					Thread.sleep(3000);
					picture();
					String error=errorOfProfileCategory.getText();
					System.out.println(error);
					System.out.println("you can not add more than 10 elements");
				}catch(Exception e) {
					System.out.println("you can add more than 10 profile category elements");
					
				}
				try {
					select.selectByVisibleText("Mentor");
					
				}catch(Exception e) {
					System.out.println("Element cannot be selected again");
					
				}
				/*if(greatnesscancelBtn.isDisplayed()) {
					System.out.println("greatness cancel button is displayed");
					Assert.assertTrue(true);
				}*/
				if(mentorcancelBtn.isDisplayed()) {
					System.out.println("mentor cancel button is displayed");
					Assert.assertTrue(true);
				}
				if(resultOfProfileCategory.isDisplayed()) {
					System.out.println("Profile Category search result is displaying");
					
				}
				click(searchBtn,"search");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[normalize-space()='Alen Border']")).click();
				Thread.sleep(8000);
				
				System.out.println("checking member profile");
				String memprofile=memberProfileCategory.getText();
				System.out.println(memprofile);
				if(memprofile.contains("Mentor")) {
					Assert.assertTrue(true);
				}
				
				//searchProfileCategorywithValues.clear();		
			}
			public void searchCommunitiesList() throws InterruptedException {
				searchByCommunities.click();
				String communitylist=communitiesList.getText();
				//int beginInt=communitylist.indexOf("Chamber of commerce viswanadh");
				//int endInt=communitylist.lastIndexOf("Chamber of commerce viswanadh");
				//System.out.println("value of i is"+ beginInt);
				System.out.println(communitylist);
				if(communitylist.contains("Chamber of commerce viswanadh")) {
					System.out.println("Community list contains list of values");
				}else 
					System.out.println("Community list not asserted");
				Thread.sleep(2000);	
				searchByCommunities.click();
				Select select=new Select(driver.findElement(By.xpath("//select[@id='CommunityIDs']")));
				select.selectByVisibleText("Chamber of commerce viswanadh");
				select.selectByVisibleText("Chambers and Partners");
				for(int i=2;i<3;i++) {
				select.selectByIndex(i);
				}
				try {
					select.selectByIndex(3);
					select.selectByIndex(4);
					Thread.sleep(3000);
					picture();
					String error=errorOfProfileCategory.getText();
					System.out.println(error);
					System.out.println("you can not add more than 3 Communities elements");
				}catch(Exception e) {
					System.out.println("you can add more than 3 Communities elements");
					
				}
				try {
					select.selectByVisibleText("Chamber of commerce viswanadh");
					System.out.println("Element can be selected again");
				}catch(Exception e) {
					System.out.println("Element cannot be selected again");
					
				}
				if(cancelCommutiesBtn.isDisplayed()) {
					System.out.println("cancel button is displayed");
					Assert.assertTrue(true);
				}
				/*if(mentorcancelBtn.isDisplayed()) {
					System.out.println("mentor cancel button is displayed");
					Assert.assertTrue(true);
				}*/
				if(resultOfProfileCategory.isDisplayed()) {
					System.out.println("Profile Category search result is displaying");
					
				}
			}
			public void searchPendingMember(String MemberName) throws InterruptedException {
				
				type(searchByName,MemberName,"Name of Pending Member");//search pending member
				click(searchBtn,"search");
				Thread.sleep(3000);
				Assert.assertEquals(0, wordDownload1.size());
				String memberError=errorBtnWhenMemberNotShowing.getText();
				String memberError2=errorBtnWhenMemberNotShowing2.getText();
				
				System.out.println("Member can not be searched and error message is dispalyed: "+memberError+"\n"+memberError2);
				Assert.assertEquals("Sorry!", memberError);
				
			}
			
			public void downloadExcelFile(String path) throws InterruptedException {		
				
				//String name=excelDownload.getAttribute("href");
				String name="AllMembers.xls";
			    String name1="AllMembers.doc";
				System.out.print("update file name" +name);
			    click(excelDownload1,"download file");
			    log.info("downloading excel file");
			    Thread.sleep(12000);
			    click(wordDownload2,"download file");
			    log.info("downloading doc file");
			    Thread.sleep(10000);
			    
			    if (CheckFile(path,name))//we check if the directory or folder exists
			    {
			    	log.info("asserting whether excel file downloaded");
			    	Assert.assertTrue(true);
			    }
			                        
			        else
			        {
			        	log.info("asserting excel file not downloaded");
			            Assert.assertTrue(false);
			        }
			    
			    if (CheckFile(path,name1))//we check if the directory or folder exists
			    {
			    	log.info("asserting whether word file downloaded");
			    	Assert.assertTrue(true);
			    }
			                        
			        else
			        {
			        	log.info("asserting word file not downloaded");
			            Assert.assertTrue(false);
			        }
			   
			}
			
			public boolean CheckFile(String path,String name) // the name of the zip file which is obtained, is passed in this method
			{
				log.info("Making string of file name and path");
				System.out.println(name);
			    String currentFile = path+"/"+name+"" ;
			    System.out.println(currentFile);
			    File f=new File(currentFile);
			    if (f.exists()) //helps to check if the zip file is present
			    { 
			    	log.info("checking size of file");
			    	if(f.length()>0 ){  
			    		DeleteFilesAndDirectory(f);
			    		return true; //if the zip file exists return boolean true
			    	}else {
			    		DeleteFilesAndDirectory(f);
			    		return false;
			    	}
			    }
			    else
			    {
			        return false; // if the zip file does not exist return boolean false
			    }
			}
			public void DeleteFilesAndDirectory(File f)
			{
			   
				    log.info("Deleting files");
			        f.delete(); //delete the downloaded zip file
			    
			}  
				
			public void searchMemberWithAllDetails(String name, String profile, String skills, String organisation, String community, String businessCategory, String group, String location) throws InterruptedException {
				type(searchByName,name,"name");
				type(searchByProfileCategory,profile,"profile");
				Thread.sleep(2000);
				type(searchBySkillAndInterest,skills,"Skills");
				type(searchByOrganisation,organisation,"organization name");
				type(searchByGroup,group,"groups");
				type(searchByLocation,location,"location");
				click(searchBtn,"search");
				Thread.sleep(5000);
				String Member=memberName.getText();
				System.out.println("Matching Member is:"+ Member);
				Assert.assertEquals(name, Member);
			}
			
			public void searchMember(String FirstName, String LastName) throws InterruptedException {
				System.out.println("Asserting Page Title:");
				String header=memberDirectoryHeader.getText();
				System.out.println("header of the page is "+header);
				Assert.assertEquals("MEMBER DIRECTORY",memberDirectoryHeader.getText());
				
				type(searchByName,LastName,LastName);//search with last name
				click(searchBtn,"search");
				Thread.sleep(3000);
				String Membername=memberName.getText();
				if(Membername.contains(LastName)) {
					System.out.println("Search Member is validated");
				}
				
				searchByName.clear();//clear out first name
				Thread.sleep(3000);
				type(searchByName,FirstName,FirstName);//search with first name
				click(searchBtn,"search");
				
				if(Membername.contains(FirstName)) {
					System.out.println("Search Member is validated");
				}
				
				searchByName.clear();//clear out the last name
				Thread.sleep(3000);
			}
			public void editNoteOfAMember(String Name,String NewTitle) throws Exception {
				type(searchMemberName,Name,Name);
				click(searchBtn,"Search");
				Thread.sleep(2000);
				click(memberSelected,Name);
				Thread.sleep(3000);
				click(editNote,"Edit Notes");
				type(titleOfAddNote,NewTitle,NewTitle);
				Thread.sleep(2000);
				click(setReminder,"Set reminder");
				click(this.reminderDate, "reminderDate");
			    waitForElementToPresent(selectReminder);
			    Thread.sleep(2000);
			    DateManager d3 = new DateManager(driver);
			    String date3 = d3.getCurrentDateString();
			    //date3=date3+1;
			    d3.selectDate("/html/body/div[5]/div[3]/table",date3);
			    Thread.sleep(2000);
			    click(currentHour,"current hour");
			    if(CurrentMinutes.size()>0) {
			    click(currentMinutes,"current time");
			    }else {
			    	click(arrowButton,"Click next");
			    	click(currentMinutes,"current time");
			    }	    
			   Thread.sleep(2000);
			   click(updateNote,"Update");
			
			}
			public void deleteNoteOfAMember(String Name) throws InterruptedException {
				type(searchMemberName,Name,Name);
				click(searchBtn,"Search");
				Thread.sleep(2000);
				click(memberSelected,Name);
				Thread.sleep(3000);
				click(deleteNote,"Delete Notes");
				Thread.sleep(2000);
				System.out.println(toastMsg.getText());
			    if(toastMsg.getText().equalsIgnoreCase("Success!"+"\n"+"Note deleted.")) {	    	
			    	System.out.println("Note deleted!!");
			    	Assert.assertTrue(true);
			    }else {
			    	System.out.println("Unable to create new reminder");
			    	Assert.assertTrue(false);
			    }	
				
				
			}
			public void searchMemberToAddReminder(String Name,String Title,String Notes) throws Exception {
				type(searchMemberName,Name,Name);
				click(searchBtn,"Search");
				Thread.sleep(2000);
				click(memberSelected,Name);
				Thread.sleep(3000);
				click(addNote,"Add note");
				type(titleOfAddNote,Title,Title);
				type(Note,Notes,Notes);
				click(setReminder,"Set reminder");
				click(this.reminderDate, "reminderDate");
			    waitForElementToPresent(selectReminder);
			    
			    DateManager d3 = new DateManager(driver);
			    String date3 = d3.getCurrentDateString();
			    //date3=date3+1;
			    d3.selectDate("/html/body/div[5]/div[3]/table",date3);
			    Thread.sleep(2000);
			    click(currentHour,"current hour");
			    if(CurrentMinutes.size()>0) {
			    click(currentMinutes,"current time");
			    }else {
			    	click(arrowButton,"Click next");
			    	click(currentMinutes,"current time");
			    }	    
			   Thread.sleep(2000);
			    click(saveNote,"Save note with reminder");
			    Thread.sleep(2000);
			    System.out.println(toastMsg.getText());
			    if(toastMsg.getText().equalsIgnoreCase("Success!"+"\n"+"Note saved.")) {	    	
			    	System.out.println("New Reminder Created!!");
			    	Assert.assertTrue(true);
			    }else {
			    	System.out.println("Unable to create new reminder");
			    	Assert.assertTrue(false);
			    }	
			}



			
			}
			
			

	
	
	




