package com.cpcommunity.testScripts.community;
//package com.cpcommunity.testcases;
//
//import org.apache.log4j.Logger;
//import org.testng.SkipException;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.uiFramework.pamTen.cpcommunity.helper.browserConfiguration.config.ObjectReader;
//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
//import com.uiFramework.pamTen.cpcommunity.pageObject.MyDashboardPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.MyProfilePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.Gmail;
//import com.uiFramework.pamTen.cpcommunity.pageObject.HomePage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.LoginPage;
//import com.uiFramework.pamTen.cpcommunity.pageObject.MyCommunitiesPage;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
///**
// * @author Sasi Vinod Akula
// */
//public class TC046_Member_Already_Joined_In_Community extends TestBase{
//	private final Logger log = LoggerHelper.getLogger(TC046_Member_Already_Joined_In_Community.class);
//
//	
//	String TCID="TC038";
//	HomePage Home_Page;
//	LoginPage login_Page;
//	MyDashboardPage Dashboard_Page; 
//	MyCommunitiesPage MyCommunitiesPage;
//	MyProfilePage MyProfile_Page;
//	Gmail gmail;
//
//	
//	@DataProvider(name="testData")
//	public Object[] testData() {
//		Object[][] data = getEXcelData("testData.xlsx", "Community", "AcceptCommunityRequestfromMycommunities");
//		return data;			
//	}
//	// ,groups="AcceptCommunityRequestfromMycommunities"
//	@Test(dataProvider="testData",enabled=false)
//	public void Member_Already_Joined_In_Community(String MemberEmailID2,String GmailPassword,String AppPassword, String CommunityName, String runMode) throws Exception{
//		if(runMode.equalsIgnoreCase("n")){
//			throw new SkipException("Run mode for this set of data is marked N");
//		}
//		getApplicationUrl(ObjectReader.reader.getUrl());
//		Home_Page = new HomePage(driver,TCID);
//		login_Page = Home_Page.clickOnLOGINBtn();		
//		Dashboard_Page = login_Page.loginToApplication(MemberEmailID2, AppPassword);
//		boolean status = Dashboard_Page.verifySuccessLogin();		
//		Dashboard_Page.verifySuccessLogin();		
//		MyCommunitiesPage = Dashboard_Page.NaviagtingToMyCommunities();
//		MyCommunitiesPage.acceptcommunity(CommunityName);
////		gmail = new Gmail(driver,TCID);
////		gmail.EmailLogin(MemberEmailID2, GmailPassword);
////		gmail.EmailNotification("Invitation to join community is accepted by you");
////		
////		status = MyProfile_Page.UnSelectPhonePrivate(PPhone);
////		AssertionHelper.updateTestStatus(status);
//		
//	}	
//}