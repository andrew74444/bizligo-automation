package com.cpcommunity.testScripts.PricingPlan;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PaymentGatewaysPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1289_verify_TA_ableto_inactivate_paymentGateway_when_AllpricingPlan_inactive extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1289(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1289", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
		PaymentGatewaysPage PG=tadashoboard.NavigatetoPaymentGatewayPage();
		PG.selectCommunity(data.get("name"));//added on 28/04 for particular community
		PG.clickAuthorise();
		PG.ClickonInActivate();
		PG.selectCommunity(data.get("name"));
		PG.clickAuthorise();
		PG.ClickonActivate();
	
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1289 Test Completed");
		
		quit();
		
	}
}