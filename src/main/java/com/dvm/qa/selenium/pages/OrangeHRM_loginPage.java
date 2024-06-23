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

}
