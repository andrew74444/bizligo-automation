package com.cpcommunity.testScripts.loginPage;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;
import com.cpcommunity.PageObjects.*;
/**
 * 
 * @author Sasi Vinod Akula
 */
public class TC006_Verify_User_Redirected_To_Select_Plans_For_Payment_Pending extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC006(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC006", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		//logInfo("Launched Browser : "+data.get("browser"));	
		//logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		//logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		login.loginWithPaymentPendingUser(data.get("email"), data.get("password"));
				
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC006 Test Completed");
		
		quit();
		
	}
}
