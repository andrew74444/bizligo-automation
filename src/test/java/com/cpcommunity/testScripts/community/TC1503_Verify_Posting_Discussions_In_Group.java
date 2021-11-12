package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC1503_Verify_Posting_Discussions_In_Group extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1503(Hashtable<String,String> data) throws Exception {
			
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1503", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage ecosystem = login.loginToApplication(data.get("email"),data.get("password"));
		GlobalCommunitesPage GL = ecosystem.goToGlobalCommunities();
		CommunityDetailsPage communityDetails = GL.navigateToCommunityDetailsPage(data.get("communityName"));
		GroupDetailsPage GroupDetailsPage = communityDetails.navigateToGroupDetailsPage(data.get("groupName"));
		GroupDetailsPage.postDiscussions(data.get("discussionTitle"),data.get("postContent"), data.get("tagMembers"));
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1503 Test Completed");
		
		quit();
		
	}

}
