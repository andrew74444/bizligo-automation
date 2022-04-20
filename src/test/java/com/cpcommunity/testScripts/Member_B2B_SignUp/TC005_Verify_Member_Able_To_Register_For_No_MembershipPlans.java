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

public class TC005_Verify_Member_Able_To_Register_For_No_MembershipPlans extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC223(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC223", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage loginPage = home.clickOnLOGINBtn();
	//	loginPage.clickonSignup();
		
		SignupPage signupPage = loginPage.clickonSignup();
		signupPage.signup(data.get("firstName"), data.get("lastName"), data.get("emailAddress"), data.get("phNo"), data.get("password"), data.get("isB2B"), data.get("isNewOrg"), data.get("corporateAddress"), data.get("organizationName"), data.get("website"), data.get("businessDescription"), data.get("businessCategories"), data.get("isOrgRequired"));
	
		
		signupPage.send();
		signupPage.newTab();
		
//*************for verification code*******************\\		
		Gmail gmail= new Gmail().open();
		gmail.Login(data.get("email3"), data.get("password3"));
		
		 gmail.registMail();
//********Entering code and selecting membership plan**********\\\\\\\\\\\\\\\\\\\\\\\	 
		 gmail.backToOldTab();
		 gmail.enterCode();
		 gmail.selectPlan();
//*********member checking mail about membership plan**************\\\\\\\\\\\\\\\		 
		 gmail.newTab();
		 
		 gmail.payementMail();
//******tenant admin checking mail about new member registration*************\\\\		 
			Yahoo yahoo= new Yahoo().open();

			yahoo.Login(data.get("email4"), data.get("password4"));
			yahoo.tAdminRegsNotification();
		 
	}

	
	
	
	
	
//	@AfterMethod
//	public void tearDown() {
//
//		logInfo("Login Test Completed");
//
//		quit();
//
//	}

}
