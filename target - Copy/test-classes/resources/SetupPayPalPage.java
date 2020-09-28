package com.w2a.zoho.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.wait.WaitHelper;

public class SetupPayPalPage extends BasePage{
	
	
	@Override
	protected  void getPageScreenSot() {
		aShot();
	}
	
	
	
	@FindBy(xpath="//h2[contains(.,'- PayPal')]")
	WebElement SetupPayPalHeader;
	
	
	@FindBy(xpath="//div[@class='user-text']")
	WebElement usertext;
	
//	@FindBy(xpath="//*[@id='email_create']")
//	WebElement registrationEmailAddress;
//	
//	@FindBy(xpath="//*[@id='SubmitCreate']")
//	WebElement createAnAccount;
//	@FindBy(xpath="//li[contains(text(),'Invalid login credentials. Please try again')]")
//	WebElement Invalidlogin;
	
//	@FindBy(xpath="//*[@id='center_column']/h1")
//	WebElement authenticate;
//	
//	@FindBy(xpath="//*[@id='create-account_form']/div/p")
//	WebElement createAnAccountMessage;
	
	 @FindBy(xpath = "//input[@value='false']")
	    WebElement UseSandboxCheckBox;
	 
	 @FindBy(xpath = "//input[@name='txtAPIUsername']")
	    WebElement txtAPIUsername;
	 @FindBy(xpath = "//input[@name='txtAPIPassword']")
	    WebElement txtAPIPassword;
	 
	 @FindBy(xpath = "//input[@name='txtAPISignature']")
	    WebElement txtAPISignature;	
	 
	 @FindBy(xpath = "//button[contains(.,'Validate')]")
	    WebElement ValidateBtn;
	 
	 @FindBy(xpath = "//button[contains(.,'Ok')]")
	    WebElement OkBtn;
	 
	 
	 @FindBy(xpath = "//label[@class='btn btn-success toggle-on']")
	    WebElement toggleOn;
	 
	 @FindBy(xpath = "//label[@class='btn btn-danger active toggle-off']")
	    WebElement toggleOff;
	 
	 @FindBy(xpath = "//*[contains(text(),'Update')]")
	    WebElement Update;	

	
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(SetupPayPalHeader);
	}

	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	public void SelectCheckBox()
	 {
		 String CheckBoxSelected = UseSandboxCheckBox.getAttribute("value");
		 if(CheckBoxSelected.equalsIgnoreCase("false"))
		 {
			 UseSandboxCheckBox.click();
		 } 
	 }
	 
	
	
	public PayPalPayment SetUpPayPalPaymentGateway(String APIUsername, String APIPassword, String APISignature) throws Exception
	{
		 this.SelectCheckBox();
		 txtAPIUsername.clear();
		 txtAPIUsername.sendKeys(APIUsername);
		 txtAPIPassword.clear();
		 txtAPIPassword.sendKeys(APIPassword);
		 txtAPISignature.clear();
		 txtAPISignature.sendKeys(APISignature);
		 Thread.sleep(1000);
		 ValidateBtn.click();
		 waitForElementToPresent(OkBtn);
		 OkBtn.click();	
		 return (PayPalPayment) openPage(PayPalPayment.class);
//				 new PayPalGateway(driver, );
	}
	
	
	
	public PaymentGatewaysPage inActiavtePayPalPaymentGateway()
	{
		toggleOn.click();
		Update.click();
		waitForElementToPresent(OkBtn);
		OkBtn.click();
		 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//				 new PaymentGatewaysPage(driver, );
	}
	
	
	public PaymentGatewaysPage ActiavtePayPalPaymentGateway() {
		toggleOff.click();
		Update.click();
		waitForElementToPresent(OkBtn);
		OkBtn.click();
		 return (PaymentGatewaysPage) openPage(PaymentGatewaysPage.class);
//				 new PaymentGatewaysPage(driver, );
		
	}
	
	public Invalidaccountdetailspage invalidErrorPage(String APIUsername, String APIPassword, String APISignature) throws InterruptedException
	{
		 this.SelectCheckBox();
		 txtAPIUsername.clear();
		 txtAPIUsername.sendKeys(APIUsername);
		 txtAPIPassword.clear();
		 txtAPIPassword.sendKeys(APIPassword);
		 txtAPISignature.clear();
		 txtAPISignature.sendKeys(APISignature);
		 Thread.sleep(500);
		 ValidateBtn.click();
		 waitForElementToPresent(OkBtn);
		 OkBtn.click();	
		return (Invalidaccountdetailspage) openPage(Invalidaccountdetailspage.class);
	}
	

	
	
	
}
