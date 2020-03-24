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

public class TC187_Purchase_Membership_With_100_Percent_PromoCode extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC187(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC187", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data.get("duration"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage Dashboard_Page = EcoSystemPage.goToDashBoardPage();
				
		GlobalCommunitesPage globalCommunitesPage = Dashboard_Page.NaviagtingToGlobalCommunities();
		
		MembershipPlansPage membershipPlansPage = globalCommunitesPage.joinCommunityWithMembershipPlan(data.get("communityName"));
		membershipPlansPage.purchaseMembershipPlan(data.get("membershipPlan"));
		if (data.get("paymentMethod").equalsIgnoreCase("paypal")) 
		{
			PayPalPayment PayPalPayment = membershipPlansPage.paymentByPayPal();
			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
		} else if (data.get("paymentMethod").equalsIgnoreCase("authorize")) {
			AuthorizeGateway AuthorizeGateway = membershipPlansPage.paymentByauthorize();
			PaymentReceipt = AuthorizeGateway.payment();
		}
		PaymentReceipt.paymentSuccess();
		CommunityDetailsPage communityDetailsPage = PaymentReceipt.viewCommunity();
		communityDetailsPage.verifyMembershipDetails(data.get("membershipPlan"), data.get("duration"));
		communityDetailsPage.verifymembershipPlan(data.get("membershipPlan"), data.get("groupName"), data.get("jobTitle"),data.get("resume"), data.get("optionalMessage"));
		Dashboard_Page.navigateToMyDashBoard();
		Dashboard_Page.checkUnreadCountIsDisplayed();
		
			
		
		
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
