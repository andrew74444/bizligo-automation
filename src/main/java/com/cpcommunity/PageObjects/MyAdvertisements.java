package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAdvertisements extends BasePage {

	@FindBy(xpath = "//h3[contains(text(),'My Advertisements')]")
	WebElement title;
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	WebElement createGlobalAd;
	@FindBy(xpath = "//*[contains(text(),'Next')]")
	WebElement next;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		log.info("---> MyAdvertisements");
		return ExpectedConditions.visibilityOf(title);
	}

	public AdvertismentPurchasePage createAd() {
		click(createGlobalAd,"createGlobalAd");
		return(AdvertismentPurchasePage) openPage(AdvertismentPurchasePage.class);
	}
	@FindBy(xpath = "//*[@id='header']")
	WebElement pageheader;
	@Override
	protected  void getPageScreenSot() {
	
		updateClass(pageheader, "");
		aShot();
		updateClass(pageheader, "navbar-fixed-top");
	}

}
