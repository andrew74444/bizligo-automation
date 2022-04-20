package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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
	@FindBy(xpath = "//div[@id='myNavbar']")
	WebElement header;
	
	@FindBy(xpath = "(//*[@type='checkbox'])[1]")
	WebElement checkbox;

	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	WebElement Accept;

	@FindBy(xpath = "//button[contains(text(),'Reject')]")
	WebElement Reject;

	@FindBy(xpath = "//*[@id='toast-container']/div/div[3]")
	WebElement toast;
//	@FindBy(xpath = "//strong[normalize-space()='Discussions']")
	@FindBy(xpath = "//*[@ui-sref='group.discussions']/*[text()='Discussions']")//added on 13/04
	WebElement DiscussionNavbar;

	@FindBy(xpath = "//*[contains(text(),'Leave')]")
	WebElement Leave;

	@FindBy(xpath = "//*[contains(text(),'Join')]")
	WebElement Join;

	@FindBy(xpath = "//*[contains(text(),'Yes,Proceed')]")
	WebElement YesProceedBtn;

//	@FindBy(xpath = "//button[@class='btn btn-primary'][normalize-space()='OK']")
	@FindBy(xpath = "//*[@class='modal-footer']/*[text()='Ok']")//added on 13/04
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
	
	@FindBy(xpath = "//button[normalize-space()='Create New Post']")
	WebElement newPostBtn;
	
	@FindBy(xpath = "//input[@id='discussionTitle']")
	WebElement discussionTitle;
	
	@FindBy(xpath = "//div[@id='copsDisable']")
	WebElement taggedmember;
	
	@FindBy(xpath = "//button[@id='validatePostbtn']")
	WebElement postBtn;
	
	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	
	@FindBy(xpath = "//div[@id='copsDisable']")
	WebElement tagMembers;
	 
	@FindBy(xpath = "(//span[@title='Menu'])[1]")
	WebElement GroupdiscussionMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement groupeditPost;
	
	@FindBy(xpath = "(//button[normalize-space()='Update'])[1]")
	WebElement updategroupPostBtn;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessage;
	
	@FindBy(xpath = "(//a[@href='javascript:;'][normalize-space()='Delete'])[1]")
	WebElement deletegrouppost;
	
	@FindBy(xpath = "(//span[contains(text(),'Unsubscribe')])[1]")
	WebElement unsubscribeBtn;
	
	@FindBy(xpath = "(//span[contains(text(),'Subscribe')])[1]")
	WebElement subscribeBtn;
	
	
	@FindBy(xpath = "//*[@ng-bind='data.GroupMemberInfoinitialData.Name']")
	WebElement name;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		waitForElementToPresent(name);//added on 13/04
		return ExpectedConditions.visibilityOf(DiscussionNavbar);
	}

	public Discussions sharePosts() throws Exception {
		
						
				return (Discussions) openPage(Discussions.class);
	}

	
	public Discussions postDiscussions(String discussionTitle, String postContent,String tagMember) throws InterruptedException 
	{
		//click(discussion, "discussion");
		//Thread.sleep(10000);
		click(newPostBtn, "CreatePost");
		Thread.sleep(20000);
		type(this.discussionTitle, discussionTitle, "discussions");
		Thread.sleep(10000);
		switchToFrameByID(0);
		type(enterTextInframe,postContent,"TestContent");
		switchTodefaultContent();
		Thread.sleep(5000);
		type(this.tagMembers, tagMember, "TaggingMembers");
		click(taggedmember, tagMember);
		Thread.sleep(5000);
		click(postBtn, "postButton");
		Thread.sleep(5000);
		return (Discussions) openPage(Discussions.class);
	}
	
	public void UnsubscribeGroupdiscussion() throws InterruptedException 
	{
	click(unsubscribeBtn, "unsubscribeBtn");
	Thread.sleep(2000);
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Success!Unsubscribed. You will no longer receive notifications for this post");
	Thread.sleep(7000);
	}
	
	public void SubscribeGroupdiscussion() throws InterruptedException 
	{
	click(unsubscribeBtn, "unsubscribeBtn");
	Thread.sleep(2000);
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Success!Unsubscribed. You will no longer receive notifications for this post");
	Thread.sleep(7000);
	click(subscribeBtn, "subscribeBtn");
	Thread.sleep(2000);
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Success! You will receive notifications if any user adds the comment");
	Thread.sleep(7000);
	
	}
	
	
	
	
	public void editgroupdiscussion(String editpostContent) throws InterruptedException 
	{
	click(GroupdiscussionMenu, "GroupdiscussionMenu");
	Thread.sleep(10000);
	click(groupeditPost, "editPost");
	Thread.sleep(20000);	
	//type(this.discussionTitle, discussionTitle, "discussions");
	//Thread.sleep(10000);
	switchToFrameByID(0);
	type(enterTextInframe,editpostContent,"TestContent");
	switchTodefaultContent();
	Thread.sleep(5000);
	click(updategroupPostBtn, "updatePostBtn");
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Post Updated Successfully");
	Thread.sleep(7000);
		}
	
	public void deletegroupdiscussion() throws InterruptedException 
	{
	click(GroupdiscussionMenu, "GroupdiscussionMenu");
	Thread.sleep(10000);
	click(deletegrouppost, "deletegrouppost");
	Thread.sleep(2000);	
	waitForElementToPresent(OkBtn);
	click(OkBtn,"Ok button");	
	waitForElementToPresent(toastMessage);
	AssertionHelper.verifyText(toastMessage.getText(), "Post deleted successfully");
	Thread.sleep(7000);
		}
	
	
	public void Join( ) {

		click(Join,"Join");
		waitForElementToPresent(YesProceedBtn);
	//	picture();
		click(YesProceedBtn,"Yes Proceed");
		waitForElementToPresent(OkBtn);
//		picture();
		click(OkBtn,"Ok");
	}

	public void sendconnection( ) {

		int i = 1;

		click(navbarMembers,"Members");
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
				click(element,"pagination");
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
	//	picture();
	//	Thread.sleep(6000);
	}

	public void JoinPublicGroup( ) {
		this.Join();
		this.LeaveDisplayed();
		picture();

	}

	public void Leave( ) {

		click(Leave,"Leave");
		waitForElementToPresent(YesProceedBtn);
		picture();
		click(YesProceedBtn,"YesProceed");
		waitForElementToPresent(OkBtn);
		picture();
		click(OkBtn,"OkBtn");
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
		scrollToElement(checkbox);
		clickElementByJavaScript(checkbox);
		click(Reject,"Reject");
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
