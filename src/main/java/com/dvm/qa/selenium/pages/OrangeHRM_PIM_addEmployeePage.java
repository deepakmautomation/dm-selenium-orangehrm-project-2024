package com.dvm.qa.selenium.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_PIM_addEmployeePage {

	private WebDriver _driver;

	By addEmployeeHeaderText = By.xpath("//h6[text()='Add Employee']");
	By firstName = By.name("firstName");
	By middleName = By.name("middleName");
	By lastName = By.name("lastName");
	By employeeID = By.xpath("//div[@class='oxd-form-row']/child::div[2]/descendant::input");
	By saveButton = By.xpath("//button[@type='submit']");
	By employeeImage = By.className("employee-image");
	By employeeImageInput = By.className("oxd-file-input");

	public OrangeHRM_PIM_addEmployeePage(WebDriver adriver) {
		this._driver = adriver;
	}

	public String getAddEmployeeHeaderText() {
		return _driver.findElement(addEmployeeHeaderText).getText();
	}

	public OrangeHRM_PIM_viewPersonalDetailsPage enterEmployeeFullName(String fname, String mname, String lname)throws InterruptedException {
		_driver.findElement(firstName).sendKeys(fname);
		_driver.findElement(middleName).sendKeys(mname);
		_driver.findElement(lastName).sendKeys(lname);
		uploadEmployeeImage();
		_driver.findElement(saveButton).click();
		Thread.sleep(3000);
		return new OrangeHRM_PIM_viewPersonalDetailsPage(_driver);

	}

	public void uploadEmployeeImage()   {

		_driver.findElement(employeeImage).click();

		File f = new File(System.getProperty("user.dir")+"/Images/Profile_picture.png");

		String imagePath = f.getAbsolutePath();

		StringSelection systemClipboard = new StringSelection(imagePath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(systemClipboard, null);

		try {
			Robot r = new Robot();

			r.setAutoDelay(3000);

			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);

			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(3000);

		} catch (AWTException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}



	}
}
