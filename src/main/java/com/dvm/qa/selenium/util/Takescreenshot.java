package com.dvm.qa.selenium.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Takescreenshot {	
	
	public void getScreenShot(WebDriver driver) throws IOException{
		
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String savepath = System.getProperty("user.dir")+"\\screenshots\\test"+"_"+TestUtil.getCurrentDateTime()+".png";
		
		File dest = new File(savepath);
		
		FileUtils.copyFile(src, dest);
		
	}
}
