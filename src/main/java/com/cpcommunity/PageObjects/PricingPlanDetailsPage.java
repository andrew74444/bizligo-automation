package com.cpcommunity.PageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingPlanDetailsPage extends BasePage {

	@FindBy(xpath = "//h2[contains(text(),'Pricing Plan Details')]")
	WebElement pricingPlanDetailsTitle;

	@FindBy(xpath = "")
	WebElement disabled;

	public void checkFeaturedisbled(String feature) {
		driver.findElement(By.xpath("((//*[@class='row plan-detail-cont'])[2]//*[contains(text(),'" + feature
				+ "')]/..)//i[@class='fa fa-times-circle']"));
	}

	public void checkFeatureEnabled(String feature) {
		driver.findElement(By.xpath("((//*[@class='row plan-detail-cont'])[2]//*[contains(text(),'" + feature
				+ "')]/..)//i[@class='fa fa-check-circle-o']"));
	}

	public void checkPlanDetails(HashMap<String, String> ftr_list) {

		if (ftr_list.containsKey("Events")) {
			checkFeatureEnabled("Events");
		} else {
			checkFeaturedisbled("Events");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
		if (ftr_list.containsKey("")) {
			checkFeatureEnabled("");
		} else {
			checkFeaturedisbled("");
		}
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(pricingPlanDetailsTitle);
	}

	@Override
	protected void getPageScreenSot() {
		aShot();

	}

}
