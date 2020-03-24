//package com.cpcommunity.testScripts.Endorsments;
//
//import org.apache.log4j.Logger;
//import org.testng.SkipException;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
//import com.uiFramework.pamTen.cpcommunity.helper.browserConfiguration.config.ObjectReader;
//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
//import com.uiFramework.pamTen.cpcommunity.pageObject.MyDashboardPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.EndorsementPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.ForgotPasswordPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.HomePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.LoginPage;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC014_Veirfy_User_Able_To_Approve_Endorsment extends TestBase{
//	private final Logger log = LoggerHelper.getLogger(TC014_Veirfy_User_Able_To_Approve_Endorsment.class);
//	
//	
//	LoginPage login_Page1;
//	LoginPage login_Page;
//	HomePage Home_Page;
//	MyDashboardPage Dashboard_Page;
//	EndorsementPage Endorsement_Page;
//	String TCID="TC014";
//	
//	@DataProvider(name="testData3")
//	public Object[] testData3() {
//		Object[][] data = getEXcelData("testData.xlsx", "MasterData", "RejectEndorsment");
//		return data;			
//	}
//	
//	@Test(dataProvider="testData3",description= "Accept_Endorsment",enabled=true,groups="AcceptEndorsment")
//	public void Veirfy_User_Able_To_Accept_Endorsment(String LoginEMailID, String Password,String runMode) throws Exception{
//		if(runMode.equalsIgnoreCase("n")){
//			throw new SkipException("Run mode for this set of data is marked N");
//		}
//		getApplicationUrl(ObjectReader.reader.getUrl());
//		Home_Page = new HomePage(driver,TCID);
//		login_Page = Home_Page.clickOnLOGINBtn();
//		
//		Dashboard_Page = login_Page.loginToApplication(LoginEMailID, Password);
//		
//		Endorsement_Page = Dashboard_Page.NaviagtingToMyEndorsements();
//		
//		Endorsement_Page.Approve();
//		boolean status = Endorsement_Page.AcceptedToastMessage();
//		
//		AssertionHelper.updateTestStatus(status);
//
//	}	
//
//	
//		
//		
////		boolean status = login_Page1.LoginPagedisplayed();
////		
////		AssertionHelper.updateTestStatus(status);
//	}
