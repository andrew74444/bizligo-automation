package com.uiFramework.pamTen.cpcommunity.helper.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.Format;
import java.util.Calendar;

public class DateManager {

	private WebDriver driver;
	private Calendar now;

	public DateManager(WebDriver driver) {
		this.driver = driver;
		now = Calendar.getInstance();

	}

	// Get Full Month Name from a given Date

	public String getMonthYearNameFromString(String value) throws Exception {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = df.parse(value);
		Format formatter = new SimpleDateFormat("MMMM");
		String s = formatter.format(d1);
		System.out.println(s);
		System.out.println("Date: " + d1);
		System.out.println("Date in dd/MM/yyyy format is: " + df.format(d1));
		return s;
	}

	public int getCurrentDate() {

		return now.get(Calendar.DATE);
	}

	public int getCurrentMonth() {

		return now.get(Calendar.MONTH) + 1;

	}

	public int getCurrentyear() {

		return now.get(Calendar.YEAR);
	}

	public String getCurrentDateString() {
		String[] dateName = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		String date = dateName[getCurrentDate() - 1];
		return date;
	}

	public String getCurrentMonthString() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String month = monthName[getCurrentMonth()];
		System.out.println(month);
		return month;
	}

	public void selectDate(String tableName, String dateToSelect) throws Exception {
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				
				
				WebElement ele = driver.findElement(By.xpath("" + tableName + "//tbody/tr[" + i + "]/td[" + j + "]"));
				if (dateToSelect.equalsIgnoreCase(ele.getText())) {
					String classes = ele.getAttribute("class");
					for (String c : classes.split(" ")) {
						if (c.equals("old") || c.equals("disabled")) {
							
						} else {
							ele.click();
							return;
						}
					}
				}
			}
		}
	}

	// to run this on stand alone
	public static void main(String arg[]) throws Exception {

		// DateManager d = new DateManager(null);
		// d.getMonthYearNameFromString("30/09/2019");
		// System.out.println(d.getCurrentDate());
		// System.out.println(d.getCurrentDateString());

	}

}
// https://www.javatpoint.com/java-string-to-date

// String testDateString = "02/04/2014";
// DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
// Date d1 = df.parse(testDateString);
// System.out.println("Date: " + d1);
// System.out.println("Date in dd/MM/yyyy format is: "+df.format(d1));
//
// Format formatter = new SimpleDateFormat("MMMM");
// String s = formatter.format(d1);
// System.out.println(s);