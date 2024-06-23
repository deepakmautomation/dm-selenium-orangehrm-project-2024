package com.dvm.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver _driver;
	
	public static Properties prop;

	public TestBase() throws IOException  {

		prop = new Properties();

		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\dvm\\qa\\selenium\\config\\config.properties");	

		FileInputStream fis = new FileInputStream(f);
		
		prop.load(fis);
	}

	public WebDriver launchBrowser() {
		 String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			_driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			_driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			_driver = new EdgeDriver();
		}
		_driver.manage().window().maximize();
		_driver.get(prop.getProperty("url"));
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		_driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		return _driver;
	}

}
