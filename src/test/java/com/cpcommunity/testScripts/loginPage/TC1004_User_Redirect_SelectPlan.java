package com.cpcommunity.testScripts.loginPage;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1004_User_Redirect_SelectPlan extends BaseTest {

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1004(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1004", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		//logInfo("Launched Browser : "+data.get("browser"));	
		//logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		//logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		//login.loginWithPaymentPendingUser(data.get("email"), data.get("password"));
				
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1004 Test Completed");
		
		quit();
		
	}
}
