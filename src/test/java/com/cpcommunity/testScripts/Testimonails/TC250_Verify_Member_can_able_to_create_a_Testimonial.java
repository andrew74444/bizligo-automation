package com.cpcommunity.testScripts.Testimonails;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.TestimonialsPage;
import com.cpcommunity.testScripts.community.BaseTest;

import com.cpcommunity.utilities.*;




public class TC250_Verify_Member_can_able_to_create_a_Testimonial extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC250(Hashtable<String,String> data) throws Throwable {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC250", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open("https://multi1.ezysubscribe.com/account/login");
		LoginPage login = home.clickOnLOGINBtn();
		MyDashboardPage dashboard = login.loginToMemberdashboard(data.get("email"),data.get("password"));
	    //dashboard.navigateToMyDashBoard();
	    TestimonialsPage testimonial = dashboard.naviagtingToTestimonials();
	    testimonial.SubmitTestimonials(data.get("title"), data.get("description"));
	    
		//testimonialsPage.SubmitTestimonials(TestimonialTitle, Description);
		
//		myDashboardPage.goToTestimonial();
		
		//Assert.fail("Failing the login test");
	}

	private void dashboard() {
		// TODO Auto-generated method stub
		
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}

