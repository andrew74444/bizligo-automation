package com.cpcommunity.testScripts.TA_Organizations;


import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC237_Verify_TA_Add_Location_To_Orginzation extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC237(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC237", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		SystemAdminDashboardPage sa = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		OrganizationsPage op = sa.goToOrganizationsPage();
		op.addLocation(data.get("companyNameSearch"), data.get("locationName"), data.get("locationType"), data.get("address"), data.get("ph"), data.get("ext"), data.get("fax"));;
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC237 Test Completed");
		
		quit();
		
	}

	
	

}
