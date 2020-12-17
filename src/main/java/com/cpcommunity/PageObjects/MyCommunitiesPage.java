package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

public class MyCommunitiesPage extends BasePage {

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(myCommunitiesHeader);
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	@FindBy(xpath = "//h3[@class='MyCommunitiesHeader text-uppercase']")
	WebElement myCommunitiesHeader;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearch;

	@FindBy(xpath = "//button[@id='CreateCommunity']")
	WebElement CreateCommunityBtn;

	@FindBy(xpath = "//button[contains(.,' Yes, Proceed')]")
	WebElement YesProceedBtn;
	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement SuccessPopUp;
	@FindBy(xpath = "//button[contains(.,' Leave')]")
	WebElement LeaveBtn;
	@FindBy(xpath = "//span[@title='Menu']")
	WebElement CommunityDashboardMenu;
	@FindBy(xpath = "//a[contains(.,'Manage Community')]")
	WebElement ManageCommunityLink;
	@FindBy(xpath = "//h2[contains(.,'Dashboard')]")
	WebElement DashBoard;

	@FindBy(xpath = "//a[contains(.,' Invite People')]")
	WebElement InvitePeople;
	@FindBy(xpath = "//button[@id='btnInvite']")
	WebElement btnInvite;
	@FindBy(xpath = "//input[@type='search']")
	WebElement SearchMember;
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement BtnOK;
	@FindBy(xpath = "//a[contains(.,'Invited')]")
	WebElement InvitedTab;
	@FindBy(xpath = "//input[@ng-model='data.InvitedData.CommunityName']")
	WebElement InvitedSearchcommunity;
	@FindBy(xpath = "//button[@ng-click='data.SearchInvitedCommunities()']")
	WebElement InvitedCommunitiesSearchBtn;
	@FindBy(xpath = "//button[contains(.,' Reject')]")
	WebElement RejectBtn;
	@FindBy(xpath = "//button[contains(.,'Accept')]")
	WebElement AcceptBtn;
	@FindBy(xpath = "//a[contains(.,'Joined')]")
	WebElement JoinedTab;
	@FindBy(xpath = "//a[contains(.,'Created')]")
	WebElement CreatedTab;

	@FindBy(xpath = "//input[@ng-model='data.UserCreatedData.CommunityName']")
	WebElement SearchCreatedCommunity;
	@FindBy(xpath = "//button[@ng-click='data.SearchCreatedCommunities()']")
	WebElement SearchCreatedCommunitiesBtn;
	@FindBy(xpath = "//*[contains(text(),'MANAGE')]")
	WebElement MANAGEbtn;
	@FindBy(xpath = "//button[@ng-if='!CreatedRow.Isactive && CreatedRow.CommunityUserRoleID == 1']")
	WebElement Activatebtn;
	@FindBy(xpath = "(//*[@class='btn btn-danger btn-sm btn-remove'])[1]")
	WebElement Cancel;

	@FindBy(xpath = "//a[contains(.,'Rejected')]")
	WebElement RejectedTab;
	@FindBy(xpath = "//button[contains(.,'Search')]")
	WebElement searchbtn;
	@FindBy(xpath = "//input[@placeholder='Search by Community Name']")
	WebElement SearchbyCommunityName;
	@FindBy(xpath = "//*[contains(text(),'Waiting for Review')]")
	WebElement waitingForReview;

	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;

	@FindBy(xpath = "//*[contains(text(),'PAYMENT PENDING')]")
	WebElement paymentPending;
	
	
	@FindBy(xpath = "//*[contains(text(),'No results found matching your search criteria')]")
	WebElement noresultfound;

	@FindBy(xpath = "//*[contains(text(),'Activate')]")
	WebElement Activate;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement Okbtn;

	@FindBy(xpath = "//u[contains(.,'Terms and Conditions')]")
	WebElement termsAndConditions;

