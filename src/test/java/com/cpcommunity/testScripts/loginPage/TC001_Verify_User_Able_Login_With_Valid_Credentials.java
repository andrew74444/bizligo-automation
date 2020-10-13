package com.cpcommunity.testScripts.loginPage;


import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.cpcommunity.utilities.*;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;

public class TC001_Verify_User_Able_Login_With_Valid_Credentials extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC001(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC001", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
//		openBrowser(data.get("browser"));
//		logInfo("Launched Browser : "+data.get("browser"));		
//		HomePage home = new HomePage().open();
//		LoginPage login = home.clickOnLOGINBtn();
//		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
//		login.loginToApplication(data.get("email"), data.get("password"));
				
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC001 Test Completed");
		
		quit();
		
	}

	
	

}
