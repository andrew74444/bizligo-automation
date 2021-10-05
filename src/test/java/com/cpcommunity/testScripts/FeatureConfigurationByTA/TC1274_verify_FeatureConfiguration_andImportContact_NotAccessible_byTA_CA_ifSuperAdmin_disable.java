package com.cpcommunity.testScripts.FeatureConfigurationByTA;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.FeaturesConfigurations;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.SuperAdminFeatureConfigurationPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.PageObjects.superAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1274_verify_FeatureConfiguration_andImportContact_NotAccessible_byTA_CA_ifSuperAdmin_disable extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1274(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1274", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	AdminHomePage home= new AdminHomePage().open("https://admin.bizligotest.com");
	AdminLogin login=home.navigateToAdminLogin();
	superAdminDashboardPage SADP=login.superAdminloginToApplication(data.get("email"), data.get("password"));
	SuperAdminFeatureConfigurationPage SAFC=SADP.goToFeatureConfigurationsPage();
	SAFC.disablefeature(data.get("feature1"));
	quit();
	
	openBrowser(data.get("browser1"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home2 = new HomePage().open(data.get("tenantType"));
	LoginPage login2 = home2.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email2"), data.get("password2"));
    tadashoboard2.checkImportContactnotDisplay();
    FeaturesConfigurations FC=tadashoboard2.goToFeaturesConfigurationsPage();
    FC.checkFeatureConfigution();
    quit();
    
    openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyCommunitiesPage myCommunity = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
	CommunityDashboardPage communityDashboard = myCommunity.gotoManageCommunity(data.get("communityName"));
    communityDashboard.checkImportContactnotDisplay();
    quit();
    
    openBrowser(data.get("browser1"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	AdminHomePage home3= new AdminHomePage().open("https://admin.bizligotest.com");
	AdminLogin login3=home3.navigateToAdminLogin();
	superAdminDashboardPage SADP3=login3.superAdminloginToApplication(data.get("email"), data.get("password"));
	SuperAdminFeatureConfigurationPage SAFC3=SADP3.goToFeatureConfigurationsPage();
	SAFC3.enableFeature(data.get("feature1"));
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1274 Test Completed");
		
		quit();
		
	}
}
