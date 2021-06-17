package com.cpcommunity.testScripts.loginPage;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1006_LoginWithout_Password extends BaseTest {

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1006(Hashtable<String,String> data ) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1006", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		//logInfo("Launched Browser : "+data.get("browser"));	
		//logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		//logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		log.info("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		
		/*if(data.get("password").isEmpty()) {
			System.out.println("Password is required");
		}
		if(data.get("password").length()>0 )  {
		login.loginToApplication(data.get("email"), data.get("password"));
		
		}*/
		
		Assert.assertEquals(" ", " ", "Password is Required");
	}
	
	@AfterMethod
	public void tearDown() {
		
		//logInfo("TC1005 Test Completed");
		
		quit();
		
	}
}
