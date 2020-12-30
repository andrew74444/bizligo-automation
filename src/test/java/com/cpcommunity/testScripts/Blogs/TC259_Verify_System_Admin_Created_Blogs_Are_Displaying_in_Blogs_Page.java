package com.cpcommunity.testScripts.Blogs;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.BlogsPage;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.*;


public class TC259_Verify_System_Admin_Created_Blogs_Are_Displaying_in_Blogs_Page extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC259(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC259", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		//HomePage home = new HomePage().open("https://multi2.ezysubscribe.com/account/login");
		//LoginPage login = home.clickOnLOGINBtn();
		//SystemAdminDashboardPage SA = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		//BlogsBySystemAdmin blogs = SA.navigateToSystemAdminBlogs();
		//CommunityBlogsPage create= blogs.navigateToCommunityBlogsPage();
		//create.createBlog(data.get("title"), data.get("shortdescription"), data.get("content"));
		//create.logOut();
		HomePage home = new HomePage().open("https://multi1.ezysubscribe.com/account/login");
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage dashboard = login.loginToMemberdashboard(data.get("email"),data.get("password"));
		//dashboard.navigateToMyDashBoard();
		BlogsPage blog = dashboard.navigateToBlogs();
		blog.searchPostByMember(data.get("search"));
		
		
		
		
		
	
		
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

