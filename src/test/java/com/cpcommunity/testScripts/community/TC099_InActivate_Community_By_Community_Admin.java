package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC099_InActivate_Community_By_Community_Admin extends BaseTest {

		
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",priority=1)
	public void TC099(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC099", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage  = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		EditCommunityPage EditCommunityPage = CommunityDashboardPage.navigateToEditCommunityPage();
		EcoSystemPage = EditCommunityPage.inActiveCommunity();
		GlobalCommunitesPage globalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		globalCommunitesPage.checkInActivatedCommunityIsNotDisplayed(data.get("communityName"));
//		//Assert.fail("Failing the login test");
	}
	
	
	
	

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC099 Test Completed");
		
		quit();
		
	}

}
