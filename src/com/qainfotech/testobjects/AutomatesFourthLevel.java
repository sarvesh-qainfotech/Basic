package com.qainfotech.testobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AutomatesFourthLevel {

	WebDriver driver;
	WebElement launchPopupWindow;
	WebElement popupTextBox;
	WebElement submitLink;
	WebElement proceedLink;

	public AutomatesFourthLevel(WebDriver driver) {
		this.driver = driver;

	}

	public void automatingFourthLevel() {
		launchPopupWindow = driver.findElement(By
				.linkText("Launch Popup Window"));

		launchPopupWindow.click();

		// getting the windowHandler of parent window
		String winHandlerParent = driver.getWindowHandle();

		// switching from parent window to child window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		 popupTextBox = driver.findElement(By.id("name"));

		popupTextBox.sendKeys("sarvesh");

		 submitLink = driver.findElement(By.id("submit"));

		submitLink.click();

		// switching controls from child to parent window through windowHandler
		driver.switchTo().window(winHandlerParent);

		proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// check the title of 5th level to ensuring switching on 5th level
		Assert.assertEquals(driver.getTitle(),
				"Cookie Handling - Basic Course - T.A.T.O.C","Check level 5 title");
	}

}
