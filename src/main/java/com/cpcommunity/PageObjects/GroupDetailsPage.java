package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;



public class GroupDetailsPage extends BasePage {

	
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(header, "");
		aShot();
		updateClass(header, "navbar-fixed-top");
	}
	@FindBy(xpath = "//*[@id='header']")
	WebElement header;
	

	@FindBy(xpath = "(//*[@type='checkbox'])[1]")
	WebElement checkbox;

	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	WebElement Accept;

	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	WebElement Reject;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement toast;
	@FindBy(xpath = "//span[contains(text(),'Discussion')]")
	WebElement DiscussionNavbar;

	@FindBy(xpath = "//*[contains(text(),'Leave')]")
	WebElement Leave;

	@FindBy(xpath = "//*[contains(text(),'Join')]")
	WebElement Join;

	@FindBy(xpath = "//*[contains(text(),'Yes,Proceed')]")
	WebElement YesProceedBtn;

	@FindBy(xpath = "//*[contains(text(),'Ok')]")
	WebElement OkBtn;

	@FindBy(xpath = "//*[contains(text(),'Waiting for Approval')]")
	WebElement WaitingforApproval;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	@FindAll({ @FindBy(xpath = "//dir-pagination-controls//a[@class]") })
	List<WebElement> Pagination;

	@FindBy(xpath = "(//button[contains(text(),'Connect')])[1]")
	WebElement connectButton;

	@FindBy(xpath="//*[contains(text(),'Send')]")
	WebElement connectionSendbtn;
	
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopup;

	@FindBy(xpath = "//*[@class='media block-update-card img-bg']")
	WebElement MemberdisplayCard;

	@FindBy(xpath = "//*[@class='navbar mynav group-nav']//*[contains(text(),'Members')]")
	WebElement navbarMembers;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(DiscussionNavbar);
	}

	public Discussions sharePosts() throws Exception {
		
				
				
				return (Discussions) openPage(Discussions.class);
	}

	public void Join( ) {

		Join.click();
		waitForElementToPresent(YesProceedBtn);
		picture();
		YesProceedBtn.click();
		waitForElementToPresent(OkBtn);
		picture();
		OkBtn.click();
	}

	public void sendconnection( ) {

		int i = 1;

		navbarMembers.click();
		waitForElementToPresent(MemberdisplayCard);
		int totalPages=1;
//		int totalPages = Pagination.size();
		// for(int i=1;i<=totalPages;)
		while (i <= totalPages) {
			try {
				click(navbarMembers,"Nav Bar");
				waitForElementToPresent(MemberdisplayCard);
				int d = driver.findElements(By.xpath("//*[@class='media block-update-card img-bg']")).size();
				int j = 1;

				while (j <= d) {
					try {
						// new
						// JavaScriptHelper(driver).scrollToElement(driver.findElement(By.xpath("((//*[@class='media
						// block-update-card col-sm-12 img-bg']))//button")));
						driver.findElement(By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])//button"))
								.isDisplayed();
						if (j > 2 && j <= d) {
							j = j - 2;
							scrollToElement(driver.findElement(By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])")));
							break;
						} else {
							break;
						}

					} catch (Exception e) {
						if (j > 2 && j <= d) {
							j = j - 2;
							scrollToElement(driver.findElement(
									By.xpath("((//*[@class='media block-update-card img-bg'])[" + j + "])")));
							j = j + 2;
						}

						j++;
					}
				}

				// connectButton.isDisplayed();
				// clickElementByJavaScript(connectButton);
				click(connectButton, "connectButton");
				waitForElementToPresent(connectionSendbtn);
				picture();
				click(connectionSendbtn, "connection Send btn");
				Thread.sleep(2000);
				picture();
				return;
			} catch (Exception e) {

				System.out.println(i++);
				WebElement element = driver.findElement(By.xpath("(//dir-pagination-controls//a[@class])[" + i + "]"));
				element.click();
				waitForElementToPresent(MemberdisplayCard);
			}
		}
		AssertionHelper.fail();

	}

	public void LeaveDisplayed() {
		Leave.isDisplayed();
	}

	public void JoinPrivateGroup( ) throws Exception {
		this.Join();
		WaitingforApproval.isDisplayed();
		picture();
		Thread.sleep(6000);
	}

	public void JoinPublicGroup( ) {
		this.Join();
		this.LeaveDisplayed();
		picture();

	}

	public void Leave( ) {

		Leave.click();
		waitForElementToPresent(YesProceedBtn);
		picture();
		YesProceedBtn.click();
		waitForElementToPresent(OkBtn);
		picture();
		OkBtn.click();
		Join.isDisplayed();
		picture();

	}

	public void approveMember( ) throws Exception {
		Thread.sleep(5000);
		updateClass(header, "");
		clickElementByJavaScript(checkbox);
		clickElementByJavaScript(Accept);
		waitForElementToPresent(toast);
		AssertionHelper.verifyText(toast.getText(), "Selected requests Approved successfully");
		picture();
		Thread.sleep(3000);
	}

	public void rejectMember( ) throws Exception {
		Thread.sleep(5000);
		updateClass(header, "");
		clickElementByJavaScript(checkbox);
		clickElementByJavaScript(Reject);
		waitForElementToPresent(toast);
		AssertionHelper.verifyText(toast.getText(), "Selected requests Rejected successfully");
		picture();
		Thread.sleep(3000);

	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

}
