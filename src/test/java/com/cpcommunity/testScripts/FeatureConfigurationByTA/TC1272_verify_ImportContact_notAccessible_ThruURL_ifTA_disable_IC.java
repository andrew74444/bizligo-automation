package com.cpcommunity.testScripts.FeatureConfigurationByTA;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.FeaturesConfigurations;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1272_verify_ImportContact_notAccessible_ThruURL_ifTA_disable_IC  extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1272(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1272", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
    FeaturesConfigurations FC= tadashoboard.goToFeaturesConfigurationsPage();
    FC.disablefeature(data.get("feature"));
    quit();
   
    openBrowser(data.get("browser1"));
	logInfo("Launched Browser : "+ data.get("browser1"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
    communityDashboard.checkImportContactnotDisplay();
    HomePage HP1=communityDashboard.logout();
    quit();
   
    openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home2 = new HomePage().open(data.get("tenantType"));
	LoginPage login2 = home2.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email"), data.get("password"));
    FeaturesConfigurations FC2= tadashoboard2.goToFeaturesConfigurationsPage();
    FC2.enableFeature(data.get("feature"));
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1272 Test Completed");
		
		quit();
		
	}
}
