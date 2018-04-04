package com.ShoesBuy.Sample;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ShoesBuy.Common.CommonMethods;

public class firefoxBrowser extends CommonMethods {
static String URLNAME = readExcelData();
	
    @Parameters({"browserName"})
	@BeforeSuite
	public static void launchBrowser(String browserName) {
    	 
		System.out.println("browser name::"+browserName);
		invokeBrowser(browserName);
		maximizeBrowser();
		//NavigatetoURL(URLNAME);
		//try {
			//Thread.sleep(6000);
		//} catch (InterruptedException e) {

			//e.printStackTrace();
		//}
		

	}
    

	@Test
	public static void TC_06()  {
		
		System.out.println("Second method");
	}

	@Test
	public static void TC_07()  {
		
		System.out.println("third method");
	}
	
	
}
