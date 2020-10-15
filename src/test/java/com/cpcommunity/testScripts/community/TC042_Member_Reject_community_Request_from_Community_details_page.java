package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC042_Member_Reject_community_Request_from_Community_details_page extends BaseTest {

		
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC041ToTC046(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC042", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+getElizabeth()+" and Password entered as "+getPassword());
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email6"),data.get("password"));
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.rejectCommunityRequest();
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC042 Test Completed");
		
		quit();
		
	}

}
