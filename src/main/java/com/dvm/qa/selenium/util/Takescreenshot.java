package com.dvm.qa.selenium.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Takescreenshot {
	
	
	public static WebDriver _driver;
	
	public Takescreenshot(WebDriver tdriver) {
		Takescreenshot._driver = tdriver;
	}
	
	public static void getScreenShot() throws IOException{
		
		TakesScreenshot takescreenshot = (TakesScreenshot)_driver;
		
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String savepath = System.getProperty("user.dir")+"\\screenshots\\test"+"_"+TestUtil.getCurrentDateTime()+".png";
		
		File dest = new File(savepath);
		
		FileUtils.copyFile(src, dest);
		
	}
}
