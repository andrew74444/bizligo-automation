package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.AuthorizeMerchanLogin;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PaymentConfirmation;
import com.cpcommunity.PageObjects.PaymentGatewaysPage;
import com.cpcommunity.PageObjects.SetupAuthorizePage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC090_Configure_AuthorizeNet_Payment_Gateway_____ extends BaseTest {

	
	String TCID= "TC090";
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC090(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC090", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		PaymentGatewaysPage PaymentGatewaysPage  = CommunityDashboardPage.navigateToPaymentGateways();
		SetupAuthorizePage SetupAuthorizePage = PaymentGatewaysPage.setUpAuthorize();
		AuthorizeGateway AuthorizeGateway =SetupAuthorizePage.SetUpAuthorizeGateway();
		String amount = AuthorizeGateway.makePayment();
		PaymentConfirmation PaymentConfirmation = AuthorizeGateway.paymentConfirmation();
		AuthorizeMerchanLogin AuthorizeMerchanLogin = PaymentConfirmation.login(); 
		String TransactionID =AuthorizeMerchanLogin.MerchantLogin();
		PaymentConfirmation = AuthorizeMerchanLogin.confirmation();		
		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(amount, TransactionID);
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
