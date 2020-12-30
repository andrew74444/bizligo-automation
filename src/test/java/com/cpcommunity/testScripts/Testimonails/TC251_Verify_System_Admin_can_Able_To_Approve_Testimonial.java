package com.cpcommunity.testScripts.Testimonails;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.SATestimonials;
import com.cpcommunity.PageObjects.SystemAdminDashboardPage;
import com.cpcommunity.PageObjects.TestimonialsPage;
import com.cpcommunity.PageObjects.TestimonialsVerifyPage;
import com.cpcommunity.testScripts.community.BaseTest;

import com.cpcommunity.utilities.*;


public class TC251_Verify_System_Admin_can_Able_To_Approve_Testimonial extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC251(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC251", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open("https://multi1.ezysubscribe.com/account/login");
		LoginPage login = home.clickOnLOGINBtn();
		SystemAdminDashboardPage SA = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		SATestimonials Edit= SA.navigatetoTestimonials();
		Edit.searchTestimonial(data.get("search"));
		Edit.approveTestimonial(data.get("notes"));
		HomePage home1 = new HomePage().open("https://multi1.ezysubscribe.com/account/login");
		LoginPage login1 = home.clickOnLOGINBtn();
		MyDashboardPage dashboard = login1.loginToMemberdashboard(data.get("email"),data.get("password"));
		dashboard.navigateToMyDashBoard();
		TestimonialsVerifyPage testimonial1 = dashboard.NavigateTotestimonials();
		testimonial1.TestimonialisVisible(data.get("actual"));
		
		
		
		
		
	
		
		
		
		
		
		
	
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

