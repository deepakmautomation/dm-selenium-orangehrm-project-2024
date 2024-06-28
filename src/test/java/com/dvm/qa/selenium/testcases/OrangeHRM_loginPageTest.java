package com.dvm.qa.selenium.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.OrangeHRM_dashboardPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;
import com.dvm.qa.selenium.util.DataProviderClass;
import com.dvm.qa.selenium.util.Takescreenshot;

@Listeners(com.dvm.qa.selenium.util.Listener.class)
public class OrangeHRM_loginPageTest {

	private WebDriver _driver;
	TestBase testbase;
	OrangeHRM_loginPage loginpage;
	OrangeHRM_dashboardPage dashboardpage;
	Takescreenshot takescreenshot;


	@BeforeMethod
	public void setup() throws IOException {
		testbase = new TestBase();
		_driver = testbase.launchBrowser();
		loginpage = new OrangeHRM_loginPage(_driver);
		takescreenshot = new Takescreenshot(_driver);
	}

	@Test
	public void verify_OrangeHRM_Login_with_valid_credentials() throws IOException {
		dashboardpage = loginpage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
		Assert.assertEquals(dashboardpage.getDashboardHedertext(), "Dashboard");
	}

	@Test(dataProvider="dataProvidertest", dataProviderClass = DataProviderClass.class)
	public void verify_Orange_HRM_Login_with_Invalid_Credentials(String uname, String pwd) {
		 dashboardpage = loginpage.login(uname, pwd);
		 Assert.assertEquals(loginpage.getInvalidCredentialsWarningText(), "Invalid credentials");
	}

	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}
}
