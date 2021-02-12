package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.AdminHomePage;
import com.cpcommunity.PageObjects.AdminLogin;
import com.cpcommunity.PageObjects.AdminPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC612_Verify_Super_Admin_Active_The_Blogs_Feature extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC612(Hashtable<String,String> data) throws Throwable {


		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC612", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		AdminHomePage home = new AdminHomePage().open("https://admin.ezysubscribe.com/account/login");
		AdminLogin login =home.navigateToAdminLogin();
		AdminPage admin = login.adminloginToApplication(data.get("email"), data.get("password"));
		admin.blogsEnabled();
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home1.clickOnLOGINBtn();
		MyDashboardPage dashboard = login1.loginToMemberdashboard(data.get("email1"),data.get("password1"));
		dashboard.blogPageWorking();
		
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

