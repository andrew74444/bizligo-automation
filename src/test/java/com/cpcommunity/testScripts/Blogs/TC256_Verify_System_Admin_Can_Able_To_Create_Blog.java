package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.BlogsBySystemAdmin;
import com.cpcommunity.PageObjects.CommunityBlogsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;

import com.cpcommunity.utilities.*;


public class TC256_Verify_System_Admin_Can_Able_To_Create_Blog extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC256(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC256", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open("https://multi2.ezysubscribe.com/account/login");
		LoginPage login = home.clickOnLOGINBtn();
		SystemAdminDashboardPage SA = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		BlogsBySystemAdmin blogs = SA.navigateToSystemAdminBlogs();
		CommunityBlogsPage create= blogs.navigateToCommunityBlogsPage();
		create.createBlog(data.get("title"), data.get("shortdescription"), data.get("content"));
	
		
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

