package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_dashboardPage {

	private WebDriver _driver;

	By dashboard = By.xpath("//div[@class='oxd-topbar-header-title']/child::span/h6");

	public OrangeHRM_dashboardPage(WebDriver ddriver) {
		this._driver = ddriver;
	}

	public String getDashboardHedertext() {
		String dashboardText = _driver.findElement(dashboard).getText();
		return dashboardText;
	}

}