	@FindBy(xpath = "//*[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//*[contains(text(),'No results found matching your search criteria')]")
	WebElement noResultsFound;

	@FindBy(xpath = "//*[contains(text(),'0')]")
	WebElement Zero;
	@FindBy(xpath = "//*[contains(text(),'COMPLETE SETUP')]")
	WebElement completeSetup;

	@FindBy(xpath = "//*[contains(text(),'Please make another member as Community Admin to remove this member as Community Admin')]")
	WebElement makeAnotherAdminAlertMeassge;

	@FindBy(xpath = "//*[@class='swal2-container swal2-center swal2-fade swal2-shown']/div")
	WebElement makeAnotherAdminAlertPopUp;

	public CreateCommunityPage clickOnCreateCommunity() {
		click(CreateCommunityBtn,"CreateCommunityBtn");
		return (CreateCommunityPage) openPage(CreateCommunityPage.class);
		// new CreateCommunityPage(driver);
	}

	public SelectPlanPage completeSetup(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		click(completeSetup, "complete Set up Community");
		return (SelectPlanPage) openPage(SelectPlanPage.class);
	}// button

	public void searchCommunity(String communityName) throws Exception {

		waitForElementToPresent(SearchbyCommunityName);
		picture();
		type(SearchbyCommunityName, communityName, "Search by Community");
		click(searchbtn, "search btn");
		Thread.sleep(6000);
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		waitForElementToPresent(ele);
		picture();

	}

	public void checkProperAlertDisplayedWhenOnlyOneAdmin(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		click(LeaveBtn, "leave");
		takeScreenshotByShutterBug(LeaveBtn, "Leave Btn");
		waitForElementToPresent(YesProceed);
		takeScreenshotByShutterBug(YesProceed, "Yes Proceed");
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(BtnOK);
		picture();
		AssertionHelper.verifyText(makeAnotherAdminAlertMeassge.getText(),
				"Please make another member as Community Admin to remove this member as Community Admin");

	}

