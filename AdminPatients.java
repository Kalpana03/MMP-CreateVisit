package com.mmp.createvisit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPatients {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public AdminPatients(WebDriver driver){
		this.driver = driver;
	}

	public void clickOnPatients() {

		wait = new WebDriverWait(driver, 30);
		// After admin login, click on 'Patients' tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Patients ']"))).click();
	}

	public void searchPatient(String patientnamessn) {
		
		wait = new WebDriverWait(driver, 30);

		// Admin-Patients page, enter a valid patient name or SSN
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search"))).sendKeys(patientnamessn);
		// Click on Search button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tfheader']/input[2]"))).click();
		// in the patients table, click on the first patient name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='show']//a"))).click();

	}

}
