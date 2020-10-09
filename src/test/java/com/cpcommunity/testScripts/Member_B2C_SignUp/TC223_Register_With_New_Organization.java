package com.cpcommunity.testScripts.Member_B2C_SignUp;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC223_Register_With_New_Organization extends BaseTest {

	PaymentReceipt PaymentReceipt;
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "masterDP")
	public void TC223(Hashtable<String, String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC223", data.get("Runmode"), excel);
		log.info("Inside TC223 Test");
		log.info(data);
		
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : " + data.get("browser"));
		HomePage home = new HomePage().open();
		LoginPage loginPage = home.clickOnLOGINBtn();
		SignupPage signupPage = loginPage.clickonSignup();
		AccountVerificationCodePage accountVerificationCodePage= signupPage.signup(data.get("firstName"), data.get("lastName"), data.get("emailAddress"), data.get("phNo"), data.get("password"), data.get("isB2B"), data.get("isNewOrg"), data.get("corporateAddress"), data.get("organizationName"), data.get("website"), data.get("businessDescription"), data.get("businessCategories"), data.get("isOrgRequired"));
		accountVerificationCodePage.clickOnSend();
//		accountVerificationCodePage = new AccountVerificationCodePage().open(""); 
		String url = accountVerificationCodePage.getURL();
		log.info(url);
		Gmail gmail = accountVerificationCodePage.goToGmail();
		gmail.Login(data.get("emailAddress"), data.get("password"));		
		gmail.emailNotification("You're almost there!");
		String otp = gmail.getOtp();
		accountVerificationCodePage.open(url);
		AccountSelectPlansPage accountSelectPlansPage = accountVerificationCodePage.verifyCode(otp);	
//		AccountSelectPlansPage accountSelectPlansPage = new AccountSelectPlansPage().open("");
		accountSelectPlansPage.selectPlan(data.get("plan"));
		if (data.get("paymentGateway").equalsIgnoreCase("paypal")) 
		{
			PayPalPayment PayPalPayment = accountSelectPlansPage.paymentByPayPal();
			PaymentReceipt = PayPalPayment.Payment(data.get("email"), data.get("password"));
		} else if (data.get("paymentGateway").equalsIgnoreCase("authorize")) 
		{
			AuthorizeGateway AuthorizeGateway = accountSelectPlansPage.paymentByauthorize();
			PaymentReceipt = AuthorizeGateway.payment();
		}
		PaymentReceipt.paymentSuccess();
		 
				

		
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {

		logInfo("Login Test Completed");

		quit();

	}

}
