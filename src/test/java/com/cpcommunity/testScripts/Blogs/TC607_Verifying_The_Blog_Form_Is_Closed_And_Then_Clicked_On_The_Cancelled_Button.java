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


public class TC607_Verifying_The_Blog_Form_Is_Closed_And_Then_Clicked_On_The_Cancelled_Button extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC607(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC607", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		SystemAdminDashboardPage SA = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		BlogsBySystemAdmin blogs = SA.navigateToSystemAdminBlogs();
		CommunityBlogsPage create= blogs.navigateToCommunityBlogsPage();
		create.canceledBlog(data.get("title"), data.get("shortdescription"), data.get("content"));
	
		
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

