package com.org.aempackge.aemmaven1;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Global.Browser;
import Global.Excel;

public class ManualAudits {
	Browser browser;
	JavascriptExecutor js;
	// MANUAL ADD COMMENT

	@FindBy(xpath = "//*[@id='potantialAudit_id']/div/div[10]//div[2]//div//div")
	public WebElement clickselectelementdropdown;

	@FindBy(xpath = "//*[@class='toast-text']/span")
	public WebElement updatedsuccessfully;

	@FindBy(xpath = "//*[@class='charge-comment-history']/div/div/a[4]")
	public WebElement clickcommenthistory;

	@FindBy(xpath = "//*[@id='clientSidenav']/a")
	public WebElement sliderclose;
	@FindBy(xpath = "//*[@class='datatable-scroll']")
	public WebElement table;
	@FindBy(xpath = "//div[@class='proceedbtn']")
	public WebElement manualproceed;

	@FindBy(xpath = "//*[@class='datatable-row-center']/descendant::datatable-header-cell[3]/div/div/div[1]")
	public WebElement click_invoicenimber;

	@FindBy(xpath = "//*[@class='vui-list']/div/div/input")
	public WebElement selectoncheckbox;

	@FindBy(xpath = "//*[@class='datatable-row-center']/descendant::datatable-header-cell[3]/div/div/div[1]/input")
	public WebElement clickonapply;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input")
	public WebElement selectclientcocecheckbox;

	@FindBy(xpath = "//*[@class='button-list']/div[5]/div")
	public WebElement clickmanualaddcoment;

	@FindBy(xpath = "//textarea[@name='name']")
	public WebElement entercomment;

	@FindBy(xpath = "//*[@class='container-fluid manual']/div[10]//div[2]//button[2]")
	public WebElement clickonsubmit;

	@FindBy(xpath = "//*[@class='submenubar']//div[2]")
	public WebElement clickonclearbutton;

	// SELECTDATAELEMENTS AND SAVELAYOUT MANUALAUDIT

	@FindBy(xpath = "//*[@class='fa fa-plus']")
	public WebElement selectdataelements;

	@FindBy(xpath = "//*[@class='container-fluid manual']/div[11]//div[2]//div//span")
	public WebElement manualselectelementdropdown;

	// @FindBy(xpath = "//li[5]/a/input")
	// public WebElement selectcheckbox;

	@FindBy(xpath = "//li[233]/a/input")
	public WebElement shipfromcompanycheckbox;

	@FindBy(xpath = "//li[234]/a/input")
	public WebElement shipfromcountrycheckbox;

	@FindBy(xpath = "//*[@class='container-fluid manual']/div[11]//div[3]/button[1]")
	public WebElement clickok;

	@FindBy(xpath = "//*[@class='child-menu']")
	public WebElement SavelayoutButton;

	@FindBy(xpath = "//*[@class='form-control ng-untouched ng-pristine ng-invalid']")
	public WebElement commententered;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[3]")
	public WebElement Click_onsavebutton;

	// SELECT ALL DATAELEMENTS

	@FindBy(xpath = "//*[@class='dropdown-menu']/li[3]")
	public WebElement Checkall;
	@FindBy(xpath = "//li[5]/a/input")
	public WebElement selectcheckbox;

	// INSERTAUDIT RESULT

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[3]")
	public WebElement Insertauditreultmanualcheckbox;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[3]")
	public WebElement Insertauditreultmanualuncheckbox;

	@FindBy(xpath = "//*[@class='button-list']/div[2]")
	public WebElement Insertauditresultbutton;

	@FindBy(xpath = "//*[@class='modal-content']/descendant::select")
	public WebElement Potentialauditcodedropdownforinsert;

	@FindBy(xpath = "//*[@value='2: 1001 - RESIDENTIAL DELIVERY CHARGE VALIDATION']")
	public WebElement selectpotentialauditcode;

	@FindBy(xpath = "//*[@class='auditresultinput ng-untouched ng-pristine ng-invalid']")
	public WebElement Auditamountformanualforindert;

	@FindBy(xpath = "//*[@class='modal fade insertaudit in']/descendant::input[2]")
	public WebElement AuditDetailsforinsert;

