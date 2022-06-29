package com.cpcommunity.testScripts.JobPost;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.cpcommunity.PageObjects.EcoSystemPage;
import com.cpcommunity.PageObjects.GlobalCareers;
import com.cpcommunity.PageObjects.HomePage;
import com.cpcommunity.PageObjects.LoginPage;
import com.cpcommunity.PageObjects.MyCommunitiesPage;
import com.cpcommunity.PageObjects.MyDashboardPage;
import com.cpcommunity.PageObjects.Yahoo;
import com.cpcommunity.testScripts.community.BaseTest;
import com.cpcommunity.utilities.Constants;
import com.cpcommunity.utilities.DataProviders;
import com.cpcommunity.utilities.DataUtil;
import com.cpcommunity.utilities.ExcelReader;

public class TC986_Verify_member_apply_job_successfully extends BaseTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void TC986(Hashtable<String,String> data) throws Exception {

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "TC986", data.get("Runmode"), excel);
		log.info("Inside Login Test");			
		openBrowser(data.get("browser"));
		logInfo("Launched Browser : "+data.get("browser"));
		logInfo("BizLigo Application Opened");
		HomePage home = new HomePage().open(data.get("tenantType"));
		LoginPage login = home.clickOnLOGINBtn();
	  //  MyDashboardPage MDP=login.loginToMemberdashboard(data.get("email"), data.get("password")); 
	//	GlobalCareers GCP=MDP.NavigateToGlobalCareers();
	//	GCP.applyToJob(data.get("path"));
		
		EcoSystemPage EcoSystemPage = login.loginToApplication(data.get("email3"), data.get("password3"));
		GlobalCareers GCP=	EcoSystemPage.goToGlobalCareers();
		GCP.applyToJob(data.get("jobTitle"),data.get("path"));
		
		
		Yahoo yahoo= new Yahoo().open();
//******for member received mail after applied job confirmation****\\
	//	yahoo.Login(data.get("email1"), data.get("password1"));
	//	yahoo.jobMailVerfication();
		
//*******for Community admin received mail after member apllied job confirmation checking********\\		
		yahoo.Login(data.get("email2"), data.get("password2"));
		yahoo.jobApplicationMail();
}
	@AfterMethod
	public void tearDown() {
		
		logInfo("TC986 Test Completed");
		
		quit();
		
	}
}
