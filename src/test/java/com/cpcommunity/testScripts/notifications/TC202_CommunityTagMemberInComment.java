package com.cpcommunity.testScripts.notifications;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC202_CommunityTagMemberInComment extends BaseTest {

		
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC202(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC202", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		Discussions discussions =CommunityDetailsPage.sharePosts(data.get("PostMessage"), data.get("postFile"), data.get("linkURL"), data.get("linkName"), data.get("postImage"), data.get("postComment"));
		discussions.tagMemberInComment(data.get("tag"), data.get("postComment"));
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
