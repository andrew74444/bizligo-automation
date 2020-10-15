package com.cpcommunity.testScripts.community;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.PageObjects.*;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

public class TC117_Send_Connection_From_Member_Directory extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC117(Hashtable<String,String> data) throws Exception {
		String TCID="TC117";
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC117", data.get("Runmode"), excel);
		
		log.info("Inside Login Test");
		log.info(data.get("browser"));
		System.out.println(data.get("browser"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open();
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		GlobalMembersPage GlobalMembersPage = EcoSystemPage.goToMembersPage();
		GlobalMembersPage.sendconnection();
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("TC117 Test Completed");
		
		quit();
		
	}

}
