package com.mmp.admin.patients;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPatientOptions {

	public WebDriver driver;
	public WebDriverWait wait;

	public AdminPatientOptions(WebDriver driver) {
		this.driver = driver;
	}

	public void createVisit(String symptoms) throws InterruptedException {

		wait = new WebDriverWait(driver, 30);
		// Click on create visit button
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='container_body']//input[@value='Create Visit']")))
				.click();

		// Get the window handle for this page
		String parentWindowHandle = driver.getWindowHandle();

		// select the first provider
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@id='opener'])[1]"))).click();

		// Get all the window handles
		Set<String> handles = driver.getWindowHandles();

		// Switch the focus to the pop up window
		for (String handle : handles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				// click on Date input box
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepicker"))).click();

				// Click on a date in the calendar
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//div[@id='ui-datepicker-div']//a)[4]"))).click();
				Thread.sleep(3000);
				// Select time - click on Time
				Select time = new Select(driver.findElement(By.id("time")));
				List<WebElement> times = time.getOptions();
				times.get(1).click();
				Thread.sleep(3000);
				// Click on Continue
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName"))).click();

				// Write the symptoms
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).clear();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("textarea"))).sendKeys(symptoms);
				// click on submit
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Submit']"))).click();
				Thread.sleep(3000);
				// click on logout
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='  Logout ']")))
						.click();

			}
		}

	}

}
