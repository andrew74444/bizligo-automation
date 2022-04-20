
package com.cpcommunity.testScripts.myprofiletestcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.ChangePasswordPage;


import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;


import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC617_Verify_Added_Member_is_Forced_to_Update_the_Password extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC617(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC617", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		//ForceChangePasswordPage Password = login.loginToChangePassword(data.get("email"), data.get("password"));
		//Password.passwordForceChanged(data.get("currentPassword"), data.get("newPassword"), data.get("confirmPassword"));
		ChangePasswordPage password = login.loginToChangePassword(data.get("email"), data.get("password"));
		password.passwordForceChanged(data.get("currentPassword"),data.get("newPassword"), data.get("confirmPassword"));
		
		
		//Assert.fail("Failing the login test");
	}

//	@AfterMethod
//	public void tearDown() {
//		
//		logInfo("Login Test Completed");
//		
//		quit();
//		
//	}

}
