package com.cpcommunity.testScripts.Promocodes;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PromoCodePage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC2152_Verify_Promocode_details_not_saved_if_cancelled_after_filling_details extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC2152(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC2152", data.get("Runmode"), excel);
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();	
		TenantAdminDashboardPage TDP = login.loginToTADashboard(data.get("email"), data.get("password"));
		PromoCodePage PCP=TDP.navigateToPromocodePage();
		PCP.cancelledPromoCode( data.get("promoCode1"),  data.get("promoCodeExpiry"),  data.get("discountByPercent"),
				data.get("discountByValue"),  data.get("discountByPercentageValue1"),  data.get("maxNumberofUses"),  data.get("appliesToAd"),
				 data.get("appliesToMembership"),  data.get("appliesToEvents"),  data.get("allAds"),  data.get("allEvents"),  data.get("allMemberships"),
				data.get("advertisementPlan"), data.get("event"), data.get("memberShipPlan"));
		
}
}