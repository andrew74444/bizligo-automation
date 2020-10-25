package com.cpcommunity.testScripts.advertisments;

import java.util.Hashtable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.utilities.*;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;

public class TC183_Verify_CA_Is_Not_Able_To_Create_Advertisment_Plan_Without_PG_Configuration extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC183(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC183", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
			
		MyCommunitiesPage myCommunitiesPage=EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage =myCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		ManageAdPlansPage manageAdPlansPage =communityDashboardPage.goToManageAdPlansPage();
		manageAdPlansPage.verifyCAIsNotAblrToCreateAdPlanWithoutConfiguringPaymentGateways();
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
