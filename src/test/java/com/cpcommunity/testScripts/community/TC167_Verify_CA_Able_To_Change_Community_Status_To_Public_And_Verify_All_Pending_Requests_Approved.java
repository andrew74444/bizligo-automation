package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityPendingRequestsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EditCommunityPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC167_Verify_CA_Able_To_Change_Community_Status_To_Public_And_Verify_All_Pending_Requests_Approved extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC167(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC167", data.get("Runmode"), excel);
		log.info("Inside TC167 Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		GlobalCommunitesPage GlobalCommunitesPage = Dashboard_Page.naviagtingToGlobalCommunities();
		GlobalCommunitesPage.JoinPrivateCommunity(data.get("communityName")+" "+date());
		home = Dashboard_Page.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		EditCommunityPage EditCommunityPage = CommunityDashboardPage.navigateToEditCommunityPage();
		CommunityDashboardPage = EditCommunityPage.updateCommunityType(data.get("type"));
		CommunityPendingRequestsPage communityPendingRequestsPage =CommunityDashboardPage.NavigateToCommunityPendingRequets();
		communityPendingRequestsPage.verifyNoPendingRequests();
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC167 Test Completed");
		
		quit();
		
	}

}
