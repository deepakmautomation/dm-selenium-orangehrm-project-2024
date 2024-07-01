package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_dashboardPage {

	private WebDriver _driver;

	By dashboard = By.xpath("//div[@class='oxd-topbar-header-title']/child::span/h6");
	By PIM = By.xpath("//a[@class='oxd-main-menu-item']/span[text()='PIM']");
	By profileName = By.className("oxd-userdropdown-tab");
	By logout = By.linkText("Logout");

	public OrangeHRM_dashboardPage(WebDriver ddriver) {
		this._driver = ddriver;
	}

	public String getDashboardHedertext() {
		String dashboardText = _driver.findElement(dashboard).getText();
		return dashboardText;
	}
	
	public OrangeHRM_PIMPage clickOnPIM() {
	 	_driver.findElement(PIM).click();
	 	return new OrangeHRM_PIMPage(_driver);
	}
	
	public void clickOnLogout() {
		_driver.findElement(profileName).click();
		_driver.findElement(logout).click();
	}
	

}
