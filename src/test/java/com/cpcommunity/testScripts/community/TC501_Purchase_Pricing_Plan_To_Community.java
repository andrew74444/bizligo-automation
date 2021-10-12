/*
 * package com.cpcommunity.testScripts.community;
 * 
 * import java.util.Hashtable;
 * 
 * import org.testng.annotations.AfterMethod; import
 * org.testng.annotations.Test;
 * 
 * import com.cpcommunity.utilities.Constants; import
 * com.cpcommunity.utilities.DataUtil; import com.cpcommunity.PageObjects.*;
 * 
 * import com.cpcommunity.utilities.DataProviders; import
 * com.cpcommunity.utilities.ExcelReader;
 * 
 * public class TC501_Purchase_Pricing_Plan_To_Community extends BaseTest {
 * 
 * PaymentReceipt PaymentReceipt; CommunityDetailsPage communityDetailsPage;
 * 
 * @Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
 * public void TC501(Hashtable<String, String> data) throws Exception {
 * 
 * ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
 * DataUtil.checkExecution("master", "TC501", data.get("Runmode"), excel);
 * log.info("Inside Login Test"); System.out.println(data.get("duration"));
 * String runTime = openBrowser(data.get("browser"));
 * logInfo("Launched Browser : " + data.get("browser"));
 * logInfo("BizLigo Application Opened"); HomePage home = new
 * HomePage().open(data.get("tenantType")); LoginPage loginPage =
 * home.clickOnLOGINBtn(); EcoSystemPage EcoSystemPage =
 * loginPage.loginToApplication(data.get("email"), data.get("password"));
 * 
 * MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
 * CreateCommunityPage CreateCommunityPage =
 * MyCommunitiesPage.clickOnCreateCommunity(); // String communityName=
 * data.get("communityName")+ currentTime(); String communityName =
 * data.get("communityName")+" "+runTime; try {
 * CreateCommunityPage.CreateCommunity(communityName, data.get("Networking"),
 * data.get("Marketing"), data.get("BuildingRelationship"),
 * data.get("Branding"), data.get("GrowMyBusiness"),
 * data.get("InvestInBusiness"), data.get("Other"), data.get("About"),
 * data.get("Category"), data.get("type")); } catch (Exception e) {
 * 
 * }
 * 
 * home = EcoSystemPage.logout(); home.clickOnLOGINBtn();
 * SystemAdminDashboardPage systemAdminDashboardPage =
 * loginPage.SystemAdminloginToApplication(data.get("email1"),
 * data.get("password")); PendingCommunitiesPage PendingCommunitiesPage =
 * systemAdminDashboardPage.naviagteToPendingCommunities(); try {
 * PendingCommunitiesPage.approveCommunity(communityName); } catch (Exception e)
 * {
 * 
 * } home = systemAdminDashboardPage.logout(); loginPage =
 * home.clickOnLOGINBtn(); EcoSystemPage =
 * loginPage.loginToApplication(data.get("email"), data.get("password"));
 * 
 * MyCommunitiesPage = EcoSystemPage.goToMyCommunities(); AuthorizeGateway
 * AuthorizeGateway; try {
 * 
 * SelectPlanPage SelectPlanPage =
 * MyCommunitiesPage.completeSetup(communityName);
 * SelectPlanPage.selectPaidPlan(data.get("planName")); if
 * (data.get("paymentGateway").equalsIgnoreCase("paypal")) { PayPalPayment
 * PayPalPayment = SelectPlanPage.paymentByPayPal(); PaymentReceipt =
 * PayPalPayment.Payment(data.get("email"), data.get("password")); } else if
 * (data.get("paymentGateway").equalsIgnoreCase("authorize")) { AuthorizeGateway
 * = SelectPlanPage.paymentByauthorize(); PaymentReceipt =
 * AuthorizeGateway.payment(); } PaymentReceipt.paymentSuccess();
 * communityDetailsPage = PaymentReceipt.viewCommunity(); } catch (Exception e)
 * { communityDetailsPage =
 * MyCommunitiesPage.navigateToCommunityDetailsPage(communityName); }
 * 
 * // CommunityDetailsPage CommunityDetailsPage = //
 * MyCommunitiesPage.navigateToCommunityDetailsPage(communityName);
 * EditCommunityPage editCommunityPage = communityDetailsPage.managecommunity();
 * CommunityDashboardPage communityDashboardPage =
 * editCommunityPage.saveCommunity(); PaymentGatewaysPage PaymentGatewaysPage =
 * communityDashboardPage.navigateToPaymentGateways(); SetupAuthorizePage
 * setupAuthorizePage = null; PaymentConfirmation PaymentConfirmation = null;
 * try { setupAuthorizePage = PaymentGatewaysPage.setUpAuthorize(); } catch
 * (Exception e) {
 * 
 * }
 * 
 * try { PaymentConfirmation = PaymentGatewaysPage.gotoConfirmPaymentPage(); }
 * catch (Exception e) {
 * 
 * }
 * 
 * AuthorizeMerchanLogin AuthorizeMerchanLogin = null; String amount = null; try
 * { AuthorizeGateway = setupAuthorizePage.SetUpAuthorizeGateway(); amount =
 * AuthorizeGateway.makePayment("TC501"); PaymentConfirmation =
 * AuthorizeGateway.paymentConfirmation(); AuthorizeMerchanLogin =
 * PaymentConfirmation.gotoMerchanLoginPage(); } catch (Exception e) {
 * AuthorizeMerchanLogin = PaymentConfirmation.gotoMerchanLoginPage(); }
 * 
 * 
 * try {
 * 
 * 
 * } catch (Exception e) {
 * 
 * }
 * 
 * try { amount = PaymentConfirmation.getAmountPaid("TC501"); String
 * TransactionID = AuthorizeMerchanLogin.getTransactionID(); PaymentConfirmation
 * = AuthorizeMerchanLogin.goPaymentConfirmationPage();
 * 
 * PaymentGatewaysPage = PaymentConfirmation.EnterTransactionDetails(amount,
 * TransactionID);
 * 
 * } catch (Exception e) {
 * 
 * }
 * 
 * PlansPage plansPage = communityDashboardPage.navigateToMembershipPlans();
 * String membershipPlan = plansPage.createMembershipPlan(data.get("name"),
 * data.get("price"), data.get("duration"), data.get("durationType"),
 * data.get("membershipPlanDescription"));
 * 
 * ManageJobsPage manageJobsPage =
 * communityDashboardPage.navigateToManageJobsPage();
 * manageJobsPage.postJob(data.get("jobTitle"), data.get("billingRate"),
 * data.get("jobTypeID"), data.get("location"), data.get("description"),
 * data.get("additionalDetails"), data.get("remarks"), data.get("makeGlobal"));
 * ManageGroupsPage ManageGroupsPage =
 * communityDashboardPage.navigateToManageGroupsPage(); Create_UpdateGroupPage
 * Create_UpdateGroupPage = ManageGroupsPage.clickOnCreateBtn();
 * Create_UpdateGroupPage.createGroup(data.get("groupName"),
 * data.get("groupDescription"), data.get("city"), data.get("state"),
 * data.get("groupCategory"), data.get("groupType")); // Add Create Ad method
 * home = communityDashboardPage.logout(); loginPage = home.clickOnLOGINBtn();
 * 
 * EcoSystemPage = loginPage.loginToApplication(data.get("email2"),
 * data.get("password"));
 * 
 * GlobalCommunitesPage globalCommunitesPage =
 * EcoSystemPage.goToGlobalCommunities(); try {
 * 
 * MembershipPlansPage membershipPlansPage = globalCommunitesPage
 * .joinCommunityWithMembershipPlan(communityName);
 * membershipPlansPage.purchaseMembershipPlan(membershipPlan); if
 * (data.get("paymentMethod").equalsIgnoreCase("paypal")) { PayPalPayment
 * PayPalPayment = membershipPlansPage.paymentByPayPal(); PaymentReceipt =
 * PayPalPayment.Payment(data.get("email"), data.get("password")); } else if
 * (data.get("paymentMethod").equalsIgnoreCase("authorize")) { AuthorizeGateway
 * = membershipPlansPage.paymentByauthorize(); PaymentReceipt =
 * AuthorizeGateway.payment(); } PaymentReceipt.paymentSuccess();
 * communityDetailsPage = PaymentReceipt.viewCommunity();
 * communityDetailsPage.verifyMembershipDetails(membershipPlan,
 * data.get("duration"));
 * communityDetailsPage.verifymembershipPlan(membershipPlan,
 * data.get("groupName"), data.get("jobTitle"), data.get("resume"),
 * data.get("optionalMessage")); // myDashboardPage.navigateToMyDashBoard(); //
 * myDashboardPage.checkUnreadCountIsDisplayed(); } catch (Exception e) { //
 * TODO: handle exception } home = EcoSystemPage.logout(); // loginPage =
 * home.clickOnLOGINBtn(); // EcoSystemPage =
 * loginPage.loginToApplication(data.get("email"), data.get("password")); // //
 * myDashboardPage = EcoSystemPage.goToDashBoardPage(); // MyCommunitiesPage =
 * EcoSystemPage.goToMyCommunities(); // communityDashboardPage =
 * MyCommunitiesPage.gotoManageCommunity(communityName); // plansPage =
 * communityDashboardPage.navigateToMembershipPlans(); //
 * plansPage.checkPurchasedMembershipPlanIsNotEditable(); }
 * 
 * @AfterMethod public void tearDown() {
 * 
 * logInfo("TC501 Test Completed");
 * 
 * quit();
 * 
 * }
 * 
 * }
 */