package com.cpcommunity.ExtentListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.uiFramework.pamTen.cpcommunity.helper.javaScript.JavaScriptHelper;
import com.cpcommunity.utilities.DriverManager;
import com.cpcommunity.utilities.SessionID;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		// htmlReporter.config().setChartVisibilityOnOpen(true);;
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "QA Team");
		extent.setSystemInfo("Organization", "PamTen");
		extent.setSystemInfo("Build no", "SPRINT 15 V1.1");
		extent.setSystemInfo("URL", "https://cpcommunityqa.azurewebsites.net");

		return extent;

	}

	public static String screenshotPath;
	public static String screenshotName;

//	public static void captureScreenshot(String ID) {
//
//		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//
//		Date d = new Date();
//
//		screenshotName = ID + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//		try {
//			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public static void captureScreenshot() {

		
//		WebDriver augment = new Augmenter().augment(DriverManager.getDriver());
//		TakesScreenshot shot = (TakesScreenshot) augment;
//		File screenshot = shot.getScreenshotAs(OutputType.FILE);
		int t = (int) (Math.random()*1000);
		try {
			Thread.sleep(t);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();

		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void captureNewPageScreenshot(String ID) {

		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = ID + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void aShot() {		
		Screenshot fpScreenshot;		
		WebElement element = DriverManager.getDriver().findElement(By.xpath("//*[@id='header']"));
		JavascriptExecutor js1 = (JavascriptExecutor) DriverManager.getDriver();
		js1.executeScript("arguments[0].setAttribute('class','');", element);
		
		
		try {
			fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(DriverManager.getDriver());
		} catch (Exception e) {
			fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(DriverManager.getDriver());
		}
		
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + SessionID.getSessionID()+".jpg";

		try {
			ImageIO.write(fpScreenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js1.executeScript("arguments[0].setAttribute('class','navbar-fixed-top');", element);

		
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date d1 = new Date();
		screenshotName = SessionID.getSessionID()+d1.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
//		 ((JavascriptExecutor)
//		 DriverManager.getDriver()).executeScript("arguments[0].style.visibility='hidden'",
//		 element);
//		 Screenshot screenshot = new
//		 AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(DriverManager.getDriver());
//
//		 ((JavascriptExecutor)
//		 DriverManager.getDriver()).executeScript("arguments[0].style.visibility=''",
//		 element);
//		 js1.executeScript("arguments[0].setAttribute('class','navbar-fixed-top');", element);
		 

	}

}
