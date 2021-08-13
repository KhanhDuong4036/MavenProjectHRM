package data.hrm.employee;

import data.hrm.datatest.EmployeeData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

public class Level_20_Data_Test_IV_Data_Driven extends BaseTest {
	String adminUserName, adminPassword, empFirstName, empLastName, empUserName, empPassword, employeeID, statusValue, empFullName;
	String avatarFilePath = GlobalConstants.UPLOAD_FOLDER_PATH + "Avatar.png";
	String nationality, maritalStatus;
	String street01, street02, city, country, phone;
	String emergencyName, emergencyRelationship, emergencyHomePhone;
	String editEmpFirstName, editEmpLastName, editEmpGender;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open Browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		
		employeeData = EmployeeData.getEmployee();
		adminUserName = "Admin";
		adminPassword = "admin123";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSysTem(driver, adminUserName, adminPassword);
		
	}

	@Test
	public void Employee_01_Add_New_Employee() {

		log.info("Add_New_01 - Step 01: Open Employee List page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
				
		log.info("Add_New_01 - Step 02: Click 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);
				
		log.info("Add_New_01 - Step 03: Enter valid information to 'First Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "firstName", employeeData.getFirstname());

		log.info("Add_New_01 - Step 04: Enter valid information to 'Last Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "lastName", employeeData.getLastname());
		
		log.info("Add_New_01 - Step 05: Get value of Employee ID");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");

		log.info("Add_New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");

		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_name", employeeData.getUsername());

		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "user_password", employeeData.getPassword());

		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm password' textbox");
		addEmployeePage.enterToTextboxByID(driver, "re_password", employeeData.getPassword());

		log.info("Add_New_01 - Step 10: Select '" + statusValue + "'value in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);

		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		myInfoPage.sleepInSecond(3);
				
		log.info("Add_New_01 - Step 12: Open Employee List page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
		employeeListPage.sleepInSecond(3);
		
		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));
		employeeListPage.enterToTextboxByID(driver, "empsearch_employee_name_empName", employeeData.getFullname());
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		verifyTrue(employeeListPage.isJQueryAjaxLoadedSuccess(driver));

		log.info("Add_New_01 - Step 15: Verify Employee Information displayed at 'Result Table'");		
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), employeeData.getFirstname());
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), employeeData.getLastname());

	}

	@Test
	public void Employee_02_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login with Employee Role");		
		loginPage = employeeListPage.logoutToSysTem(driver);
		dashboardPage = loginPage.loginToSysTem(driver, employeeData.getUsername(), employeeData.getPassword());
		
		log.info("Upload_Avatar_02 - Step 02: Open Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		
		log.info("Upload_Avatar_02 - Step 03: Click to Change Photo Image");
		myInfoPage.clickToChangePhotoImage();
		
		log.info("Upload_Avatar_02 - Step 04: Upload new Avatar Image");
		myInfoPage.uploadImage(driver, avatarFilePath);
		
		log.info("Upload_Avatar_02 - Step 05: Click to Upload button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		myInfoPage.isJQueryAjaxLoadedSuccess(driver);
		
		log.info("Upload_Avatar_02 - Step 06: Verify success message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Uploaded"));
		
		log.info("Upload_Avatar_02 - Step 07: Verify new Avatar image is displayed");
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
			
	}

	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details_03 - Step 01: Open Personal Detail Page");
		myInfoPage.openTabAtSideBarByName("Personal Details");
		
		log.info("Personal_Details_03 - Step 02: Veiry all fields at 'Personal Detail' are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));
		
		log.info("Personal_Details_03 - Step 03: Click to Edit button at 'Personal Detai' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details_03 - Step 04: Verify 'Employee Id' textbox are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtEmployeeId"));
		
		log.info("Personal_Details_03 - Step 05: Verify 'Driver's License Number' textbox are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtLicenNo"));
		
		log.info("Personal_Details_03 - Step 06: Verify 'SSN Number' textbox are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtNICNo"));
		
		log.info("Personal_Details_03 - Step 07: Verify 'SIN Number' textbox are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_txtSINNo"));
		
		log.info("Personal_Details_03 - Step 08: Verify 'Date of Birth' textbox are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "personal_DOB"));
		
		log.info("Personal_Details_03 - Step 09: Enter new 'First Name'");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);
		
		log.info("Personal_Details_03 - Step 10: Enter new 'Last Name'");
		myInfoPage.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);
		
		log.info("Personal_Details_03 - Step 11: Select new 'Gender'");
		myInfoPage.clickToRadioButtonByLabel(driver, editEmpGender);
		
		log.info("Personal_Details_03 - Step 12: Select new 'Marital Status'");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", maritalStatus);
	
		log.info("Personal_Details_03 - Step 13: Select new 'Nationality'");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbNation", nationality);
		
		log.info("Personal_Details_03 - Step 14: Click to 'Save' button at 'Personal Detail' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details_03 - Step 15: Verify Success Message is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));

		log.info("Personal_Details_03 - Step 16: Verify 'First Name' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);
		
		log.info("Personal_Details_03 - Step 17: Verify 'Last Name' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName);
		
		log.info("Personal_Details_03 - Step 18: Verify 'Gender' is updated");
		verifyTrue(myInfoPage.isRadioSelected(driver, editEmpGender));
		
		log.info("Personal_Details_03 - Step 19: Verify 'Marital Status' is updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbMarital"), maritalStatus);
		
		log.info("Personal_Details_03 - Step 20: Verify 'Nationality' is updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbNation"), nationality);	
		
		log.info("Personal_Details_03 - Step 21: Verify 'Employee Id' is correct");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmployeeId"), employeeID);
	}

	@Test
	public void Employee_04_Contact_Details() {
		log.info("Contact_Detaisl_04 - Step 01: Open 'Contact Details' tab at Side bar");
		myInfoPage.openTabAtSideBarByName("Contact Details");
		
		log.info("Contact_Detaisl_04 - Step 02: Verify all fields at 'Contact Details' are disabled");
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street1"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_street2"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_city"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_country"));
		verifyFalse(myInfoPage.isFieldEnabledByName(driver, "contact_emp_mobile"));
		
		
		log.info("Contact_Detaisl_04 - Step 03: Click to 'Edit' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Contact_Detaisl_04 - Step 04: Enter 'Address Street 1' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street1", street01);
		
		log.info("Contact_Detaisl_04 - Step 05: Enter 'Address Street 2' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_street2", street02);
		
		log.info("Contact_Detaisl_04 - Step 06: Enter 'City' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_city", city);
		
		log.info("Contact_Detaisl_04 - Step 07: Select 'Country' in dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "contact_country", country);
		
		log.info("Contact_Detaisl_04 - Step 08: Enter 'Phone' textbox");
		myInfoPage.enterToTextboxByID(driver, "contact_emp_mobile", phone);
		
		log.info("Contact_Detaisl_04 - Step 09: Click 'Save' button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Contact_Detaisl_04 - Step 09: Verify 'Success Message' is displayed");
		verifyTrue(myInfoPage.isSuccessMessageDisplayed(driver, "Successfully Saved"));
		
		log.info("Contact_Detaisl_04 - Step 10: Verify 'Address Street 1' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_street1"), street01);
		
		log.info("Contact_Detaisl_04 - Step 11: Verify 'Address Street 2' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_street2"), street02);
		
		log.info("Contact_Detaisl_04 - Step 12: Verify 'City' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_city"), city);
		
		log.info("Contact_Detaisl_04 - Step 13: Verify 'Country' is updated");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "contact_country"), country);
		
		log.info("Contact_Detaisl_04 - Step 14: Verify 'Phone' is updated");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "contact_emp_mobile"), phone);
			
	}

	@Test
	public void Employee_05_Emergency_Contact() {
		
	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Assigned_Dependents() {

	}

	@Test
	public void Employee_08_View_Salary() {

	}

	@Test
	public void Employee_09_View_Tax() {

	}

	@Test
	public void Employee_09_Assigned_Dependents() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employees() {

	}

	@Parameters({ "browser" })
	@AfterClass
	public void cleanBrowser() {
		log.info("Post-Condition: Close browser");
		driver.quit();
	}
	
	WebDriver driver;
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	EmployeeListPO employeeListPage;
	MyInfoPO myInfoPage;
	DashboardPO dashboardPage;
	EmployeeData employeeData;

}
