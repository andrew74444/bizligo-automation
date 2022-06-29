package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.ManageCommunityPage;
import com.cpcommunity.PageObjects.MyAdvertisements;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1131_Verify_otherCA_ofSameCommunity_Can_Edit_AdPlans extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1131(Hashtable<String,String> data) throws Exception {
		
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1131", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
//	 MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password"));
//	 GlobalCommunitesPage GCP=MDP.naviagtingToGlobalCommunities();
//	 GCP.searchCommunity(data.get("community"));
//	 ManageCommunityPage MC=GCP.goToManagecommunity();
//	 ManageAdPlansPage MAP=MC.NavigateTomanageAdpage();
	 EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboard =MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		ManageAdPlansPage MAPP=communityDashboard.goToManageAdPlansPage();
	 MAPP.editPlan(data.get("plan"));
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1131 Test Completed");
		
		quit();
		
	}
}

