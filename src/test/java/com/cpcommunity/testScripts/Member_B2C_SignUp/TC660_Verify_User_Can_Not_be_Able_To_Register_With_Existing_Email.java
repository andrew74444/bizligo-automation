package com.cpcommunity.testScripts.Member_B2C_SignUp;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC660_Verify_User_Can_Not_be_Able_To_Register_With_Existing_Email extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC660(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC660", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		SignupPage signup = loginPage.clickonSignup();
		signup.checkUserAbleToSignUpWithExsitingEmail(data.get("emailAddress"));
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC660 Test Completed");

		quit();

	}

}
