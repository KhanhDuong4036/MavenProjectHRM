package data.nopcommerce.login;

import java.lang.reflect.Method;
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

//import com.relevantcodes.extentreports.LogStatus;

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
//import reportConfig.ExtentTestManager;

public class Level_13_Register_Login_Log_Extent_Report_V2 extends BaseTest {
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
	public void User_01_Register_To_System(Method method) {
		/*
		 * ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 01: Verify Home Page is displayed"); homePage =
		 * PageGeneratorManager.getHomePage(driver);
		 * verifyTrue(homePage.isHomePageSliderDisplayed());
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 02: Click to Register Link"); registerPage =
		 * homePage.clickToRegisterLink(); registerPage.sleepInSecond(3);
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 03: Click to Male radio button");
		 * registerPage.clickToGenderMaleRadioButton();
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 04: Enter to First Name text box");
		 * registerPage.enterToFirstnameTextbox("khanh");
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 05: Enter to Last Name text box");
		 * registerPage.enterToLastnameTextbox("duong");
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 06: Enter to Email text box: " + emailAddress);
		 * registerPage.enterToEmailTextbox(emailAddress);
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 07: Enter to Password text box: " + password);
		 * registerPage.enterToPasswordTextbox(password);
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 08: Enter to Confirm Password Text box: " +
		 * password); registerPage.enterToConfirmPasswordTextbox(password);
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 09: Click to Register Button");
		 * registerPage.clickToRegisterButton();
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 10: Verify Success Message is displayed");
		 * verifyTrue(registerPage.isSuccessMessageDisplayed());
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 11: Click to Logout link"); homePage =
		 * registerPage.clickToLogoutLink();
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_01_Register - Step 12: Verify Home Page is displayed");
		 * verifyTrue(homePage.isHomePageSliderDisplayed());
		 * 
		 * ExtentTestManager.endTest();
		 */
	}

	@Test
	public void User_02_Login_To_System(Method method) {
		/*
		 * ExtentTestManager.startTest(method.getName(), "User_02_Login_To_System");
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_02_Login - Step 01: Click to Login link"); loginPage =
		 * homePage.clickToLoginLink();
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_02_Login - Step 02: Enter to Email text box: " + emailAddress);
		 * loginPage.enterToEmailTextbox("");
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_02_Login - Step 03: Enter to Password text box: " + password);
		 * loginPage.enterToPasswordTextbox(password);
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_02_Login - Step 04: Click to Login Button "); homePage =
		 * loginPage.clickToLoginButton();
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.INFO,
		 * "User_02_Login - Step 05: Verify Home Page is displayed");
		 * verifyTrue(homePage.isHomePageSliderDisplayed());
		 * 
		 * ExtentTestManager.endTest();
		 */
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;

}
