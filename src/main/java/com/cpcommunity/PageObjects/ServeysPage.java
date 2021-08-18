package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ServeysPage extends BasePage

{
	@FindBy(xpath = "//i[@class='icon-plus']")
	WebElement addBtn;

	@FindBy(xpath = "//*[@id='Name']")
	WebElement name;

	@FindBy(xpath = "//*[@id='EventID']")
	WebElement eventID;

	@FindBy(xpath = "//*[@id='Title']")
	WebElement title;

	@FindBy(tagName = "body")
	WebElement enterTextInframe;
	@FindBy(tagName = "iframe")
	WebElement iframe;
	@FindBy(xpath = "//input[@id='StartDate']")
	WebElement startDate;
	@FindBy(xpath="//div[@class='toast toast-success']")
	WebElement toastMsg;
	@FindBy(xpath = "//button[normalize-space()='Add Question']")
	WebElement addQues;
	@FindBy(xpath = "//input[@id='EndDate']")
	WebElement endDate;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/button[1]/span[1]")
	WebElement action;

	@FindBy(xpath = "//div[@class='btn-group open']//li[2]//a[1]")
	WebElement inactiveBtn;

	@FindBy(xpath = "//a[normalize-space()='Active']")
	WebElement activeBtn;

	@FindBy(xpath = "//div[@class='btn-group open']//li[1]//a[1]//i[1]")
	WebElement edit;
	
	@FindBy(xpath="//button[@class='btn btn-small dropdown-toggle']")
	WebElement questionActionBtn;
	
	@FindBy(xpath="//a[normalize-space()='Disable']")
	WebElement questionDisable;
	 
	@FindBy(xpath="//a[normalize-space()='Enable']")
	WebElement questionEnable;
	
	@FindBy(xpath="//small[@class='text-error']")
	WebElement inactiveMsg;
	
	@FindBy(xpath="//input[@value='Save Survey']")
	WebElement SaveSurvey;
	
	@FindBy(xpath="//small[@class='text-success']")
	WebElement activeMsg;
	
	@FindBy(xpath="//a[normalize-space()='Edit']")
	WebElement editQuestion;
	
	@FindBy(xpath="//span[@data-bind='text: title']")
	WebElement textQues;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//a[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//input[@id='Title']")
	WebElement question;


	

	
	@Override
	protected void getPageScreenSot() {

		aShot();
	}

	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	WebElement Save;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement saveSurvey;
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		driver.switchTo().frame("surveyFrame");
		
		return ExpectedConditions.visibilityOf(addBtn);
	}

	public void createServey() throws Exception {
		waitForElementToPresent(addBtn);
		click(addBtn, "back to PaymentGateways");
		waitForElementToPresent(name);
		click(addBtn,"Add Question");
		waitForElementToPresent(title);
		type(title, "", "title");
			
		
		click(Save,"Save");
		
		
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);
		

	}
	public void createSurveyByCA(String Name,String Ques) throws Exception {
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		waitForElementToPresent(name);
		Name = Name+getDateInDDMMMYYYY();
		type(name,Name,Name);
		getDateInDDMMYYYY();
		System.out.println(startDate.getAttribute("value"));
		selectUsingIndex(eventID,1,"Event selected");		
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques, Ques);		
		click(Save,"Save");
		click(saveSurvey,"Save Survey");
		Thread.sleep(3000);
		System.out.println( toastMsg.getText());
		if(toastMsg.getText().equalsIgnoreCase("Success! Survey created.")) {
			System.out.println("Survey created byCA");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
	}
