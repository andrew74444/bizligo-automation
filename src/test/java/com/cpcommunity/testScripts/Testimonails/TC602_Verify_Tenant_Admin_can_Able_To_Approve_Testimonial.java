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


public class TC602_Verify_Tenant_Admin_can_Able_To_Approve_Testimonial extends BaseTest
{
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC602(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC602", data.get("Runmode"), excel);
		log.info("Inside Login Test");
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
		SystemAdminDashboardPage SA = login.SystemAdminloginToApplication(data.get("email"), data.get("password"));
		SATestimonials Edit= SA.navigatetoTestimonials();
		Edit.searchTestimonial(data.get("search"));
		Edit.approveTestimonial(data.get("notes"));
		HomePage home1 = new HomePage().open(data.get("tenantType"));
		LoginPage login1 = home.clickOnLOGINBtn();
		MyDashboardPage dashboard = login1.loginToMemberdashboard(data.get("email1"),data.get("password1"));
		//dashboard.navigateToMyDashBoard();
		TestimonialsVerifyPage testimonial1 = dashboard.NavigateTotestimonials();
		testimonial1.TestimonialisVisible(data.get("actual"));
	

		
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

