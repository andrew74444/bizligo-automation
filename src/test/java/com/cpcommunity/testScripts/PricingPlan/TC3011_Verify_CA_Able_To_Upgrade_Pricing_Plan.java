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

public class TC3011_Verify_CA_Able_To_Upgrade_Pricing_Plan extends BaseTest{
	
	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC3011(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3011", data.get("Runmode"), excel);
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
	
		SelectPlanPage SelectPlanPage = pricingPlan.upgradePlan();

		SelectPlanPage.selectPaidPlan(data.get("planName"));

		if (data.get("paymentGateway").equalsIgnoreCase("paypal")) {
			PayPalPayment PayPalPayment = SelectPlanPage.paymentByPayPal();
			PaymentReceipt = PayPalPayment.Payment(data.get("PEmail"), data.get("PPwd"));
		}

		else if (data.get("paymentGateway").equalsIgnoreCase("authorize")) {
			AuthorizeGateway AuthorizeGateway = SelectPlanPage.paymentByauthorize();
			PaymentReceipt = AuthorizeGateway.payment();
		}

		PaymentReceipt.paymentSuccess();
		
		//***********To check community admin mail*******************************//	
		      Yahoo yahoo= new Yahoo().open();
				yahoo.Login(data.get("email2"), data.get("password2"));//Community admin
				yahoo.planUpgradedMailToCA();//pricing plan notification to CA
				yahoo.openAndGoToNewTab();
				
		//***********To check Tenant admin mail*******************************//	
				Yahoo yahoo1= new Yahoo().open();
				yahoo1.Login(data.get("email3"), data.get("password3"));//Tenant admin
				yahoo1.planUpgradedMailToTA();//pricing plan notification to TA
				
		
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC3011 Test Completed");
		
		quit();
		
	}
}
