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

public class TC139_Approve_Advertisement_By_CA_And_Verify_The_Ad_Dispplayed_In_Community_Details_Page extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC132(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC132", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
			
		MyCommunitiesPage myCommunitiesPage=EcoSystemPage.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		ManageMemberAdvertisementsPage manageMemberAdvertisementsPage =communityDashboardPage.navigateToMemberAdvertisements();
		manageMemberAdvertisementsPage.approveAd(data.get("planName"),data.get("adImage"),data.get("linkUrl"));

		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
