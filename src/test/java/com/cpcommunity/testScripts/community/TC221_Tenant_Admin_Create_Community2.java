package com.cpcommunity.testScripts.community;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC221_Tenant_Admin_Create_Community2 extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC221(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC221", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		PlansPage plansPage = Dashboard_Page.NavigateManagePricingPlans();
//		plansPage.CreatePlan(data.get("PlanName"), data.get("PlanPrice"), data.get("PlanDuration"), data.get("NumberOfAdmins"), data.get("NumberOfGroups"), data.get("NumberOfMembers"));  
//		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
//		tACommunitiesPage.AddNewCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"),data.get("PlanName"));
		HashMap<String, String> Ftr_list = plansPage.getPricingPlanFeatures(data.get("PlanName"));
//		home = Dashboard_Page.logout();
//		login = home.clickOnLOGINBtn();
//		EcoSystemPage ecoSystemPage = login.loginToApplication(data.get("communityAdminEmail"), data.get("password"));
//		GlobalCommunitesPage globalCommunitesPage = ecoSystemPage.naviagtingToGlobalCommunities();
//		CommunityDetailsPage communityDetailsPage = globalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
//		EditCommunityPage editCommunityPage = communityDetailsPage.managecommunity();
//		CommunityDashboardPage communityDashboardPage =editCommunityPage.saveCommunity();
//		communityDashboardPage.navigateToPricingPlansDetailsPage();
		
		
		
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC205 Test Completed");
		
		quit();
		
	}

}
