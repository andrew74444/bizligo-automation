package com.cpcommunity.testScripts.Member_B2B_SignUp;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC652_Verify_User_Not_Able_To_Register_With_Existing_Organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC652(Hashtable<String, String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC652", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		SystemAdminDashboardPage SA = loginPage.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		HomePage home1 = SA.notAllowExistingOrg();
		LoginPage loginPage1 = home1.clickOnLOGINBtn();
		SignupPage signup = loginPage1.clickonSignup();
		signup.checkUserAbleToSignUpWithExsitingOrganizationName(data.get("orgName"));
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
