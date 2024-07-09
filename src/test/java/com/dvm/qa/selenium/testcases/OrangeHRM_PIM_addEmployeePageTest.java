package com.dvm.qa.selenium.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.OrangeHRM_PIMPage;
import com.dvm.qa.selenium.pages.OrangeHRM_PIM_addEmployeePage;
import com.dvm.qa.selenium.pages.OrangeHRM_PIM_viewPersonalDetailsPage;
import com.dvm.qa.selenium.pages.OrangeHRM_dashboardPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_PIM_addEmployeePageTest {

	private WebDriver _driver;
	TestBase testBase;
	OrangeHRM_loginPage loginPage;
	OrangeHRM_PIM_addEmployeePage addemployee;
	OrangeHRM_dashboardPage dashboard;
	OrangeHRM_PIMPage pim;
	OrangeHRM_PIM_viewPersonalDetailsPage personalDetails;

	@Parameters({"browserName"})
	@BeforeMethod
	public void setUp(String browserName) throws IOException, URISyntaxException {
		testBase = new TestBase();
		_driver =  testBase.launchBrowser(browserName);
		loginPage = new OrangeHRM_loginPage(_driver);
	}

	@Test
	public void verifyAdminCanAddEmployee() throws InterruptedException, AWTException{
		dashboard = loginPage.login(TestBase.prop.getProperty("username"),TestBase.prop.getProperty("password"));
		pim = dashboard.clickOnPIM();
		Assert.assertEquals(pim.getPIMHeaderText(), "PIM");
		addemployee =  pim.clickOnAddEmployee();
		personalDetails =  addemployee.enterEmployeeFullName("John21", "S", "Smith1", "John21", "Admin@123", "417");
		Assert.assertEquals(personalDetails.getEmployeeName(), "John2 Smith1");
		dashboard.clickOnLogout();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		_driver.quit();
	}

}
