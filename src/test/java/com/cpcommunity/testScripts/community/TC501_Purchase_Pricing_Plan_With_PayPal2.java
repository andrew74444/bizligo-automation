//package com.cpcommunity.testScripts.community;
//
//import java.util.Hashtable;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//
//import com.cpcommunity.utilities.Constants;
//import com.cpcommunity.utilities.DataUtil;
//import com.cpcommunity.PageObjects.*;
//
//import com.cpcommunity.utilities.DataProviders;
//import com.cpcommunity.utilities.ExcelReader;
//
//public class TC501_Purchase_Pricing_Plan_With_PayPal2 extends BaseTest {
//
//	PaymentReceipt PaymentReceipt;
//	CommunityDetailsPage communityDetailsPage;
//	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
//	public void TC501(Hashtable<String, String> data) throws Exception {
//
//		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
//		DataUtil.checkExecution("master", "TC501", data.get("Runmode"), excel);
//		log.info("Inside Login Test");
//		System.out.println(data.get("duration"));
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : " + data.get("browser"));
//		HomePage home = new HomePage().open();
//		LoginPage loginPage = home.clickOnLOGINBtn();
//		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
//
//		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
//		
//		// String communityName= data.get("communityName")+ currentTime();
//		String communityName = data.get("communityName");
//				AuthorizeGateway AuthorizeGateway;
//		
//			communityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(communityName);
//		
//		
//
//		// CommunityDetailsPage CommunityDetailsPage =
//		// MyCommunitiesPage.navigateToCommunityDetailsPage(communityName);
//		EditCommunityPage editCommunityPage = communityDetailsPage.managecommunity();
//		CommunityDashboardPage communityDashboardPage = editCommunityPage.saveCommunity();
//		PaymentGatewaysPage PaymentGatewaysPage = communityDashboardPage.navigateToPaymentGateways();
//		SetupAuthorizePage setupAuthorizePage = null;
//		PaymentConfirmation PaymentConfirmation = null;
//		try {
//			 setupAuthorizePage = PaymentGatewaysPage.setUpAuthorize();	
//		} catch (Exception e) {
//			PaymentConfirmation = PaymentGatewaysPage.gotoConfirmPaymentPage();
//		}
//		
//		AuthorizeMerchanLogin AuthorizeMerchanLogin;
//		String amount;
//		try {
//			AuthorizeGateway = setupAuthorizePage.SetUpAuthorizeGateway();
//			amount = AuthorizeGateway.makePayment("TC501");
//			PaymentConfirmation = AuthorizeGateway.paymentConfirmation();
//			AuthorizeMerchanLogin = PaymentConfirmation.gotoMerchanLoginPage();
//		} catch (Exception e) {
//			amount = PaymentConfirmation.getAmountPaid("TC501");
//			AuthorizeMerchanLogin = PaymentConfirmation.gotoMerchanLoginPage();
//		}
//		
//		try {
//			String TransactionID = AuthorizeMerchanLogin.getTransactionID();
//			PaymentConfirmation = AuthorizeMerchanLogin.goPaymentConfirmationPage();
//			
//			PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(amount, TransactionID);
//			
//		} catch (Exception e) {
//			
//		}
//		
//
//		PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
//		String membershipPlan = plansPage.createMembershipPlan(data.get("name"), data.get("price"),
//				data.get("duration"), data.get("durationType"), data.get("membershipPlanDescription"));
//
//		ManageJobsPage manageJobsPage = communityDashboardPage.navigateToManageJobsPage();
//		manageJobsPage.postJob(data.get("jobTitle"), data.get("billingRate"), data.get("jobTypeID"),
//				data.get("location"), data.get("description"), data.get("additionalDetails"), data.get("remarks"),
//				data.get("makeGlobal"));
//		ManageGroupsPage ManageGroupsPage = communityDashboardPage.navigateToManageGroupsPage();
//		Create_UpdateGroupPage Create_UpdateGroupPage = ManageGroupsPage.clickOnCreateBtn();
//		Create_UpdateGroupPage.createGroup(data.get("groupName"), data.get("groupDescription"), data.get("city"),
//				data.get("state"), data.get("groupCategory"), data.get("groupType"), data.get("logoImagePath"));
//		// Add Create Ad method
//		home = communityDashboardPage.logout();
//		loginPage = home.clickOnLOGINBtn();
//
//		EcoSystemPage = loginPage.loginToApplication(data.get("email2"), data.get("password"));
//
//		GlobalCommunitesPage globalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
//
//		MembershipPlansPage membershipPlansPage = globalCommunitesPage.joinCommunityWithMembershipPlan(communityName);
//		membershipPlansPage.purchaseMembershipPlan(membershipPlan);
//		if (data.get("paymentMethod").equalsIgnoreCase("paypal")) {
//			PayPalPayment PayPalPayment = membershipPlansPage.paymentByPayPal();
//			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
//		} else if (data.get("paymentMethod").equalsIgnoreCase("authorize")) {
//			AuthorizeGateway = membershipPlansPage.paymentByauthorize();
//			PaymentReceipt = AuthorizeGateway.payment();
//		}
//		PaymentReceipt.paymentSuccess();
//		communityDetailsPage = PaymentReceipt.viewCommunity();
//		communityDetailsPage.verifyMembershipDetails(membershipPlan, data.get("duration"));
//		communityDetailsPage.verifymembershipPlan(membershipPlan, data.get("groupName"), data.get("jobTitle"),
//				data.get("resume"), data.get("optionalMessage"));
//		// myDashboardPage.navigateToMyDashBoard();
//		// myDashboardPage.checkUnreadCountIsDisplayed();
//		home = EcoSystemPage.logout();
//		loginPage = home.clickOnLOGINBtn();
//		EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
//		// myDashboardPage = EcoSystemPage.goToDashBoardPage();
//		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
//		communityDashboardPage = MyCommunitiesPage.gotoManageCommunity(communityName);
//		plansPage = communityDashboardPage.navigateToMembershipPlans();
//		plansPage.checkPurchasedMembershipPlanIsNotEditable();
//	}
//
//	@AfterMethod
//	public void tearDown() {
//
//		logInfo("Login Test Completed");
//
//		quit();
//
//	}
//
//}
