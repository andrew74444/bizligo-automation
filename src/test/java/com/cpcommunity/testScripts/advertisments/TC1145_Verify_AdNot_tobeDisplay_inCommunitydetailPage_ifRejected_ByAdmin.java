package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.ManageMemberAdvertisementsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1145_Verify_AdNot_tobeDisplay_inCommunitydetailPage_ifRejected_ByAdmin extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1145(Hashtable<String,String> data) throws Exception {
		//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1145", data.get("Runmode"), excel);
	log.info("Inside Login Test");	
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+data.get("browser"));
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	 MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
	 GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
	 GCP.searchCommunity(data.get("community"));
	 SelectPlanPage SPP= GCP.navigatetoselectPlanPage();
	 AuthorizeGateway AG=SPP.selectPlan1(data.get("planName"),data.get("AdName"),data.get("path"));
	 AG.makePayment();
	 quit();
	 
	 openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));				
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
	 ManageMemberAdvertisementsPage MMA=communityDashboard.navigateToMemberAdvertisements();
	 MMA.rejectAd(data.get("status"));
	// MMA.approveRejectedAd(data.get("plan1"), data.get("adImage"),data.get("linkUrl"));
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1145 Test Completed");
		
		quit();
}
}
