package com.cpcommunity.testScripts.advertisments;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC140_Reject_Advertisement_By_CA extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC140(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC132", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime =openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage=EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageMemberAdvertisementsPage manageMemberAdvertisementsPage =communityDashboardPage.navigateToMemberAdvertisements();
		manageMemberAdvertisementsPage.rejectAd(data.get("planName"));
		
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC132 Test Completed");
		
		quit();
		
	}

}
