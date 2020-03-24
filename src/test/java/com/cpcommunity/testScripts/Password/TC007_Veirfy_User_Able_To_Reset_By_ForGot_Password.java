//package com.cpcommunity.testScripts.Password;
//
//import java.util.Hashtable;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.cpcommunity.testcases.BaseTest;
//import com.w2a.zoho.PageObjects.ForgotPasswordPage;
//import com.w2a.zoho.PageObjects.HomePage;
//import com.w2a.zoho.PageObjects.LoginPage;
//import com.w2a.zoho.utilities.Constants;
//import com.w2a.zoho.utilities.DataProviders;
//import com.w2a.zoho.utilities.DataUtil;
//import com.w2a.zoho.utilities.ExcelReader;
//
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC007_Veirfy_User_Able_To_Reset_By_ForGot_Password extends BaseTest{
//	
//	
//	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
//	public void TC029(Hashtable<String,String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC029", data.get("Runmode"), excel);
//		log.info("Inside Login Test");			
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));		
//		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
//		LoginPage login = home.clickOnLOGINBtn();
//		ForgotPasswordPage ForgotPasswordPage= login.clickOnForgotpassword();
//		ForgotPasswordPage.SendForgotPasswordEmail(data.get("emailAddress"));
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