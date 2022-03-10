//package com.cpcommunity.testScripts.community;
//
//
//
//import java.util.Hashtable;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.w2a.zoho.utilities.Constants;
//import com.w2a.zoho.utilities.DataUtil;
//import com.w2a.zoho.utilities.DriverManager;
//import com.w2a.zoho.PageObjects.AuthorizeGateway;
//import com.w2a.zoho.PageObjects.CommunityDashboardPage;
//import com.w2a.zoho.PageObjects.HomePage;
//import com.w2a.zoho.PageObjects.Invalidaccountdetailspage;
//import com.w2a.zoho.PageObjects.LoginPage;
//import com.w2a.zoho.PageObjects.MyCommunitiesPage;
//import com.w2a.zoho.PageObjects.MyDashboardPage;
//import com.w2a.zoho.PageObjects.PayPalMerchant;
//import com.w2a.zoho.PageObjects.PayPalPayment;
//import com.w2a.zoho.PageObjects.PaymentConfirmation;
//import com.w2a.zoho.PageObjects.PaymentGatewaysPage;
//import com.w2a.zoho.PageObjects.SetupAuthorizePage;
//import com.w2a.zoho.PageObjects.SetupPayPalPage;
//import com.w2a.zoho.PageObjects.TransactionPage;
//import com.w2a.zoho.utilities.DataProviders;
//import com.w2a.zoho.utilities.ExcelReader;
//
//public class TC186_Verify_User_Prompted_With_Attempts_Left_If_Invalid_Entries_Made_By_The_user extends BaseTest {
//
//	
//	
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void TC186(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC186", data.get("Runmode"), excel);
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
//		SetupAuthorizePage SetupAuthorizePage = PaymentGatewaysPage.setUpAuthorize();
//		AuthorizeGateway Authorize = SetupAuthorizePage.AuthorizeGatewayPage(data.get("authorizeAPIUsername"), data.get("authorizeAPIPassword"), data.get("authorizeAPISignature"));
//		Authorize.makePayment();
//		PaymentConfirmation paymentconfirmation = Authorize.paymentConfirmation();
//	    paymentconfirmation.invalidTransactionDetails(data.get("amountPaid"), data.get("transactionID"));
//	    
//		
//	}
//
//	@AfterMethod
//	public void tearDown() {
//		
//		logInfo("Login Test Completed");
//		
//		quit();
//		
//	}
//
//}
//
//
//
////		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
////		DataUtil.checkExecution("master", "TC089", data.get("Runmode"), excel);
////		log.info("Inside Login Test");
////		openBrowser(data.get("browser"));
////		logInfo("Launched Browser : "+data.get("browser"));
////		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
////		LoginPage login = home.clickOnLOGINBtn();
//////		login.login(data.get("username"), data.get("password"));
//////		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
////		MyDashboardPage Dashboard_Page = login.loginToApplication(data.get("email"),data.get("password"));
////		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
////		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
////		PaymentGatewaysPage PaymentGatewaysPage  = CommunityDashboardPage.navigateToPaymentGateways();
////		SetupPayPalPage SetupPayPalPage = PaymentGatewaysPage.SetPayPal();
////		PayPalPayment PayPalPayment = SetupPayPalPage.SetUpPayPalPaymentGateway(data.get("payPalAPIUsername"), data.get("payPalAPIPassword"), data.get("payPalAPISignature"));
////		String PaidAmount = PayPalPayment.PayPalpayment(data.get("email"),data.get("password"));
////		PaymentConfirmation PaymentConfirmation = PayPalPayment.payPalconfirmation();
////		String Url = DriverManager.getDriver().getCurrentUrl();
////		PayPalMerchant PayPalMerchant= PaymentConfirmation.payPallogin();
////		PayPalMerchant.merchantLogin(data.get("payPalMerchantEmailID"), data.get("PayPalMerchantPassword"), PaidAmount);
////		
////		String TransactionID = PayPalMerchant.merchantLogin();		
////		DriverManager.getDriver().get(Url);
////		PaymentConfirmation PaymentConfirmation = PayPalGateway.confirmation();		 
////		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(PaidAmount,TransactionID);
//		
//
//
