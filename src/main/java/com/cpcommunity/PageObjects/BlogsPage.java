package com.cpcommunity.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BlogsPage extends BasePage {

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(SearchBtn);
	}

	@Override
	protected void getPageScreenSot() {

		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;

	@FindBy(xpath = "//select")
	WebElement selectCommuntiy;
	@FindBy(xpath = "//*[@id='term']")
	WebElement blogsPostName;
	@FindBy(xpath = "//button[contains(.,' Search')]")
	WebElement SearchBtn;

	public void searchPost(String communityName, String blogName) {
		communityName =communityName+" "+date();
		selectByVisibleText(selectCommuntiy, communityName, "selecting Communtiy");
		type(blogsPostName, blogName, "Post Name to search");
		click(SearchBtn, "Search");
		
			WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'" + blogName + "')]"));
			waitForElementToPresent(ele);
			ele.isDisplayed();
		

		

	}

}