public void eventNameNotVisibleInDropDown(String Title) {
		
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		System.out.println(eventID.getText());
		if(!eventID.getText().contains(Title)) {
			System.out.println("Event where survey is made is unavailable in drop down menu");
		}
		
	}
	public void checkPopUpWhenCancel(String Name,String Ques) {
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		waitForElementToPresent(name);
		Name = Name+getDateInDDMMMYYYY();
		type(name,Name,Name);
		getDateInDDMMYYYY();
		System.out.println(startDate.getAttribute("value"));
		selectUsingIndex(eventID,1,"Event selected");		
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques, Ques);		
		click(Save,"Save");
		click(cancel,"Cancel");
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		if(x.equalsIgnoreCase("Do you want to discard the changes?")) {
			System.out.println("Pop up comes up when we cancel filled survey form");
			Assert.assertTrue(true);
		}
		driver.switchTo().alert().dismiss();	
		System.out.println("We can click cancel on pop up and the form remains");
		/*if(name.getText().equalsIgnoreCase(Name)) {
			System.out.println("Cancelled ");
		}*/		
		click(cancel,"Cancel");
		driver.switchTo().alert().accept();
		System.out.println("We can click ok on pop up and form gets cancelled and survey page opens");
		
	}
	public void inactivateSurveyByCA() throws InterruptedException {
		click(action,"Action")	;
		click(inactiveBtn,"Inactive");
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		click(action,"Action")	;
		click(activeBtn,"Active");
		driver.switchTo().alert().accept();
	}
	public void infiniteQuestionsByCA(String Name,String Ques,String Ques2,String Ques3,String Ques4,String Ques5,String Ques6) {
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		waitForElementToPresent(name);
		Name = Name+getDateInDDMMMYYYY();
		type(name,Name,Name);
		getDateInDDMMYYYY();
		System.out.println(startDate.getAttribute("value"));
		selectUsingIndex(eventID,1,"Event selected");		
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques, Ques);		
		click(Save,"Save");
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques2, Ques2);		
		click(Save,"Save");
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques3, Ques3);		
		click(Save,"Save");
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques4, Ques4);		
		click(Save,"Save");
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques5, Ques5);		
		click(Save,"Save");
		click(addQues,"Add Question");
		waitForElementToPresent(title);
		type(title,Ques6, Ques6);		
		click(Save,"Save");
		
	}
	public void draftAndCancelledEvents(String Draft,String Cancelled) {
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		System.out.println(eventID.getText());
		System.out.println(Draft);
		System.out.println(Cancelled);
		if(!eventID.getText().contains(Draft)) {
			System.out.println("Draft Event not available in the Event dropdown Menu");
			Assert.assertTrue(true);
		}else {
			System.out.println("Draft Event available in the event drop down Menu");
		}
		
		if(!eventID.getText().contains(Cancelled)) {
			System.out.println("Cancelled Event not available in the Event dropdown Menu");
			Assert.assertTrue(true);
		}else {
			System.out.println("Cancelled Event available in the event drop down Menu");
		}
		
	}
	public void disabledSurveyQuestion() throws InterruptedException {
		click(action,"Action")	;
		click(edit,"Edit");
		Thread.sleep(2000);
		click(questionActionBtn,"Action For Question");
		click(questionDisable,"Disable Question")	;
		String x=inactiveMsg.getAttribute("data-bind");
		System.out.println(x);
		if(x.contains("!isActive")) {
			System.out.println("On disabling question it becomes inactive");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);		
		click(questionActionBtn,"Action For Question");
		click(questionEnable,"Enable Question")	;
		click(SaveSurvey,"save survey");
		
		
		
		
	}
	public void editQuestionByCA(String newQuestion,String oldQuestion) throws InterruptedException {
		click(action,"Action")	;
		click(edit,"Edit");
		Thread.sleep(2000);
		click(questionActionBtn,"Action For Question");
		click(editQuestion,"Edit Question");
		type(question,newQuestion,newQuestion);
		System.out.println(newQuestion);
		click(saveBtn,"Save edited question");
		System.out.println(textQues.getText());
		if(newQuestion.equals(textQues.getText())) {
			System.out.println("CA can edit question after survey submitted");
			Assert.assertTrue(true);
		}else Assert.assertTrue(false);
		click(questionActionBtn,"Action For Question");
		click(editQuestion,"Edit Question");
		type(question,oldQuestion,oldQuestion);
		click(saveBtn,"Save edited question");
		click(SaveSurvey,"save survey");
	}
	public void emptyFormSubmission() throws InterruptedException {
		waitForElementToPresent(addBtn);
		click(addBtn, "create new survey");
		click(addQues,"Add Question");
		Thread.sleep(1000);
		//driver.switchTo().frame(0);
		//type(description,"ABCD","description");
		//driver.switchTo().defaultContent();
		click(Save,"Save");
		Thread.sleep(1000);
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		if(x.equalsIgnoreCase("Error: All fields are required!")) {
			Assert.assertTrue(true);
			System.out.println("CA cannot submit empty survey form");
					}else Assert.assertTrue(false);
	}
		
		


	


}
