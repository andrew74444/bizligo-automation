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
//import com.uiFramework.pamTen.cpcommunity.pageObject.ProfilePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.ForgotPasswordPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.GlobalMembersPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.HomePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.LoginPage;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC015_Veirfy_Approved_Endorsment_Displayed_In_Member_Profile extends TestBase{
//	private final Logger log = LoggerHelper.getLogger(TC015_Veirfy_Approved_Endorsment_Displayed_In_Member_Profile.class);
//	
//	String TCID="TC015";	
//	LoginPage login_Page1;
//	LoginPage login_Page;
//	HomePage Home_Page;
//	MyDashboardPage Dashboard_Page;;
//	GlobalMembersPage GlobalMembers_Page;
//	ProfilePage Profile_Page;
//	@DataProvider(name="testData")
//	public Object[] testData() {
//		Object[][] data = getEXcelData("testData.xlsx", "MasterData", "AddEndorsment");
//		return data;			
//	}
//	
//	@Test(dataProvider="testData",description= "Rejeceted Endorsment is not displayed in the memeber profile",enabled=true,groups="Accepted_Endorsment_Displayed")
//	public void Veirfy_Accepted_Endorsment_Displayed_In_Member_Profile(String LoginEMailID, String Password,String MemberName,String EndormentMessage,String runMode) throws Exception{
//		if(runMode.equalsIgnoreCase("n")){
//			throw new SkipException("Run mode for this set of data is marked N");
//		}
//		getApplicationUrl(ObjectReader.reader.getUrl());
//		Home_Page = new HomePage(driver,TCID);
//		login_Page = Home_Page.clickOnLOGINBtn();
//		
//		Dashboard_Page = login_Page.loginToApplication(LoginEMailID, Password);
//		
//		boolean status = Dashboard_Page.verifySuccessLogin();
//		
//		AssertionHelper.updateTestStatus(status);
//		
//		GlobalMembers_Page = Dashboard_Page.ClickOnGlobalMembers();
//		
//		Profile_Page = GlobalMembers_Page.NavigateToMemberProfile(MemberName);
//		status = Profile_Page.IsEndoremsnetDisplayed(EndormentMessage);
//		AssertionHelper.updateTestStatus(status);
//		
//	}
//	
//	
//	
//}
