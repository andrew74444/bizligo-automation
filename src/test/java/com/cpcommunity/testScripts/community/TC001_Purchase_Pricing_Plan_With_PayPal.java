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

public class TC001_Purchase_Pricing_Plan_With_PayPal extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC001(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC001", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = myDashboardPage.NaviagtingToMyCommunities();
		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
//		String communityName= data.get("communityName")+ currentTime();
		String communityName= data.get("communityName");
		CreateCommunityPage.CreateCommunity(communityName, data.get("Networking"), data.get("Marketing"),data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"),data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"),data.get("type"));
		home = myDashboardPage.logout();
		home.clickOnLOGINBtn();
		SystemAdminDashboardPage systemAdminDashboardPage = loginPage.SystemAdminloginToApplication(data.get("email1"),	data.get("password"));
		PendingCommunitiesPage PendingCommunitiesPage = systemAdminDashboardPage.naviagteToPendingCommunities();
		PendingCommunitiesPage.approveCommunity(communityName);
		home = systemAdminDashboardPage.logout();
		loginPage = home.clickOnLOGINBtn();
		EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		myDashboardPage = EcoSystemPage.goToDashBoardPage();
		
		MyCommunitiesPage = myDashboardPage.NaviagtingToMyCommunities();
		SelectPlanPage SelectPlanPage = MyCommunitiesPage.completeSetup(communityName);
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
		
//		CommunityDetailsPage CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(communityName);
		EditCommunityPage editCommunityPage = CommunityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage = editCommunityPage.saveCommunity();
		PaymentGatewaysPage PaymentGatewaysPage = communityDashboardPage.navigateToPaymentGateways();
		SetupAuthorizePage SetupAuthorizePage =PaymentGatewaysPage.setUpAuthorize();
		AuthorizeGateway AuthorizeGateway =SetupAuthorizePage.SetUpAuthorizeGateway();
		String amount = AuthorizeGateway.makePayment();
		PaymentConfirmation PaymentConfirmation = AuthorizeGateway.paymentConfirmation();
		AuthorizeMerchanLogin AuthorizeMerchanLogin = PaymentConfirmation.login(); 
		String TransactionID =AuthorizeMerchanLogin.MerchantLogin();
		PaymentConfirmation = AuthorizeMerchanLogin.confirmation();		
		PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(amount, TransactionID);
		
		PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
		String membershipPlan = plansPage.createMembershipPlan(data.get("name"), data.get("price"),	data.get("duration"), data.get("durationType"), data.get("membershipPlanDescription"));

		ManageJobsPage manageJobsPage = communityDashboardPage.navigateToManageJobsPage();
		manageJobsPage.postJob(data.get("jobTitle"), data.get("billingRate"), data.get("jobTypeID"),data.get("location"), data.get("description"), data.get("additionalDetails"), data.get("remarks"),data.get("makeGlobal"));
		ManageGroupsPage ManageGroupsPage = communityDashboardPage.navigateToManageGroupsPage();
		Create_UpdateGroupPage Create_UpdateGroupPage = ManageGroupsPage.clickOnCreateBtn();
		Create_UpdateGroupPage.createGroup(data.get("groupName"), data.get("groupDescription"), data.get("city"),
				data.get("state"), data.get("groupCategory"), data.get("groupType"), data.get("logoImagePath"));
		// Add Create Ad method
		home = communityDashboardPage.logout();
		loginPage = home.clickOnLOGINBtn();
		
		EcoSystemPage = loginPage.loginToApplication(data.get("email2"), data.get("password"));
		myDashboardPage =EcoSystemPage.goToDashBoardPage();
		GlobalCommunitesPage globalCommunitesPage = myDashboardPage.NaviagtingToGlobalCommunities();
		
		MembershipPlansPage membershipPlansPage = globalCommunitesPage.joinCommunityWithMembershipPlan(communityName);
		membershipPlansPage.purchaseMembershipPlan(membershipPlan);
		if (data.get("paymentMethod").equalsIgnoreCase("paypal")) 
		{
			PayPalPayment PayPalPayment = membershipPlansPage.paymentByPayPal();
			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
		} else if (data.get("paymentMethod").equalsIgnoreCase("authorize")) {
			AuthorizeGateway = membershipPlansPage.paymentByauthorize();
			PaymentReceipt = AuthorizeGateway.payment();
		}
		PaymentReceipt.paymentSuccess();
		CommunityDetailsPage = PaymentReceipt.viewCommunity();
		CommunityDetailsPage.verifyMembershipDetails(membershipPlan, data.get("duration"));
		CommunityDetailsPage.verifymembershipPlan(membershipPlan, data.get("groupName"), data.get("jobTitle"),data.get("resume"), data.get("optionalMessage"));
		myDashboardPage.navigateToMyDashBoard();
		myDashboardPage.checkUnreadCountIsDisplayed();
		home = myDashboardPage.logout();
		loginPage = home.clickOnLOGINBtn();
		EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage = myDashboardPage.NaviagtingToMyCommunities();	
		communityDashboardPage= MyCommunitiesPage.NaviagtetoManageCommunity(communityName);
		plansPage = communityDashboardPage.navigateToMembershipPlans();
		plansPage.checkPurchasedMembershipPlanIsNotEditable();	
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
