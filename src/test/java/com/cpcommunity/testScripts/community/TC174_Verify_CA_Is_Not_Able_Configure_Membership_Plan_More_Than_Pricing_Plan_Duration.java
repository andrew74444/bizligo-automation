package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC174_Verify_CA_Is_Not_Able_Configure_Membership_Plan_More_Than_Pricing_Plan_Duration extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC501(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC501", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage= MyCommunitiesPage.gotoManageCommunity(data.get("communityName")+" "+runTime);
		PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
		plansPage.createMembershipPlan(data.get("name"), data.get("price"),	"99", data.get("durationType"), data.get("membershipPlanDescription"));
		plansPage.checkMembershipPlanDurationCannotExceedThePricingPlanDuration();
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC174 Test Completed");

		quit();

	}

}
