package com.cpcommunity.testScripts.TAMembershipPlan;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageMembershipPlan;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1277_verify_TA_ableto_Inactivate_MembershipPlan extends BaseTest{
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC1276(Hashtable<String, String> data) throws Exception {
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1276", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
    ManageMembershipPlan manageMP= tadashoboard.navigateToMembershipPlansPage();
    manageMP.EditPlan(data.get("PlanName"));
    manageMP.inactivate();
	
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1277 Test Completed");
		
		quit();
	}
		
}
