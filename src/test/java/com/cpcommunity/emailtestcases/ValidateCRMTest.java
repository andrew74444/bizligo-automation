package com.cpcommunity.emailtestcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class ValidateCRMTest extends BaseTest  {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",enabled=false)
	public void validateCRMTest(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "ValidateCRMTest", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
//		ZohoHomePage home = new ZohoHomePage().open("https://www.zoho.com/");
//		ZohoLoginPage login = home.gotoLogin();
//		ZohoAppPage app = login.doLoginAsValidUser(getDefaultUserName(), getDefaultPassword());
//		logInfo("Username entered as "+getDefaultUserName()+" and Password entered as "+getDefaultPassword());
		
//		app.gotoCRM();
			//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
