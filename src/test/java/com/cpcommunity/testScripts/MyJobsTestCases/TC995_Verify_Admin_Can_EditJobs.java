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

public class TC995_Verify_Admin_Can_EditJobs extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC995(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC995", data.get("Runmode"), excel);
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
		 MJP.UpdateJob(data.get("JobTitle"), data.get("UpdateTitle"), data.get("BillingRate"), data.get("JobTypeID"), data.get("Location"),data.get("Description"),data.get("AdditionalDetails"),data.get("reMarks"),data.get("makeGlobal"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC995 Test Completed");
		
		quit();
		
	}
}
