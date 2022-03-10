package com.cpcommunity.a;

import java.util.Hashtable;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.ForgotPasswordPage;
import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ResetPasswordPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class Atest extends BaseTest{
	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",priority=1)
	public void TC001(Hashtable<String,String> data) throws Exception {
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC001", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
     	logInfo("Username entered as "+data.get("email")+" and Password entered as "+data.get("password"));
    // login.loginToApplication(data.get("email"), data.get("password"));
     	ForgotPasswordPage pass=login.clickOnForgotpassword();
     	pass.SendForgotPasswordEmail("venkatakodi7@gmail.com");

		//	actions();
     	}
     	
     	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",priority=2)
    	public void EmailVerification(Hashtable<String,String> data) throws Exception {
    	
    		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
    		DataUtil.checkExecution("master", "TC002", data.get("Runmode"), excel);
    		log.info("Launched Browser : "+data.get("password"));
    		log.info("Launched Browser : "+data.get("email"));
    	
    	
    		Gmail gmail= new Gmail().open("https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    
    	
    		gmail.Login(data.get("email"), data.get("password"));
    	
    		 gmail.reset();
    		 
    		 
    		 
	}



}
