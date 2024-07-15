package com.dvm.qa.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM_PIMPage {

	private WebDriver _driver;

	By PIMHeaderText = By.xpath("//h6[text()='PIM']");
	By addEmployeeLink = By.linkText("Add Employee");
	By employeeList = By.xpath("//a[contains(text(),'Employee List')]");

	public OrangeHRM_PIMPage(WebDriver pdriver) {
		this._driver = pdriver; 
	}

	public String getPIMHeaderText() {
		return _driver.findElement(PIMHeaderText).getText();
	}

	public OrangeHRM_PIM_addEmployeePage clickOnAddEmployee() {
		_driver.findElement(addEmployeeLink).click();
		return new OrangeHRM_PIM_addEmployeePage(_driver);
	}

	public OrangeHRM_PIM_viewEmployeeListPage clickOnEmployeeList() {
		WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(employeeList));
		_driver.findElement(employeeList).click();
		return new OrangeHRM_PIM_viewEmployeeListPage(_driver);
	}

}
