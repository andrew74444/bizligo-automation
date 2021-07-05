package com.cpcommunity.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TenantAdminDashboardPage extends BasePage{

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		waitForElementToPresent(PageTitle);
		return ExpectedConditions.visibilityOf(PageTitle);
	}

	@Override
	protected void getPageScreenSot() {
		// TODO Auto-generated method stub
		updateClass(pageheader, "");
		aShot();
	}
	@FindBy(xpath = "//div[@class='nav_menu']")
	WebElement pageheader;
	@FindBy(xpath = "//h3[normalize-space()='Tenant Admin Dashboard']")
	WebElement PageTitle;
	@FindBy(xpath="//a[normalize-space()='Import Contacts']")
	WebElement ImportContacts;
	@FindBy(xpath="//a[normalize-space()='Manage Campaign']")
	WebElement manageCampaign;
	@FindBy(xpath="//a[normalize-space()='Campaign Template']")
	WebElement campaignTemplate;
	@FindBy(xpath="//a[normalize-space()='Manage Resources']")
	WebElement manageresource;
	@FindBy(xpath="//a[normalize-space()='Compose Campaign']")
	WebElement composeCampaign;
	 @FindBy(xpath="//a[@title='Go to Member site home']")
	 WebElement bizligoBtn;

public ComposeCampaign navigateToComposeCampaignPage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(composeCampaign);
	this.composeCampaign.click();	
	//click(composeCampaign, "composeCampaign");
	return (ComposeCampaign) openPage(ComposeCampaign.class);
	
}
public ImportContactsPage navigateToImportContactsPagePage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(ImportContacts);
	this.ImportContacts.click();	
	//click(composeCampaign, "composeCampaign");
	return (ImportContactsPage) openPage(ImportContactsPage.class);
	
}
public CampaignTemplatePage navigateToCampaignTemplate() throws Exception {
	scrollDownVertically();
	scrollToElement(manageCampaign);
	click(manageCampaign, "manageCampaign");
	Thread.sleep(500);
	waitForElementToPresent(campaignTemplate);
	this.campaignTemplate.click();	
	//click(composeCampaign, "composeCampaign");
	return (CampaignTemplatePage) openPage(CampaignTemplatePage.class);
	
}
public ManageResourcesPage navigateToManageResourcesPage() throws Exception {
	scrollDownVertically();
	scrollToElement(manageresource);
	click(manageresource, "manageresource");
	return (ManageResourcesPage) openPage(ManageResourcesPage.class);
	
}
public HomePage goToHomePage() {
	 
	click(bizligoBtn,"Bizligo button");
	
	return (HomePage) openPage(HomePage.class);

}
}