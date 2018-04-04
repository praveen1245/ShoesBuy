package com.ShoesBuy.Sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ShoesBuy.Common.CommonMethods;

public class SampleTest extends CommonMethods {
    
	static String URLNAME = readExcelData();
	
    @Parameters({"browserName"})
	@BeforeSuite
	public static void launchBrowser(String browserName) {
    	 
		System.out.println("browser name::"+browserName);
		invokeBrowser(browserName);
		maximizeBrowser();
		NavigatetoURL(URLNAME);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}

	@BeforeMethod
	public static void loginPage() {
		clickFunction("/html/body/div[3]/header[1]/div[1]/div/div/ul/li[2]/a");


		loginFunction("praveen.kondreddy@gmail.com", "Bujju@123");

	}

	@Test(priority = 1)
	public static void TC_Login_Verification() {

		// To get firstName
		String firstName = textFromElement("/html/body/div[6]/div/div/section[1]/div[1]/div/div[1]/div/span[1]");
		// To get LastName
		String lastName = textFromElement("/html/body/div[6]/div/div/section[1]/div[1]/div/div[1]/div/span[2]");
		// TO print the FirstName
		System.out.println("First Name Entered is::" + firstName);
		// To Print the LastName
		System.out.println("Last Entered is::" + lastName);

	}

	@Test(priority=2)
	public static void TC_Address_add() {

		// To click on add button in shipping address section
		clickFunction("//*[@id=\"addShippingButton\"]");
		// To make the thread wait to get the Pop Up displayed
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// To switch PopUp window
		switchToWindow();
		// To interact with elements on alert window
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[1]/div[1]/input", "Praveen");
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[1]/div[2]/input", "Kondreddy");
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[2]/div[1]/input", "450 Serra Mall");
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[2]/div[2]/input", "");
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[3]/div[1]/input", "Stanford");
		SelectFunction("//*[@id=\"state_dom\"]", "California");
		SendKeysFunction("//*[@id=\"zip_nat\"]", "94305");
		clickFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[4]/div[3]/select/option[50]");
		SendKeysFunction("/html/body/div[6]/div/div/form[3]/div/div[2]/fieldset/div[7]/input", "16507232300");
		// TO Save The Entered Address
		clickFunction("/html/body/div[6]/div/div/form[3]/div/div[3]/input");
		// To get the ScreenShot
		TakeScreenShot();
		// To Print Entered Address
		System.out.println("entered address is:::"
				+ textFromElement("/html/body/div[6]/div/div/section[1]/div[1]/div/div[2]/div"));

	}

	@Test(priority = 3)
	public static void TC_Address_Delete() {

		// TO click on Edit Button of Address
		clickFunction("//a[@id=\"editShippingButton\"]");
		// To wait for the PopUp to get Displayed
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// To Switch to PopUp Window
		switchToWindow();
		// To click on Delete Button to delete the Address
		clickFunction("/html/body/div[6]/div/div/div/div[2]/div[2]/div/fieldset/label/div/div/a[1]");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public static void TC_AddPaymentDetails() {
		
		//To Click on Add Button
		clickFunction("//a[@id=\"addPaymentButton\"]");
		//To wait for the PopUp to appear
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//To Shift the cursor to PopUp Window
		switchToWindow();
		//To Select Type of Card
		SelectFunction("/html/body/div[6]/div/div/form[4]/div/div[2]/fieldset/div[1]/div/div/select","Mastercard");
		//To Enter the Card Number
		SendKeysFunction("/html/body/div[6]/div/div/form[4]/div/div[2]/fieldset/div[2]/div/input","5596010002539888");
		//To Select the Expiry Month
		SelectFunction("/html/body/div[6]/div/div/form[4]/div/div[2]/fieldset/div[3]/div/div[1]/select","11 - Nov");
		//To Select the Expiry Year
		SelectFunction("/html/body/div[6]/div/div/form[4]/div/div[2]/fieldset/div[3]/div/div[2]/select","2022");
		//To click on Save Button
		clickFunction("/html/body/div[6]/div/div/form[4]/div/div[3]/input");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	@Test(priority=5) 
	public static void TC_DeletePaymentDetails() {
		
		//To click on Edit button
		clickFunction("//*[@id=\"editPaymentButton\"]");
		//To wait  for payment details PopUp to appear
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//To click on delete button
		clickFunction("/html/body/div[6]/div/div/form[2]/div/div[2]/div[2]/fieldset/label/div/div[2]/a[1]");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

	@AfterMethod
	public static void logoutPage() {

		clickFunction("//a[@id=\"siteLogout\"]");
	}

	@AfterSuite
	public static void closeBrowser() {

		ShutdownBrowser();
	}

}
