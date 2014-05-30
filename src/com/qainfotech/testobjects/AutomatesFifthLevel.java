package com.qainfotech.testobjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AutomatesFifthLevel {
	
	public void automatingFifthLevel(WebDriver driver){
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
		Assert.assertEquals("Check course completion page", "End - T.A.T.O.C",
				driver.getTitle());

	}
	
	
	

}
