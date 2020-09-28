//package com.cpcommunity.PageObjects;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.apache.log4j.Logger;
//
//
//
//public class FaceBookPage extends BasePage{
//	
//		
//	@Override
//	protected  void getPageScreenSot() {
//	
//
//		aShot();
//
//	}
//	
//	
//	@FindBy(xpath="//*[@id='Facebook']")
//	WebElement FaceBookBtn;
//	@FindBy(xpath="//input[@id='email']")
//	WebElement FaceBookEmail;
//	@FindBy(xpath="//input[@id='pass']")
//	WebElement FaceBookPwd;
//	@FindBy(xpath="//button[contains(.,'Log In')]")
//	WebElement FaceBookLoginBtn;
//	@FindBy(xpath="//button[contains(.,'Cancel')]")
//	WebElement FaceBookCancel;	
//	@FindBy(xpath="//button[@name='__CONFIRM__']")
//	WebElement FaceBookConfirm;
//	
//	
//	
//	public MyDashboardPage FacebookLogin(String EMailID,String Password) throws Exception
//	{	
//		FaceBookEmail.sendKeys(EMailID);
//		FaceBookEmail.sendKeys(Password);
//		FaceBookLoginBtn.click();
//		
//		try {
//			waitForElementToPresent(FaceBookCancel);
//			FaceBookConfirm.click();	
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		Thread.sleep(3000);
//		return (MyDashboardPage) openPage(MyDashboardPage.class);
////		new MyDashboardPage(driver, TCID);		
//	}
//	
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return ExpectedConditions.visibilityOf(FaceBookEmail);
//	}
//	
////	public ZohoCRMPage gotoCRM() {
////		
////		click(crm,"CRM Link");
////		return () openPage(.class);
////	}
////	
////	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
//	
//	
//}
