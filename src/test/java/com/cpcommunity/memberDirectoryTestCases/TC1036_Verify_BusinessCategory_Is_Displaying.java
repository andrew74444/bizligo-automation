package com.cpcommunity.memberDirectoryTestCases;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MemberDirectoryPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1036_Verify_BusinessCategory_Is_Displaying extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1036(Hashtable<String,String> data) throws Exception {
 //
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC1036", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+ data.get("browser"));		
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
	//	MyCommunitiesPage myCommunity = login.loginToMyCommunitiesPage(data.get("email"), data.get("password"));
		//BusinessDirectoryPage bussinessdirectory= myCommunity.gotoBusinessDirectoryPage();
	//	MemberDirectoryPage memberdirectory= myCommunity.gotoMemberDirectoryPage();
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email"), data.get("password"));
		MemberDirectoryPage memberdirectory= EcoSystemPage.gotoMemberDirectoryPage();
		memberdirectory.ClickonBusinessCategory(data.get("bussinessCategory"),data.get("BussinessCategory1"));
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1036 Test Completed");
		
		quit();
		
	}
}
