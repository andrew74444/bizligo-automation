package com.cpcommunity.testScripts.advertisments;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;

public class TC186_Purchase_Advertisment_With_100_Percent_Promo_Code_For_No_Approval_Ad extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC186(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC186", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
			
		MyCommunitiesPage myCommunitiesPage =  EcoSystemPage.goToMyCommunities();
		CommunityDetailsPage communityDetailsPage = myCommunitiesPage.navigateToCommunityDetailsPage(data.get("communityName")+" "+runTime);
		AdvertismentPurchasePage advertismentPurchasePage =communityDetailsPage.clickOnAdvertisements();
		PaymentOptionsPage paymentOptionsPage = advertismentPurchasePage.SelectPlan(data.get("planName"), data.get("adImage"), data.get("linkUrl"), data.get("additionalInstructions"));
		PaymentReceipt paymentReceipt = paymentOptionsPage.makePayment(data.get("paymentMethod"),data.get("promoCode"));
		communityDetailsPage = paymentReceipt.NavigateToCommunityDetailspage();
		communityDetailsPage.verifyAdImage(data.get("expectedImage"));
		

		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}