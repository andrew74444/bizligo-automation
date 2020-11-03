package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC239_Verify_Tagging_Member_In_Community_Post extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC239(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC222", data.get("Runmode"), excel);
		log.info("Inside TC239 Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		Discussions discussions =CommunityDetailsPage.sharePosts(data.get("PostMessage"), data.get("postFile"), data.get("linkURL"), data.get("linkName"), data.get("postImage"), data.get("postComment"));
		discussions.tagMemberInPost(data.get("postMessage"),data.get("postComment"), data.get("memberName"));
		String d = discussions.getPostDate();
//		home = EcoSystemPage.logout();
//		login = home.clickOnLOGINBtn();
//		 EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
//		
//		 MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
//		 CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
//		 discussions = CommunityDetailsPage.sharePosts(data.get("PostMessage"), data.get("postFile"), data.get("linkURL"), data.get("linkName"), data.get("postImage"), data.get("postComment"));
//		 NotificationsPage notificationsPage =discussions.goToAllNotifications();
//		 notificationsPage.viewPost(d);
//		 
		 
		 
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC239 Test Completed");
		
		quit();
		
	}

}
