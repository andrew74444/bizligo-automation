package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC072_Community_Admin_Approve_And_Reject_Group_Requests extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC072(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC072", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email1"), data.get("password"));
		

		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.PrivateGroupJoinedSuccessfully(data.get("groupName"));
		Thread.sleep(8000);	
		home = EcoSystemPage.logout();
		
		

		home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email2"), data.get("password"));
		
//		EcoSystemPage.verifySuccessLogin();
		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.PrivateGroupJoinedSuccessfully(data.get("groupName"));
		Thread.sleep(8000);	
		home = EcoSystemPage.logout();	
		
		
		
		home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
			
//		EcoSystemPage.verifySuccessLogin();
		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();		
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));		
		GroupsPendingRequestsPage GroupsPendingRequestsPage = CommunityDashboardPage.NavigateToCommunitygroupPendingRequets();
		GroupsPendingRequestsPage.approveMember(data.get("email1"));
		GroupsPendingRequestsPage.rejectMember(data.get("email2"), data.get("rejectReason"));
		// Udate te emai
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
