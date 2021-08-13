package data.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Object extends BaseTest {
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
	public void Login_01_Register_To_System() {
		
		homePage = new HomePageObject(driver);

		

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		
		homePage.clickToRegisterLink();
		homePage.sleepInSecond(3);
		registerPage = new RegisterPageObject(driver);

		registerPage.clickToGenderMaleRadioButton();

		registerPage.enterToFirstnameTextbox("khanh");

		registerPage.enterToLastnameTextbox("duong");

		registerPage.enterToEmailTextbox(emailAddress);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink();

		homePage = new HomePageObject(driver);


		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_02_Login_To_System() {
		
		homePage.clickToLoginLink();
		homePage.sleepInSecond(3);
		
		loginPage = new LoginPageObject(driver);

		
		loginPage.enterToEmailTextbox(emailAddress);

		
		loginPage.enterToPasswordTextbox(password);

		
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

		

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
