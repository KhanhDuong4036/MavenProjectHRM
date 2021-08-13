package pageObjects.user.nopCommerce;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.user.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		scrollToElement(driver, LoginPageUI.LOGIN_BUTTON);
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		if(driver.toString().contains("chrome")) {
			sleepInSecond(3);
		}
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject openHomePage() {
		waitForElementClickable(driver, LoginPageUI.HOMEPAGE_IMG);
		clickToElement(driver, LoginPageUI.HOMEPAGE_IMG);
		return PageGeneratorManager.getHomePage(driver);
	}

}
