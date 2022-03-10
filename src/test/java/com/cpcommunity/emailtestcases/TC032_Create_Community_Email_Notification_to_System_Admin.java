
package com.cpcommunity.emailtestcases;



import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.ResetPasswordPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.ExcelReader;

/**
 * 
 * @author Sasi Vinod Akula
 */


public class TC032_Create_Community_Email_Notification_to_System_Admin extends BaseTest {
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void EmailVerification(Hashtable<String,String> data) throws Exception {
	
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC002", data.get("Runmode"), excel);
		log.info("Launched Browser : "+data.get("password"));
		log.info("Launched Browser : "+data.get("email"));
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		Gmail gmail= new Gmail().open("https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	//	https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin
		
		// https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin
		gmail.Login(data.get("email"), data.get("password"));
	//	gmail.emailNotification("Community waiting for review");
		 gmail.reset();
		
	
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("EmailVerification Test Completed");
		
//		quit();
		
	}

}
