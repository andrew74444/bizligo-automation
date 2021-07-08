package com.cpcommunity.ProfileCompleteness;

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



public class TC990_Verify_Profileprogress_whenDeleteDetails extends BaseTest{

	String TCID ="TC990";
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC990(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC990", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
		
		MyProfilePage MyProfile_Page = myCommunity.goToMyProfilePage();
		int intialProgressPercent = MyProfile_Page.currentProfilePercent();
		
		MyProfile_Page.DeleteProfileDetails();
		int finalProgressPercent = MyProfile_Page.currentProfilePercent();
		boolean expected=MyProfile_Page.validate_Progress(intialProgressPercent,finalProgressPercent);
		Assert.assertEquals(false, expected);
		//MyProfile_Page.validate_progress(diff);
		
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC990 Test Completed");
		
		quit();
		
	}
}
