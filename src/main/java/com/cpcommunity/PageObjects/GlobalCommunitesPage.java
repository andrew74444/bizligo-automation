package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.uiFramework.pamTen.cpcommunity.helper.assertion.AssertionHelper;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class GlobalCommunitesPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(CreateCommunityBtn);
	}

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	// public ZohoCRMPage gotoCRM() {
	//
	// click(crm,"CRM Link");
	// return () openPage(.class);
	// }
	//
	// return (ZohoCRMPage) openPage(ZohoCRMPage.class);

	@FindBy(xpath = "//button[@id='CreateCommunity']")
	WebElement CreateCommunityBtn;

	@FindBy(xpath = "//div[@class='user-text']")
	WebElement usertext;

	@FindBy(xpath = "//input[@id='searchName']")
	WebElement searchName;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-search']")
	WebElement searchBtn;
	@FindBy(xpath = "//*[contains(text(),'No Communities found')]")
	WebElement noCommunitiesfound;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-sm btn-remove']")
	WebElement rejectBtn;

	@FindBy(xpath = "//button[@class='btn btn-success btn-sm btn-remove']")
	WebElement acceptBtn;

	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;

	@FindBy(xpath = "//button[contains(.,'Yes, Proceed')]")
	WebElement YesProceed;
	@FindBy(xpath = "(//button[contains(.,'Join')])[1]")
	WebElement join;
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement Cancel;
	@FindBy(xpath = "//button[contains(.,'Leave')]")
	WebElement Leave;

	@FindBy(xpath = "(//*[@class='suggested-right']//*[contains(text(),'Join')])[1]")
	WebElement joinInsuggestedCommunities;

	@FindBy(xpath = "//*[@role='dialog']//*[@type='checkbox']")
	WebElement checkbox;

	@FindBy(xpath = "//u[contains(.,'Terms and Conditions')]")
	WebElement termsAndConditions;

	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement OKbtn;

	@FindBy(xpath = "//*[@id='swal2-content']")
	WebElement waitingForApproval;

	@FindBy(xpath = "//*[@ng-bind='data.communities.length']")
	WebElement communitiesLength;

	@FindBy(xpath = "//*[@ng-bind='data.totalrecords']")
	WebElement communitiesTotalRecords;

	@FindBy(xpath = "//*[contains(text(),'Category')]//*")
	WebElement communitiesCategory;

	public void checkTotalCommunities(Hashtable<String, String> data) throws Exception {
		String name = "";
		this.searchCommunity(data.get("Name"));

	}

	public void joinCommunitytermsandconditions(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(join, "join");

		waitForElementToPresent(YesProceed);
		click(checkbox, "check box");
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "You have Joined the Community Successfully");
		Thread.sleep(7000);

	}

	public void joinsuggestedCommunity() {

		joinInsuggestedCommunities.click();

	}

	public boolean JoinCommunities(String publicCommunity, String privateCommunity) throws Exception {

		boolean s1 = JoinPublicCommunity(publicCommunity);
		boolean s2 = JoinPrivateCommunity(privateCommunity);
		if (s1 == s2 == true) {
			return true;
		} else {
			return false;
		}

	}

	public boolean leaveCommunity(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(Leave, "Leave");
		picture();

		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "You have been removed successfully from the Community");
		picture();
		Thread.sleep(6000);
		this.searchCommunity(communityName);
		picture();
		if (join.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean leaveCommunityWithoutDate(String communityName) throws Exception {
		
		this.searchCommunity(communityName);
		click(Leave, "Leave");
		picture();

		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "You have been removed successfully from the Community");
		picture();
		Thread.sleep(6000);
		this.searchCommunity(communityName);
		picture();
		if (join.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean cancelRequest(String communityName) throws Exception {
		
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(Cancel, "Cancel");
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(toastMessage);
		AssertionHelper.verifyText(toastMessage.getText(), "Your request processed successfully");
		Thread.sleep(3000);
		if (join.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public MembershipPlansPage joinCommunityWithMembershipPlan(String communityName) throws Exception {
		this.searchCommunity(communityName + " " + getDateInDDMMMYYYY());
		this.clickOnJoin();
		return (MembershipPlansPage) openPage(MembershipPlansPage.class);
	}

	public void clickOnJoin() {
		click(join, "join");

	}
	
	
	
	public void communityJoinWithOutDate(String communityName) throws Exception {
		
		this.searchCommunity(communityName);
		this.clickOnJoin();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(OKbtn);
		// AssertionHelper.verifyText(waitingForApproval.getText(), "Your join request
		// is waiting for approval");
		OKbtn.click();
		Thread.sleep(7000);

	}
	
	public void JoinCommunity(String communityName) throws Exception {
		communityName = communityName + " " + getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		this.clickOnJoin();
		waitForElementToPresent(YesProceed);
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(OKbtn);
		// AssertionHelper.verifyText(waitingForApproval.getText(), "Your join request
		// is waiting for approval");
		OKbtn.click();
		Thread.sleep(7000);

	}

	public boolean JoinPublicCommunity(String publicCommunity) throws Exception {
		publicCommunity = publicCommunity+" "+getDateInDDMMMYYYY();
		this.searchCommunity(publicCommunity);
		picture();
		this.JoinCommunity(publicCommunity);
		this.searchCommunity(publicCommunity);
		picture();
		if (Leave.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean JoinPrivateCommunity(String privateCommunity) throws Exception {
		privateCommunity = privateCommunity+" "+getDateInDDMMMYYYY();
		this.JoinCommunity(privateCommunity);
		this.searchCommunity(privateCommunity);
		if (Cancel.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public CreateCommunityPage clickOnCreateCommunity() {
		click(CreateCommunityBtn, "CreateCommunityBtn");
		return (CreateCommunityPage) openPage(CreateCommunityPage.class);
		// new CreateCommunityPage(driver);
	}

	public boolean rejectCommunity(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(rejectBtn, "reject Btn");
		waitForElementToPresent(YesProceed);
		YesProceed.click();
		waitForElementToPresent(toastMessage);
		String Message = toastMessage.getText();
		assertEquals(Message, "Your request is successfully processed");
		waitForElementToPresent(join);

		if (Message.equalsIgnoreCase("Your request is successfully processed")) {
			return true;
		} else {
			return false;
		}
	}

	public void checkCommunityIsDisplayed(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);

	}
	
	
	
	public void searchCommunity(String CommunityName) throws Exception {
		searchName.clear();
		type(searchName, CommunityName, "search");
		click(searchBtn, "search Btn");
		Thread.sleep(2000);
		waitForElementToPresent(driver.findElement(By.xpath("//a[contains(text(),'" + CommunityName + "')]")));

	}

	public boolean acceptCommunity(String communityName) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(acceptBtn, "Accept Btn");
		waitForElementToPresent(YesProceed);
		YesProceed.click();
		picture();
		waitForElementToPresent(toastMessage);
		String Message = toastMessage.getText();
		assertEquals(Message, "Your request is successfully processed");
		picture();
		waitForElementToPresent(Leave);
		if (Message.equalsIgnoreCase("Your request is successfully processed")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean acceptCommunity(String communityName, String TC) throws Exception {
		communityName = communityName+" "+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(acceptBtn, "Accept Btn");
		String parent = driver.getWindowHandle();
		waitForElementToPresent(YesProceed);
		picture();
		termsAndConditions.click();
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
				driver.close();
				driver.switchTo().window(parent);
				checkbox.click();
			}
		}
		click(YesProceed, "Yes Proceed");
		waitForElementToPresent(toastMessage);
		String Message = toastMessage.getText();
		assertEquals(Message, "Your request is successfully processed");
		waitForElementToPresent(Leave);
		if (Message.equalsIgnoreCase("Your request is successfully processed")) {
			return true;
		} else {
			return false;
		}
	}

	public void verifyCommunityCategory(String communityName) throws Exception {

		communityName = communityName + " " + getDateInDDMMMYYYY();
		this.searchCommunity(communityName);

		String category;
		int index = stringToInt(getSystemCurrentDate());
		if (index > 25) {
			index = 26;
		}
		switch (index) {
		case 1:
			category = "Arts";
			break;
		case 2:
			category = "Beliefs";
			break;
		case 3:
			category = "Book Clubs";
			break;
		case 4:
			category = "Career & Business";
			break;
		case 5:
			category = "Dance";
			break;
		case 6:
			category = "Family";
			break;
		case 7:
			category = "Fashion & Beauty";
			break;
		case 8:
			category = "Film";
			break;
		case 9:
			category = "Food & Drink";
			break;
		case 10:
			category = "Health & Wellness";
			break;
		case 11:
			category = "Hobbies & Crafts";
			break;
		case 12:
			category = "LGBTQ";
			break;
		case 13:
			category = "Language & Culture";
			break;
		case 14:
			category = "Learning";
			break;
		case 15:
			category = "Movements";
			break;
		case 16:
			category = "Music";
			break;
		case 17:
			category = "NGO";
			break;
		case 18:
			category = "Outdoors & Adventure";
			break;
		case 19:
			category = "Pets";
			break;
		case 20:
			category = "Photography";
			break;
		case 21:
			category = "Sci-Fi & Games";
			break;
		case 22:
			category = "Social";
			break;
		case 23:
			category = "Sports & Fitness";
			break;
		case 24:
			category = "Tech";
			break;
		case 25:
			category = "Women Empowerment";
			break;
		default:
			category = "Writing";
		}

		String name = communitiesCategory.getText();
		System.out.println(name);
		AssertionHelper.verifyText(name, category);

	}

	public CommunityDetailsPage navigateToCommunityDetailsPage(String communityName) throws Exception {
		communityName = communityName + " " + getDateInDDMMMYYYY();
		this.searchCommunity(communityName);

		driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']")).click();
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
		// CommunityDetailsPage(driver);
	}

	public void checkInActivatedCommunityIsNotDisplayed(String communityName) throws Exception {
		communityName = communityName + " " + getDateInDDMMMYYYY();
		type(searchName, communityName, "search");
		click(searchBtn, "search Btn");
		waitForElementToPresent(noCommunitiesfound);

		Thread.sleep(2000);

	}

	public CommunityDetailsPage navigateToExpiredCommunityDetailsPage(String communityName) throws Exception {
		Date date = new Date();
		Date newDate = subtractDays(date, 2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(newDate);
		this.searchCommunity(communityName+" "+strDate);
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'" + communityName+" "+strDate + "')]"));
		click(ele,communityName+" "+strDate);
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}

}
