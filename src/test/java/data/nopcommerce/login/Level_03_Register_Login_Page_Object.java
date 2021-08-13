package data.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		emailAddress = getRandomEmail();
		password = "123123123";
	}

	@Test
	public void Login_01_Register_To_System() {
		// Step 01: Open URL -> HomePage
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		// Step 02: Verify Homepage Logo displayed

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		// Step 03: Click Register Link
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		// Step 04: Click to Male radio
		registerPage.clickToGenderMaleRadioButton();

		// Step 05: Input firstname textbox
		registerPage.enterToFirstnameTextbox("khanh");

		// Step 06: Input lastname textbox
		registerPage.enterToLastnameTextbox("duong");

		// Step 07: Input Email textbox
		registerPage.enterToEmailTextbox(emailAddress);

		// Step 08: Input password textbox
		registerPage.enterToPasswordTextbox(password);

		// Step 09: Input confirm password textbox
		registerPage.enterToConfirmPasswordTextbox(password);

		// Step 10: Click to Register button
		registerPage.clickToRegisterButton();

		// Step 11: Verify Success Message Displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		// Step 12: Click To Logout Link
		registerPage.clickToLogoutLink();

		homePage = new HomePageObject(driver);

		// Step 13: Verify Homepage Logo displayed

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_02_Login_To_System() {
		// Step 01: Click to Login Link
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		// Step 02: Input To Email Textbox
		loginPage.enterToEmailTextbox(emailAddress);

		// Step 03: Input To Password Textbox
		loginPage.enterToPasswordTextbox(password);

		// Step 04: Click To Login Button
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

		// Step 05: Verify Homepage Logo displayed

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "khanhduong" + rand.nextInt(99999) + "@live.com";

	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
