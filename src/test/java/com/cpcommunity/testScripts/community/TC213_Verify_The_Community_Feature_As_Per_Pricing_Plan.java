package com.cpcommunity.testScripts.community;



import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EditCommunityPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.PlansPage;
import com.cpcommunity.PageObjects.PricingPlanDetailsPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.TACommunitiesPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC213_Verify_The_Community_Feature_As_Per_Pricing_Plan extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC213(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC213", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		PlansPage plansPage = Dashboard_Page.NavigateManagePricingPlans();
//		plansPage.CreatePlan(data.get("PlanName"), data.get("PlanPrice"), data.get("PlanDuration"), data.get("NumberOfAdmins"), data.get("NumberOfGroups"), data.get("NumberOfMembers"));  
//		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
//		tACommunitiesPage.AddNewCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"), data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"), data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"), data.get("type"),data.get("PlanName"));
		HashMap<String, String> Ftr_list = plansPage.getPricingPlanFeatures(data.get("PlanName"));
		home = Dashboard_Page.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage ecoSystemPage = login.loginToApplication(data.get("communityAdminEmail"), data.get("password"));
		GlobalCommunitesPage globalCommunitesPage = ecoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage communityDetailsPage = globalCommunitesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		EditCommunityPage editCommunityPage = communityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage =editCommunityPage.saveCommunity();
		PricingPlanDetailsPage pricingPlanDetailsPage = communityDashboardPage.navigateToPricingPlansDetailsPage();
		pricingPlanDetailsPage.checkPlanDetails(Ftr_list);
		
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC213 Test Completed");
		
		quit();
		
	}

}
