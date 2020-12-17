package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;
import com.uiFramework.pamTen.cpcommunity.helper.imagediffer.Imagediff;


public class GlobalMembersPage extends BasePage {

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}
	
	

	@FindBy(xpath = "//*[contains(text(),'Cliq')]")
	public WebElement crm;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(SearchBtn);
	}

	@FindBy(xpath = "//input[@id='membername']")
	WebElement membername;
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement companyname;
	@FindBy(xpath = "//input[@id='memberlocation']")
	WebElement memberlocation;
	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement SearchBtn;
	@FindBy(xpath = "//span[contains(.,'Pending')]")
	WebElement Pending;
	@FindBy(xpath = "//button[contains(.,'Connect')]")
	WebElement SendConnectionRequest;

	// span[contains(text(),'Pending')]
	// span[contains(text(),'Pending')]

	@FindBy(xpath = "//*[@ng-bind='member.MemberName']")
	WebElement MemberMemberName;

	// @FindBy(xpath =
	// "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/h5/span")
	// WebElement NoEdrsmnts;
	// @FindBy(xpath =
	// "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[1]")
	// WebElement FirstEdrsmnt;
	// @FindBy(xpath =
	// "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]")
	// WebElement MorethanOneEdrsmnts;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;

	@FindBy(xpath = "//span[@ng-bind='member.JobTitle']")
	WebElement JobTitle;
	@FindBy(xpath = "//div[@ng-bind='member.MemberName']")
	WebElement MemberName;
	@FindBy(xpath = "//*[@id='home']/div[1]/div/div[1]/div[3]/div[2]/div/div/div[1]/div[1]/div[2]/div[1]")
	WebElement ActualEndorsement;
	@FindBy(xpath = "//*[@id='removeinnercss']/div/div[1]/div[4]/div[3]/div/div/div[1]/div[2]/div/div[3]/span")
	WebElement GetPhoneNo;

	@FindBy(xpath = "(//a[@target='_blank'])[1]")
	WebElement targetBlank;
	@FindBy(xpath = "//button[contains(text(),'Connect')]")
	WebElement Connect;
	//
	@FindAll({ @FindBy(xpath = "//*[@class='col-lg-6 col-md-6 col-sm-6 organizations-profile-card ng-scope']") })
	List<WebElement> Members;

	@FindBy(xpath = "//*[@class='col-lg-6 col-md-6 col-sm-6 organizations-profile-card ng-scope']")
	WebElement Member;

	@FindAll({ @FindBy(xpath = "//dir-pagination-controls//a[@class]") })
	List<WebElement> Pagination;

	@FindBy(xpath = "((//*[@class='col-lg-6 col-md-6 col-sm-6 organizations-profile-card ng-scope'])//*[contains(text(),'Connect')])[1]")
	WebElement connectButton;

	
	@FindBy(xpath="(//*[@class='modal-body'])[2]")
	WebElement connectionPopUp;
	
	
	@FindBy(xpath="//button[contains(text(),'Send')]")
	WebElement connectionSendbtn;

	@FindBy(xpath="//*[@id='header']")
	WebElement header;

	@FindBy(xpath="//*[@id='PromotionsImageSlider']")
	WebElement ad;
	
	
	public void sendconnection() {

		int i = 1;

		int totalPages = Pagination.size();

		while (i <= totalPages) {

			try {
				int d = driver.findElements(By.xpath("//*[@class='media block-update-card col-sm-12 img-bg']")).size();
				int j = 1;
				while (j <= d) {
					try {
						
//						scrollToElement(driver.findElement(By.xpath("((//*[@class='media block-update-card col-sm-12 img-bg']))//button")));
						driver.findElement(By.xpath("((//*[@class='media block-update-card col-sm-12 img-bg'])[" + j + "])//button")).isDisplayed();	
						if (j > 2 && j <= d) {
							j = j - 2;
							scrollToElement(driver.findElement(By.xpath("((//*[@class='media block-update-card col-sm-12 img-bg'])[" + j + "])")));
							break;
						}
						else {
							break;
						}
						
					} catch (Exception e) {						
						if (j > 2 && j <= d) {
						j = j - 2;
						scrollToElement(driver.findElement(By.xpath("((//*[@class='media block-update-card col-sm-12 img-bg'])[" + j + "])")));
						j = j + 2;}
						
						j++;
					}					
				}
				click(connectButton, "connectButton");
				waitForElementToPresent(connectionSendbtn);
				picture();
				click(connectionSendbtn, "connection Send btn");
				Thread.sleep(2000);
				picture();
				return;
			} catch (Exception e) {
				i++;
				System.out.println(i);
				WebElement element = driver.findElement(By.xpath("(//dir-pagination-controls//a[@class])[" + i + "]"));
				scrollToElement(element);
				click(element,"pagination");
				waitForElementToPresent(Member);
				scrollToElement(SearchBtn);
			}
		}
	}

	public void SearchMemberByName(String MemberName) throws Exception {

		type(membername, MemberName, "MemberName");
	
		Thread.sleep(500);

		click(SearchBtn,"SearchBtn");
		Thread.sleep(5000);
		picture();
	}

	public ProfilePage NavigateToMemberProfile(String MemberName) throws Exception {
		this.SearchMemberByName(MemberName);

		String Url = target_blank(targetBlank);
		driver.get(Url);

		return (ProfilePage) openPage(ProfilePage.class);
		// new ProfilePage(driver, );
	}

	public void sendConnection(String MemberName ) throws Exception {
		this.SearchMemberByName(MemberName);
		click(Connect,"Connect");
		waitForElementToPresent(SuccessPopup);
		AssertionHelper.verifyText(SuccessPopup.getText(), "Connection Request has been sent Successfully.");
		picture();
	}
	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	public void verifyAdImage(String expectedImgFileName) throws Exception {
		updateClass(header,"");
		takeScreenshotByShutterBug(ad, "GlobalMembersAd");
		Imagediff.check(expectedImgFileName, "\\screenshots\\GlobalMembersAd.png");
		
	}

}
