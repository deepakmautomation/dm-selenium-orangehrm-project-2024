package com.dvm.qa.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_PIM_viewPersonalDetailsPage {

	private WebDriver _driver;


	By personalDeatilsHeaderText = By.xpath("//div[@class='orangehrm-edit-employee-content']/child::div/h6");
	By empolyeeName = By.xpath("//div[@class='orangehrm-edit-employee-name']/child::h6");



	public OrangeHRM_PIM_viewPersonalDetailsPage(WebDriver pdriver) {
		this._driver = pdriver;
	}

	public String getPersonalDetailsHeaderText() {
		return _driver.findElement(personalDeatilsHeaderText).getText();
	}

	public String getEmployeeName() {
		WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(empolyeeName));
		return _driver.findElement(empolyeeName).getText();
	}

	

}
