package com.dvm.qa.selenium.testcases;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.OrangeHRM_PIMPage;
import com.dvm.qa.selenium.pages.OrangeHRM_PIM_viewEmployeeListPage;
import com.dvm.qa.selenium.pages.OrangeHRM_PIM_viewPersonalDetailsPage;
import com.dvm.qa.selenium.pages.OrangeHRM_dashboardPage;
import com.dvm.qa.selenium.pages.OrangeHRM_loginPage;
import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_PIM_viewEmployeeListPageTest {

	WebDriver _driver;
	TestBase testbase;
	OrangeHRM_loginPage loginpage;
	OrangeHRM_dashboardPage dashboardpage;
	OrangeHRM_PIMPage PIMpage;
	OrangeHRM_PIM_viewEmployeeListPage viewemployee;
	OrangeHRM_PIM_viewPersonalDetailsPage personaldetails;

	@Parameters({"browserName"})
	@BeforeMethod
	public void setUp(String browserName) throws IOException, URISyntaxException {

		testbase = new TestBase();
		_driver = testbase.launchBrowser(browserName);
		loginpage = new OrangeHRM_loginPage(_driver);
		personaldetails = new OrangeHRM_PIM_viewPersonalDetailsPage(_driver);

	}

	@Test
	public void verify_that_the_admin_can_be_able_to_search_the_employee() throws InterruptedException {
		dashboardpage = loginpage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
		PIMpage =  dashboardpage.clickOnPIM(); 
		viewemployee =  PIMpage.clickOnEmployeeList();
		viewemployee.enterEmpId();
		viewemployee.clickOnSearchButton();
		viewemployee.clickOnEditAction();
		Assert.assertEquals(personaldetails.getEmployeeName(), TestBase.prop.getProperty("firstname")+" "+TestBase.prop.getProperty("lastname"));

	}

	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}


}
