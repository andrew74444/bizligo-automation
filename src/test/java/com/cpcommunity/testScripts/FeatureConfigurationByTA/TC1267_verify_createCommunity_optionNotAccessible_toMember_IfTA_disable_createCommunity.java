package com.cpcommunity.testScripts.FeatureConfigurationByTA;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.FeaturesConfigurations;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1267_verify_createCommunity_optionNotAccessible_toMember_IfTA_disable_createCommunity extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1267(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1267", data.get("Runmode"), excel);
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
    
    openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));
	GlobalCommunitesPage GC=MDP.naviagtingToGlobalCommunities();
	GC.checkCreateCommunitiesNotDisplaying();
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
		
		logInfo("TC1267 Test Completed");
		
		quit();
		
	}
}
