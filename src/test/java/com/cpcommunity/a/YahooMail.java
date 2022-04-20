package com.cpcommunity.a;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.Gmail;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class YahooMail extends BaseTest {
	
	
	
 	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC3002(Hashtable<String,String> data) throws Exception {
	
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC3002", data.get("Runmode"), excel);
		log.info("Launched Browser : "+data.get("password"));
		log.info("Launched Browser : "+data.get("email"));
	
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));	
		Yahoo yahoo= new Yahoo().open();

		yahoo.Login(data.get("email"), data.get("password"));
		yahoo.planChangedMailToCA();
	
		yahoo.openAndGoToNewTab();
		
		Yahoo yahoo1= new Yahoo().open();

		yahoo1.Login(data.get("email1"), data.get("password1"));
		yahoo1.planChangedMailToTA();
	//	yahoo.emailVerfication();
		
	//	yahoo.left();
	//	yahoo.EventRegsNotification(); 
		 
}
	}


