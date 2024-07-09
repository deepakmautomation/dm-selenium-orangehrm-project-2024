package com.dvm.qa.selenium.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportcls {
	
	public static ExtentReports extent;
	public  static ExtentTest test;
	
	public void getReport() {
		
		extent = new ExtentReports();
		
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("target/extent/extentReport.html");
		
		spark.config().setDocumentTitle("Title: Orange HRM Automation Testing Report");
		spark.config().setReportName("Name: Orange HRM Automation Testing Report");
		spark.config().setTheme(Theme.STANDARD);
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host", "Windows");
		extent.setSystemInfo("QA", "DeepakQA");

	}

}
