package data.nopcommerce.login;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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


public class Level_13_Register_Login_Log_Extent_Report_V3_V4 extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		emailAddress = getRandomEmail();
		password = "123123123";

	}

	@Test
	public void User_01_Register_To_System() {
		
		log.info("User_01_Register - Step 01: Verify Home Page is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("User_01_Register - Step 02: Click to Register Link");
		registerPage = homePage.clickToRegisterLink();
		registerPage.sleepInSecond(3);
		
		log.info("User_01_Register - Step 03: Click to Male radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("User_01_Register - Step 04: Enter to First Name text box");
		registerPage.enterToFirstnameTextbox("khanh");
		
		log.info("User_01_Register - Step 05: Enter to Last Name text box");
		registerPage.enterToLastnameTextbox("duong");
		
		log.info("User_01_Register - Step 06: Enter to Email text box: " + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("User_01_Register - Step 07: Enter to Password text box: " + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("User_01_Register - Step 08: Enter to Confirm Password Text box: " + password);
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("User_01_Register - Step 09: Click to Register Button");
		registerPage.clickToRegisterButton();
		
		log.info("User_01_Register - Step 10: Verify Success Message is displayed");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("User_01_Register - Step 11: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("User_01_Register - Step 12: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}

	@Test
	public void User_02_Login_To_System() {

		log.info("User_02_Login - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("User_02_Login - Step 02: Enter to Email text box: " + emailAddress);
		loginPage.enterToEmailTextbox("");
		
		log.info("User_02_Login - Step 03: Enter to Password text box: " + password);
		loginPage.enterToPasswordTextbox(password);

		log.info("User_02_Login - Step 04: Click to Login Button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("User_02_Login - Step 05: Verify Home Page is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser - " + browserName + "'");
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
