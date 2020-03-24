package com.cpcommunity.PageObjects;
//package com.uiFramework.pamTen.cpcommunity.pageObject;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import com.aventstack.extentreports.Status;
//import com.uiFramework.pamTen.cpcommunity.helper.assertion.VerificationHelper;
//import com.uiFramework.pamTen.cpcommunity.helper.browserConfiguration.config.ObjectReader;
//import com.uiFramework.pamTen.cpcommunity.helper.javaScript.JavaScriptHelper;
//import com.uiFramework.pamTen.cpcommunity.helper.logger.LoggerHelper;
//import com.uiFramework.pamTen.cpcommunity.helper.wait.WaitHelper;
//import com.uiFramework.pamTen.cpcommunity.testbase.TestBase;
//import com.uiFramework.pamTen.cpcommunity.utils.ClickOn;
//import com.uiFramework.pamTen.cpcommunity.utils.FieldName;
//
//
///**
// * 
// * @author Bhanu Pratap
// */
//public class InviteMembersPage{
//	
//	private WebDriver driver;
//	private final Logger log = LoggerHelper.getLogger(InviteMembersPage.class);
//	
//		
//	
//	
//	public void logout(){
//		logout.click();
//		log.info("clicked on logout link");
//		waitHelper.waitForElement(LOGINBtn, ObjectReader.reader.getExplicitWait());
//	}
//	
//	public void logExtentReport(String s1){
//		TestBase.test.log(Status.INFO, s1);
//	}
//
//}
