package com.ShoesBuy.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	static WebDriver driver;
	static String text;

	public static void invokeBrowser(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"..\\ShoesBuy\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver",
    				"..\\ShoesBuy\\drivers\\geckodriver.exe");
    		driver = new FirefoxDriver();
        }

	}
	public static void maximizeBrowser() {
		
		driver.manage().window().maximize();
	}
	public static String readExcelData() {

		String URLNAME = null;
		String name1;

		try {
			FileInputStream excel = new FileInputStream("../ShoesBuy/TestData/BrowserData.xlsx");

			XSSFWorkbook book = new XSSFWorkbook("../ShoesBuy/TestData/BrowserData.xlsx");

			XSSFSheet sheet1 = book.getSheet("Sheet1");
			XSSFRow row1 = sheet1.getRow(0);
			XSSFCell cell1 = row1.getCell(0);
			String key1 = cell1.getStringCellValue();
			System.out.println("key1::" + key1);
			XSSFCell cell2 = row1.getCell(1);
			String value1 = cell2.getStringCellValue();
			System.out.println("value1::" + value1);
			XSSFCell cell3 = row1.getCell(2);
			name1 = cell3.getStringCellValue();
			System.out.println("name1::" + name1);
			XSSFRow row3 = sheet1.getRow(2);
			XSSFCell cell4 = row3.getCell(0);
			URLNAME = cell4.getStringCellValue();
			// XSSFCell cell6 = row3.getCell(2);
			// String URL = cell6.getStringCellValue();
			excel.close();
			book.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return URLNAME;

	}


	public static void NavigatetoURL(String URLNAME) {

		driver.get(URLNAME);

	}

	
	public static void loginFunction(String USERNAME, String PASSWORD) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		SendKeysFunction("/html/body/div[6]/div/article/div/div/div[1]/div[1]/form/div[2]/div/div/div[1]/div[2]/input",
				USERNAME);
		SendKeysFunction("/html/body/div[6]/div/article/div/div/div[1]/div[1]/form/div[2]/div/div/div[2]/div[2]/input",
				PASSWORD);
		clickFunction("//*[@id=\"form-submit\"]");
	}

	public static void clickFunction(String xpath) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (NoSuchElementException e) {

			e.printStackTrace();
		}

	}

	public static void SendKeysFunction(String xpath, String input) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		try {
			driver.findElement(By.xpath(xpath)).sendKeys(input);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public static String textFromElement(String xpath) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		text = driver.findElement(By.xpath(xpath)).getText();
		return text;

	}

	public static void SelectFunction(String xpath, String visibleText) {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Select stateDropDown = new Select(driver.findElement(By.xpath(xpath)));
		stateDropDown.selectByVisibleText(visibleText);
	}

	public static void switchToWindow() {

		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {

			if (handle != currentWindowHandle) {
				driver.switchTo().window(handle);
				break;

			}

		}

	}

	public static void TakeScreenShot() {

		try {
			Thread.sleep(30000);
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(sourceFile, new File("../ShoesBuy/ScreeShots/LoginPage.jpeg"));
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void ShutdownBrowser() {

		driver.quit();
	}
}
