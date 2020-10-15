package com.cpcommunity.testScripts.community;



import java.util.Date;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC179_Verify_Member_Is_Able_Update_Membership_Plan extends BaseTest {

		
	PaymentReceipt paymentReceipt;
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC179(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC179", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		GlobalCommunitesPage GlobalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		CommunityDetailsPage CommunityDetailsPage = GlobalCommunitesPage.navigateToExpiredCommunityDetailsPage(data.get("communityName"));
		MembershipPlansPage membershipPlansPage = CommunityDetailsPage.renewMemberShipPlan();
		membershipPlansPage.renewThePurchasedMembershipPlan();

		if (data.get("paymentMethod").equalsIgnoreCase("paypal")) 
		{
			PayPalPayment PayPalPayment = membershipPlansPage.paymentByPayPal();
			paymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
		} else if (data.get("paymentMethod").equalsIgnoreCase("authorize")) {
			AuthorizeGateway AuthorizeGateway = membershipPlansPage.paymentByauthorize();
			paymentReceipt = AuthorizeGateway.payment();
		}
		paymentReceipt.paymentSuccess();
		CommunityDetailsPage = paymentReceipt.viewCommunity();
		
//		CommunityDetailsPage.verifyMembershipDetails(membershipPlan, data.get("duration"));
		
		
		//Assert.fail("Failing the login test");
	}


	@AfterMethod
	public void tearDown() {
		
		logInfo("TC179 Test Completed");
		
		quit();
		
	}

}
