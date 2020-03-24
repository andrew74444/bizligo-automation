package com.cpcommunity.emailtestcases;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.JoinUserCommunity;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

/**
 * 
 * @author Sasi Vinod Akula
 */


public class TC124_Member_Accept_Community_Request_from_EMail extends BaseTest {
	String TCID="TC124";
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void EmailVerification(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "EmailVerification", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		Gmail gmail= new Gmail().open("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");;
		gmail.Login(data.get("email12"), data.get("password3"));
		gmail.emailNotification("Community join invitation");
		gmail.verifyTC(data.get("termsAndConditons"));
		LoginPage login = gmail.joinCommunity();
		JoinUserCommunity j= login.joinUserCommunityLogin(data.get("email12"), data.get("password3"));
		j.successfullyJoinCommunity(data.get("termsAndConditons")); 
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
