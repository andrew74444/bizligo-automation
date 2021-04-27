/*package com.cpcommunity.testScripts.Password;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.testcases.BaseTest;
import com.w2a.zoho.PageObjects.ChangePasswordPage;
import com.w2a.zoho.PageObjects.HomePage;
import com.w2a.zoho.PageObjects.LoginPage;
import com.w2a.zoho.PageObjects.MyDashboardPage;
import com.w2a.zoho.utilities.Constants;
import com.w2a.zoho.utilities.DataProviders;
import com.w2a.zoho.utilities.DataUtil;
import com.w2a.zoho.utilities.ExcelReader;

*//**
 * 
 * @author Sasi Vinod Akula
 *//*
public class TC008_Verify_User_Able_to_Change_password extends BaseTest{
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC029(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC029", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		HomePage home = new HomePage().open("https://cpcommunityqa.azurewebsites.net/");
		LoginPage login = home.clickOnLOGINBtn();
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		MyDashboardPage DashboardPage = login.loginToApplication(data.get("email"), data.get("password"));
		ChangePasswordPage ChangePassword = DashboardPage.NaviagtingToManagePassword();
		ChangePassword.Changepassword(data.get("password"), data.get("NewPassword"), data.get("ConfirmPassword"));
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}
}*/