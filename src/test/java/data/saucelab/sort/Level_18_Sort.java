package data.saucelab.sort;

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
import pageObjects.saucelab.InventoryPageObject;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGenerator;


public class Level_18_Sort extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	InventoryPageObject inventoryPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		loginPage = PageGenerator.getLoginPage(driver);
		loginPage.enterToUserNameTextbox("standard_user");
		loginPage.enterToPasswordTextb("secret_sauce");
		inventoryPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortAscending());
		
		inventoryPage.selectItemInSortDropdown("Name (Z to A)");
		verifyTrue(inventoryPage.isProductNameSortDecending());
		
	}
	@Test
	public void Sort_02_Name() {
		inventoryPage.selectItemInSortDropdown("Name (A to Z)");
		verifyTrue(inventoryPage.isProductNameSortDecending());
		
	}

	@Test
	public void Sort_03_Price() {
		
		inventoryPage.selectItemInSortDropdown("Price (low to high)");
		verifyTrue(inventoryPage.isProductPriceSortAscending());
		
		inventoryPage.selectItemInSortDropdown("Price (high to low)");
		verifyTrue(inventoryPage.isProductPriceSortDecending());
		
	}

	@AfterClass
	public void cleanBrowser() {
		log.info("Post-Condition: Close browser");
		driver.quit();
	}

}
