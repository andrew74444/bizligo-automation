package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC128_Create_Job_Requirement extends BaseTest {

	String TCID = "TC128";	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",enabled=true)
	public void TC128(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC128", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();		
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage =MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		ManageJobsPage manageJobsPage =CommunityDashboardPage.navigateToManageJobsPage();
		manageJobsPage.postJob(data.get("JobTitle"), data.get("BillingRate"), data.get("JobTypeID"), data.get("Location"), data.get("Description"), data.get("AdditionalDetails"), data.get("remarks"), data.get("makeGlobal"));
		CommunityDetailsPage cdp = manageJobsPage.navigateToCommunityDetailsPage(data.get("communityName"));
		cdp.searchJob(data.get("JobTitle"));
		EcoSystemPage.goToGlobalCommunities();
		GlobalCareers GC = EcoSystemPage.goToGlobalCareers();
		GC.searchJob(data.get("JobTitle"));
		GC.verifyTheDetails(data.get("JobTitle"), data.get("AdditionalDetails"), data.get("remarks"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
