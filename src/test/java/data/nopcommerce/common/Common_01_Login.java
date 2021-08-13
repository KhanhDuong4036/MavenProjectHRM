package data.nopcommerce.common;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;
import pageUIs.user.nopCommerce.SearchPageUI;

public class Common_01_Login extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	public static Set<Cookie> loginPageCookie;


	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Open Browser '" + browserName + "'");
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getRandomEmail();
		password = "123123123";

		log.info("Common_01 - Step 01: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInSecond(3);
		
		log.info("Common_01 - Step 03: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Common_01 - Step 04: Enter to First Name text box");
		registerPage.enterToFirstnameTextbox("khanh");
		
		log.info("Common_01 - Step 05: Enter to Last Name text box");
		registerPage.enterToLastnameTextbox("duong");
		
		log.info("Common_01 - Step 06: Enter to Email text box: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 07: Enter to Password text box: " + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Common_01 - Step 08: Enter to Confirm Password Text box: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Common_01 - Step 09: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("Common_01 - Step 10: Verify Success Message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Common_01 - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Common_01 - Step 12: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());

		log.info("Common_01 - Step 13: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Common_01 - Step 14: Enter to Email text box: " + emailAddress);
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("Common_01 - Step 15: Enter to Password text box: " + password);
		loginPage.enterToPasswordTextbox(password);

		log.info("Common_01 - Step 16: Click to Login Button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Common_01 - Step 17: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 18: Get all login page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		System.out.println(loginPageCookie);
		
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanDriverInstance();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
