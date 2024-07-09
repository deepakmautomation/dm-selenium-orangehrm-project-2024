package com.dvm.qa.selenium.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	By logoImage = By.xpath("//div[@class='orangehrm-login-branding']/img[contains(@src,'/web/images/ohrm_branding.png?v=1711595107870')]");


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
	
	public boolean checkLogoAvaialbility() {
		WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(logoImage));
		 return _driver.findElement(logoImage).isDisplayed();
	}

}
