package com.dvm.qa.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_loginPage  extends TestBase{

	private WebDriver _driver;

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	By invalidcreds = By.xpath("//div[@class='orangehrm-login-form']/descendant::p[text()='Invalid credentials']");
	By usernameRequiredWarningtxt  = By.xpath("//div[@class='oxd-form-row'][1]/descendant::span");
	By passwordRequiredWarningtxt = By.xpath("//div[@class='oxd-form-row'][2]/descendant::span");
	By forgotPasswordLink = By.xpath("//div[@class='orangehrm-login-forgot']/p");

	public OrangeHRM_loginPage(WebDriver ldriver) throws IOException {
		super();
		this._driver = ldriver;
	}

	public OrangeHRM_dashboardPage login(String uname, String pwd) {
		_driver.findElement(username).sendKeys(uname);
		_driver.findElement(password).sendKeys(pwd);
		_driver.findElement(loginBtn).click();
		return new OrangeHRM_dashboardPage(_driver);
	}

	public String getInvalidCredentialsWarningText() {
		return _driver.findElement(invalidcreds).getText();
	}

	public String getUserNameRequiredWarning() {
		return _driver.findElement(usernameRequiredWarningtxt).getText();
	}

	public String getPasswordRequiredWarning() {
		return _driver.findElement(passwordRequiredWarningtxt).getText();
	}

	public void clickOnForgotPasswordLink() {
		_driver.findElement(forgotPasswordLink).click();
	}

}
