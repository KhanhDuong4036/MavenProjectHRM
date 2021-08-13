//package com.nopcommerce.login;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//import commons.BaseTest;
//import pageObjects.user.nopCommerce.HomePageObject;
//import pageObjects.user.nopCommerce.LoginPageObject;
//import pageObjects.user.nopCommerce.MyAccountPageObject;
//import pageObjects.user.nopCommerce.OrderPageObject;
//import pageObjects.user.nopCommerce.PageGeneratorManager;
//import pageObjects.user.nopCommerce.RegisterPageObject;
//import pageObjects.user.nopCommerce.SearchPageObject;
//import pageUIs.user.nopCommerce.SearchPageUI;
//
//public class Level_15_Register_Login_Pattern_Object extends BaseTest {
//	WebDriver driver;
//	String emailAddress, password, date, month, year;
//	String projectLocation = System.getProperty("user.dir");
//
//	@Parameters({ "browser", "url" })
//	@BeforeClass
//	public void beforClass(String browserName, String appUrl) {
//		log.info("Pre-Condition - Open Browser '" + browserName + "'");
//		driver = getBrowserDriver(browserName, appUrl);
//		
//		emailAddress = getRandomEmail();
//		password = "123123123";
//		date= "8"; 
//		month= "June"; 
//		year = "1995";
//
//		
//	}
//
//	@Test
//	public void User_01_Register_To_System() {
//		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//		
//		log.info("User_01_Register - Step 02: Click to Register Link");
//		homePage.openHeaderPageByName(driver, "Register");
//		registerPage = PageGeneratorManager.getRegisterPage(driver);
//		
//		log.info("User_01_Register - Step 03: Click to Male radio button");
//		registerPage.clickToRadioButtonByID(driver, "gender-male");
//		
//		log.info("User_01_Register - Step 04: Enter to First Name text box");
//		registerPage.enterToTextboxByID(driver, "FirstName", "Khanh");
//			
//		log.info("User_01_Register - Step 05: Enter to Last Name text box");
//		registerPage.enterToTextboxByID(driver, "LastName", "Duong");
//		
//		log.info("User_01_Register - Step 06: Enter to Email text box: " + emailAddress);
//		registerPage.enterToTextboxByID(driver, "Email", emailAddress);
//		
//		log.info("User_01_Register - Step 07: Enter to Password text box: " + password);
//		registerPage.enterToTextboxByID(driver, "Password", password);
//		
//		log.info("User_01_Register - Step 08: Enter to Confirm Password Text box: " + password);
//		registerPage.enterToTextboxByID(driver, "ConfirmPassword", password);
//		
//		log.info("User_01_Register - Step 09: Select item in Date dropdown");
//		registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
//		
//		log.info("User_01_Register - Step 10: Select item in Month dropdown");
//		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
//		
//		log.info("User_01_Register - Step 11: Select item in Year dropdown");
//		registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
//		
//		registerPage.scrollToBottomPage(driver);
//		log.info("User_01_Register - Step 12: Click to Register Button");
//		registerPage.clickToButtonByText(driver, "Register");
//		
//		log.info("User_01_Register - Step 13: Verify Success Message is displayed");
//		verifyTrue(registerPage.isSuccessMessageDisplayed());
//		
//		log.info("User_01_Register - Step 14: Click to Logout link");
//		registerPage.openHeaderPageByName(driver, "Log out");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		
//		log.info("User_01_Register - Step 15: Verify Home Page is displayed");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//
//	}
//
//	@Test
//	public void User_02_Login_To_System() {
//		
//		log.info("User_02_Login - Step 01: Click to Login link");
//		homePage.openHeaderPageByName(driver, "Log in");
//		loginPage = PageGeneratorManager.getLoginPage(driver);
//		
//		log.info("User_02_Login - Step 02: Enter to Email text box: " + emailAddress);
//		loginPage.enterToTextboxByID(driver, "Email", emailAddress);
//		
//		log.info("User_02_Login - Step 03: Enter to Password text box: " + password);
//		loginPage.enterToTextboxByID(driver, "Password", password);
//
//		log.info("User_02_Login - Step 04: Click to Login Button ");
//		loginPage.clickToButtonByText(driver, "Log in");
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
//		verifyTrue(homePage.isHomePageSliderDisplayed());
//	}
//
//	@AfterClass
//	public void cleanBrowser() {
//		log.info("Post-Condition: Close browser");
//		driver.quit();
//	}
//
//	HomePageObject homePage;
//	LoginPageObject loginPage;
//	RegisterPageObject registerPage;
//	SearchPageObject searchPage;
//	MyAccountPageObject myAccountPage;
//	OrderPageObject orderPage;
//
//}
