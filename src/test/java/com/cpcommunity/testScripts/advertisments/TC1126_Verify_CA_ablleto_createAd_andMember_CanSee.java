package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.Discussions;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1126_Verify_CA_ablleto_createAd_andMember_CanSee extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1126(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1126", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));

	EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
	MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
	CommunityDashboardPage communityDashboard = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
	ManageAdPlansPage MAPP=communityDashboard.goToManageAdPlansPage();
	MAPP.createAdPlan(data.get("name"),data.get("price"), data.get("planDetails"),data.get("duration"),data.get("durationType"),data.get("adLocation"),data.get("adType"), data.get("approvalType"));
//	quit();
	
//	openBrowser(data.get("browser"));
//	logInfo("Launched Browser : "+data.get("browser"));
//	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	home1.logout();
	LoginPage login1 = home1.clickOnLOGINBtn();
	// MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));
	// GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	EcoSystemPage EcoSystemPage1 = login1.loginToApplication(data.get("email"), data.get("password"));
	GlobalCommunitesPage GCP = EcoSystemPage1.goToGlobalCommunities();
	 GCP.searchCommunity(data.get("community"));
//	 GCP.Gotoresources();
	 GCP.goTocommunityPage(data.get("community"));
	 GCP.checkAdPresent(data.get("name"));
//	 quit();
	 
//	    openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+ data.get("browser"));		
//		logInfo("BizLigo Application Opened");
//		HomePage home2 = new HomePage().open(data.get("tenantType"));
//		LoginPage login2 = home2.clickOnLOGINBtn();
//		//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
//		MyCommunitiesPage myCommunity2 = login2.loginToMyCommunitiesPage(data.get("email2"), data.get("password2"));
//		CommunityDashboardPage communityDashboard2 = myCommunity2.gotoManageCommunity(data.get("communityName"));
//		ManageAdPlansPage MAPP2=communityDashboard2.goToManageAdPlansPage();
//	   MAPP2.inactivatePlan(data.get("plan"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1126 Test Completed");
		
		quit();
		
	}
}