	@FindBy(xpath = "//*[@class='modal fade insertaudit in']/descendant::button[3]")
	public WebElement insertmanualauditsubmitbutton;

	public String errormessage = "//*[@class='modal fade in']/descendant::div[4]";

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement manualinsertauditclose;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement acceptauditokbutton;

	// SEND TO CLIENT

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement clicktokbutton;

	@FindBy(xpath = "//*[@class='button-list']/div[6]/div")
	public WebElement clicksendtoclientmanualbutton;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement clickclosebutton;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement NotabletofindClientuser;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[2]")
	public WebElement sendtoclientmanualcheckboxunchecked;

	@FindBy(xpath = "//*[@class='container-fluid manual']/div/div")
	public WebElement manualauditworkspacecount;

	// SEND TO CARRIER

	@FindBy(xpath = "//*[@class='button-list']/div[5]/div")
	public WebElement click_addcomment;

	@FindBy(xpath = "//textarea[@name='name']")
	public WebElement type_comment;

	@FindBy(xpath = "//*[@class='container-fluid manual']/div[10]//div[2]//button[2]")
	public WebElement submit;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[2]")
	public WebElement sendtocarriercheckbox;

	@FindBy(xpath = "//*[@class='button-list']/div[7]/div")
	public WebElement clicksendtocarrierbutton;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement closebuttonclick;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement NotabletofindCarrier;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[2]")
	public WebElement sendtocarrieruncheckedcheckbox;

	@FindBy(xpath = "//*[@class='menubars']/div")
	public WebElement manualauditcarrierworkspacecount;

	// COMPLETEVALIDATION

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[5]")
	public WebElement completecheckbox;

	@FindBy(xpath = "//*[@class='button-list']/div[3]/div")
	public WebElement completevalidationbutton;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[5]")
	public WebElement completeuncheckbox;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement completevalidationokbutton;

	// NON-AUDITED CHARGE
	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[6]")
	public WebElement nonchargecheckbox;

	@FindBy(xpath = "//*[@class='datatable-scroll']/descendant::input[6]")
	public WebElement nonchargeuncheckbox;

	@FindBy(xpath = "(//*[@class='btn-link'])[4]")
	public WebElement noncargebutton;

	@FindBy(xpath = "//*[@class='sub-title']")
	public WebElement insertvalidationbuttonworkspace;

	@FindBy(xpath = "//*[@class='modal fade in']/descendant::button[2]")
	public WebElement auditchargeokbutton;

	// EXPORTDATAMANUAL
	@FindBy(xpath = "//*[@class='exp-ort']")
	public WebElement Clickonexportbutton;

	/**
	 * @param j
	 */
	public ManualAudits(WebDriver driver) {
		this.js = (JavascriptExecutor) driver;
	}

	public Integer countDownlodedFiles(String fileName) {
		int count = 0;
		File dir = new File(System.getProperty("user.dir") + "\\downloads\\");
		File[] dir_contents = dir.listFiles();
		for (int index = 0; index < dir_contents.length; index++) {
			String currentfilename = dir_contents[index].getName();
			if (currentfilename.contains(fileName)) {
				count++;
			}
		}
		return count;
	}

