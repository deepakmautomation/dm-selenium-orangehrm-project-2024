package com.dvm.qa.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dvm.qa.selenium.testbase.TestBase;

public class OrangeHRM_PIM_viewEmployeeListPage {

	private WebDriver _driver;

	By employeeNameHint = By.xpath("(//div[@class='oxd-autocomplete-wrapper'])[1]/descendant::input");
	By searchBtn = By.xpath("//div[@class='oxd-form-actions']/child::button[@type='submit']");
	By editAction = By.xpath("//div[@class='oxd-table-cell-actions']/child::button[2]");
	By searchId = By.xpath("(//div[@class='oxd-input-group__label-wrapper'])[2]/following-sibling::div/child::input");
	By row = By.xpath("//div[@class='oxd-table-card']");

	public OrangeHRM_PIM_viewEmployeeListPage(WebDriver vdriver) {
		this._driver = vdriver;
	}


	public void typeHintEmployeeName() {
		_driver.findElement(employeeNameHint).sendKeys(TestBase.prop.getProperty("firstname")+" "+TestBase.prop.getProperty("lastname"));
	}

	public void clickOnSearchButton() throws InterruptedException {
		_driver.findElement(searchBtn).click();
	}

	public void enterEmpId() {
		_driver.findElement(searchId).sendKeys(TestBase.prop.getProperty("empid"));
	}

	public OrangeHRM_PIM_viewPersonalDetailsPage clickOnEditAction() throws InterruptedException {
		
		WebDriverWait wait= new WebDriverWait(_driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(row));

		List<WebElement> ids =  _driver.findElements(By.xpath("//div[@class='oxd-table-card']/child::div/child::div[2]/child::div"));

		for(int i=0;i<ids.size();i++) {

			if(ids.get(i).getText().contains(TestBase.prop.getProperty("empid"))) 
			{ 
				try {
					_driver.findElement(editAction).click(); 
					break;
				}
				catch (Exception e){
					e.printStackTrace(); 
				}
			}

		}
		return new OrangeHRM_PIM_viewPersonalDetailsPage(_driver);
	}
}
