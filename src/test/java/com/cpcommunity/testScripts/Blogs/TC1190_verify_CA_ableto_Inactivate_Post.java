package com.cpcommunity.testScripts.Blogs;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CategoriesPage;
import com.cpcommunity.PageObjects.CommunityBlogsPage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1190_verify_CA_ableto_Inactivate_Post extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1190(Hashtable<String,String> data) throws Throwable {
		
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1190", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	CategoriesPage categories=communityDashboard.gotoCategories();
	CommunityBlogsPage post=categories.checkPostCounts(data.get("Name"));
	post.inactivatePost(data.get("searchName"));
	CategoriesPage categories1=post.gotoCategoriespage();
	CommunityBlogsPage post1=categories1.checkPostCounts(data.get("Name1"));
	post1.activatePost(data.get("searchName1"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}	
}
