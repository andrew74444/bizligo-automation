package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.AdminPage;
import com.cpcommunity.PageObjects.BlogsPage;
import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.SuperAdminFeatureConfigurationPage;
import com.cpcommunity.PageObjects.superAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC611_Verify_Super_Admin_Inactive_The_Blogs_Feature extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC611(Hashtable<String,String> data) throws Throwable {


		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC611", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
//		AdminHomePage home = new AdminHomePage().open("https://admin.ezysubscribe.com/account/login");
//		AdminLogin login =home.navigateToAdminLogin();
//		AdminPage admin = login.adminloginToApplication(data.get("email"), data.get("password"));
//		admin.blogsdisabled();
		AdminHomePage home= new AdminHomePage().open("https://admin.bizligotest.com");
		AdminLogin login=home.navigateToAdminLogin();
		superAdminDashboardPage SADP=login.superAdminloginToApplication(data.get("email"), data.get("password"));
		SuperAdminFeatureConfigurationPage SAFC=SADP.goToFeatureConfigurationsPage();
		SAFC.disablefeature(data.get("feature"));
		
	//	SAFC.enablefeature(data.get("feature"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
	//	MyDashboardPage dashboard = login1.loginToMemberdashboard(data.get("email1"),data.get("password1"));
		 EcoSystemPage EcoSystemPage = login1.loginToApplication(data.get("email1"), data.get("password1"));
			EcoSystemPage.blogPageIsNotWorking();
		
		
		
		
		
		
	
		
		//blogs.AddnewPost(data.get("title"), data.get("shortdescription"), data.get("description"));
		
		
	
		//testimonialsPage.SubmitTestimonials(TestimonialTitle, Description);
		
//		myDashboardPage.goToTestimonial();
		
		//Assert.fail("Failing the login test");
	}


	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}

