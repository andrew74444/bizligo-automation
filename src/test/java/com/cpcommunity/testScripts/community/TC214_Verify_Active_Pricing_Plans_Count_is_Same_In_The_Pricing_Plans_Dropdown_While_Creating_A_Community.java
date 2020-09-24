package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.PendingCommunitiesPage;
import com.cpcommunity.PageObjects.PlansPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.TACommunitiesPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC214_Verify_Active_Pricing_Plans_Count_is_Same_In_The_Pricing_Plans_Dropdown_While_Creating_A_Community extends BaseTest {


	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC214(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC214", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();	
		SystemAdminDashboardPage Dashboard_Page = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		TACommunitiesPage tACommunitiesPage =  Dashboard_Page.navigateToCommunitiesPage();
		int tppdd = tACommunitiesPage.checkActivePricingPlans();
		PlansPage plansPage = Dashboard_Page.NavigateManagePricingPlans();
		int tapp= plansPage.getTotalActivePlansCount();
		logInfo("Total Active Plans in Pricing Plans Page:"+tapp+" Total Active Plans in Drop down is: "+tppdd );

		Assert.assertEquals(tppdd, tapp);
//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC205 Test Completed");
		
		quit();
		
	}

}
