package com.cpcommunity.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;


import com.cpcommunity.utilities.DriverManager;

public class Gmail extends BasePage {

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//span[contains(.,'Next')]")
	WebElement nextBtn;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//div[@class='asa'])[9]")
	WebElement RefreshBtn;

	@FindBy(xpath = "//span[contains(.,'Events')]")
	WebElement Events;
	

	@FindAll({ @FindBy(xpath = ""), @FindBy(xpath = "") })
	List<WebElement> elementsList;
	
	@FindBy(xpath = "(//*[@data-saferedirecturl])[1]")
	WebElement joinCommunity;
	
	@FindBy(xpath = "(//*[@data-saferedirecturl])[2]")
	WebElement termsandConditions;
	
	int j = 0;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		System.out.println(driver + "Gmail Login Page");
		
		
		return ExpectedConditions.visibilityOf(email);
	}

	public Gmail open(String url ) {
		
		DriverManager.getDriver().navigate().to(url);		
		System.out.println("Page Opened");
		picture();
		return (Gmail) openPage(Gmail.class);
	}

	public void Login(String email, String password) throws Exception {

		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName);
		System.out.println(browserVersion);

		// Get OS name.
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);

		waitForElementToPresent(this.email);
		type(this.email, email, "Email");
		click(nextBtn, "Next");
		waitForElementToPresent(this.password);
		type(this.password, password, "password");
		waitForElementToPresent(nextBtn);
		click(nextBtn, "Next");
		Thread.sleep(30000);
		waitForElementToPresent(RefreshBtn);
		click(RefreshBtn, "Refresh Btn");

	}

	public void emailNotification(String subject ) throws Exception {

		Thread.sleep(15000);
		while (true) {
			List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
			for (int i = 0; i < unreademeil.size(); i++) {
				if (driver.findElements(By.xpath("//span[@class='bqe']")).get(i).getText().equals(subject)) {
					click(driver.findElements(By.xpath("//*[@class='zF']")).get(i),"subject");
					Thread.sleep(5000);
					picture();
					return ;
				}
			}
			if (j == 25) {
				SoftAssert softAssertion = new SoftAssert();
				softAssertion.assertEquals(subject+" is not Recieved", subject + " Email should be Recieved");
				softAssertion.assertAll();
				picture();
				return ;
			}
			j++;
			Thread.sleep(2000);
		}
		
		
	}

	public LoginPage joinCommunity( ) throws Exception {
		waitForElementToPresent(joinCommunity);
		int t = driver.findElements(By.xpath("(//span[@style='font-family:verdana'])//*[contains(.,'Apple')]")).size();
		if(t!=1) {
			t=t*2;
			t--;
		}
		
		
		String url = target_blank(driver.findElement(By.xpath("((//*[@data-saferedirecturl]))["+t+"]")));
		driver.get(url);

		Thread.sleep(5000);

		picture();
		return (LoginPage) openPage(LoginPage.class);
	}

	
	public void verifyTC(String TC ) throws Exception {
		String GmailUrl = driver.getCurrentUrl();
		String url = target_blank(termsandConditions);
		driver.get(url);
		String xpath1 = "//*[contains(text(),'";
		String xpath2 = TC;
		String xpath3 = "')]";
		//*[contains(text(),'TC')]
		
		
		String xpath = xpath1+xpath2+xpath3;
		System.out.println(xpath);
		WebElement ele = driver.findElement(By.xpath(xpath));
		waitForElementToPresent(ele);
		AssertionHelper.verifyText(ele.getText(), TC);
		picture();
		driver.get(GmailUrl);
		
	
}

	@Override
	protected void getPageScreenSot() {

		aShot();		
	}
	
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
