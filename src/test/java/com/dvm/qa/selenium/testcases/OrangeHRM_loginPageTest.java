package com.dvm.qa.selenium.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.OrangeHRM_dashboardPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_loginPageTest {

	private WebDriver _driver;
	TestBase testbase;
	OrangeHRM_loginPage loginpage;
	OrangeHRM_dashboardPage dashboardpage;

	@BeforeMethod
	public void setup() throws IOException {
		testbase = new TestBase();
		_driver = testbase.launchBrowser();
		loginpage = new OrangeHRM_loginPage(_driver);
	}

	@Test
	public void verify_OrangeHRM_Login() {
		dashboardpage = loginpage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
		Assert.assertEquals(dashboardpage.getDashboardHedertext(), "Dashboard");
	}

	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}
}
