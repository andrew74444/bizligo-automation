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

public class TC655_Verify_new_user_unable_to_login_to_the_system_until_the_organization_is_approved_by_ta extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC655(Hashtable<String, String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC655", data.get("Runmode"), excel);
		log.info("Inside TC650 Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
//		HomePage home = new HomePage().open(data.get("tenantType"));
//		LoginPage loginPage = home.clickOnLOGINBtn();
//		SignupPage signup = loginPage.clickonSignup();
//		AccountVerificationCodePage verification = signup.signupPage(data.get("firstName"),data.get("lastName"),data.get("emailAddress"), data.get("password"), data.get("confirmPassword"), data.get("organizationName"), data.get("website"),data.get("businessDescription"), data.get("phNo"), data.get("corporateAddress"), data.get("businessCategories"));
//		SelectnewMembershipPlan membership = verification.clickOnSend(data.get("email"));
//		AuthorizeGateway authorize = membership.MembershipPlansPage();
//		authorize.makePayment();
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage1 = home1.clickOnLOGINBtn();
		loginPage1.waitingForApproval(data.get("emailAddress1"), data.get("password1"));
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC655 Test Completed");

		quit();

	}

}
