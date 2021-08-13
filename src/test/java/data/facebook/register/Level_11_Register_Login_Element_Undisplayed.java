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
public class Level_11_Register_Login_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	public void Register_01_Element_Displayed() {
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
		registerPage.enterToEmailTextbox("khanhduong4036@gmmail.com");
		registerPage.sleepInSecond(2);
		Assert.assertTrue(registerPage.isEmailTextboxDisplayed());
	}

	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.enterToEmailTextbox("");
		registerPage.sleepInSecond(2);
		Assert.assertFalse(registerPage.isEmailTextboxDisplayed());
	}
	
	public void Register_03_Element_Undisplayed_Not_In_DOM() {}
	

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
}
