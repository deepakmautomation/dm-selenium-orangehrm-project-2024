package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_PIMPage {

	private WebDriver _driver;

	By PIMHeaderText = By.xpath("//h6[text()='PIM']");
	By addEmployeeLink = By.linkText("Add Employee");

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

}
