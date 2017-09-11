package com.mmp.admin.patients;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import com.mmp.admin.patients.Homepage;
import com.mmp.admin.patients.AdminPatients;
import com.mmp.admin.patients.AdminPatientOptions;

public class CreateVisitByAdmin {

	private WebDriver driver;
	Homepage hpage;
	AdminPatients patients;
	AdminPatientOptions options;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\CoreFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void createVisitForPatient() throws InterruptedException {

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		hpage = new Homepage(driver);

		hpage.adminLogin("padmajap", "Mmpadmin2017");
		hpage.signIn();
		Thread.sleep(5000);

		patients = new AdminPatients(driver);
		patients.clickOnPatients();
		Thread.sleep(3000);
		patients.searchPatient("576341234");
		Thread.sleep(3000);

		options = new AdminPatientOptions(driver);
		options.createVisit("fever");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		Thread.sleep(5000);
		driver.quit();
	}

}
