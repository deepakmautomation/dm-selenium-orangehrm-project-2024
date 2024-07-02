package com.dvm.qa.selenium.testcases;

import java.io.IOException;

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
	public void setUp(String browserName) throws IOException {
		testBase = new TestBase();
		_driver =  testBase.launchBrowser(browserName);
		loginPage = new OrangeHRM_loginPage(_driver);
	}

	@Test
	public void verifyAdminCanAddEmployee() throws InterruptedException{
		dashboard = loginPage.login(TestBase.prop.getProperty("username"),TestBase.prop.getProperty("password"));
		pim = dashboard.clickOnPIM();
		Assert.assertEquals(pim.getPIMHeaderText(), "PIM");
		addemployee =  pim.clickOnAddEmployee();
		personalDetails =  addemployee.enterEmployeeFullName("Jargon3", "S", "Smith3");
		Thread.sleep(4000);
		Assert.assertEquals(personalDetails.getEmployeeName(), "Jargon3 Smith3");
		//System.out.println("You Employee ID is: "+ employeeID);// unable to get the Emp ID
		dashboard.clickOnLogout();
	}


	@AfterMethod
	public void tearDown() {
		_driver.quit();
	}

}
