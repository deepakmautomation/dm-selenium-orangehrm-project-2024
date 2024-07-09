package com.dvm.qa.selenium.util;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dvm.qa.selenium.testbase.WebdriverMgr;

public class Listener implements ITestListener  {

	 private WebDriver _driver;
	 Takescreenshot takescreenshot;
	

	public void onFinish(ITestContext context) {
		System.out.println("Test Finished..");
	}


	public void onTestStart(ITestResult result) {

		_driver = WebdriverMgr.get_driver();
		takescreenshot = new Takescreenshot();
		System.out.println(result.getMethod().getMethodName()+ " Test Started");
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success..");
	}


	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed..");
		try {
			takescreenshot.getScreenShot(_driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped..");	
	}

	public void onStart(ITestContext context) {
		System.out.println("Test started...");
	}



}
