package data.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManager;
import pageObjects.facebook.RegisterPageObject;


@Test
public class Level_12_Register_Login_Assert_Verify extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	public void Register_01_Assert() {
		verifyFalse(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("khanhduong4036@gmmail.com");
		registerPage.sleepInSecond(2);
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());
		
		
	}

	public void Register_02_Verify() {
	
	}


	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
