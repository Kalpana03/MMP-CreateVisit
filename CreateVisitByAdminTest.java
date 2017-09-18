package com.mmp.createvisit;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.mmp.createvisit.Homepage;
import com.mmp.createvisit.AdminPatients;
import com.mmp.createvisit.AdminPatientOptions;

public class CreateVisitByAdminTest {

	private WebDriver driver;
	Homepage hpage;
	AdminPatients patients;
	AdminPatientOptions options;

	@Parameters({ "url" })
	@BeforeTest
	public void beforeMethod(String url) {

		// using chrome driver
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.out.println("maven command line parameter"+ System.getProperty("qaurl"));
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Parameters({ "adminid", "adminpwd" })
	@Test(description = "TC001: Login as admin")
	public void loginAdmin(String id, String pwd) throws InterruptedException {

		// Enter the id, password for the admin
		hpage = new Homepage(driver);
		hpage.adminLogin(id, pwd);
		hpage.signIn();
		Thread.sleep(5000);

	}

	@Parameters({ "searchpatient" })
	@Test(description = "TC002: Click on Patients and search for the patient", dependsOnMethods = {"loginAdmin"})
	public void searchForPatient(String patientSSN) throws InterruptedException {

		// Click on patients tab and enter the patient SSN value to search for
		// the patient
		patients = new AdminPatients(driver);
		patients.clickOnPatients();
		Thread.sleep(3000);
		patients.searchPatient(patientSSN);
		Thread.sleep(3000);

	}

	@Test(description = "TC003: Create the visit", dependsOnMethods = {"searchForPatient"})
	public void createVisitForPatient() throws InterruptedException {
		// Click on the create Visit button and create the visit and logout
		options = new AdminPatientOptions(driver);
		options.createVisit("fever");
		options.logout();
	}

	@AfterTest
	public void afterMethod() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}
