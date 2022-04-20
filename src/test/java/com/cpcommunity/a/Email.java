package com.cpcommunity.a;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.ForgotPasswordPage;
import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.SignupPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class Email extends BaseTest {
	
	
	
 	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP",priority=2)
	public void TC3001(Hashtable<String,String> data) throws Exception {
	
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3001", data.get("Runmode"), excel);
		log.info("Launched Browser : "+data.get("password"));
		log.info("Launched Browser : "+data.get("email"));
	
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));	
		Gmail gmail= new Gmail().open("https://accounts.google.com/signin/v2/identifier?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//		https://login.yahoo.com/?.src=search&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.search.yahoo.com%2F%3Ffr2%3Dinr&pspid=2114723002&activity=header-signin);
	
		gmail.Login(data.get("email"), data.get("password"));
	
		 gmail.registMail();
		 gmail.payementMail();
		 
	
			Yahoo yahoo= new Yahoo().open();

			yahoo.Login(data.get("email3"), data.get("password3"));
			yahoo.tAdminRegsNotification();
		 
		 
}
	}
