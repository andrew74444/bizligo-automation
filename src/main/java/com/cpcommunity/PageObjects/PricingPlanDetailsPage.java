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
		if (ftr_list.containsKey("Advertisements")) {
			checkFeatureEnabled("Advertisements");
		} else {
			checkFeaturedisbled("Advertisements");
		}
		if (ftr_list.containsKey("Manage Campaign")) {
			checkFeatureEnabled("Manage Campaign");
		} else {
			checkFeaturedisbled("Manage Campaign");
		}
		if (ftr_list.containsKey("Payment Gateways")) {
			checkFeatureEnabled("Payment Gateways");
		} else {
			checkFeaturedisbled("Payment Gateways");
		}
		if (ftr_list.containsKey("Groups")) {
			checkFeatureEnabled("Groups");
		} else {
			checkFeaturedisbled("Groups");
		}
		if (ftr_list.containsKey("Zoom")) {
			checkFeatureEnabled("Zoom");
		} else {
			checkFeaturedisbled("Zoom");
		}
		if (ftr_list.containsKey("Surveys")) {
			checkFeatureEnabled("Surveys");
		} else {
			checkFeaturedisbled("Surveys");
		}
		if (ftr_list.containsKey("Membership Plans")) {
			checkFeatureEnabled("Membership Plans");
		} else {
			checkFeaturedisbled("Membership Plans");
		}
		if (ftr_list.containsKey("CRM")) {
			checkFeatureEnabled("CRM");
		} else {
			checkFeaturedisbled("CRM");
		}
		if (ftr_list.containsKey("Blog")) {
			checkFeatureEnabled("Blog");
		} else {
			checkFeaturedisbled("Blog");
		}
		
		if (ftr_list.containsKey("Member Activity Report")) {
			checkFeatureEnabled("Member Activity Report");
		} else {
			checkFeaturedisbled("Member Activity Report");
		}
		
		if (ftr_list.containsKey("Community Members")) {
			checkFeatureEnabled("Community Members");
		} else {
			checkFeaturedisbled("Community Members");
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
