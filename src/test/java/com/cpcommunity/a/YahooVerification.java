package com.cpcommunity.a;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.ForgotPasswordPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class YahooVerification extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC3002(Hashtable<String,String> data) throws Exception {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3002", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		
     	ForgotPasswordPage pass=login.clickOnForgotpassword();
     	pass.SendForgotPasswordEmail("yogesh.bhor141@yahoo.com");
     	
    	Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email"), data.get("password"));
		
	//	yahoo.reset();
	
     	
     	
     	
}
}