package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC172_Verify_Purchased_Membership_Is_Not_Editable_To_CA extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC172(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC172", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage= MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
		plansPage.checkPurchasedMembershipPlanIsNotEditable();	
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC172 Test Completed");

		quit();

	}

}
