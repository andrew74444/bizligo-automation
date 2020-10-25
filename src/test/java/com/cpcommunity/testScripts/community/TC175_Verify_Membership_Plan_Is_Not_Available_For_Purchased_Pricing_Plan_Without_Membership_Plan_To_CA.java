package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC175_Verify_Membership_Plan_Is_Not_Available_For_Purchased_Pricing_Plan_Without_Membership_Plan_To_CA extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC175(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC175", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();

		CreateCommunityPage CreateCommunityPage = MyCommunitiesPage.clickOnCreateCommunity();
		try {
			CreateCommunityPage.CreateCommunity(data.get("communityName")+" "+runTime, data.get("Networking"), data.get("Marketing"),data.get("BuildingRelationship"), data.get("Branding"), data.get("GrowMyBusiness"),data.get("InvestInBusiness"), data.get("Other"), data.get("About"), data.get("Category"),data.get("type"));
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
				
		
		home = EcoSystemPage.logout();
		home.clickOnLOGINBtn();
		SystemAdminDashboardPage systemAdminDashboardPage = login.SystemAdminloginToApplication(data.get("email1"),	data.get("password"));
		PendingCommunitiesPage PendingCommunitiesPage = systemAdminDashboardPage.naviagteToPendingCommunities();

		try {
			PendingCommunitiesPage.approveCommunity(data.get("communityName")+" "+runTime);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		home = systemAdminDashboardPage.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		EcoSystemPage = EcoSystemPage.goToMyEcosystem();
		MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage CommunityDetailsPage;
		try {
			SelectPlanPage SelectPlanPage = MyCommunitiesPage.completeSetup(data.get("communityName")+" "+runTime);
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
			 CommunityDetailsPage = PaymentReceipt.viewCommunity();	
		} catch (Exception e) {
			CommunityDetailsPage = MyCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		}
		
		EditCommunityPage editCommunityPage = CommunityDetailsPage.managecommunity();
		CommunityDashboardPage communityDashboardPage = editCommunityPage.saveCommunity();
		communityDashboardPage.checkMembershipPlansNotAvailable();
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC175 Test Completed");

		quit();

	}

}
