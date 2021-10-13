package com.cpcommunity.testScripts.DynamicMenu;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.ManageMenuPage;
import com.cpcommunity.PageObjects.TenantAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC1251_verify_added_Menu_displaying_inAll_Pages extends BaseTest {
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC1251(Hashtable<String,String> data) throws Exception {
		
	
	ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
	DataUtil.checkExecution("master", "TC1251", data.get("Runmode"), excel);
	log.info("Inside Login Test");			
	openBrowser(data.get("browser"));
	logInfo("Launched Browser : "+ data.get("browser"));		
	logInfo("BizLigo Application Opened");
	HomePage home = new HomePage().open(data.get("tenantType"));
	LoginPage login = home.clickOnLOGINBtn();
	TenantAdminDashboardPage tadashoboard=login.loginToTADashboard(data.get("email"), data.get("password"));
    ManageMenuPage menu=tadashoboard.goToManageMenu();
    menu.AddMenu(data.get("Name"), data.get("display"), data.get("url"));
    HomePage home1= menu.goToHomePage();
    home1.checkAllPages();
    
    openBrowser(data.get("browser"));
   	logInfo("Launched Browser : "+ data.get("browser"));		
   	logInfo("BizLigo Application Opened");
   	HomePage home2 = new HomePage().open(data.get("tenantType"));
   	LoginPage login2 = home2.clickOnLOGINBtn();
   	TenantAdminDashboardPage tadashoboard2=login2.loginToTADashboard(data.get("email"), data.get("password"));
       ManageMenuPage menu2=tadashoboard2.goToManageMenu();
       menu2.InactiveMenu(data.get("Name"), data.get("display"), data.get("url"));
       
   	
    
	}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC1251 Test Completed");
		
		quit();
		
	}

}
