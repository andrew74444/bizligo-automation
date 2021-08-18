package com.cpcommunity.testScrips.communityWidget;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Discussions;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1168_Verify_mostRecent_Discussion_Displaying extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1168(Hashtable<String,String> data) throws Exception {
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1168", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
	GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	GCP.searchCommunity(data.get("community"));
    Discussions D=GCP.navigatetoDiscussionPage();
    D.addComment(data.get("Disccusion"), data.get("postComment"));
    D.recentPost();
	 
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1168 Test Completed");
		
		quit();
		
	}
}
