package data.jquery.datatable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	public void Table_01_Paging() {
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedByNumber("15"));

		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActivedByNumber("5"));

		homePage.openPageByNumber("20");
		Assert.assertTrue(homePage.isPageActivedByNumber("20"));
	}

	
	public void Table_02_Input_Header_Textbox() {
		// Input Textbox
		homePage.inputToHeaderTextboxByName("Females", "434000");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Males", "451000");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Syrian Arab Rep ");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	public void Table_03_ClickToIcon(){
		// Click to Icon
		homePage.clickToIconByCountryName("Argentina", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByCountryName("Algeria", "remove");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByCountryName("Arab Rep of Egypt", "edit");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToIconByCountryName("Angola", "edit");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}

	public void Table_04_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

	}
	@Test
	public void Table_05_Input_To_Row_Textbox() {
		homePage.inputToTextBoxByRowNumber("Contact Person", "2", "John Kenedy");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextBoxByRowNumber("Order Placed", "1", "5");
		homePage.sleepInSecond(3);
		
		homePage.inputToTextBoxByRowNumber("Company", "2", "Apple");
		homePage.sleepInSecond(3);
		
		
		
	}
	

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
