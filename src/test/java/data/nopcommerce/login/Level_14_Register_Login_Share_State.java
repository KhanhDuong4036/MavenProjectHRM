package data.nopcommerce.login;

import data.nopcommerce.common.Common_01_Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.MyAccountPageObject;
import pageObjects.user.nopCommerce.OrderPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;
import pageObjects.user.nopCommerce.SearchPageObject;

public class Level_14_Register_Login_Share_State extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Open Browser '" + browserName + "'");
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = getRandomEmail();
		password = "123123123";
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("User_02_Login - Step 01: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("User_02_Login - Step 02: Set login page cookie");
		loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
		loginPage.sleepInSecond(5);
		loginPage.refreshCurrentPage(driver);
		
		log.info("User_02_Login - Step 03: Click to Homepage Image");
		homePage = loginPage.openHomePage();
		
		log.info("User_02_Login - Step 03: Verify Home Page is displayed");
		verifyFalse(homePage.isHomePageSliderDisplayed());
		
	}

	@Test
	public void User_01_Login_To_System() {
	
	}
	
	@Test
	public void User_02_Login_To_System() {
		
	}

	@AfterClass
	public void cleanBrowser() {
		log.info("Post-Condition: Close browser");
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
