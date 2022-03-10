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
//import com.w2a.zoho.PageObjects.CommunityDashboardPage;
//import com.w2a.zoho.PageObjects.HomePage;
//import com.w2a.zoho.PageObjects.LoginPage;
//import com.w2a.zoho.PageObjects.MyCommunitiesPage;
//import com.w2a.zoho.PageObjects.MyDashboardPage;
//import com.w2a.zoho.PageObjects.PaymentGatewaysPage;
//import com.w2a.zoho.PageObjects.SetupAuthorizePage;
//import com.w2a.zoho.PageObjects.SetupPayPalPage;
//import com.w2a.zoho.utilities.DataProviders;
//import com.w2a.zoho.utilities.ExcelReader;
//
//public class TC189_InActivate_PayMent_Gateways3 extends BaseTest {
//
//	String TCID= "TC189";
//	 
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void TC189(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC189", data.get("Runmode"), excel);
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
//		PaymentGatewaysPage PaymentGatewaysPage = CommunityDashboardPage.navigateToPaymentGateways();
//		PaymentGatewaysPage.InactiveAuthorize();
//		
//		
//		//Assert.fail("Failing the login test");
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
