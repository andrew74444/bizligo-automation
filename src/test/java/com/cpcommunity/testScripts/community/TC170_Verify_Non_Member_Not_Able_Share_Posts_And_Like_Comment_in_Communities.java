package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC170_Verify_Non_Member_Not_Able_Share_Posts_And_Like_Comment_in_Communities extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC170(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC170", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		EcoSystemPage EcoSystemPage = login.loginToApplication("andrew74444@gmail.com", data.get("password"));
//
//		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
//		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));//+" "+runTime
//		Discussions discussions =CommunityDetailsPage.sharePosts(data.get("PostMessage"), data.get("postFile"), data.get("linkURL"), data.get("linkName"), data.get("postImage"), data.get("postComment"));
//		discussions.addPosts(data.get("PostMessage"), data.get("postComment"));
//
//		Thread.sleep(8000);
//
//		home = EcoSystemPage.logout();
//		home.clickOnLOGINBtn();
		
		EcoSystemPage	EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage	 CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));//+" "+runTime
		Discussions	 discussions =CommunityDetailsPage.CheckNonMemberNotAbleTosharePosts();
	discussions.CheckNonMemberIsNotAbleToPostLikeComment();
		//Assert.fail("Failing the login test");
	//	CommunityDetailsPage.CheckNonMemberIsNotAbleToPostLikeComment();//added on 09/05
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC170 Test Completed");
		
		quit();
		
	}

}
