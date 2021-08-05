package com.cpcommunity.testScripts.Donations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageDonationsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC926_Verify_donate_menu_link_opening_new_tab_if_donation_external extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC926(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC926", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
	    ManageDonationsPage MDP=TDP.NavigatetoManageDonationsPage();
	    MDP.makeDonationExternal(data.get("Community"),data.get("AddURL"));
	    HomePage home1 = new HomePage().open(data.get("tenantType"));
        home1.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();	
		MyCommunitiesPage MyCP = login1.loginToMyCommunitiesPage(data.get("email1"), data.get("password1"));
        Bizligo1CommunityPage BCP=MyCP.goToMyCommunity(data.get("Community"));
        BCP.checkNewTabForExternalDonation();
        HomePage home3 = new HomePage().open(data.get("tenantType"));
	    home3.logout();
		LoginPage login3 = home3.clickOnLOGINBtn();
		TenantAdminDashboardPage TDP1 = login3.loginToTADashboard(data.get("email"), data.get("password"));
	    ManageDonationsPage MDP1=TDP1.NavigatetoManageDonationsPage();
	    MDP1.makeDonationInternal(data.get("Community")); //   
	    }
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