	public void ExportData(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {
		int beforefilecount = countDownlodedFiles("manualReport");
		wait.until(ExpectedConditions.elementToBeClickable(Clickonexportbutton));
		Clickonexportbutton.click();
		Thread.sleep(5000);
		/*
		 r = new Robot(); Thread.sleep(1000);
		 * r.keyPress(KeyEvent.VK_ALT); r.keyPress(KeyEvent.VK_S);
		 * Thread.sleep(1000); r.keyRelease(KeyEvent.VK_ALT);
		 * r.keyRelease(KeyEvent.VK_S); r.keyPress(KeyEvent.VK_ENTER);
		 */
		Thread.sleep(1000);
		int afterFilecount = countDownlodedFiles("manualReport");
		if (afterFilecount == beforefilecount + 1) {
			test.log(LogStatus.PASS, "ExportData Passed");
			String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
			test.log(LogStatus.PASS, "ExportData Passed", test.addScreenCapture(screenshotPath));
		} else {
			test.log(LogStatus.FAIL, "ExportData Failed");
			String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
			test.log(LogStatus.FAIL, "ExportData faied", test.addScreenCapture(screenshotPath));
		}
		Thread.sleep(10000);
	}

	public void selectDataelement(WebDriver driver, WebDriverWait wait, ExtentTest test) throws Exception {

		List columns = driver.findElements(By.xpath(
				"/html/body/aem-app/aem-home/div/app-manualaudits/div/div/div[25]/ngx-datatable/div/datatable-header/div/div[2]/datatable-header-cell"));
		int tableCellsLength = columns.size() - 1;
		selectdataelements.click();
		Thread.sleep(2000);
		System.out.println("dropdown clicked with locator as " + manualselectelementdropdown);
		js.executeScript("arguments[0].click();", manualselectelementdropdown);
		Thread.sleep(3000);
		ArrayList dataelements = new ArrayList();
		for (int i = 0; i <= 2; i++) 
		{
			driver.findElement(By.xpath("//li[" + (i + 5) + "]/a/input")).click();
			dataelements.add(driver.findElement(By.xpath("//li[" + (i + 5) + "]/a/span")).getText());
		}
		String screenshotPath = null;
		screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
		test.log(LogStatus.PASS, "selectElement Passed", test.addScreenCapture(screenshotPath));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(clickok));
		clickok.click();
		Thread.sleep(5000);
		Boolean isPassed = false;
		for (int i = 0; i <= 2; i++) {
			WebElement scroll = driver.findElement(
				By.xpath("//datatable-row-wrapper[1]/datatable-body-row/descendant::datatable-body-cell["
							+ (tableCellsLength + (i + 2)) + "]//div[@class='datatable-body-cell-label']/div"));

			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", scroll);
			Thread.sleep(5000);
			String newlyAddedColumn = driver.findElement(By
					.xpath("/html/body/aem-app/aem-home/div/app-manualaudits/div/div/div[25]/ngx-datatable/div/datatable-header/div/div[2]/datatable-header-cell["
							+ (tableCellsLength + (i + 1)) + "]/div/div/div[1]"))
					.getText();
			Thread.sleep(2000);
			isPassed = (newlyAddedColumn.equals(dataelements.get(i)));

			if (!isPassed) {
				break;

			}

		}
		if (isPassed) {
			test.log(LogStatus.PASS, "selectDataelement Passed");
			screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
			test.log(LogStatus.PASS, "selectDataelement Passed", test.addScreenCapture(screenshotPath));
		} else {
			test.log(LogStatus.FAIL, "selectDataelement Failed");
			screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
			test.log(LogStatus.FAIL, "selectDataelement failed", test.addScreenCapture(screenshotPath));
		}

		Thread.sleep(12000);
	}

