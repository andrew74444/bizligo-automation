package com.cpcommunity.PageObjects;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.cpcommunity.ExtentListeners.*;
import com.cpcommunity.ExtentListeners2.*;
import com.cpcommunity.utilities.DriverCapabilities;
import com.cpcommunity.utilities.DriverManager;
import com.cpcommunity.utilities.JavaScript;
import com.cpcommunity.utilities.RobotClass;
import com.cpcommunity.utilities.SessionID;
import com.cpcommunity.utilities.waitHelper;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public abstract class BasePage<T> {

	protected WebDriver driver;
	protected String ID;
	public Logger log = Logger.getLogger(BasePage.class);
	// private long LOAD_TIMEOUT = 200;
	private int AJAX_ELEMENT_TIMEOUT = 20;
	public int expTime = 20;
	protected JavascriptExecutor exe;
	protected Robot robot;
	protected WebDriverWait wait;
	protected Capabilities caps;

	public BasePage() {
		this.driver = DriverManager.getDriver();
		this.ID = SessionID.getSessionID();
		this.exe = JavaScript.getJavaScriptObject();
		this.robot = RobotClass.getRobotClassObject();
		this.wait = waitHelper.getWebDriverWaitObject();
		this.caps = DriverCapabilities.getCapabilities();
	}

	public T openPage(Class<T> clazz) {
		T page = null;
		try {
			driver = DriverManager.getDriver();
			AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
			page = PageFactory.initElements(driver, clazz);
			PageFactory.initElements(ajaxElemFactory, page);
			ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
			waitForPageToLoad(pageLoadCondition);
			((BasePage) page).getPageScreenSot();
		} catch (NoSuchElementException e) {
			/*
			 * String error_screenshot = System.getProperty("user.dir") +
			 * "\\target\\screenshots\\" + clazz.getSimpleName() + "_error.png";
			 * this.takeScreenShot(error_screenshot);
			 */ throw new IllegalStateException(String.format("This is not the %s page", clazz.getSimpleName()));
		}
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
		// WebDriverWait wait = new WebDriverWait(driver, LOAD_TIMEOUT);
	log.info("waiting for "+ pageLoadCondition);
		wait.until(pageLoadCondition);

	}

	protected abstract ExpectedCondition getPageLoadCondition();

	protected abstract void getPageScreenSot();

	public String screenshotName;

	public void aShot() {
try {
	

		Screenshot fpScreenshot;

		fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(DriverManager.getDriver());

		Date d = new Date();
		screenshotName = SessionID.getSessionID() + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		try {
			ImageIO.write(fpScreenshot.getImage(), "PNG",
					new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			ExtentListeners.testReport.get().info(
					"<b>" + "<font color=" + "yellow>" + "Screenshot of new Page Navigation" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());

			// ExtentListeners.testReport.get().info("<b>" + "<font color=" + "yellow>" +
			// "Screenshot of new Page Navigation" + "</font>" + "</b>"+"<p>" + "<a
			// target=\"_blank\" href='" + screenshotName
			// + "'><img src='" + screenshotName +"'width='10%'/></a>" + "</p>");

		} catch (Exception e) {

		}

		scrollUpVertically();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void takeScreenshotByShutterBug(WebElement ele, String imageName) {
		log.info("Taking Screen shot of the element");
		Shutterbug.shootElement(DriverManager.getDriver(), ele).withName(imageName).save();
		log.info("Taken Screen shot of the element");

		try {
			ExtentListeners.testReport.get()
					.info("<b>" + "<font color=" + "white>" + "Screenshot of the section" + "</font>" + "</b>",
							MediaEntityBuilder
									.createScreenCaptureFromPath(
											System.getProperty("user.dir") + "\\screenshots\\" + imageName + ".png")
									.build());

		} catch (Exception e) {

		}

	}

	protected void waitForElementToPresent(WebElement element) {

		
		log.info("waiting for :" + element.toString().substring(65) + " for :" + expTime + " seconds");
		// System.out.println("waiting for :" + element.toString() + " for :" +
		// timeOutInSeconds + " seconds");

		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element.toString().substring(60) + "is displayed");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).perform();
	}

	public void click(WebElement element, String elementName) {

		ExtentListeners.testReport.get().info("Clicking on : " + elementName);
		ExtentListeners2.testReport.get().info("Clicking on : " + elementName);
		// System.out.println("Clicking on : "+elementName);
		log.info("Clicking on : " + elementName);
		highlightElement(element);
		element.click();
		log.info("Clicked on : " + elementName);
		ExtentListeners.testReport.get().info("Clicked on : " + elementName);
		ExtentListeners2.testReport.get().info("Clicked on : " + elementName);
//		ExtentListeners2.testReport.get().info("Clicked on : " + elementName);
	}

	public void type(WebElement element, String value, String elementName) {
		// System.out.println("Typing in : "+elementName+" entered the value as :
		// "+value);
		log.info("Typing in : " + elementName + " entered the value as : " + value);
		ExtentListeners.testReport.get().info("Typing in : " + elementName + " entered the value as : " + value);
		ExtentListeners2.testReport.get().info("Typing in : " + elementName + " entered the value as : " + value);
		element.clear();
		highlightElement(element);
		element.sendKeys(value);
//		ExtentListeners2.testReport.get().info("Typed in : " + elementName + " entered the value as : " + value);
	}

	public String getValueFromInputFiled(WebElement ele) {
		return ele.getAttribute("value");

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		// WebElement inpElement = driver.findElement(By.id("inputTag"));
		// String value = js.executeScript("return arguments[0].value", inpElement);
	}

	public void selectByVisibleText(WebElement element, String value, String elementName) {
		log.info("Selecting the " + elementName + "value as : " + value);
		ExtentListeners.testReport.get().info("Selecting the " + elementName + " value as : " + value);
		ExtentListeners2.testReport.get().info("Selecting the " + elementName + " value as : " + value);
		Select sel = new Select(element);
		highlightElement(element);
		sel.selectByVisibleText(value);
		log.info("Selected the " + elementName + "value as : " + value);
//		ExtentListeners2.testReport.get().info("Selected the " + elementName + " value as : " + value);
	}

	public void selectUsingIndex(WebElement element, int index, String elementName) {
		Select select = new Select(element);
		ExtentListeners.testReport.get().info("Selecting the " + elementName + " value as : " + index);
		ExtentListeners2.testReport.get().info("Selecting the " + elementName + " value as : " + index);
		log.info("selectUsingIndex and index is: " + index);
		select.selectByIndex(index);
//		ExtentListeners2.testReport.get().info("Selected the " + elementName + " value as : " + index);
	}

	public List<String> getAllDropDownData(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for (WebElement ele : elementList) {
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}

	public int getTotalCountOfDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> elementList = select.getOptions();
		return elementList.size();
	}

	// https://www.javatpoint.com/how-to-generate-random-number-in-java
	// https://www.tutorialspoint.com/generate-random-boolean-in-java
	// https://www.tutorialspoint.com/java/util/random_nextboolean.htm
	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
	public int getnumber() {
	    double  number = Math.random()*1000;
	    int n = (int) number ;
		return n;
	}
	

	// public void picture(String ID) {
	// try {
	// ExtentManager.captureScreenshot(ID);
	// ExtentListeners.testReport.get().info(
	// "<b>" + "<font color=" + "yellow>" + "Screenshot of new Page Navigation" +
	// "</font>" + "</b>",
	// MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
	// } catch (Exception e) {
	//
	// }
	//
	// }

	public void picture() {
		try {
			ExtentManager.captureScreenshot();
			ExtentListeners.testReport.get().info(
					"<b>" + "<font color=" + "yellow>" + "Screenshot of new Page Navigation" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		} catch (Exception e) {

		}

	}

	public void newPageScreenShot() {
		try {
			ExtentManager.aShot();
			ExtentListeners.testReport.get().info(
					"<b>" + "<font color=" + "yellow>" + "Screenshot of new Page Navigation" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
			ExtentListeners.testReport.get().info("<b>" + "<a target=\"_blank\" href='" + screenshotName
					+ "'><img src='" + screenshotName + "height='100 width='100'/></a>" + "</b>");
			// <a target=\"_blank\" href='"+Name+"'><img src='"+Name+"'height='100'
			// width='100'/></a>
		} catch (Exception e) {

		}

	}

	public int getString(String str, int position) {
		String[] T = str.split("\\s+");
		int TotalPlans = Integer.parseInt(T[position]);
		return TotalPlans;
	}

	// https://www.javatpoint.com/java-string-getchars
	public String getStringPositionAt(String str, int position) {
		String[] T = str.split("\\s+");
		return T[position];

	}
	
	
	public String[] splitStringBy(String str, String by) {

		String[] t = str.split(by);
		
	
		return t;
		}

	// https://compiler.javatpoint.com/opr/test.jsp?filename=DateToStringExample2
	public String currentTime() {
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Date date = new Date();
		// System.out.println(date)); //0809190355
		
		String d = dateFormat.format(date);
		log.info(d);
		return d;
	}

	public String getSystemCurrentYear() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	public String getSystemCurrentMonth() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("M");
		String strDate = formatter.format(date);
		return strDate;
	}

	public String getSystemCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("d");
		String strDate = formatter.format(date);
		return strDate;
	}

	public String getSystemCurrentHourIn12Hour() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("hh");
		String strDate = formatter.format(date);
		System.out.println("Date Format with dd-M-yyyy hh:mm:ss : " + strDate);
		return strDate;
	}

	public String getSystemCurrentMintues() {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("mm");
		String strDate = formatter.format(date);
		System.out.println("Date Format with dd-M-yyyy hh:mm:ss : " + strDate);
		return strDate;
	}

	public String getAmPm() {

		Date date = new Date();
		String dateToStr = DateFormat.getTimeInstance().format(date);
		System.out.println("Date Format using getTimeInstance(): " + dateToStr);
		return dateToStr;
	}

	public String intToString(int i) {
		String s = String.valueOf(i);
		return s;
	}

	public int stringToInt(String s) {
		int i = Integer.parseInt(s);
		log.info(i);
		return i;
	}

	public Date getDate() {
		Date date = new Date();
		return date;
	}

	public String getDateInDDMMMYYYY() {

		// SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		String strDate = formatter.format(getDate());
		System.out.println("Date Format with dd MMMM yyyy : " + strDate);
		return strDate;
	}

	// https://mkyong.com/java/java-date-and-calendar-examples/

	public String addDaysToCurrentDate(int days, int weeks, int months, int year) {

		// DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date d = getDate();

		log.info(d);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		Date daysAdded = c.getTime();
		log.info(daysAdded);

		c.add(Calendar.DATE, days);
		daysAdded = c.getTime();
		log.info(daysAdded);

		c.add(Calendar.MONTH, months);
		log.info(daysAdded);
		daysAdded = c.getTime();

		c.add(Calendar.YEAR, year);
		daysAdded = c.getTime();
		log.info(daysAdded);

		c.add(Calendar.WEEK_OF_YEAR, weeks);
		daysAdded = c.getTime();
		log.info(daysAdded);

		int yr = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = c.get(Calendar.WEEK_OF_MONTH);
		month++;
		String date = month + "/" + dayOfMonth + "/" + yr;
		log.info(date);
		return date;
	}

	public void getDateInDDMMYYYY() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
	}

	public String getDateInString() {
		return getSystemCurrentDate() + "-" + getSystemCurrentMonth() + "-" + getSystemCurrentYear();

	}

	// Sun Nov 25 11:45:05 PST 2012
	public Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);

		return cal.getTime();
	}
	// Sun Nov 25 11:45:05 PST 2012

	public Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	public void verifyImage(String pathOfTheImage) throws Exception {

		Thread.sleep(1000);
		Thread.sleep(1000);
		Screen screen = new Screen();

		Pattern img = new Pattern(pathOfTheImage);

		screen.wait(img, expTime);
		System.out.println(screen.wait(img, expTime));
		// screen.click(img);
		// screen.type(img,value);

	}

	public void switchToFrameByID(int ID) {
		DriverManager.getDriver().switchTo().frame(ID);
	}

	public void switchTodefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

	// Should match elements all
	// @FindBys({
	// @FindBy(xpath=""),
	// @FindBy(xpath="")
	// })
	// List<WebElement> elementsList;

	// @FindAll({
	// @FindBy(xpath=""),
	// @FindBy(xpath="")
	// })
	// List<WebElement> elementsList;

	// *******************************************JavaScript*********************************//
	/**
	 * Scroll till element and click
	 * 
	 * @param element
	 * 
	 * 
	 */

	public void highlightElement(WebElement element) {
		exe.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	public void scrollToElement(WebElement element) {
		exe.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x,
				element.getLocation().y);
	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element is clicked: " + element.toString());
	}

	public Object executeScript(String script) {
		return exe.executeScript(script);
	}

	/**
	 * This method will execute Java script with multiple arguments
	 * 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object... args) {
		return exe.executeScript(script, args);
	}

	public void TypeByJavaScript(String Value, WebElement element) {
		executeScript("arguments[0].value='" + Value + "';", element);

	}

	/**
	 * Open Link in same window
	 * 
	 * @param element
	 */

	public String target_blank(WebElement element) {
		String hrefUrl = element.getAttribute("href");
		// System.out.println("*******" + hrefUrl);
		// driver.get(hrefUrl);
		// System.out.println(element.getAttribute("target"));
		executeScript("arguments[0].setAttribute('target','_self');", element);
		// System.out.println(element.getText());
		// System.out.println(element.getAttribute("target"));
		return hrefUrl;
	}

	public void updateClass(WebElement element, String value) {
		// System.out.println("value is "+value);
		executeScript("arguments[0].setAttribute('class','" + value + "');", element);
	}

	public void setAttribute(WebElement element, String value, String attribute) {
		// System.out.println("value is "+value);
		executeScript("arguments[0].setAttribute('" + attribute + "','" + value + "');", element);
	}

	public String getAttributeValue(WebElement element, String name) {
		// System.out.println("value is "+value);
		return element.getAttribute(name);

	}

	/**
	 * Scroll till element view
	 * 
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		log.info("scroll till web " + element);
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * Scroll till element view and click
	 * 
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("element is clicked: " + element.toString());

	}

	/**
	 * This method will scroll down vertically
	 */
	public void scrollDownVertically() {
		log.info("scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically() {
		log.info("scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	/**
	 * This method will scroll till given pixel (e.g=1500)
	 * 
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
	}

	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

	/**
	 * This method will zoom screen by 100%
	 */
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	/**
	 * This method will zoom screen by 60%
	 */
	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	/**
	 * This method will click on element
	 * 
	 * @param element
	 */
	public void clickElementByJavaScript(WebElement element) {
		highlightElement(element);
		log.info("Clicking" + element.toString().substring(65));
		executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		log.info("Clicked" + element.toString().substring(65));
	}

	public HashMap<String, String> getBrowserInstance() {
		HashMap<String, String> instanceDetails = new HashMap<String, String>();
//		https://multi2.ezysubscribe.com/paymentgateways/paymentconfirmation?PaymentId=792&TransactionId=40055248987&Message=Payment%20Processed%20successfully&PaymentPurpose=MEMBERSHIP_PLAN_PURCHASE&FailedAttempts=0
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName);
		System.out.println(browserVersion);
		instanceDetails.put("browserName", browserName);
		instanceDetails.put("browserVersion", browserVersion);
		// Get OS name.
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
		instanceDetails.put("os", os);
		log.info(instanceDetails);
		return instanceDetails;
	}

	public StringBuffer chanageToUpperCase(String name) {

		StringBuffer updatedName = new StringBuffer(name);

		for (int i = 0; i < name.length(); i++) {

			// Checks for lower case character

			// Convert it into upper case using toUpperCase() function
			updatedName.setCharAt(i, Character.toUpperCase(name.charAt(i)));
		}
		return updatedName;
	}

	public void applyPromoCode(String promo, WebElement promoCode, WebElement applybtn, WebElement promoCodeApplied)
			throws Exception {

		Thread.sleep(1000);
		Thread.sleep(1000);
		Thread.sleep(1000);

		if (promo.contains("PROMO")) {
			driver.findElement(By.xpath("//*[@for='IHavePromoCode']")).click();
			type(promoCode, promo + getSystemCurrentMonth() + getSystemCurrentDate() + getSystemCurrentYear(),
					"promo Code");
			click(applybtn, "apply button");
			waitForElementToPresent(promoCodeApplied);

		}
	}

	public void clickByVisibleScreen(String imagePath) throws FindFailed {
		// We have to create Screen class object to access method
		Screen screen = new Screen();
		// Create object of Pattern class and specify the images path
		Pattern image = new Pattern(imagePath);

		screen.wait(image, 10);
		// using screen object we can call click method which will accept image path and
		// will perform //action
		// This will click on gmail image on google home page
		screen.click(image);

	}
	
	public void typeByVisibleScreen(String imagePath, String value) throws FindFailed {
		// We have to create Screen class object to access method
		Screen screen = new Screen();
		// Create object of Pattern class and specify the images path
		Pattern image = new Pattern(imagePath);

//		screen.wait(image, 10);
		// using screen object we can call click method which will accept image path and
		// will perform //action
		// This will click on gmail image on google home page
//		screen.type(imagePath);
		screen.type(image,value);


	}
	
	

	public String projectFloder(String path) {
		return System.getProperty("user.dir") + path;
	}

	public void verifyText(String actual, String expected) {

		SoftAssert st = new SoftAssert();
		st.assertEquals(actual, expected);
		st.assertAll();

	}

	public void uploadImage(String filePath) throws IOException, InterruptedException {
		HashMap<String, String> instanceDetails = getBrowserInstance();
		Thread.sleep(10000);
		if(instanceDetails.get("browserName").equalsIgnoreCase("chrome")) {	
			 Runtime.getRuntime().exec(filePath);
			 log.info("Image uploaded");
		}
		Thread.sleep(10000);	
	}
	
	public void writeInNotePad(String value, String fileName) throws Exception {
	
		try {

			  Path path = Paths.get(System.getProperty("user.dir")+"//src//test//resources//testdata//test");

			  //java.nio.file.Files;
			  Files.createDirectories(path);

			  System.out.println("Directory is created!");

			} catch (IOException e) {

			  System.err.println("Failed to create directory!" + e.getMessage());

			}
	    
		
		File f = new File(System.getProperty("user.dir")+"//src//test//resources//testdata//test//"+fileName+".txt");
		f.delete();
		Thread.sleep(3000);
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter writer = new BufferedWriter(fw);	
		writer.write(value);
		
		writer.close();
		
	}
	
	public String readInNotePadFile(String fileName) throws Exception {
	File f = new File(System.getProperty("user.dir")+"//src//test//resources//testdata//test//"+fileName+".txt");
	
	FileReader fr = new FileReader(f);
	
	BufferedReader reader = new BufferedReader(fr);
	String value = reader.readLine();
	log.info(value);
	reader.close();
	return value;
	}
	
	public void deleteFile (String path) throws InterruptedException{
		
		Thread.sleep(3000);
		    File myObj = new File(path); 
		    if (myObj.delete()) { 
		      System.out.println("Deleted the folder: " + myObj.getName());
		    } else {
		      System.out.println("Failed to delete the folder.");
		    } 
		  }
	
	
	public void getAllFiles() throws InterruptedException {
		File directoryPath = new File(System.getProperty("user.dir")+"//src//test//resources//testdata//test");
	      //List of all files and directories
	      String contents[] = directoryPath.list();
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	         deleteFile(System.getProperty("user.dir")+"//src//test//resources//testdata//test//"+contents[i]);
	      }
	}
	
		
}
