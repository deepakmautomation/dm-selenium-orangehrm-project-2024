package com.dvm.qa.selenium.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	By createLoginDetailsToggle = By.className("oxd-switch-wrapper");
	By username = By.xpath("(//div[@class='oxd-form-row'])[2]/descendant::input[1]");
	By password = By.xpath("(//div[@class='oxd-form-row'])[2]/following-sibling::div/descendant::input[@type='password'][1]");
	By confirmPassword = By.xpath("(//div[@class='oxd-form-row'])[2]/following-sibling::div/descendant::input[@type='password'][2]");
	By statusEnabled = By.xpath("(//div[@class='oxd-form-row'])[2]/descendant::input[2]");
	By statusDisabled = By.xpath("(//div[@class='oxd-form-row'])[2]/descendant::input[3]");

	
	public OrangeHRM_PIM_addEmployeePage(WebDriver adriver) {
		this._driver = adriver;
	}

	public String getAddEmployeeHeaderText() {
		return _driver.findElement(addEmployeeHeaderText).getText();
	}

	public OrangeHRM_PIM_viewPersonalDetailsPage enterEmployeeFullName(String fname, String mname, String lname, String uname, String pwd, String empid)throws InterruptedException {
		_driver.findElement(firstName).sendKeys(fname);
		_driver.findElement(middleName).sendKeys(mname);
		_driver.findElement(lastName).sendKeys(lname);
		_driver.findElement(employeeID).sendKeys(Keys.CONTROL+"A"+Keys.BACK_SPACE);
		_driver.findElement(employeeID).sendKeys(empid);
		createLoginDetails(uname, pwd);
		uploadEmployeeImage();
		_driver.findElement(saveButton).click();
		Thread.sleep(5000);
		return new OrangeHRM_PIM_viewPersonalDetailsPage(_driver);
	}

	public void uploadEmployeeImage()   {

		_driver.findElement(employeeImage).click();

		File f = new File(System.getProperty("user.dir")+"/Images/Profile_picture.png");

		String imagePath = f.getAbsolutePath();

		StringSelection systemClipboard = new StringSelection(imagePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(systemClipboard, null); // we can also use Clipboard class

		try {
			Robot r = new Robot();

			r.setAutoDelay(3000);

			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);

			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(2000);

		} catch (AWTException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void createLoginDetails(String uname, String pwd) {
		_driver.findElement(createLoginDetailsToggle).click();
		_driver.findElement(username).sendKeys(uname);
		//_driver.findElement(statusEnabled).click();
		_driver.findElement(password).sendKeys(pwd);
		_driver.findElement(confirmPassword).sendKeys(pwd);
	}
}
