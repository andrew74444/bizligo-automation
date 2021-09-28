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

public class TC659_Verify_User_Canbe_Able_To_Registered_with_Existing_Organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC659(Hashtable<String, String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC659", data.get("Runmode"), excel);
		log.info("Inside TC659 Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
		SignupPage signup = loginPage.clickonSignup();
		AccountVerificationCodePage verification = signup.signupExistingORG(data.get("firstName"),data.get("lastName"),data.get("emailAddress"), data.get("password"), data.get("confirmPassword"), data.get("organizationName"), data.get("phNo"));
		SelectnewMembershipPlan membership = verification.clickOnSend(data.get("email"));
		AuthorizeGateway authorize = membership.MembershipPlansPage();
		authorize.makePayment();
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC222 Test Completed");

		quit();

	}

}
