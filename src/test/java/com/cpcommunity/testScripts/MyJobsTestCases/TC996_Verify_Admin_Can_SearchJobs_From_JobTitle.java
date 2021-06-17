package com.cpcommunity.testScripts.MyJobsTestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC996_Verify_Admin_Can_SearchJobs_From_JobTitle extends BaseTest {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC996(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC996", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		MyCommunitiesPage MyCP = login.loginToApplicationMcp(data.get("email"), data.get("password"));
		 CommunityDashboardPage CDP= MyCP.gotoManageCommunity(data.get("communityName"));
		 ManageJobsPage MJP= CDP.navigateToManageJobsPage();
		 MJP.searchByJobTitle(data.get("JobTitle"), data.get("Location"),data.get("JobTypeID"),data.get("Status"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC996 Test Completed");
		
		quit();
}
}