	// SaveLayout code
	public void SavelayOut(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(selectdataelements));
			selectdataelements.click();
			Thread.sleep(7000);
			System.out.println("dropdown clicked with locator as " + manualselectelementdropdown);
			js.executeScript("arguments[0].click();", manualselectelementdropdown);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(shipfromcompanycheckbox));
			shipfromcompanycheckbox.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(clickok));
			clickok.click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(SavelayoutButton));
			SavelayoutButton.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(commententered));
			commententered.sendKeys("savelayoutformanual");
			wait.until(ExpectedConditions.elementToBeClickable(Click_onsavebutton));
			Click_onsavebutton.click();
			Thread.sleep(3000);
			String str = driver.findElement(By.xpath("//*[@class='menu-item']/select")).getText();

			if (str.contains("savelayoutformanual")) {
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "SavelayOut Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "SavelayOut Passed", test.addScreenCapture(screenshotPath));
			} else {
				test.log(LogStatus.FAIL, "SavelayOut Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "SavelayOut failed", test.addScreenCapture(screenshotPath));

			}

		} catch (Exception e) {

		}
		Thread.sleep(12000);
	}

	public void checkSelectedRows(List<WebElement> rows) throws InterruptedException {
		Iterator rowsIterator = rows.iterator();
		while (rowsIterator.hasNext()) {
			WebElement row = (WebElement) rowsIterator.next();
			Thread.sleep(12000);
			row.findElement(By.tagName("input")).click();

		}
	}

	public void isCommentHistory(WebElement row, String CommentedValue, WebDriverWait wait, WebDriver driver,
			ExtentTest test) throws Exception {
		Boolean isEvaluated;
		Thread.sleep(15000);
		WebElement selectedBurgerIcon = row.findElement(By.xpath("//*[@class='info']/i"));
		wait.until(ExpectedConditions.elementToBeClickable(selectedBurgerIcon));
		selectedBurgerIcon.click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.elementToBeClickable(clickcommenthistory));
		clickcommenthistory.click();
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[1];",
				driver.findElement(By.xpath("//*[@id='clientSidenav']/div[2]/div/div[1]")), 3000);

		List<WebElement> commentBlocks = driver.findElements(By.xpath("//*[@class='comment-block']"));
		WebElement lastCommentBlock = commentBlocks.get(commentBlocks.size() - 1);
		String commentedHistoryValue = lastCommentBlock.findElement(By.className("desc")).getText();
		Thread.sleep(2000);
		isEvaluated = CommentedValue.equals(commentedHistoryValue);

		if (isEvaluated) {
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "manualaddcomment1 passed ");
			String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
			test.log(LogStatus.PASS, "manualaddcomment1 passed", test.addScreenCapture(screenshotPath));
		} else {
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "manualaddcomment1 Failed");
			String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
			test.log(LogStatus.FAIL, "manualaddcomment1 Failed", test.addScreenCapture(screenshotPath));
		}
		wait.until(ExpectedConditions.elementToBeClickable(sliderclose));
		sliderclose.click();
	}

	public void isCommentsHistory(List selectedRows, String commentedValue, WebDriverWait wait, WebDriver driver,
			ExtentTest test) throws Exception {
		Boolean isEvaluated = true;
		Iterator rowIterator = selectedRows.iterator();

		while (rowIterator.hasNext()) {
			WebElement row = (WebElement) rowIterator.next();
			isCommentHistory(row, commentedValue, wait, driver, test);
			{
				isEvaluated = false;
			}
		}
	}

	public void manualaddcomment1(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {

		String manualaddcomment1 = "manualaddcomment1";
		List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
		List<WebElement> selectedRows = Auditorqueue.getRandomSubList(rows, true);
		checkSelectedRows(selectedRows);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(click_invoicenimber));
			click_invoicenimber.click();
			List<WebElement> rows1 = driver.findElements(By.xpath("//*[@class='vui-list']/div/div/input"));
			if (rows.size() != 0) {
				for (int i = 1; i <= rows.size(); i++) {
					WebElement findElement = driver
							.findElement(By.xpath("//*[@class='vui-list']/div/div[" + i + "]/input"));
					findElement.click();
					if (i == 4) {
						break;
					}
				}
			}
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonapply));
			clickonapply.click();
			Thread.sleep(20000);
			rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
			selectedRows = Auditorqueue.getRandomSubList(rows, true);
			Thread.sleep(5000);
			checkSelectedRows(selectedRows);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(clickmanualaddcoment));
			clickmanualaddcoment.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(entercomment));
			entercomment.sendKeys("manualaddcomment1");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonsubmit));
			clickonsubmit.click();
			Thread.sleep(5000);
			checkSelectedRows(selectedRows);
			Thread.sleep(5000);
			isCommentsHistory(selectedRows, manualaddcomment1, wait, driver, test);
			Thread.sleep(10000);
			checkSelectedRows(selectedRows);
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(clickonclearbutton));
			clickonclearbutton.click();

		} catch (Exception e) {

		}
		Thread.sleep(12000);
	}

	public void SendtoclientManual(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {

		try {
			String commentforsendtoclient = "addcomment";

			List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
			List<WebElement> selectedRows = Auditorqueue.getRandomSubList(rows, true);
			checkSelectedRows(selectedRows);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(click_addcomment));
			click_addcomment.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(type_comment));
			type_comment.sendKeys(commentforsendtoclient);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();
			Thread.sleep(10000);
			checkSelectedRows(selectedRows);
			Thread.sleep(5000);

			int countBefore = stringtointeger(manualauditworkspacecount.getText());

			WebElement scroll = driver.findElement(By.xpath(
					"//datatable-row-wrapper[1]/datatable-body-row/descendant::datatable-body-cell[20]//div[@class='datatable-body-cell-label']/div"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", scroll);

			wait.until(ExpectedConditions.elementToBeClickable(clicksendtoclientmanualbutton));
			clicksendtoclientmanualbutton.click();
			Thread.sleep(5000);
			clickclosebutton.click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOf(updatedsuccessfully));
			int countAfter = stringtointeger(manualauditworkspacecount.getText());
			Boolean isTestPassed = ((countBefore - selectedRows.size()) == (countAfter));
			if (updatedsuccessfully.getText().equalsIgnoreCase("Updated Successfully") && isTestPassed) {
				test.log(LogStatus.PASS, "SendtoclientManual Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "SendtoclientManual Passed", test.addScreenCapture(screenshotPath));
			} else {
				test.log(LogStatus.FAIL, "SendtoclientManual Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "SendtoclientManual failed", test.addScreenCapture(screenshotPath));
				checkSelectedRows(selectedRows);
			}
		} catch (Exception e) {
			Thread.sleep(12000);
		}
	}

	public void SendtoCarriermanual(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {

		try {
			String commentforsendtocarrier = "addcomment";
			List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
			List<WebElement> selectedRows = Auditorqueue.getRandomSubList(rows, true);
			checkSelectedRows(selectedRows);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(click_addcomment));
			click_addcomment.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(type_comment));
			type_comment.sendKeys(commentforsendtocarrier);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(submit));
			submit.click();
			Thread.sleep(5000);
			checkSelectedRows(selectedRows);
			Thread.sleep(5000);
			int countBefore = stringtointeger(manualauditworkspacecount.getText());

			WebElement scroll = driver.findElement(By.xpath(
					"//datatable-row-wrapper[1]/datatable-body-row/descendant::datatable-body-cell[20]//div[@class='datatable-body-cell-label']/div"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", scroll);

			wait.until(ExpectedConditions.elementToBeClickable(clicksendtoclientmanualbutton));
			clicksendtocarrierbutton.click();
			Thread.sleep(3000);
			clickclosebutton.click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOf(updatedsuccessfully));
			int countAfter = stringtointeger(manualauditworkspacecount.getText());
			Boolean isTestPassed = ((countBefore - selectedRows.size()) == (countAfter));
			if (updatedsuccessfully.getText().equalsIgnoreCase("Updated Successfully") && isTestPassed) {
				test.log(LogStatus.PASS, "SendtoCarriermanual Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "SendtoCarriermanual Passed", test.addScreenCapture(screenshotPath));

			} else {
				test.log(LogStatus.FAIL, "SendtoCarriermanual Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "SendtoCarriermanual failed", test.addScreenCapture(screenshotPath));
				checkSelectedRows(selectedRows);
			}
		} catch (Exception e) {

		}
		Thread.sleep(12000);
	}

	public void InsertauditResult(WebDriverWait wait, WebDriver driver, ExtentTest test) throws Exception {
		int countBefore = stringtointeger(manualauditworkspacecount.getText());
		List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
		Iterator rowIterator = rows.iterator();
		ArrayList filteredRows = new ArrayList<>();
		String validationIconXpath = "datatable-body-row/descendant::datatable-body-cell[16]//div[@class='datatable-body-cell-label']/div/span/i";
		WebElement scroll = driver.findElement(By.xpath(
				"//datatable-row-wrapper[1]/datatable-body-row/descendant::datatable-body-cell[18]//div[@class='datatable-body-cell-label']/div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", scroll);

		while (rowIterator.hasNext()) {
			WebElement row = (WebElement) rowIterator.next();
			if (row.findElements(By.xpath(validationIconXpath)).size() == 0) {
				filteredRows.add(row);
				break;
			}
		}

		checkSelectedRows(filteredRows);
		Thread.sleep(3000);
		if (filteredRows.size() == 0) {
			test.log(LogStatus.SKIP, "InsertauditResult: - No data");
			String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
			test.log(LogStatus.SKIP, "InsertauditResult: - No data", test.addScreenCapture(screenshotPath));
			return;
		}
		if (!Insertauditresultbutton.getAttribute("class").contains("disabled")) {
			Insertauditresultbutton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(Potentialauditcodedropdownforinsert));
		Potentialauditcodedropdownforinsert.click();

		wait.until(ExpectedConditions.elementToBeClickable(selectpotentialauditcode));
		selectpotentialauditcode.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Auditamountformanualforindert));
		Auditamountformanualforindert.sendKeys("10");

		wait.until(ExpectedConditions.elementToBeClickable(AuditDetailsforinsert));
		AuditDetailsforinsert.sendKeys("test");

		wait.until(ExpectedConditions.elementToBeClickable(insertmanualauditsubmitbutton));
		insertmanualauditsubmitbutton.click();
		Thread.sleep(3000);

		try {
			if (NotabletofindCarrier.isDisplayed()) {
				Thread.sleep(1000);
				closebuttonclick.click();
				System.out.println("errormrssagereached");
				checkSelectedRows(filteredRows);
				test.log(LogStatus.PASS, "InsertauditResult Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "InsertauditResult Passed", test.addScreenCapture(screenshotPath));

			}
			wait.until(ExpectedConditions.visibilityOf(updatedsuccessfully));
			int countAfter = stringtointeger(manualauditworkspacecount.getText());
			Boolean isTestPassed = ((countBefore + filteredRows.size()) == (countAfter));

			if (updatedsuccessfully.getText().equalsIgnoreCase("Updated Successfully") && isTestPassed) {
				test.log(LogStatus.PASS, "InsertauditResult Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "InsertauditResult Passed", test.addScreenCapture(screenshotPath));

			} else {
				test.log(LogStatus.FAIL, "InsertauditResult Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "InsertauditResult failed", test.addScreenCapture(screenshotPath));
			}
		} catch (Exception e) {

		}
		Thread.sleep(10000);
	}

	public void CompleteValidation(WebDriverWait wait, WebDriver driver, ExtentTest test)
			throws InterruptedException, IOException {
		try {
			int countBefore = stringtointeger(manualauditworkspacecount.getText());
			List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
			Iterator rowIterator = rows.iterator();
			ArrayList filteredRows = new ArrayList<>();

			String validationIconXpath = "datatable-body-row/descendant::datatable-body-cell[16]//div[@class='datatable-body-cell-label']/div/span/i";

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = arguments[1];",
					driver.findElement(By.xpath("/html/body/aem-app/aem-home/div/app-manualaudits/div/div")), 3000);

			while (rowIterator.hasNext()) {
				WebElement row = (WebElement) rowIterator.next();
				if (row.findElements(By.xpath(validationIconXpath)).size() == 0) {
					filteredRows.add(row);
					break;
				}
			}
			checkSelectedRows(filteredRows);
			Thread.sleep(2000);

			if (filteredRows.size() == 0) {
				test.log(LogStatus.SKIP, "CompleteValidation: - No data");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.SKIP, "CompleteValidation: - No data", test.addScreenCapture(screenshotPath));
				return;
			}

			if (!completevalidationbutton.getAttribute("class").contains("disabled")) {
				completevalidationbutton.click();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(completevalidationokbutton));
				completevalidationokbutton.click();
				Thread.sleep(5000);
			} else {

				checkSelectedRows(filteredRows);
			}
			// Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(updatedsuccessfully));
			int countAfter = stringtointeger(manualauditworkspacecount.getText());
			Boolean isTestPassed = ((countBefore - filteredRows.size()) == (countAfter));

			if (updatedsuccessfully.getText().equalsIgnoreCase("Updated Successfully") && isTestPassed) {
				test.log(LogStatus.PASS, "CompleteValidation Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "CompleteValidation Passed", test.addScreenCapture(screenshotPath));

			} else {
				test.log(LogStatus.FAIL, "CompleteValidation Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "CompleteValidation failed", test.addScreenCapture(screenshotPath));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(12000);
	}

	public void NonAuditedcharge(WebDriverWait wait, WebDriver driver, ExtentTest test)
			throws IOException, InterruptedException {
		try {
			int countBefore = stringtointeger(manualauditworkspacecount.getText());
			List<WebElement> rows = table.findElements(By.xpath("//*[@class='datatable-row-wrapper']"));
			Iterator rowIterator = rows.iterator();
			ArrayList filteredRows = new ArrayList<>();
			String validationIconXpath = "datatable-body-row/descendant::datatable-body-cell[16]//div[@class='datatable-body-cell-label']/div/span/i";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollTop = arguments[1];",
					driver.findElement(By.xpath("/html/body/aem-app/aem-home/div/app-manualaudits/div/div")), 3000);

			while (rowIterator.hasNext()) {
				WebElement row = (WebElement) rowIterator.next();
				if (row.findElements(By.xpath(validationIconXpath)).size() == 0) {
					filteredRows.add(row);
					break;
				}
			}

			checkSelectedRows(filteredRows);
			Thread.sleep(2000);

			if (filteredRows.size() == 0) {
				test.log(LogStatus.SKIP, "NonAuditedcharge: - No data");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.SKIP, "NonAuditedcharge: - No data", test.addScreenCapture(screenshotPath));
				return;
			}

			/*
			 * List<WebElement> selectedRows =
			 * Auditorqueue.getRandomSubList(rows, true);
			 * checkSelectedRows(selectedRows);
			 */

			Thread.sleep(5000);
			if (!noncargebutton.getAttribute("class").contains("disabled")) {
				noncargebutton.click();
				wait.until(ExpectedConditions.elementToBeClickable(auditchargeokbutton));
				auditchargeokbutton.click();
			}

			else {

				checkSelectedRows(filteredRows);
			}

			wait.until(ExpectedConditions.visibilityOf(updatedsuccessfully));
			int countAfter = stringtointeger(manualauditworkspacecount.getText());
			Boolean isTestPassed = ((countBefore - filteredRows.size()) == (countAfter));
			if (updatedsuccessfully.getText().equalsIgnoreCase("Updated Successfully") && isTestPassed) {
				test.log(LogStatus.PASS, "NonAuditedcharge Passed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", true);
				test.log(LogStatus.PASS, "NonAuditedcharge Passed", test.addScreenCapture(screenshotPath));
				Thread.sleep(3000);
			} else {
				test.log(LogStatus.FAIL, "NonAuditedcharge Failed");
				String screenshotPath = GetScreenshot.getScreenshot(browser.driver, "screenShots", false);
				test.log(LogStatus.FAIL, "NonAuditedcharge failed", test.addScreenCapture(screenshotPath));
				// checkSelectedRows(filteredRows);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.sleep(10000);

	}

	public void selectingAudit(WebDriverWait wait, WebDriver driver, ExtentTest test)
			throws IOException, InterruptedException {
		List<WebElement> rows = driver.findElements(By.xpath("//datatable-row-wrapper"));

		for (int row = 0; row < rows.size(); row++) {
			String value = rows.get(row)
					.findElement(By
							.xpath("datatable-body-row/descendant::datatable-body-cell[7]//div[@class='datatable-body-cell-label']/div"))
					.getText();
			System.out.println(value);

			if (!(value.equalsIgnoreCase("0") || value.equalsIgnoreCase("1") || value.equalsIgnoreCase("2")))
				rows.get(row)
						.findElement(By.xpath(
								"//datatable-row-wrapper[" + ++row + "]/datatable-body-row/div[1]/descendant::input"))
						.click();
			else
				continue;
			break;
		}

		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(manualproceed));
		manualproceed.click();
		Thread.sleep(3000);
		String str = driver.findElement(By.xpath("//*[@class='menubars']/div")).getText();
		if (str.contains("Manual Audit Workspace")) {
		}
		Thread.sleep(8000);
	}

	public int stringtointeger(String input) {
		if (input.contains(",")) {
			input = input.replace(",", "");
		}

		String result = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
		if (result.contains(")")) {
			result = result.replace(")", "");
		}

		result = result.replace(")", "");
		return Integer.parseInt(result.trim());
	}
}
