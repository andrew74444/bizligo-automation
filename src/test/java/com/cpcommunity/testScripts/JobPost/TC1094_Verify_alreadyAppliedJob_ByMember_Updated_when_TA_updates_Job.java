package com.cpcommunity.testScripts.JobPost;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.BasePage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.MyJobsPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1094_Verify_alreadyAppliedJob_ByMember_Updated_when_TA_updates_Job extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1094(Hashtable<String,String> data) throws Exception {
			
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1094", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageJobsPage manageJob=TDP.navigateToManageJobsPage();
	manageJob.UpdateJob(data.get("JobTitle"),data.get("BillingRate"),data.get("JobTypeID"),data.get("Location"),data.get("Description"),data.get("AdditionalDetails"),data.get("reMarks"),data.get("makeGlobal"));
	manageJob.logout();
	LoginPage login2 = home.clickOnLOGINBtn();
	MyDashboardPage dashpage1 = login2.loginToDashboard(data.get("email1"), data.get("password1"));
	MyJobsPage MJP1=dashpage1.NavigatingToMyJobs();
	MJP1.FindappliedJobs(data.get("Jobtitle1"));
	MJP1.getSystemCurrentDate();

	
	}@AfterMethod
	public void tearDown() {
		
		logInfo("TC1094 Test Completed");
		
		quit();
		
	}
}
