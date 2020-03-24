//
//package com.w2a.zoho.testcases;
//
//import java.util.Hashtable;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.w2a.zoho.utilities.Constants;
//import com.w2a.zoho.utilities.DataUtil;
//import com.w2a.zoho.utilities.DriverManager;
//import com.w2a.zoho.PageObjects.HomePage;
//import com.w2a.zoho.PageObjects.LoginPage;
//import com.w2a.zoho.PageObjects.MyDashboardPage;
//import com.w2a.zoho.PageObjects.MyProfilePage;
//import com.w2a.zoho.PageObjects.ZohoLoginPage;
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
//		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
//		LoginPage login = home.clickOnLOGINBtn();
////		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
//		MyDashboardPage Dashboard_Page = login.loginToApplication(data.get("username"), data.get("password"));
//		MyProfilePage MyProfile_Page = Dashboard_Page.NaviagtingToMyProfilePage();
//		MyProfile_Page.UpdateProfileDetails(data.get("FName"), data.get("LName"), data.get("jtitle"), data.get("PPhone"), data.get("PExt"), data.get("PSummary"), data.get("Ytube"), data.get("LUrl"), data.get("FUrl"), data.get("TUrl"), data.get("GUrl"));
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
