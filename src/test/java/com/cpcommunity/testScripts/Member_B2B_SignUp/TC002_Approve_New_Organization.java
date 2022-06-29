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

public class TC002_Approve_New_Organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC1198(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1198", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
	//	loginPage.clickonSignup();
		
		   TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email1"), data.get("password1"));
		    OrganizationsPage organisation=	tadashoboard.goToOrganizationsPage();
		    organisation.approveOrganization(data.get("orgName"));
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC002 Test Completed");

		quit();

	}

}
