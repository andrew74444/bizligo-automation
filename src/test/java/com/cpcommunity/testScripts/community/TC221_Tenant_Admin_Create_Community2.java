package com.cpcommunity.testScripts.community;



import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;

public class TC221_Tenant_Admin_Create_Community2 extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC221(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC221", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		PlansPage plansPage = Dashboard_Page.NavigateManagePricingPlans();
//		plansPage.CreatePlan(data.get("PlanName"), data.get("PlanPrice"), data.get("PlanDuration"), data.get("NumberOfAdmins"), data.get("NumberOfGroups"), data.get("NumberOfMembers"));  
//		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
//		tACommunitiesPage.AddNewCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"),data.get("PlanName"));
		HashMap<String, String> Ftr_list = plansPage.getPricingPlanFeatures(data.get("PlanName"));
		home = Dashboard_Page.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage ecoSystemPage = login.loginToApplication(data.get("communityAdminEmail")+" "+runTime, data.get("password"));
		GlobalCommunitesPage globalCommunitesPage = ecoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage communityDetailsPage = globalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		EditCommunityPage editCommunityPage = communityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage =editCommunityPage.saveCommunity();
		PricingPlanDetailsPage pricingPlanDetailsPage = communityDashboardPage.navigateToPricingPlansDetailsPage();
		pricingPlanDetailsPage.checkPlanDetails(Ftr_list);
		
		
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC221 Test Completed");
		
		quit();
		
	}

}
