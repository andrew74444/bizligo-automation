package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC043_Member_Reject_Community_Request_From_Global_Community extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC043(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC043", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+getHarley()+" and Password entered as "+getPassword());
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		CommunityInviteMembersPage CommunityInviteMembersPage = CommunityDashboardPage.navigateToinvitePeople();
		CommunityInviteMembersPage.	invite(data.get("email1"));
		
		HomePage home1= CommunityInviteMembersPage.logOut();
		LoginPage login1 = home1.clickOnLOGINBtn();
		
		
		EcoSystemPage EcoSystemPage1 = login1.loginToApplication(data.get("email1"),data.get("password1"));
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage1.goToGlobalCommunities();
		GlobalCommunitesPage.rejectCommunity(data.get("communityName"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC043 Test Completed");
		
		quit();
		
	}

}
