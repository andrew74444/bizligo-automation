package com.cpcommunity.testScripts.TA_Organizations;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AccountVerificationCodePage;
import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.OrganizationsPage;
import com.cpcommunity.PageObjects.SelectnewMembershipPlan;
import com.cpcommunity.PageObjects.SignupPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1198_verify_TA_ableto_Approve_Organisation extends BaseTest{
	    
	    @Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	    public void TC1198(Hashtable<String, String> data) throws Throwable {

	 //
	        ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	        DataUtil.checkExecution("master", "TC1198", data.get("Runmode"), excel);
	        log.info("Inside Login Test");			
			/*
			 * openBrowser(data.get("browser")); logInfo("Launched Browser : "+
			 * data.get("browser")); logInfo("BizLigo Application Opened"); HomePage home =
			 * new HomePage().open(data.get("tenantType")); LoginPage loginPage =
			 * home.clickOnLOGINBtn(); SignupPage signup = loginPage.clickonSignup();
			 * AccountVerificationCodePage verification =
			 * signup.signupPage(data.get("firstName"),data.get("lastName"),data.get(
			 * "emailAddress"), data.get("password"), data.get("confirmPassword"),
			 * data.get("organizationName"),
			 * data.get("website"),data.get("businessDescription"), data.get("phNo"),
			 * data.get("corporateAddress"), data.get("businessCategories"));
			 * SelectnewMembershipPlan membership =
			 * verification.clickOnSend(data.get("email")); AuthorizeGateway authorize =
			 * membership.MembershipPlansPage(); authorize.makePayment(); quit();
			 */
	        openBrowser(data.get("browser"));
	        logInfo("Launched Browser : " + data.get("browser"));
	        HomePage home1 = new HomePage().open(data.get("tenantType"));
	        LoginPage login = home1.clickOnLOGINBtn();
	        TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email1"), data.get("password1"));
		    OrganizationsPage organisation=	tadashoboard.goToOrganizationsPage();
		    organisation.approveOrganization(data.get("orgName"));
	        
	    }
	    @AfterMethod
		public void tearDown() {
			
			logInfo("Test Completed");
			
			quit();
			
		}
}
