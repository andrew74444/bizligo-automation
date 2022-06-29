package com.cpcommunity.testScripts.Blogs;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TagsPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1189_verify_CA_cannot_make_tag_with_same_Name extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1189(Hashtable<String,String> data) throws Throwable {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1189", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
	MyCommunitiesPage mycommunities = EcoSystemPage.goToMyCommunities();

	CommunityDashboardPage communityDashboard = mycommunities.gotoManageCommunity(data.get("communityName"));
	 TagsPage tag=communityDashboard.gotoTags();
	 tag.sameNameTag(data.get("Name"),data.get("Description"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}	
}
