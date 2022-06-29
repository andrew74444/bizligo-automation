package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
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
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
				
		GlobalCommunitesPage globalCommunitesPage = EcoSystemPage.goToGlobalCommunities();
		
		MembershipPlansPage membershipPlansPage = globalCommunitesPage.joinCommunityWithMembershipPlan(data.get("communityName"));//+" "+runTime
		membershipPlansPage.purchaseMembershipPlan(data.get("membershipPlan"));
		PaymentReceipt=	membershipPlansPage.usingPromoCode(data.get("code"));//added on 10/05
//		if (data.get("paymentMethod").equalsIgnoreCase("paypal")) 
//		{
//			PayPalPayment PayPalPayment = membershipPlansPage.paymentByPayPal();
//			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
//		} else if (data.get("paymentMethod").equalsIgnoreCase("authorize")) {
//			AuthorizeGateway AuthorizeGateway = membershipPlansPage.paymentByauthorize();
//			PaymentReceipt = AuthorizeGateway.payment();
//		}
		PaymentReceipt.paymentSuccess();
		CommunityDetailsPage communityDetailsPage = PaymentReceipt.viewCommunity();
	//	communityDetailsPage.verifyMembershipDetails(data.get("membershipPlan"), data.get("duration"));
	//	communityDetailsPage.verifymembershipPlan(data.get("membershipPlan"), data.get("groupName"), data.get("jobTitle"),data.get("resume"), data.get("optionalMessage"));
		communityDetailsPage.verifyMembershipPlan(data.get("membershipPlan"));//added on 10/05
		//		Dashboard_Page.navigateToMyDashBoard();
//		Dashboard_Page.checkUnreadCountIsDisplayed();
		
			
		
		
		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("TC187 Test Completed");

	quit();

	}

}
