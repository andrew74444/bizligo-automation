package com.cpcommunity.testScripts.loginPage;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.utilities.*;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
/**
 * 
 * @author Sasi Vinod Akula
 */
public class TC005_Verify_Alert_Displayed_To_Suspened_User extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC005(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC005", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		//logInfo("Launched Browser : "+data.get("browser"));		
		//logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		//logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		login.suspended(data.get("email"), data.get("password"));
				
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC005 Test Completed");
		
		quit();
		
	}
}
