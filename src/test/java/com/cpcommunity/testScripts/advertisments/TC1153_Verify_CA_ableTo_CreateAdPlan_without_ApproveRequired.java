package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1153_Verify_CA_ableTo_CreateAdPlan_without_ApproveRequired extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1153(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1153", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
	EcoSystemPage EcoSystemPage1 = login.loginToApplication(data.get("email"), data.get("password"));
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage1.goToMyCommunities();
	CommunityDashboardPage communityDashboard = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
	ManageAdPlansPage MAPP=communityDashboard.goToManageAdPlansPage();
	MAPP.createAdWithoutApproval(data.get("name"),data.get("price"), data.get("planDetails"),data.get("duration"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
	MAPP.inactivatePlan(data.get("plan"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1153 Test Completed");
		
		quit();
		
	}

}
