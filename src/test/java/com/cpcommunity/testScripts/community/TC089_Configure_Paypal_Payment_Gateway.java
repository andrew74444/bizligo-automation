package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DriverManager;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC089_Configure_Paypal_Payment_Gateway extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC089(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC089", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		PaymentGatewaysPage PaymentGatewaysPage  = CommunityDashboardPage.navigateToPaymentGateways();
		SetupPayPalPage SetupPayPalPage = PaymentGatewaysPage.SetPayPal();
		PayPalPayment PayPalPayment = SetupPayPalPage.SetUpPayPalPaymentGateway(data.get("payPalAPIUsername"), data.get("payPalAPIPassword"), data.get("payPalAPISignature"));
		String PaidAmount = PayPalPayment.PayPalpayment(data.get("email"),data.get("password"));
		PaymentConfirmation PaymentConfirmation = PayPalPayment.payPalconfirmation();
		String Url = DriverManager.getDriver().getCurrentUrl();		
		PayPalMerchant PayPalMerchant = PaymentConfirmation.payPallogin();
		
		String TransactionID = PayPalMerchant.merchantLogin(data.get("payPalMerchantEmailID"), data.get("PayPalMerchantPassword"), PaidAmount);		
//		PaymentConfirmation = PayPalMerchant.confirmation();
		DriverManager.getDriver().get(Url);			 
		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(PaidAmount.trim(),TransactionID);
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC089 Test Completed");
		
		quit();
		
	}

}



//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC089", data.get("Runmode"), excel);
//		log.info("Inside Login Test");
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));
//		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
//		LoginPage login = home.clickOnLOGINBtn();
////		login.login(data.get("username"), data.get("password"));
////		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
//		MyDashboardPage Dashboard_Page = login.loginToApplication(data.get("email"),data.get("password"));
//		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
//		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
//		PaymentGatewaysPage PaymentGatewaysPage  = CommunityDashboardPage.navigateToPaymentGateways();
//		SetupPayPalPage SetupPayPalPage = PaymentGatewaysPage.SetPayPal();
//		PayPalPayment PayPalPayment = SetupPayPalPage.SetUpPayPalPaymentGateway(data.get("payPalAPIUsername"), data.get("payPalAPIPassword"), data.get("payPalAPISignature"));
//		String PaidAmount = PayPalPayment.PayPalpayment(data.get("email"),data.get("password"));
//		PaymentConfirmation PaymentConfirmation = PayPalPayment.payPalconfirmation();
//		String Url = DriverManager.getDriver().getCurrentUrl();
//		PayPalMerchant PayPalMerchant= PaymentConfirmation.payPallogin();
//		PayPalMerchant.merchantLogin(data.get("payPalMerchantEmailID"), data.get("PayPalMerchantPassword"), PaidAmount);
//		
//		String TransactionID = PayPalMerchant.merchantLogin();		
//		DriverManager.getDriver().get(Url);
//		PaymentConfirmation PaymentConfirmation = PayPalGateway.confirmation();		 
//		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(PaidAmount,TransactionID);
		


