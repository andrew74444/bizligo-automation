package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.AuthorizeMerchanLogin;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.CreateCommunityPage;
import com.cpcommunity.PageObjects.Create_UpdateGroupPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.EditCommunityPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageGroupsPage;
import com.cpcommunity.PageObjects.ManageJobsPage;
import com.cpcommunity.PageObjects.MembershipPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PayPalPayment;
import com.cpcommunity.PageObjects.PaymentConfirmation;
import com.cpcommunity.PageObjects.PaymentGatewaysPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.PlansPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.SetupAuthorizePage;
import com.cpcommunity.PageObjects.PaymentReceipt;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC182_Verify_CA_Is_Not_Able_To_Create_Paid_Membership_Plan_Without_PG_Configuration extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC182(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC182", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		CommunityDashboardPage communityDashboardPage= MyCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
		plansPage.verifyCANotAbleToCreatePaidPlanForPayMentGatewayNotConfigured(data.get("price"));
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
