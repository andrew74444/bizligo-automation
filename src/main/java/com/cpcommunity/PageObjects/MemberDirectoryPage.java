package com.cpcommunity.PageObjects;

import java.io.File;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class MemberDirectoryPage extends BasePage{
	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//input[@id='membername']")
	WebElement searchMemberName;
	
	@FindBy(xpath = "//input[@id='memberlocation']")
	WebElement searchLocation;
	
	@FindBy(xpath = "//h3[normalize-space()='Member Directory']")
	WebElement memberDirectoryHeader;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement searchOrganizationName;
	
	@FindBy(xpath = "//input[@placeholder='Search by Profile Category']")
	WebElement searchByProfileCategory;
	
	@FindBy(xpath = "//*[@id=\"removeinnercss\"]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/span/span[1]/span/ul")
	WebElement searchProfileCategorywithValues;
	
	@FindBy(xpath = "//input[@placeholder='Search by Communities (Upto 3)']")
	WebElement searchByCommunities;
	
	@FindBy(xpath = "//input[@placeholder='Search by Business Categories (Upto 5)']")
	WebElement searchByBusiness;
	
	@FindBy(xpath = "//input[@placeholder='Search by Skills and Interests']")
	WebElement searchBySkills;
	
	@FindBy(xpath = "//input[@placeholder='Select Groups (Limit 3)']")
	WebElement searchBySelectGroups;
	
	@FindBy(xpath = "//div[@class='directory-name firstletterCap ng-binding']")
	WebElement memberName;
	
	@FindBy(xpath = "//ul[@id='select2-WhoAmIs-results']")
	WebElement profileCategoryList;
	
	@FindBy(xpath = "//ul[@id='select2-CommunityIDs-results']")
	WebElement communitiesList;
	
	@FindBy(xpath = "//li[@id='select2-WhoAmIs-result-wkf9-mentor']")
	WebElement mentor;
	
	@FindBy(xpath = "//li[@id='select2-WhoAmIs-result-mlby-greatness']")
	WebElement greatness;
	
	@FindBy(xpath = "//li[@title='mentor']//span[@role='presentation'][normalize-space()='×']")
	WebElement mentorcancelBtn;
	
	@FindBy(xpath = "//span[@class='select2-selection__choice__remove']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//span[@role='presentation'][normalize-space()='×']")
	WebElement cancelCommutiesBtn;
	
	@FindBy(xpath = "//div[@class='panel-body']")
	WebElement memberProfileCategory;
	
	@FindBy(xpath = "//li[@title='greatness']//span[@role='presentation'][normalize-space()='×']")
	WebElement greatnesscancelBtn;
	

	@FindBy(xpath = "//body/div[@class='main-home-cont']/div[@id='wrapper']/div[@id='body']/section[@id='renderBodyConatiner']/div[@id='removeinnercss']/div[@class='row member-directory-page']/div[@class='col-lg-9 ng-scope']/div/div[@class='row directory-box']/div")
	WebElement resultOfProfileCategory;
	
	@FindBy(xpath = "///div[@class='row directory-box']")
	WebElement resultOfCommunitySearch;
	

	@FindBy(xpath = "//li[@role='treeitem']")
	WebElement errorOfProfileCategory;
	
	@FindBy(xpath = "//input[@placeholder='Search by Communities (Upto 3)']")
	WebElement searchByCommunity;
	
	@FindBy(xpath = "//h4[normalize-space()='Sorry!']")
	WebElement errorBtnWhenMemberNotShowing;
	
	@FindBy(xpath = "//p[normalize-space()=\"There aren't any members here.\"]")
	WebElement errorBtnWhenMemberNotShowing2;
	
	@FindBy(xpath = "//i[@title='Download Excel']")
	WebElement excelDownload;
	
	@FindBy(xpath = "//i[@title='Download Word']")
	WebElement wordDownload;
	
	@FindBy(xpath = "//i[@title='Download Word']")
	List<WebElement> wordDownload1;
	
	@FindBy(xpath = "//div[@class='row member-directory-page']//div[2]//div[1]//div[1]//div[2]//a[1]//strong[1]//div[1]")
	WebElement memberNameAndrew;
	
	//div[@class='row member-directory-page']//div[2]//div[1]//div[1]//div[2]//a[1]//strong[1]//div[1]
	
	
	
	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
	}
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(memberDirectoryHeader);
	}
	
	public void searchMemberWithAllDetails(String name, String profile, String skills, String organisation, String community, String businessCategory, String group, String location) throws InterruptedException {
		type(searchMemberName,name,"name");
		type(searchByProfileCategory,profile,"profile");
		type(searchBySkills,skills,"Skills");
		type(searchOrganizationName,organisation,"organization name");
		type(searchBySelectGroups,group,"groups");
		type(searchLocation,location,"location");
		click(searchBtn,"search");
		Thread.sleep(3000);
		String Member=memberName.getText();
		System.out.println("Matching Member is:"+ Member);
		Assert.assertEquals(name, Member);
	}

	public void searchMember(String FirstName, String LastName) throws InterruptedException {
		System.out.println("Asserting Page Title:");
		String header=memberDirectoryHeader.getText();
		System.out.println("header of the page is "+header);
		Assert.assertEquals("MEMBER DIRECTORY",memberDirectoryHeader.getText());
		
		type(searchMemberName,LastName,LastName);//search with last name
		click(searchBtn,"search");
		String Membername=memberName.getText();
		if(Membername.contains(LastName)) {
			System.out.println("Search Member is validated");
		}
		
		searchMemberName.clear();//clear out first name
		Thread.sleep(3000);
		type(searchMemberName,FirstName,FirstName);//search with first name
		click(searchBtn,"search");
		
		if(Membername.contains(FirstName)) {
			System.out.println("Search Member is validated");
		}
		
		searchMemberName.clear();//clear out the last name
		Thread.sleep(3000);
	}
	
	public void searchPendingMember(String MemberName) throws InterruptedException {
		
		type(searchMemberName,MemberName,"Name of Pending Member");//search pending member
		click(searchBtn,"search");
		Thread.sleep(3000);
		Assert.assertEquals(0, wordDownload1.size());
		String memberError=errorBtnWhenMemberNotShowing.getText();
		String memberError2=errorBtnWhenMemberNotShowing2.getText();
		
		System.out.println("Member can not be searched and error message is dispalyed: "+memberError+"\n"+memberError2);
		Assert.assertEquals("Sorry!", memberError);
		
	}
    public  ProfilePage MemberWithPendingEndorsement(String MemberName) throws InterruptedException {
		
		type(searchMemberName,MemberName,"Name of Member");//search pending member
		click(searchBtn,"search");
		Thread.sleep(3000);
		 memberNameAndrew.click();
		 Thread.sleep(3000);
		return (ProfilePage) openPage(ProfilePage.class);
		
		
}

 public  ProfilePage MemberWithRejectedEndorsement(String MemberName) throws InterruptedException {
		Thread.sleep(2000);
		type(searchMemberName,MemberName,"Name of Member");//search pending member
		click(searchBtn,"search");
		Thread.sleep(3000);
		memberName.click();
		 Thread.sleep(3000);
		return (ProfilePage) openPage(ProfilePage.class);
		
		
}

	public void profileCategoryList() throws InterruptedException {
		searchByProfileCategory.click();
		String profilelist=profileCategoryList.getText();
		System.out.println(profilelist);
		if(profilelist.contains("mentor")) {
			System.out.println("Profile list contains list of values");
		}else System.out.println("Profile list not asserted");
		Thread.sleep(2000);	
		searchByProfileCategory.click();
		Select select=new Select(driver.findElement(By.xpath("//select[@id='WhoAmIs']")));
		select.selectByVisibleText("mentor");
		select.selectByVisibleText("greatness");
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
			select.selectByVisibleText("mentor");
			
		}catch(Exception e) {
			System.out.println("Element cannot be selected again");
			
		}
		if(greatnesscancelBtn.isDisplayed()) {
			System.out.println("greatness cancel button is displayed");
			Assert.assertTrue(true);
		}
		if(mentorcancelBtn.isDisplayed()) {
			System.out.println("mentor cancel button is displayed");
			Assert.assertTrue(true);
		}
		if(resultOfProfileCategory.isDisplayed()) {
			System.out.println("Profile Category search result is displaying");
			
		}
		click(searchBtn,"search");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[normalize-space()='Andrew Thomson']")).click();
		Thread.sleep(6000);
		String memprofile=memberProfileCategory.getText();
		System.out.println(memprofile);
		if(memprofile.contains("mentor")) {
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
		
		public void downloadExcelFile(String path) throws InterruptedException {		
		
		//String name=excelDownload.getAttribute("href");
			String name="AllMembers.xls";
		    String name1="AllMembers.doc";
		System.out.print("update file name" +name);
	    click(excelDownload,"download file");
	    log.info("downloading excel file");
	    Thread.sleep(10000);
	    click(wordDownload,"download file");
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
		
	


}

