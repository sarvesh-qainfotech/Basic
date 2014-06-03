package com.qainfotech.testobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AutomatesFifthLevel {

	WebDriver driver;

	public AutomatesFifthLevel(WebDriver driver) {
		this.driver = driver;

	}

	public void automatingFifthLevel() {
		WebElement generateTokenLink = driver.findElement(By
				.linkText("Generate Token"));

		generateTokenLink.click();

		WebElement tokenValueBox = driver.findElement(By.id("token"));

		// getting the actual cookie string by removing unwanted text
		String tokenValue = tokenValueBox.getText().substring(7);

		Cookie cookie = new Cookie("Token", tokenValue, "/tatoc/basic");

		driver.manage().addCookie(cookie);

		WebElement proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// checking the course completion page
		Assert.assertEquals(driver.getTitle(), "End - T.A.T.O.C",
				"Check course completion page");

	}

}
