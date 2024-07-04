package com.dvm.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {

	//public WebDriver _driver;
	private RemoteWebDriver _driver;

	public static Properties prop;
	
	private String username = "deepakmautomation";
	private String accesskey = "h3iAWJPcUJ83qgWvBpzVtdI36fcnWY5P87RUFYcV5CUmJTDB2b";

	public TestBase() throws IOException  {

		prop = new Properties();

		File f = new File(System.getProperty("user.dir")+"/src/main/java/com/dvm/qa/selenium/config/config.properties");	

		FileInputStream fis = new FileInputStream(f);

		prop.load(fis);
	}

	public WebDriver launchBrowser(String browserName) throws URISyntaxException, MalformedURLException {
		
		URI uri = new URI("https://"+username+":"+accesskey+"@hub.lambdatest.com/wd/hub");
		URL url = uri.toURL();

		if(prop.getProperty("remote").equals("true")) {
			
			if(browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 10");
				browserOptions.setBrowserVersion("126");
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("video", true);
				ltOptions.put("build", "Build-dm-selenium-orangehrm-project-2024");
				ltOptions.put("project", "dm-selenium-orangehrm-project-2024");
				ltOptions.put("name", "Test-dm-selenium-orangehrm-project-2024");
				ltOptions.put("w3c", true);
				ltOptions.put("plugin", "java-java");
				browserOptions.setCapability("LT:Options", ltOptions);
				_driver = new RemoteWebDriver(url, browserOptions);	
				_driver.setFileDetector(new LocalFileDetector());
			}
					
		}else {

			if(browserName.equalsIgnoreCase("chrome")) {
				_driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				_driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				_driver = new EdgeDriver();
			}
		}
		_driver.manage().window().maximize();
		_driver.get(prop.getProperty("url"));
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		_driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		return _driver;
	}

}
