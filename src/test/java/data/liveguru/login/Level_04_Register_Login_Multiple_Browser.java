package data.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest{
	WebDriver driver;
	String emailAddress, password;

	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123123123";
		driver.get("http://live.demoguru99.com/index.php/");
	}

	@Test
	public void Login_01_Empty_Email_Password() {
		
		
		homePage = new HomePageObject(driver);
		
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextbox("");		
		loginPage.enterToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
		
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.enterToEmailTextbox("123@490123");		
		loginPage.enterToPasswordTextbox("123123123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.enterToEmailTextbox("khanhduong403666@live.com");		
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");

	}

	@Test
	public void Login_04_Incorrect_Email() {
		loginPage.enterToEmailTextbox(emailAddress);		
		loginPage.enterToPasswordTextbox("123123123");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.enterToEmailTextbox("dam@gmail.com");		
		loginPage.enterToPasswordTextbox("123222");
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getIncorrectEmailOrPasswordErrorMessage(), "Invalid login or password.");

	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.enterToEmailTextbox("dam@gmail.com");		
		loginPage.enterToPasswordTextbox("123123");
		loginPage.clickToLoginButton();
		
		myDashboardPage = new MyDashboardPageObject(driver);
		
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
		
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "khanhduong" + rand.nextInt(99999) + "@live.com";

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;

}
