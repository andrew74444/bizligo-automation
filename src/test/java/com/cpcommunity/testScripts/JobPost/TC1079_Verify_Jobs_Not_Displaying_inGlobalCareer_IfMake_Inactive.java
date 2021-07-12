package com.cpcommunity.testScripts.JobPost;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.GlobalCareers;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1079_Verify_Jobs_Not_Displaying_inGlobalCareer_IfMake_Inactive extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1079(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1079", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	ManageJobsPage manageJob=communityDashboard.navigateToManageJobsPage();
	manageJob.inActivateJob(data.get("Title"));
	GlobalCareers Cp=manageJob.navigateToCareerPage();
	Cp.JobNotDisplayed(data.get("Title1"));
	
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1079 Test Completed");
		
		quit();
		
	}
	
}
