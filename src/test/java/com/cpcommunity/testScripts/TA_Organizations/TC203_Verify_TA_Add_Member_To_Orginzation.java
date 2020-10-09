package com.cpcommunity.testScripts.TA_Organizations;


import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC203_Verify_TA_Add_Member_To_Orginzation extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC203(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC203", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		log.info(data);
		logInfo("Launched Browser : "+data.get("browser"));		
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		SystemAdminDashboardPage sa = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		OrganizationsPage op = sa.goToOrganizationsPage();
		op.addMember(data.get("companyNameSearch"), data.get("firstName"), data.get("lastName"), data.get("username"), data.get("password"), data.get("confirmpassword"), data.get("location"), data.get("isContactPrimary"));
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

	
	

}
