package com.cpcommunity.testScripts.JobPost;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageCommunitiesPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1083_Verify_TA_created_JobPost_Not_Displaying_If_Community_IsInactivated_For_Only_Community extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1083(Hashtable<String,String> data) throws Exception {
			
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1083", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
	ManageJobsPage manageJob=TDP.navigateToManageJobsPage();
	manageJob.postTAJob(data.get("community"),data.get("JobTitle"),data.get("billingRate"),data.get("jobTypeID"),data.get("location"),data.get("description"),data.get("additionalDetails"),data.get("remarks"),data.get("makeGlobal"));
	ManageCommunitiesPage MCP=manageJob.navigateToManageCommunitiesPage();
	MCP.searchCommunity(data.get("Community2"));
	MCP.EditCommunities(data.get("Name"),data.get("About"), data.get("Category"), data.get("type"));
	GlobalCommunitesPage GCP=MCP.navigateToglobalcommunities();
	GCP.checkInActivatedCommunityIsNotDisplayed(data.get("Community1"));
	TenantAdminDashboardPage TAdash=GCP.navigateToTenantAdminDashboardPage();
	ManageCommunitiesPage managecomm=TAdash.navigatetomanageCommunities();
	managecomm.ActivateCommunities(data.get("community3"),data.get("About3"),data.get("Category3"),data.get("type3"));
	
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1183 Test Completed");
		
		quit();
		
	}
	
}
