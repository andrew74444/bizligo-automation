package com.cpcommunity.testScripts.JobPost;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1082_Verify_TA_ableTo_create_JOB extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1082(Hashtable<String,String> data) throws Exception {
			
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1082", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageJobsPage manageJob=TDP.navigateToManageJobsPage();
	manageJob.postTAJob(data.get("community"),data.get("JobTitle"),data.get("billingRate"),data.get("jobTypeID"),data.get("location"),data.get("description"),data.get("additionalDetails"),data.get("remarks"),data.get("makeGlobal"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1082 Test Completed");
		
		quit();
		
	}
}
