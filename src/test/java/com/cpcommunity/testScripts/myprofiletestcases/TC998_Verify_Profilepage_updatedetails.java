package com.cpcommunity.testScripts.myprofiletestcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyProfilePage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC998_Verify_Profilepage_updatedetails extends BaseTest{
	


	String TCID ="TC998";
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC998(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC998", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		MyCommunitiesPage MyCP = login.loginToApplicationMcp(data.get("email"), data.get("password"));
		
		MyProfilePage MyProfile_Page = MyCP.goToMyProfilePage();
		int intialProgressPercent = MyProfile_Page.currentProfilePercent();
		//MyProfile_Page.compareProgressPercentage((data.get("FName"), data.get("LName"), data.get("jtitle"), data.get("PPhone"), data.get("PExt"), data.get("PSummary"), data.get("Ytube"), data.get("LUrl"), data.get("FUrl"), data.get("TUrl"));
		
		MyProfile_Page.UpdateProfileDetails(data.get("FName"), data.get("LName"), data.get("jtitle"), data.get("PPhone"), data.get("PExt"), data.get("PSummary"), data.get("Ytube"), data.get("LUrl"), data.get("FUrl"), data.get("TUrl"));
		
		int finalProgressPercent = MyProfile_Page.currentProfilePercent();
		//MyProfile_Page.validate_ProfileProgress(intialProgressPercent,finalProgressPercent);
      // boolean diff=MyProfile_Page.validate_NoProgress(intialProgressPercent,finalProgressPercent);
      
       Assert.assertEquals(finalProgressPercent, intialProgressPercent);
		
		//MyProfile_Page.validate_progress(diff);
	
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC998 Test Completed");
		
		quit();
}
}
