package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC167_Verify_CA_Able_To_Change_Community_Status_To_Public_And_Verify_All_Pending_Requests_Approved extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC167(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC167", data.get("Runmode"), excel);
		log.info("Inside TC167 Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
	//	login = home.clickOnLOGINBtn();
//		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email2"), data.get("password2"));
//		
//		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
//		GlobalCommunitesPage.JoinPrivateCommunity(data.get("communityName"));//+" "+date()+" "+runTime
//		home = EcoSystemPage.logout();
//		login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));//+" "+runTime
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
