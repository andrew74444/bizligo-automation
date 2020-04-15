package com.cpcommunity.testScripts.notifications;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.Discussions;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.GroupDetailsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

import com.cpcommunity.testScripts.community.BaseTest;
public class TC204_GroupTagMemberInComment extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC204(Hashtable<String,String> data) throws Exception {
			
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC204", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+getAndrew()+" and Password entered as "+getPassword());
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		GlobalCommunitesPage GlobalCommunitesPage = Dashboard_Page.naviagtingToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		GroupDetailsPage GroupDetailsPage = CommunityDetailsPage.navigateToGroupDetailsPage(data.get("groupName"));
		Discussions discussions = GroupDetailsPage.sharePosts();
		discussions.tagMemberInComment(data.get("postMessage"), data.get("postComment"));
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
