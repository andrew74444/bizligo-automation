package com.cpcommunity.testScripts.PricingPlan;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.CommunityDashboardPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.PayPalPayment;
import com.cpcommunity.PageObjects.PaymentReceipt;
import com.cpcommunity.PageObjects.PricingPlanDetailsPage;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC3013_Verify_CA_Able_To_Renewal_Pricing_Plan extends BaseTest{
	

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC3013(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3013", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		String runTime = openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		
		MyCommunitiesPage MyCommunitiesPage = EcoSystemPage.goToMyCommunities();
		CommunityDashboardPage CommunityDashboardPage = MyCommunitiesPage.gotoManageCommunity(data.get("communityName"));
		PricingPlanDetailsPage pricingPlan=CommunityDashboardPage.navigateToPricingPlanDetailsPage();
	
		SelectPlanPage SelectPlanPage = pricingPlan.renewalPlan();

		SelectPlanPage.renewalFreePlan(data.get("planName"));

	
		//***********To check community admin mail*******************************//		
                Yahoo yahoo= new Yahoo().open();
				yahoo.Login(data.get("email2"), data.get("password2"));//Community admin
				yahoo.planRenewedMailToCA();//pricing plan notification to CA
				yahoo.openAndGoToNewTab();
				
		//***********To check Tenant admin mail*******************************//	
				Yahoo yahoo1= new Yahoo().open();
				yahoo1.Login(data.get("email3"), data.get("password3"));//Tenant admin
				yahoo1.planRenewedMailToTA();//pricing plan notification to TA
				
		
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC3013 Test Completed");
		
		quit();
		
	}
}

