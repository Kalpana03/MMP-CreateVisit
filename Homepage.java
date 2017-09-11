package com.mmp.admin.patients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	public WebDriver driver;
	public WebDriverWait wait;

	public Homepage(WebDriver driver) {

		this.driver = driver;
	}

	public void adminLogin(String name, String pwd) throws InterruptedException {

		wait = new WebDriverWait(driver, 30);
		// Click on Login button for Admin
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='welcome']//a[text()='Login']")))
				.click();
		// Enter valid Admin username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(name);
		// Enter valid Admin Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(pwd);

		Thread.sleep(3000);
	}

	public void signIn() {

		// Click on Submit button
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//form[@id='login1']//input[@value='Sign In']"))).click();

	}

}
