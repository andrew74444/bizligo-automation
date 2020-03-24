//package com.cpcommunity.emailtestcases;
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
//import com.w2a.zoho.utilities.DataProviders;
//import com.w2a.zoho.utilities.ExcelReader;
//
//public class LoginTest extends BaseTest {
//
//	
//	
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void loginTest(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
//		log.info("Inside Login Test");
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));
////		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
////		LoginPage login = home.clickOnLOGINBtn();
////		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
////		MyDashboardPage Dashboard_Page = login.loginToApplication(data.get("username"), data.get("password"));
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
