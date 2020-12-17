package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;




public class PayPalMerchant extends BasePage{
	
	
	@Override
	protected  void getPageScreenSot() {
	

		aShot();

	}
	
	
	@FindBy(xpath="//input[@name='login_email']")
	WebElement EmailID;
	@FindBy(xpath="//input[@name='login_password']")
	WebElement PayPalPWd;
	@FindBy(xpath="//input[@value='Log In'] | //button[@id='btnLogin']")
	WebElement LoginBtn;
//	@FindBy(xpath="//button[@id='btnLogin']")
//	WebElement btnLogin;
	
	
	@FindBy(xpath="//input[@value='Log In'] | //button[@id='btnLogin']")
	WebElement btnLogin;
	                
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueBtn;
	@FindBy(xpath = "//input[@value='1']")
	WebElement PayPalRadioBtn;
	@FindBy(xpath = "//input[@value='2']")
	WebElement AuthorizedRadioBtn;
	@FindBy(xpath="//input[@id='privateDeviceCheckbox']")
	WebElement CheckBox;
	@FindBy(xpath="//*/tbody/tr[2]/td[4]")
	WebElement PaidAmount;
	
	@FindBy(xpath="//*/tbody/tr[1]/td[2]")
	WebElement FirstRow;
	@FindBy(xpath="//*/tbody/tr/td[4]/span/span/span[2]/a")
	WebElement TrasactionNumber;
	
	@FindBy(xpath="//a[contains(.,'Log Out')]")
	WebElement Logout;
	
	@FindBy(xpath="//a[contains(.,'Log in to Dashboard')]")
	WebElement LoginIntoDashboard;
	
	
	@FindBy(xpath="//*[@id='btnNext']")
	WebElement btnNext;
	
	@FindBy(xpath="//button[contains(.,'Search for notifications')]")
	WebElement btnSearchNotifications;
	
	
	
	
//	@Override
//	protected ExpectedCondition getPageLoadCondition() {
//		// TODO Auto-generated method stub
//		return ExpectedConditions.visibilityOf(crm);
//	}

	public void Login(String PEmail, String PPwd ) throws Exception
	{	
		waitForElementToPresent(EmailID);
		  EmailID.clear();
		  type(EmailID, PEmail, "EmailID");
		  
		  
		  if(PEmail.equalsIgnoreCase("andrew74444@gmail.com"))
		  {
			  click(btnNext,"btnNext");
			  Thread.sleep(3000);
		  }

		  type(PayPalPWd,PPwd,"PayPalPWd");
		  picture();
//		  new TestBase().captureScreen(, driver);
		  
		  if(PEmail.equalsIgnoreCase("ObjectReader.reader.MerchantEmailID()"))
		  {
			  click(btnLogin,"btnLogin");
			  Thread.sleep(3000);  
		  }
		  else
		  {
			  click(LoginBtn,"LoginBtn");	
		  }
		
	}	
	
	
	
	
	public String merchantLogin(String PEmail, String PPwd,String PaidAmountInPayPalGateway ) throws Exception{
		
		driver.get("https://developer.paypal.com/developer/notifications");
		waitForElementToPresent(LoginIntoDashboard);
//		new TestBase().captureScreen(, driver);
		picture();
		String AmountPaid = null;
		String TransactionID = null;
		String parent=driver.getWindowHandle();		
				
		click(LoginIntoDashboard,"LoginIntoDashboard");				
		this.Login(PEmail, PPwd);
		picture();
//		new TestBase().captureScreen(, driver);
		while(true)
		{
			waitForElementToPresent(btnSearchNotifications);
			scrollToElement(btnSearchNotifications);			
			waitForElementToPresent(FirstRow);			
			Thread.sleep(2000);
			picture();
//			new TestBase().captureScreen(, driver);
			clickElementByJavaScript(FirstRow);
//			FirstRow.click();
			Thread.sleep(2000);			
			Set<String>s1=driver.getWindowHandles();
//			while(true){
//				if(s1.size()!=2){
//					Utility.WaitForElementToVisible(driver, FirstRow);
//					Thread.sleep(2000);
//					Notificationofpaymentreceived.click();
//					Thread.sleep(2000);
//				}else{
//					break;
//				}
//				}
			System.out.println(s1);
			System.out.println(parent);
			Iterator<String> I1= s1.iterator();
			while(I1.hasNext())
			{
				String child_window=I1.next();
				if(!parent.equals(child_window))
					{
					driver.switchTo().window(child_window);
					Thread.sleep(2000);			
					waitForElementToPresent(TrasactionNumber);
					TransactionID = TrasactionNumber.getText();
					AmountPaid = PaidAmount.getText();
					picture();
//					new TestBase().captureScreen(, driver);
					driver.close();					
					driver.switchTo().window(parent);					
					}		
			}			
			AmountPaid = AmountPaid.replace("$","");
			AmountPaid = AmountPaid.replace(" USD","");	
			System.out.println(PaidAmountInPayPalGateway.trim());
			
			System.out.println(AmountPaid);
			if(PaidAmountInPayPalGateway.trim().equals(AmountPaid)) 
			{					
				break;
			}		
			else 
			{								
				String PayPalUrl= driver.getCurrentUrl();
				Thread.sleep(1000);
				driver.get(PayPalUrl);
			}	
		}
		
		
//		JavascriptExecutor js=(JavascriptExecutor)driver; 
//		js.executeScript("window.open();");
		TransactionID = TransactionID.replace("Transaction ID: ","");
		String X = TransactionID;
		
		//Utility.CloseTab(driver);
		
		//driver.getTitle();
		return X;
		
	}
	
