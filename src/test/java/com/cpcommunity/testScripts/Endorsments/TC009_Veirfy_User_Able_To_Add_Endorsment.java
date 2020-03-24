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
//import com.uiFramework.pamTen.cpcommunity.pageObject.EndorsementPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.GlobalMembersPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.Gmail;
//import com.uiFramework.pamTen.cpcommunity.pageObject.HomePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.LoginPage;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC009_Veirfy_User_Able_To_Add_Endorsment extends TestBase{
//	private final Logger log = LoggerHelper.getLogger(TC009_Veirfy_User_Able_To_Add_Endorsment.class);
//	
//	HomePage Home_Page;
//	LoginPage login_Page;
//	MyDashboardPage Dashboard_Page; 
//	GlobalMembersPage GlobalMembers_Page;
//	ProfilePage Profile_Page;
//	Gmail Gmail;
//	EndorsementPage Endorsement_Page;
//	String Message;
//	String TCID="109";
//	
//	@DataProvider(name="testData")
//	public Object[] testData() {
//		Object[][] data = getEXcelData("testData.xlsx", "MasterData", "AddEndorsment");
//		return data;			
//	}
//	
//	
//	@Test(dataProvider="testData", description="TC009 Veirfy User Able To Add Endorsment",enabled=true,groups="Add_Endorsment")
//	public void Veirfy_User_Able_To_Add_Endorsment(String LoginEMailID, String Password,String MemberName,String EndormentMessage, String runMode) throws Exception{
//		
//		
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
//		
//		status = Profile_Page.AddEndorsement(EndormentMessage);		
//				
//		AssertionHelper.updateTestStatus(status);
//	}	
//	
////
////	
//	
////	
////	
//	
////	
//	
//	
//}