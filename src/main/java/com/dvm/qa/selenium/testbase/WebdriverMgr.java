package com.dvm.qa.selenium.testbase;

import org.openqa.selenium.WebDriver;

public class WebdriverMgr {
	
	 private static WebDriver _driver;

	public static WebDriver get_driver() {
		return _driver;
	}

	public static void set_driver(WebDriver _driver) {
		WebdriverMgr._driver = _driver;
	}

}
