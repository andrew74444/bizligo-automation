package com.cpcommunity.testScripts.Resources;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageResourcesPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1076_Verify_TA_ablTo_Update_Resources extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1076(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1076", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
		ManageResourcesPage manageres=tadashoboard.navigateToManageResourcesPage();
	//	manageres.AddFieldswithCommunity(data.get("Title1"),data.get("community"), data.get("Description"),data.get("url"));
		manageres.updateResource(data.get("Title"),data.get("Title1"),data.get("community"), data.get("Description"),data.get("url"));
		HomePage home1= manageres.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();
//		MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email11"), data.get("password11"));
//		CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
//		ManageResourcesPage manageres1=communityDashboard.navigateToManageResourcesPage();
//		manageres1.checkResources();
		
		EcoSystemPage EcoSystemPage = login1.loginToApplication(data.get("email1"),data.get("password1"));
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		CommunityDetailsPage.checkResource(data.get("Title1"));
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1076 Test Completed");
		
		quit();
		
	}
}
