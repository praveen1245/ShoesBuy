package com.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScreenShot {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver","../ShoesBuy/drivers/geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https:\\www.google.co.in");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
		FileUtils.copyFile(src,new File("../ShoesBuy/ScreeShots/google.jpeg"));
		
	}

}
