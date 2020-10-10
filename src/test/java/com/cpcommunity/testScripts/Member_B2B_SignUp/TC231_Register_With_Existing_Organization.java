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

public class TC231_Register_With_Existing_Organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC231(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC231", data.get("Runmode"), excel);
		log.info("Inside TC231 Test");
		log.info(data);
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		SignupPage signupPage = loginPage.clickonSignup();
		signupPage.checkUserAbleToSignUpWithExsitingOrganizationName(data.get("orgName"));
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}