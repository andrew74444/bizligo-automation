package com.cpcommunity.testScripts.advertisments;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.AdvertismentPurchasePage;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.CommunityDetailsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCommunitesPage;
import com.cpcommunity.PageObjects.GlobalMembersPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageAdPlansPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PaymentOptionsPage;
import com.cpcommunity.PageObjects.PaymentReceipt;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC137_Purchase_Advertisment_With_No_Approval_And_Verify_The_Ad_Is_Displayed_In_Global_Members_Page extends BaseTest {
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC137(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC137", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();	
		MyCommunitiesPage myCommunitiesPage =  myDashboardPage.NaviagtingToMyCommunities();
		CommunityDetailsPage communityDetailsPage = myCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName"));
		AdvertismentPurchasePage advertismentPurchasePage =communityDetailsPage.clickOnAdvertisements();
		PaymentOptionsPage paymentOptionsPage = advertismentPurchasePage.SelectPlan(data.get("planName"),  data.get("adImage"), data.get("linkUrl"), data.get("additionalInstructions"));
		PaymentReceipt paymentReceipt = paymentOptionsPage.makePayment(data.get("paymentMethod"),data.get("promoCode"));
		paymentReceipt.verifyPublishedMessageisDisplayed();
		GlobalMembersPage globalMembersPage =myDashboardPage.navigateToGlobalMembers();
		globalMembersPage.verifyAdImage(data.get("imgVerification"));

		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}