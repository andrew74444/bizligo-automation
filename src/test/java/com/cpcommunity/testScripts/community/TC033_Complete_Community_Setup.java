package com.cpcommunity.testScripts.community;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.AuthorizeGateway;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.PayPalPayment;
import com.cpcommunity.PageObjects.PaymentReceipt;
import com.cpcommunity.PageObjects.SelectPlanPage;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC033_Complete_Community_Setup extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC033(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC033", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage = loginPage.loginToApplication(data.get("email"), data.get("password"));
		MyDashboardPage myDashboardPage = EcoSystemPage.goToDashBoardPage();
		MyCommunitiesPage MyCommunitiesPage = myDashboardPage.NaviagtingToMyCommunities();
		SelectPlanPage SelectPlanPage = MyCommunitiesPage.completeSetup(data.get("communityName"));

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

		// Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
