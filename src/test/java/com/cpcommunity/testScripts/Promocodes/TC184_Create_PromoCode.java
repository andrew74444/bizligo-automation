package com.cpcommunity.testScripts.Promocodes;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.*;

public class TC184_Create_PromoCode extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC184(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC184", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		System.out.println(data);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage myCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage communityDashboardPage = myCommunitiesPage.NaviagtetoManageCommunity(data.get("communityName"));
		PromoCodePage promoCodePage = communityDashboardPage.goToPromoCodePage();
		promoCodePage.createPromocode( data.get("promoCode1"),  data.get("promoCodeExpiry"),  data.get("discountByPercent"),
				data.get("discountByValue"),  data.get("discountByPercentageValue1"),  data.get("maxNumberofUses"),  data.get("appliesToAd"),
				 data.get("appliesToMembership"),  data.get("appliesToEvents"),  data.get("allAds"),  data.get("allEvents"),  data.get("allMemberships"),
				data.get("advertisementPlan"), data.get("event"), data.get("memberShipPlan"));
		promoCodePage.createPromocode( data.get("promoCode2"),  data.get("promoCodeExpiry"),  data.get("discountByPercent"),
				data.get("discountByValue"),  data.get("discountByPercentageValue2"),  data.get("maxNumberofUses"),  data.get("appliesToAd"),
				 data.get("appliesToMembership"),  data.get("appliesToEvents"),  data.get("allAds"),  data.get("allEvents"),  data.get("allMemberships"),
				data.get("advertisementPlan"), data.get("event"), data.get("memberShipPlan"));
		promoCodePage.createPromocode( data.get("promoCode3"),  data.get("promoCodeExpiry"),  data.get("discountByPercent"),
				data.get("discountByValue"),  data.get("discountByPercentageValue1"),  data.get("maxNumberofUses"),  data.get("appliesToAd"),
				 data.get("appliesToMembership"),  data.get("appliesToEvents"),  data.get("allAds"),  data.get("allEvents"),  data.get("allMemberships"),
				data.get("advertisementPlan"), data.get("event"), data.get("memberShipPlan"));
	}

	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
