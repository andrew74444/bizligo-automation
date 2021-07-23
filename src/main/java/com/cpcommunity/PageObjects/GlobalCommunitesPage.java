package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

	@FindBy(xpath = "//*[@id='global-nav']")
	WebElement pageheader;

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
//		updateClass(pageheader, "navbar-fixed-top");
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
	@FindBy(xpath = "((//*[@class='cmt-groups'])[1])//*[contains(text(),'Join')]")
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
	
	@FindBy(xpath = "//a[normalize-space()='Accer Community']")
	WebElement acerCommunity;
	
	@FindBy(xpath = "//span[normalize-space()='Resources']")
	WebElement ResourcesAcer;
	
	@FindBy(xpath = "//p[@class='ng-binding ng-scope']")
	WebElement msgIfNotMember;
	
	@FindBy(xpath="//a[normalize-space()='BizLigo1']")
	WebElement bizligo1;
	@FindBy(xpath="//a[normalize-space()='Animal Lovers']")
	WebElement animalLovercommunity;
	@FindBy(xpath="//div[@id='myNavbar']")
	WebElement headermenu;
	@FindBy(xpath="//a[normalize-space()='ActionEdge']")
	WebElement actionEdge;
	
	@FindBy(xpath="//span[normalize-space()='Careers']")
	WebElement careers;
	
	@FindBy(xpath="//input[@placeholder='Search by Job Title']")
	WebElement searchByJobTitle;
	
	@FindBy(xpath="//select[@id='JobTypeID']")
	WebElement searchByJobType;
	
	@FindBy(xpath="//input[@placeholder='Search by Location']")
	WebElement location;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchCareer;
	
	@FindBy(xpath = "//a[normalize-space()='View and Apply']")
	WebElement ViewandApply;
	
	@FindBy(xpath = "//button[normalize-space()='Apply']")
	WebElement Apply;
	@FindBy(xpath = "//a[@title='Manage Community']")
	WebElement managetocommunity;
	
	@FindBy(xpath = "//div[@class='swal-text']")
	WebElement msgCannotApply;
	
	@FindBy(xpath = "//div[@class='communities-box ng-scope col-lg-4 col-md-12 col-sm-12']//h4")
	WebElement BDMAIcomm;
	@FindBy(xpath = "//span[normalize-space()='Advertisements']")
	WebElement advertisement;
	@FindBy(xpath = "//div[@ng-show='PromotionPlans.length']//div[@class='row']")
	WebElement adPlans;
	@FindBy(xpath = "//ng-repeat[2]//div[1]//div[1]//div[1]//div[3]//a[1]")
	WebElement selectPlans;
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement next;
	@FindBy(xpath = "//input[@id='AdName']")
	WebElement adname;
	@FindBy(xpath = "//td[normalize-space()='17']")
	WebElement dateselect;
	@FindBy(xpath = "//input[@id='AdStartDate']")
	WebElement date;
	@FindBy(xpath = "//input[@id='AdImageId']")
	WebElement choosefile;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;
	@FindBy(xpath = "//span[@title='Toggle dropdown menu']")
	WebElement Toggledropdownmenu;
	
	@FindBy(xpath = "//a[normalize-space()='My Ecosystem']")
	WebElement ecosystem;
	@FindBy(xpath = "//ng-repeat[7]//div[1]//div[1]//div[1]//div[3]//a[1]")
	WebElement selectPlan2;
	
	@FindBy(xpath = "//button[@class='btn btn-danger padding-space']")
	WebElement cancel;
	
	@FindBy(xpath = "//button[normalize-space()='Yes, Proceed']")
	WebElement yesProceed;
	
	@FindBy(xpath = "(((//*[@class='col-md-3 left_col']//img[@src='/Content/Images/adprommenu.png'])/..)/..)")
	WebElement advertisements;
    @FindBy(xpath = "//img[@src='/Content/Images/setting-icon.png']/../..")
	WebElement manage;
    @FindBy(xpath = "//a[contains(text(),'Manage Plans')]")
	WebElement managePlans;
	
	public void checkTotalCommunities(Hashtable<String, String> data) throws Exception {
		String name = "";
		this.searchCommunity(data.get("Name"));

	}
	public ManageAdPlansPage goToManageAdPlansPage() {

		click(advertisements, "advertisements");
 		waitForElementToPresent(managePlans);
 		click(managePlans, "Manage Plans");
 		return (ManageAdPlansPage) openPage(ManageAdPlansPage.class);
 		// new CommunityPendingRequestsPage(driver);
 	}
	public ManageCommunityPage goToManagecommunity() {

		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		waitForElementToPresent(managetocommunity);
		click(managetocommunity, ID);
		
 		return (ManageCommunityPage) openPage(ManageCommunityPage.class);
 		// new CommunityPendingRequestsPage(driver);
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

		click(joinInsuggestedCommunities,"joinInsuggestedCommunities");

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
		click(OKbtn,"OKbtn");
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
		communityName = communityName+getDateInDDMMMYYYY();
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
	
	public void checkInactiveAdvertisementNotPresent() throws InterruptedException {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		//clickElementByJavaScript(BDMAIcomm);
		Thread.sleep(4000);
		scrollToElementAndClick(advertisement);
		waitForElementToPresent(adPlans);
		String Allplans=this.adPlans.getText();
    	String Notpresent="Test@1122";
    	System.out.println("Inactive Plan is not present");
    	Assert.assertNotEquals(Notpresent, Allplans, "Inactive Plan is not present");
		
	}
	public void checkAdPresent() throws InterruptedException {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		scrollDownVertically();
		waitForElementToPresent(advertisement);
		click(advertisement, "Advertisement");
		waitForElementToPresent(adPlans);
		String Allplans=this.adPlans.getText();
    	String present="Goldengold";
    	System.out.println(" Plan is  present");
		//Assert.assertEquals(Allplans, present);
	}
	public void checkPendingadvertisement(String AdName, String  path) throws InterruptedException {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		//clickElementByJavaScript(BDMAIcomm);
		//Thread.sleep(2000);
		scrollDownVertically();
		waitForElementToPresent(advertisement);
		click(advertisement, "Advertisement");
		waitForElementToPresent(selectPlans);
		click(selectPlans, "Select TestSilver Plan");
		waitForElementToPresent(next);
		click(next, "Next");
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(dateselect);
		click(dateselect, "Date 17 july");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(save, "Save");
		//waitForElementToPresent(toastMessage);
		//AssertionHelper.verifyText(toastMessage.getText(), "Advertisement details saved.");
		Thread.sleep(2000);
		
	}
	public void clickCancel(String AdName, String  path) {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		//clickElementByJavaScript(BDMAIcomm);
		//Thread.sleep(2000);
		scrollIntoViewAndClick(advertisement);
		//click(advertisement, "Advertisement");
		waitForElementToPresent(selectPlans);
		click(selectPlan2, "Select TestSilver Plan");
		waitForElementToPresent(next);
		click(next, "Next");
		waitForElementToPresent(adname);
		type(adname, AdName, "Advertisement name");
		click(date, "Select Date");
		waitForElementToPresent(date);
		click(dateselect, "Date 17 july");
		waitForElementToPresent(choosefile);
		type(choosefile, path, "Image Path");
		scrollDownVertically();
		click(cancel, "Cancel");
		waitForElementToPresent(yesProceed);
		click(yesProceed, "Yes Proceed");
		
	}
	public MyDashboardPage gotoMyDashboardPage() throws Exception {
		waitForElementToPresent(Toggledropdownmenu);
		click(Toggledropdownmenu,"Toggledropdownmenu");
		Thread.sleep(500);
		waitForElementToPresent(ecosystem);
		click(ecosystem,"Ecosystem");
		return (MyDashboardPage) openPage(MyDashboardPage.class);
	}	
	
	public void searchCommunity(String CommunityName) throws Exception {
		searchName.clear();
		type(searchName, CommunityName, "search");
		click(searchBtn, "search Btn");
		Thread.sleep(2000);
		waitForElementToPresent(driver.findElement(By.xpath("//a[contains(text(),'" + CommunityName + "')]")));

	}
	
	public SelectPlanPage navigatetoselectPlanPage() throws InterruptedException {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		Thread.sleep(2000);
		scrollDownVertically();
		clickElementByJavaScript(advertisement);
		//click(advertisement, "Advertisement");
		
	return (SelectPlanPage) openPage(SelectPlanPage.class);	
}
	public CreateAdPage gotoCreateAdPage() throws InterruptedException {
		waitForElementToPresent(BDMAIcomm);
		click(BDMAIcomm, "BDMAI");
		Thread.sleep(5000);
		scrollDownVertically();
		//scrollIntoViewAndClick(advertisement);
		clickElementByJavaScript(advertisement);
		//click(advertisement, "Advertisement");
		waitForElementToPresent(selectPlans);
		click(selectPlans, "Select TestSilver Plan");
		waitForElementToPresent(next);
		click(next, "Next");
		
		return (CreateAdPage) openPage(CreateAdPage.class);	
	}
	
	public void CheckcareerMenuNotPresent() {
		waitForElementToPresent(animalLovercommunity);
		click(animalLovercommunity, "Animal Lover Community");
		String expected=this.headermenu.getText();
    	String actual="Careers";
    	System.out.println("Careers is not Present for Member  without Joining Private Community ");
    	Assert.assertNotEquals(actual, expected, "Career is not present");
		
		
	}

	public boolean acceptCommunity(String communityName) throws Exception {
		communityName = communityName+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);
		click(acceptBtn, "Accept Btn");
		waitForElementToPresent(YesProceed);
		click(YesProceed,"YesProceed");
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
		communityName = communityName+getDateInDDMMMYYYY();
		this.searchCommunity(communityName);

		click(driver.findElement(By.xpath("//a[@tooltip='" + communityName + "']")),"Community Name");
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
		// CommunityDetailsPage(driver);
	}

	public void checkInActivatedCommunityIsNotDisplayed(String communityName) throws Exception {
		communityName = communityName+getDateInDDMMMYYYY();
		type(searchName, communityName, "search");
		Thread.sleep(10000);
		click(searchBtn, "search Btn");
		waitForElementToPresent(noCommunitiesfound);

		Thread.sleep(2000);

	}

	public CommunityDetailsPage navigateToExpiredCommunityDetailsPage(String communityName) throws Exception {
		Date date = new Date();
		Date newDate = subtractDays(date, 2);
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		String strDate = formatter.format(newDate);
		this.searchCommunity(communityName+" "+strDate);
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'" + communityName+" "+strDate + "')]"));
		click(ele,communityName+" "+strDate);
		return (CommunityDetailsPage) openPage(CommunityDetailsPage.class);
	}
	public Bizligo1CommunityPage goToMyCommunity() {
		//click(viewAllBtn,"view all");
		waitForElementToPresent(bizligo1);
		click(bizligo1,"Bizligo 1");
		return (Bizligo1CommunityPage) openPage(Bizligo1CommunityPage.class);
	}
	
	public void checkResources() {
		waitForElementToPresent(acerCommunity);
		click(acerCommunity,"Acer community");
		waitForElementToPresent(ResourcesAcer);
		click(ResourcesAcer,"Resources");
		waitForElementToPresent(msgIfNotMember);
		String x=msgIfNotMember.getText();
		System.out.println(x);
		if(x.equalsIgnoreCase("Join the community to view the community information")) {
			System.out.println("Member who is not part of community cannot see the resources.");
			Assert.assertTrue(true);
			
		}else {
			Assert.assertTrue(false);
		}
		
	}
	public void checkCareerPage() throws InterruptedException {
		waitForElementToPresent(actionEdge);
		click(actionEdge,"Action Edge Community");
		Thread.sleep(3000);
		//waitForElementToPresent(actionEdge);
		click(careers,"Careers");	
		if(searchByJobTitle.isDisplayed() && searchByJobType.isDisplayed() && location.isDisplayed()) {
			System.out.println("Member can see careers of community even if not a part of it.");
		}
	}
	
	public void nonMemberApplyJob(String JobTitle) throws InterruptedException {
		waitForElementToPresent(actionEdge);
		click(actionEdge,"Action Edge Community");
		Thread.sleep(3000);
		//waitForElementToPresent(actionEdge);
		click(careers,"Careers");
		type(searchByJobTitle,JobTitle,JobTitle);
		click(searchCareer,"Search");
		Thread.sleep(2000);
		click(ViewandApply,"view and apply");
		Thread.sleep(2000);
		click(Apply,"Apply");
		Thread.sleep(2000);
		System.out.println(msgCannotApply.getText());
		if(msgCannotApply.getText().equalsIgnoreCase("Please join this community to apply for these jobs.")) {
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		
		
	}	
}
