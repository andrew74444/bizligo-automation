
package com.cpcommunity.testScripts.myprofiletestcases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyProfilePage;

import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC311_Verify_Matched_Members_Will_Not_be_Displayed_if_One_of_the_Skills_and_Interests_are_not_found extends BaseTest {

	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC311(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC311", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
//		login.login(data.get("username"), data.get("password"));
//		logInfo("Username entered as "+data.get("username")+" and Password entered as "+data.get("password"));
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MyProfilePage profile = EcoSystemPage.goToMyProfilePage();
		profile.AddInterests(data.get("AddInterest"));
		profile.AddSkills(data.get("Skills"));
		profile.logout();
		LoginPage login1 = home.clickOnLOGINBtn();
		EcoSystemPage EcoSystemPage1 = login.loginToApplication(data.get("email1"), data.get("password1"));
		MyProfilePage profile1 = EcoSystemPage1.goToMyProfilePage();
		profile.AddInterests(data.get("AddInterest1"));
		profile.AddSkills(data.get("Skills1"));
		EcoSystemPage ecosystem= profile.navigateToEcoSystemPage();
		ecosystem.myMatches(data.get("actual"));
		

		
		
		
		
		//Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
