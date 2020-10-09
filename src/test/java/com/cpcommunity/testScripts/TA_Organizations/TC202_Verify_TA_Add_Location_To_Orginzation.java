package com.cpcommunity.testScripts.TA_Organizations;


import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.*;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC202_Verify_TA_Add_Location_To_Orginzation extends BaseTest {

	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC201(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC201", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
		logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
		SystemAdminDashboardPage sa = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		OrganizationsPage op = sa.goToOrganizationsPage();
		op.createOrganization(data.get("name"),data.get("noOfEmp"),data.get("description"), data.get("Categories"), data.get("Orgnizationemail"),
				data.get("phone"), data.get("extension"), data.get("fax"), data.get("membershipPlan"), data.get("companyLogoImage"));
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

	
	

}
