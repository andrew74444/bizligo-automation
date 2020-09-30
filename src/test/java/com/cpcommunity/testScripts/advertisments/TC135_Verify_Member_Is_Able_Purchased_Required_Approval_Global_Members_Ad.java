package com.cpcommunity.testScripts.advertisments;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;

public class TC135_Verify_Member_Is_Able_Purchased_Required_Approval_Global_Members_Ad extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC135(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC135", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage =  EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage communityDetailsPage = myCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		AdvertismentPurchasePage advertismentPurchasePage =communityDetailsPage.clickOnAdvertisements();
		PaymentOptionsPage paymentOptionsPage = advertismentPurchasePage.SelectPlan(data.get("planName"),  data.get("adImage"), data.get("linkUrl"), data.get("additionalInstructions"));
		PaymentReceipt paymentReceipt = paymentOptionsPage.makePayment(data.get("paymentMethod"),data.get("promoCode"));
		paymentReceipt.verifyAdSentToAdminReview();
		communityDetailsPage = paymentReceipt.NavigateToCommunityDetailspage();
		home = EcoSystemPage.logout();
		login = home.clickOnLOGINBtn();
		EcoSystemPage = login.loginToApplication(data.get("email2"), data.get("password"));
			
		myCommunitiesPage =  EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		ManageMemberAdvertisementsPage manageMemberAdvertisementsPage =communityDashboardPage.navigateToMemberAdvertisements();
		manageMemberAdvertisementsPage.verifyPurchasedAdisDisplayed(data.get("planName"));	
		
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}