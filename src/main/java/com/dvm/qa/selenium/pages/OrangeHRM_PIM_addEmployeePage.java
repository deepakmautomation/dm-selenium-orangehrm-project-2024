package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_PIM_addEmployeePage {

	private WebDriver _driver;

	By addEmployeeHeaderText = By.xpath("//h6[text()='Add Employee']");
	By firstName = By.name("firstName");
	By middleName = By.name("middleName");
	By lastName = By.name("lastName");
	By employeeID = By.xpath("//div[@class='oxd-form-row']/child::div[2]/descendant::input");
	By saveButton = By.xpath("//button[@type='submit']");

	public OrangeHRM_PIM_addEmployeePage(WebDriver adriver) {
		this._driver = adriver;
	}

	public String getAddEmployeeHeaderText() {
		return _driver.findElement(addEmployeeHeaderText).getText();
	}

	public OrangeHRM_PIM_viewPersonalDetailsPage enterEmployeeFullName(String fname, String mname, String lname)throws InterruptedException {
		_driver.findElement(firstName).sendKeys(fname);
		_driver.findElement(middleName).sendKeys(mname);
		_driver.findElement(lastName).sendKeys(lname);
		//String EmployeeID =  _driver.findElement(employeeID).getText();
		_driver.findElement(saveButton).click();
		Thread.sleep(3000);
		return new OrangeHRM_PIM_viewPersonalDetailsPage(_driver);

	}
}
