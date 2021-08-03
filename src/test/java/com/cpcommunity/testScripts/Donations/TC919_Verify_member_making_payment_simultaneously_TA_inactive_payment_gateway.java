package com.cpcommunity.testScripts.Donations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Bizligo1CommunityPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageDonationsPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.PaymentGatewaysPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC919_Verify_member_making_payment_simultaneously_TA_inactive_payment_gateway extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC919(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC919", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		MyCommunitiesPage MyCP = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
        Bizligo1CommunityPage BCP=MyCP.goToMyCommunity(data.get("Community"));
        BCP.makeDonationWhenTAdisablePayment();
        HomePage home1 = new HomePage().open(data.get("tenantType"));
        home1.logout();
		LoginPage login1 = home1.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login1.loginToTADashboard(data.get("email1"), data.get("password1"));
		PaymentGatewaysPage PGP=TDP.NavigatetoPaymentGatewayPage();
		PGP.inactiveAuthorizeGateway();
	    HomePage home3 = new HomePage().open(data.get("tenantType"));
	    home3.logout();
		LoginPage login3 = home3.clickOnLOGINBtn();
		MyCommunitiesPage MyCP1 = login3.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
        Bizligo1CommunityPage BCP1=MyCP1.goToMyCommunity(data.get("Community"));
        BCP1.checkAuthorizeGatewayWhenInactivate();
        HomePage home4 = new HomePage().open(data.get("tenantType"));
        home4.logout();
		LoginPage login4 = home4.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP1 = login4.loginToTADashboard(data.get("email1"), data.get("password1"));
		PaymentGatewaysPage PGP1=TDP1.NavigatetoPaymentGatewayPage();
	    PGP1.activeAuthorizeGateway();

}
	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}
}
