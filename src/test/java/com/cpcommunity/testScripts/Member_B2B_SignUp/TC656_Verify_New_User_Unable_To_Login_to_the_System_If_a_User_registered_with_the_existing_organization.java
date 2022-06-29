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

public class TC656_Verify_New_User_Unable_To_Login_to_the_System_If_a_User_registered_with_the_existing_organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC656(Hashtable<String, String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC656", data.get("Runmode"), excel);
		log.info("Inside TC656 Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
//		SignupPage signup = loginPage.clickonSignup();
//		AccountVerificationCodePage verification = signup.signupExistingORG(data.get("firstName"),data.get("lastName"),data.get("emailAddress"), data.get("password"), data.get("confirmPassword"), data.get("phNo"),data.get("organizationName"));
//		LoginPage loginPage1 = verification.clickOnSendToNavigateHomepage(data.get("email"));
		loginPage.waitingForTAApproval(data.get("emailAddress1"), data.get("password1"));
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC656 Test Completed");

		quit();

	}

}
