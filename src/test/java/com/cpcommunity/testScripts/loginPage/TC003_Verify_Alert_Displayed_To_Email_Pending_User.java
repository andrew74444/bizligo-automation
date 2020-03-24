//package com.cpcommunity.testScripts.loginPage;
//
//import java.util.Hashtable;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.cpcommunity.testcases.BaseTest;
//import com.w2a.zoho.PageObjects.HomePage;
//import com.w2a.zoho.PageObjects.LoginPage;
//import com.w2a.zoho.utilities.Constants;
//import com.w2a.zoho.utilities.DataProviders;
//import com.w2a.zoho.utilities.DataUtil;
//import com.w2a.zoho.utilities.ExcelReader;
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC003_Verify_Alert_Displayed_To_Email_Pending_User extends BaseTest {
//	
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void TC001(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC001", data.get("Runmode"), excel);
//		log.info("Inside Login Test");			
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));		
//		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
//		LoginPage login = home.clickOnLOGINBtn();
//		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
//		login.ReSend_Email_Verification_Confirmation(data.get("email"), data.get("password"));
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
//}
