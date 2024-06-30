package com.dvm.qa.selenium.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.OrangeHRM_ResetPasswordPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_ResetPasswordPageTest {

	WebDriver _driver;
	TestBase testBase; 
	OrangeHRM_loginPage loginPage;
	OrangeHRM_ResetPasswordPage resetPasswordPage;

	@BeforeMethod
	public void setUp() throws IOException {
		testBase = new TestBase();
		_driver = testBase.launchBrowser();
		loginPage = new OrangeHRM_loginPage(_driver);
		resetPasswordPage = new OrangeHRM_ResetPasswordPage(_driver);
	}

	@Test
	public void verifyResetPasswordHeader() {
		loginPage.clickOnForgotPasswordLink();
		String actualResetPasswordPageHeaderText = resetPasswordPage.getResetPasswordHeaderText();
		Assert.assertEquals(actualResetPasswordPageHeaderText, "Reset Password");	
	}

	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}

}