	public PaymentConfirmation confirmation () {
		
		return (PaymentConfirmation) openPage(PaymentConfirmation.class);
	}
	
	
	public PaymentReceipt Payment (String PEmail, String PPwd) throws Exception {
		this.PayPalpayment(PEmail, PPwd);
		return (PaymentReceipt) openPage(PaymentReceipt.class);
	}
	

	
	public String PayPalpayment(String PEmail, String PPwd) throws Exception
	
	{
		
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		waitForElementToPresent(driver.findElement(By.className("baslLoginButtonContainer")));
		
		String Amount = "0";
//		try
//		{
//			this.Login(PEmail, PPwd);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
//			
//			clickElementByJavaScript(ContinueBtn);
//			
//			Thread.sleep(10000);
//		 }
//		catch(Exception e)
//		{
//			System.out.println("New Form Displayed Completed");
//		}
		try{
			List <WebElement> list = driver.findElements(By.tagName("a"));
			//System.out.println("Number of links: "+list.size());
			for(int i = 0; i < list.size(); i++)
				{
				// System.out.println(list.get(i).getText());
				//eligible purchases
				//Thread.sleep(15000);
				if(list.get(i).getText().equals("Log In"))
					{
					//System.out.println(list.get(i).getText());
					Amount = driver.findElement(By.xpath(".//*[@id='transactionCart']/span[2]/format-currency/span")).getText();
					
					Amount = Amount.replace("$","");
					Amount = Amount.replace(" USD","");
					
					driver.findElement(By.className("baslLoginButtonContainer")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));
					type(EmailID,PEmail,"EmailID");
					click(driver.findElement(By.xpath("//button[@type='submit']")),"submit");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnLogin']")));
					Thread.sleep(5000);
					type(PayPalPWd,PPwd,"PayPalPWd");
					click(driver.findElement(By.xpath("//button[@id='btnLogin']")),"btnLogin");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
					Thread.sleep(15000);
					click(driver.findElement(By.xpath("//input[@type='submit']")),"submit");
					Thread.sleep(5000);
					System.out.println(Amount);
					return Amount;
					
					}
				
				  else 
					  if(list.get(i).getText().equals("Use phone number instead"))
					  {
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='login_email']")));
							 type(EmailID,PEmail,"EmailID");
							 click(driver.findElement(By.xpath("//button[@type='submit']")),"submit");
							 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btnLogin']")));
							 Thread.sleep(5000);
							 type(PayPalPWd,PPwd,"PayPalPWd");
							 click(driver.findElement(By.xpath("//button[@id='btnLogin']")),"btnLogin");
							 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
							 Thread.sleep(20000);
							 Amount = driver.findElement(By.xpath(".//*[@id='transactionCart']/span[2]/format-currency/span")).getText();
								
								Amount = Amount.replace("$","");
								Amount = Amount.replace(" USD","");
							 click(driver.findElement(By.xpath("//input[@type='submit']")),"submit");
							 Thread.sleep(10000);
							 System.out.println(Amount);
							 return Amount;
						
					  }
				}
		}
		catch(Exception e)
		{
			System.out.println("Old Form displayed");
		}
		return Amount;
			
				
	}
	
	public EventTicketPage MakePayment() throws Exception{
		this.PayPalpayment("andrew74444@gmail.com", "Admin@123");		
		return (EventTicketPage) openPage(EventTicketPage.class);
//				new EventTicket(driver, );
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		driver.get("https://developer.paypal.com/developer/notifications");
		return ExpectedConditions.visibilityOf(LoginIntoDashboard);
	}
	
	
//	public ZohoCRMPage gotoCRM() {
//		
//		click(crm,"CRM Link");
//		return () openPage(.class);
//	}
//	
//	return (ZohoCRMPage) openPage(ZohoCRMPage.class);
	
	
}
