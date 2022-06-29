package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC090_Configure_AuthorizeNet_Payment_Gateway_____ extends BaseTest {

	

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC090(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC090", data.get("Runmode"), excel);
		log.info("TC090 Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));

		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		PaymentGatewaysPage PaymentGatewaysPage = CommunityDashboardPage.navigateToPaymentGateways();
		SetupAuthorizePage SetupAuthorizePage = null;
		
		try {
			 SetupAuthorizePage = PaymentGatewaysPage.setUpAuthorize();

		} catch (Exception e) {
			
		}

		AuthorizeGateway AuthorizeGateway = null;
		try {
			AuthorizeGateway = SetupAuthorizePage.SetUpAuthorizeGateway();

		} catch (Exception e) {
			// TODO: handle exception		
			}
			
		String amount;
		PaymentConfirmation PaymentConfirmation = null;
		try {
			amount = AuthorizeGateway.makePayment("TC090");
			PaymentConfirmation = AuthorizeGateway.paymentConfirmation();
		} catch (Exception e) {
			PaymentConfirmation = PaymentGatewaysPage.gotoConfirmPaymentPage();
			amount = PaymentConfirmation.getAmountPaid("TC090");
			
		}	
	
		AuthorizeMerchanLogin AuthorizeMerchanLogin = PaymentConfirmation.gotoMerchanLoginPage();
		String TransactionID = AuthorizeMerchanLogin.getTransactionID();
		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(amount, TransactionID);

		// Assert.fail("Failing the login test");
		Yahoo yahoo= new Yahoo().open();
		yahoo.Login(data.get("email"), data.get("password"));
		yahoo.paymentGateway();
	}

	@AfterMethod
	public void tearDown() {

		logInfo("TC090 Test Completed");

		quit();

	}

}
