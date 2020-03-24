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

public class TC175_Verify_Membership_Plan_Is_Not_Available_For_Purchased_Pricing_Plan_Without_Membership_Plan_To_CA extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC175(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC175", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		CreateCommunityPage.CreateCommunity(data.get("communityName"), data.get("Networking"), data.get("Marketing"),data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"),data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"),data.get("type"));
		home = Dashboard_Page.logout();
		home.clickOnLOGINBtn();
		SystemAdminDashboardPage systemAdminDashboardPage = login.SystemAdminloginToApplication(data.get("email1"),	data.get("password"));
		PendingCommunitiesPage PendingCommunitiesPage = systemAdminDashboardPage.naviagteToPendingCommunities();
		PendingCommunitiesPage.approveCommunity(data.get("communityName"));
		home = systemAdminDashboardPage.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		Dashboard_Page = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
		SelectPlanPage SelectPlanPage = MyCommunitiesPage.completeSetup(data.get("communityName"));
		SelectPlanPage.selectPaidPlan(data.get("planName"));
		if (data.get("paymentGateway").equalsIgnoreCase("paypal")) 
		{
			PayPalPayment PayPalPayment = SelectPlanPage.paymentByPayPal();
			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
		} else if (data.get("paymentGateway").equalsIgnoreCase("authorize")) 
		{
			AuthorizeGateway AuthorizeGateway = SelectPlanPage.paymentByauthorize();
			PaymentReceipt = AuthorizeGateway.payment();
		}
		PaymentReceipt.paymentSuccess();
		CommunityDetailsPage CommunityDetailsPage = PaymentReceipt.viewCommunity();
		EditCommunityPage editCommunityPage = CommunityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage = editCommunityPage.saveCommunity();
		communityDashboardPage.checkMembershipPlansNotAvailable();
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
