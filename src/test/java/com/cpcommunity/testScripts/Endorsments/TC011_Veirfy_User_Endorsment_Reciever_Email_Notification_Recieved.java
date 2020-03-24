//package com.cpcommunity.testScripts.Endorsments;
//
//import org.apache.log4j.Logger;
//import org.testng.SkipException;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.uiFramework.pamTen.cpcommunity.helper.browserConfiguration.config.ObjectReader;
//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
//import com.uiFramework.pamTen.cpcommunity.pageObject.Gmail;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
///**
// * 
// * @author Sasi Vinod Akula
// */
//public class TC011_Veirfy_User_Endorsment_Reciever_Email_Notification_Recieved extends TestBase{
//	private final Logger log = LoggerHelper.getLogger(TC011_Veirfy_User_Endorsment_Reciever_Email_Notification_Recieved.class);
//	
//	
//String TCID = "TC011";
//	
//	Gmail Gmail;
//	@DataProvider(name="testData2")
//	public Object[] testData2() {
//		Object[][] data = getEXcelData("testData.xlsx", "MasterData", "EndorsmentRecieverEmailAcount");
//		return data;			
//	}
//	@Test(dataProvider="testData2",description= "Reciever email notification",enabled=false,groups="Reciever_Email_Notification")
//	public void Veirfy_User_Endorsment_Reciever_Email_Notification(String LoginEMailID, String Password,String runMode) throws Exception{
//		if(runMode.equalsIgnoreCase("n")){
//			throw new SkipException("Run mode for this set of data is marked N");
//		}
//		
//		Gmail = new Gmail(driver,TCID);
//		Gmail.EmailLogin(LoginEMailID, Password);
//		String Subject = Gmail.EmailNotification("Endorsement Received from andrew thomson");
//		
//		//AssertionHelper.updateTestStatus(status);
//	}
//
//}
