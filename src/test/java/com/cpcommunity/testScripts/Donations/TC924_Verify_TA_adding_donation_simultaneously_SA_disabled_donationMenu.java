package com.cpcommunity.testScripts.Donations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.SuperAdminFeatureConfigurationPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.PageObjects.superAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC924_Verify_TA_adding_donation_simultaneously_SA_disabled_donationMenu extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC924(Hashtable<String,String> data) throws Throwable {


		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC924", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		AdminHomePage home = new AdminHomePage().open("https://admin.bizligotest.com");
		AdminLogin login =home.navigateToAdminLogin();
		superAdminDashboardPage SADP=login.superAdminloginToApplication(data.get("email"), data.get("password"));
		SuperAdminFeatureConfigurationPage SFCP = SADP.goToFeatureConfigurationsPage();
		SFCP.disablefeature(data.get("Feature"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login1.loginToTADashboard(data.get("email1"), data.get("password1"));
		TDP.checkDonationsWhenDisabled();
		quit();
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		AdminHomePage home2 = new AdminHomePage().open("https://admin.bizligotest.com");
		AdminLogin login2=home2.navigateToAdminLogin();
		superAdminDashboardPage SADP1=login2.superAdminloginToApplication(data.get("email"), data.get("password"));
		SuperAdminFeatureConfigurationPage SFCP2=SADP1.goToFeatureConfigurationsPage();
		SFCP2.enableFeature(data.get("Feature"));//
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}


}
