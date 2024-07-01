package com.dvm.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_ResetPasswordPage {
	
	 private WebDriver _driver;
	
	By resetPasswordheader = By.xpath("//div[@class='orangehrm-card-container']/child::form/child::h6");
	
	
	public OrangeHRM_ResetPasswordPage(WebDriver rdriver) {
		this._driver = rdriver;
	}
	
	public String getResetPasswordHeaderText() {
		 return _driver.findElement(resetPasswordheader).getText();
	}

}
