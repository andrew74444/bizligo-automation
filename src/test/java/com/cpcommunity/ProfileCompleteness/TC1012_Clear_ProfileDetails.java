package com.cpcommunity.ProfileCompleteness;

import java.util.Hashtable;

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

import junit.framework.Assert;

public class TC1012_Clear_ProfileDetails extends BaseTest{

	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1012(Hashtable<String,String> data) throws Exception {
 
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1012", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		//MyProfilePage myprofile = login.loginToMyProfilePage(data.get("email"), data.get("password"));
		MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
		MyProfilePage myProfile =  myCommunity.goToMyProfilePage();
		int prevProgress = myProfile.GetProfileProgress();
		myProfile.ClearProfileDetails(data.get("FirstName"),data.get("LastName"),data.get("JobTitle"),data.get("PhoneNumber"),data.get("PhoneExt"),data.get("ProfessionalSummary"), data.get("Youtube"),data.get("Linkedln"),data.get("Facebook"),data.get("Twitter"));
		int afterProgress = myProfile.GetProfileProgress();
		logInfo("Before Progress : " + prevProgress + ", After Progress : " + afterProgress);
		boolean val=myProfile.CompareProgressBars(prevProgress,afterProgress);
		//myProfile.Validate_progress_ToClearDetails(val);
		Assert.assertEquals(false, val);
		
}
	
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC001 Test Completed");
		
		quit();
		
	}
	
}