	public boolean cancelCommunityRequest(String CommunityName) throws Exception {
		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());
		click(Cancel, "Cancel");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		waitForElementToPresent(SuccessPopUp);
		AssertionHelper.verifyText(SuccessPopUp.getText(), "Your request processed successfully");
		Thread.sleep(3000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
		if (noresultfound.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void activateCommunity(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		click(Activate,"Activate");
		picture();
		waitForElementToPresent(YesProceed);
		picture();
		click(YesProceed,"YesProceed");
		waitForElementToPresent(Okbtn);
		picture();
		click(Okbtn,"Okbtn");
		waitForElementToPresent(LeaveBtn);
		LeaveBtn.isDisplayed();
		picture();
		// picture();
		Thread.sleep(2000);

	}

	public boolean leaveCommunity(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		click(LeaveBtn,"LeaveBtn");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		Thread.sleep(5000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
		if (noresultfound.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	public boolean leaveCommunityWithName(String communityName) throws Exception {
		this.searchCommunity(communityName);
		click(LeaveBtn,"LeaveBtn");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		Thread.sleep(5000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
		if (noresultfound.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public CommunityDetailsPage navigateToCommunityDetailsPage(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		click(ele, communityName);
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
		// new CommunityDetailsPage(driver, );
	}
	
	
	
	public CommunityDetailsPage navigateToExpiredCommunityDetailsPage(String communityName, String runTime) throws Exception {
		Date date = new Date();
		
		Date newDate = subtractDays(date, 2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		String strDate = formatter.format(newDate);
		this.searchCommunity(communityName+" "+strDate);
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName+" "+strDate + "']"));
		click(ele,communityName+" "+strDate);
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}
	
	public CommunityDetailsPage navigateToCommunityDetailsPageWithoutDate(String communityName) throws Exception {
		
		this.searchCommunity(communityName);
		WebElement ele = driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']"));
		click(ele, "CommunityName");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
		// new CommunityDetailsPage(driver, );
	}

	public boolean cancelReviewCommunity(String CommunityName) throws Exception {

		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());
		Zero.isDisplayed();
		click(Cancel,"Cancel");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		waitForElementToPresent(Okbtn);
		click(Okbtn,"Okbtn");
		waitForElementToPresent(noResultsFound);
		Thread.sleep(2000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
		if (noresultfound.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void cancelJoinCommunity(String CommunityName) throws Exception {

		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());
		click(Cancel,"Cancel");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request is successfully processed");
		Thread.sleep(2000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
	}

	public boolean rejectcommunity(String CommunityName) throws Exception {

		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());
		click(RejectBtn,"RejectBtn");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request is successfully processed");
		Thread.sleep(2000);
		AssertionHelper.verifyText(noResultsFound.getText(), "No results found matching your search criteria");
		// try {
		// if (RejectBtn.isDisplayed())
		// return false;
		// } catch (Exception e) {
		// return true;
		// }

		return true;
	}

	public void acceptcommunity(String CommunityName) throws Exception {
		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());

		click(AcceptBtn,"");
		waitForElementToPresent(YesProceed);
		String parent = driver.getWindowHandle();
		picture();
		// picture();
		click(YesProceed,"YesProceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request is successfully processed");
		Thread.sleep(2000);
		waitForElementToPresent(LeaveBtn);
		picture();
		// picture();
	}

	public void acceptcommunity(String CommunityName, String TC) throws Exception {
		this.searchCommunity(CommunityName+" "+getDateInDDMMMYYYY());

		click(AcceptBtn,"AcceptBtn");
		waitForElementToPresent(YesProceed);
		String parent = driver.getWindowHandle();
		picture();
		// picture();
		click(termsAndConditions,"termsAndConditions");
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> I1 = s1.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				Thread.sleep(2000);
				WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + TC + "')]"));
				waitForElementToPresent(ele);
				AssertionHelper.verifyText(ele.getText(), TC);
				picture();
				// picture();
				driver.close();
				driver.switchTo().window(parent);
				click(checkbox,"");
			}
		}
		click(YesProceed,"YesProceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request is successfully processed");
		Thread.sleep(2000);
		waitForElementToPresent(LeaveBtn);
		// picture();
		picture();
	}

	public CommunityDashboardPage gotoManageCommunity(String communityName) throws Exception {

		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		click(MANAGEbtn, "Manage");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		// new CommunityDashboardPage(driver, );
	}
	public CommunityDashboardPage goToManageCommunity(String communityName) throws Exception {

		this.searchCommunity(communityName);
		click(MANAGEbtn, "Manage");
		return (CommunityDashboardPage) openPage(CommunityDashboardPage.class);
		// new CommunityDashboardPage(driver, );
	}
	public void verifyWaitForReviewIsDisplayed(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		waitingForReview.isDisplayed();		
	}

	public void verifyRejectCommunityIsNotDisplayedInMyCommunities(String communityName) throws Exception {
		waitForElementToPresent(SearchbyCommunityName);
		type(SearchbyCommunityName, communityName, "Search by Community");
		click(searchbtn, "search btn");
		Thread.sleep(3000);
		noresultfound.isDisplayed();
		picture();	
	}

	@FindBy(xpath = "(//*[contains(text(),'Showing 1 to')]//*)[1]")
	WebElement displayingCards;
	@FindBy(xpath="(//*[contains(text(),'Showing 1 to')]//*)[2]")
	WebElement TotalDisplayingCards;
	
	public String getTotalCommunities() {
		
		
		return TotalDisplayingCards.getText();
	}

	public void verifyPaymentPendindDisplayed(String communityName) throws Exception {
		this.searchCommunity(communityName+" "+getDateInDDMMMYYYY());
		waitForElementToPresent(paymentPending);
		paymentPending.isDisplayed();
		
	}

}
