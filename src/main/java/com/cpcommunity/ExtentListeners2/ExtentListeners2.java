package com.cpcommunity.ExtentListeners2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners2 implements ITestListener {

	static Date d = new Date();
	static String fileName2 = "Extent_" + d.toString().replace(":", "_").replace(" ", "_")+"2" + ".html";

	static Date date = new Date();  
    static SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");  
    static String strDate = formatter.format(date);    
    static String fileName = "Extent_" + strDate.toString().replace(" ", "_")+"2" + ".html";
    
	
	
	private static ExtentReports extent = ExtentManager2
			.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		String testName = result.getTestClass().getName();
		
		if (testName.contains("com.cpcommunity.testScripts.community")) {
			testName = testName.replace("com.cpcommunity.testScripts.community", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.advertisments")) {
			testName = testName.replace("com.cpcommunity.testScripts.advertisments", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.Create_Free_Event")) {
			testName = testName.replace("com.cpcommunity.testScripts.Create_Free_Event", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.Create_Paid_Event")) {
			testName = testName.replace("com.cpcommunity.testScripts.Create_Paid_Event", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.Event_Registrations")) {
			testName = testName.replace("com.cpcommunity.testScripts.Event_Registrations", "");
		}
		
		if (testName.contains("com.cpcommunity.testScripts.Groups")) {
			testName = testName.replace("com.cpcommunity.testScripts.Groups", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.loginPage")) {
			testName = testName.replace("com.cpcommunity.testScripts.loginPage", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.myprofiletestcases")) {
			testName = testName.replace("com.cpcommunity.testScripts.myprofiletestcases", "");
		}
		if (testName.contains("com.cpcommunity.testScripts.Promocodes")) {
			testName = testName.replace("com.cpcommunity.testScripts.Promocodes", "");
		}
		if (testName.contains("cpcommunity.testScripts.TA_Organizations")) {
			testName = testName.replace("cpcommunity.testScripts.TA_Organizations", "");
		}

		
		System.out.println("@TestCase : " + result.getMethod().getMethodName());
		ExtentTest test = extent.createTest(testName);
		// ExtentTest test = extent.createTest(result.getTestClass().getName()+"
		// @TestCase : "+result.getMethod().getMethodName());
		testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");

//		try {
//			String TC = result.getTestClass().getName();
//			ExtentManager2.captureScreenshot();
//			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
//					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager2.screenshotName).build());
//		} catch (IOException e) {
//
//		}

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

}
