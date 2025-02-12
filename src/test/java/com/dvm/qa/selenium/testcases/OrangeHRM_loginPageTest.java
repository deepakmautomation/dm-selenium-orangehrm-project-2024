package com.dvm.qa.selenium.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dvm.qa.selenium.pages.OrangeHRM_dashboardPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;
import com.dvm.qa.selenium.util.DataProviderClass;
import com.dvm.qa.selenium.util.ExtentReportcls;
import com.dvm.qa.selenium.util.Takescreenshot;


public class OrangeHRM_loginPageTest {

	private WebDriver _driver;
	TestBase testbase;
	OrangeHRM_loginPage loginpage;
	OrangeHRM_dashboardPage dashboardpage;
	Takescreenshot takescreenshot;
	ExtentReportcls exterepo;

	@BeforeTest
	public void reportSetup() {
	exterepo = new ExtentReportcls();	
	exterepo.getReport();
	}
	
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void setup(String browserName) throws IOException, URISyntaxException {
		testbase = new TestBase();
		_driver = testbase.launchBrowser(browserName);
		loginpage = new OrangeHRM_loginPage(_driver);
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
	
	@Test
	public void verify_Orange_hrm_logo_present() throws InterruptedException {
		assertTrue(loginpage.checkLogoAvaialbility());
	}

	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}
	
	@AfterTest
	public void reportgen() {
		ExtentReportcls.extent.flush();
	}
	
	
}
