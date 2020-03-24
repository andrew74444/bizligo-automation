package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;

public class Create_Blog extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC194(Hashtable<String,String> data) throws Exception
	{

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC194", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginpage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginpage.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage mycommunities = myDashboardPage.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage = mycommunities.NaviagtetoManageCommunity(data.get("communityName"));
		CommunityBlogsPage communityBlogsPage = communityDashboardPage.gotoManageBlogs();
		communityBlogsPage.createBlog(data);
		CommunityDetailsPage communityDetailsPage = communityDashboardPage.navigateToCommunityDetailsPage(data);
		myDashboardPage = myDashboardPage.navigateToMyDashBoard();
		BlogsPage bolgsPage = myDashboardPage.goToBlogsPage();
		bolgsPage.searchPost(data.get("communityName"), data.get("title"));
		

		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
