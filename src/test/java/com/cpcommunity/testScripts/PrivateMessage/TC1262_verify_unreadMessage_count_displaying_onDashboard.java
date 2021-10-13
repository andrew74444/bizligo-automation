package com.cpcommunity.testScripts.PrivateMessage;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.Messages;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1262_verify_unreadMessage_count_displaying_onDashboard extends BaseTest{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1262(Hashtable<String,String> data) throws Exception {
	//
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1262", data.get("Runmode"), excel);
	log.info("Inside Login Test");
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home1 = new HomePage().open(data.get("tenantType"));
	LoginPage login1 = home1.clickOnLOGINBtn();
	MyDashboardPage MDP=login1.loginToMemberdashboard(data.get("email1"), data.get("password1"));
	Messages msg= MDP.NavigateToMyMessages();
	msg.SendNewMessage(data.get("Name"), data.get("msg"));
    quit();
    
    openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home2 = new HomePage().open(data.get("tenantType"));
	LoginPage login2 = home2.clickOnLOGINBtn();
	MyDashboardPage MDP2=login2.loginToMemberdashboard(data.get("email"), data.get("password"));
	MDP2.checkUnreadMessagecounts();
	Messages msg2= MDP2.NavigateToMyMessages();
	msg2.checkMessage();
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1262 Test Completed");
		
		quit();
		
	}
}
