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
//
//@Test
//public class Level_07_Register_Login_Switch_Page extends BaseTest {
//	WebDriver driver;
//	String emailAddress, password;
//	String projectLocation = System.getProperty("user.dir");
//
//	@Parameters({ "browser", "url" })
//	@BeforeClass
//	public void beforClass(String browserName, String appUrl) {
//
//		driver = getBrowserDriver(browserName, appUrl);
//		emailAddress = getRandomEmail();
//		password = "123123123";
//		
//		homePage = PageGeneratorManager.getHomePage(driver);
//	}
//
//	public void Login_01_Register_To_System() {
//		
//		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
//	
//		registerPage = homePage.clickToRegisterLink();
//		registerPage.clickToGenderMaleRadioButton();
//		registerPage.enterToFirstnameTextbox("khanh");
//		registerPage.enterToLastnameTextbox("duong");
//		registerPage.enterToEmailTextbox(emailAddress);
//		registerPage.enterToPasswordTextbox(password);
//		registerPage.enterToConfirmPasswordTextbox(password);
//		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
//		
//		homePage = registerPage.clickToLogoutLink();
//		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
//
//	}
//
//	public void Login_02_Login_To_System() {
//		
//		loginPage = homePage.clickToLoginLink();			 
//		loginPage.enterToEmailTextbox(emailAddress);
//		loginPage.enterToPasswordTextbox(password);
//		
//		homePage = loginPage.clickToLoginButton();
//		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
//	}
//	
//	public void Login_03_Switch_Page_At_Footer() {
//		// Homepage -> Search Page
//		searchPage = homePage.openSearchPage(driver);
//		//searchPage.xxx
//		
//		
//		//Search Page -> Order page
//		myAccountPage = searchPage.openMyAccountPage(driver);
//		
//		//My Account page -> Order Page
//		orderPage = myAccountPage.openOrderPage(driver);
//		
//		//Order Page -> My Account Page
//		myAccountPage = orderPage.openMyAccountPage(driver);
//		
//		
//		//My Account Page -> Search page
//		searchPage = myAccountPage.openSearchPage(driver);
//	}
//
//	@AfterClass
//	public void cleanBrowser() {
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
