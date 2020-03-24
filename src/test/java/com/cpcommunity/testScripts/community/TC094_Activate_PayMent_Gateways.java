package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PaymentGatewaysPage;
import com.cpcommunity.PageObjects.SetupAuthorizePage;
import com.cpcommunity.PageObjects.SetupPayPalPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC094_Activate_PayMent_Gateways extends BaseTest {

     String TCID= "TC094";	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC094(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC094", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.goToManageCommunity(data.get("communityName"));
		PaymentGatewaysPage PaymentGatewaysPage = CommunityDashboardPage.navigateToPaymentGateways();
		PaymentGatewaysPage.activateCheque();
		PaymentGatewaysPage.activateCash();
		SetupPayPalPage SetupPayPalPage = PaymentGatewaysPage.navigateToActivatePayPal();
		SetupPayPalPage.ActiavtePayPalPaymentGateway();
		SetupAuthorizePage SetupAuthorizePage =PaymentGatewaysPage.navigateActivateAuthorize();
		SetupAuthorizePage.ActiveAuthorizeGateway();
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
