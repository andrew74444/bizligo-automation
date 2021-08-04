package com.cpcommunity.testScripts.Donations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.SuperAdminFeatureConfigurationPage;
import com.cpcommunity.PageObjects.superAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC921_Verify_member_making_payment_simultaneously_SuperAdmin_disabled_donation extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC921(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC921", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyCommunitiesPage MyCP = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
        Bizligo1CommunityPage BCP=MyCP.goToMyCommunity(data.get("Community"));
        BCP.makeDonationWhenTAdisablePayment();
        AdminHomePage home1 = new AdminHomePage().open("https://admin.bizligotest.com");
		AdminLogin login1 =home1.navigateToAdminLogin();
		superAdminDashboardPage SADP=login1.superAdminloginToApplication(data.get("email1"), data.get("password1"));
		SuperAdminFeatureConfigurationPage SFCP = SADP.goToFeatureConfigurationsPage();
		SFCP.disablefeature(data.get("Feature"));
		HomePage home3 = new HomePage().open(data.get("tenantType"));
	    home3.logout();
		LoginPage login3 = home3.clickOnLOGINBtn();
		MyCommunitiesPage MyCP1 = login3.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
        Bizligo1CommunityPage BCP1=MyCP1.goToMyCommunity(data.get("Community"));
        BCP1.checkDonationWhenInactivated();
        quit();
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		AdminHomePage home2 = new AdminHomePage().open("https://admin.bizligotest.com");
		AdminLogin login2=home2.navigateToAdminLogin();
		superAdminDashboardPage SADP1=login2.superAdminloginToApplication(data.get("email1"), data.get("password1"));
		SuperAdminFeatureConfigurationPage SFCP2=SADP1.goToFeatureConfigurationsPage();
		SFCP2.enableFeature(data.get("Feature"));

}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}
	
}
