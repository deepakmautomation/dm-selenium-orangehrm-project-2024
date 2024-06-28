package com.dvm.qa.selenium.util;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener  {

	public void onFinish(ITestContext context) {
		System.out.println("Test Finished..");
	}

	public void onTestStart(ITestResult result) {

		System.out.println(result.getMethod().getMethodName()+ " Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success..");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed..");
		try {
			Takescreenshot.getScreenShot();
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
