package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC100_Activate_Community_By_Community_Admin extends BaseTest {

		
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
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
		MyCommunitiesPage.activateCommunity(data.get("communityName"));
		GlobalCommunitesPage globalCommunitesPage=EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage communityDetailsPage= globalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		communityDetailsPage.verifyNoEvents();
		communityDetailsPage.VerifyNoGroups();
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC100 Test Completed");
		
		quit();
		
	}

}
